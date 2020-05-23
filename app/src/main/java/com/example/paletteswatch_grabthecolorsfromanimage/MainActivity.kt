package com.example.paletteswatch_grabthecolorsfromanimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var list: MutableList<Palette.Swatch>
    var currentSwatch: Palette.Swatch? = null
    var i = 0

    var vibrantswatch: Palette.Swatch? = null
    var lightVibrantSwatch: Palette.Swatch? = null
    var darkVibrantSwatch: Palette.Swatch? = null
    var muttedSwatch: Palette.Swatch? = null
    var lightMuttedSwatch: Palette.Swatch? = null
    var darkMuttedSwatch: Palette.Swatch? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Palette.from(imageView_emmawatson.drawable.toBitmap()).maximumColorCount(64).generate {
            list = mutableListOf()

            currentSwatch = it!!.vibrantSwatch //titleTextColor,bodyTextColor,rgb
            vibrantswatch = it!!.vibrantSwatch
            lightVibrantSwatch = it.lightVibrantSwatch
            darkVibrantSwatch = it.darkVibrantSwatch
            muttedSwatch = it.mutedSwatch
            lightMuttedSwatch = it.lightMutedSwatch
            darkMuttedSwatch = it.darkMutedSwatch
        }

        bt_nextswatch.setOnClickListener {

            when (i) {

                0 -> {
                    currentSwatch = vibrantswatch
                    textView_title.text = "vibrantSwatch"
                }
                1 -> {
                    currentSwatch = lightVibrantSwatch
                    textView_title.text = "lightVibrantSwatch"
                }
                2 -> {
                    currentSwatch = darkVibrantSwatch
                    textView_title.text = "darkVibrantSwatch"
                }
                3 -> {
                    currentSwatch = muttedSwatch
                    textView_title.text = "mutedSwatch"
                }
                4 -> {
                    currentSwatch = lightMuttedSwatch
                    textView_title.text = "lightMutedSwatch"
                }
                5 -> {
                    currentSwatch = darkMuttedSwatch
                    textView_title.text = "darkMutedSwatch"
                }
            }


            if (currentSwatch != null) {
                textView_title.setTextColor(currentSwatch!!.titleTextColor)
                textView2_body.setTextColor(currentSwatch!!.bodyTextColor)
                rootlayout.setBackgroundColor(currentSwatch!!.rgb)
            }

            if (i < 6) i++
            else i = 0

        }
    }
}
