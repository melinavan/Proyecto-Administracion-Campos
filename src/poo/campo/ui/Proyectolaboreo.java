package poo.campo.ui;
// Generated 11/12/2018 10:20:40 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Proyectolaboreo generated by hbm2java
 */
public class Proyectolaboreo  implements java.io.Serializable {


     private Integer idproyectolaboreo;
     private Laboreo laboreo;
     private Proyecto proyecto;
     private Date fecha;
     private String nota;
     private Integer idlaboreocultivo;    
     private boolean activo;
     private Integer idlaboreo;
     private Integer idcultivo;
     private Integer idproyecto;
    
    public Proyectolaboreo() {
    }

	
    public Proyectolaboreo(Laboreo laboreo, Proyecto proyecto, Date fecha, boolean activo) {
        this.laboreo = laboreo;
        this.proyecto = proyecto;
        this.fecha = fecha;
        this.activo = activo;
    }
    public Proyectolaboreo(Laboreo laboreo, Proyecto proyecto, Date fecha, String nota, Integer idlaboreocultivo, boolean activo) {
       this.laboreo = laboreo;
       this.proyecto = proyecto;
       this.fecha = fecha;
       this.nota = nota;
       this.idlaboreocultivo = idlaboreocultivo;
       this.activo = activo;
    }
   
    public Integer getIdproyectolaboreo() {
        return this.idproyectolaboreo;
    }
    
    public void setIdproyectolaboreo(Integer idproyectolaboreo) {
        this.idproyectolaboreo = idproyectolaboreo;
    }
    public Laboreo getLaboreo() {
        return this.laboreo;
    }
    
    public void setLaboreo(Laboreo laboreo) {
        this.laboreo = laboreo;
    }
    public Proyecto getProyecto() {
        return this.proyecto;
    }
    
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getNota() {
        return this.nota;
    }
    
    public void setNota(String nota) {
        this.nota = nota;
    }
    public Integer getidproyecto() {
        return this.idproyecto;
    }
    
    public void setidproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }           
    public Integer getIdlaboreocultivo() {
        return this.idlaboreocultivo;
    }
    
    public void setIdlaboreocultivo(Integer idlaboreocultivo) {
        this.idlaboreocultivo = idlaboreocultivo;
    }
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setidCultivo(Integer idCultivo) {
        this.idcultivo = idCultivo;
    }
    public void setidLaboreo(Integer idlaboreo) {
        this.idlaboreo = idlaboreo;
    }

    public Integer getIdcultivo() {
        return this.idcultivo;
    }
    public Integer getIdLaboreo() {
        return this.idlaboreo;
    }

}


