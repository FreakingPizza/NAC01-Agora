package br.com.seunome.jokenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val GRAMA = 1
    val AGUA = 2
    val FOGO = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivGrama.setOnClickListener {
            realizarJogada(GRAMA)
        }

        ivFogo.setOnClickListener {
            realizarJogada(FOGO)
        }

        ivAgua.setOnClickListener {
            realizarJogada(AGUA)
        }

    }

    fun configurarImagemDaJogada(jogada: Int, imageView: ImageView){
        when(jogada){
            AGUA -> {configurarImagem(R.drawable.squirtle, imageView)}
            FOGO -> {configurarImagem(R.drawable.charmander, imageView)}
            GRAMA -> {configurarImagem(R.drawable.bulbasaur, imageView)}
        }
    }

    fun configurarImagem(resourceID : Int, imageView: ImageView){
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resourceID))
    }



    fun realizarJogada(jogadaUsuario: Int) {
        val jogadaAdversario = Random().nextInt(3) + 1

        configurarImagemDaJogada(jogadaUsuario, ivVoce)
        configurarImagemDaJogada(jogadaAdversario, ivAndroid)

        when (jogadaUsuario) {
            GRAMA -> {
                when (jogadaAdversario) {
                    GRAMA -> {
                        empate()
                    }
                    FOGO -> {
                        derrota()
                    }
                    AGUA -> {
                        vitoria()
                    }
                }
            }
            FOGO -> {
                when (jogadaAdversario) {
                    GRAMA -> {
                        vitoria()
                    }
                    FOGO -> {
                        empate()
                    }
                    AGUA -> {
                        derrota()
                    }
                }
            }

            AGUA -> {
                when (jogadaAdversario) {
                    GRAMA -> {
                        derrota()
                    }
                    FOGO -> {
                        vitoria()
                    }
                    AGUA -> {
                        empate()
                    }
                }

            }


        }
    }

    fun vitoria() {

        tvResultado.text = "Quem é o campeão? Você é!!"
    }

    fun derrota() {

        tvResultado.text = "Escolheu errado, otário!"
    }

    fun empate() {

        tvResultado.text = "Empatou..."
    }
}
