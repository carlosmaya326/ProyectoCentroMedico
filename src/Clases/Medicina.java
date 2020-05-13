/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import DB.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Juan Carlos
 */
public class Medicina {
    int id;
    String nombre;
    String fechaCaducidad;
    String detalle;

    public Medicina(String nombre, String fechaCaducidad, String detalle) {
        this.nombre = nombre;
        this.fechaCaducidad = fechaCaducidad;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public int guardar(){
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();
            
            Statement estado = conexion.createStatement();
            
            if(this.id == -1){
                String qInsert = "INSERT INTO medicina (Nombre, FechaCaducidad, Detalle) "
                        + "VALUES('"+this.nombre+"', '"+this.fechaCaducidad+"', '"+this.detalle+"')";

                Statement query = conexion.createStatement();

                query.executeUpdate(qInsert);
                return 1;
            }else{
                String qUpdate = "UPDATE medicina "
                        + " SET Nombre= '" + this.nombre + "'"
                        + " ,FechaCaducidad = '" + this.fechaCaducidad + "'"
                        + " ,Detalle = '" + this.detalle + "'"
                        + " WHERE MedicinaId = '" + this.id + "'";
                
                System.out.println(qUpdate);

                Statement query = conexion.createStatement();

                query.executeUpdate(qUpdate);
                return 2;
            }
       }catch(Exception ex){
           System.out.println("Error, No se ha podido guardar la información");
           System.out.println(ex.getMessage());
       }
        return 0;
    }
    
}
