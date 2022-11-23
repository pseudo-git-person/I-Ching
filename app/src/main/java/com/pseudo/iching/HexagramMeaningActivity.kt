package com.pseudo.iching

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.time.LocalDateTime
import android.graphics.Bitmap

import com.bumptech.glide.request.target.SimpleTarget

import com.bumptech.glide.load.engine.DiskCacheStrategy




val HexArray = arrayOf(
    intArrayOf(1, 1, 1, 1, 1, 1),
    intArrayOf(0, 0, 0, 0, 0, 0),
    intArrayOf(1, 0, 0, 0, 1, 0),
    intArrayOf(0, 1, 0, 0, 0, 1),   //4
    intArrayOf(1, 1, 1, 0, 1, 0),
    intArrayOf(0, 1, 0, 1, 1, 1),
    intArrayOf(0, 1, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 1, 0),   //8
    intArrayOf(1, 1, 1, 0, 1, 1),
    intArrayOf(1, 1, 0, 1, 1, 1),
    intArrayOf(1, 1, 1, 0, 0, 0),
    intArrayOf(0, 0, 0, 1, 1, 1),   //12
    intArrayOf(1, 0, 1, 1, 1, 1),
    intArrayOf(1, 1, 1, 1, 0, 1),
    intArrayOf(0, 0, 1, 0, 0, 0),
    intArrayOf(0, 0, 0, 1, 0, 0),   //16
    intArrayOf(1, 0, 0, 1, 1, 0),
    intArrayOf(0, 1, 1, 0, 0, 1),
    intArrayOf(1, 1, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 1, 1),   //20
    intArrayOf(1, 0, 0, 1, 0, 1),
    intArrayOf(1, 0, 1, 0, 0, 1),
    intArrayOf(0, 0, 0, 0, 0, 1),
    intArrayOf(1, 0, 0, 0, 0, 0),   //24
    intArrayOf(1, 0, 0, 1, 1, 1),
    intArrayOf(1, 1, 1, 0, 0, 1),
    intArrayOf(1, 0, 0, 0, 0, 1),
    intArrayOf(0, 1, 1, 1, 1, 0),   //28
    intArrayOf(0, 1, 0, 0, 1, 0),
    intArrayOf(1, 0, 1, 1, 0, 1),
    intArrayOf(0, 0, 1, 1, 1, 0),
    intArrayOf(0, 1, 1, 1, 0, 0),   //32
    intArrayOf(0, 0, 1, 1, 1, 1),
    intArrayOf(1, 1, 1, 1, 0, 0),
    intArrayOf(0, 0, 0, 1, 0, 1),
    intArrayOf(1, 0, 1, 0, 0, 0),   //36
    intArrayOf(1, 0, 1, 0, 1, 1),
    intArrayOf(1, 1, 0, 1, 0, 1),
    intArrayOf(0, 0, 1, 0, 1, 0),
    intArrayOf(0, 1, 0, 1, 0, 0),   //40
    intArrayOf(1, 1, 0, 0, 0, 1),
    intArrayOf(1, 0, 0, 0, 1, 1),
    intArrayOf(1, 1, 1, 1, 1, 0),
    intArrayOf(0, 1, 1, 1, 1, 1),   //44
    intArrayOf(0, 0, 0, 1, 1, 0),
    intArrayOf(0, 1, 1, 0, 0, 0),
    intArrayOf(0, 1, 0, 1, 1, 0),
    intArrayOf(0, 1, 1, 0, 1, 0),   //48
    intArrayOf(1, 0, 1, 1, 1, 0),
    intArrayOf(0, 1, 1, 1, 0, 1),
    intArrayOf(1, 0, 0, 1, 0, 0),
    intArrayOf(0, 0, 1, 0, 0, 1),   //52
    intArrayOf(0, 0, 1, 0, 1, 1),
    intArrayOf(1, 1, 0, 1, 0, 0),
    intArrayOf(1, 0, 1, 1, 0, 0),
    intArrayOf(0, 0, 1, 1, 0, 1),   //56
    intArrayOf(0, 1, 1, 0, 1, 1),
    intArrayOf(1, 1, 0, 1, 1, 0),
    intArrayOf(0, 1, 0, 0, 1, 1),
    intArrayOf(1, 1, 0, 0, 1, 0),   //60
    intArrayOf(1, 1, 0, 0, 1, 1),
    intArrayOf(0, 0, 1, 1, 0, 0),
    intArrayOf(1, 0, 1, 0, 1, 0),
    intArrayOf(0, 1, 0, 1, 0, 1),   //64
)

class HexagramMeaningActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hexagram_meaning)

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        val hexStructure = intent.getIntArrayExtra("EXTRA_HEXSTRUCTURE")

        var HexNumber : Int = 0

        for (i in HexArray.indices){
            if (hexStructure.contentEquals(HexArray[i]))
                HexNumber = i
        }
        val imageName = HexURLArray[HexNumber]
        val hexImage = findViewById<ImageView>(R.id.hexagramImage)
        Glide
            .with(this)
            .load(imageName)
            .into(hexImage)

        val titleName = HexStringArray[(HexNumber)*2]
        val descriptionName = HexStringArray[(HexNumber)*2+1]

        findViewById<TextView>(R.id.hexagramTitle).text = titleName
        findViewById<TextView>(R.id.hexagramDescription).text = descriptionName


        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val number = sharedPreferences.getInt("NUMBER_KEY", 0) + 1
        val editor = sharedPreferences.edit()
        editor.apply {
            putInt("NUMBER_KEY", number)
            putString("TITLE_KEY_$number", LocalDateTime.now().toString().replace('T', ' ').dropLast(7) + "\n"+ titleName.replace("\n"," "))
            putString("DESCRIPTION_KEY_$number", descriptionName)
            putString("IMAGENAME_KEY_$number", imageName)
        }.apply()


        var mLastClickTime :Long = 0

        findViewById<Button>(R.id.share_button).setOnClickListener{
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()

            val intent = Intent(Intent.ACTION_SEND)

            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "My divination for today is: \n $titleName \n $descriptionName \n\n $imageName")
            startActivity(Intent.createChooser(intent, "Select sharing platform:"))
        }


        findViewById<Button>(R.id.another_reading_button).setOnClickListener{
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime();
        Intent(this, MyFortuneActivity::class.java).also{
            startActivity(it)}}

        findViewById<Button>(R.id.home_button).setOnClickListener{
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()
            Intent(this, MainActivity::class.java).also{
                startActivity(it)}}


    }


}