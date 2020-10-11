package com.example.myapplication;

public class Materia {
    int codigoMateria;
    String nombre;
    double porcentajeQuiz, porcentajeTaller, porcentajeParcialTeorico, porcentajeParcialPractico;

    public Materia(){}

    public Materia(String nombre, double porcentajeQuiz, double porcentajeTaller, double porcentajeParcialTeorico, double porcentajeParcialPractico) {
        this.nombre = nombre;
        this.porcentajeQuiz = porcentajeQuiz;
        this.porcentajeTaller = porcentajeTaller;
        this.porcentajeParcialTeorico = porcentajeParcialTeorico;
        this.porcentajeParcialPractico = porcentajeParcialPractico;
    }

    public Materia(int codigoMateria, String nombre,  double porcentajeQuiz, double porcentajeTaller, double porcentajeParcialTeorico, double porcentajeParcialPractico) {
        this.codigoMateria = codigoMateria;
        this.nombre = nombre;
        this.porcentajeQuiz = porcentajeQuiz;
        this.porcentajeTaller = porcentajeTaller;
        this.porcentajeParcialTeorico = porcentajeParcialTeorico;
        this.porcentajeParcialPractico = porcentajeParcialPractico;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public double getPorcentajeQuiz() {
        return porcentajeQuiz;
    }

    public void setPorcentajeQuiz(double porcentajeQuiz) {
        this.porcentajeQuiz = porcentajeQuiz;
    }

    public double getPorcentajeTaller() {
        return porcentajeTaller;
    }

    public void setPorcentajeTaller(double porcentajeTaller) {
        this.porcentajeTaller = porcentajeTaller;
    }

    public double getPorcentajeParcialTeorico() {
        return porcentajeParcialTeorico;
    }

    public void setPorcentajeParcialTeorico(double porcentajeParcialTeorico) {
        this.porcentajeParcialTeorico = porcentajeParcialTeorico;
    }

    public double getPorcentajeParcialPractico() {
        return porcentajeParcialPractico;
    }

    public void setPorcentajeParcialPractico(double porcentajeParcialPractico) {
        this.porcentajeParcialPractico = porcentajeParcialPractico;
    }
}
