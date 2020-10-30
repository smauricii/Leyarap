package com.edu.uan.android.leyarap

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.edu.uan.android.leyarap.clases.ListaSalud
import com.edu.uan.android.leyarap.database.AppDatabaseSalud
import kotlinx.android.synthetic.main.activity_creada_salud.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityCreadaSalud : AppCompatActivity() {
    private lateinit var database: AppDatabaseSalud
    private lateinit var listaItemSalud: ListaSalud
    private lateinit var itemListLiveData: LiveData<ListaSalud>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creada_salud)

        txt_title_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_title_salud.setTextColor(Color.WHITE)

        title_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        title_salud.setTextColor(Color.WHITE)

        val idlista = intent.getIntExtra("id", 0)
        database = AppDatabaseSalud.getDatabase(this)

        itemListLiveData = database.itemListaSalud().get(idlista)
        itemListLiveData.observe(this, Observer {

            listaItemSalud = it
            txt_title_salud.text = listaItemSalud.titulo
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista_salud, menu)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.edit_item_salud -> {
                val intent = Intent(this, CrearEventoSaludActivity::class.java)
                intent.putExtra("listaItemSalud", listaItemSalud)
                startActivity(intent)

            }
            R.id.delete_item_salud -> {

                val builder = AlertDialog.Builder(this)

                builder.setTitle("Estas seguro de eliminar ${listaItemSalud.titulo} ?")
                builder.setPositiveButton("Eliminar") { dialogInterface: DialogInterface, i: Int ->

                    itemListLiveData.removeObservers(this)
                    CoroutineScope(Dispatchers.IO).launch {
                        database.itemListaSalud().delete(listaItemSalud)
                        this@ActivityCreadaSalud.finish()
                    }
                }
                builder.setNegativeButton("Cancelar",
                    { dialogInterface: DialogInterface, i: Int -> })
                builder.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}