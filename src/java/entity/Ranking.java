/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Ranking {
    
    private String nombreCurso;
    private int idUsuarioExperto;
    private String nombreUsuarioExperto;
    private int totalTutorias;
    private double promedio;

    public Ranking() {
    }

    public Ranking(String nombreCurso, int idUsuarioExperto, String nombreUsuarioExperto, int totalTutorias, double promedio) {
        this.nombreCurso = nombreCurso;
        this.idUsuarioExperto = idUsuarioExperto;
        this.nombreUsuarioExperto = nombreUsuarioExperto;
        this.totalTutorias = totalTutorias;
        this.promedio = promedio;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIdUsuarioExperto() {
        return idUsuarioExperto;
    }

    public void setIdUsuarioExperto(int idUsuarioExperto) {
        this.idUsuarioExperto = idUsuarioExperto;
    }

    public String getNombreUsuarioExperto() {
        return nombreUsuarioExperto;
    }

    public void setNombreUsuarioExperto(String nombreUsuarioExperto) {
        this.nombreUsuarioExperto = nombreUsuarioExperto;
    }

    public int getTotalTutorias() {
        return totalTutorias;
    }

    public void setTotalTutorias(int totalTutorias) {
        this.totalTutorias = totalTutorias;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    
    
}
