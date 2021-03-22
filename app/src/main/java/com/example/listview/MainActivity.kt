package com.example.listview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val dataName = arrayOf(
        "Cut Nyak Dien",
        "Ki Hajar Dewantara",
        "Moh Yamin",
        "Pattimura",
        "R A Kartini",
        "Sukarno"
    )
    private lateinit var adapter: AdapterPahlawan
    private lateinit var dataNama: Array<String>
    private lateinit var dataDeskripsi: Array<String>
    private lateinit var dataFoto: TypedArray
    private var PAHLAWAN = arrayListOf<Pahlawan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
        adapter = AdapterPahlawan(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{ _, _, i, _ ->
            Toast.makeText(this, PAHLAWAN[i].nama, Toast.LENGTH_SHORT).show()
        }
    }

    private fun addItem() {
        for (i in dataNama.indices) {
            val pahlawan = Pahlawan(
                dataFoto.getResourceId(i, -1),
                dataNama[i],
                dataDeskripsi[i]
            )
            PAHLAWAN.add(pahlawan)
        }
        adapter.pahlawan = PAHLAWAN
        Log.d("log", PAHLAWAN.toString())
    }

    private fun prepare() {
        dataNama = resources.getStringArray(R.array.data_name)
        dataDeskripsi = resources.getStringArray(R.array.data_description)
        dataFoto = resources.obtainTypedArray(R.array.data_photo)
    }
}