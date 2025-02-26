package com.example.brainbucks.Adaptor

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.brainbucks.ModalClass.CategoryModalClass
import com.example.brainbucks.QuizActivity
import com.example.brainbucks.databinding.CategroyItemBinding

class CategoryAdaptor(
    var categoryList: ArrayList<CategoryModalClass>,
    private val requireActivity: FragmentActivity
): RecyclerView.Adapter<CategoryAdaptor.MyCategoryViewHolder>() {
    class MyCategoryViewHolder(var binding:CategroyItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoryViewHolder {
        return MyCategoryViewHolder(
            CategroyItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyCategoryViewHolder, position: Int) {
        holder.binding.categoryImage.setImageResource(categoryList.get(position).catImage)
        holder.binding.categoryName.text = categoryList.get(position).catText
        holder.binding.categorybtn.setOnClickListener{
          val intent = Intent(requireActivity,QuizActivity::class.java)
            intent.putExtra("category_image",categoryList[position].catImage)
            requireActivity.startActivity(intent)
        }
    }

}

