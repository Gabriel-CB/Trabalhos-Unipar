package com.example.trabalho2bimestre

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho2bimestre.databinding.FragmentListaAlunosBinding

enum class IntentFields(val field: String) {
    NOME("Nome"),
    ra("R/a"),
    curso("Curso"),
}

private lateinit var binding: FragmentListaAlunosBinding
class ListaAlunos : Fragment() {


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListaAlunosBinding.inflate(layoutInflater);
        val fragment = inflater.inflate(R.layout.fragment_lista_alunos, container, false);

        var rv:RecyclerView = fragment.findViewById(R.id.rv);
        val llm = LinearLayoutManager(fragment.context)
        rv.layoutManager = llm

        val dados = ArrayList<Person>()
        dados.add(Person("Gabriel Candeias Barbosa", "22431", "Sistemas da Informação"))
        dados.add(Person("Victor Huggo Guilherme de Oliveira", "218476", "Sistemas da Informação"))
        dados.add(Person("Carl", "123333", "Sistemas da Informação"))
        dados.add(Person("Alberto", "321222", "Admininstração"))
        dados.add(Person("Jurandi", "005588", "Sistemas da Informação"))

        val adapter = PersonListAdapter(dados, requireActivity().applicationContext)
        rv.adapter = adapter

        // Inflate the layout for this fragment
        return fragment

    }
}