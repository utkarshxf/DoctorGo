package com.example.orion.doctorgo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.orion.doctorgo.databinding.RegistrationBinding
import com.example.orion.doctorgo.model.Result
import kotlinx.android.synthetic.main.fragment_home_fregment.view.*
import kotlinx.android.synthetic.main.tickets.view.*

class baseAdapter( var mList: List<Result>): RecyclerView.Adapter<baseAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): baseAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tickets, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem: Result = mList[position]
        holder.nameXp.text = currentItem.name
        holder.emailX.text=currentItem.email
        holder.idX.text=currentItem.doctors_id
        holder.genderX.text=currentItem.gender
        holder.practice_frm_monthX.text=currentItem.practice_frm_month
        holder.practice_frm_yearX.text=currentItem.practice_frm_year

    }

    override fun getItemCount(): Int {
       return mList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameXp:TextView  = itemView.findViewById(R.id.nametvX)
        var idX:TextView = itemView.findViewById(R.id.doctors_idX)
        var emailX:TextView = itemView.findViewById(R.id.emailX)
        var genderX:TextView = itemView.findViewById(R.id.genderX)
        var practice_frm_monthX:TextView = itemView.findViewById(R.id.practice_frm_monthX)
        var practice_frm_yearX:TextView = itemView.findViewById(R.id.practice_frm_yearX)

    }
}