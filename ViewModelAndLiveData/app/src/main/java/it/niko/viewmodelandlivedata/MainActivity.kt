package it.niko.viewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        val textCount = findViewById<TextView>(R.id.tvCount)
        val countButtonP1 = findViewById<Button>(R.id.btnCount)

       // textCount.text = viewModel.count.toString()
        viewModel.count.observe(this) {
            textCount.text = it.toString()
        }

        countButtonP1.setOnClickListener {
            viewModel.updateCount()
           // textCount.text = viewModel.count.toString()
        }

    }
}