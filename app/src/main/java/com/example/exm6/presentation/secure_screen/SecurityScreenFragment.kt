package com.example.exm6.presentation.secure_screen

import com.example.authentication_server_hw17.presentation.base.BaseFragment
import com.example.exm6.data.NumPadValue
import com.example.exm6.databinding.FragmentSecurityScreenBinding


class SecurityScreenFragment :
    BaseFragment<FragmentSecurityScreenBinding>(FragmentSecurityScreenBinding::inflate) {

    override fun setRecycler() {
        binding.rvNumPad.adapter = NumPadItemAdapter().apply {
            itemOnClick = ::activateButtons
            setData(NumPadValue.numPadValueList)
        }
    }

    private fun activateButtons(currPosition: Int) {
//        if (prevPosition != currPosition) {
//            Datasource.apply {
//                colors[prevPosition].check = 0
//                colors[currPosition].check = ic_check
//            }
//
//            with(adapter) {
//                notifyItemChanged(prevPosition)
//                notifyItemChanged(currPosition)
//            }
//
//            prevPosition = currPosition
//        }

        val num = NumPadValue.numPadValueList[currPosition].value


    }
}