package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.listview.databinding.ItemPahlawanBinding

class AdapterPahlawan internal constructor(private val context: Context) : BaseAdapter() {


    internal var pahlawan = arrayListOf<Pahlawan>()
    override fun getCount(): Int {
        return pahlawan.size
    }

    override fun getItem(position: Int): Any {
        return pahlawan[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_pahlawan, parent, false)
        }

        val vHolder = ViewHolder(itemView as View)

        val pahlawan = getItem(position) as Pahlawan
        vHolder.bind(pahlawan)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val binding = ItemPahlawanBinding.bind(view)

        internal fun bind(pahlawan: Pahlawan) {
            binding.tvNama.text = pahlawan.nama
            binding.tvDeskripsi.text = pahlawan.deskripsi
            binding.ivPahlawan.setImageResource(pahlawan.foto)
        }
    }
}