package it.niko.oopdemo

interface SpeedController {
    fun accelerate()
    fun decelerate()
    fun getBrandId(): String {
        return "AD672513"
    }
}