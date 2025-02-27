package com.example.brainbucks.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.brainbucks.ModalClass.User
import com.example.brainbucks.R
import com.example.brainbucks.databinding.FragmentProfileBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


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
        binding.imageButton.setOnClickListener {
            if (isExpand) {
                binding.expandableconstraintlayout.visibility = View.VISIBLE
                binding.imageButton.setImageResource(R.drawable.uparrow)
            } else {
                binding.expandableconstraintlayout.visibility = View.GONE
                binding.imageButton.setImageResource(R.drawable.downarrow)

            }
            isExpand != isExpand
        }

        Firebase.database.reference.child("Userss").child(Firebase.auth.currentUser!!.uid)
            .addValueEventListener(
                object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for(datasnap in snapshot.children){
                            var user = snapshot.getValue<User>()
                            binding.username.text = user?.name
                            binding.nameup.text = user?.name
                            binding.userpass.text = user?.password
                            binding.useremail.text = user?.email
                            binding.userage.text = user?.age.toString()
                        }


                    }

                    override fun onCancelled(error: DatabaseError) {
//                        TODO("Not yet implemented")
                    }

                }
            )
        return binding.root
    }

    companion object {

    }
}