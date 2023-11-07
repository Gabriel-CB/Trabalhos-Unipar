package com.example.trabalho2bimestre;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho2bimestre.ui.main.Info;

import java.util.ArrayList;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.PersonViewHolder> {

    ArrayList<Person> dados = new ArrayList<>();
    Context ctx;
    public PersonListAdapter( ArrayList<Person> dados,Context ctx ) {

        this.dados = dados;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_list_layout, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(dados.get(position).name);
        holder.ra.setText(dados.get(position).ra);
        holder.curso.setText(dados.get(position).curso);

        CardView cardView = holder.itemView.findViewById(R.id.cardInfo);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Info.class);


                Log.w("frag", dados.get(position).name);
                intent.putExtra(
                        "name",
                        dados.get(position).name
                );
                intent.putExtra(
                        "ra",
                        dados.get(position).ra
                );
                intent.putExtra(
                        "curso",
                        dados.get(position).curso
                );

                startActivity(v.getContext(), intent, null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView ra;
        TextView curso;
        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            ra = itemView.findViewById(R.id.ra);
            curso = itemView.findViewById(R.id.curso);

        }
    }
}
