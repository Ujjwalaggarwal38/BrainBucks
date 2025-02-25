package com.example.brainbucks.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.brainbucks.R
import com.example.brainbucks.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private val binding:FragmentProfileBinding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }
    val isExpand = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.imageButton.setOnClickListener{
            if(isExpand){
                binding.expandableconstraintlayout.visibility=View.VISIBLE
                binding.imageButton.setImageResource(R.drawable.uparrow)
            }
            else{
                binding.expandableconstraintlayout.visibility=View.GONE
                binding.imageButton.setImageResource(R.drawable.downarrow)

            }
            isExpand!=isExpand
        }

        return binding.root
    }

    companion object {

    }
}