package com.fnf.kotlinlistview

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = ArrayList<CustomClass>()
        items.add(CustomClass("Android Developer from alibaba", "Alibaba", R.drawable.face))
        items.add(CustomClass("I am second developer", "Daraz", R.drawable.image))
        items.add(CustomClass("I am third developer", "Pakhi mara", R.drawable.four))

        val adapter = CustomAdapter(this, items)
        val list = findViewById<ListView>(R.id.listView)
        list.adapter = adapter
        list.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->
            val alert = Dialog(this@MainActivity)
            alert.setContentView(R.layout.custom_alert)

            val title = alert.findViewById<TextView>(R.id.textAlertTitle)
            val desc = alert.findViewById<TextView>(R.id.textAlertDesc)
            val image = alert.findViewById<ImageView>(R.id.imageViewAlert)
            val hide = alert.findViewById<Button>(R.id.buttonHideAlert)

            val item = adapter.getItem(position)

            title.text = item!!.title
            desc.text = item!!.desc
            image.setImageResource(item!!.image)
            alert.show()
            hide.setOnClickListener { alert.dismiss() }


        }

    }
}