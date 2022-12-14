/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.progra2.p2bc11pokemon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author dual4
 */
public class VentanaPokedex extends javax.swing.JFrame {
    
    //fondo
//    FondoPanel fondo = new FondoPanel();
   
    //defino mis variables de instancia
    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;

    //variables para db
    Statement estado; // lleva el estado de la conexion.
    ResultSet resultadoConsulta;
    Connection conexion;

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenpokemon.getGraphics();

        g2.drawImage(buffer1, 0, 0, imagenpokemon.getWidth(), imagenpokemon.getHeight(), null);
        
        
        
    }

    public VentanaPokedex() {
        initComponents();
        
        idBuscar.selectAll();
        
//        this.setContentPane(fondo);

        try {
            imagen1 = ImageIO.read(new File("C:\\Users\\dual4\\Desktop\\datos\\imagenes\\black-white.png"));
        } catch (Exception e) {
            System.out.println("Hubo error en " + e.getMessage());
        }

        buffer1 = (BufferedImage) imagenpokemon.createImage(imagenpokemon.getWidth(), imagenpokemon.getHeight());

        dibujaElPokemonQueEstaEnLaPosicion(0);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL = "jdbc:mysql://localhost:3306/pokedex?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
            conexion = DriverManager.getConnection(JDBC_URL, "root", "Dual1020");
            estado = (Statement) conexion.createStatement();
        } catch (Exception e) {
            System.out.println("Error en:" + e.getMessage());
        }

    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenpokemon.getWidth(),
                imagenpokemon.getHeight());
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel 
                0, // posicion Y inicial dentro del jpanel
                imagenpokemon.getWidth(), //ancho del jpanel
                imagenpokemon.getHeight(), //alto del jpanel
                columna * 96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila * 96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna * 96 + 96, //posicion final X
                fila * 96 + 96, //posicion final Y
                null //si no lo pones no va
        );
        
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenpokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        nombrePokemon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        idBuscar = new javax.swing.JTextPane();
        buscar = new javax.swing.JButton();
        evolucion = new javax.swing.JLabel();
        especie = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        habitad = new javax.swing.JLabel();
        lbltext = new javax.swing.JLabel();
        lbltext1 = new javax.swing.JLabel();
        lbltext2 = new javax.swing.JLabel();
        lbltext3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setIconImages(null);

        javax.swing.GroupLayout imagenpokemonLayout = new javax.swing.GroupLayout(imagenpokemon);
        imagenpokemon.setLayout(imagenpokemonLayout);
        imagenpokemonLayout.setHorizontalGroup(
            imagenpokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenpokemonLayout.setVerticalGroup(
            imagenpokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        izq.setText("<= IZQ");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setText("DER =>");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        nombrePokemon.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePokemon.setText(" ");

        idBuscar.setText("Codigo a Buscar");
        jScrollPane1.setViewportView(idBuscar);

        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        evolucion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        especie.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        color.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        habitad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lbltext.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbltext.setText("Especie: ");

        lbltext1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbltext1.setText("Habitad:");

        lbltext2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbltext2.setText("Color:");

        lbltext3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbltext3.setText("Evolucion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombrePokemon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(imagenpokemon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltext2)
                                    .addComponent(lbltext1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltext)
                                    .addComponent(lbltext3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(habitad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(especie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(evolucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(color, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(imagenpokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(especie)
                            .addComponent(lbltext))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(habitad)
                            .addComponent(lbltext1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(color)
                            .addComponent(lbltext2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(evolucion)
                            .addComponent(lbltext3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombrePokemon)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izq)
                    .addComponent(der))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        nombrePokemon.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
       
        idBuscar.setText("Codigo a Buscar");
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            if (resultadoConsulta.next()) {
                nombrePokemon.setText(resultadoConsulta.getString(2));
                especie.setText(resultadoConsulta.getString(12));
                habitad.setText(resultadoConsulta.getString(15));
                color.setText(resultadoConsulta.getString(13));
                //evolucion.setText(R);
            } else {
                nombrePokemon.setText("Este pokemon no figura en la pokedex");
                especie.setText(" ");
                habitad.setText(" ");
                color.setText(" ");
            }
        } catch (SQLException ex) {
        }
        contador--;
        if (contador <= 0) {
            contador = 0;

        }
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        idBuscar.setText("Codigo a Buscar");
        dibujaElPokemonQueEstaEnLaPosicion(contador);

        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador + 1));
            if (resultadoConsulta.next()) {
                nombrePokemon.setText(resultadoConsulta.getString(2));
                especie.setText(resultadoConsulta.getString(12));
                habitad.setText(resultadoConsulta.getString(15));
                color.setText(resultadoConsulta.getString(13));
            } else {
                nombrePokemon.setText("Este pokemon no figura en la pokedex");
                especie.setText(" ");
                habitad.setText(" ");
                color.setText(" ");
            }
        } catch (SQLException ex) {
        }
        contador++;
        if (contador >= 649) {
            contador = 649;

        }
    }//GEN-LAST:event_derActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String id= idBuscar.getText();
        int ide = Integer.parseInt(id);
        dibujaElPokemonQueEstaEnLaPosicion(ide-1);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (id));
            if (resultadoConsulta.next()) {
                nombrePokemon.setText(resultadoConsulta.getString(2));
                especie.setText(resultadoConsulta.getString(12));
                habitad.setText(resultadoConsulta.getString(15));
                color.setText(resultadoConsulta.getString(13));
            } else {
                nombrePokemon.setText("Este pokemon no figura en la pokedex");
                especie.setText(" ");
                habitad.setText(" ");
                color.setText(" ");
            }
        } catch (SQLException ex) {
        }
       //   contador++;
//        if (contador >= 649) {
//            contador = 649;
//
//        }
    }//GEN-LAST:event_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JLabel color;
    private javax.swing.JButton der;
    private javax.swing.JLabel especie;
    private javax.swing.JLabel evolucion;
    private javax.swing.JLabel habitad;
    private javax.swing.JTextPane idBuscar;
    private javax.swing.JPanel imagenpokemon;
    private javax.swing.JButton izq;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltext;
    private javax.swing.JLabel lbltext1;
    private javax.swing.JLabel lbltext2;
    private javax.swing.JLabel lbltext3;
    private javax.swing.JLabel nombrePokemon;
    // End of variables declaration//GEN-END:variables

    


//    class FondoPanel extends JPanel{
//        private Image imagen;
//        
//        @Override
//        public void paint(Graphics g){
//            imagen = new ImageIcon(getClass().getResource("/imagenes/fondo1")).getImage();
//            
//            g.drawImage(imagen, 0,0, getWidth(), getHeight(), this);
//            
//            setOpaque(false);
//            
//            super.paint(g);
//            
//        
//        }
        
        
    //}

}
