package com.fiap.cardapiodigitalmvp.controller

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fiap.cardapiodigitalmvp.R
import com.fiap.cardapiodigitalmvp.adapter.AdapterProdutos
import com.fiap.cardapiodigitalmvp.model.Produto
import com.fiap.cardapiodigitalmvp.persist.DataBaseManager


class PratosPrincipaisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pratos_principais)

        val db = DataBaseManager(this,"produto");
        db.insereProduto(1, "Lasanha",10.00);
        db.insereProduto(2, "Spaguetti",20.00);
        db.insereProduto(3, "Risoto",15.00);

        val cursor = db.listaProdutos();
        val listaProdutos = ArrayList<Produto>();

        try {
            while (cursor.moveToNext()) {
                val produto = Produto(cursor.getString(cursor.getColumnIndex("NOME")),
                    cursor.getDouble(cursor.getColumnIndex("VALOR")));

                    listaProdutos.add(Produto(produto.nome,produto.valor));
            }
        }finally {
            cursor.close();
        }

        val lista = findViewById<ListView>(R.id.lista);
        //val adapter: ArrayAdapter<Produto> = ArrayAdapter<Produto>(this,android.R.layout.simple_list_item_1,listaProdutos);

        val adapter = AdapterProdutos(listaProdutos,this);
        lista.adapter = adapter;

    }
}