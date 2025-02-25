package com.example.brainbucks.Fragment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.brainbucks.databinding.FragmentSpinBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.random.Random

class SpinFragment : Fragment() {
    private val binding:FragmentSpinBinding by lazy {
        FragmentSpinBinding.inflate(layoutInflater)
    }
    private lateinit var timer: CountDownTimer
    private val entities = arrayOf("100","Try Again","500","Try Again","200","Try Again")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.coin.setOnClickListener{
            val bottomSheetDialog: BottomSheetDialogFragment = WithdrawlFragment()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        binding.wuthdrawcoin.setOnClickListener{
            val bottomSheetDialog: BottomSheetDialogFragment = WithdrawlFragment()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            binding.button2.isEnabled = false
            val spin = Random(6)
        }
    }

    companion object {

    }
}