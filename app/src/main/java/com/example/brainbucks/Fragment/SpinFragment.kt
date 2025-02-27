package com.example.brainbucks.Fragment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.brainbucks.ModalClass.User
import com.example.brainbucks.databinding.FragmentSpinBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
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