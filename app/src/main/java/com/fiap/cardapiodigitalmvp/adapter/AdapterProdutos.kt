package com.fiap.cardapiodigitalmvp.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.fiap.cardapiodigitalmvp.R
import com.fiap.cardapiodigitalmvp.model.Produto
import org.w3c.dom.Text


class AdapterProdutos(var listaProdutos: List<Produto>, var activity : Activity) : BaseAdapter() {


    override fun getCount(): Int {
        return this.listaProdutos.size;
    }

    override fun getItem(position: Int): Any? {
        return listaProdutos.get(position);
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View = activity.layoutInflater.inflate(R.layout.activity_lista_produtos_personalizados,parent,false);
        val produto: Produto = listaProdutos.get(position);

        val nome: TextView = view.findViewById(R.id.ista_produtos_personalizados_nome);
        val valor: TextView = view.findViewById(R.id.lista_curso_personalizada_valor);
        val imagem: ImageView = view.findViewById(R.id.lista_produtos_personalizados_imagem);

        nome.setText(produto.nome);
        valor.setText(produto.valor.toString());
        imagem.setImageResource(R.drawable.ic_launcher_foreground);

        return view;
    }

}