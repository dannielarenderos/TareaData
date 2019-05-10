package com.spartons.livedataexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main2.*

import android.arch.lifecycle.Observer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val scoreTeam1 = ViewModelProviders.of(this).get(contadorViewModel::class.java)
        val scoreTeam2 = ViewModelProviders.of(this).get(contadorViewModel::class.java)

        val scoreObserver1 = Observer<Int> { newInt ->
            // Update the UI, in this case, a TextView.
            contador1.text = newInt.toString()
        }
        val scoreObserver2 = Observer<Int> { newInt ->
            // Update the UI, in this case, a TextView.
            contador2.text = newInt.toString()
        }
        scoreTeam1.contador1.observe(this, scoreObserver1)
        scoreTeam2.contador2.observe(this, scoreObserver2)

        btnA_3puntos.setOnClickListener(){
            scoreTeam1.anotarA(3)
        }
        btnA_2puntos.setOnClickListener(){
            scoreTeam1.anotarA(2)
        }
        btnA_1puntos.setOnClickListener(){
            scoreTeam1.anotarA(1)
        }
        btnB_3puntos.setOnClickListener(){
            scoreTeam2.anotarB(3)
        }
        btnB_2puntos.setOnClickListener(){
            scoreTeam2.anotarB(2)
        }
        btnB_1puntos.setOnClickListener(){
            scoreTeam2.anotarB(1)
        }
    }
}
class contadorViewModel : ViewModel() {
    var aux1=0
    var aux2=0

    val contador1 = MutableLiveData<Int>()
    val contador2 = MutableLiveData<Int>()

    fun anotarA(i: Int) {
        aux1= aux1+i
        contador1.postValue(aux1)
    }
    fun anotarB(i: Int) {
        aux2= aux2+i
        contador2.postValue(aux2)
    }
}