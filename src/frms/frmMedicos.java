/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frms;

import Clases.Medico;
import DB.Conexion;
import centromedico.vMedicos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leagu
 */
public class frmMedicos extends javax.swing.JFrame {

    String opcion;
    int medicoId;

    public frmMedicos(String opcion, int medicoId) {
        initComponents();
       
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Registrar Medicos");
        setResizable(false);
        setVisible(true);
        
        this.opcion = opcion;
        this.medicoId = medicoId;
        
        this.obtenerInfo();
        this.obtenerInfoRoles();
    }

    public void obtenerInfo(){
        try{
           if(opcion.equals("editar")){
                Conexion con = new Conexion();
                Connection conexion = con.getConexion();
                Statement estado = conexion.createStatement();     
                ResultSet qSelect = estado.executeQuery("SELECT * FROM Medico WHERE MedicoId = '"+this.medicoId+"'");

                if(qSelect.next()){
                    txtDocumento.setText(qSelect.getString("Documento"));
                    txtDocumento.setEnabled(false);
                    txtNombre.setText(qSelect.getString("Nombres"));
                    txtApellido.setText(qSelect.getString("Apellidos"));;
                    txtTelefono.setText(qSelect.getString("Telefono"));
                    txtDireccion.setText(qSelect.getString("Direccion"));
                }else{
                    System.out.println("No se encontraron registros");
                }
            }

        }catch(IllegalAccessException | InstantiationException | SQLException e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
    
    public void obtenerInfoRoles(){
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return column == 2;
            }
        };
        
        try{
            Conexion con = new Conexion();
            Connection conexion=con.getConexion();

            Statement estado = conexion.createStatement();
           
            String query = "SELECT \n" +
            "	R.RolId\n" +
            "	,R.Nombre\n" +
            "	,(SELECT COUNT(*) FROM RolMedico WHERE RolId = R.RolId AND MedicoId = '"+this.medicoId+"') TieneRol\n" +
            "FROM Rol R";

            ResultSet res = estado.executeQuery(query);
           
            modelo.addColumn("Id");
            modelo.addColumn("Rol");
            modelo.addColumn("Si(1)");

            while(res.next()){
                Object []object = new Object[3];
                object[0] = res.getString("RolId");
                object[1] = res.getString("Nombre");
                object[2] = "";
                modelo.addRow(object);
            }
            tblRoles.setModel(modelo);

            for (int count = 0; count < modelo.getRowCount(); count++){                   
                int valorTabla = Integer.parseInt(modelo.getValueAt(count, 0).toString());
                String queryInfo = "SELECT \n" +
                    "	R.RolId\n" +
                    "	,(SELECT COUNT(*) FROM RolMedico WHERE RolId = R.RolId AND MedicoId = '"+this.medicoId+"') TieneRol\n" +
                    "FROM Rol R\n "+
                    "WHERE R.RolId = '"+valorTabla+"'";
                ResultSet resInfo = estado.executeQuery(queryInfo);
                if(resInfo.next()){
                    int valor = (resInfo.getInt("tieneRol") > 0) ? 1 : 0;
                    if(resInfo.getInt("tieneRol") > 0){
                        tblRoles.setValueAt(valor, count, 2);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTituloMedicos = new javax.swing.JLabel();
        lbDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        lbDocumento1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTituloMedicos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTituloMedicos.setText("Medicos");

        lbDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento.setText("Roles");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nombre");

        lbApellido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbApellido.setText("Apellido");

        lbTelefono.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTelefono.setText("Telefono");

        lbDireccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDireccion.setText("Direccion");

        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Rol", "Si(1)"
            }
        ));
        jScrollPane1.setViewportView(tblRoles);

        lbDocumento1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento1.setText("Documento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(lbTituloMedicos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(lbDocumento1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDocumento)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloMedicos)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDocumento)
                    .addComponent(lbDocumento1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtDocumento.getText().equals("") || 
            txtNombre.getText().equals("") || 
            txtApellido.getText().equals("") ||
            txtTelefono.getText().equals("") ||
            txtDireccion.getText().equals("")
        ){
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos no esten vacios");
        }else{
            Medico medico = new Medico(
                Integer.parseInt(txtDocumento.getText()), 
                txtNombre.getText(), 
                txtApellido.getText(), 
                Integer.parseInt(txtTelefono.getText()), 
                txtDireccion.getText(),
                tblRoles
            );
            medico.setId(medicoId);
            
            int resp = medico.guardar();

            vMedicos ventana = new vMedicos();
            if(resp == 1){
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
                ventana.show();
                this.dispose();
            }else if(resp == 2){
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
                ventana.show();
                this.dispose();
            }else if(resp == 3){
                JOptionPane.showMessageDialog(null, "El documento ya existe");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vMedicos ventana = new vMedicos();
        ventana.show();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new frmMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbDocumento1;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTituloMedicos;
    private javax.swing.JTable tblRoles;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
