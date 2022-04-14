package com.colin.skud

import android.app.Service
import android.content.Intent
import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log
import android.widget.Toast


class NfcCardEmulation : HostApduService() {
    override fun onCreate() {
        super.onCreate()
        Log.d("SERVICE", "ServiceStarted")
    }
    companion object {
        //val TAG = "Host Card Emulator"
        val STATUS_SUCCESS = "9000"
        val STATUS_FAILED = "6F00"
        //val CLA_NOT_SUPPORTED = "6E00"
        //val INS_NOT_SUPPORTED = "6D00"
        val AID = "2066726F6D2041"
        //val SELECT_INS = "A4"
        //val DEFAULT_CLA = "00"
        //val MIN_APDU_LENGTH = 1
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_STICKY
    }

    override fun processCommandApdu(commandApdu: ByteArray, extras: Bundle?): ByteArray {
        val hexCommandApdu = Utils.toHex(commandApdu)
        val test = hexCommandApdu.substring(10, 24);
        Log.d("NFC", "FOUND: $test")


        if (hexCommandApdu.substring(10, 24) == AID)  {
            return Utils.hexStringToByteArray(STATUS_SUCCESS)
        } else {
            return Utils.hexStringToByteArray(STATUS_FAILED)
        }

    }

    override fun onDeactivated(reason: Int) {
        Log.d("NFC", "Deactivated: " + reason)
    }
}