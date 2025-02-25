package com.example.brainbucks.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.brainbucks.Adaptor.CategoryAdaptor
import com.example.brainbucks.ModalClass.CategoryModalClass
import com.example.brainbucks.R
import com.example.brainbucks.databinding.ActivityHomeBinding
import com.example.brainbucks.databinding.CategroyItemBinding
import com.example.brainbucks.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private var categoryList = ArrayList<CategoryModalClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.coin.setOnClickListener{
            val bottomSheetDialog:BottomSheetDialogFragment = WithdrawlFragment()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        binding.wuthdrawcoin.setOnClickListener{
            val bottomSheetDialog:BottomSheetDialogFragment = WithdrawlFragment()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryList.add(CategoryModalClass(R.drawable.category_1,"Science"))
        categoryList.add(CategoryModalClass(R.drawable.cactegory_2,"Math"))
        categoryList.add(CategoryModalClass(R.drawable.category_3,"English"))
        categoryList.add(CategoryModalClass(R.drawable.category_4,"History"))
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),2)
        var adaptor = CategoryAdaptor(categoryList)
        binding.recyclerview.adapter = adaptor
        binding.recyclerview.setHasFixedSize(true)
    }

    }