/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Mensaje {
    private int id;
    private String asunto;
    private String contenido;
    private String fecha;
    private int idEmisor;
    private int idReceptor;
    
    // Constructor
    
    public Mensaje(int id, String asunto, String contenido, String fecha, int idEmisor, int idReceptor) {
        this.id = id;
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.idEmisor = idEmisor;
        this.idReceptor = idReceptor;
    }

    public Mensaje(String asunto, String contenido, String fecha, int idEmisor, int idReceptor) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.idEmisor = idEmisor;
        this.idReceptor = idReceptor;
    }

    // Getters y setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getAsunto() {
        return asunto;
    }
    
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
    }
    
}

