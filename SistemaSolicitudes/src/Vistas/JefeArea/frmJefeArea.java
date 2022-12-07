package Vistas.JefeArea;

import Conexion.Conexion;
import DAO.SolicitudDAO;
import DAO.UsuarioTIDAO;
import Modelos.Solicitud;
import Vistas.Login.frmLoginUsuarioTI;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class frmJefeArea extends javax.swing.JFrame {

    SolicitudDAO sda = new SolicitudDAO();
    UsuarioTIDAO udao;
    frmLoginUsuarioTI frmlg;
    private String usuarioJ;
    public static String nombres;
    static protected Solicitud sol = new Solicitud();

    public String getUsuarioJ() {
        return usuarioJ;
    }

    public void setUsuarioJ(String usuarioJ) {
        this.usuarioJ = usuarioJ;
    }

    public frmJefeArea() {
        initComponents();
        mostrarFiltro("");
        designTabla();
        rdbTodo.doClick();
        this.setTitle(nombres);
        this.setLocationRelativeTo(null);
    }
    
    private void cerrar() {
        try {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de salir de la aplicación?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                udao = new UsuarioTIDAO();
                udao.estadoconexion(this.getUsuarioJ(), 2);
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void designTabla() {
        tablaJ.setFillsViewportHeight(true);
        tablaJ.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tablaJ.getTableHeader().setForeground(new Color(99, 99, 99));
        tablaJ.getTableHeader().setBackground(new Color(213, 215, 217));
        tablaJ.getTableHeader().setOpaque(false);
        tablaJ.getColumnModel().getColumn(0).setPreferredWidth(105);
        tablaJ.getColumnModel().getColumn(1).setPreferredWidth(118);
        tablaJ.getColumnModel().getColumn(2).setPreferredWidth(80);
        tablaJ.getColumnModel().getColumn(3).setPreferredWidth(80); 
        tablaJ.getColumnModel().getColumn(4).setPreferredWidth(125);
        tablaJ.getColumnModel().getColumn(5).setPreferredWidth(160);
        tablaJ.getColumnModel().getColumn(6).setPreferredWidth(160);
    }

    void mostrarEstado(int IdEst){
        DefaultTableModel dt= (DefaultTableModel)tablaJ.getModel();
        dt.setRowCount(0);
        String tecnico;
        for (Solicitud x: sda.listarEst(IdEst)) {
            if (x.getUsuarioTI().getPersona().getNombres() == null) {
                tecnico = "SIN ASIGNAR";
            } else {
                tecnico = x.getUsuarioTI().getPersona().getNombres();
            }
                Object v[] = {x.getIdSolicitud(), x.getFh_creacion(), x.getEs().getNombre_es(),x.getTs().getNombre(), x.getAsunto(), x.getCat().getNombre_cat(), tecnico};
            dt.addRow(v);  
        }
    }
    void mostrarFiltro(String cad){
        DefaultTableModel dt= (DefaultTableModel)tablaJ.getModel();
        dt.setRowCount(0);
        String tecnico;
        for (Solicitud x : sda.filtrar(cad)) {
            if (x.getUsuarioTI().getPersona().getNombres() == null) {
                tecnico = "SIN ASIGNAR";
            } else {
                tecnico = x.getUsuarioTI().getPersona().getNombres();
            }
                Object v[] = {x.getIdSolicitud(), x.getFh_creacion(), x.getEs().getNombre_es(),x.getTs().getNombre(), x.getAsunto(), x.getCat().getNombre_cat(), tecnico};
            dt.addRow(v);      
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJ = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnRequerimiento = new javax.swing.JButton();
        btnIncidencia = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        rdbTodo = new javax.swing.JRadioButton();
        rdbPendiente = new javax.swing.JRadioButton();
        rdbAtendiendo = new javax.swing.JRadioButton();
        rdbSolucionado = new javax.swing.JRadioButton();
        iconoLupa = new javax.swing.JLabel();
        reload = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaJ.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaJ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"INC202211101654", "2022-11-10 16:37:54", "Solucionado", "Incidencia", "NO PUEDO PRENDER MI PC", "PROBLEMAS CON PC", "GIAN FRANCO ARMAS MEJIA"}
            },
            new String [] {
                "Nro", "FH Registro", "Estado", "Tipo", "Asunto", "Categoria", "Técnico Asignado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaJ.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaJ.setGridColor(new java.awt.Color(153, 153, 153));
        tablaJ.setRowHeight(30);
        tablaJ.setSelectionBackground(new java.awt.Color(105, 235, 253));
        tablaJ.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tablaJ.setShowGrid(false);
        tablaJ.setShowHorizontalLines(true);
        tablaJ.getTableHeader().setReorderingAllowed(false);
        tablaJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaJ);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 830, 360));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarsesion.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 510, 40, 40));

        btnRequerimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton reporte requerimiento.png"))); // NOI18N
        btnRequerimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRequerimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequerimientoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRequerimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 120, 40));

        btnIncidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton reporte Incidencia.png"))); // NOI18N
        btnIncidencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncidenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btnIncidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 40));

        txtBuscar.setBackground(new java.awt.Color(221, 170, 253));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 98, 140, 20));

        rdbTodo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbTodo);
        rdbTodo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbTodo.setText("Todo");
        rdbTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbTodoMouseClicked(evt);
            }
        });
        getContentPane().add(rdbTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, 30));

        rdbPendiente.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbPendiente);
        rdbPendiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbPendiente.setText("Pendiente");
        rdbPendiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbPendienteMouseClicked(evt);
            }
        });
        getContentPane().add(rdbPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, 30));

        rdbAtendiendo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbAtendiendo);
        rdbAtendiendo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbAtendiendo.setText("Atendiendo");
        rdbAtendiendo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbAtendiendoMouseClicked(evt);
            }
        });
        getContentPane().add(rdbAtendiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, 30));

        rdbSolucionado.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbSolucionado);
        rdbSolucionado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbSolucionado.setText("Solucionado");
        rdbSolucionado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdbSolucionadoMouseClicked(evt);
            }
        });
        getContentPane().add(rdbSolucionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, 30));

        iconoLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        getContentPane().add(iconoLupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reload.png"))); // NOI18N
        reload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reloadMouseClicked(evt);
            }
        });
        getContentPane().add(reload, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ventana Listado de Solicitudes (Jefe de Area).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 868, 575));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea desconectarse?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
        udao = new UsuarioTIDAO();
        frmlg = new frmLoginUsuarioTI();
        udao.estadoconexion(this.getUsuarioJ(), 2);
        frmlg.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRequerimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequerimientoActionPerformed
        try {
            Conexion con = new Conexion();
            Connection cnn = con.con;
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteRequerimiento.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cnn);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(frmJefeArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRequerimientoActionPerformed

    private void btnIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncidenciaActionPerformed
        try {
            Conexion con = new Conexion();
            Connection cnn = con.con;
            JasperReport reporte = null;
            String path = "src\\Reportes\\ReporteIncidencia.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cnn);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(frmJefeArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIncidenciaActionPerformed

    private void tablaJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJMouseClicked
        if (evt.getClickCount() == 2) {
            sda = new SolicitudDAO();
            int u = tablaJ.getSelectedRow();
            String codSol = tablaJ.getValueAt(u, 0).toString();
            sol = sda.leer(codSol);
            frmSolicitudJefeArea frm = new frmSolicitudJefeArea();
            frm.setVisible(true);
            frm.setUsuarioJ(this.usuarioJ);
            frmSolicitudJefeArea.idSol = sol.getIdSolicitud();
            this.setVisible(false);
        }
    }//GEN-LAST:event_tablaJMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing

    private void rdbTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbTodoMouseClicked
        mostrarFiltro("");
    }//GEN-LAST:event_rdbTodoMouseClicked

    private void rdbPendienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPendienteMouseClicked
        mostrarEstado(1);
    }//GEN-LAST:event_rdbPendienteMouseClicked

    private void rdbAtendiendoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbAtendiendoMouseClicked
        mostrarEstado(2);
    }//GEN-LAST:event_rdbAtendiendoMouseClicked

    private void rdbSolucionadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSolucionadoMouseClicked
        mostrarEstado(3);
    }//GEN-LAST:event_rdbSolucionadoMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        mostrarFiltro(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void reloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadMouseClicked
        if(rdbTodo.isSelected()){
            mostrarFiltro("");
        }
        if(rdbPendiente.isSelected()){
            mostrarEstado(1);
        }
        if(rdbAtendiendo.isSelected()){
            mostrarEstado(2);
        }
        if(rdbSolucionado.isSelected()){
            mostrarEstado(3);
        }
    }//GEN-LAST:event_reloadMouseClicked

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
            java.util.logging.Logger.getLogger(frmJefeArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmJefeArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmJefeArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmJefeArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmJefeArea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIncidencia;
    private javax.swing.JButton btnRequerimiento;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel iconoLupa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbAtendiendo;
    private javax.swing.JRadioButton rdbPendiente;
    private javax.swing.JRadioButton rdbSolucionado;
    private javax.swing.JRadioButton rdbTodo;
    private javax.swing.JLabel reload;
    private javax.swing.JTable tablaJ;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
