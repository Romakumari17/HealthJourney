package com.romakumari.healthjourney

import android.Manifest

import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.romakumari.healthjourney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Manifest.permission()
        navController = findNavController(R.id.nav_Host)
        binding.bottomNav.itemIconTintList= ColorStateList.valueOf(Color.parseColor("#FEC5E5"))
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemHome -> {
                    navController.navigate(R.id.fragment_Home)
                }

                R.id.itemExplore -> {
                    navController.navigate(R.id.fragment_explore)

                }

                R.id.itemDownload -> {
                    navController.navigate(R.id.fragment_downloads2)

                }

            }
            return@setOnItemSelectedListener true
        }
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            when (destination.id) {
                R.id.fragment_Home ->
                    binding.bottomNav.menu[0].isChecked= true


                R.id.fragment_explore ->
                    binding.bottomNav.menu[1].isChecked = true


                R.id.fragment_downloads2 ->
                    binding.bottomNav.menu[2].isChecked = true

            }


        }
    }

    private companion object {
        const val REQUEST_CODE_PERMISSION = 100 // Use any value you prefer
    }

    private fun permission() {
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CODE_PERMISSION
            )
        }
    }

}





