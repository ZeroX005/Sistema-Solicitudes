package Vistas.Cliente;

import DAO.SolicitudDAO;
import Modelos.Solicitud;
import Vistas.Login.frmLoginUsuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmCliente extends javax.swing.JFrame {

    SolicitudDAO obj = new SolicitudDAO();
    frmLoginUsuario frmlg;
    public static int idUsuario;
    public static String nombres;

    public frmCliente() {
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
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void designTabla() {
        tableC.setFillsViewportHeight(true);
        tableC.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableC.getTableHeader().setForeground(new Color(99, 99, 99));
        tableC.getTableHeader().setBackground(new Color(213, 215, 217));
        tableC.getTableHeader().setOpaque(false);
        tableC.getColumnModel().getColumn(0).setPreferredWidth(105);
        tableC.getColumnModel().getColumn(1).setPreferredWidth(118);
        tableC.getColumnModel().getColumn(2).setPreferredWidth(80);
        tableC.getColumnModel().getColumn(3).setPreferredWidth(80); 
        tableC.getColumnModel().getColumn(4).setPreferredWidth(125);
        tableC.getColumnModel().getColumn(5).setPreferredWidth(160);
        tableC.getColumnModel().getColumn(6).setPreferredWidth(160);
    }

    void mostrarEst(int idEst) {
        DefaultTableModel dt = (DefaultTableModel) tableC.getModel();
        dt.setRowCount(0);
        String tecnico;
        for (Solicitud x : obj.listarEst(idEst)) {
            if (x.getUsuario().getIdUsuario() == idUsuario) {
                if (x.getUsuarioTI().getPersona().getNombres() == null) {
                    tecnico = "SIN ASIGNAR";
                } else {
                    tecnico = x.getUsuarioTI().getPersona().getNombres();
                }
                Object v[] = {x.getIdSolicitud(), x.getFh_creacion(), x.getEs().getNombre_es(),x.getTs().getNombre(), x.getAsunto(), x.getCat().getNombre_cat(), tecnico};
                dt.addRow(v);
            }
        }
    }

    void mostrarFiltro(String cad) {
        DefaultTableModel dt = (DefaultTableModel) tableC.getModel();
        dt.setRowCount(0);
        String tecnico;
        for (Solicitud x : obj.filtrar(cad)) {
            if (x.getUsuario().getIdUsuario() == idUsuario) {
                if (x.getUsuarioTI().getPersona().getNombres() == null) {
                    tecnico = "SIN ASIGNAR";
                } else {
                    tecnico = x.getUsuarioTI().getPersona().getNombres();
                }
                Object v[] = {x.getIdSolicitud(), x.getFh_creacion(), x.getEs().getNombre_es(),x.getTs().getNombre(), x.getAsunto(), x.getCat().getNombre_cat(), tecnico};
                dt.addRow(v);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableC = new javax.swing.JTable();
        btnRegistroIncidente = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
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

        tableC.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tableC.setModel(new javax.swing.table.DefaultTableModel(
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
        tableC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableC.setGridColor(new java.awt.Color(153, 153, 153));
        tableC.setRowHeight(30);
        tableC.setSelectionBackground(new java.awt.Color(105, 235, 253));
        tableC.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tableC.setShowGrid(false);
        tableC.setShowHorizontalLines(true);
        tableC.getTableHeader().setReorderingAllowed(false);
        tableC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableC);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 830, 360));

        btnRegistroIncidente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boton Registrar Incidente.png"))); // NOI18N
        btnRegistroIncidente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroIncidenteActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistroIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 40));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarsesion.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 510, 40, 40));

        txtBuscar.setBackground(new java.awt.Color(165, 212, 185));
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ventana Listado de Solicitudes (Cliente).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 868, 575));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroIncidenteActionPerformed
        frmRegistroIncidencia.idUsuario = idUsuario;
        frmRegistroIncidencia registrar = new frmRegistroIncidencia();
        registrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroIncidenteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea desconectarse?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
        frmlg = new frmLoginUsuario();
        frmlg.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tableCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCMouseClicked
        if (evt.getClickCount() == 2) {
            int f = tableC.getSelectedRow();
            frmDetalleSolicitud detalle = new frmDetalleSolicitud();
            Solicitud s = obj.leer(tableC.getValueAt(f, 0).toString());
            String tecnico;
            if (s.getUsuarioTI().getPersona().getNombres() == null) {
                tecnico = "Sin Asignar";
            } else {
                tecnico = s.getUsuarioTI().getPersona().getNombres();
            }
            if (s.getEs().getNombre_es().equals("Solucionado")) {
                detalle.btnAnular.setVisible(false);
                detalle.btnActualizar.setVisible(false);
                detalle.txtAsunto.setEditable(false);
                detalle.txtDescripcion.setEditable(false);
            }
            detalle.lblCliente.setText(s.getUsuario().getPersona().getNombres());
            detalle.lblCategoria.setText(s.getCat().getNombre_cat());
            detalle.lblTecnico.setText(tecnico);
            detalle.lblPrioridad.setText(s.getPri().getNombre_p());
            detalle.lblTipo.setText(s.getTs().getNombre());
            detalle.lblEstado.setText(s.getEs().getNombre_es());
            detalle.txtAsunto.setText(s.getAsunto());
            detalle.txtDescripcion.setText(s.getDescripcion());
            detalle.setVisible(true);
            detalle.idCat = s.getCat().getIdCategoria();
            detalle.idEstado = s.getEs().getIdEstado_solicitud();
            detalle.idPri = s.getPri().getIdPrioridad();
            detalle.idSol = s.getIdSolicitud();
            detalle.idTecnico = s.getUsuarioTI().getIdUsuarioTI();
            detalle.tipo = s.getTs().getIdTipo_solicitud();
            this.dispose();
        }
    }//GEN-LAST:event_tableCMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        mostrarFiltro(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void rdbTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbTodoMouseClicked
        mostrarFiltro("");
    }//GEN-LAST:event_rdbTodoMouseClicked

    private void rdbPendienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbPendienteMouseClicked
        mostrarEst(1);
    }//GEN-LAST:event_rdbPendienteMouseClicked

    private void rdbAtendiendoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbAtendiendoMouseClicked
        mostrarEst(2);
    }//GEN-LAST:event_rdbAtendiendoMouseClicked

    private void rdbSolucionadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdbSolucionadoMouseClicked
        mostrarEst(3);
    }//GEN-LAST:event_rdbSolucionadoMouseClicked

    private void reloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadMouseClicked
        if (rdbTodo.isSelected()) {
            mostrarFiltro("");
        }
        if (rdbPendiente.isSelected()) {
            mostrarEst(1);
        }
        if (rdbAtendiendo.isSelected()) {
            mostrarEst(2);
        }
        if (rdbSolucionado.isSelected()) {
            mostrarEst(3);
        }
    }//GEN-LAST:event_reloadMouseClicked

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
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistroIncidente;
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
    private javax.swing.JTable tableC;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
