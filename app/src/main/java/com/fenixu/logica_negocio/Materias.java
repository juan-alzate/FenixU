package com.fenixu.logica_negocio;

public abstract class Materias {

    int numeroCreditos;
    float nota;
    String nombreMateria;

  public Materias(int numeroCreditos, float nota, String nombreMateria){
      this.numeroCreditos = numeroCreditos;
      this.nota = nota;
      this.nombreMateria = nombreMateria;
  }

  public int getNumeroCreditos(){
      return numeroCreditos;
  }

  public void setNumeroCreditos(int numeroCreditos){
      this.numeroCreditos = numeroCreditos;
  }

  public float getNota(){
      return nota;
  }

  public void setNota(float nota){
      this.nota = nota;
  }

  public String getNombreMateria(){
      return nombreMateria;
  }

  public void setNombreMateria(String nombreMateria){
      this.nombreMateria = nombreMateria;
  }

}
