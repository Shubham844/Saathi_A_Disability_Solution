package com.example.myapplication.saathi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList:ArrayList<ItemViewModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.ngo_home_card, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentitem = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.logo.setImageResource(currentitem.ngologo)

        // sets the text to the textview from our itemHolder class
        holder.ngo_name.text = currentitem.ngoname
        holder.caption.text = currentitem.ngocaption
        holder.image.setImageResource(currentitem.image)

    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val logo: ImageView = itemView.findViewById(R.id.ngo_logo)
        val ngo_name: TextView = itemView.findViewById(R.id.textView)
        val image : ImageView = itemView.findViewById(R.id.image)
        val caption :TextView = itemView.findViewById(R.id.textView2)
    }
}