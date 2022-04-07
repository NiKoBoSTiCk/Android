package it.niko.oopdemo

import android.util.Log

class MyCar: Car(), SpeedController {
    override fun start() {
        super.start()
        Log.i("MyTag", "this is myCar Starting... Brand is ${getBrandId()}")
    }

    override fun accelerate() {
        TODO("Not yet implemented")
    }

    override fun decelerate() {
        TODO("Not yet implemented")
    }
}