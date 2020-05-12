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
import java.util.Objects;

public class Usuario {
    int id;
    String tipoUsuario;
    int documento;
    String usuario;
    String contrasena;
    
    public Usuario(int id, String tipoUsuario, int documento, String usuario, String contrasena){
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.documento = documento;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public int guardar(Usuario usuario){
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();
            
            Statement estado = conexion.createStatement();
            
            if(this.id == -1){
                ResultSet sql = estado.executeQuery("SELECT COUNT(*) Cantidad FROM usuario WHERE Usuario = '"+usuario.usuario+"' OR Documento= '"+usuario.documento+"'");
                if(sql.next()){
                    if(sql.getInt("Cantidad") > 0){
                        return 3; //Si el usuario o el documento ya existen
                    }else{
                        String qInsert = "INSERT INTO usuario (Documento, Usuario, Contrasena, TipoUsuario, Estado) "
                                + "VALUES('"+usuario.documento+"', '"+usuario.usuario+"', '"+usuario.contrasena+"', '"+usuario.tipoUsuario+"', 'A')";

                        Statement query = conexion.createStatement();

                        query.executeUpdate(qInsert);
                        return 1;
                    }
                }
            }else{
                String qUpdate = "UPDATE usuario "
                        + " SET Documento = '" + usuario.documento + "'"
                        + " ,SET Usuario = '" + usuario.usuario + "'"
                        + " ,SET Contrasena = '" + usuario.contrasena + "'"
                        + " ,SET TipoUsuario = '" + usuario.tipoUsuario + "'"
                        + " WHERE UsuarioId = '" + usuario.id + "'";

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
    
    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
