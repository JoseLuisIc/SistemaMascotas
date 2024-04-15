package sistemamascotas;

import Controlador.ControllerCanes;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Timestamp;
import java.util.Date;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo Adrian Delgadillo Rivera 6*A T/V
 */
public class PnlFondo extends javax.swing.JPanel {
    private JFrame jFramePadre;
    Controlador.ControllerCanes cc = new ControllerCanes();
    public String columnas[] = new String[] {"IdCan","Nombre","Raza","Color","Patron","Genero","Tamaño","Caracteristicas","Observaciones","FechaIngreso","FechaSalida"};
    DefaultTableModel modeloCan;
    private String nombreCanAux;
    private String razaCanAux;
    private String colorCanAux;
    private String patronCanAux;
    private String generoCanAux;
    private String tamaCanAux;
    private String caracteristicasCanAux;
    private String observacionesCanAux;
    private Timestamp fechaInicioAux;
    private Timestamp fechaFinAux;
    private int idSeleccion;
    
    /** Creates new form PnlFondo */
    public PnlFondo() {
        cc.openConnection();
        modeloCan = cc.modeloCan(columnas);
        cc.closeConnection();
        initComponents();
        this.setSize(600, 800);
        
        tablaCan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tablaCan.rowAtPoint(evt.getPoint());
                int col = 0;
                if (row >= 0 && col >= 0) {
                    String valor = tablaCan.getModel().getValueAt(row, col).toString(); //Tomo el valor de el modelo de la tabla
                    idSeleccion = Integer.parseInt(valor); //Obtengo el valor del textfield
                    //System.out.println(idSeleccion);
                }
            }
        });
       // Icon imgBoton = new ImageIcon(getClass().
        //        getResource("/los/imagen/Connecting.gif"));
        //btnIngresar.setIcon(imgBoton);
        ButtonGroup G = new ButtonGroup();
        G.add(btnFem);
        G.add(btnMasc);
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        //System.out.println("paintComponent");
        Dimension tamanio = getSize();        
        ImageIcon imagenFondo = new ImageIcon(getClass().
                getResource("/sistemamascotas/media/fondomascota.jpg"));
        g.drawImage(imagenFondo.getImage(), 0, 0, 
                tamanio.width, tamanio.height, null);
        setOpaque(false);
        
        super.paintComponent(g);
    }
    void limpiarPanel(){
        nombreCan.setText("");
        razaCan.setText("");
        colorCan.setText("");
        patronCan.setText("");
        tamCan.setText("");
        caracteristicasCan.setText("");
        observacionesCan.setText("");
        fechaIngreso.setDate(new Date());
        fechaSalida.setDate(new Date());
        nomCanBuscar.setText("");
    }
    int validarInformacionDelPanel(){
        
        nombreCanAux = nombreCan.getText();
        if(nombreCanAux.isEmpty()){
            JOptionPane.showMessageDialog(this, "El nombre del Can,está vacío.");
            return 0;
        
        }
        
        razaCanAux = razaCan.getText();
        if(razaCanAux.isEmpty()){
            JOptionPane.showMessageDialog(this, "La raza del Can,está vacío.");
            return 0;
        
        }
        
        colorCanAux = colorCan.getText();
        if(colorCanAux.isEmpty()){
            JOptionPane.showMessageDialog(this, "El color del Can,está vacío.");
            return 0;
        }
        patronCanAux = patronCan.getText();
        if(patronCanAux.isEmpty()){
            JOptionPane.showMessageDialog(this, "El patron del Can,está vacío.");
            return 0;
        }
        
        tamaCanAux = tamCan.getText();
        if(tamaCanAux.isEmpty()){
            JOptionPane.showMessageDialog(this, "El tamaño del Can,está vacío.");
            return 0;
        }
        
        caracteristicasCanAux = caracteristicasCan.getText();     
        if(caracteristicasCanAux.isEmpty()){
            JOptionPane.showMessageDialog(this, "Las características del Can,está vacío.");
            return 0;
        }
        
        observacionesCanAux = observacionesCan.getText();
        if(observacionesCanAux.isEmpty()){
            JOptionPane.showMessageDialog(this, "Las observaciones del Can,está vacío.");
            return 0;
        }
        
        fechaInicioAux = getTimestamp(fechaIngreso.getDate());
        if(fechaInicioAux == null){
            JOptionPane.showMessageDialog(this, "Es necesario añadir una fecha inicio de ingreso.");
            return 0;
        }
        fechaFinAux = getTimestamp(fechaSalida.getDate());
        if(fechaFinAux == null){
            JOptionPane.showMessageDialog(this, "Es necesario añadir una fecha fin de salida.");
            return 0;
        }
        
        if(btnFem.isSelected()){
            generoCanAux = "Hembra";
        }
        else{
            if(btnMasc.isSelected()){
                generoCanAux = "Macho";
            }
            else{
                
                JOptionPane.showMessageDialog(this, "Es necesario seleccionar un genero.");
                return 0;
            }
        }
        return 1;
    }
    public Timestamp getTimestamp(java.util.Date date){ return date == null ? null : new java.sql.Timestamp(date.getTime()); }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreCan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        caracteristicasCan = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnFem = new javax.swing.JRadioButton();
        btnMasc = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacionesCan = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        fechaSalida = new com.toedter.calendar.JCalendar();
        fechaIngreso = new com.toedter.calendar.JCalendar();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        nomCanBuscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        razaCan = new javax.swing.JTextField();
        colorCan = new javax.swing.JTextField();
        patronCan = new javax.swing.JTextField();
        tamCan = new javax.swing.JTextField();

        nombreCan.setColumns(12);
        nombreCan.setToolTipText("Nombre");

        jLabel1.setText("Nombre del Can");

        jLabel2.setText("Raza del Can");

        jLabel3.setText("Color(es) del Can");

        jLabel4.setText("Patron(es) de pelaje del Can");

        caracteristicasCan.setColumns(20);
        caracteristicasCan.setRows(5);
        caracteristicasCan.setToolTipText("Caracteristicas");
        jScrollPane1.setViewportView(caracteristicasCan);

        jLabel5.setText("Características distintivas del Can");

        btnFem.setText("Hembra");

        btnMasc.setText("Macho");

        jLabel6.setText("Genero del Can");

        jLabel7.setText("Tamaño del Can");

        jLabel8.setText("Imagenes Canes");

        observacionesCan.setColumns(20);
        observacionesCan.setRows(5);
        observacionesCan.setToolTipText("Observaciones");
        jScrollPane2.setViewportView(observacionesCan);

        jLabel9.setText("Observaciones del Can");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemamascotas/media/canes.jpg"))); // NOI18N

        jLabel11.setText("Fecha Ingreso");

        jLabel12.setText("Fecha Salida");

        tablaCan.setModel(modeloCan);
        jScrollPane3.setViewportView(tablaCan);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel13.setText("Escriba el nombre del Can a Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(112, 112, 112)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomCanBuscar)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnVer)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(nomCanBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        razaCan.setColumns(12);
        razaCan.setToolTipText("Raza");

        colorCan.setColumns(12);
        colorCan.setToolTipText("Colores");

        patronCan.setColumns(12);
        patronCan.setToolTipText("Patrones");

        tamCan.setColumns(12);
        tamCan.setToolTipText("Tamaño");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(210, 210, 210))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombreCan)
                                    .addComponent(razaCan)
                                    .addComponent(colorCan)
                                    .addComponent(patronCan))
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(btnMasc)
                                    .addComponent(btnFem)
                                    .addComponent(jLabel7)
                                    .addComponent(tamCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addGap(80, 80, 80)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fechaSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombreCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMasc))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(btnFem))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(razaCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(colorCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tamCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(patronCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel12)))))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        
        int v= validarInformacionDelPanel();
        if(v==1){
            cc.openConnection();
            Can objCan = new Can();
            objCan.setNombreCan(nombreCanAux);
            objCan.setRazaCan(razaCanAux);
            objCan.setCaracteristicasCan(caracteristicasCanAux);
            objCan.setColorCan(colorCanAux);
            objCan.setGeneroCan(generoCanAux);
            objCan.setObservacionesCan(observacionesCanAux);
            objCan.setPatronCan(patronCanAux);
            objCan.setTamaCan(tamaCanAux);
            objCan.setFechaInicio(fechaInicioAux);
            objCan.setFechaFin(fechaFinAux);
            int i = cc.insertCan(objCan);

            if(i==1){
                JOptionPane.showMessageDialog(this, "El Can se guardo con éxito.");
                limpiarPanel();
            }
            else{
                JOptionPane.showMessageDialog(this, "Ocurrio un error, valida tu información ingresada.");
            }
            modeloCan = cc.modeloCan(columnas);
            cc.closeConnection();
            tablaCan.setModel(modeloCan);
            modeloCan.fireTableDataChanged();
        }else{
            JOptionPane.showMessageDialog(this,"Añade la información completa para guardar el Can");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        if(idSeleccion>0){
            cc.openConnection();
            Can objCan = cc.getCan(idSeleccion);
            nombreCan.setText(objCan.getNombreCan());
            razaCan.setText(objCan.getRazaCan());
            colorCan.setText(objCan.getColorCan());
            patronCan.setText(objCan.getPatronCan());
            tamCan.setText(objCan.getTamaCan());
            caracteristicasCan.setText(objCan.getCaracteristicasCan());
            observacionesCan.setText(objCan.getObservacionesCan());
            fechaIngreso.setDate(objCan.getFechaInicio());
            fechaSalida.setDate(objCan.getFechaFin());
            //nomCanBuscar.setText("");
            if("Hembra".equals(objCan.getGeneroCan())){
                btnFem.setSelected(true);
            }
            else{
                if("Macho".equals(objCan.getGeneroCan())){
                    btnMasc.setSelected(true);
                }
                else{
                    JOptionPane.showMessageDialog(this, "No se selecciono el genero probablemente no exista en la base de datos, pero puedes seleccionar uno nuevo para continuar.");
                }
            }
            cc.closeConnection();
        }
        else{
            JOptionPane.showMessageDialog(this, "Selecciona un Can para mostrar su información en el Panel");
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        cc.openConnection();
        if(idSeleccion>0){
            cc.deleteCan(idSeleccion);
            JOptionPane.showMessageDialog(this, "El Can seleccionado, fue eliminado con éxito");
        }
        else{
            JOptionPane.showMessageDialog(this, "Selecciona el Can a eliminar.");
        }
        modeloCan = cc.modeloCan(columnas);
        cc.closeConnection();
        tablaCan.setModel(modeloCan);
        modeloCan.fireTableDataChanged();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarPanel();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        cc.openConnection();
        if(!nomCanBuscar.getText().isEmpty()){
            
            modeloCan = cc.modeloCan(columnas,nomCanBuscar.getText());
            tablaCan.setModel(modeloCan);
            modeloCan.fireTableDataChanged();
        }
        else{
            modeloCan = cc.modeloCan(columnas);
            tablaCan.setModel(modeloCan);
            modeloCan.fireTableDataChanged();
            JOptionPane.showMessageDialog(this, "Escribe el nombre que deseas buscar.");
        }
        cc.closeConnection();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int v= validarInformacionDelPanel();
        if(v==1){
        cc.openConnection();
        if(idSeleccion>0){
            Can objCan = new Can();
            objCan.setNombreCan(nombreCanAux);
            objCan.setRazaCan(razaCanAux);
            objCan.setCaracteristicasCan(caracteristicasCanAux);
            objCan.setColorCan(colorCanAux);
            objCan.setGeneroCan(generoCanAux);
            objCan.setObservacionesCan(observacionesCanAux);
            objCan.setPatronCan(patronCanAux);
            objCan.setTamaCan(tamaCanAux);
            objCan.setFechaInicio(fechaInicioAux);
            objCan.setFechaFin(fechaFinAux);
            int i = cc.editCan(objCan,idSeleccion);
            if(i==1){
                JOptionPane.showMessageDialog(this, "El Can se actualizo con éxito.");
            }
            else{
                JOptionPane.showMessageDialog(this, "El Can no se actualizo con éxito.");
            }
            
            modeloCan = cc.modeloCan(columnas);
            tablaCan.setModel(modeloCan);
            modeloCan.fireTableDataChanged();
            limpiarPanel();
        }
        else{
            JOptionPane.showMessageDialog(this, "Selecciona el Can y después el boton 'Ver', para mostrar la información a actualizar");
        }
        cc.closeConnection();
        }
        else{
            JOptionPane.showMessageDialog(this, "Añade la información completa para actualizar el Can");
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JRadioButton btnFem;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JRadioButton btnMasc;
    private javax.swing.JButton btnVer;
    private javax.swing.JTextArea caracteristicasCan;
    private javax.swing.JTextField colorCan;
    private com.toedter.calendar.JCalendar fechaIngreso;
    private com.toedter.calendar.JCalendar fechaSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomCanBuscar;
    private javax.swing.JTextField nombreCan;
    private javax.swing.JTextArea observacionesCan;
    private javax.swing.JTextField patronCan;
    private javax.swing.JTextField razaCan;
    private javax.swing.JTable tablaCan;
    private javax.swing.JTextField tamCan;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jFramePadre
     */
    public JFrame getjFramePadre() {
        return jFramePadre;
    }

    /**
     * @param jFramePadre the jFramePadre to set
     */
    public void setjFramePadre(JFrame jFramePadre) {
        this.jFramePadre = jFramePadre;
    }
    
}
