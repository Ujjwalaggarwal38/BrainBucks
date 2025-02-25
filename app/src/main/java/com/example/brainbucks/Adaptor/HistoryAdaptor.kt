package com.example.brainbucks.Adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brainbucks.ModalClass.HistoryModalClass
import com.example.brainbucks.databinding.HistoryitemBinding

class HistoryAdaptor(var ListHistory:ArrayList<HistoryModalClass>): RecyclerView.Adapter<HistoryAdaptor.HistoryViewHolder>() {
    class HistoryViewHolder(var binding: HistoryitemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
      return  HistoryViewHolder(HistoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return  ListHistory.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.binding.Time.text = ListHistory[position].timeandDate
        holder.binding.coin90.text = ListHistory[position].coin
    }
}