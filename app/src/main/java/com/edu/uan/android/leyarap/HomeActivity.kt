package com.edu.uan.android.leyarap

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*



class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val font = Typeface.createFromAsset(assets, "fonts/texto_letras.ttf")
        txt_bienvenido?.setTypeface(font)
        emailtxt?.setTypeface(font)

        //setup PARA GUARDAR LOS DATOS QUE TENEMOS
        val bundle = intent.extras
        val email = bundle?.getString("email")
        setup(email ?:"")

        //GUARDAR LOS DATOS QUE TENEMOS
        val pref = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE).edit()
        pref.putString("email",email)
        pref.apply()

        btn_pausas_act.setOnClickListener{pausasActivasAct()}
    }
    private fun setup(email:String){
        title ="Inicio"
        emailtxt.text ="${email}"
        //boton salir y guardado de preferencias
        btn_salir.setOnClickListener {

            val pref = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE).edit()
            pref.clear()
            pref.apply()
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }


    }

    private fun pausasActivasAct(){
        val pausaActivity = Intent(this,PausasActivasActivity::class.java)
        startActivity(pausaActivity)

    }
}