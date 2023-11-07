package com.example.trabalho2bimestre

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class Calculadora : Fragment() {

    private lateinit var relativeLayout: RelativeLayout;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var viewFragment = inflater.inflate(R.layout.fragment_calculadora, container, false)

        var calcularNota: Button = viewFragment.findViewById(R.id.calcularNota);
        relativeLayout = viewFragment.findViewById(R.id.fragmentCalculadora);

        calcularNota.setOnClickListener({
            var v1 = viewFragment.findViewById<EditText>(R.id.v1).text.toString();
            var v2 = viewFragment.findViewById<EditText>(R.id.v2).text.toString();
            var v3 = viewFragment.findViewById<EditText>(R.id.v3).text.toString();
            var v4 = viewFragment.findViewById<EditText>(R.id.v4).text.toString();

            if (v1 == "" || v2 == "" || v3 == "" || v4 == "") {
                snackbar("Digite todas as notas primeiro !", Color.RED, viewFragment);
            } else {

                snackbar("Resultado: "+ CalcularMedia(v1, v2, v3, v4), Color.BLUE, viewFragment);
            }
        })

        // Inflate the layout for this fragment
        return viewFragment;
    }

    fun snackbar(text:String,color:Int, viewFragment: View){

        var snackbar:Snackbar = Snackbar.make(relativeLayout, text,
            Snackbar.LENGTH_SHORT).setAction("Resetar", View.OnClickListener {

            viewFragment.findViewById<EditText>(R.id.v1).setText("");
            viewFragment.findViewById<EditText>(R.id.v2).setText("");
            viewFragment.findViewById<EditText>(R.id.v3).setText("");
            viewFragment.findViewById<EditText>(R.id.v4).setText("");
        }).setTextColor(Color.WHITE)
            .setBackgroundTint(color);

        snackbar.show();
    }

    fun CalcularMedia(n1: String, n2: String, n3: String, n4: String): String {

        var media:Double = (n1.toDouble() + n2.toDouble() + n3.toDouble() + n4.toDouble()) / 4;
        var msg = "";

        if(media >= 6){
            msg = "Aprovado";
        }else if(media >= 4 && media < 6){
            msg = "Recuperação";
        }else{
            msg = "Reprovado";
        }

        return media.toString() + " " + msg;
    }

}