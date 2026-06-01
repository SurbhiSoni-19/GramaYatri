package com.example.gramayatri.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gramayatri.R
import com.example.gramayatri.adapters.PingAdapter
import com.example.gramayatri.models.Ping

class PingFragment : Fragment() {

    private lateinit var recyclerPings: RecyclerView
    private lateinit var pingList: ArrayList<Ping>
    private lateinit var adapter: PingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_ping,
            container,
            false
        )

        val etName =
            view.findViewById<EditText>(R.id.etName)

        val etLocation =
            view.findViewById<EditText>(R.id.etLocation)

        val btnSend =
            view.findViewById<Button>(R.id.btnSend)

        val btnPassed =
            view.findViewById<Button>(R.id.btnPassed)

        val btnCancelled =
            view.findViewById<Button>(R.id.btnCancelled)

        recyclerPings =
            view.findViewById(R.id.recyclerPings)

        recyclerPings.layoutManager =
            LinearLayoutManager(requireContext())

        pingList = ArrayList()

        // DEFAULT HISTORY

        pingList.add(Ping("SU","Surbhi at Kothapalli","Boarded bus · 02:38 PM"))
        pingList.add(Ping("AN","Anitha at Vijayawada","Boarded bus · 08:41 AM"))
        pingList.add(Ping("ME","Meena at Nandigama","Bus passed · 08:50 AM"))
        pingList.add(Ping("RV","Ravi at Kothapalli","Bus arrived · 09:05 AM"))
        pingList.add(Ping("KR","Kiran at Penuganchiprolu","Boarded bus · 09:15 AM"))
        pingList.add(Ping("LA","Lakshmi at Tiruvuru","Bus delayed · 09:22 AM"))
        pingList.add(Ping("PR","Praveen at Jaggayyapeta","Bus crowded · 09:35 AM"))
        pingList.add(Ping("SN","Sneha at Ibrahimpatnam","Bus arrived · 09:42 AM"))
        pingList.add(Ping("AR","Arjun at Vijayawada","Boarded bus · 09:55 AM"))
        pingList.add(Ping("PO","Pooja at Nadivada","Bus passed · 10:02 AM"))
        pingList.add(Ping("VK","Vikram at Kothapalli","Bus departed · 10:10 AM"))
        pingList.add(Ping("RA","Ramesh at Tiruvuru","Seats available · 10:20 AM"))
        pingList.add(Ping("DE","Deepa at Nandigama","Bus arrived · 10:35 AM"))
        pingList.add(Ping("CH","Chandu at Penuganchiprolu","Boarded bus · 10:48 AM"))
        pingList.add(Ping("MO","Mounika at Vijayawada","Bus delayed · 11:00 AM"))
        pingList.add(Ping("SR","Sridhar at Kothapalli","Bus passed · 11:15 AM"))
        pingList.add(Ping("VA","Varsha at Tiruvuru","Boarded bus · 11:28 AM"))
        pingList.add(Ping("AK","Akash at Jaggayyapeta","Bus crowded · 11:40 AM"))
        pingList.add(Ping("NI","Nikhil at Ibrahimpatnam","Bus arrived · 11:52 AM"))
        pingList.add(Ping("RE","Reshma at Vijayawada","Boarded bus · 12:05 PM"))
        pingList.add(Ping("RO","Rohit at Nadivada","Bus passed · 12:18 PM"))
        pingList.add(Ping("SA","Sai at Penuganchiprolu","Bus departed · 12:30 PM"))
        pingList.add(Ping("HA","Harika at Tiruvuru","Bus crowded · 12:45 PM"))
        pingList.add(Ping("TE","Teja at Kothapalli","Boarded bus · 01:00 PM"))
        pingList.add(Ping("KE","Keerthi at Vijayawada","Bus arrived · 01:12 PM"))
        pingList.add(Ping("LO","Lokesh at Nandigama","Bus delayed · 01:25 PM"))
        pingList.add(Ping("DH","Dhanu at Jaggayyapeta","Boarded bus · 01:40 PM"))
        pingList.add(Ping("MA","Mahesh at Ibrahimpatnam","Bus passed · 01:55 PM"))
        pingList.add(Ping("RI","Rishi at Tiruvuru","Bus departed · 02:08 PM"))
        pingList.add(Ping("KA","Kavya at Vijayawada","Bus arrived · 02:20 PM"))

        adapter = PingAdapter(pingList)

        recyclerPings.adapter = adapter

        adapter.notifyDataSetChanged()

        // ON BUS

        btnSend.setOnClickListener {

            val name = etName.text.toString()
            val location = etLocation.text.toString()

            if (name.isEmpty() || location.isEmpty()) {

                Toast.makeText(
                    requireContext(),
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val initial = name.take(2).uppercase()

                pingList.add(
                    0,
                    Ping(
                        initial,
                        "$name at $location",
                        "Boarded bus · 03:25 PM"
                    )
                )

                adapter.notifyDataSetChanged()

                etName.text.clear()
                etLocation.text.clear()
            }
        }

        // PASSED

        btnPassed.setOnClickListener {

            val name = etName.text.toString()
            val location = etLocation.text.toString()

            if (name.isEmpty() || location.isEmpty()) {

                Toast.makeText(
                    requireContext(),
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val initial = name.take(2).uppercase()

                pingList.add(
                    0,
                    Ping(
                        initial,
                        "$name at $location",
                        "Bus passed · 03:28 PM"
                    )
                )

                adapter.notifyDataSetChanged()

                etName.text.clear()
                etLocation.text.clear()
            }
        }

        // CANCELLED

        btnCancelled.setOnClickListener {

            val name = etName.text.toString()
            val location = etLocation.text.toString()

            if (name.isEmpty() || location.isEmpty()) {

                Toast.makeText(
                    requireContext(),
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val initial = name.take(2).uppercase()

                pingList.add(
                    0,
                    Ping(
                        initial,
                        "$name at $location",
                        "Bus cancelled · 03:30 PM"
                    )
                )

                adapter.notifyDataSetChanged()

                etName.text.clear()
                etLocation.text.clear()
            }
        }

        return view
    }
}