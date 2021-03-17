package com.fiap.cardapiodigitalmvp.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fiap.cardapiodigitalmvp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonPratosPrincipais = findViewById<Button>(R.id.btnPratosPrincipais);
        val buttonBebidas = findViewById<Button>(R.id.btnBebidas);
        val buttonSobremesas = findViewById<Button>(R.id.btnSobremesas);

        buttonPratosPrincipais.setOnClickListener{
            val intent = Intent(this,
                PratosPrincipaisActivity::class.java);
            startActivity(intent);
        }

        buttonBebidas.setOnClickListener{
            val intent = Intent(this,
                BebidasActivity::class.java);
            startActivity(intent);
        }

        buttonSobremesas.setOnClickListener{
            val intent = Intent(this,
                SobremesasActivity::class.java);
            startActivity(intent);
        }

    }


}