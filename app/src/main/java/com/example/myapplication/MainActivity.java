package com.example.myapplication;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    daoMateria dao;
    Adaptador adapter;
    ArrayList<Materia> lista;
    Materia asignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new daoMateria ( this);
        lista=dao.verTodos();
        adapter=new Adaptador(this,lista,dao);

        final ListView list=(ListView)findViewById(R.id.tablaAsignaturas);
        ImageView agregar=(ImageView) findViewById(R.id.añadirItemDeAsignaturas);
        if(lista!=null && lista.size() > 0 )
        {
            list.setAdapter(adapter);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Dialogo para ver vista previa de registro--xml de agregar asignatura
            }
        });


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dialogo de agregar
                final Dialog dialogo = new Dialog(MainActivity.this);
                dialogo.setTitle("Nuevo registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.agregar_asignatura);
                dialogo.show();

                final EditText nombre=(EditText)dialogo.findViewById(R.id.txtNombreAsignatura);

                final EditText txQuiz=(EditText)dialogo.findViewById(R.id.txtQuiz);
                final EditText txTaller=(EditText)dialogo.findViewById(R.id.txtTaller);
                final EditText txParcialTeorico=(EditText)dialogo.findViewById(R.id.txtParcialTeorico);
                final EditText txParcialPractico=(EditText)dialogo.findViewById(R.id.txtParcialPractico);

                Button guardar=(Button)dialogo.findViewById(R.id.btnAgregarAsignatura);
                Button cancelar=(Button)dialogo.findViewById(R.id.btnCancelarEnAsignatura);

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            asignatura =new Materia(nombre.getText().toString(),
                                    Double.parseDouble(txQuiz.getText().toString()) ,Double.parseDouble(txTaller.getText().toString()) , Double.parseDouble(txParcialTeorico.getText().toString()),Double.parseDouble(txParcialPractico.getText().toString())
                                    );
                            dao.insertar(asignatura);
                            lista=dao.verTodos();
                            adapter.notifyDataSetChanged();
                            dialogo.dismiss();

                        }catch (Exception e){
                            Toast.makeText(getApplication(),"Error", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogo.dismiss();
                    }
                });

            }
        });

    }
}