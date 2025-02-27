package com.example.brainbucks.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brainbucks.Adaptor.HistoryAdaptor
import com.example.brainbucks.ModalClass.HistoryModalClass
import com.example.brainbucks.ModalClass.User
import com.example.brainbucks.databinding.FragmentHistoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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

    companion object {

    }
}