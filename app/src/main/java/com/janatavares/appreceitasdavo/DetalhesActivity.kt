package com.janatavares.appreceitasdavo

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    private lateinit var imgDetalhes: ImageView
    private lateinit var textTituloDetalhes: TextView
    private lateinit var textTempoDetalhes: TextView
    private lateinit var textReceitaDetalhes: TextView
    private lateinit var textPreparoDetalhes: TextView
    private lateinit var btnVoltar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imgDetalhes = findViewById(R.id.img_detalhe)
        textTituloDetalhes = findViewById(R.id.text_titutlo_detalhe)
        textTempoDetalhes = findViewById(R.id.text_tempo_detalhe)
        textReceitaDetalhes = findViewById(R.id.text_receita_detalhe)
        textPreparoDetalhes = findViewById(R.id.text_preparo_detalhes)
        btnVoltar = findViewById(R.id.btn_voltar)

        btnVoltar.setOnClickListener {
            finish()
        }

        val bundle = intent.extras
        if (bundle != null) {
            val receita = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable<Receita>("receita", Receita::class.java)
            } else {
                bundle.getParcelable<Receita>("receita")
            }

            receita?.let {
                imgDetalhes.setImageResource(it.imagem)
                textTituloDetalhes.text = it.titulo
                textTempoDetalhes.text = it.tempo

                val listaIngredientes = it.ingredientes
                var textoIngredientes = ""
                for (ingrediente in listaIngredientes) {
                    textoIngredientes += "- $ingrediente \n"
                }

                textReceitaDetalhes.text = textoIngredientes

                val listaPreparo = it.preparo
                var textoPreparo = ""
                for (preparo in listaPreparo) {
                    textoPreparo += "- $preparo \n"
                }

                textPreparoDetalhes.text = textoPreparo

            }
        }
    }
}