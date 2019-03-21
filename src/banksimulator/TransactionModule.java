package banksimulator;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Cristian Meoño 201801397
 */
public  class TransactionModule implements MouseListener{
    
    private final String[] columnNames = {"ID","Nombre","Direccion", "Telefono","Cuentas de Ahorro","Cuentas Monetarias","Prestamos","Tarjetas de Credito","Transacciones"};
    private final String[] lugaresMtx = {"Agencia Bancaria","Agencia con AutoBanco","Cajero Automatico","Call-Center"};
    
    private Object[][] tableData = Data.ClientesMtx;
    
    public JInternalFrame TransactionFrame = new JInternalFrame("Modulo de Transacciones",true,true,false,true);
    private JTable tablaClientes =  new JTable(tableData,columnNames);
    
    TransactionModule(){
        
       TransactionFrame.setVisible(true);
       TransactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       tablaClientes.setPreferredScrollableViewportSize(new Dimension(500, 70));
       tablaClientes.setPreferredSize(new Dimension(200,200));
       tablaClientes.addMouseListener(this);
       TransactionFrame.add(tablaClientes);
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getClickCount()>0){
            
        //Se obtiene valor del ID     
        Point point = e.getPoint();
        int row = tablaClientes.rowAtPoint(point);
        TableModel model = tablaClientes.getModel();
        
        //Se le pasa como parametro el ID a TransactionsWindow
        String IDCliente=String.valueOf(model.getValueAt(row,0));
        String IDPlace;
        TransactionsWindow Window = new TransactionsWindow();
        String place = (String) JOptionPane.showInputDialog(null, "¿A donde desea dirigirse?","Lugares",
                        JOptionPane.DEFAULT_OPTION,null,lugaresMtx, lugaresMtx[0]);
        
            switch(place){
                case "Agencia Bancaria":
                    IDPlace = (String) JOptionPane.showInputDialog(null,"¿De que agencia viene?","Agencias",
                    JOptionPane.DEFAULT_OPTION,null,Data.getColumn(Data.AgenciasMtx,0,Data.AgenciasMtxCounter),Data.AgenciasMtx[0][0]);
                    
                    Window.TabbedPane.addTab("Retiro", new Retiro(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Deposito", new Deposito(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Cambio de Cheques", new CambioCheques());
                    Window.TabbedPane.addTab("Emision de Cheques", new EmisionCheques(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Pagos", new Pagos());
                    Window.TabbedPane.addTab("Consulta", new Consulta(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.add("Apertura Cuentas", new AbrirCts(IDPlace,IDCliente,"TypeA"));
                    Window.setVisible(true);
                break;
                
                case "Agencia con AutoBanco":
                    IDPlace = (String) JOptionPane.showInputDialog(null,"¿De que agencia viene?","AgenciasAuto",
                    JOptionPane.DEFAULT_OPTION,null,Data.getColumn(Data.AgenciasAutoMtx,0,Data.AgenciasAutoMtxCounter),Data.AgenciasAutoMtx[0][0]);
                    
                    Window.TabbedPane.addTab("Retiro", new Retiro(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Deposito", new Deposito(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Cambio de Cheques", new CambioCheques());
                    Window.TabbedPane.addTab("Emision de Cheques", new EmisionCheques(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Pagos", new Pagos());
                    Window.TabbedPane.addTab("Consulta", new Consulta(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.add("Apertura Cuentas", new AbrirCts(IDPlace,IDCliente,"TypeB"));
                    Window.setVisible(true);
                break;
                
                case "Cajero Automatico":
                    IDPlace = (String) JOptionPane.showInputDialog(null,"¿De que cajero viene?","Cajeros",
                    JOptionPane.DEFAULT_OPTION,null,Data.getColumn(Data.CajerosMtx,0,Data.CajerosMtxCounter),Data.CajerosMtx[0][0]);
                    Window.TabbedPane.addTab("Retiro", new Retiro(IDPlace,IDCliente,"TypeC"));
                    Window.TabbedPane.addTab("Consulta", new Consulta(IDPlace,IDCliente,"TypeC"));
                    Window.setVisible(true);
                break;
                
                case "Call-Center":                   
                    Window.TabbedPane.addTab("Deposito", new Deposito("Single",IDCliente,"TypeX"));
                    Window.TabbedPane.addTab("Pagos", new Pagos());
                    Window.setVisible(true);
                break;

            }            
            this.TransactionFrame.revalidate();
            this.TransactionFrame.repaint();             
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
    
    
    
    // Clase con Tabbed Pane donde cada Pestaña corresponde a una operacion permitada
    private class TransactionsWindow extends JFrame implements WindowListener {
        
        public JTabbedPane TabbedPane = new JTabbedPane();
    
        TransactionsWindow(){
            this.setSize(new Dimension(800,600));
            this.setTitle("Ventana de Transacciones - Cliente");
            this.setLayout(new BorderLayout());
            this.setVisible(false);
            //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);            
            this.setLocationRelativeTo(TransactionFrame);           
            this.add(TabbedPane,BorderLayout.CENTER);
            TransactionFrame.dispose();
            this.addWindowListener(this);
        }
        

        @Override
        public void windowOpened(WindowEvent e) {
            
        }

        @Override
        public void windowClosing(WindowEvent e) {
           int confirm = JOptionPane.showOptionDialog(null, "¿Desea regresar al modulo de Transacciones?", "Confirmacion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == 0) {
                TransactionFrame.show();
                this.dispose();
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {
            
        }

        @Override
        public void windowIconified(WindowEvent e) {
           
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            
        }

        @Override
        public void windowActivated(WindowEvent e) {
            
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            
        }
 
    }
    
    
    // Clases JPanel de cada operacion.
    
    private class AbrirCts extends JPanel implements ActionListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        JLabel idCuentaLbl = new JLabel();
        JLabel idClienteLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        JLabel montoLbl = new JLabel();
        
        JFormattedTextField idCuenta = new JFormattedTextField(new Integer(0));
        JFormattedTextField idCliente = new JFormattedTextField(new Integer(0));
        JFormattedTextField fechaAp = new JFormattedTextField();
        JFormattedTextField monto = new JFormattedTextField(new Double(0.00));
        
        JRadioButton ahorroRbtn = new JRadioButton();
        JRadioButton monetariaRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] auxVector= new String[5];
        String idAgencia,typeAgencia;
        
        AbrirCts(String arg1,String arg2,String arg3){
            
            this.idAgencia=arg1;
            this.typeAgencia=arg3;
            
            this.setLayout(new GridBagLayout());          
            GridBagConstraints Const = new GridBagConstraints();
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            GroupRbtn.add(ahorroRbtn);
            GroupRbtn.add(monetariaRbtn); 
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Cuenta:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            ahorroRbtn.setText("Ahorro");
            this.add(ahorroRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            monetariaRbtn.setText("Monetaria");
            this.add(monetariaRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idCuentaLbl.setText("ID Cuenta");
            this.add(idCuentaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            idClienteLbl.setText("ID Cliente");
            this.add(idClienteLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            fechaLbl.setText("Fecha Apertura");
            this.add(fechaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            montoLbl.setText("Monto Inicial");
            this.add(montoLbl,Const);
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCuenta.setPreferredSize(new Dimension(200,20));
            this.add(idCuenta, Const);

            Const.gridx=2;
            Const.gridy=2;
            idCliente.setPreferredSize(new Dimension(200,20));
            idCliente.setText(arg2);
            idCliente.setEnabled(false);
            this.add(idCliente, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            fechaAp.setPreferredSize(new Dimension(200,20));
            fechaAp.setText(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            fechaAp.setEnabled(false);
            this.add(fechaAp, Const);           
            
            Const.gridx=2;
            Const.gridy=4;
            monto.setPreferredSize(new Dimension(200,20));
            this.add(monto, Const);
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
            
            
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            auxVector[0]=idCuenta.getText();
            auxVector[1]=idCliente.getText();
            auxVector[2]=fechaAp.getText();
            auxVector[3]=monto.getText();
            auxVector[4]="25";
                    
            if(ahorroRbtn.isSelected()){
         
                Data.addReg(auxVector, Data.cAhorroMtx, Data.cAhorroMtxCounter);
            
                if(!(Data.checkPK(idCuenta.getText(),Data.cAhorroMtx,Data.cAhorroMtxCounter))){ 
                    Data.addValueIn(idCliente.getText(),idCuenta.getText(),Data.ClientesMtx,Data.ClientesMtxCounter,4);
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente.getText(), "TypeCl");
                    JOptionPane.showMessageDialog(null,"Apertura Exitosa", "Apertura", JOptionPane.INFORMATION_MESSAGE);
                    Data.cAhorroMtxCounter++;
                    
                } 
                
                Data.printMtx(Data.cAhorroMtx);
                
            }
            
            else if(monetariaRbtn.isSelected()){    
                
                Data.addReg(auxVector, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
                            
                if(!(Data.checkPK(idCuenta.getText(),Data.cMonetariaMtx,Data.cMonetariaMtxCounter))){  
                    Data.addValueIn(idCliente.getText(),idCuenta.getText(),Data.ClientesMtx,Data.ClientesMtxCounter,5);
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente.getText(), "TypeCl");
                    JOptionPane.showMessageDialog(null,"Apertura Exitosa", "Apertura", JOptionPane.INFORMATION_MESSAGE);
                    Data.cMonetariaMtxCounter++;                  
                }
                
                Data.printMtx(Data.cMonetariaMtx);
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        
    }
    
    private class Retiro extends JPanel implements ActionListener,ChangeListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        
        JLabel idCuentaLbl = new JLabel();
        JLabel montoLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        
        JComboBox idCuenta = new JComboBox();
        JFormattedTextField monto = new JFormattedTextField(new Double(0.00));
        JFormattedTextField fecha = new JFormattedTextField();
        
        JRadioButton ahorroRbtn = new JRadioButton();
        JRadioButton monetariaRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] auxVector= new String[3];
        String [] idsCuentas;
        String idAgencia,typeAgencia,idCliente;
        
        Retiro(String arg1,String arg2,String arg3){
            
            this.idAgencia=arg1;
            this.idCliente=arg2;
            this.typeAgencia=arg3;
            
            this.setLayout(new GridBagLayout());          
            GridBagConstraints Const = new GridBagConstraints();
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            GroupRbtn.add(ahorroRbtn);
            GroupRbtn.add(monetariaRbtn); 
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Cuenta:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            ahorroRbtn.setText("Ahorro");
            ahorroRbtn.addChangeListener(this);
            this.add(ahorroRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            monetariaRbtn.setText("Monetaria");
            monetariaRbtn.addChangeListener(this);
            this.add(monetariaRbtn, Const);  
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idCuentaLbl.setText("ID Cuenta");
            this.add(idCuentaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            montoLbl.setText("Monto a Retirar");
            this.add(montoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            fechaLbl.setText("Fecha ");
            this.add(fechaLbl,Const);
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCuenta.setPreferredSize(new Dimension(200,20));
            this.add(idCuenta, Const);

            Const.gridx=2;
            Const.gridy=2;
            monto.setPreferredSize(new Dimension(200,20));
            this.add(monto, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            fecha.setPreferredSize(new Dimension(200,20));
            fecha.setText(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            fecha.setEnabled(false);
            this.add(fecha, Const);
          
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            auxVector[0]=(String)idCuenta.getSelectedItem();
            auxVector[1]=monto.getText();
            auxVector[2]=fecha.getText();
            
            if(ahorroRbtn.isSelected()){
                
                
                if(Double.parseDouble(monto.getText().replace(",","")) <= Data.getSaldo((String)idCuenta.getSelectedItem(), "TypeAH" )){
                    
                    if(Double.parseDouble(monto.getText().replace(",","")) <= Data.getSaldo(idAgencia, typeAgencia)){
                      Data.makeDebito((String)idCuenta.getSelectedItem(), "TypeAH", Double.parseDouble(monto.getText().replace(",","")));
                      Data.makeDebito(idAgencia, typeAgencia, Double.parseDouble(monto.getText().replace(",","")));
                      Data.addReg(auxVector, Data.RetirosMtx, Data.RetirosMtxCounter);
                      Data.increaseTransac(idAgencia, typeAgencia);
                      Data.increaseTransac(idCliente, "TypeCl");
                      Data.RetirosMtxCounter++;
                      JOptionPane.showMessageDialog(null,"Retiro Exitoso", "Retiro", JOptionPane.INFORMATION_MESSAGE); 
                      Data.printMtx(Data.RetirosMtx);
                    }
                    
                    else {
                    JOptionPane.showMessageDialog(null,"Monto supera dinero Disponible en Agencia", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Monto supera dinero disponible en Cuenta", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                
            }
            else if(monetariaRbtn.isSelected()){
                
                if(Double.parseDouble(monto.getText().replace(",","")) <= Data.getSaldo((String)idCuenta.getSelectedItem(), "TypeM")){
                    if(Double.parseDouble(monto.getText().replace(",","")) <= Data.getSaldo(idAgencia, typeAgencia)){
                        Data.makeDebito((String)idCuenta.getSelectedItem(), "TypeM", Double.parseDouble(monto.getText().replace(",","")));
                        Data.makeDebito(idAgencia, typeAgencia, Double.parseDouble(monto.getText().replace(",","")));
                        Data.addReg(auxVector, Data.RetirosMtx, Data.RetirosMtxCounter);
                        Data.increaseTransac(idAgencia, typeAgencia);
                        Data.increaseTransac(idCliente, "TypeCl");
                        Data.RetirosMtxCounter++;
                        JOptionPane.showMessageDialog(null,"Retiro Exitoso", "Retiro", JOptionPane.INFORMATION_MESSAGE);
                        Data.printMtx(Data.RetirosMtx);
                    }
                    
                    else {
                    JOptionPane.showMessageDialog(null,"Monto supera dinero Disponible en Agencia", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
                else {
                    JOptionPane.showMessageDialog(null,"Monto supera dinero Disponible en Cuenta", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                
            }
            else {
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de cuenta", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        
        }       
        
        @Override
        public void stateChanged(ChangeEvent e) {
            
            if (ahorroRbtn.isSelected()) {
                idsCuentas=Data.getIDs(idCliente,"TypeAH");
                idCuenta.removeAllItems();
                for (String string : idsCuentas) {
                idCuenta.addItem(string);
                }
            }
            if (monetariaRbtn.isSelected()) {
                idsCuentas=Data.getIDs(idCliente,"TypeM");
                idCuenta.removeAllItems();
                for (String string : idsCuentas) {
                idCuenta.addItem(string);
                }
            }     
        }
        
    }
    
    private class Consulta extends JPanel implements ActionListener,ChangeListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        
        JLabel idCuentaLbl = new JLabel();
        JLabel saldoLbl = new JLabel();
        
        JComboBox idCuenta = new JComboBox();
        JFormattedTextField saldo = new JFormattedTextField();
        
        JRadioButton ahorroRbtn = new JRadioButton();
        JRadioButton monetariaRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] idsCuentas;
        String idAgencia,typeAgencia,idCliente;
        
        Consulta(String arg1,String arg2,String arg3){
            
            this.idAgencia=arg1;
            this.idCliente=arg2;
            this.typeAgencia=arg3;
            
            this.setLayout(new GridBagLayout());          
            GridBagConstraints Const = new GridBagConstraints();
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            GroupRbtn.add(ahorroRbtn);
            GroupRbtn.add(monetariaRbtn); 
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Cuenta:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            ahorroRbtn.setText("Ahorro");
            ahorroRbtn.addChangeListener(this);
            this.add(ahorroRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            monetariaRbtn.setText("Monetaria");
            monetariaRbtn.addChangeListener(this);
            this.add(monetariaRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idCuentaLbl.setText("ID Cuenta");
            this.add(idCuentaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            saldoLbl.setText("Saldo Disponible  Q.");
            this.add(saldoLbl,Const);
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCuenta.setPreferredSize(new Dimension(200,20));
            this.add(idCuenta, Const);

            Const.gridx=2;
            Const.gridy=2;
            saldo.setPreferredSize(new Dimension(200,20));
            saldo.setEnabled(false);
            this.add(saldo, Const);
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(ahorroRbtn.isSelected()){
                
                saldo.setText(Double.toString(Data.getSaldo((String)idCuenta.getSelectedItem(), "TypeAH")));
                Data.increaseTransac(idAgencia, typeAgencia);
                Data.increaseTransac(idCliente, "TypeCl");
                
                
            }
            else if(monetariaRbtn.isSelected()){
                
                saldo.setText(Double.toString(Data.getSaldo((String)idCuenta.getSelectedItem(), "TypeM")));
                Data.increaseTransac(idAgencia, typeAgencia);
                Data.increaseTransac(idCliente, "TypeCl");
                
            }
            
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            
            if (ahorroRbtn.isSelected()) {
                idsCuentas=Data.getIDs(idCliente,"TypeAH");
                idCuenta.removeAllItems();
                for (String string : idsCuentas) {
                idCuenta.addItem(string);
                }
            }
            if (monetariaRbtn.isSelected()) {
                idsCuentas=Data.getIDs(idCliente,"TypeM");
                idCuenta.removeAllItems();
                for (String string : idsCuentas) {
                idCuenta.addItem(string);
                }
            }
            
        }
        
    }
    
    private class Deposito extends JPanel implements ActionListener,ChangeListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        
        JLabel idCuentaLbl = new JLabel();
        JLabel montoLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        JLabel tipoDepLbl = new JLabel();
        JLabel idChequeLbl = new JLabel();
        
        JFormattedTextField idCuenta = new JFormattedTextField();
        JFormattedTextField monto = new JFormattedTextField();
        JFormattedTextField fecha = new JFormattedTextField();
        JFormattedTextField tipoDep = new JFormattedTextField();
        JFormattedTextField idCheque = new JFormattedTextField();
        
        JRadioButton efectivoRbtn = new JRadioButton();
        JRadioButton chequeRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] auxVector= new String[4];
        String idAgencia,typeAgencia;
        
        Deposito(String arg1,String arg2,String arg3){
            this.idAgencia=arg1;
            this.typeAgencia=arg3;
            
            this.setLayout(new GridBagLayout());          
            GridBagConstraints Const = new GridBagConstraints();
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            GroupRbtn.add(efectivoRbtn);
            GroupRbtn.add(chequeRbtn); 
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Deposito:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            efectivoRbtn.setText("Efectivo");
            efectivoRbtn.addChangeListener(this);
            this.add(efectivoRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            chequeRbtn.setText("Cheque");
            chequeRbtn.addChangeListener(this);
            this.add(chequeRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idCuentaLbl.setText("ID Cuenta");
            this.add(idCuentaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            montoLbl.setText("Monto a Depositar");
            this.add(montoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            fechaLbl.setText("Fecha ");
            this.add(fechaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            idChequeLbl.setText("ID Cheque");
            this.add(idChequeLbl,Const);
            
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCuenta.setPreferredSize(new Dimension(200,20));
            this.add(idCuenta, Const);

            Const.gridx=2;
            Const.gridy=2;
            monto.setPreferredSize(new Dimension(200,20));
            this.add(monto, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            fecha.setPreferredSize(new Dimension(200,20));
            fecha.setText(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            fecha.setEnabled(false);
            this.add(fecha, Const);   
            
            Const.gridx=2;
            Const.gridy=4;
            idCheque.setPreferredSize(new Dimension(200,20));
            idCheque.setEnabled(false);
            this.add(idCheque, Const); 
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
            
            
        }
       
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            
            if (efectivoRbtn.isSelected()) {
                idCheque.setEnabled(false);
            }
            if (chequeRbtn.isSelected()) {
                idCheque.setEnabled(true);
            }
        }
    }      
    
    private class CambioCheques extends JPanel implements ActionListener{
        
        public String IDAgencia;
        public String IDCliente;
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
    }
    
    private class Pagos extends JPanel implements ActionListener{
        
        public String IDAgencia;
        public String IDCliente;
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
        
    }
    
    private class EmisionCheques extends JPanel implements ActionListener{
        
         JButton okBtn = new JButton();
        
        JLabel idChequeLbl = new JLabel();
        JLabel idCuentaLbl = new JLabel();
        JLabel idCliente2Lbl = new JLabel();
        JLabel montoLbl = new JLabel();
        
        JFormattedTextField idCheque = new JFormattedTextField(new Integer(0));
        JComboBox idCuenta = new JComboBox();
        JFormattedTextField idCliente2 = new JFormattedTextField(new Integer(0));
        JFormattedTextField monto = new JFormattedTextField(new Double(0.00));
        
        String [] auxVector= new String[4];
        String [] auxVector2= new String[5];
        String [] idsCuentas;
        String idAgencia,typeAgencia,idCliente;
        
        EmisionCheques(String arg1,String arg2,String arg3){
            
            this.idAgencia=arg1;
            this.idCliente=arg2;
            this.typeAgencia=arg3;
            
            this.setLayout(new GridBagLayout());          
            GridBagConstraints Const = new GridBagConstraints();
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idChequeLbl.setText("ID Cheque");
            this.add(idChequeLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            idCuentaLbl.setText("ID Cuente Origen");
            this.add(idCuentaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            idCliente2Lbl.setText("ID Cliente Acreedor");
            this.add(idCliente2Lbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            montoLbl.setText("Monto   Q.");
            this.add(montoLbl,Const);
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCheque.setPreferredSize(new Dimension(200,20));
            this.add(idCheque, Const);

            Const.gridx=2;
            Const.gridy=2;
            idCuenta.setPreferredSize(new Dimension(200,20));
            this.add(idCuenta, Const);
            idsCuentas=Data.getIDs(idCliente,"TypeM");
            idCuenta.removeAllItems();
            for (String string : idsCuentas) {
            idCuenta.addItem(string);
            }
            
            Const.gridx=2;
            Const.gridy=3;
            idCliente2.setPreferredSize(new Dimension(200,20));
            this.add(idCliente2, Const);
            
            Const.gridx=2;
            Const.gridy=4;
            monto.setPreferredSize(new Dimension(200,20));
            this.add(monto, Const);
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            auxVector[0]=idCheque.getText();
            auxVector[1]=(String)idCuenta.getSelectedItem();
            auxVector[2]=idCliente2.getText();
            auxVector[3]=monto.getText();
            
            auxVector2=Data.readReg(auxVector[1],Data.cMonetariaMtx,Data.cMonetariaMtxCounter);
            
            if(Data.getSaldo(auxVector[1], "TypeM")>= Double.parseDouble(auxVector[3].replace(",",""))){
                
                if(!Data.checkPK(auxVector[0], Data.ChequesMtx, Data.ChequesMtxCounter)){
                    
                    if(Data.checkPK(auxVector[2], Data.ClientesMtx, Data.ClientesMtxCounter)){
                        
                        if(Integer.parseInt(auxVector2[4])>0){
                            
                            Data.addReg(auxVector, Data.ChequesMtx, Data.ChequesMtxCounter);
                            Data.makeDebito(auxVector[1],"TypeM",Double.parseDouble(auxVector[3].replace(",","")));
                            Data.increaseTransac(idAgencia, typeAgencia);
                            Data.increaseTransac(idCliente, "TypeCl");
                            Data.ChequesMtxCounter++;
                            Data.printMtx(Data.ChequesMtx);
                            //Se disminuye en 1 la cantidad de cheques disponibles en la cuenta monetaria                       
                            auxVector2[4]=Integer.toString(Integer.parseInt(auxVector2[4])-1);
                            Data.editReg(auxVector2[0], auxVector2, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
                            JOptionPane.showMessageDialog(null,auxVector2[4]+" Cheques Restantes", "Succes", JOptionPane.INFORMATION_MESSAGE); 

                        }
                        
                        else{
                            JOptionPane.showMessageDialog(null,"Cheques ya no disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                                                                                                 
                    }
                    
                    else{
                    JOptionPane.showMessageDialog(null,"ID de Cliente Acreedor no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                                        
                }
                
                else{
                JOptionPane.showMessageDialog(null,"ID de Cheque ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Monto supera saldo disponible en cuenta", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
    } 
            
    private class SolPrestamo extends JPanel{
        
    }
    
    private class Soltjt extends JPanel{
        
    }
    
    
    
    }
