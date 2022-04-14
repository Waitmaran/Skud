package com.colin.skud

import android.content.Intent
import android.nfc.NfcAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.colin.skud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.buttonSendData.setOnClickListener {
        val intent = Intent(this, NfcCardEmulation::class.java)
        startService(intent)
        Log.d("USER", "BUTTON CLICKED")
    }
}
}
