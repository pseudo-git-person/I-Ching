package com.pseudo.iching

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MyFortuneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_fortune)

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        val field = findViewById<EditText>(R.id.insert_field)
        val buttonClickQuestionSubmit = findViewById<Button>(R.id.submit_button)

        var mLastClickTime :Long = 0

        buttonClickQuestionSubmit.setOnClickListener {
            val question = field.text.toString()
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()
            Intent(this, QuestionSubmitActivity::class.java).also{
                it.putExtra("EXTRA_QUESTION", question)
                startActivity(it)}

        }



    }
}