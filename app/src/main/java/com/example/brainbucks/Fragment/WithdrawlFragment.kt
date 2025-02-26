package com.example.brainbucks.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.brainbucks.R
import com.example.brainbucks.databinding.FragmentWithdrawlBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WithdrawlFragment : BottomSheetDialogFragment() {
    private val binding:FragmentWithdrawlBinding by lazy {
        FragmentWithdrawlBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
    }
}