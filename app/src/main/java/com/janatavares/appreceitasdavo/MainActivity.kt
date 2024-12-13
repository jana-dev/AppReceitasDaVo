package com.janatavares.appreceitasdavo

import android.content.Intent
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
            Receita("Bolo de Cenoura", "60 min", R.drawable.bolocenoura,
                listOf("3xic de farinha de trigo", "3 cenouras médias", "2 xic de açucar", "1 colher de fermento em pó", "1/2 xic de óleo", "1 xic chocolate em pó", "1/2 xic de leite", "1xic de açucar para"),
                listOf("Corte a cenoura e no liquidificador bata junto com a farinha, açucar, leite e óleo", "Para a cobertura coloque tudo ao fogo e mexa até erguer fervura.")
            ),
            Receita("Bolo de chocolate com amendoim", "60 min", R.drawable.chocoamendoim,
                listOf("3 xic de farinha de trilho", "2 xic de chocolate em pó", "1 colher de fermento em pó", "1/2 xic de óleo", "1 copo agua morna", "1 pacote 30g de amedoim triturado"),
                listOf("Bata todos os ingredientes", "Finalize com o amendoim triturado")
            ),
            Receita("Salpicão", "30 min", R.drawable.salpicao,
                listOf("1 repolho roxo", "1 repolho verde", "3 maças", "2 pacotes de ameixa seca", "1 pote de maionese", "batata palha"),
                listOf("Rale os repolhos", "Misture com o milho", "Corte a maça e com limão espremido e agua para nao pretear.")
            ),
            Receita("Torta salgada de Carne Moída", "30 min", R.drawable.tortasalgada,
                listOf("1kg de carne moida", "1 cebola média", "1 alho", "1 lata de milho", "1 xic de leite", "2 xic de fatinha de trilho", "1 colher de fermento"),
                listOf("Regogue a carne moida com cebola e alho","Misture com o milho, leite, fatinha e fermento", "Leve ao forno pré aquecido por 45min ou até dourar")
            )
        )

        //Adapter
        receitasAdapter = ReceitasAdapter{ receita ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", receita)
            startActivity(intent)
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(lista)

        //Layout Manager
        rvReceitas.layoutManager = LinearLayoutManager(this)
    }
}