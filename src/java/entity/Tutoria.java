/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Tutoria {

    private int id;
    private String tema;
    private String estado;
    private String fecha;
    private String horaIni;
    private String horaFin;
    private int puntuacion;
    private String comentario;
    private int estadoPago;
    private int idTutor;
    private int idEstudiante;
    private int idCurso;

    public Tutoria(int id, String tema, String estado, String fecha, String horaIni, String horaFin, int puntuacion, String comentario, int estadoPago, int idTutor, int idEstudiante, int idCurso) {
        this.id = id;
        this.tema = tema;
        this.estado = estado;
        this.fecha = fecha;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.estadoPago = estadoPago;
        this.idTutor = idTutor;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }

    

    public Tutoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(int estadoPago) {
        this.estadoPago = estadoPago;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

}   

