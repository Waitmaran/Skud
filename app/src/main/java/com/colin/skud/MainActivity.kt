package com.colin.skud

import android.nfc.NfcAdapter
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.colin.skud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityMainBinding

    private val nfcAdapter: NfcAdapter? by lazy {
        NfcAdapter.getDefaultAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ClassRoomRecyclerAdapter(fillList(), this)
}

    private fun fillList(): List<ClassInfo> {
        val data = mutableListOf<ClassInfo>()
        data.add(0, ClassInfo("420", "лекционная"))
        data.add(0, ClassInfo("428", "лабаратория"))
        data.add(0, ClassInfo("439", "кафедра"))
        return data
    }

    override fun onItemClicked(classInfo: ClassInfo) {
        Toast.makeText(this,"ClassRoomName ${classInfo.classroomName} \n ClassRoomType: ${classInfo.classroomType}",Toast.LENGTH_LONG)
            .show()
    }

}
