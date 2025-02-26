package com.example.brainbucks

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.brainbucks.Fragment.WithdrawlFragment
import com.example.brainbucks.databinding.ActivityQuizBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class QuizActivity : AppCompatActivity() {
    private val binding: ActivityQuizBinding by lazy {
        ActivityQuizBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.coin.setOnClickListener{
            val bottomSheetDialog: BottomSheetDialogFragment = WithdrawlFragment()
            bottomSheetDialog.show(this@QuizActivity.supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        binding.wuthdrawcoin.setOnClickListener{
            val bottomSheetDialog: BottomSheetDialogFragment = WithdrawlFragment()
            bottomSheetDialog.show(this@QuizActivity.supportFragmentManager,"Test")
            bottomSheetDialog.enterTransition
        }
        var image = intent.getIntExtra("category_image",0)
        binding.categoryimg.setImageResource(image)

    }
}