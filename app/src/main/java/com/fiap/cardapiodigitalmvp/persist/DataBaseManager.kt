package com.fiap.cardapiodigitalmvp.persist

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.math.BigDecimal

class DataBaseManager(context: Context, name: String?) : SQLiteOpenHelper(context, name, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE PRODUTO(" +
                "ID_PRODUTO INT NOT NULL, " +
                "NOME VARCHAR(20), " +
                "VALOR DECIMAL(5,2)," +
                "PRIMARY KEY(ID_PRODUTO));"
        db?.execSQL(query);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val queryDrop = "DROP TABLE IF EXISTS PRODUTO";

        val query = "CREATE TABLE PRODUTO(" +
                "ID_PRODUTO INT NOT NULL, " +
                "NOME VARCHAR(20), " +
                "VALOR DECIMAL(5,2)," +
                "PRIMARY KEY(ID_PRODUTO));"

        db?.execSQL(queryDrop);
        db?.execSQL(query);
    }

    fun insereProduto(id:Int, nome: String, valor: Double){

        var db = this.writableDatabase;
        var cv = ContentValues();

        cv.put("ID_PRODUTO",id);
        cv.put("NOME",nome);
        cv.put("VALOR",valor);

        db.insert("PRODUTO", "ID_PRODUTO",cv);
    }

    fun listaProdutos():Cursor{
        var db = this.readableDatabase;
        var cur = db.rawQuery("select nome, valor from produto",null);

        return cur;
    }

    fun removeSaudacao(idProduto: Int){
        var db = this.writableDatabase;
        db.delete("PRODUTO", "ID_PRODUTO=$idProduto",null);
    }


}