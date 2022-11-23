package com.pseudo.iching

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.text.method.TextKeyListener.clear
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class JournalActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits", "SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val number = sharedPreferences.getInt("NUMBER_KEY", 0)

        if (number == 0)
        return


        for (i in number downTo 1) {

                val titleText = sharedPreferences.getString("TITLE_KEY_$i", null)
                val descriptionText = sharedPreferences.getString("DESCRIPTION_KEY_$i", null)
                val imageName = sharedPreferences.getString("IMAGENAME_KEY_$i", null)

            val parent = LinearLayout(this)
            parent.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            parent.orientation = LinearLayout.HORIZONTAL

            //children
            val iv = ImageView(this)
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            lp.setMargins(0, 140, 20, 0)
            iv.setLayoutParams(lp)
            iv.getLayoutParams().height = 200
            iv.getLayoutParams().width = 200

            Glide
                .with(this)
                .load(imageName)
                .into(iv);

            parent.addView(iv)

            val linearCH = LinearLayout(this)
            linearCH.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            linearCH.orientation = LinearLayout.VERTICAL

            // TextView1
            val tv1 = TextView(this)
            val lptv1 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            lptv1.setMargins(60, 60, 0, 0)

            tv1.setLayoutParams(lptv1)
            tv1.setText(titleText) // title
            tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
            tv1.textAlignment = View.TEXT_ALIGNMENT_CENTER

            // TextView2
            val tv2 = TextView(this)
            val lptv2 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            lptv2.setMargins(0, 11, 7, 0)

            tv2.setLayoutParams(lptv2)
            tv2.setText(descriptionText) // description
            tv2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13F)
            tv2.textAlignment = View.TEXT_ALIGNMENT_CENTER


            linearCH.removeAllViews()
            linearCH.addView(tv1)
            linearCH.addView(tv2)

            parent.removeAllViews()
            parent.addView(iv)
            parent.addView(linearCH)

            val finalParent = this.findViewById(R.id.rootLinearLayout) as ViewGroup
            finalParent.addView(parent)

        }

        var mLastClickTime :Long = 0
        val trashButton = findViewById<Button>(R.id.trash_button)
        trashButton.setVisibility(View.VISIBLE)
        trashButton.setOnClickListener {

            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                return@setOnClickListener
            mLastClickTime = SystemClock.elapsedRealtime()

            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure you want to empty the Journal?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    val editor = sharedPreferences.edit()
                    editor.clear().apply()
                    trashButton.setVisibility(View.INVISIBLE)
                    val mainLayout = this.findViewById(R.id.parent_layout) as ViewGroup
                    mainLayout.invalidate()
                    setContentView(R.layout.activity_journal)
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.dismiss()
                }
            val alert = builder.create()
            alert.show()

        }

    }
}