/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.campo;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import poo.campo.dao.estadocampodao;
import poo.campo.dao.campodao;
import javax.swing.table.DefaultTableModel;
import poo.campo.ui.Estadocampo;
import poo.campo.ui.Tiposuelo;
import poo.campo.dao.tiposuelodao;
import poo.campo.ui.Lote;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import poo.campo.dao.lotedao;
import poo.campo.ui.Campo;
import poo.campo.ui.Estadoproyecto;
import poo.campo.ui.Lote;
import poo.campo.ui.Proyectolaboreo;

/**
 *
 * @author Normal
 */
public class JFCampo extends javax.swing.JFrame {
    private ArrayList<Lote> arrlote;
    /**
     * Creates new form JFCampo
     */
    
    public void setTipoSuelo(Tiposuelo ts) {
        jComboTipoSuelo.setSelectedItem(ts);
    }   
    
    public JFCampo() {
        initComponents();
        cargarEstados(0);
        cargarTipoSuelos(0);
        limpiarTabla(JTLotes);
        jTextField2.setText("0");

       }
    public void cargarEstados(int busca){
        Estadocampo ep = new Estadocampo();
        ep.mostrarEstadoCampo(jComboEstado);  
    }
    public void cargarTipoSuelos(int busca){
        Tiposuelo ts = new Tiposuelo();
        ts.mostrarTiposuelo(jComboTipoSuelo);         
    }

   public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) JTLotes.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
   
    private boolean validaSuperficie(){
    boolean exito=true;
        int superficie=0;
        int val;
        int filas=JTLotes.getRowCount(); 
        int supIngresa,supCampo;
        supCampo=Integer.parseInt(jTextField2.getText());	
        supIngresa=Integer.parseInt(jTextField4.getText());
        superficie=supIngresa;
        if (supIngresa>supCampo)exito=false;
        else{
            if (filas==0) {
                exito=true;        
            }else
            {
            int cols = JTLotes.getColumnCount();
            int fils = JTLotes.getRowCount();

                for(int i=0; i<fils; i++) {
                    if (exito==true){                    
                        val = Integer.valueOf((String) JTLotes.getValueAt(i,1));
                        superficie=superficie+val;                        
                        if (supCampo >= superficie)  exito=true;
                        else exito=false;
                    }    
                }               
            }
        }    
         return exito;
    }
    private boolean validaSuperficieGuardar(){
    boolean exito=true;
        int superficie=0;
        int val;
        int filas=JTLotes.getRowCount(); 
        int supCampo;
        supCampo=Integer.parseInt(jTextField2.getText());       
            if (filas==0) {
                exito=true;        
            }else
            {
            int cols = JTLotes.getColumnCount();
            int fils = JTLotes.getRowCount();

                for(int i=0; i<fils; i++) {
                    if (exito==true){                    
                        val = Integer.valueOf((String) JTLotes.getValueAt(i,1));
                        superficie=superficie+val;                        
                        if (supCampo >= superficie)  exito=true;
                        else exito=false;
                    }    
                }               
            }            
         return exito;
    }
    private boolean ValidaNrolote(){
        boolean exito=true;
        int nrocampo;
        int val;
        int filas=JTLotes.getRowCount();    
        
        if (filas==0) {
            exito=true;        
        }else
        {
        int cols = JTLotes.getColumnCount();
        int fils = JTLotes.getRowCount();
        
            for(int i=0; i<fils; i++) {
                if (exito==true){
                    nrocampo=Integer.parseInt(jTextField3.getText());	
                    val = Integer.valueOf((String) JTLotes.getValueAt(i,0));
                  //  System.out.println(nrocampo);
                  //  System.out.println(val);
                    if (val == nrocampo)  exito=false;
                    else exito=true;
                }    
            }               
        }
         return exito;
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
        jTable1 = new javax.swing.JTable();
        jComboEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTLotes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboTipoSuelo = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jbtnEditar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione el estado");

        jLabel2.setText("Nombre");

        jLabel3.setText("Superficie");

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setForeground(new java.awt.Color(0, 153, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REGISTRAR CAMPOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        JTLotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nro Lote", "Superficie", "Descripcion", "Tipo Suelo", "idTipoSuelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTLotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTLotesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTLotes);

        jLabel5.setBackground(new java.awt.Color(0, 153, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("REGISTRAR LOTES");

        jLabel6.setText("Nro:");

        jLabel7.setText("Superficie:");

        jLabel8.setText("Tipo Suelo:");

        jTextField4.setName(""); // NOI18N

        jLabel9.setText("Descripción:");

        jbtnEditar.setText("Editar");
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnEliminar.setText("Quitar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(29, 29, 29)
                        .addComponent(jComboTipoSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(43, 43, 43)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(350, 350, 350))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jbtnAgregar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbtnEditar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbtnEliminar))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboTipoSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnEditar)
                    .addComponent(jbtnEliminar)
                    .addComponent(jbtnAgregar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton1.setText("Registra campo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("REPORTE CAMPO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       dispose();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        int filaseleccionada = JTLotes.getSelectedRow();
        int val;
        val=jComboTipoSuelo.getItemAt(jComboTipoSuelo.getSelectedIndex()).getIdtiposuelo();

                String valor=String.valueOf(val);
                JTLotes.setValueAt(jTextField3.getText(), filaseleccionada, 0);
                JTLotes.setValueAt(jTextField4.getText(), filaseleccionada, 1);
                JTLotes.setValueAt(jTextField5.getText(), filaseleccionada, 2);
                JTLotes.setValueAt(jComboTipoSuelo.getSelectedItem().toString(), filaseleccionada, 3);
                JTLotes.setValueAt(valor, filaseleccionada, 4);

                limpiarCampos();      
        
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void  limpiarCampos(){
     jTextField3.setText("");
     jTextField4.setText("");
     jTextField5.setText("");
            }
    
    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        int supCampo,idtiposuelo;        
        String tiposuelo;
        supCampo=Integer.parseInt(jTextField2.getText());
        tiposuelo=jComboTipoSuelo.getSelectedItem().toString();
        idtiposuelo=jComboTipoSuelo.getItemAt(jComboTipoSuelo.getSelectedIndex()).getIdtiposuelo();     
        if (supCampo==0){
            JOptionPane.showMessageDialog(null, "La superficie del campo debe ser mayor a 0");}
        else{
                if (validaSuperficie()==true){
                    if (ValidaNrolote()==true) {  
                        DefaultTableModel modelo = (DefaultTableModel) JTLotes.getModel();    
                        Object [] registros = new Object [5];
                        registros[0] = jTextField3.getText();
                        registros[1] = jTextField4.getText();
                        registros[2] = jTextField5.getText();
                        registros[3] = tiposuelo;
                        registros[4] = idtiposuelo;
                        modelo.addRow(registros);
                        JTLotes.setModel(modelo);  
                        limpiarCampos();
                    }

                    else{JOptionPane.showMessageDialog(null, "Nro lote duplicado");
                        }
                }
                else {JOptionPane.showMessageDialog(null, "La suma de superficies de lotes, excede al campo");
                        }
        }    
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
          DefaultTableModel modelo = (DefaultTableModel) JTLotes.getModel(); 
          int a = JTLotes.getSelectedRow(); 
          if (a<0){  
                JOptionPane.showMessageDialog(null,"Debe seleccionar una fila de la tabla" );  
         }else {
            int confirmar=JOptionPane.showConfirmDialog(null,"Esta seguro que desea Eliminar el registro? "); 
        if(JOptionPane.OK_OPTION==confirmar) {                     
                   modelo.removeRow(a); 
                   JOptionPane.showMessageDialog(null,"Registro Eliminado" );
 
            } 
 
        } 
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void JTLotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTLotesMouseClicked
        int filaseleccionada;
        int val;
        String sval;
            //Guardamos en un entero la fila seleccionada.
            filaseleccionada = JTLotes.getSelectedRow();
            if (filaseleccionada == -1){
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
            } else {
                sval=((String)JTLotes.getValueAt(filaseleccionada, 0));
                jTextField3.setText(sval); 
                sval=((String)JTLotes.getValueAt(filaseleccionada, 1));
                jTextField4.setText(sval);       
                sval=((String)JTLotes.getValueAt(filaseleccionada, 2));
                jTextField5.setText(sval);   
                sval=((String)JTLotes.getValueAt(filaseleccionada, 3));   
                jComboTipoSuelo.setSelectedItem(sval);
            }
    }//GEN-LAST:event_JTLotesMouseClicked
    public int getEstadoCampo() {
        int id ;     
        id=jComboEstado.getItemAt(jComboEstado.getSelectedIndex()).getIdestadoCampo();  
	return id;                    
    }
   
    public void setTiposFuc(Estadocampo ec) {
	jComboEstado.setSelectedItem(ec);
    }
    private void guardar(){
        Campo c = new Campo(); //idcampo,descripcion,superficie,idestadoactivo
        int sup,id;
        boolean valor=true;
        Integer idcampo;
        sup=Integer.parseInt(jTextField2.getText());
        c.setDescripcion(jTextField1.getText());
        c.setSuperficie(sup);
        id=getEstadoCampo();
        c.setidestadocampo(id);
        c.setActivo(valor);

       // String resp = campodao.registrarCampo(c,arrlote);     
       idcampo=campodao.registrarCampo(c); 
       if (idcampo>0) CargarLotesdeMatriz(idcampo);   
       
    }
    
    private void CargarLotesdeMatriz(Integer idcampo){
        TableModel tablaL = JTLotes.getModel();        
        Integer sup=0;
        Integer nro=0;  
        Integer val=0;
        String desc,suelo,valorid;
        
        for (int i = 0; i < tablaL.getRowCount(); i++) {
            String sfecha;
            Lote lo = new Lote();
            nro =Integer.valueOf((String) tablaL.getValueAt(i,0)); 
            sup =Integer.valueOf((String) tablaL.getValueAt(i,1)); 
            desc=(String) tablaL.getValueAt(i,2);      
            suelo=(String) tablaL.getValueAt(i,3);
            valorid=tablaL.getValueAt(i, 4).toString();
            val =Integer.parseInt(valorid);
  
            lo.setNumero(nro);            
            lo.setDescripcion(desc);            
            lo.setSuperficie(sup);
            lo.setidTipoSuelo(val); 
            lo.setidCampo(idcampo);
            
            String resp = lotedao.registrarLote(lo); 
        }     
        JOptionPane.showMessageDialog(null, "EL CAMPO Y SUS LOTES FUERON REGISTRADOS CON EXITO");
        
    }        
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filas = JTLotes.getRowCount();
        int supCampo;
        supCampo=Integer.parseInt(jTextField2.getText());
        if (supCampo>0){
            if (filas>0){
                if (validaSuperficieGuardar()==false){
                    JOptionPane.showMessageDialog(null, "La suma de superficies de lotes excede el campo");
                  }
                else guardar();
           // if (validaCampo()==false){
           } else   
                JOptionPane.showMessageDialog(null, "Debe ingresar al menos un LOTE");
        } else   
                JOptionPane.showMessageDialog(null, "La superficie del CAMPO debe ser mayor a 0");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String sdir="C:\\Users\\Normal\\Documents\\NetBeansProjects\\AdministraCampo\\src\\Reportes\\JrCampos.jrxml"; 
            
            String a=campodao.VerReporte(sdir);
        } catch (JRException ex) {
            Logger.getLogger(JFCampo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JFCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCampo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCampo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTLotes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Estadocampo> jComboEstado;
    private javax.swing.JComboBox<Tiposuelo> jComboTipoSuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnEliminar;
    // End of variables declaration//GEN-END:variables

    private void setTiposuelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
