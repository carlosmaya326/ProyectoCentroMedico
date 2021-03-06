/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frms;

import Clases.Usuario;
import DB.Conexion;
import centromedico.vSolicitar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author leagu
 */
public class frmSolicitar extends javax.swing.JFrame {

    String opcion;
    int id;
    Usuario user;
    
    public frmSolicitar(String opcion, int id, Usuario user) {
        initComponents();
        
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("Solicitar");
        
        this.opcion = opcion;
        this.id = id;
        this.user = user;
        
        System.out.println(id);
        
        if(id == -1){
            infoInicial();
        }else{
            infoCita();
        }
    }
    
    public void infoInicial(){
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();
            Statement estado = conexion.createStatement();

            String query = "SELECT CONCAT(Nombres, ' ', Apellidos) Nombre FROM Paciente WHERE Documento = '" + this.user.getDocumento() + "'";
            if(this.user.getTipoUsuario().equals("M")){
                query = "SELECT CONCAT(Nombres, ' ', Apellidos) Nombre FROM Medico WHERE Documento = '" + this.user.getDocumento() + "'";
            }
            ResultSet res = estado.executeQuery(query);

            if (res.next()) {
                txtDocumento.setText(Integer.toString(this.user.getDocumento()));
                txtNombre.setText(res.getString("Nombre"));

                txtDocumento.enable(false);
                txtNombre.enable(false);
            }
        }catch(Exception ex){
           System.out.println("Error, No se ha podido guardar la información");
           System.out.println(ex.getMessage());
       }
    }
    
    public void infoCita(){
        try{
            Conexion con = new Conexion();
            Connection conexion = con.getConexion();
            Statement estado = conexion.createStatement();

            String query = "SELECT\n" +
                "	CM.CitaMedicaId\n" +
                "	,CM.Documento\n" +
                "	,CASE WHEN P.Documento IS NOT NULL THEN\n" +
                "		 CONCAT(P.Nombres, ' ', P.Apellidos) \n" +
                "		 ELSE CONCAT(M2.Nombres, ' ', M2.Apellidos) \n" +
                "	END Paciente\n" +
                "	,CM.Fecha\n" +
                "	,CM.Descripcion\n" +
                "FROM CitaMedica CM\n" +
                "LEFT JOIN Paciente P ON CM.Documento = P.Documento\n" +
                "LEFT JOIN Medico M2 ON CM.Documento = M2.Documento\n" +
                "WHERE CM.CitaMedicaId = '" + this.id + "'";

            ResultSet res = estado.executeQuery(query);

            if (res.next()) {
                txtDocumento.setText(res.getString("Documento"));
                txtNombre.setText(res.getString("Paciente"));

                txtDocumento.enable(false);
                txtNombre.enable(false);
                
                txtFecha.setDate(res.getDate("Fecha"));
                txtDetalle.setText(res.getString("Descripcion"));
            }
        }catch(Exception ex){
           System.out.println("Error, No se ha podido guardar la información");
           System.out.println(ex.getMessage());
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        lbTituloSolicitarCita = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        txtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento.setText("Documento");

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        lbTituloSolicitarCita.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTituloSolicitarCita.setText("Solicitar Cita");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nombre");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Detalles");

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        txtFecha.setDateFormatString("yyyy-MM-d HH:mm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(lbTituloSolicitarCita))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbDocumento)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txtNombre)))
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloSolicitarCita)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDocumento)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(txtDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
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

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtFecha.getDate() == null || txtDetalle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Verifique que todos los campos no esten vacios");
        }else{
            String anio = Integer.toString(txtFecha.getCalendar().get(Calendar.YEAR));
            String mes = Integer.toString(txtFecha.getCalendar().get(Calendar.MONTH) + 1);
            String dia = Integer.toString(txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            String hora = Integer.toString(txtFecha.getCalendar().get(Calendar.HOUR_OF_DAY));
            String minutos = Integer.toString(txtFecha.getCalendar().get(Calendar.MINUTE));
            String fecha = anio + "-" + mes + "-" + dia + " " + hora + ":" + minutos;
            
            
            //txtNombre.getText(), fechaCaducidad, txtDetalle.getText();
            try{   
                Conexion con = new Conexion();
                Connection conexion = con.getConexion();
                Statement estado = conexion.createStatement();
                if(opcion.equals("crear")){
                    String qInsert = "INSERT INTO CitaMedica (Documento, Fecha, Descripcion, Estado) "
                            + "VALUES('"+txtDocumento.getText()+"', '"+fecha+"', '"+txtDetalle.getText()+"' , 'A')";

                    Statement query = conexion.createStatement();
                    query.executeUpdate(qInsert);

                    JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
                    vSolicitar ventana = new vSolicitar(user);
                    ventana.show();
                    this.dispose();
                }else{
                    String qUpdate = "UPDATE CitaMedica "
                            + " SET Fecha = '" + fecha + "'"
                            + " ,Descripcion = '" + txtDetalle.getText() + "'"
                            + " WHERE CitaMedicaId = '" + this.id + "'";

                    Statement query = conexion.createStatement();
                    query.executeUpdate(qUpdate);
                        
                    JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
                    vSolicitar ventana = new vSolicitar(user);
                    ventana.show();
                    this.dispose();
                }
            }catch(Exception ex){
                System.out.println("Error, No se ha podido guardar la información");
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vSolicitar ventana = new vSolicitar(user);
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
            java.util.logging.Logger.getLogger(frmSolicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSolicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSolicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSolicitar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new frmSolicitar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbTituloSolicitarCita;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtDocumento;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
