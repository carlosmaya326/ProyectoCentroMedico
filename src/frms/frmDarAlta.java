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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Carlos
 */
public class frmDarAlta extends javax.swing.JFrame {

    int citaId;
    Usuario user;
    
    public frmDarAlta(int citaId, Usuario user) {
        initComponents();
        
        setLocationRelativeTo(this);
        setResizable(false);
        setTitle("Dar de Alta");
        
        this.citaId = citaId;
        this.user = user;
        
        this.infoCita();
        this.obtenerInfoMedicina();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbDocumento = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        lbDocumento1 = new javax.swing.JLabel();
        lbDocumento2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceta = new javax.swing.JTable();
        lbDocumento3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        lbDocumento4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento.setText("Documento");

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nombre Paciente");

        txtFecha.setDateFormatString("yyyy-MM-d HH:mm");
        txtFecha.setEnabled(false);

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        lbDocumento1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento1.setText("Detalle");

        lbDocumento2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento2.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDocumento)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDocumento1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDocumento2))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDocumento)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lbDocumento2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbDocumento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        jTabbedPane1.addTab("Información Cita", jPanel1);

        tblReceta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Medicina", "Dosis", "Si(1)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblReceta);

        lbDocumento3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento3.setText("Receta Médica");

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane3.setViewportView(txtObservacion);

        lbDocumento4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDocumento4.setText("Observación");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDocumento3)
                            .addComponent(lbDocumento4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDocumento4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDocumento3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Dar de Alta", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        vSolicitar ventana = new vSolicitar(user);
        ventana.show();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(txtObservacion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe diligenciar todos los campos");
        }else{
            try{   
                Conexion con = new Conexion();
                Connection conexion = con.getConexion();
                Statement estado = conexion.createStatement();

                String qInsert = "INSERT INTO HistorialClinico (CitaMedicaId, Observaciones) "
                        + "VALUES('"+this.citaId+"', '"+txtObservacion.getText()+"')";

                Statement query = conexion.createStatement();
                query.executeUpdate(qInsert);

                Statement queryU = conexion.createStatement();
                queryU.executeUpdate("UPDATE CitaMedica SET Estado = 'F' WHERE CitaMedicaId = '"+this.citaId+"'");
                
                Statement queryS = conexion.createStatement();
                ResultSet res = estado.executeQuery("SELECT MAX(HistorialClinicoId) Id FROM HistorialClinico");
                
                int historialId = 1;
                if(res.next()){
                    historialId = res.getInt("Id");
                }
                
                Statement queryI = conexion.createStatement();
                queryI.executeUpdate("INSERT INTO RecetaMedica (HistorialClinicoId) VALUES ('"+historialId+"') ");
                
                Statement queryS2 = conexion.createStatement();
                ResultSet res2 = estado.executeQuery("SELECT MAX(RecetaMedicaId) Id FROM RecetaMedica");
                
                int RecetaMedicaId = 1;
                if(res2.next()){
                    RecetaMedicaId = res2.getInt("Id");
                }
                
                for (int count = 0; count < tblReceta.getRowCount(); count++){                   
                    if(!tblReceta.getValueAt(count, 3).toString().equals("")){
                        int valorTabla = Integer.parseInt(tblReceta.getValueAt(count, 0).toString());
                        String dosis = tblReceta.getValueAt(count, 2).toString();
                        int tieneReceta = Integer.parseInt(tblReceta.getValueAt(count, 3).toString());
                        if(tieneReceta == 1){
                            Statement estadoRolInsert = conexion.createStatement();
                            String queryRoles = "INSERT INTO RecetaMedicaMedicina (RecetaMedicaId, MedicinaId, Dosis) "
                                    + " VALUES ('"+RecetaMedicaId+"', '"+valorTabla+"', '"+dosis+"')";
                            estadoRolInsert.executeUpdate(queryRoles);
                        }
                    }
                }

                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
                vSolicitar ventana = new vSolicitar(user);
                ventana.show();
                this.dispose();

            }catch(Exception ex){
                System.out.println("Error, No se ha podido guardar la información");
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
                "WHERE CM.CitaMedicaId = '" + this.citaId + "'";

            ResultSet res = estado.executeQuery(query);

            if (res.next()) {
                txtDocumento.setText(res.getString("Documento"));
                txtNombre.setText(res.getString("Paciente"));
                txtFecha.setDate(res.getDate("Fecha"));
                txtDetalle.setText(res.getString("Descripcion"));
                
                txtDocumento.enable(false);
                txtNombre.enable(false);
                txtFecha.enable(false);
                txtDetalle.enable(false);
            }
        }catch(Exception ex){
           System.out.println("Error, No se ha podido guardar la información");
           System.out.println(ex.getMessage());
       }
    }
    
    public void obtenerInfoMedicina(){
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return (column == 2 || column == 3);
            }
        };
        
        try{
            Conexion con = new Conexion();
            Connection conexion=con.getConexion();

            Statement estado = conexion.createStatement();
           
            String query = "SELECT * FROM Medicina";

            ResultSet res = estado.executeQuery(query);
           
            modelo.addColumn("Id");
            modelo.addColumn("Medicina");
            modelo.addColumn("Dosis");
            modelo.addColumn("Si(1)");

            while(res.next()){
                Object []object = new Object[4];
                object[0] = res.getString("MedicinaId");
                object[1] = res.getString("Nombre");
                object[2] = "";
                object[3] = "";
                modelo.addRow(object);
            }
            tblReceta.setModel(modelo);

            for (int count = 0; count < modelo.getRowCount(); count++){                   
                int valorTabla = Integer.parseInt(modelo.getValueAt(count, 0).toString());
                String queryInfo = "SELECT\n" +
                    "	RMM.Dosis,\n" +
                    "	COUNT(*) Cantidad\n" +
                    "FROM RecetaMedicaMedicina RMM\n" +
                    "LEFT JOIN RecetaMedica RM ON RMM.RecetaMedicaId = RM.RecetaMedicaId\n" +
                    "LEFT JOIN HistorialClinico HC ON RM.HistorialClinicoId = HC.HistorialClinicoId\n" +
                    "WHERE RMM.MedicinaId = '"+valorTabla+"' AND HC.CitaMedicaId = '"+this.citaId+"'";
                ResultSet resInfo = estado.executeQuery(queryInfo);
                if(resInfo.next()){
                    int valor = (resInfo.getInt("Cantidad") > 0) ? 1 : 0;
                    if(resInfo.getInt("Cantidad") > 0){
                        tblReceta.setValueAt(resInfo.getString("Dosis"), count, 2);
                        tblReceta.setValueAt(valor, count, 3);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
    
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
            java.util.logging.Logger.getLogger(frmDarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDarAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new frmDarAlta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbDocumento1;
    private javax.swing.JLabel lbDocumento2;
    private javax.swing.JLabel lbDocumento3;
    private javax.swing.JLabel lbDocumento4;
    private javax.swing.JTable tblReceta;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtDocumento;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
}
