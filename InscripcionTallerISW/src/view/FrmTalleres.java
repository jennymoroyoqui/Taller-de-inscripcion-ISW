package view;

import controller.InscripcionController;
import controller.TallerController;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.Taller;
import model.Ticket;

public class FrmTalleres extends javax.swing.JFrame {

    private TallerController tallerController;
    private InscripcionController inscripcionController;
    private Taller tallerSeleccionado;
    private Alumno alumnoActual;
    private boolean actualizando = false;
    private DefaultTableModel modeloTabla;
    private CardLayout cardInferior;

    public FrmTalleres(TallerController tallerController, InscripcionController inscripcionController) {
        this.tallerController = tallerController;
        this.inscripcionController = inscripcionController;
        initComponents();
        configurarFormulario();
        cargarTabla();
    }

    private void configurarFormulario() {
        setTitle("Semana de ISW - Inscripción a Talleres");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(1240, 790);
        setLocationRelativeTo(null);
        cardInferior = (CardLayout) pnlInferior.getLayout();
        pnlInferior.setPreferredSize(new java.awt.Dimension(1000, 320));

        lblTitulo.setText("Semana de ISW - Talleres disponibles");
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

        String[] columnas = {"Taller", "Instructor", "Fecha", "Horario", "Lugar", "Cupo", "Descripción breve"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblTalleres.setModel(modeloTabla);
        tblTalleres.setRowHeight(26);
        tblTalleres.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        int[] anchos = {190, 130, 125, 90, 95, 45, 220};
        for (int i = 0; i < anchos.length; i++) {
            tblTalleres.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblTalleres.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !actualizando) {
                seleccionarTaller();
            }
        });

        jScrollPane1.setBorder(BorderFactory.createTitledBorder("Lista de talleres"));
        pnlDetalles.setBorder(BorderFactory.createTitledBorder("Detalles del taller"));
        jScrollPane2.setBorder(BorderFactory.createTitledBorder("Descripción"));
        pnlInferior.setBorder(BorderFactory.createTitledBorder("Inscripción"));
        txtDescripcion.setEditable(false);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtTicket.setEditable(false);
        txtTicket.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));

        String[] capDetalle = {"Taller:", "Instructor:", "Fecha:", "Horario:", "Lugar:", "Cupo disponible:"};
        for (int i = 0; i < capDetalle.length; i++) {
            JLabel cap = (JLabel) pnlCampos.getComponent(2 * i);
            cap.setText(capDetalle[i]);
            cap.setFont(cap.getFont().deriveFont(Font.BOLD));
        }
        String[] capAlumno = {"ID:", "Nombre completo:", "Semestre:", "Programa académico:"};
        for (int i = 0; i < capAlumno.length; i++) {
            JLabel cap = (JLabel) pnlAlumno.getComponent(2 * i);
            cap.setText(capAlumno[i]);
            cap.setFont(cap.getFont().deriveFont(Font.BOLD));
        }
        ((GridLayout) pnlCampos.getLayout()).setHgap(20);
        ((GridLayout) pnlCampos.getLayout()).setVgap(6);
        ((GridLayout) pnlAlumno.getLayout()).setHgap(20);
        ((GridLayout) pnlAlumno.getLayout()).setVgap(6);

        // Textos de botones y de la ayuda
        btnInscribirse.setText("Inscribirse");
        btnBuscar.setText("Buscar");
        btnConfirmar.setText("Confirmar inscripción");
        btnFinalizar.setText("Finalizar");
        lblAyuda.setText("Seleccione un taller y presione \"Inscribirse\".");
        lblAyuda.setHorizontalAlignment(JLabel.CENTER);

        limpiarDetalles();
        mostrarCard(0);
    }

    private void mostrarCard(int numero) {
        cardInferior.first(pnlInferior);
        for (int i = 0; i < numero; i++) {
            cardInferior.next(pnlInferior);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTalleres = new javax.swing.JTable();
        pnlDetalles = new javax.swing.JPanel();
        pnlCampos = new javax.swing.JPanel();
        lblCapDet0 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCapDet1 = new javax.swing.JLabel();
        lblInstructor = new javax.swing.JLabel();
        lblCapDet2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCapDet3 = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblCapDet4 = new javax.swing.JLabel();
        lblLugar = new javax.swing.JLabel();
        lblCapDet5 = new javax.swing.JLabel();
        lblCupo = new javax.swing.JLabel();
        pnlDesc = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnInscribirse = new javax.swing.JButton();
        pnlInferior = new javax.swing.JPanel();
        pnlVacio = new javax.swing.JPanel();
        lblAyuda = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        pnlId = new javax.swing.JPanel();
        lblCapId = new javax.swing.JLabel();
        txtIdAlumno = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlAlumno = new javax.swing.JPanel();
        lblCapAlu0 = new javax.swing.JLabel();
        lblIdAlumno = new javax.swing.JLabel();
        lblCapAlu1 = new javax.swing.JLabel();
        lblNombreAlumno = new javax.swing.JLabel();
        lblCapAlu2 = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        lblCapAlu3 = new javax.swing.JLabel();
        lblPrograma = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        pnlTicket = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Semana de ISW - Inscripción a Talleres");
        setResizable(false);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Semana de ISW - Talleres disponibles");
        getContentPane().add(lblTitulo, java.awt.BorderLayout.NORTH);

        jSplitPane1.setDividerLocation(790);
        jSplitPane1.setResizeWeight(0.68);

        tblTalleres.setRowHeight(26);
        tblTalleres.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblTalleres);

        jSplitPane1.setLeftComponent(jScrollPane1);

        pnlDetalles.setLayout(new java.awt.BorderLayout());

        pnlCampos.setLayout(new java.awt.GridLayout(6, 2));

        lblCapDet0.setText("Taller:");
        pnlCampos.add(lblCapDet0);

        lblNombre.setText("-");
        pnlCampos.add(lblNombre);

        lblCapDet1.setText("Instructor:");
        pnlCampos.add(lblCapDet1);

        lblInstructor.setText("-");
        pnlCampos.add(lblInstructor);

        lblCapDet2.setText("Fecha:");
        pnlCampos.add(lblCapDet2);

        lblFecha.setText("-");
        pnlCampos.add(lblFecha);

        lblCapDet3.setText("Horario:");
        pnlCampos.add(lblCapDet3);

        lblHorario.setText("-");
        pnlCampos.add(lblHorario);

        lblCapDet4.setText("Lugar:");
        pnlCampos.add(lblCapDet4);

        lblLugar.setText("-");
        pnlCampos.add(lblLugar);

        lblCapDet5.setText("Cupo disponible:");
        pnlCampos.add(lblCapDet5);

        lblCupo.setText("-");
        pnlCampos.add(lblCupo);

        pnlDetalles.add(pnlCampos, java.awt.BorderLayout.NORTH);

        pnlDesc.setLayout(new java.awt.BorderLayout());

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(4);
        txtDescripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtDescripcion);

        pnlDesc.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlDetalles.add(pnlDesc, java.awt.BorderLayout.CENTER);

        btnInscribirse.setText("Inscribirse");
        btnInscribirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirseActionPerformed(evt);
            }
        });
        pnlDetalles.add(btnInscribirse, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setRightComponent(pnlDetalles);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pnlInferior.setLayout(new java.awt.CardLayout());

        pnlVacio.setLayout(new java.awt.BorderLayout());

        lblAyuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAyuda.setText("Seleccione un taller y presione \"Inscribirse\".");
        pnlVacio.add(lblAyuda, java.awt.BorderLayout.CENTER);

        pnlInferior.add(pnlVacio, "VACIO");

        pnlDatos.setLayout(new java.awt.BorderLayout());

        pnlId.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblCapId.setText("Ingrese el ID del alumno:");
        pnlId.add(lblCapId);

        txtIdAlumno.setColumns(12);
        txtIdAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAlumnoActionPerformed(evt);
            }
        });
        pnlId.add(txtIdAlumno);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlId.add(btnBuscar);

        pnlDatos.add(pnlId, java.awt.BorderLayout.NORTH);

        pnlAlumno.setLayout(new java.awt.GridLayout(4, 2));

        lblCapAlu0.setText("ID:");
        pnlAlumno.add(lblCapAlu0);

        lblIdAlumno.setText("-");
        pnlAlumno.add(lblIdAlumno);

        lblCapAlu1.setText("Nombre completo:");
        pnlAlumno.add(lblCapAlu1);

        lblNombreAlumno.setText("-");
        pnlAlumno.add(lblNombreAlumno);

        lblCapAlu2.setText("Semestre:");
        pnlAlumno.add(lblCapAlu2);

        lblSemestre.setText("-");
        pnlAlumno.add(lblSemestre);

        lblCapAlu3.setText("Programa académico:");
        pnlAlumno.add(lblCapAlu3);

        lblPrograma.setText("-");
        pnlAlumno.add(lblPrograma);

        pnlDatos.add(pnlAlumno, java.awt.BorderLayout.CENTER);

        btnConfirmar.setText("Confirmar inscripción");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        pnlDatos.add(btnConfirmar, java.awt.BorderLayout.SOUTH);

        pnlInferior.add(pnlDatos, "DATOS");

        pnlTicket.setLayout(new java.awt.BorderLayout());

        txtTicket.setEditable(false);
        txtTicket.setColumns(20);
        txtTicket.setRows(5);
        jScrollPane3.setViewportView(txtTicket);

        pnlTicket.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        pnlTicket.add(btnFinalizar, java.awt.BorderLayout.SOUTH);

        pnlInferior.add(pnlTicket, "TICKET");

        getContentPane().add(pnlInferior, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInscribirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirseActionPerformed
        inscribirse();
    }//GEN-LAST:event_btnInscribirseActionPerformed

    private void txtIdAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAlumnoActionPerformed
        buscarAlumno();
    }//GEN-LAST:event_txtIdAlumnoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarAlumno();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmar();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        finalizar();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    public void cargarTabla() {
        actualizando = true;
        modeloTabla.setRowCount(0);
        List<Taller> talleres = tallerController.obtenerTalleres();
        for (Taller t : talleres) {
            modeloTabla.addRow(new Object[]{t.getNombre(), t.getInstructor(), t.getFecha(),
                t.getHorario(), t.getLugar(), t.getCupoDisponible(), t.getDescripcionBreve()});
        }
        actualizando = false;
    }

    public void refrescarTabla() {
        int fila = tblTalleres.getSelectedRow();
        cargarTabla();
        if (fila >= 0) {
            actualizando = true;
            tblTalleres.setRowSelectionInterval(fila, fila);
            actualizando = false;
        }
    }

    private void seleccionarTaller() {
        int fila = tblTalleres.getSelectedRow();
        if (fila >= 0) {
            tallerSeleccionado = tallerController.obtenerTaller(fila);
            mostrarDetalles(tallerSeleccionado);
            alumnoActual = null;
            mostrarCard(0);
        }
    }

    public void mostrarDetalles(Taller t) {
        lblNombre.setText(t.getNombre());
        lblInstructor.setText(t.getInstructor());
        lblFecha.setText(t.getFecha());
        lblHorario.setText(t.getHorario());
        lblLugar.setText(t.getLugar());
        lblCupo.setText(String.valueOf(t.getCupoDisponible()));
        txtDescripcion.setText(t.getDescripcion());
    }

    public void limpiarDetalles() {
        lblNombre.setText("-");
        lblInstructor.setText("-");
        lblFecha.setText("-");
        lblHorario.setText("-");
        lblLugar.setText("-");
        lblCupo.setText("-");
        txtDescripcion.setText("");
    }

    private void limpiarDatosAlumno() {
        lblIdAlumno.setText("-");
        lblNombreAlumno.setText("-");
        lblSemestre.setText("-");
        lblPrograma.setText("-");
    }

    public void inscribirse() {
        try {
            tallerSeleccionado = tallerController.obtenerTaller(tblTalleres.getSelectedRow());
            alumnoActual = null;
            txtIdAlumno.setText("");
            limpiarDatosAlumno();
            mostrarCard(1);
            txtIdAlumno.requestFocus();
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    public void buscarAlumno() {
        try {
            alumnoActual = inscripcionController.buscarAlumno(txtIdAlumno.getText());
            lblIdAlumno.setText(alumnoActual.getId());
            lblNombreAlumno.setText(alumnoActual.getNombreCompleto());
            lblSemestre.setText(alumnoActual.getSemestre() + "º semestre");
            lblPrograma.setText(alumnoActual.getProgramaAcademico());
        } catch (IllegalArgumentException ex) {
            alumnoActual = null;
            limpiarDatosAlumno();
            mostrarError(ex.getMessage());
        }
    }

    public void confirmar() {
        try {
            Ticket ticket = inscripcionController.confirmarInscripcion(alumnoActual, tallerSeleccionado);
            txtTicket.setText(ticket.generarTexto());
            txtTicket.setCaretPosition(0);
            mostrarCard(2);
            refrescarTabla();
            mostrarDetalles(tallerSeleccionado);
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        }
    }

    public void finalizar() {
        alumnoActual = null;
        txtIdAlumno.setText("");
        limpiarDatosAlumno();
        mostrarCard(0);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnInscribirse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblAyuda;
    private javax.swing.JLabel lblCapAlu0;
    private javax.swing.JLabel lblCapAlu1;
    private javax.swing.JLabel lblCapAlu2;
    private javax.swing.JLabel lblCapAlu3;
    private javax.swing.JLabel lblCapDet0;
    private javax.swing.JLabel lblCapDet1;
    private javax.swing.JLabel lblCapDet2;
    private javax.swing.JLabel lblCapDet3;
    private javax.swing.JLabel lblCapDet4;
    private javax.swing.JLabel lblCapDet5;
    private javax.swing.JLabel lblCapId;
    private javax.swing.JLabel lblCupo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblIdAlumno;
    private javax.swing.JLabel lblInstructor;
    private javax.swing.JLabel lblLugar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JLabel lblPrograma;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAlumno;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDesc;
    private javax.swing.JPanel pnlDetalles;
    private javax.swing.JPanel pnlId;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlTicket;
    private javax.swing.JPanel pnlVacio;
    private javax.swing.JTable tblTalleres;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdAlumno;
    private javax.swing.JTextArea txtTicket;
    // End of variables declaration//GEN-END:variables
}
