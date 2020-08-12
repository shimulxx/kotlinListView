package com.fnf.kotlinlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(context: Context, data:ArrayList<CustomClass>) : ArrayAdapter<CustomClass>(context, 0, data){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false)
        val item = getItem(position)
        val title = itemView!!.findViewById<TextView>(R.id.textTitle)
        title.text = item!!.title;
        val desc = itemView!!.findViewById<TextView>(R.id.textViewDesc)
        desc.text = item!!.desc
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        image.setImageResource(item.image)


        return itemView

    }
}