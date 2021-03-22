package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

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
        private val txtNama: TextView = view.findViewById(R.id.tv_nama)
        private val txtDeskripsi: TextView = view.findViewById(R.id.tv_deskripsi)
        private val imgFoto: CircleImageView = view.findViewById(R.id.iv_pahlawan)

        internal fun bind(pahlawan: Pahlawan) {
            txtNama.text = pahlawan.nama
            txtDeskripsi.text = pahlawan.deskripsi
            imgFoto.setImageResource(pahlawan.foto)
        }
    }
}