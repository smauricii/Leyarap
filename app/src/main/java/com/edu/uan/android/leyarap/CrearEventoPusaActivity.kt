package com.edu.uan.android.leyarap

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.uan.android.leyarap.clases.ListaPausas
import com.edu.uan.android.leyarap.database.AppDatabase
import kotlinx.android.synthetic.main.activity_crear_evento_pusa.*
import kotlinx.android.synthetic.main.item_lista_pausa.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearEventoPusaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_evento_pusa)

        var idListapausa: Int? =null

        if(intent.hasExtra("listaitem")){
            val itemLista = intent.extras?.getSerializable("listaitem") as ListaPausas

            txt_nombre.setText(itemLista.titulo)
            //txt_hora.setText(itemLista.diaHora)
            idListapausa = itemLista.idLista
        }

        val database = AppDatabase.getDatabase(this)

        txt_crear_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_crear_evento.setTextColor(Color.WHITE)

        txt_nombre_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_nombre_evento.setTextColor(Color.WHITE)

        txt_seleccion.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_seleccion.setTextColor(Color.WHITE)

        btn_crear.setOnClickListener {
            if (txt_nombre.text.toString() != "") {
                val nombre = txt_nombre.text.toString()
                val hora = "13:00"
                val lista = ListaPausas(nombre, hora, R.drawable.imagen_fondo1)
                if(idListapausa != null){
                    CoroutineScope(Dispatchers.IO).launch {
                        lista.idLista = idListapausa

                        database.itemLista().update(lista)
                        this@CrearEventoPusaActivity.finish()
                    }
                }else{
                    CoroutineScope(Dispatchers.IO).launch {
                        database.itemLista().insertAll(lista)

                        this@CrearEventoPusaActivity.finish()
                }


                }
            }else{
                Toast.makeText(this, "Por favor llena los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}