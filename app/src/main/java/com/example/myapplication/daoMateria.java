package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class daoMateria {
    SQLiteDatabase conexion;
    ArrayList<Materia> Materias = new ArrayList<Materia>();
    Materia materia;
    Context contexto;

    String dataBase = "BaseDMaterias";
    String tabla = "create table if not exists materias(codigoMateria integer primary key autoincrement, nombre text, porcentajeQuiz real, porcentajeTaller real, porcentajeParcialTeorico real, porcentajeParcialPractico real)";



    public daoMateria(Context c) {
        this.contexto = c;
        conexion = c.openOrCreateDatabase(dataBase, Context.MODE_PRIVATE, null);
        conexion.execSQL(tabla);
    }

    public boolean insertar(Materia m)
    {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre",m.getNombre());
        contenedor.put("porcentajeQuiz",m.getPorcentajeQuiz());
        contenedor.put("porcentajeTaller",m.getPorcentajeTaller());
        contenedor.put("porcentajeParcialTeorico",m.getPorcentajeParcialTeorico());
        contenedor.put("porcentajeParcialPractico",m.getPorcentajeParcialPractico());
        return(conexion.insert("materias", null,contenedor))>0;

    }

    public boolean eliminar(int cod)
    {

        return true;
    }

    public  boolean editar(Materia m)
    {
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre",m.getNombre());
        contenedor.put("porcentajeQuiz",m.getPorcentajeQuiz());
        contenedor.put("porcentajeTaller",m.getPorcentajeTaller());
        contenedor.put("porcentajeParcialTeorico",m.getPorcentajeParcialTeorico());
        contenedor.put("porcentajeParcialPractico",m.getPorcentajeParcialPractico());
        return(conexion.update("materias", contenedor,"id="+m.getCodigoMateria(),null))>0;
    }

    public ArrayList<Materia> verTodos()
    {


        Materias.clear();
        Cursor cursor=conexion.rawQuery("select * from materias", null);
        if(cursor!=null&&cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                Materias.add(new Materia(
                        cursor.getInt(0),
                        cursor.getString(1 ),
                        cursor.getDouble(2),
                        cursor.getDouble(3),
                        cursor.getDouble(4),
                        cursor.getDouble(5)
                        )
                );
            }while(cursor.moveToNext());
        }
        return Materias;
    }

    public Materia verUno(int cod)
    {
        return materia;
    }
}
