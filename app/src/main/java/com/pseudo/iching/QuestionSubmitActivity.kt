package com.pseudo.iching

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.pseudo.iching.ShakeDetector.OnShakeListener
import kotlinx.coroutines.*
import android.media.MediaPlayer
import android.os.SystemClock
import android.view.View.VISIBLE
import android.widget.Button



private var mSensorManager: SensorManager? = null
private var mAccelerometer: Sensor? = null
private var mShakeDetector: ShakeDetector? = null

class QuestionSubmitActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)

    override fun onResume() {
        super.onResume()
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager!!.registerListener(
            mShakeDetector,
            mAccelerometer,
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager!!.unregisterListener(mShakeDetector)
        super.onPause()
    }

    fun playCoinToss(){
        val sound = MediaPlayer.create(this, R.raw.coin_toss)
        sound?.setOnPreparedListener{
            sound.start()
        }
        sound?.setOnCompletionListener {
            sound.stop()
            sound.release()
        }
    }

    fun playClappers(){
        val sound = MediaPlayer.create(this, R.raw.clappers)
        sound?.setOnPreparedListener{
            sound.start()
        }
        sound?.setOnCompletionListener {
            sound.stop()
            sound.release()
        }
    }

    fun playDoubleClappers(){
        val sound = MediaPlayer.create(this, R.raw.double_clappers)
        sound?.setOnPreparedListener{
            sound.start()
        }
        sound?.setOnCompletionListener {
            sound.stop()
            sound.release()
        }
    }

    fun playBell(){
        val sound = MediaPlayer.create(this, R.raw.bell)
        sound?.setOnPreparedListener{
            sound.start()
        }
        sound?.setOnCompletionListener {
            sound.stop()
            sound.release()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_submit)

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        val display = findViewById<TextView>(R.id.question_display)

        val question = intent.getStringExtra("EXTRA_QUESTION")
        val questionFinal: String = if (question == "") {
            "Keep your question in your mind."
        } else if (question?.last() == '?') {
            "Your question:\n $question"
        } else {
            "Your question:\n $question?"
        }
        println(questionFinal)
        display.text = questionFinal

        // 2 -> tails
        // 3 -> heads

        var resultOne = 0
        var resultTwo = 0
        var resultThree = 0

        var displayOne: String
        var displayTwo: String
        var displayThree: String
        var sum = 0

        //animation times
        val spinTime : Long = 1000
        val CoinDisplayTime : Long = 1500
        val lineInsertTime : Long = 2500
        val NextTossTime : Long = 3500
        val unlockShake : Long = 3800

        val coinOne = findViewById<ImageView>(R.id.coinOne)
        val coinTwo = findViewById<ImageView>(R.id.coinTwo)
        val coinThree = findViewById<ImageView>(R.id.coinThree)
        val coinOneDisplay = findViewById<TextView>(R.id.coin_one_display)
        val coinTwoDisplay = findViewById<TextView>(R.id.coin_two_display)
        val coinThreeDisplay = findViewById<TextView>(R.id.coin_three_display)
        val prompt = findViewById<TextView>(R.id.prompt)
        prompt.text = "Toss the coins"

        val line1 = findViewById<ImageView>(R.id.line1)
        var line1set = false
        val line2 = findViewById<ImageView>(R.id.line2)
        var line2set = false
        val line3 = findViewById<ImageView>(R.id.line3)
        var line3set = false
        val line4 = findViewById<ImageView>(R.id.line4)
        var line4set = false
        val line5 = findViewById<ImageView>(R.id.line5)
        var line5set = false
        val line6 = findViewById<ImageView>(R.id.line6)
        var line6set = false

        val hexStructure = intArrayOf(0, 0, 0, 0, 0, 0)

        fun WhichLine(sumFun: Int) {
            Handler().postDelayed({
                if (sumFun % 2 == 0)
                {
                    playClappers()
                    if(!line1set) {
                        line1.setImageResource(R.drawable.solid_line)
                        line1set = true
                        hexStructure[0] = 1}
                        else if(!line2set){
                            line2.setImageResource(R.drawable.solid_line)
                            line2set = true
                            hexStructure[1] = 1}
                            else if(!line3set){
                                line3.setImageResource(R.drawable.solid_line)
                                line3set = true
                                hexStructure[2] = 1}
                                else if(!line4set){
                                    line4.setImageResource(R.drawable.solid_line)
                                    line4set = true
                                    hexStructure[3] = 1}
                                    else if(!line5set){
                                        line5.setImageResource(R.drawable.solid_line)
                                        line5set = true
                                        hexStructure[4] = 1}
                                        else if(!line6set){
                                            line6.setImageResource(R.drawable.solid_line)
                                            line6set = true
                                            hexStructure[5] = 1}

                }
                else
                {
                    playDoubleClappers()
                    if(!line1set) {
                        line1.setImageResource(R.drawable.split_line)
                        line1set = true}
                        else if(!line2set){
                            line2.setImageResource(R.drawable.split_line)
                            line2set = true}
                            else if(!line3set){
                                line3.setImageResource(R.drawable.split_line)
                                line3set = true}
                                else if(!line4set){
                                    line4.setImageResource(R.drawable.split_line)
                                    line4set = true}
                                    else if(!line5set){
                                        line5.setImageResource(R.drawable.split_line)
                                        line5set = true}
                                        else if(!line6set){
                                            line6.setImageResource(R.drawable.split_line)
                                            line6set = true}
                }
            }, lineInsertTime)

            Handler().postDelayed({
                if (line6set){
                    prompt.text = ""
                    coinOne.setEnabled(false)
                    coinTwo.setEnabled(false)
                    coinThree.setEnabled(false)

                    var mLastClickTime :Long = 0

                    val meaningButton = findViewById<Button>(R.id.hexagram_meaning_button)
                    meaningButton.setVisibility(VISIBLE)
                    meaningButton.setOnClickListener {
                        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                            return@setOnClickListener
                        mLastClickTime = SystemClock.elapsedRealtime()
                        Intent(this, HexagramMeaningActivity::class.java).also{
                            it.putExtra("EXTRA_HEXSTRUCTURE", hexStructure)
                            playBell()
                            startActivity(it)}
                    }
                }
                else
                {prompt.text = "Toss again"
                    coinOne.setEnabled(true)
                    coinTwo.setEnabled(true)
                    coinThree.setEnabled(true)
                    coinOneDisplay.text = ""
                    coinTwoDisplay.text = ""
                    coinThreeDisplay.text = ""
                }
            }, NextTossTime)
        }


        coinOne.setOnClickListener() {
            prompt.text = ""
            coinOneDisplay.text = ""
            playCoinToss()
            resultOne = (2..3).random()
            sum += resultOne
                if (resultOne == 2) {displayOne = "Tails"} else {displayOne = "Heads"}
                coinOne.setEnabled(false)
                coinOne.animate().apply {
                    duration = spinTime
                    rotationXBy(360 + resultOne * 180F)
                }
                Handler().postDelayed({
                    coinOneDisplay.text = displayOne
                }, CoinDisplayTime)
                if(!coinTwo.isEnabled && !coinThree.isEnabled) {
                    WhichLine(sum)
                    sum = 0
                }
            }


        coinTwo.setOnClickListener() {
            prompt.text = ""
            coinTwoDisplay.text = ""
            playCoinToss()
            resultTwo = (2..3).random()
            sum += resultTwo
                if (resultTwo == 2) {displayTwo = "Tails"} else {displayTwo = "Heads"}
                coinTwo.setEnabled(false)
                coinTwo.animate().apply {
                    duration = spinTime
                    rotationXBy(360 + resultTwo * 180F)

                }
                Handler().postDelayed({
                    coinTwoDisplay.text = displayTwo
                }, CoinDisplayTime)
                if(!coinOne.isEnabled && !coinThree.isEnabled) {
                    WhichLine(sum)
                    sum = 0
                }
            }

        coinThree.setOnClickListener() {
            prompt.text = ""
            coinThreeDisplay.text = ""
            playCoinToss()
            resultThree = (2..3).random()
            sum += resultThree
                if (resultThree == 2) {displayThree = "Tails"} else {displayThree = "Heads"}
                coinThree.setEnabled(false)
                coinThree.animate().apply {
                    duration = spinTime
                    rotationXBy(360 + resultThree * 180F)
                }
                Handler().postDelayed({
                    coinThreeDisplay.text = displayThree
                }, CoinDisplayTime)
                if(!coinOne.isEnabled && !coinTwo.isEnabled) {
                    WhichLine(sum)
                    sum = 0
                }
            }

        // ShakeDetector initialization
        // ShakeDetector initialization
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager!!
            .getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mShakeDetector = ShakeDetector()
        mShakeDetector!!.setOnShakeListener(object : OnShakeListener {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onShake(count: Int) {

                onPause()

                if(!line6set){
                    playCoinToss()
                    Handler().postDelayed({ playCoinToss() }, 50)
                    Handler().postDelayed({ playCoinToss() }, 50)

                    prompt.text = ""
                    coinOneDisplay.text = ""
                    coinTwoDisplay.text = ""
                    coinThreeDisplay.text = ""

                    coinOne.setEnabled(false)
                    resultOne = (2..3).random()
                    sum += resultOne
                    if (resultOne == 2) {
                        displayOne = "Tails"
                    } else {
                        displayOne = "Heads"
                    }
                    coinOne.animate().apply {
                        duration = spinTime
                        rotationXBy(360 + resultOne * 180F)
                    }
                    Handler().postDelayed({
                        coinOneDisplay.text = displayOne
                    }, CoinDisplayTime)

                    coinTwo.setEnabled(false)
                    resultTwo = (2..3).random()
                    sum += resultTwo
                    if (resultTwo == 2) {
                        displayTwo = "Tails"
                    } else {
                        displayTwo = "Heads"
                    }
                    coinTwo.animate().apply {
                        duration = spinTime
                        rotationXBy(360 + resultTwo * 180F)
                    }
                    Handler().postDelayed({
                        coinTwoDisplay.text = displayTwo
                    }, CoinDisplayTime)

                    coinThree.setEnabled(false)
                    resultThree = (2..3).random()
                    sum += resultThree
                    if (resultThree == 2) {
                        displayThree = "Tails"
                    } else {
                        displayThree = "Heads"
                    }
                    coinThree.animate().apply {
                        duration = spinTime
                        rotationXBy(360 + resultThree * 180F)
                    }
                    Handler().postDelayed({
                        coinThreeDisplay.text = displayThree
                    }, CoinDisplayTime)

                    WhichLine(sum)
                    sum = 0

                    Handler().postDelayed({ onResume() }, unlockShake)
                }
            }
        })

    }
}



