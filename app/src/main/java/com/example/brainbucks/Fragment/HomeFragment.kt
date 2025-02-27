package com.example.brainbucks.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.brainbucks.Adaptor.CategoryAdaptor
import com.example.brainbucks.ModalClass.CategoryModalClass
import com.example.brainbucks.ModalClass.User
import com.example.brainbucks.R
import com.example.brainbucks.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private var categoryList = ArrayList<CategoryModalClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryList.add(CategoryModalClass(R.drawable.category_1,"Science"))
        categoryList.add(CategoryModalClass(R.drawable.cactegory_2,"Math"))
        categoryList.add(CategoryModalClass(R.drawable.category_3,"English"))
        categoryList.add(CategoryModalClass(R.drawable.category_4,"History"))

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
        Firebase.database.reference.child("Userss").child(Firebase.auth.currentUser!!.uid)
            .addValueEventListener(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for(datasnap in snapshot.children){
                            var user = snapshot.getValue<User>()
                            binding.Name.text = user?.name
                        }


                    }

                    override fun onCancelled(error: DatabaseError) {
//                        TODO("Not yet implemented")
                    }

                }
            )
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),2)
        var adaptor = CategoryAdaptor(categoryList, requireActivity())
        binding.recyclerview.adapter = adaptor
        binding.recyclerview.setHasFixedSize(true)
    }

    }