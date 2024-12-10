package com.janatavares.appreceitasdavo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var rvReceitas: RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvReceitas = findViewById(R.id.rv_receitas)

        val lista = listOf(
            Receita("Bolo de Cenoura", "60 min", R.drawable.bolocenoura),
            Receita("Bolo de chocolate com amendoim", "60 min", R.drawable.chocoamendoim),
            Receita("Salpicão", "30 min", R.drawable.salpicao),
            Receita("Torta salgada de Carne Moída", "30 min", R.drawable.tortasalgada)
        )

        //Adapter
        receitasAdapter = ReceitasAdapter()
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(lista)

        //Layout Manager
        rvReceitas.layoutManager = LinearLayoutManager(this)
    }
}