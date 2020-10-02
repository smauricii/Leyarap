package com.edu.uan.android.leyarap.ejemplos

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.activity_ejemplo_creada_pausa.*

class EjemploActivityCreadaPausa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_creada_pausa)

        txt_ejemplo_title.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_ejemplo_title.setTextColor(Color.WHITE)
        title_ejemplo.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        title_ejemplo.setTextColor(Color.WHITE)
    }

}