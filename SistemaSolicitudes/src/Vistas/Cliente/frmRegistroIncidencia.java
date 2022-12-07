package Vistas.Cliente;

import DAO.CategoriaDAO;
import DAO.PrioridadDAO;
import DAO.SolicitudDAO;
import DAO.TipoDAO;
import DAO.UsuarioTIDAO;
import Modelos.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class frmRegistroIncidencia extends javax.swing.JFrame {

    SolicitudDAO obj = new SolicitudDAO();
    CategoriaDAO cat = new CategoriaDAO();
    PrioridadDAO pri = new PrioridadDAO();
    UsuarioTIDAO uti = new UsuarioTIDAO();
    TipoDAO ts = new TipoDAO();
    public static int idUsuario;
    public static String nombres;

    public frmRegistroIncidencia() {
        initComponents();
        lblCliente.setText(nombres);
        txtDescripcion.setBorder(BorderFactory.createCompoundBorder(txtDescripcion.getBorder(), BorderFactory.createEmptyBorder(3, 7, 3, 7)));
        llenarCombos();
        this.setTitle(nombres);
        this.setLocationRelativeTo(null);
    }
    
    private void cerrar() {
        try {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de salir de la aplicación?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void llenarCombos() {
        cboCategoria.removeAllItems();
        cboPrioridad.removeAllItems();
        cboTipo.removeAllItems();
        ArrayList mListaCat = cat.consultaCat();
        ArrayList mListaPri = pri.consultaPri();
        ArrayList mListaTip = ts.consultaTipo();

        Iterator iteraCat = mListaCat.iterator();
        while (iteraCat.hasNext()) {
            Categoria objCat = (Categoria) iteraCat.next();
            cboCategoria.addItem(objCat);
        }

        Iterator iteraPri = mListaPri.iterator();
        while (iteraPri.hasNext()) {
            Prioridad objPri = (Prioridad) iteraPri.next();
            cboPrioridad.addItem(objPri);
        }

        Iterator iteraTS = mListaTip.iterator();
        while (iteraTS.hasNext()) {
            Tipo_solicitud objTS = (Tipo_solicitud) iteraTS.next();
            cboTipo.addItem(objTS);
        }

    }

    void push(String asunto, String Descripcion) {
        Solicitud sol = new Solicitud();
        Usuario u = new Usuario(idUsuario);
        sol.setUsuario(u);
        UsuarioTI utiobj = uti.tecnicoAsignado();
        sol.setUsuarioTI(utiobj);
        sol.setDescripcion(Descripcion);
        sol.setAsunto(asunto);
        Tipo_solicitud ts = new Tipo_solicitud(cboTipo.getSelectedIndex() + 1);
        sol.setTs(ts);
        Estado_solicitud es = new Estado_solicitud(1);
        sol.setEs(es);
        Prioridad pr = new Prioridad(cboPrioridad.getSelectedIndex() + 1);
        sol.setPri(pr);
        Categoria cat = new Categoria(cboCategoria.getSelectedIndex() + 1);
        sol.setCat(cat);
        obj.crear(sol);
        JOptionPane.showMessageDialog(null, "Se ha registrado la solicitud correctamente");
        frmCliente regresar = new frmCliente();
        regresar.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        cboCategoria = new javax.swing.JComboBox<>();
        cboPrioridad = new javax.swing.JComboBox<>();
        cboTipo = new javax.swing.JComboBox<>();
        txtAsunto = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDescripcion.setBackground(new java.awt.Color(165, 212, 185));
        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setBorder(null);
        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 610, 230));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton salir Verde.png"))); // NOI18N
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 40, 40));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Registrar.png"))); // NOI18N
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 120, 40));

        cboCategoria.setBackground(new java.awt.Color(165, 212, 185));
        cboCategoria.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(cboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 300, 30));

        cboPrioridad.setBackground(new java.awt.Color(165, 212, 185));
        cboPrioridad.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(cboPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 130, -1));

        cboTipo.setBackground(new java.awt.Color(165, 212, 185));
        cboTipo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(cboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 130, -1));

        txtAsunto.setBackground(new java.awt.Color(165, 212, 185));
        txtAsunto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAsunto.setBorder(null);
        getContentPane().add(txtAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 250, -1));

        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 112, 250, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ventana Registro Solicitud (Cliente).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 668, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmCliente regresar = new frmCliente();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String asunto = txtAsunto.getText();
        String Descripcion = txtDescripcion.getText();
        if (asunto.equals("") || Descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "Llenar los campos");
        } else {
            push(asunto, Descripcion);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRegistroIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistroIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistroIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistroIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistroIncidencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Object> cboCategoria;
    private javax.swing.JComboBox<Object> cboPrioridad;
    private javax.swing.JComboBox<Object> cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}