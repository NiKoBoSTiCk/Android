package it.niko.oopdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val driver = Driver("Tom", 37)
        driver.showDetails()

        val myCar = MyCar()
        myCar.maxSpeed = 890
        myCar.start()
    }
}