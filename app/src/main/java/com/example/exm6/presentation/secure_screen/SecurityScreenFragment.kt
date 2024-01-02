package com.example.exm6.presentation.secure_screen

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.authentication_server_hw17.presentation.base.BaseFragment
import com.example.exm6.R
import com.example.exm6.data.NumFieldValue.Companion.NUM_FIELD_SIZE
import com.example.exm6.data.NumPadValue.Companion.numPadValueList
import com.example.exm6.data.ValueType
import com.example.exm6.databinding.FragmentSecurityScreenBinding
import kotlinx.coroutines.launch


class SecurityScreenFragment :
    BaseFragment<FragmentSecurityScreenBinding>(FragmentSecurityScreenBinding::inflate) {

    private var typedDigits: String = ""

    private lateinit var adapter: NumFieldItemAdapter

    private val securityScreenViewModel: SecurityScreenViewModel by viewModels()

    companion object {
        const val pinCode = "0934"
    }

    override fun setRecycler() {

        adapter = NumFieldItemAdapter()
        binding.rvNumField.adapter = adapter

        binding.rvNumPad.adapter = NumPadItemAdapter().apply {
            itemOnClick = ::activateButtons
            setData(numPadValueList)
        }


    }

    private fun activateButtons(currPosition: Int) {

        val numPadVal = numPadValueList[currPosition]

        if (numPadVal.valueType == ValueType.NUMBER && typedDigits.length < NUM_FIELD_SIZE) {
            val num = numPadVal.value
            securityScreenViewModel.addDigit(typedDigits.length)

            typedDigits += num.toString()
        } else if (numPadVal.value == R.drawable.ic_backspace) {
            typedDigits = typedDigits.dropLast(1)

            securityScreenViewModel.removeDigit(typedDigits.length)
        }

        if (typedDigits.length == 4) {
            outputResult(typedDigits == pinCode)

            while (typedDigits.isNotEmpty()) {
                securityScreenViewModel.removeDigit(typedDigits.length - 1)
                typedDigits = typedDigits.dropLast(1)
            }
        }
    }

    private fun outputResult(isSuccess: Boolean) {
        val result = if (isSuccess) {
            "Success"
        } else {
            "Failed"
        }

        Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
    }

    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                securityScreenViewModel.typedPinCode.collect {
                    with(adapter) {
                        submitList(it)
                        notifyDataSetChanged()
                    }
                }
            }
        }
    }
}