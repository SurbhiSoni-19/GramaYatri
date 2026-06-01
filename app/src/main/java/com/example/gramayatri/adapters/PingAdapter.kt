package com.example.gramayatri.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gramayatri.R
import com.example.gramayatri.models.Ping

class PingAdapter(
    private val pingList: ArrayList<Ping>
) : RecyclerView.Adapter<PingAdapter.PingViewHolder>() {

    class PingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val txtInitial: TextView =
            itemView.findViewById(R.id.txtInitial)

        val txtTitle: TextView =
            itemView.findViewById(R.id.txtTitle)

        val txtSubtitle: TextView =
            itemView.findViewById(R.id.txtSubtitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PingViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_ping,
                parent,
                false
            )

        return PingViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: PingViewHolder,
        position: Int
    ) {

        val ping = pingList[position]

        holder.txtInitial.text = ping.initial
        holder.txtTitle.text = ping.title
        holder.txtSubtitle.text = ping.subtitle
    }

    override fun getItemCount(): Int {
        return pingList.size
    }
}