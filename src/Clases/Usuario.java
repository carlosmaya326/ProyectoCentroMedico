package Clases;

import DB.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usuario {
    int id;
    String tipoUsuario;
    int documento;
    String usuario;
    String contrasena;
    
    public Usuario(String tipoUsuario, int documento, String usuario, String contrasena){
        this.tipoUsuario = tipoUsuario;
        this.documento = documento;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public int guardar(){
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();
            
            Statement estado = conexion.createStatement();
            
            if(this.id == -1){
                ResultSet sql = estado.executeQuery("SELECT COUNT(*) Cantidad FROM usuario WHERE Usuario = '"+this.usuario+"' OR Documento= '"+this.documento+"'");
                if(sql.next()){
                    if(sql.getInt("Cantidad") > 0){
                        return 3; //Si el usuario o el documento ya existen
                    }else{
                        String qInsert = "INSERT INTO usuario (Documento, Usuario, Contrasena, TipoUsuario, Estado) "
                                + "VALUES('"+this.documento+"', '"+this.usuario+"', '"+this.contrasena+"', '"+this.tipoUsuario+"', 'A')";

                        Statement query = conexion.createStatement();

                        query.executeUpdate(qInsert);
                        return 1;
                    }
                }
            }else{
                String qUpdate = "UPDATE usuario "
                        + " SET Documento = '" + this.documento + "'"
                        + " ,Usuario = '" + this.usuario + "'"
                        + " ,Contrasena = '" + this.contrasena + "'"
                        + " ,TipoUsuario = '" + this.tipoUsuario + "'"
                        + " WHERE UsuarioId = '" + this.id + "'";
                
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
