package com.example.brainbucks.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brainbucks.Adaptor.HistoryAdaptor
import com.example.brainbucks.ModalClass.HistoryModalClass
import com.example.brainbucks.databinding.FragmentHistoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HistoryFragment : Fragment() {
    private val binding: FragmentHistoryBinding by lazy {
        FragmentHistoryBinding.inflate(layoutInflater)
    }
    private var ListHistory = ArrayList<HistoryModalClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ListHistory.add(HistoryModalClass("12:30","300"))
        ListHistory.add(HistoryModalClass("16:30","200"))
        ListHistory.add(HistoryModalClass("13:30","100"))
        ListHistory.add(HistoryModalClass("2:30","500"))
        ListHistory.add(HistoryModalClass("8:30","200"))
        ListHistory.add(HistoryModalClass("00:30","500"))
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
        binding.historyrv.layoutManager = LinearLayoutManager(requireContext())
        val adaptor=HistoryAdaptor(ListHistory)
        binding.historyrv.adapter=adaptor
        binding.historyrv.setHasFixedSize(true)
        return binding.root

    }

    companion object {

    }
}