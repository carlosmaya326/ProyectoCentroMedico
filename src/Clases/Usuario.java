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
                        + " ,Usuario = '" + usuario.usuario + "'"
                        + " ,Contrasena = '" + usuario.contrasena + "'"
                        + " ,TipoUsuario = '" + usuario.tipoUsuario + "'"
                        + " WHERE UsuarioId = '" + usuario.id + "'";
                
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
    
    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
