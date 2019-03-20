package banksimulator;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

/**
 *
 * @author Cristian Meoño 201801397
 */

public class AdminModule {

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

    }

    class ClientePanel extends JPanel implements ActionListener {

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
        JFormattedTextField direccionCliente = new JFormattedTextField(new String(""));
        JFormattedTextField telefonoCliente = new JFormattedTextField(new Integer(1));
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
            tjtcreditoCliente.setPreferredSize(new Dimension(200, 20));
            tjtcreditoCliente.setText("");
            tjtcreditoCliente.setEnabled(false);
            this.add(tjtcreditoCliente, Const);

            Const.gridx = 2;
            Const.gridy = 8;
            prestamosCliente.setPreferredSize(new Dimension(200, 20));
            prestamosCliente.setText("");
            prestamosCliente.setEnabled(false);
            this.add(prestamosCliente, Const);

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
        JFormattedTextField nombreAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField direccionAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField telefonoAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField numcajasAgencia = new JFormattedTextField();
        JFormattedTextField numescritoriosAgencia = new JFormattedTextField();
        JFormattedTextField efectivoAgencia = new JFormattedTextField();
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
        JFormattedTextField nombreAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField direccionAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField telefonoAgencia = new JFormattedTextField();
        JFormattedTextField numcajasAgencia = new JFormattedTextField();
        JFormattedTextField numescritoriosAgencia = new JFormattedTextField();
        JFormattedTextField efectivoAgencia = new JFormattedTextField();
        JFormattedTextField numautoAgencia = new JFormattedTextField();
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
        JFormattedTextField ubicacionCajero = new JFormattedTextField(new String(""));
        JFormattedTextField efectivoCajero = new JFormattedTextField(new String(""));
        JFormattedTextField estadoCajero = new JFormattedTextField();
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
                auxVector[3] = estadoCajero.getText();
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
                auxVector[3] = estadoCajero.getText();
                auxVector[4] = numtransCajero.getText();
                Data.CajerosMtx = Data.editReg(idCajero.getText(), auxVector, Data.CajerosMtx, Data.CajerosMtxCounter);
            } else if (readRbtn.isSelected()) {

                auxVector = Data.readReg(idCajero.getText(), Data.CajerosMtx, Data.CajerosMtxCounter);
                idCajero.setText(auxVector[0]);
                ubicacionCajero.setText(auxVector[1]);
                efectivoCajero.setText(auxVector[2]);
                estadoCajero.setText(auxVector[3]);
                numtransCajero.setText(auxVector[4]);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciones un tipo de consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    class TarjetaCreditoPanel extends JPanel {

    }

    class PrestamosPanel extends JPanel {

    }

    class EmpleadosPanel extends JPanel implements ActionListener{

        JButton okBtn = new JButton();

        JLabel titleRbtn = new JLabel();
        JLabel idEmpleadoLbl = new JLabel();
        JLabel nombreLbl = new JLabel();
        JLabel areaLbl = new JLabel();
        JLabel departamentoLbl = new JLabel();
        

        JFormattedTextField idEmpleado = new JFormattedTextField(new Integer(0));
        JFormattedTextField nombreEmpleado = new JFormattedTextField(new String(""));
        JFormattedTextField areaEmpleado = new JFormattedTextField(new String(""));
        JFormattedTextField subareaEmpleado = new JFormattedTextField();

        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();

        ButtonGroup GroupRbtn = new ButtonGroup();
        String[] auxVector = new String[4];
        private final String[] lugaresMtx = {"Agencia Bancaria","Agencia con AutoBanco","Call-Center","Oficinas Centrales"};
        private final String[] columnNames = {""};
        
        
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
                auxVector[2] = areaEmpleado.getText();
                auxVector[3] = subareaEmpleado.getText();

                Data.addReg(auxVector, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);

                if (!Data.checkPK(idEmpleado.getText(), Data.EmpleadosMtx, Data.EmpleadosMtxCounter)) {
                    Data.EmpleadosMtxCounter++;
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Empleado", JOptionPane.INFORMATION_MESSAGE);
                }

                Data.printMtx(Data.EmpleadosMtx);

            } else if (editRbtn.isSelected()) {

                auxVector[0] = idEmpleado.getText();
                auxVector[1] = nombreEmpleado.getText();
                auxVector[2] = areaEmpleado.getText();
                auxVector[3] = subareaEmpleado.getText();
                Data.EmpleadosMtx = Data.editReg(idEmpleado.getText(), auxVector, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
                
            } else if (readRbtn.isSelected()) {

                auxVector = Data.readReg(idEmpleado.getText(), Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
                idEmpleado.setText(auxVector[0]);
                nombreEmpleado.setText(auxVector[1]);
                areaEmpleado.setText(auxVector[2]);
                subareaEmpleado.setText(auxVector[3]);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciones un tipo de consulta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        
        

    }
       
}
