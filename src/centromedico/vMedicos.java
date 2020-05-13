/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centromedico;

/**
 *
 * @author Juan Carlos
 */
public class vMedicos extends javax.swing.JFrame {

    /**
     * Creates new form vMenuUsuario
     */
    public vMedicos() {
        initComponents();
        setLocationRelativeTo(this);
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
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblUsuario1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuConfig = new javax.swing.JMenu();
        mUsuario = new javax.swing.JMenuItem();
        mMedicina = new javax.swing.JMenuItem();
        mRolMedico = new javax.swing.JMenuItem();
        mMedicos = new javax.swing.JMenuItem();
        mPacientes = new javax.swing.JMenuItem();
        menuCita = new javax.swing.JMenu();
        mSolicitar = new javax.swing.JMenuItem();
        mHistorial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblLogo.setText("Logo");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUsuario.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Centro Médico tu Salud - ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblLogo)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsuario)
                        .addComponent(jLabel2)
                        .addComponent(lblLogo)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Documento", "Nombre", "Teléfono", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuario);
        if (tblUsuario.getColumnModel().getColumnCount() > 0) {
            tblUsuario.getColumnModel().getColumn(0).setResizable(false);
            tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblUsuario.getColumnModel().getColumn(1).setResizable(false);
            tblUsuario.getColumnModel().getColumn(2).setResizable(false);
            tblUsuario.getColumnModel().getColumn(3).setResizable(false);
        }

        btnRegistrar.setText("Registrar");

        btnEditar.setText("Editar");

        btnEliminar.setText("Eliminar");

        lblUsuario1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUsuario1.setText("Médicos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(lblUsuario1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuConfig.setText("Configuración");

        mUsuario.setText("Usuarios");
        mUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUsuarioActionPerformed(evt);
            }
        });
        menuConfig.add(mUsuario);

        mMedicina.setText("Medicina");
        mMedicina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMedicinaActionPerformed(evt);
            }
        });
        menuConfig.add(mMedicina);

        mRolMedico.setText("Rol Médico");
        mRolMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRolMedicoActionPerformed(evt);
            }
        });
        menuConfig.add(mRolMedico);

        mMedicos.setText("Medicos");
        menuConfig.add(mMedicos);

        mPacientes.setText("Pacientes");
        menuConfig.add(mPacientes);

        menu.add(menuConfig);

        menuCita.setText("Citas");

        mSolicitar.setText("Solicitar");
        menuCita.add(mSolicitar);

        mHistorial.setText("Historial");
        menuCita.add(mHistorial);

        menu.add(menuCita);

        setJMenuBar(menu);

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

    private void mUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUsuarioActionPerformed
        vUsuario ventana = new vUsuario();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_mUsuarioActionPerformed

    private void mMedicinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMedicinaActionPerformed
        vMedicina ventana = new vMedicina();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_mMedicinaActionPerformed

    private void mRolMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRolMedicoActionPerformed
        vRolMedico ventana = new vRolMedico();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_mRolMedicoActionPerformed

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
            java.util.logging.Logger.getLogger(vUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JMenuItem mHistorial;
    private javax.swing.JMenuItem mMedicina;
    private javax.swing.JMenuItem mMedicos;
    private javax.swing.JMenuItem mPacientes;
    private javax.swing.JMenuItem mRolMedico;
    private javax.swing.JMenuItem mSolicitar;
    private javax.swing.JMenuItem mUsuario;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuCita;
    private javax.swing.JMenu menuConfig;
    private javax.swing.JTable tblUsuario;
    // End of variables declaration//GEN-END:variables
}
