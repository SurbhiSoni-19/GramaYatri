package com.example.gramayatri.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gramayatri.R
import com.example.gramayatri.adapters.StopAdapter
import com.example.gramayatri.models.Stop

class RouteFragment : Fragment() {

    private lateinit var recyclerStops: RecyclerView
    private lateinit var stopList: ArrayList<Stop>
    private lateinit var adapter: StopAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_route,
            container,
            false
        )

        recyclerStops = view.findViewById(R.id.recyclerStops)

        recyclerStops.layoutManager =
            LinearLayoutManager(requireContext())

        stopList = ArrayList()

        // PASSED STOPS

        stopList.add(
            Stop(
                stop = "Kothapalli",
                status = "✓ Passed"
            )
        )

        stopList.add(
            Stop(
                stop = "Nadivada",
                status = "✓ Passed"
            )
        )

        stopList.add(
            Stop(
                stop = "Penuganchiprolu",
                status = "✓ Passed"
            )
        )

        stopList.add(
            Stop(
                stop = "Tiruvuru",
                status = "✓ Passed"
            )
        )

        stopList.add(
            Stop(
                stop = "Jaggayyapeta",
                status = "✓ Passed"
            )
        )

        stopList.add(
            Stop(
                stop = "Nandigama",
                status = "✓ Passed"
            )
        )

        // CURRENT LOCATION

        stopList.add(
            Stop(
                stop = "Ibrahimpatnam",
                status = "Bus is here now"
            )
        )

        // UPCOMING STOPS

        stopList.add(
            Stop(
                stop = "Benz Circle",
                status = "Coming Soon"
            )
        )

        stopList.add(
            Stop(
                stop = "Ramavarappadu",
                status = "Coming Soon"
            )
        )

        stopList.add(
            Stop(
                stop = "Vijayawada Bus Stand",
                status = "Coming Soon"
            )
        )

        stopList.add(
            Stop(
                stop = "Railway Station",
                status = "Coming Soon"
            )
        )

        stopList.add(
            Stop(
                stop = "Vijayawada",
                status = "Final Stop"
            )
        )

        adapter = StopAdapter(stopList)

        recyclerStops.adapter = adapter

        return view
    }
}