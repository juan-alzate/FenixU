package com.fenixu.logica_negocio;

import java.util.ArrayList;
import java.util.List;

public class MateriasNotas extends Materias {

    int porcentaje;
    float notaAcumulada=0;
    List<Float> listaNotas = new ArrayList<Float>();

    public MateriasNotas(int numeroCreditos, float nota, String nombreMateria,  int porcentaje){
        super(numeroCreditos, nota, nombreMateria);
        this.porcentaje = porcentaje;
    }

    public int getPorcentaje(){
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje){
        this.porcentaje = porcentaje;
    }

    public void ingresarNota(float nota, int porcentajeActual){
        if(porcentaje<=100){
            float notaActual = nota*(porcentaje/100);
            listaNotas.add(notaActual);
            porcentaje+=porcentajeActual;
        }
    }

    public float calcularNota(){
        float notaActual;
        for (int i = 0; i <= listaNotas.size() - 1; i++){
            notaAcumulada += listaNotas.get(i);
        }
        notaActual = (notaAcumulada*100)/porcentaje;
        return notaActual;
    }

    public float notaFaltante(){
        float notaNecesaria = (3-notaAcumulada)/(100-porcentaje);
        return notaNecesaria;
    }
}
