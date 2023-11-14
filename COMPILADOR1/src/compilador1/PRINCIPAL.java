/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package compilador1;

import GRAMATICA.GRAMATICA;
import Metodos.PROC_CODIGO;
import OBJETOS_TABLA.OBJETO_T;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LMC Alumno
 */
public class PRINCIPAL extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public PRINCIPAL() {
        initComponents();
        Modelo1.addColumn("ID");
        Modelo1.addColumn("LEXEMA");
        Modelo1.addColumn("TOKEN");
        TABLA.setModel(Modelo1);

        Modelo2.addColumn("LINEA");
        Modelo2.addColumn("TIPO");
        Modelo2.addColumn("ERROR");
        Modelo2.addColumn("DESCRIPCION");
        TABLA2.setModel(Modelo2);
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
        TXTCODIGODEPURADO = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TXTAREAINPUT = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnANALIZAR = new javax.swing.JButton();
        BTNBUSCAR = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLA = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABLA2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TXTCODIGODEPURADO.setColumns(20);
        TXTCODIGODEPURADO.setRows(5);
        jScrollPane1.setViewportView(TXTCODIGODEPURADO);

        TXTAREAINPUT.setColumns(20);
        TXTAREAINPUT.setRows(5);
        TXTAREAINPUT.setText("package x;\npublic class MethodExample {\n    public static void main(String[] args) {\n        // Llamada al método\n        greet(\"Mariana\");\n        int resultado = sum(5, 3);\n    }\n\n    // Método que imprime un saludo\n    static void greet(String nombre) {\n    }\n\n    // Método que retorna la suma de dos números\n    static int sum(int a, int b) {\n        return a + b;\n    }\n}\n");
        jScrollPane2.setViewportView(TXTAREAINPUT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("INPUT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("CODIGO DEPURADO");

        btnANALIZAR.setText("ANALIZAR");
        btnANALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnANALIZARActionPerformed(evt);
            }
        });

        BTNBUSCAR.setText("BUSCAR");
        BTNBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBUSCARActionPerformed(evt);
            }
        });

        TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "LEXEMA", "TOKEN"
            }
        ));
        jScrollPane3.setViewportView(TABLA);
        if (TABLA.getColumnModel().getColumnCount() > 0) {
            TABLA.getColumnModel().getColumn(0).setResizable(false);
            TABLA.getColumnModel().getColumn(1).setResizable(false);
            TABLA.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("TABLA DE SIMBOLOS");

        TABLA2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "LINEA", "TIPO", "ERROR", "DESCRIPCION"
            }
        ));
        jScrollPane4.setViewportView(TABLA2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnANALIZAR, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(BTNBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BTNBUSCAR, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnANALIZAR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DefaultTableModel Modelo1 = new DefaultTableModel();
    DefaultTableModel Modelo2 = new DefaultTableModel();

    private void btnANALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANALIZARActionPerformed
        PROC_CODIGO A = new PROC_CODIGO();
        GRAMATICA GRAMATICA = new GRAMATICA();
        try {
            Modelo1.addColumn("ID");
            Modelo1.addColumn("LEXEMA");
            Modelo1.addColumn("TOKEN");
            TABLA.setModel(Modelo1);
            String Codigo = TXTAREAINPUT.getText();
            String CodigoDepu = A.depurarCodigo(Codigo);
            TXTCODIGODEPURADO.setText(A.Agregar(A.getEspacios(), CodigoDepu));
            // TXTCODIGODEPURADO.setText(CodigoDepu);
            String[] b = A.DIVIDIRCODIGO(A.depurarCodigo(Codigo));
            ArrayList<String> c = A.DIVIDIRFINAL(b);
            ArrayList<OBJETO_T> LISTAT = A.CLASIFICAR(c);
            LLENARTABLA(LISTAT);

            GRAMATICA.VALIDAR_PCK(LISTAT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e);
        }

    }//GEN-LAST:event_btnANALIZARActionPerformed

    private void BTNBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBUSCARActionPerformed
        try {
            JFileChooser BuscadorA = new JFileChooser();
            BuscadorA.showOpenDialog(null);
            File archivo = new File(BuscadorA.getSelectedFile().getAbsolutePath());
            if (!archivo.equals(null)) {
                try {
                    String Archivo = new String(Files.readAllBytes(archivo.toPath()));
                    TXTAREAINPUT.setText(Archivo);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARCHIVO" + ex);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + ex);
                }
            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
    }//GEN-LAST:event_BTNBUSCARActionPerformed
    public void LLENARTABLA(ArrayList<OBJETO_T> LISTAT) {
        int id = 1;
        for (OBJETO_T O : LISTAT) {
            String ID = String.valueOf(id);
            if (O.getTOKEN() == "IDU") {
                String Objeto[] = {ID, O.getLexema(), O.getTOKEN()};
                id++;
                Modelo1.addRow(Objeto);
            } else {
                String Objeto2[] = {null, O.getLexema(), O.getTOKEN()};
                Modelo1.addRow(Objeto2);
            }
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
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNBUSCAR;
    private javax.swing.JTable TABLA;
    private javax.swing.JTable TABLA2;
    private javax.swing.JTextArea TXTAREAINPUT;
    private javax.swing.JTextArea TXTCODIGODEPURADO;
    private javax.swing.JButton btnANALIZAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
