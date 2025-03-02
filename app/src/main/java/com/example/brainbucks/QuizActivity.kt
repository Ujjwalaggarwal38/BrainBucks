package com.example.brainbucks

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.brainbucks.Fragment.WithdrawlFragment
import com.example.brainbucks.ModalClass.Question
import com.example.brainbucks.databinding.ActivityQuizBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class QuizActivity : AppCompatActivity() {
    private val binding: ActivityQuizBinding by lazy {
        ActivityQuizBinding.inflate(layoutInflater)
    }
    var currentquestion=0
    var score=0
    private lateinit var questionList:ArrayList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        questionList = ArrayList<Question>()
        var image = intent.getIntExtra("category_image",0)
        var catText = intent.getStringExtra("questionType")
        Firebase.firestore.collection("Quesion")
            .document(catText.toString())
            .collection("question1").get().addOnSuccessListener {
                questionData->
                questionList.clear()
                for(data in questionData.documents){
                    var question:Question ?=data.toObject(Question::class.java)
                    questionList.add(question!!)
                }
                if(questionList.size>0){
                    binding.question.text = questionList.get(currentquestion).question
                    binding.option1.text = questionList.get(currentquestion).option1
                    binding.option2.text = questionList.get(currentquestion).option2
                    binding.option3.text = questionList.get(currentquestion).option3
                    binding.option4.text = questionList.get(currentquestion).option4
                }

            }
        binding.categoryimg.setImageResource(image)
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
        binding.option1.setOnClickListener {
            nextQuestionandScoreUpdate(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            nextQuestionandScoreUpdate(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            nextQuestionandScoreUpdate(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            nextQuestionandScoreUpdate(binding.option4.text.toString())


        }





    }

    private fun nextQuestionandScoreUpdate(s:String) {
        if(s.equals(questionList.get(currentquestion).answer)){
            score+=10
        }
        currentquestion+=1
        if(currentquestion>=questionList.size){
           if(score>=(score/(questionList.size*10))*100){
               binding.winner.visibility= View.VISIBLE
            Firebase.database.reference.child("Play Chance")
                .child(Firebase.auth.currentUser!!.uid).setValue(1)
           }
            else{
               binding.sorry.visibility= View.VISIBLE
           }
        }
        else{
            binding.question.text = questionList.get(currentquestion).question
            binding.option1.text = questionList.get(currentquestion).option1
            binding.option2.text = questionList.get(currentquestion).option2
            binding.option3.text = questionList.get(currentquestion).option3
            binding.option4.text = questionList.get(currentquestion).option4
        }

    }
}