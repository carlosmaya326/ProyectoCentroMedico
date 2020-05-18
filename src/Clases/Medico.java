package Clases;

import DB.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;

public class Medico {
    int id;
    int documento;
    String nombres;
    String apellidos;
    int telefono;
    String direccion;
    JTable roles;

    public Medico(int documento, String nombres, String apellidos, int telefono, String direccion, JTable roles) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public JTable getRoles() {
        return roles;
    }

    public void setRoles(JTable roles) {
        this.roles = roles;
    }
    
    public int guardar(){
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();
            
            Statement estado = conexion.createStatement();
            
            Statement estadoRol = conexion.createStatement();
            estadoRol.executeUpdate("DELETE FROM RolMedico WHERE MedicoId = '"+this.id+"'");
            
            if(this.id == -1){
                ResultSet sql = estado.executeQuery("SELECT COUNT(*) Cantidad FROM Medico WHERE Documento = '"+this.documento+"'");
                if(sql.next()){
                    if(sql.getInt("Cantidad") > 0){
                        return 3; //Si el documento ya existe
                    }else{
                        String qInsert = "INSERT INTO Medico (Documento, Nombres, Apellidos, Telefono, Direccion) "
                            + "VALUES('"+this.documento+"', '"+this.nombres+"', '"+this.apellidos+"', '"+this.telefono+"', '"+this.direccion+"')";

                        Statement query = conexion.createStatement();

                        query.executeUpdate(qInsert);
                        ResultSet sqlR = estado.executeQuery("SELECT MedicoId FROM Medico WHERE Documento = '"+this.documento+"'");
                        if(sqlR.next()){
                            this.id = sqlR.getInt("MedicoId");
                        }
                        for (int count = 0; count < roles.getRowCount(); count++){                   
                            if(!roles.getValueAt(count, 2).toString().equals("")){
                                int valorTabla = Integer.parseInt(roles.getValueAt(count, 0).toString());
                                int tieneRol = Integer.parseInt(roles.getValueAt(count, 2).toString());
                                if(tieneRol == 1){
                                    Statement estadoRolInsert = conexion.createStatement();
                                    String queryRoles = "INSERT INTO RolMedico (RolId, MedicoId) "
                                            + "VALUES ('"+valorTabla+"', '"+this.id+"')";
                                    estadoRolInsert.executeUpdate(queryRoles);
                                }
                            }
                        }
                        return 1;
                    }
                }
            }else{
                for (int count = 0; count < roles.getRowCount(); count++){                   
                    if(!roles.getValueAt(count, 2).toString().equals("")){
                        int valorTabla = Integer.parseInt(roles.getValueAt(count, 0).toString());
                        int tieneRol = Integer.parseInt(roles.getValueAt(count, 2).toString());
                        if(tieneRol == 1){
                            Statement estadoRolInsert = conexion.createStatement();
                            String queryRoles = "INSERT INTO RolMedico (RolId, MedicoId) "
                                    + "VALUES ('"+valorTabla+"', '"+this.id+"')";
                            estadoRolInsert.executeUpdate(queryRoles);
                        }
                    }
                }
                
                String qUpdate = "UPDATE Medico "
                        + " SET Nombres = '" + this.nombres + "'"
                        + " ,Apellidos = '" + this.apellidos + "'"
                        + " ,Telefono = '" + this.telefono + "'"
                        + " ,Direccion = '" + this.direccion + "'"
                        + " WHERE MedicoId = '" + this.id + "'";

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
