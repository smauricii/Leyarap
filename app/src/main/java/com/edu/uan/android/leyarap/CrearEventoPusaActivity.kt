package com.edu.uan.android.leyarap

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crear_evento_pusa.*

class CrearEventoPusaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_evento_pusa)
        txt_crear_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_crear_evento.setTextColor(Color.WHITE)

        txt_nombre_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_nombre_evento.setTextColor(Color.WHITE)

        txt_seleccion.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_seleccion.setTextColor(Color.WHITE)
    }
}