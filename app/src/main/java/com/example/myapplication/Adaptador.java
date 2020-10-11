package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    ArrayList<Materia> materias;
    daoMateria daoMaterias;
    Materia materia;
    Activity activity;
    int id=0;

    public Adaptador(Activity activity,ArrayList<Materia> materias, daoMateria daoMaterias )
    {
        this.materias=materias;
        this.activity=activity;
        this.daoMaterias=daoMaterias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return materias.size();
    }

    @Override
    public Materia getItem(int position) {
       materia=materias.get(position);
       return null;
    }

    @Override
    public long getItemId(int position) {
        materia=materias.get(position);
        return materia.getCodigoMateria();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= convertView;
        if(v==null){
            LayoutInflater li = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.item_asignatura,null);
        }
        materia=materias.get(position);
        setId(materia.getCodigoMateria());
        TextView nombre=(TextView)v.findViewById(R.id.t_nombre);
        final TextView definitiva=(TextView)v.findViewById(R.id.t_definitiva);

        ImageView icono=(ImageView)v.findViewById(R.id.imageView4);
        ImageView editar=(ImageView)v.findViewById(R.id.btnEditarEnAsignatura);
        ImageView eliminar=(ImageView)v.findViewById(R.id.btnEliminarEnAsignatura);

        nombre.setText(materia.getNombre());
        //Calcular definitiva aqui........
        //definitiva.setText((int) 0.0);

        editar.setTag(position);
        eliminar.setTag(position);

        editar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int pos=Integer.parseInt(v.getTag().toString());
                final Dialog dialogo = new Dialog(activity);
                dialogo.setTitle("Editar registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.agregar_asignatura);
                dialogo.show();

                final EditText nombre=(EditText)dialogo.findViewById(R.id.txtNombreAsignatura);
                final EditText txtQuiz=(EditText)dialogo.findViewById(R.id.txtQuiz);
                final EditText txtTaller=(EditText)dialogo.findViewById(R.id.txtTaller);
                final EditText txtParcialTeorico=(EditText)dialogo.findViewById(R.id.txtParcialTeorico);
                final EditText txtParcialPractico=(EditText)dialogo.findViewById(R.id.txtParcialPractico);

                Button guardar=(Button)dialogo.findViewById(R.id.btnAgregarAsignatura);
                guardar.setText("Guardar");
                Button cancelar=(Button)dialogo.findViewById(R.id.btnCancelarEnAsignatura);

                materia=materias.get(pos);
                setId(materia.getCodigoMateria());
                nombre.setText(materia.getNombre());
                txtQuiz.setText(""+materia.getPorcentajeQuiz());
                txtTaller.setText(""+materia.getPorcentajeTaller());
                txtParcialTeorico.setText(""+materia.getPorcentajeParcialTeorico());
                txtParcialPractico.setText(""+materia.getPorcentajeParcialPractico());

                //definitiva.setText((int) 1.0);//Calcular la definitivaaaaaaaaaaaaaaaaaaaa................

                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            materia =new Materia(getId(),nombre.getText().toString(),
                                    Double.parseDouble(txtQuiz.getText().toString()) ,Double.parseDouble(txtTaller.getText().toString()) , Double.parseDouble(txtParcialTeorico.getText().toString()),Double.parseDouble(txtParcialPractico.getText().toString())
                            );
                            daoMaterias.editar(materia);
                            materias=daoMaterias.verTodos();
                            notifyDataSetChanged();
                            dialogo.dismiss();

                        }catch (Exception e){
                            Toast.makeText(activity,"Error", Toast.LENGTH_SHORT).show();

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

        eliminar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
}
