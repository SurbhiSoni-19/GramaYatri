package com.example.gramayatri

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gramayatri.fragments.AlertsFragment
import com.example.gramayatri.fragments.PingFragment
import com.example.gramayatri.fragments.RouteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var txtLiveTime: TextView

    private val handler = Handler(Looper.getMainLooper())

    private val timeRunnable = object : Runnable {
        override fun run() {

            val currentTime = SimpleDateFormat(
                "hh:mm a",
                Locale.getDefault()
            ).format(Date())

            txtLiveTime.text = currentTime

            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        txtLiveTime = findViewById(R.id.txtLiveTime)

        bottomNavigation =
            findViewById(R.id.bottomNavigation)

        // LIVE CLOCK
        handler.post(timeRunnable)

        // DEFAULT SCREEN
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.frameLayout,
                RouteFragment()
            )
            .commit()

        // BOTTOM NAVIGATION
        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_route -> {

                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            RouteFragment()
                        )
                        .commit()

                    true
                }

                R.id.menu_ping -> {

                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            PingFragment()
                        )
                        .commit()

                    true
                }

                R.id.menu_alerts -> {

                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frameLayout,
                            AlertsFragment()
                        )
                        .commit()

                    true
                }

                else -> false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        handler.removeCallbacks(timeRunnable)
    }
}