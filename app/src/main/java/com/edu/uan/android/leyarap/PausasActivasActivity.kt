package com.edu.uan.android.leyarap

import android.annotation.SuppressLint

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.edu.uan.android.leyarap.ejemplos.EjemploActivityCreadaPausa
import kotlinx.android.synthetic.main.activity_pausas_activas.*


class PausasActivasActivity : AppCompatActivity() {

    private var search:SearchView? =null
    private var count =0
    private var num =10
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pausas_activas)
        actionBar?.setBackgroundDrawable(ColorDrawable(R.drawable.fondo))


        txt_pausa.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_pausa.setTextColor(Color.WHITE)

        btn_crear_evento.setOnClickListener { crearEventoActivity() }
        btn_ejemplo.setOnClickListener { ejemploEventoActivity() }
    }
//futura implementacion de busqueda filtrando datos en una lista
/*    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nemu, menu)
        search = menu?.findItem(R.id.app_bar_search)?.actionView as SearchView
        search!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        search!!.setOnQueryTextListener(this)
        return true

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
*//*        count =1
        if(!newText.equals("",ignoreCase = true)){
            search.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
            for(i in 0 until num){

            }

        }*//*
        return false
    }*/

    private fun crearEventoActivity(){
        val crearAct = Intent(this, CrearEventoPusaActivity::class.java)
        startActivity(crearAct)
    }

    private fun ejemploEventoActivity(){
        val ejemplo = Intent(this, EjemploActivityCreadaPausa::class.java)
        startActivity(ejemplo)
    }


}