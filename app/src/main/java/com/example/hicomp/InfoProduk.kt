package com.example.hicomp

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InfoProduk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_produk)
    }
}

class InfoProdukAdapter(val infoProdukList: List<Barang>):
    RecyclerView.Adapter<InfoProdukAdapter.BarangInfo>(){
    class BarangInfo(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var deskripsiTxt : TextView = itemView.findViewById(R.id.teksdeskripsi)
        var linearLayout : TextView = itemView.findViewById(R.id.linearLayout)
        var expandableLayout : TextView = itemView.findViewById(R.id.expandable_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangInfo {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.activity_info_produk, parent,false)

        return BarangInfo(view)
    }

    override fun getItemCount(): Int {
        return infoProdukList.size
    }

    override fun onBindViewHolder(holder: BarangInfo, position: Int) {
        val deskripsii : Barang = infoProdukList[position]
        holder.deskripsiTxt.text = deskripsii.deskripsi

        val isExpandable : Boolean? = infoProdukList[position].expandable
        holder.expandableLayout.visibility = if(isExpandable!!) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            val deskripsii = infoProdukList[position]
            deskripsii.expandable = !deskripsii.expandable!!
            notifyItemChanged(position)
        }
    }

}