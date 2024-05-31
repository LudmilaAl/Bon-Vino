package Boundary;


import Control.GestorRankingVinos;
import java.util.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaRankingVinos extends javax.swing.JFrame {
    private GestorRankingVinos gestor;
    private Date fechaActual;
    private LocalDate fechaDesdeTxt;
    private LocalDate fechaHastaTxt;
    private boolean cambioFechaPorValidacion = false;
    private String tipoResenaSeleccionada;
    private String formasVisualizacionReporte;
    private boolean confirmacionGeneracionReporte;


    public PantallaRankingVinos() {
        initComponents();
        fechaActual = new Date();
        fechaMaxima(fechaActual);
        cmbTipoReseña.setSelectedIndex(-1);
        cmbTipoVisualizacion.setSelectedIndex(-1);
        ocultarCampos();
        gestor = new GestorRankingVinos();
        dateChooseDesde.setDateFormatString("dd/MM/yyyy");
        dateChooseHasta.setDateFormatString("dd/MM/yyyy");
        inicializarListeners();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelPrincipal = new javax.swing.JPanel();
        botonGenerarRankingBtn = new javax.swing.JButton();
        lblBonVino = new javax.swing.JLabel();
        btnImportarActualizacionVinos1 = new javax.swing.JButton();
        fechaDesdeLbl = new javax.swing.JLabel();
        fechaHastaLbl = new javax.swing.JLabel();
        fechaHastaLbl2 = new javax.swing.JLabel();
        lblTipoReseña = new javax.swing.JLabel();
        cmbTipoReseña = new javax.swing.JComboBox<>();
        lblTipoVisualizacion = new javax.swing.JLabel();
        cmbTipoVisualizacion = new javax.swing.JComboBox<>();
        botonConfirmacionBtn = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        dateChooseDesde = new com.toedter.calendar.JDateChooser();
        dateChooseHasta = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setBackground(new java.awt.Color(181, 12, 12));

        botonGenerarRankingBtn.setText("Generar Ranking de Vinos");
        botonGenerarRankingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarRankingBtnActionPerformed(evt);
            }
        });

        lblBonVino.setFont(new java.awt.Font("Segoe UI Black", 2, 36)); // NOI18N
        lblBonVino.setForeground(new java.awt.Color(255, 255, 255));
        lblBonVino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBonVino.setText("BON VINO");

        btnImportarActualizacionVinos1.setText("Importar actualización de vinos");

        fechaDesdeLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        fechaDesdeLbl.setForeground(new java.awt.Color(255, 255, 255));
        fechaDesdeLbl.setText("Ingresar fecha desde:");

        fechaHastaLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        fechaHastaLbl.setForeground(new java.awt.Color(255, 255, 255));
        fechaHastaLbl.setText("Ingresar fecha hasta:");

        fechaHastaLbl2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        fechaHastaLbl2.setForeground(new java.awt.Color(255, 255, 255));
        fechaHastaLbl2.setText("Generar ranking de los mejores vinos.");

        lblTipoReseña.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTipoReseña.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoReseña.setText("Tipo de reseña:");

        cmbTipoReseña.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reseñas de Sommelier", "Reseñas normales", "Reseñas de amigos", " " }));
        cmbTipoReseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoReseñaActionPerformed(evt);
            }
        });

        lblTipoVisualizacion.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTipoVisualizacion.setForeground(new java.awt.Color(255, 255, 255));
        lblTipoVisualizacion.setText("Tipo de visualización:");

        cmbTipoVisualizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excel", "En Pantalla", "PDF" }));

        botonConfirmacionBtn.setText("Generar reporte");
        botonConfirmacionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmacionBtnActionPerformed(evt);
            }
        });

        btnVolver.setText("<");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        dateChooseDesde.setDateFormatString("dd/MM/yyyy\n");

        dateChooseHasta.setDateFormatString("dd/MM/yyyy\n");

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
                jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(botonGenerarRankingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(fechaHastaLbl)
                                                        .addComponent(fechaDesdeLbl)
                                                        .addComponent(lblTipoReseña)
                                                        .addComponent(lblTipoVisualizacion))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cmbTipoReseña, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cmbTipoVisualizacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(dateChooseDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(dateChooseHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap(203, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnImportarActualizacionVinos1)
                                                .addGap(43, 43, 43))))
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(276, 276, 276)
                                .addComponent(lblBonVino, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonConfirmacionBtn)
                                .addGap(310, 310, 310))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fechaHastaLbl2)
                                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
                jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(fechaHastaLbl2)
                                                        .addComponent(btnVolver))
                                                .addGap(10, 10, 10)
                                                .addComponent(lblBonVino, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(93, 93, 93)
                                                .addComponent(fechaDesdeLbl))
                                        .addComponent(dateChooseDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fechaHastaLbl)
                                        .addComponent(dateChooseHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblTipoReseña)
                                        .addComponent(cmbTipoReseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTipoVisualizacion)
                                        .addComponent(cmbTipoVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(botonConfirmacionBtn)
                                .addGap(108, 108, 108)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonGenerarRankingBtn)
                                        .addComponent(btnImportarActualizacionVinos1))
                                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }// </editor-fold>

    private void botonGenerarRankingBtnActionPerformed(java.awt.event.ActionEvent evt) {
        habilitarPantalla();
        gestor.opGenerarRankingDeVinos(PantallaRankingVinos.this);
    }

    private void cmbTipoReseñaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void botonConfirmacionBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
        ocultarCampos();
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
            java.util.logging.Logger.getLogger(PantallaRankingVinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRankingVinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRankingVinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRankingVinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRankingVinos().setVisible(true);
            }
        });
    }

    public void fechaMaxima(Date fechaActual) {
        dateChooseDesde.setMaxSelectableDate(fechaActual);
        dateChooseHasta.setMaxSelectableDate(fechaActual);
    }


    public void ocultarCampos() {

        botonGenerarRankingBtn.setVisible(true);
        lblBonVino.setVisible(true);
        btnImportarActualizacionVinos1.setVisible(true);
        fechaDesdeLbl.setVisible(false);
        dateChooseDesde.setVisible(false);
        fechaHastaLbl.setVisible(false);
        dateChooseHasta.setVisible(false);
        fechaHastaLbl2.setVisible(false);
        lblTipoReseña.setVisible(false);
        cmbTipoReseña.setVisible(false);
        lblTipoVisualizacion.setVisible(false);
        cmbTipoVisualizacion.setVisible(false);
        botonConfirmacionBtn.setVisible(false);
        btnVolver.setVisible(false);
    }
    public void habilitarPantalla(){
        botonGenerarRankingBtn.setVisible(false);
        lblBonVino.setVisible(true);
        btnImportarActualizacionVinos1.setVisible(false);
        fechaDesdeLbl.setVisible(true);
        dateChooseDesde.setVisible(true);
        fechaHastaLbl.setVisible(true);
        dateChooseHasta.setVisible(true);
        fechaHastaLbl2.setVisible(true);
        lblTipoReseña.setVisible(true);
        cmbTipoReseña.setVisible(true);
        lblTipoVisualizacion.setVisible(true);
        cmbTipoVisualizacion.setVisible(true);
        botonConfirmacionBtn.setVisible(true);
        btnVolver.setVisible(true);

        //inhabilitar interaccion
        fechaDesdeLbl.setEnabled(false);
        dateChooseDesde.setEnabled(false);
        fechaHastaLbl.setEnabled(false);
        dateChooseHasta.setEnabled(false);
        fechaHastaLbl2.setEnabled(false);
        lblTipoReseña.setEnabled(false);
        cmbTipoReseña.setEnabled(false);
        lblTipoVisualizacion.setEnabled(false);
        cmbTipoVisualizacion.setEnabled(false);
        botonConfirmacionBtn.setEnabled(false);
    }

    public void solicitarFechaDesdeYHasta() {
        fechaDesdeLbl.setEnabled(true);
        dateChooseDesde.setEnabled(true);
        fechaHastaLbl.setEnabled(true);
        dateChooseHasta.setEnabled(true);
    }

    public void tomarFechaDesde() {
        Date fechaDesdeSeleccionada = dateChooseDesde.getDate();
        if (fechaDesdeSeleccionada != null) {
            fechaDesdeTxt = fechaDesdeSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }

    public void tomarFechaHasta() {
        Date fechaDesdeSeleccionada = dateChooseHasta.getDate();
        if (fechaDesdeSeleccionada != null) {
            fechaHastaTxt = fechaDesdeSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }

    public boolean validarFechas(LocalDate fechaDesde, LocalDate fechaHasta){
        if (fechaDesde != null && fechaHasta != null && fechaHasta.isBefore(fechaDesde)){
            JOptionPane.showMessageDialog(this, "La fecha hasta la que se quiere buscar no puede ser menor a la fecha desde cual se inicia la búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
            // Establecer el booleano de cambio de fecha por validación para evitar el bucle infinito
            cambioFechaPorValidacion = true;
            dateChooseHasta.setDate(null);
            dateChooseDesde.setDate(null);

            // Restablecer el booleano después de completar la operación
            cambioFechaPorValidacion = false;
            return false;
        } else {
            return true;
        }
    }

    public void inicializarListeners() {
        dateChooseDesde.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (!cambioFechaPorValidacion && "date".equals(evt.getPropertyName())) {
                    tomarFechaDesde();
            /*if (!validarFechas(fechaDesdeTxt, fechaHastaTxt)){
                fechaDesdeTxt = null;
                fechaHastaTxt = null;
            }*/
                }
            }
        });

        dateChooseHasta.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (!cambioFechaPorValidacion && "date".equals(evt.getPropertyName())) {
                    tomarFechaHasta();
                    if (!validarFechas(fechaDesdeTxt, fechaHastaTxt)){
                        fechaDesdeTxt = null;
                        fechaHastaTxt = null;
                    } else {
                        gestor.tomarFechasDesdeHasta(fechaDesdeTxt, fechaHastaTxt, PantallaRankingVinos.this);
                    }
                }
            }
        });

        // Listener para cmbTipoReseña
        cmbTipoReseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarTipoResena();
            }
        });

        cmbTipoVisualizacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarFormaDeVisualizacion();
            }
        });

    /*botonConfirmacionBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int opcion = JOptionPane.showConfirmDialog(PantallaRankingVinos.this, "¿Estás seguro que quieres generar el reporte?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                confirmacionGeneracionReporte = tomarConfPGReporte();
                gestor.tomarConfPGReportetomarConfPGReporte(confirmacionGeneracion, listaVinos, listapaises, interfazExcel);;
                // Puedes hacer algo con la confirmación, si lo necesitas.
            }
        }
    });*/

    }

    public void solicitarTipoResena(){
        lblTipoReseña.setEnabled(true);
        cmbTipoReseña.setEnabled(true);


    }


    public void tomarFormaDeVisualizacion() {
        formasVisualizacionReporte = (String) cmbTipoVisualizacion.getSelectedItem();
        if (formasVisualizacionReporte != null && "Excel".equals(formasVisualizacionReporte)) {
            gestor.tomarFormaDeVisualiz(formasVisualizacionReporte, PantallaRankingVinos.this);
        } else {
            JOptionPane.showMessageDialog(this, "¡Estamos trabajando! ¡Muy pronto vas a poder seleccionar ese tipo de reseñas!");
        }

    }

    public void tomarTipoResena(){
        tipoResenaSeleccionada = (String) cmbTipoReseña.getSelectedItem();
        if (tipoResenaSeleccionada != null && "Reseñas de Sommelier".equals(tipoResenaSeleccionada)) {
            gestor.tomarTipoResena(tipoResenaSeleccionada, PantallaRankingVinos.this);
        } else {
            JOptionPane.showMessageDialog(this, "¡Estamos trabajando! ¡Muy pronto vas a poder seleccionar ese tipo de reseñas!");

        }
    }

    public void mostrarFormasDeVisualizPSeleccion() {
        lblTipoVisualizacion.setEnabled(true);
        cmbTipoVisualizacion.setEnabled(true);

    }



    public void solicitarConfPGReporte(){
        botonConfirmacionBtn.setEnabled(true);

    }

    public boolean tomarConfPGReporte(){
        return true;

    }

    // Variables declaration - do not modify
    private javax.swing.JButton botonConfirmacionBtn;
    private javax.swing.JButton botonGenerarRankingBtn;
    private javax.swing.JButton btnImportarActualizacionVinos1;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbTipoReseña;
    private javax.swing.JComboBox<String> cmbTipoVisualizacion;
    private com.toedter.calendar.JDateChooser dateChooseDesde;
    private com.toedter.calendar.JDateChooser dateChooseHasta;
    private javax.swing.JLabel fechaDesdeLbl;
    private javax.swing.JLabel fechaHastaLbl;
    private javax.swing.JLabel fechaHastaLbl2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JLabel lblBonVino;
    private javax.swing.JLabel lblTipoReseña;
    private javax.swing.JLabel lblTipoVisualizacion;
    // End of variables declaration
}

