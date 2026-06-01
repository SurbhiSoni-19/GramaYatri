package com.example.gramayatri.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gramayatri.R
import com.example.gramayatri.models.Stop

class StopAdapter(
    private val stopList: ArrayList<Stop>
) : RecyclerView.Adapter<StopAdapter.StopViewHolder>() {

    class StopViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val txtStopName: TextView =
            itemView.findViewById(R.id.txtStopName)

        val txtStatus: TextView =
            itemView.findViewById(R.id.txtStatus)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StopViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_stop, parent, false)

        return StopViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StopViewHolder,
        position: Int
    ) {

        val stop = stopList[position]

        holder.txtStopName.text = stop.stop
        holder.txtStatus.text = stop.status
    }

    override fun getItemCount(): Int {
        return stopList.size
    }
}