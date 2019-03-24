package banksimulator;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;


/**
 *
 * @author Cristian Meoño 201801397
 */

public class AdminModule  {

    public JInternalFrame AdminFrame = new JInternalFrame("Modulo de Administracion", true, true, false, true);
    public JTabbedPane TabbedPane = new JTabbedPane();

    AdminModule() {

        AdminFrame.setVisible(true);
        AdminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AdminFrame.add(TabbedPane);

        //Panel 1 -- Clientes
        TabbedPane.addTab("Clientes", new ClientePanel());
        //Panel 2 -- Agencias
        TabbedPane.addTab("Agencias", new AgenciaPanel());
        //Panel 3 -- Agencias AutoBanco
        TabbedPane.addTab("Agencia - AutoBanco", new AgenciaAutoPanel());
        //Panel 4 -- Cajeros Automaticos
        TabbedPane.addTab("Cajero Automatico", new CajeroPanel());
        //Panel 5 -- Tarjeta Credito Sol.
        TabbedPane.addTab("Tarjetas de Credito", new TarjetaCreditoPanel());
        //Panel 6 -- Prestamos
        TabbedPane.addTab("Prestamos", new PrestamosPanel());
        //Panel 7 -- Empleados
        TabbedPane.addTab("Empleados", new EmpleadosPanel());
        //Panel 8 -- Reportes
        TabbedPane.addTab("Reportes", new ReportesPanel());

    }

    class ClientePanel extends JPanel implements ActionListener   {

        JButton okBtn = new JButton();

        JLabel titleRbtn = new JLabel();
        JLabel id = new JLabel();
        JLabel nombre = new JLabel();
        JLabel direccion = new JLabel();
        JLabel telefono = new JLabel();
        JLabel ctsahorro = new JLabel();
        JLabel ctsmonetarias = new JLabel();
        JLabel prestamos = new JLabel();
        JLabel tjtcredito = new JLabel();
        JLabel transacciones = new JLabel();
                   
        JFormattedTextField idCliente = new JFormattedTextField(new Integer(0));
        JFormattedTextField nombreCliente = new JFormattedTextField(new String(""));
        JFormattedTextField direccionCliente = new JFormattedTextField();
        JFormattedTextField telefonoCliente = new JFormattedTextField(Data.getMask("####-####"));
        JFormattedTextField ctsahorroCliente = new JFormattedTextField();
        JFormattedTextField ctsmonetariasCliente = new JFormattedTextField();
        JFormattedTextField prestamosCliente = new JFormattedTextField();
        JFormattedTextField tjtcreditoCliente = new JFormattedTextField();
        JFormattedTextField transaccionesCliente = new JFormattedTextField();

        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();

        ButtonGroup GroupRbtn = new ButtonGroup();
        // Vector auxiliar
        String[] auxVector = new String[9];

        ClientePanel() {

            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);

            GridBagConstraints Const = new GridBagConstraints();

            //CONSTANTES
            //------------------
            Const.weightx = 0.0;
            Const.weighty = 0.0;
            Const.insets = new Insets(5, 5, 5, 5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------

            //RADIO BUTTONS
            Const.gridx = 0;
            Const.gridy = 0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 4;
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 5;
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);

            //CAMPOS  
            Const.insets = new Insets(5, 75, 5, 0);

            Const.gridx = 1;
            Const.gridy = 1;
            id.setText("ID");
            this.add(id, Const);

            Const.gridx = 1;
            Const.gridy = 2;
            nombre.setText("Nombre: ");
            this.add(nombre, Const);

            Const.gridx = 1;
            Const.gridy = 3;
            direccion.setText("Direccion: ");
            this.add(direccion, Const);

            Const.gridx = 1;
            Const.gridy = 4;
            telefono.setText("Telefono: ");
            this.add(telefono, Const);

            Const.gridx = 1;
            Const.gridy = 5;
            ctsahorro.setText("Cuentas de Ahorro: ");
            this.add(ctsahorro, Const);

            Const.gridx = 1;
            Const.gridy = 6;
            ctsmonetarias.setText("Cuentas Monetarias: ");
            this.add(ctsmonetarias, Const);

            Const.gridx = 1;
            Const.gridy = 7;
            prestamos.setText("Prestamos");
            this.add(prestamos, Const);

            Const.gridx = 1;
            Const.gridy = 8;
            tjtcredito.setText("Tarjetas de Credito: ");
            this.add(tjtcredito, Const);

            Const.gridx = 1;
            Const.gridy = 9;
            transacciones.setText("Transacciones: ");
            this.add(transacciones, Const);

            //TEXT FIELD
            Const.gridx = 2;
            Const.gridy = 1;
            idCliente.setPreferredSize(new Dimension(200, 20));
            this.add(idCliente, Const);

            Const.gridx = 2;
            Const.gridy = 2;
            nombreCliente.setPreferredSize(new Dimension(200, 20));
            this.add(nombreCliente, Const);

            Const.gridx = 2;
            Const.gridy = 3;
            direccionCliente.setPreferredSize(new Dimension(200, 20));
            this.add(direccionCliente, Const);

            Const.gridx = 2;
            Const.gridy = 4;
            telefonoCliente.setPreferredSize(new Dimension(200, 20));
            this.add(telefonoCliente, Const);

            Const.gridx = 2;
            Const.gridy = 5;
            ctsahorroCliente.setPreferredSize(new Dimension(200, 20));
            ctsahorroCliente.setText("");
            ctsahorroCliente.setEnabled(false);
            this.add(ctsahorroCliente, Const);

            Const.gridx = 2;
            Const.gridy = 6;
            ctsmonetariasCliente.setPreferredSize(new Dimension(200, 20));
            ctsmonetariasCliente.setText("");
            ctsmonetariasCliente.setEnabled(false);
            this.add(ctsmonetariasCliente, Const);

            Const.gridx = 2;
            Const.gridy = 7;
            prestamosCliente.setPreferredSize(new Dimension(200, 20));
            prestamosCliente.setText("");
            prestamosCliente.setEnabled(false);
            this.add(prestamosCliente, Const);
            
            Const.gridx = 2;
            Const.gridy = 8;
            tjtcreditoCliente.setPreferredSize(new Dimension(200, 20));
            tjtcreditoCliente.setText("");
            tjtcreditoCliente.setEnabled(false);
            this.add(tjtcreditoCliente, Const);           

            Const.gridx = 2;
            Const.gridy = 9;
            transaccionesCliente.setPreferredSize(new Dimension(200, 20));
            transaccionesCliente.setText("0");
            transaccionesCliente.setEnabled(false);
            this.add(transaccionesCliente, Const);

            Const.gridx = 2;
            Const.gridy = 12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn, Const);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (delRbtn.isSelected()) {

                if (Data.checkPK(idCliente.getText(), Data.ClientesMtx, Data.ClientesMtxCounter)) {
                    Data.ClientesMtx = Data.delReg(idCliente.getText(), Data.ClientesMtx, Data.ClientesMtxCounter);
                    Data.ClientesMtxCounter--;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ID no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

                Data.printMtx(Data.ClientesMtx);

            } else if (addRbtn.isSelected()) {

                auxVector[0] = idCliente.getText();
                auxVector[1] = nombreCliente.getText();
                auxVector[2] = direccionCliente.getText();
                auxVector[3] = telefonoCliente.getText();
                auxVector[4] = ctsahorroCliente.getText();
                auxVector[5] = ctsmonetariasCliente.getText();
                auxVector[6] = prestamosCliente.getText();
                auxVector[7] = tjtcreditoCliente.getText();
                auxVector[8] = transaccionesCliente.getText();

                Data.addReg(auxVector, Data.ClientesMtx, Data.ClientesMtxCounter);

                if (!Data.checkPK(idCliente.getText(), Data.ClientesMtx, Data.ClientesMtxCounter)) {
                    Data.ClientesMtxCounter++;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                }

                Data.printMtx(Data.ClientesMtx);

            } else if (editRbtn.isSelected()) {

                auxVector[0] = idCliente.getText();
                auxVector[1] = nombreCliente.getText();
                auxVector[2] = direccionCliente.getText();
                auxVector[3] = telefonoCliente.getText();
                auxVector[4] = ctsahorroCliente.getText();
                auxVector[5] = ctsmonetariasCliente.getText();
                auxVector[6] = prestamosCliente.getText();
                auxVector[7] = tjtcreditoCliente.getText();
                auxVector[8] = transaccionesCliente.getText();
                Data.ClientesMtx = Data.editReg(idCliente.getText(), auxVector, Data.ClientesMtx, Data.ClientesMtxCounter);

            } else if (readRbtn.isSelected()) {

                auxVector = Data.readReg(idCliente.getText(), Data.ClientesMtx, Data.ClientesMtxCounter);
                idCliente.setText(auxVector[0]);
                nombreCliente.setText(auxVector[1]);
                direccionCliente.setText(auxVector[2]);
                telefonoCliente.setText(auxVector[3]);
                ctsahorroCliente.setText(auxVector[4]);
                ctsmonetariasCliente.setText(auxVector[5]);
                prestamosCliente.setText(auxVector[6]);
                tjtcreditoCliente.setText(auxVector[7]);
                transaccionesCliente.setText(auxVector[8]);

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        // Habilita campos
        public void enabledFields() {

            idCliente.setEnabled(true);
            nombreCliente.setEnabled(true);
            direccionCliente.setEnabled(true);
            telefono.setEnabled(true);
            ctsahorroCliente.setEnabled(true);
            ctsmonetariasCliente.setEnabled(true);
            prestamosCliente.setEnabled(true);
            tjtcreditoCliente.setEnabled(true);
            transaccionesCliente.setEnabled(true);

        }

        //Deshabilita Campos
        public void disabledFields() {

            idCliente.setEnabled(true);
            nombreCliente.setEnabled(false);
            direccionCliente.setEnabled(false);
            telefono.setEnabled(false);
            ctsahorroCliente.setEnabled(false);
            ctsmonetariasCliente.setEnabled(false);
            prestamosCliente.setEnabled(false);
            tjtcreditoCliente.setEnabled(false);
            transaccionesCliente.setEnabled(false);

        }

    }

    class AgenciaPanel extends JPanel implements ActionListener {

        JButton okBtn = new JButton();

        JLabel titleRbtn = new JLabel();
        JLabel id = new JLabel();
        JLabel nombre = new JLabel();
        JLabel direccion = new JLabel();
        JLabel telefono = new JLabel();
        JLabel numcajas = new JLabel();
        JLabel numescritorios = new JLabel();
        JLabel efectivo = new JLabel();
        JLabel transac = new JLabel();

        JFormattedTextField idAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField nombreAgencia = new JFormattedTextField();
        JFormattedTextField direccionAgencia = new JFormattedTextField();
        JFormattedTextField telefonoAgencia = new JFormattedTextField(Data.getMask("####-####"));
        JFormattedTextField numcajasAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField numescritoriosAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField efectivoAgencia = new JFormattedTextField(new Double(0.00));
        JFormattedTextField numtransacAgencia = new JFormattedTextField();

        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();

        ButtonGroup GroupRbtn = new ButtonGroup();
        String[] auxVector = new String[8];

        AgenciaPanel() {
            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);

            GridBagConstraints Const = new GridBagConstraints();

            //CONSTANTES
            //------------------
            Const.weightx = 0.0;
            Const.weighty = 0.0;
            Const.insets = new Insets(5, 5, 5, 5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------

            //RADIO BUTTONS
            Const.gridx = 0;
            Const.gridy = 0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 4;
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 5;
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);

            //CAMPOS  
            Const.insets = new Insets(5, 75, 5, 0);

            Const.gridx = 1;
            Const.gridy = 1;
            id.setText("ID");
            this.add(id, Const);

            Const.gridx = 1;
            Const.gridy = 2;
            nombre.setText("Nombre: ");
            this.add(nombre, Const);

            Const.gridx = 1;
            Const.gridy = 3;
            direccion.setText("Direccion: ");
            this.add(direccion, Const);

            Const.gridx = 1;
            Const.gridy = 4;
            telefono.setText("Telefono: ");
            this.add(telefono, Const);

            Const.gridx = 1;
            Const.gridy = 5;
            numcajas.setText("Numero de Cajas: ");
            this.add(numcajas, Const);

            Const.gridx = 1;
            Const.gridy = 6;
            numescritorios.setText("Escritorios de Servicio al Cliente: ");
            this.add(numescritorios, Const);

            Const.gridx = 1;
            Const.gridy = 7;
            efectivo.setText("Efectivo");
            this.add(efectivo, Const);

            Const.gridx = 1;
            Const.gridy = 8;
            transac.setText("Numero de Transacciones");
            this.add(transac, Const);

            //TEXT FIELD
            Const.gridx = 2;
            Const.gridy = 1;
            idAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(idAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 2;
            nombreAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(nombreAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 3;
            direccionAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(direccionAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 4;
            telefonoAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(telefonoAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 5;
            numcajasAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(numcajasAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 6;
            numescritoriosAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(numescritoriosAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 7;
            efectivoAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(efectivoAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 8;
            numtransacAgencia.setPreferredSize(new Dimension(200, 20));
            numtransacAgencia.setText("0");
            numtransacAgencia.setEnabled(false);
            this.add(numtransacAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn, Const);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (delRbtn.isSelected()) {

                if (Data.checkPK(idAgencia.getText(), Data.AgenciasMtx, Data.AgenciasMtxCounter)) {
                    Data.AgenciasMtx = Data.delReg(idAgencia.getText(), Data.AgenciasMtx, Data.AgenciasMtxCounter);
                    Data.AgenciasMtxCounter--;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Agencia", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ID no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

                Data.printMtx(Data.AgenciasMtx);

            } else if (addRbtn.isSelected()) {

                auxVector[0] = idAgencia.getText();
                auxVector[1] = nombreAgencia.getText();
                auxVector[2] = direccionAgencia.getText();
                auxVector[3] = telefonoAgencia.getText();
                auxVector[4] = numcajasAgencia.getText();
                auxVector[5] = numescritoriosAgencia.getText();
                auxVector[6] = efectivoAgencia.getText();
                auxVector[7] = numtransacAgencia.getText();

                Data.addReg(auxVector, Data.AgenciasMtx, Data.AgenciasMtxCounter);

                if (!Data.checkPK(idAgencia.getText(), Data.AgenciasMtx, Data.AgenciasMtxCounter)) {
                    Data.AgenciasMtxCounter++;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Agencia", JOptionPane.INFORMATION_MESSAGE);
                }

                Data.printMtx(Data.AgenciasMtx);

            } else if (editRbtn.isSelected()) {

                auxVector[0] = idAgencia.getText();
                auxVector[1] = nombreAgencia.getText();
                auxVector[2] = direccionAgencia.getText();
                auxVector[3] = telefonoAgencia.getText();
                auxVector[4] = numcajasAgencia.getText();
                auxVector[5] = numescritoriosAgencia.getText();
                auxVector[6] = efectivoAgencia.getText();
                auxVector[7] = numtransacAgencia.getText();;
                Data.AgenciasMtx = Data.editReg(idAgencia.getText(), auxVector, Data.AgenciasMtx, Data.AgenciasMtxCounter);

            } else if (readRbtn.isSelected()) {

                auxVector = Data.readReg(idAgencia.getText(), Data.AgenciasMtx, Data.AgenciasMtxCounter);
                idAgencia.setText(auxVector[0]);
                nombreAgencia.setText(auxVector[1]);
                direccionAgencia.setText(auxVector[2]);
                telefonoAgencia.setText(auxVector[3]);
                numcajasAgencia.setText(auxVector[4]);
                numescritoriosAgencia.setText(auxVector[5]);
                efectivoAgencia.setText(auxVector[6]);
                numtransacAgencia.setText(auxVector[7]);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    class AgenciaAutoPanel extends JPanel implements ActionListener {

        JButton okBtn = new JButton();

        JLabel titleRbtn = new JLabel();
        JLabel id = new JLabel();
        JLabel nombre = new JLabel();
        JLabel direccion = new JLabel();
        JLabel telefono = new JLabel();
        JLabel numcajas = new JLabel();
        JLabel numescritorios = new JLabel();
        JLabel efectivo = new JLabel();
        JLabel cajasauto = new JLabel();
        JLabel transac = new JLabel();

        JFormattedTextField idAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField nombreAgencia = new JFormattedTextField();
        JFormattedTextField direccionAgencia = new JFormattedTextField();
        JFormattedTextField telefonoAgencia = new JFormattedTextField(Data.getMask("####-####"));
        JFormattedTextField numcajasAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField numescritoriosAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField efectivoAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField numautoAgencia = new JFormattedTextField(new Double(0.00));
        JFormattedTextField numtransacAgencia = new JFormattedTextField();

        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();

        ButtonGroup GroupRbtn = new ButtonGroup();
        String[] auxVector = new String[9];

        AgenciaAutoPanel() {
            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);

            GridBagConstraints Const = new GridBagConstraints();

            //CONSTANTES
            //------------------
            Const.weightx = 0.0;
            Const.weighty = 0.0;
            Const.insets = new Insets(5, 5, 5, 5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------

            //RADIO BUTTONS
            Const.gridx = 0;
            Const.gridy = 0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 4;
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 5;
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);

            //CAMPOS  
            Const.insets = new Insets(5, 75, 5, 0);

            Const.gridx = 1;
            Const.gridy = 1;
            id.setText("ID");
            this.add(id, Const);

            Const.gridx = 1;
            Const.gridy = 2;
            nombre.setText("Nombre: ");
            this.add(nombre, Const);

            Const.gridx = 1;
            Const.gridy = 3;
            direccion.setText("Direccion: ");
            this.add(direccion, Const);

            Const.gridx = 1;
            Const.gridy = 4;
            telefono.setText("Telefono: ");
            this.add(telefono, Const);

            Const.gridx = 1;
            Const.gridy = 5;
            numcajas.setText("Numero de Cajas: ");
            this.add(numcajas, Const);

            Const.gridx = 1;
            Const.gridy = 6;
            numescritorios.setText("Escritorios de Servicio al Cliente: ");
            this.add(numescritorios, Const);

            Const.gridx = 1;
            Const.gridy = 7;
            efectivo.setText("Efectivo");
            this.add(efectivo, Const);

            Const.gridx = 1;
            Const.gridy = 8;
            cajasauto.setText("Numeros de Cajas en AutoBanco");
            this.add(cajasauto, Const);

            Const.gridx = 1;
            Const.gridy = 9;
            transac.setText("Numero de Transacciones");
            this.add(transac, Const);

            //TEXT FIELD
            Const.gridx = 2;
            Const.gridy = 1;
            idAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(idAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 2;
            nombreAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(nombreAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 3;
            direccionAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(direccionAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 4;
            telefonoAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(telefonoAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 5;
            numcajasAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(numcajasAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 6;
            numescritoriosAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(numescritoriosAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 7;
            efectivoAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(efectivoAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 8;
            numautoAgencia.setPreferredSize(new Dimension(200, 20));
            this.add(numautoAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 9;
            numtransacAgencia.setPreferredSize(new Dimension(200, 20));
            numtransacAgencia.setText("0");
            numtransacAgencia.setEnabled(false);
            this.add(numtransacAgencia, Const);

            Const.gridx = 2;
            Const.gridy = 12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn, Const);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (delRbtn.isSelected()) {

                if (Data.checkPK(idAgencia.getText(), Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter)) {
                    Data.AgenciasAutoMtx = Data.delReg(idAgencia.getText(), Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
                    Data.AgenciasAutoMtxCounter--;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Agencia", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ID no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

                Data.printMtx(Data.AgenciasAutoMtx);

            } else if (addRbtn.isSelected()) {

                auxVector[0] = idAgencia.getText();
                auxVector[1] = nombreAgencia.getText();
                auxVector[2] = direccionAgencia.getText();
                auxVector[3] = telefonoAgencia.getText();
                auxVector[4] = numcajasAgencia.getText();
                auxVector[5] = numescritoriosAgencia.getText();
                auxVector[6] = efectivoAgencia.getText();
                auxVector[7] = numautoAgencia.getText();
                auxVector[8] = numtransacAgencia.getText();

                Data.addReg(auxVector, Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);

                if (!Data.checkPK(idAgencia.getText(), Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter)) {
                    Data.AgenciasAutoMtxCounter++;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Agencia", JOptionPane.INFORMATION_MESSAGE);
                }

                Data.printMtx(Data.AgenciasAutoMtx);

            } else if (editRbtn.isSelected()) {

                auxVector[0] = idAgencia.getText();
                auxVector[1] = nombreAgencia.getText();
                auxVector[2] = direccionAgencia.getText();
                auxVector[3] = telefonoAgencia.getText();
                auxVector[4] = numcajasAgencia.getText();
                auxVector[5] = numescritoriosAgencia.getText();
                auxVector[6] = efectivoAgencia.getText();
                auxVector[7] = numautoAgencia.getText();
                auxVector[8] = numtransacAgencia.getText();

                Data.AgenciasAutoMtx = Data.editReg(idAgencia.getText(), auxVector, Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
            } else if (readRbtn.isSelected()) {

                auxVector = Data.readReg(idAgencia.getText(), Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
                idAgencia.setText(auxVector[0]);
                nombreAgencia.setText(auxVector[1]);
                direccionAgencia.setText(auxVector[2]);
                telefonoAgencia.setText(auxVector[3]);
                numcajasAgencia.setText(auxVector[4]);
                numescritoriosAgencia.setText(auxVector[5]);
                efectivoAgencia.setText(auxVector[6]);
                numautoAgencia.setText(auxVector[7]);
                numtransacAgencia.setText(auxVector[8]);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciones un tipo de consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    class CajeroPanel extends JPanel implements ActionListener {

        JButton okBtn = new JButton();

        JLabel titleRbtn = new JLabel();
        JLabel id = new JLabel();
        JLabel ubicacion = new JLabel();
        JLabel efectivo = new JLabel();
        JLabel estado = new JLabel();
        JLabel numtrans = new JLabel();

        JFormattedTextField idCajero = new JFormattedTextField(new Integer(0));
        JFormattedTextField ubicacionCajero = new JFormattedTextField();
        JFormattedTextField efectivoCajero = new JFormattedTextField(new Double(0.00));
        JComboBox estadoCajero = new JComboBox();
        JFormattedTextField numtransCajero = new JFormattedTextField();

        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();

        ButtonGroup GroupRbtn = new ButtonGroup();
        String[] auxVector = new String[5];

        CajeroPanel() {

            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);

            GridBagConstraints Const = new GridBagConstraints();

            //CONSTANTES
            //------------------
            Const.weightx = 0.0;
            Const.weighty = 0.0;
            Const.insets = new Insets(5, 5, 5, 5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------

            //RADIO BUTTONS
            Const.gridx = 0;
            Const.gridy = 0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 4;
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 5;
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);

            //CAMPOS  
            Const.insets = new Insets(5, 75, 5, 0);

            Const.gridx = 1;
            Const.gridy = 1;
            id.setText("ID");
            this.add(id, Const);

            Const.gridx = 1;
            Const.gridy = 2;
            ubicacion.setText("Ubicacion: ");
            this.add(ubicacion, Const);

            Const.gridx = 1;
            Const.gridy = 3;
            efectivo.setText("Efectivo Disponible: ");
            this.add(efectivo, Const);

            Const.gridx = 1;
            Const.gridy = 4;
            estado.setText("Estado: ");
            this.add(estado, Const);

            Const.gridx = 1;
            Const.gridy = 5;
            numtrans.setText("Transacciones Realizadas: ");
            this.add(numtrans, Const);

            //TEXT FIELD
            Const.gridx = 2;
            Const.gridy = 1;
            idCajero.setPreferredSize(new Dimension(200, 20));
            this.add(idCajero, Const);

            Const.gridx = 2;
            Const.gridy = 2;
            ubicacionCajero.setPreferredSize(new Dimension(200, 20));
            this.add(ubicacionCajero, Const);

            Const.gridx = 2;
            Const.gridy = 3;
            efectivoCajero.setPreferredSize(new Dimension(200, 20));
            this.add(efectivoCajero, Const);

            Const.gridx = 2;
            Const.gridy = 4;
            estadoCajero.setPreferredSize(new Dimension(200, 20));
            estadoCajero.addItem("Activo");
            estadoCajero.addItem("Inactivo");
            this.add(estadoCajero, Const);

            Const.gridx = 2;
            Const.gridy = 5;
            numtransCajero.setPreferredSize(new Dimension(200, 20));
            numtransCajero.setText("0");
            numtransCajero.setEnabled(false);
            this.add(numtransCajero, Const);

            Const.gridx = 2;
            Const.gridy = 12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn, Const);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (delRbtn.isSelected()) {

                if (Data.checkPK(idCajero.getText(), Data.CajerosMtx, Data.CajerosMtxCounter)) {
                    Data.CajerosMtx = Data.delReg(idCajero.getText(), Data.CajerosMtx, Data.CajerosMtxCounter);
                    Data.CajerosMtxCounter--;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Cajero", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ID no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

                Data.printMtx(Data.CajerosMtx);

            } else if (addRbtn.isSelected()) {

                auxVector[0] = idCajero.getText();
                auxVector[1] = ubicacionCajero.getText();
                auxVector[2] = efectivoCajero.getText();
                auxVector[3] = (String)estadoCajero.getSelectedItem();
                auxVector[4] = numtransCajero.getText();

                Data.addReg(auxVector, Data.CajerosMtx, Data.CajerosMtxCounter);

                if (!Data.checkPK(idCajero.getText(), Data.CajerosMtx, Data.CajerosMtxCounter)) {
                    Data.CajerosMtxCounter++;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Cajero", JOptionPane.INFORMATION_MESSAGE);
                }

                Data.printMtx(Data.CajerosMtx);

            } else if (editRbtn.isSelected()) {

                auxVector[0] = idCajero.getText();
                auxVector[1] = ubicacionCajero.getText();
                auxVector[2] = efectivoCajero.getText();
                auxVector[3] = (String)estadoCajero.getSelectedItem();
                auxVector[4] = numtransCajero.getText();
                Data.CajerosMtx = Data.editReg(idCajero.getText(), auxVector, Data.CajerosMtx, Data.CajerosMtxCounter);
            } else if (readRbtn.isSelected()) {
                estadoCajero.removeAllItems();
                auxVector = Data.readReg(idCajero.getText(), Data.CajerosMtx, Data.CajerosMtxCounter);
                idCajero.setText(auxVector[0]);
                ubicacionCajero.setText(auxVector[1]);
                efectivoCajero.setText(auxVector[2]);
                estadoCajero.addItem(auxVector[3]);
                numtransCajero.setText(auxVector[4]);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciones un tipo de consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
    
    class EmpleadosPanel extends JPanel implements ActionListener{

        JButton okBtn = new JButton();

        JLabel titleRbtn = new JLabel();
        JLabel idEmpleadoLbl = new JLabel();
        JLabel nombreLbl = new JLabel();
        JLabel areaLbl = new JLabel();
        JLabel departamentoLbl = new JLabel();
        
        private final String[] lugaresMtx = {"Agencia Bancaria","Agencia con AutoBanco","Call-Center","Oficinas Centrales"};

        JFormattedTextField idEmpleado = new JFormattedTextField(new Integer(0));
        JFormattedTextField nombreEmpleado = new JFormattedTextField(new String(""));
        JComboBox areaEmpleado = new JComboBox(lugaresMtx);
        JComboBox subareaEmpleado = new JComboBox();

        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();

        ButtonGroup GroupRbtn = new ButtonGroup();
        String[] auxVector = new String[4];       
        private  String[] IDsVector;
        
        
        EmpleadosPanel() {

            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);

            GridBagConstraints Const = new GridBagConstraints();

            //CONSTANTES
            //------------------
            Const.weightx = 0.0;
            Const.weighty = 0.0;
            Const.insets = new Insets(5, 5, 5, 5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------

            //RADIO BUTTONS
            Const.gridx = 0;
            Const.gridy = 0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 4;
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);

            Const.gridx = 0;
            Const.gridy = 5;
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);

            //CAMPOS  
            Const.insets = new Insets(5, 75, 5, 0);

            Const.gridx = 1;
            Const.gridy = 1;
            idEmpleadoLbl.setText("ID:");
            this.add(idEmpleadoLbl, Const);

            Const.gridx = 1;
            Const.gridy = 2;
            nombreLbl.setText("Nombre:");
            this.add(nombreLbl, Const);

            Const.gridx = 1;
            Const.gridy = 3;
            areaLbl.setText("Area: ");
            this.add(areaLbl, Const);

            Const.gridx = 1;
            Const.gridy = 4;
            departamentoLbl.setText("Departamento: ");
            this.add(departamentoLbl, Const);
            
            //TEXT FIELD
            Const.gridx = 2;
            Const.gridy = 1;
            idEmpleado.setPreferredSize(new Dimension(200, 20));
            this.add(idEmpleado, Const);
            
            Const.gridx = 2;
            Const.gridy = 2;
            nombreEmpleado.setPreferredSize(new Dimension(200, 20));
            this.add(nombreEmpleado, Const);

            Const.gridx = 2;
            Const.gridy = 3;
            areaEmpleado.setPreferredSize(new Dimension(200, 20)); 
            areaEmpleado.addActionListener(this);
            this.add(areaEmpleado, Const);

            Const.gridx = 2;
            Const.gridy = 4;
            subareaEmpleado.setPreferredSize(new Dimension(200, 20));
            this.add(subareaEmpleado, Const);
            
            Const.gridx = 2;
            Const.gridy = 12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn, Const);


        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
        if(e.getSource().equals(areaEmpleado)){
            JComboBox cb = (JComboBox)e.getSource();
            String area = (String)cb.getSelectedItem();
            switch(area){
                case"Agencia Bancaria":
                        IDsVector=Data.getColumn(Data.AgenciasMtx, 0, Data.AgenciasMtxCounter);
                        subareaEmpleado.removeAllItems();
                        for (String string : IDsVector) {
                        subareaEmpleado.addItem(string);
                        }
                    break;
                case"Agencia con AutoBanco":
                        IDsVector=Data.getColumn(Data.AgenciasAutoMtx, 0, Data.AgenciasAutoMtxCounter);
                        subareaEmpleado.removeAllItems();
                        for (String string : IDsVector) {
                        subareaEmpleado.addItem(string);
                        }
                    break;
                case"Call-Center":
                        subareaEmpleado.removeAllItems();
                        subareaEmpleado.addItem("N/A");
                    break;
                case"Oficinas Centrales":
                    subareaEmpleado.removeAllItems();
                    subareaEmpleado.addItem("Gerencia");
                    subareaEmpleado.addItem("Departamento de Marketing");
                    subareaEmpleado.addItem("Departamento de Informatica");
                    subareaEmpleado.addItem("Departamento Financiero");
                    subareaEmpleado.addItem("Departamento de Reclamos");
                    subareaEmpleado.addItem("Departamento de Cobros");
                    break;
            }
        }
        else{    

            if (delRbtn.isSelected()) {

                if (Data.checkPK(idEmpleado.getText(), Data.EmpleadosMtx, Data.EmpleadosMtxCounter)) {
                    Data.EmpleadosMtx = Data.delReg(idEmpleado.getText(), Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
                    Data.EmpleadosMtxCounter--;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Empleado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ID no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

                Data.printMtx(Data.EmpleadosMtx);

            } else if (addRbtn.isSelected()) {

                auxVector[0] = idEmpleado.getText();
                auxVector[1] = nombreEmpleado.getText();
                auxVector[2] = (String)areaEmpleado.getSelectedItem();
                auxVector[3] = (String)subareaEmpleado.getSelectedItem();

                Data.addReg(auxVector, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);

                if (!Data.checkPK(idEmpleado.getText(), Data.EmpleadosMtx, Data.EmpleadosMtxCounter)) {
                    Data.EmpleadosMtxCounter++;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Empleado", JOptionPane.INFORMATION_MESSAGE);
                }

                Data.printMtx(Data.EmpleadosMtx);

            } else if (editRbtn.isSelected()) {

                auxVector[0] = idEmpleado.getText();
                auxVector[1] = nombreEmpleado.getText();
                auxVector[2] = (String)areaEmpleado.getSelectedItem();
                auxVector[3] = (String)subareaEmpleado.getSelectedItem();
                Data.EmpleadosMtx = Data.editReg(idEmpleado.getText(), auxVector, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
                
            } else if (readRbtn.isSelected()) {
                areaEmpleado.removeAllItems();
                subareaEmpleado.removeAllItems();
                auxVector = Data.readReg(idEmpleado.getText(), Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
                idEmpleado.setText(auxVector[0]);
                nombreEmpleado.setText(auxVector[1]);
                areaEmpleado.addItem(auxVector[2]);
                subareaEmpleado.addItem(auxVector[3]);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciones un tipo de consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }        
        }             
    }

    class TarjetaCreditoPanel extends JPanel implements MouseListener{
        
        private  String[] columnNames = {"ID","ID Cliente","Fecha de Vencimiento", "Limite Credito","Monto Abonado"};
        String[] auxVector= new String[5];

        private Object[][] tableData = Data.sCreditoMtx;
        private Object[][] tableData2 = Data.aCreditoMtx;
        JLabel title = new JLabel();
        JLabel title2 = new JLabel();

        private JTable tablaCreditos =  new JTable(tableData,columnNames);
        private JTable tablaCreditos2 =  new JTable(tableData2,columnNames);
        
        String IDCredito;
        
        TarjetaCreditoPanel(){
            title.setText("Solicitudes");
            //this.add(title,BorderLayout.BEFORE_LINE_BEGINS);
            title2.setText("Aprobadas");
            tablaCreditos.addMouseListener(this);
            this.add(new JScrollPane(tablaCreditos),BorderLayout.CENTER);
            //this.add(new JScrollPane(tablaCreditos2),BorderLayout.CENTER);
            //this.add(title2,BorderLayout.AFTER_LINE_ENDS);            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
            //Se obtiene valor del ID     
            Point point = e.getPoint();
            int row = tablaCreditos.rowAtPoint(point);
            TableModel model = tablaCreditos.getModel();
            IDCredito=String.valueOf(model.getValueAt(row,0));
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea aprobar el Credito con ID: "+IDCredito+" ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(resp==0){
                auxVector=Data.readReg(IDCredito, Data.sCreditoMtx, Data.sCreditoMtxCounter);
                Data.delReg(IDCredito, Data.sCreditoMtx, Data.sCreditoMtxCounter);
                Data.sCreditoMtxCounter--;
                Data.addReg(auxVector, Data.aCreditoMtx, Data.aCreditoMtxCounter);
                Data.aCreditoMtxCounter++;
                Data.addValueIn(auxVector[1], IDCredito, Data.ClientesMtx, Data.ClientesMtxCounter,7);
                JOptionPane.showMessageDialog(null,"Credito Aprobado", "Aprobacion", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

    }

    class PrestamosPanel extends JPanel implements MouseListener {
        
        private  String[] columnNames = {"ID","ID Cliente","Fecha de Solicitud", "Monto Prestado","Monto Abonado"};
        String[] auxVector = new String[5];

        private Object[][] tableData = Data.sPrestamosMtx;
        private Object[][] tableData2 = Data.aPrestamosMtx;
        JLabel title = new JLabel();
        JLabel title2 = new JLabel();

        private JTable tablaPrestamos =  new JTable(tableData,columnNames);
        private JTable tablaPrestamos2 =  new JTable(tableData2,columnNames);
        
        String IDPrestamo;
        
        PrestamosPanel(){
            title.setText("Solicitudes");
            //this.add(title,BorderLayout.BEFORE_LINE_BEGINS);
            title2.setText("Aprobadas");
      
            tablaPrestamos.addMouseListener(this);
            this.add(new JScrollPane(tablaPrestamos),BorderLayout.CENTER);
            //this.add(new JScrollPane(tablaPrestamos2),BorderLayout.CENTER);
            //this.add(title2,BorderLayout.AFTER_LINE_ENDS);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
            //Se obtiene valor del ID     
            Point point = e.getPoint();
            int row = tablaPrestamos.rowAtPoint(point);
            TableModel model = tablaPrestamos.getModel();
            IDPrestamo=String.valueOf(model.getValueAt(row,0));
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea aprobar el Prestamo con ID: "+IDPrestamo+" ?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(resp==0){
                auxVector=Data.readReg(IDPrestamo, Data.sPrestamosMtx, Data.sPrestamosMtxCounter);
                Data.delReg(auxVector[0], Data.sPrestamosMtx, Data.sPrestamosMtxCounter);
                Data.sPrestamosMtxCounter--;
                Data.addReg(auxVector, Data.aPrestamosMtx, Data.aPrestamosMtxCounter);
                Data.aPrestamosMtxCounter++;
                Data.addValueIn(auxVector[1], IDPrestamo, Data.ClientesMtx, Data.ClientesMtxCounter,6);
                JOptionPane.showMessageDialog(null,"Prestamo Aprobado", "Aprobacion", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
        
        
        

    }

    class ReportesPanel extends JPanel implements ActionListener,MouseListener{
        
        JButton rutaBtn = new JButton();
        JButton genBtn = new JButton();

        JTextField rutaText = new JTextField();
        JComboBox reporteCombo = new JComboBox();
        
        private final  String[] columnNames = {"ID","Nombre","Direccion", "Telefono","Cuentas de Ahorro","Cuentas Monetarias","Prestamos","Tarjetas de Credito","Transacciones"};
    
        private Object[][] tableData = Data.ClientesMtx;
        private JTable tablaClientes =  new JTable(tableData,columnNames);
        String [] auxVector;
        
        Paragraph column1,column2,column3,column4,column5,column6,column7,column8,column9,column10,column11,column12;
        PdfPTable Tabla1;
        PdfPCell titleCell;

        ReportesPanel(){
            
            this.setLayout(new GridBagLayout());
            GridBagConstraints Const = new GridBagConstraints();            

            //CONSTANTES
            //------------------
            Const.weightx = 0.0;
            Const.weighty = 0.0;
            Const.insets = new Insets(5, 5, 5, 5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //Text Area
            Const.gridx = 0;
            Const.gridy = 0;
            rutaText.setPreferredSize(new Dimension(350, 30));
            rutaText.setEditable(false);
            rutaText.setText("");
            this.add(rutaText, Const);
            
            Const.gridx = 0;
            Const.gridy = 1;
            reporteCombo.setPreferredSize(new Dimension(350, 30));
            reporteCombo.addItem("Agencias");
            reporteCombo.addItem("Cajeros");
            reporteCombo.addItem("Clientes");
            reporteCombo.addItem("Top 3 Clientes con mas cuentas");
            reporteCombo.addItem("Top 3 Clientes con mas dinero");
            reporteCombo.addItem("Top 3 Clientes con mas deudas");
            reporteCombo.addItem("Top 3 Agencias mas Utilizadas");
            reporteCombo.addItem("Top 2 Operaciones en Call-Center");
            reporteCombo.addItem("Sumatoria de efectivo en agencias");
            reporteCombo.addItem("Monto de efectivo por agencia");
            reporteCombo.addItem("Listado de Empleados de cada Agencia");
            reporteCombo.addItem("Listado de Empleados en Oficinas Centrales");
            reporteCombo.addItem("Agencia con mayor numero de Empleados");
            reporteCombo.addItem("Top 3 Clientes con mas compras al credito");
            this.add(reporteCombo, Const);
            
            //Buttons
            Const.gridx = 1;
            Const.gridy = 0;
            rutaBtn.setText("Elegir Ruta...");
            rutaBtn.addActionListener(this);
            this.add(rutaBtn,Const);
            
            Const.gridx = 1;
            Const.gridy = 1;
            genBtn.setText("Generar Reporte");
            genBtn.addActionListener(this);
            this.add(genBtn,Const);
            
            Const.gridx = 1;
            Const.gridy = 2;
            tablaClientes.addMouseListener(this);
            this.add(new JScrollPane(tablaClientes),Const);
            
        
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(rutaBtn)){
                JFileChooser FileDialog = new JFileChooser();
                int option = FileDialog.showSaveDialog(this);
                if(option == JFileChooser.APPROVE_OPTION){
                    File Ruta = FileDialog.getSelectedFile();
                    rutaText.setText(Ruta.toString());
                }
            }
            if(e.getSource().equals(genBtn)){
                
                switch((String)reporteCombo.getSelectedItem()){
                    
                case"Agencias":
                    
                    try{
                    String path = rutaText.getText();
                    path = (path.endsWith(".pdf"))?path:path+".pdf";
                    FileOutputStream PDF = new FileOutputStream(path);
                    Document Report = new Document();
                    PdfWriter.getInstance(Report, PDF);
                    //<editor-fold defaultstate="collapsed" desc="Creacion de PDF - Agencias y AgenciasAuto">
                    Report.open();
                    
                        Report.add(new Paragraph("Agencias",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.BLUE)));
                        Report.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                        Report.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                        
                    // -----------------------------TABLA 1 - Agencias-------------------------------
                        Tabla1 = new PdfPTable(8);
                        Tabla1.setWidthPercentage(100);
                        titleCell = new PdfPCell(new Paragraph("Agencias"));
                        titleCell.setColspan(8);
                        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        Tabla1.addCell(titleCell);
                    // COLUMNS NAMES
                        column1= new Paragraph("ID",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column2= new Paragraph("Nombre",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column3= new Paragraph("Direccion",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column4= new Paragraph("Telefono",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column5= new Paragraph("Cantidad Cajeros",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column6= new Paragraph("Cantidad Escritorios",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column7= new Paragraph("Efectivo",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column8= new Paragraph("Transacciones",FontFactory.getFont(FontFactory.HELVETICA,12));
                                
                        Tabla1.addCell(column1);
                        Tabla1.addCell(column2);
                        Tabla1.addCell(column3);
                        Tabla1.addCell(column4);
                        Tabla1.addCell(column5);
                        Tabla1.addCell(column6);
                        Tabla1.addCell(column7);
                        Tabla1.addCell(column8);
                                                                        
                        auxVector = new String [8];
                        
                        for(int i=0;i<Data.AgenciasMtxCounter;i++){
                            auxVector=Data.readReg(Data.AgenciasMtx[i][0], Data.AgenciasMtx, Data.AgenciasMtxCounter);
                            Tabla1.addCell(auxVector[0]);
                            Tabla1.addCell(auxVector[1]);
                            Tabla1.addCell(auxVector[2]);
                            Tabla1.addCell(auxVector[3]);
                            Tabla1.addCell(auxVector[4]); 
                            Tabla1.addCell(auxVector[5]);
                            Tabla1.addCell(auxVector[6]);
                            Tabla1.addCell(auxVector[7]);                          
                        }
                        Report.add(Tabla1);
                    //-----------------------------FIN TABLA 1------------------------------
                    // ----------------------------TABLA 2 - Agencias Auto Banco------------
                        Tabla1 = new PdfPTable(9);
                        Tabla1.setWidthPercentage(100);
                        titleCell = new PdfPCell(new Paragraph("Agencias con AutoBanco"));
                        titleCell.setColspan(9);
                        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        Tabla1.addCell(titleCell);
                    // COLUMNS NAMES
                        column1= new Paragraph("ID",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column2= new Paragraph("Nombre",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column3= new Paragraph("Direccion",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column4= new Paragraph("Telefono",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column5= new Paragraph("Cantidad Cajeros",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column6= new Paragraph("Cantidad Escritorios",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column7= new Paragraph("Efectivo",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column8= new Paragraph("AutoBancon",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column9= new Paragraph("Transacciones",FontFactory.getFont(FontFactory.HELVETICA,12));
                                
                        Tabla1.addCell(column1);
                        Tabla1.addCell(column2);
                        Tabla1.addCell(column3);
                        Tabla1.addCell(column4);
                        Tabla1.addCell(column5);
                        Tabla1.addCell(column6);
                        Tabla1.addCell(column7);
                        Tabla1.addCell(column8);
                        Tabla1.addCell(column9);
                        
                        auxVector = new String [9];
                        
                        for(int i=0;i<Data.AgenciasAutoMtxCounter;i++){
                            auxVector=Data.readReg(Data.AgenciasAutoMtx[i][0], Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
                            Tabla1.addCell(auxVector[0]);
                            Tabla1.addCell(auxVector[1]);
                            Tabla1.addCell(auxVector[2]);
                            Tabla1.addCell(auxVector[3]);
                            Tabla1.addCell(auxVector[4]); 
                            Tabla1.addCell(auxVector[5]);
                            Tabla1.addCell(auxVector[6]);
                            Tabla1.addCell(auxVector[7]);
                            Tabla1.addCell(auxVector[8]);
                        }
                        Report.add(Tabla1);
                    //-----------------------FIN TABLA2-----------------------------                       
                        
                        
                    Report.close();
                    JOptionPane.showMessageDialog(this, "Reporte PDF generado exitosamente");
                    //</editor-fold>
                    
                    }                   
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    } 
                    
                    break;
                    
                case"Cajeros":
                    
                    try{
                    String path = rutaText.getText();
                    path = (path.endsWith(".pdf"))?path:path+".pdf";
                    FileOutputStream PDF = new FileOutputStream(path);
                    Document Report = new Document();
                    PdfWriter.getInstance(Report, PDF);
                    
                    //<editor-fold defaultstate="collapsed" desc="Creacion de PDF - Cajeros Automaticos">
                    Report.open();
                    
                        Report.add(new Paragraph("Cajeros",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.BLUE)));
                        Report.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                        Report.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                        
                    // -----------------------------TABLA 1 - Cajeros Automaticos -------------------------------
                        Tabla1 = new PdfPTable(5);
                        Tabla1.setWidthPercentage(100);
                        titleCell = new PdfPCell(new Paragraph("Cajeros - ATM"));
                        titleCell.setColspan(5);
                        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        Tabla1.addCell(titleCell);
                    // COLUMNS NAMES
                        column1= new Paragraph("ID",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column2= new Paragraph("Ubicacion",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column3= new Paragraph("Efectivo",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column4= new Paragraph("Estado",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column5= new Paragraph("Transacciones",FontFactory.getFont(FontFactory.HELVETICA,12));
                                
                        Tabla1.addCell(column1);
                        Tabla1.addCell(column2);
                        Tabla1.addCell(column3);
                        Tabla1.addCell(column4);
                        Tabla1.addCell(column5);

                                                                        
                        auxVector = new String [5];
                        
                        for(int i=0;i<Data.CajerosMtxCounter;i++){
                            auxVector=Data.readReg(Data.CajerosMtx[i][0], Data.CajerosMtx, Data.CajerosMtxCounter);
                            Tabla1.addCell(auxVector[0]);
                            Tabla1.addCell(auxVector[1]);
                            Tabla1.addCell(auxVector[2]);
                            Tabla1.addCell(auxVector[3]);
                            Tabla1.addCell(auxVector[4]); 
                             
                        }
                        Report.add(Tabla1);
                    //-----------------------------FIN TABLA 1------------------------------                                             
                        
                    Report.close();
                    JOptionPane.showMessageDialog(this, "Reporte PDF generado exitosamente");
                    //</editor-fold>
                    
                    }                   
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                    break;
                    
                case"Clientes":
                    
                    try{
                    String path = rutaText.getText();
                    path = (path.endsWith(".pdf"))?path:path+".pdf";
                    FileOutputStream PDF = new FileOutputStream(path);
                    Document Report = new Document();
                    PdfWriter.getInstance(Report, PDF);
                    //<editor-fold defaultstate="collapsed" desc="Creacion de PDF - Clientes">
                    Report.open();
                    
                        Report.add(new Paragraph("Clientes",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.BLUE)));
                        Report.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                        Report.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                        
                    // -----------------------------TABLA 1 - Clientes-------------------------------
                        Tabla1 = new PdfPTable(9);
                        Tabla1.setWidthPercentage(100);
                        titleCell = new PdfPCell(new Paragraph("Clientes"));
                        titleCell.setColspan(9);
                        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        Tabla1.addCell(titleCell);
                    // COLUMNS NAMES
                        column1= new Paragraph("ID",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column2= new Paragraph("Nombre",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column3= new Paragraph("Direccion",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column4= new Paragraph("Telefono",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column5= new Paragraph("Cuentas Ahorro",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column6= new Paragraph("Cuentas Monetarias",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column7= new Paragraph("Prestamos",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column8= new Paragraph("Creditos",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column9= new Paragraph("Transacciones",FontFactory.getFont(FontFactory.HELVETICA,12));
                                
                        Tabla1.addCell(column1);
                        Tabla1.addCell(column2);
                        Tabla1.addCell(column3);
                        Tabla1.addCell(column4);
                        Tabla1.addCell(column5);
                        Tabla1.addCell(column6);
                        Tabla1.addCell(column7);
                        Tabla1.addCell(column8);
                        Tabla1.addCell(column9);
                                                                        
                        auxVector = new String [9];
                        
                        for(int i=0;i<Data.ClientesMtxCounter;i++){
                            auxVector=Data.readReg(Data.ClientesMtx[i][0], Data.ClientesMtx, Data.ClientesMtxCounter);
                            Tabla1.addCell(auxVector[0]);
                            Tabla1.addCell(auxVector[1]);
                            Tabla1.addCell(auxVector[2]);
                            Tabla1.addCell(auxVector[3]);
                            Tabla1.addCell(auxVector[4]); 
                            Tabla1.addCell(auxVector[5]);
                            Tabla1.addCell(auxVector[6]);
                            Tabla1.addCell(auxVector[7]);     
                            Tabla1.addCell(auxVector[8]); 
                        }
                        Report.add(Tabla1);
                    //-----------------------------FIN TABLA 1------------------------------                                                                     
                    Report.close();
                    JOptionPane.showMessageDialog(this, "Reporte PDF generado exitosamente");
                    //</editor-fold>
                    
                    }                   
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    } 
                    
                    break;
                case"Top 3 Clientes con mas cuentas":
                    break;
                case"Top 3 Clientes con mas dinero":
                    break;
                case"Top 3 Clientes con mas deudas":
                    break;
                case"Top 3 Agencias mas Utilizadas":
                    break;
                case"Top 2 Operaciones en Call-Center":
                    break;
                case"Sumatoria de efectivo en agencias":
                    
                    try{
                    String path = rutaText.getText();
                    path = (path.endsWith(".pdf"))?path:path+".pdf";
                    FileOutputStream PDF = new FileOutputStream(path);
                    Document Report = new Document();
                    PdfWriter.getInstance(Report, PDF);
                    //<editor-fold defaultstate="collapsed" desc="Creacion de PDF - Sumatoria Efectivo">
                    Report.open();
                    
                        Report.add(new Paragraph("Sumatoria de Efectivo en Agencias",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.BLUE)));
                        Report.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                        Report.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                        
                        auxVector=Data.getColumn(Data.AgenciasMtx, 6, Data.AgenciasMtxCounter);
                        double total=0;
                        for(int i=0;i<auxVector.length;i++){
                            total=Double.parseDouble(auxVector[i].replace(",", ""))+total;
                        }
                        auxVector=Data.getColumn(Data.AgenciasAutoMtx, 6, Data.AgenciasAutoMtxCounter);
                        double total2=0;
                        for(int i=0;i<auxVector.length;i++){
                            total=Double.parseDouble(auxVector[i].replace(",", ""))+total;
                        }
                        
                        Report.add(new Paragraph("Agencias: TOTAL= "+total,FontFactory.getFont(FontFactory.HELVETICA,15,BaseColor.BLACK)));
                        Report.add(new Paragraph("Agencias con AutoBanco: TOTAL= "+total2,FontFactory.getFont(FontFactory.HELVETICA,15,BaseColor.BLACK)));                                                                  
                    Report.close();
                    JOptionPane.showMessageDialog(this, "Reporte PDF generado exitosamente");
                    //</editor-fold>
                    
                    }                   
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                    break;
                case"Monto de efectivo por agencia":
                    
                    try{
                    String path = rutaText.getText();
                    path = (path.endsWith(".pdf"))?path:path+".pdf";
                    FileOutputStream PDF = new FileOutputStream(path);
                    Document Report = new Document();
                    PdfWriter.getInstance(Report, PDF);
                    //<editor-fold defaultstate="collapsed" desc="Creacion de PDF - Monto por Agencia">
                    Report.open();
                    
                        Report.add(new Paragraph("Efectivo por Agencia",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.BLUE)));
                        Report.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                        Report.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                        
                    // -----------------------------TABLA 1 - AgenciasEfectivo-------------------------------
                        Tabla1 = new PdfPTable(3);
                        Tabla1.setWidthPercentage(100);
                        titleCell = new PdfPCell(new Paragraph("Agencias"));
                        titleCell.setColspan(3);
                        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        Tabla1.addCell(titleCell);
                    // COLUMNS NAMES
                        column1= new Paragraph("ID",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column2= new Paragraph("Nombre",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column3= new Paragraph("Efectivo",FontFactory.getFont(FontFactory.HELVETICA,12));
                                    
                        Tabla1.addCell(column1);
                        Tabla1.addCell(column2);
                        Tabla1.addCell(column3);
                                                                       
                        auxVector = new String [8];
                        
                        for(int i=0;i<Data.AgenciasMtxCounter;i++){
                            auxVector=Data.readReg(Data.AgenciasMtx[i][0], Data.AgenciasMtx, Data.AgenciasMtxCounter);
                            Tabla1.addCell(auxVector[0]);
                            Tabla1.addCell(auxVector[1]);
                            Tabla1.addCell(auxVector[6]);                           
                        }
                        Report.add(Tabla1);
                    //-----------------------------FIN TABLA 1------------------------------
                    // ----------------------------TABLA 2 - Agencias Auto Banco------------
                        Tabla1 = new PdfPTable(9);
                        Tabla1.setWidthPercentage(100);
                        titleCell = new PdfPCell(new Paragraph("Agencias con AutoBanco"));
                        titleCell.setColspan(9);
                        titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        Tabla1.addCell(titleCell);
                    // COLUMNS NAMES
                        column1= new Paragraph("ID",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column2= new Paragraph("Nombre",FontFactory.getFont(FontFactory.HELVETICA,12));
                        column3= new Paragraph("Efectivo",FontFactory.getFont(FontFactory.HELVETICA,12));
                                
                        Tabla1.addCell(column1);
                        Tabla1.addCell(column2);
                        Tabla1.addCell(column3);
                        
                        auxVector = new String [9];
                        
                        for(int i=0;i<Data.AgenciasAutoMtxCounter;i++){
                            auxVector=Data.readReg(Data.AgenciasAutoMtx[i][0], Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
                            Tabla1.addCell(auxVector[0]);
                            Tabla1.addCell(auxVector[1]);
                            Tabla1.addCell(auxVector[6]);
                        }
                        Report.add(Tabla1);
                    //-----------------------FIN TABLA2-----------------------------
                    Report.close();
                    JOptionPane.showMessageDialog(this, "Reporte PDF generado exitosamente");
                    //</editor-fold>
                    
                    }                   
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                                       
                    break;
                case"Listado de Empleados de cada Agencia":
                    break;
                case"Listado de Empleados en Oficinas Centrales":
                    break;
                case"Agencia con mayor numero de Empleados":
                    break;
                case"Top 3 Clientes con mas compras al credito":
                    break;                   
                    
                }
                
                
                
                
            }
            
        
        
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
            if(e.getClickCount()>0){
                Point point = e.getPoint();
                int row = tablaClientes.rowAtPoint(point);
                TableModel model = tablaClientes.getModel();
                String IDCliente=String.valueOf(model.getValueAt(row,0));
                
                try{
                    String path = rutaText.getText();
                    path = (path.endsWith(".pdf"))?path:path+".pdf";
                    FileOutputStream PDF = new FileOutputStream(path);
                    Document Report = new Document();
                    PdfWriter.getInstance(Report, PDF);
                    //<editor-fold defaultstate="collapsed" desc="Creacion de PDF - ClientesCuentas">
                    Report.open();
                    
                        Report.add(new Paragraph("Cliente - ID: "+IDCliente,FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.BLUE)));
                        Report.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                        Report.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                                                               
                        auxVector = new String [9];                       
                        auxVector=Data.readReg(IDCliente, Data.ClientesMtx, Data.ClientesMtxCounter);
                        Report.add(new Paragraph("Cuentas de Ahorro: "+auxVector[4]));
                        Report.add(new Paragraph("Cuentas de Monetarias: "+auxVector[5]));
                        Report.add(new Paragraph("IDs Prestamos: "+auxVector[6]));
                        Report.add(new Paragraph("IDs Creditos: "+auxVector[7]));
                                                                                            
                    Report.close();
                    JOptionPane.showMessageDialog(this, "Reporte PDF generado exitosamente");
                    //</editor-fold>
                    
                    }                   
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                 
                
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        
    }
      
}
