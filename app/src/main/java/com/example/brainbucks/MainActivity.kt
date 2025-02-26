package com.example.brainbucks

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.brainbucks.ModalClass.User
import com.example.brainbucks.databinding.ActivityHomeBinding
import com.example.brainbucks.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.usersignup.setOnClickListener {
            if(
                binding.username2.text.toString().equals("")||
                binding.userage2.text.toString().equals("")||
                binding.useremail2.text.toString().equals("")||
                binding.userpass2.text.toString().equals("")
                ){
                Toast.makeText(this,"Please Fill all the details",Toast.LENGTH_LONG).show()
            }
            else{
                Firebase.auth.createUserWithEmailAndPassword(
                    binding.useremail2.text.toString(),
                    binding.userpass2.text.toString()).addOnCompleteListener{
                        if(it.isSuccessful){
                                var user = User(binding.username2.text.toString(),
                                    binding.userage2.text.toString().toInt(),
                                    binding.useremail2.text.toString(),
                                    binding.userpass2.text.toString())
                            Firebase.database.reference.child("Userss")
                                .child(Firebase.auth.currentUser!!.uid).setValue(user)
                                .addOnSuccessListener {
                                    startActivity(Intent(this,HomeActivity::class.java))
                                    finish()
                                }


                        }
                    else{
                            Toast.makeText(this, it.exception?.localizedMessage,Toast.LENGTH_LONG).show()
                        }
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        if(Firebase.auth.currentUser!=null)
        { startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
    }
}