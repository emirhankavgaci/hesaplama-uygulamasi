package com.example.hesaplamauygulamasi

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

@SuppressLint("SetTextI18n")
class MainActivity : ComponentActivity() {

    private lateinit var  girdiText : EditText
    private lateinit var  sonucText : TextView
    private lateinit var  button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.buttonCalc)
        button.setOnClickListener{
          buttonClick()
        }
    }


    private fun buttonClick()
    {
        girdiText = findViewById(R.id.inputText)
        sonucText = findViewById(R.id.outText)
        val sayilar : Array<String>

        if(girdiText.text.toString().contains('+'))
        {
            sayilar = girdiText.text.split("+").toTypedArray()

            if(sayilar.size == 2 && sayilar[0].toIntOrNull()!=null && sayilar[1].toIntOrNull()!=null)
              {
                  sonucText.text = (sayilar[0].toInt().plus(sayilar[1].toInt())).toString()
              }
            else{
                  sonucText.text = "Lutfen işlemi doğru bir şekilde giriniz."
              }

        }
    else if (girdiText.text.toString().contains('-'))
    {
        sayilar = girdiText.text.split("-").toTypedArray()
        if(sayilar.size == 2 && sayilar[0].toIntOrNull()!=null && sayilar[1].toIntOrNull()!=null)
        {
            sonucText.text = (sayilar[0].toInt().minus(sayilar[1].toInt())).toString()
        }
        else{
            sonucText.text = "Lutfen işlemi doğru bir şekilde giriniz."
        }
    }
    else if(girdiText.text.toString().contains('*'))
    {
        sayilar = girdiText.text.split("*").toTypedArray()
        if(sayilar.size == 2 && sayilar[0].toIntOrNull()!=null && sayilar[1].toIntOrNull()!=null)
        {
            sonucText.text = (sayilar[0].toInt().times(sayilar[1].toInt())).toString()
        }
        else{
            sonucText.text = "Lutfen işlemi doğru bir şekilde giriniz."
        }

    }
    else if(girdiText.text.toString().contains('/'))
    {
        sayilar = girdiText.text.split("/").toTypedArray()
        if(sayilar.size == 2 && sayilar[0].toIntOrNull()!=null && sayilar[1].toIntOrNull()!=null && sayilar[1].toInt()!=0)
        {
            sonucText.text = (sayilar[0].toInt() / (sayilar[1].toInt())).toString()
        }
        else if(sayilar[1].toInt() == 0)
        {
            sonucText.text = "0'a bölme hatası"
        }
        else{
            sonucText.text = "Lutfen işlemi doğru bir şekilde giriniz."
        }
    }
    else
    {
        sonucText.text = "Tanımlanamayan işlem türü!"
    }

        girdiText.text.clear()
        girdiText.text.append(sonucText.text)
    }

}
