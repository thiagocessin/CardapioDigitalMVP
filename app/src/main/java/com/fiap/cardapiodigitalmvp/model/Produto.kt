package com.fiap.cardapiodigitalmvp.model

class Produto(val nome: String, val valor: Double) {


    override fun toString(): String {
        return this.nome + "Valor:"+ valor;
    }

}