package it.niko.viewbindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import it.niko.viewbindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            btnSubmit.setOnClickListener {
                val name = etName.text.toString()
                tvMessage.text = "Hello $name"
                etName.setText("")
            }
        }
    }
}