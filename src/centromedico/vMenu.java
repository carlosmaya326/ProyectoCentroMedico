/*
Soy alejo
 */
package centromedico;

import Clases.Usuario;
import java.awt.Color;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 *
 * @author Juan Carlos
 */
public class vMenu extends javax.swing.JFrame {

    private JMenuItem item;
    public Usuario user;
    
    public vMenu() {
        initComponents();
        setLocationRelativeTo(this);

        ImageIcon icono = new ImageIcon(getClass().getResource("/Images/logout.png"));
        jButton2.setIcon(icono);
        
        panel2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        panel2.setBackground(new Color(50,162,140));

    }
    
    public vMenu(Usuario user) {
        initComponents();
        setLocationRelativeTo(this);
        
        this.user = user;
        if(user.getTipoUsuario().equals("P")){
            mUsuario.setVisible(false);
            mMedicina.setVisible(false);
            mRolMedico.setVisible(false);
            mMedicos.setVisible(false);
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
        panel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconomenu.jpg"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblUsuario.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Centro Médico tu Salud - ");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblLogo)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogo)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblUsuario)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        mMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMedicosActionPerformed(evt);
            }
        });
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

    private void mMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMedicosActionPerformed
        vMedicos ventana = new vMedicos();
        ventana.setVisible(true);
        dispose();
    }//GEN-LAST:event_mMedicosActionPerformed

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
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUsuario;
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
    private javax.swing.JPanel panel2;
    // End of variables declaration//GEN-END:variables
}
