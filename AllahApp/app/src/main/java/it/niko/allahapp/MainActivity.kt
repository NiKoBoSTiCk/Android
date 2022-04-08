package it.niko.allahapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var mediaPLayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    private lateinit var tvPlayed: TextView
    private lateinit var tvDue: TextView
    private var duration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.sbAllah)
        handler = Handler(Looper.getMainLooper())
        val playButton = findViewById<FloatingActionButton>(R.id.fabPlay)
        val pauseButton = findViewById<FloatingActionButton>(R.id.fabPause)
        val stopButton = findViewById<FloatingActionButton>(R.id.fabStop)

        playButton.setOnClickListener {
            if (mediaPLayer == null) {
                mediaPLayer = MediaPlayer.create(this, R.raw.allah)
                initializeSeekBar()
            }
            mediaPLayer?.start()
        }

        pauseButton.setOnClickListener {
            mediaPLayer?.pause()
        }

        stopButton.setOnClickListener {
            tvPlayed.text = 0.toString()
            tvDue.text = duration.toString()
            mediaPLayer?.stop()
            mediaPLayer?.reset()
            mediaPLayer?.release()
            mediaPLayer = null
            handler.removeCallbacks(runnable)
            seekBar.progress = 0
        }
    }

    private fun initializeSeekBar() {
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPLayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        tvPlayed = findViewById(R.id.tvPlayed)
        tvDue = findViewById(R.id.tvDue)

        seekBar.max = mediaPLayer!!.duration
        runnable = Runnable {
            seekBar.progress = mediaPLayer!!.currentPosition

            val playedTime = mediaPLayer!!.currentPosition/1000
            tvPlayed.text = "$playedTime"
            duration = mediaPLayer!!.duration/1000
            val dueTime = duration - playedTime
            tvDue.text = "$dueTime"

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }
}