package com.pseudo.iching

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.Image
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        val taijituImageView = findViewById<ImageView>(R.id.taijitu)
        val mountainsImageView = findViewById<ImageView>(R.id.mountains)
        val forestImageView = findViewById<ImageView>(R.id.forest)
        Glide
            .with(this)
            .load("https://i.imgur.com/KCyZi41.png")
            .into(taijituImageView)
        Glide
            .with(this)
            .load("https://i.imgur.com/S0T79Z2.png")
            .into(mountainsImageView)
        Glide
            .with(this)
            .load("https://i.imgur.com/vQWZQCP.png")
            .into(forestImageView)


        val buttonClickInstruction = findViewById<Button>(R.id.instruction_button)
        val buttonClickMyFortune = findViewById<Button>(R.id.my_fortune_button)
        val buttonClickJournal = findViewById<Button>(R.id.journal_button)
        val buttonClickHexagrams = findViewById<Button>(R.id.hexagrams_button)

        var mLastClickTime :Long = 0

        buttonClickInstruction.setOnClickListener {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()
            val intent = Intent(this, InstructionActivity::class.java)
            startActivity(intent)
        }

        buttonClickMyFortune.setOnClickListener {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()
            val intent = Intent(this, MyFortuneActivity::class.java)
            startActivity(intent)
        }

        buttonClickJournal.setOnClickListener {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()
            val intent = Intent(this, JournalActivity::class.java)
            startActivity(intent)
        }

        buttonClickHexagrams.setOnClickListener {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 2000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()
            val intent = Intent(this, HexagramsActivity::class.java)
            startActivity(intent)
        }

    }


}