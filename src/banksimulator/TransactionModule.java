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
import javax.swing.JScrollPane;
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
    
    private final  String[] columnNames = {"ID","Nombre","Direccion", "Telefono","Cuentas de Ahorro","Cuentas Monetarias","Prestamos","Tarjetas de Credito","Transacciones"};
    private final String[] lugaresMtx = {"Agencia Bancaria","Agencia con AutoBanco","Cajero Automatico","Call-Center"};
    
    private Object[][] tableData = Data.ClientesMtx;
    
    public JInternalFrame TransactionFrame = new JInternalFrame("Modulo de Transacciones",true,true,false,true);
    private JTable tablaClientes =  new JTable(tableData,columnNames);
    
    TransactionModule(){
        
       TransactionFrame.setVisible(true);
       TransactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
       tablaClientes.addMouseListener(this);
       TransactionFrame.add(new JScrollPane(tablaClientes),BorderLayout.CENTER);
       
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
                    Window.TabbedPane.addTab("Cambio de Cheques", new CambioCheques(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Emision de Cheques", new EmisionCheques(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Sol. Prestamo", new SolPrestamo(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Sol. Credito", new SolCredito(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Pagos", new Pagos(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.addTab("Consulta", new Consulta(IDPlace,IDCliente,"TypeA"));
                    Window.TabbedPane.add("Apertura Cuentas", new AbrirCts(IDPlace,IDCliente,"TypeA"));
                    Window.setVisible(true);
                break;
                
                case "Agencia con AutoBanco":
                    IDPlace = (String) JOptionPane.showInputDialog(null,"¿De que agencia viene?","AgenciasAuto",
                    JOptionPane.DEFAULT_OPTION,null,Data.getColumn(Data.AgenciasAutoMtx,0,Data.AgenciasAutoMtxCounter),Data.AgenciasAutoMtx[0][0]);
                    
                    Window.TabbedPane.addTab("Retiro", new Retiro(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Deposito", new Deposito(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Cambio de Cheques", new CambioCheques(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Emision de Cheques", new EmisionCheques(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Sol. Prestamo", new SolPrestamo(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Sol. Credito", new SolCredito(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Pagos", new Pagos(IDPlace,IDCliente,"TypeB"));
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
                    Window.TabbedPane.addTab("Transferencias", new Transferencias("Single",IDCliente,"TypeX"));
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
        
        JFormattedTextField idCuenta = new JFormattedTextField(Data.getMask("###"));
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
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(monto.getText().replace(",","")));
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
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(monto.getText().replace(",","")));
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
        
        JLabel idRetiroLbl = new JLabel();
        JLabel idCuentaLbl = new JLabel();
        JLabel montoLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        
        JFormattedTextField idRetiro = new JFormattedTextField();
        JComboBox idCuenta = new JComboBox();
        JFormattedTextField monto = new JFormattedTextField(new Double(0.00));
        JFormattedTextField fecha = new JFormattedTextField();
        
        JRadioButton ahorroRbtn = new JRadioButton();
        JRadioButton monetariaRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] auxVector= new String[4];
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
            idRetiroLbl.setText("ID Retiro");
            this.add(idRetiroLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            idCuentaLbl.setText("ID Cuenta");
            this.add(idCuentaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            montoLbl.setText("Monto a Retirar");
            this.add(montoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            fechaLbl.setText("Fecha ");
            this.add(fechaLbl,Const);
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idRetiro.setPreferredSize(new Dimension(200,20));
            this.add(idRetiro, Const);
            
            Const.gridx=2;
            Const.gridy=2;
            idCuenta.setPreferredSize(new Dimension(200,20));
            this.add(idCuenta, Const);

            Const.gridx=2;
            Const.gridy=3;
            monto.setPreferredSize(new Dimension(200,20));
            this.add(monto, Const);
            
            Const.gridx=2;
            Const.gridy=4;
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
            
            auxVector[0]=idRetiro.getText();
            auxVector[1]=(String)idCuenta.getSelectedItem();
            auxVector[2]=monto.getText();
            auxVector[3]=fecha.getText();
            
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
        JComboBox idCheque = new JComboBox();
        
        JRadioButton efectivoRbtn = new JRadioButton();
        JRadioButton chequeRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] idsCheques;
        String [] auxVector= new String[5];
        String [] auxVector2= new String[4];
        String idAgencia,typeAgencia,idCliente;
        
        Deposito(String arg1,String arg2,String arg3){
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
            monto.setEnabled(false);
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
            
            auxVector[0]=idCuenta.getText();
            auxVector[2]=fecha.getText();
            
            
            if(chequeRbtn.isSelected()){
                auxVector[4]=(String)idCheque.getSelectedItem();
                //Se lee el registro del cheque y se introduce monto
                auxVector2=Data.readReg(auxVector[4], Data.ChequesMtx, Data.ChequesMtxCounter);
                auxVector[1]=auxVector2[3];
                auxVector[3]="Cheque";
                if(Data.checkPK(idCuenta.getText(), Data.cAhorroMtx, Data.cAhorroMtxCounter)){
                    
                    Data.makeAbono(idCuenta.getText(), "TypeAH",Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.addReg(auxVector, Data.DepositosMtx, Data.DepositosMtxCounter);                   
                    Data.delReg(auxVector[4], Data.ChequesMtx, Data.ChequesMtxCounter);
                    Data.DepositosMtxCounter++;
                    Data.ChequesMtxCounter--;
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    JOptionPane.showMessageDialog(null,"Monto depositado a cuenta de Ahorro", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }
                if(Data.checkPK(idCuenta.getText(), Data.cMonetariaMtx, Data.cMonetariaMtxCounter)){
                    
                    Data.makeAbono(idCuenta.getText(), "TypeM",Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.addReg(auxVector, Data.DepositosMtx, Data.DepositosMtxCounter);
                    Data.delReg(auxVector[4], Data.ChequesMtx, Data.ChequesMtxCounter);
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    JOptionPane.showMessageDialog(null,"Monto depositado a cuenta Monetaria", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }
                
                
                

            }
            else if(efectivoRbtn.isSelected()){
                auxVector[4]="N/A";
                auxVector[1]=monto.getText();
                auxVector[3]="Efectivo";
                if(Data.checkPK(idCuenta.getText(), Data.cAhorroMtx, Data.cAhorroMtxCounter)){
                    
                    Data.makeAbono(idCuenta.getText(), "TypeAH",Double.parseDouble(auxVector[1].replace(",","")));
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(auxVector[1].replace(",","")));
                    Data.addReg(auxVector, Data.DepositosMtx, Data.DepositosMtxCounter);
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    JOptionPane.showMessageDialog(null,"Monto depositado a cuenta de Ahorro", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }
                if(Data.checkPK(idCuenta.getText(), Data.cMonetariaMtx, Data.cMonetariaMtxCounter)){
                    
                    Data.makeAbono(idCuenta.getText(), "TypeM",Double.parseDouble(auxVector[1].replace(",","")));
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(auxVector[1].replace(",","")));
                    Data.addReg(auxVector, Data.DepositosMtx, Data.DepositosMtxCounter);
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    JOptionPane.showMessageDialog(null,"Monto depositado a cuenta Monetaria", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de Deposito", "Error", JOptionPane.ERROR_MESSAGE);               
            }
        
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            
            if (efectivoRbtn.isSelected()) {
                idCheque.setEnabled(false);
                monto.setEnabled(true);
            }
            if (chequeRbtn.isSelected()) {
                idsCheques=Data.getCheques(idCliente);
                idCheque.removeAllItems();
                for (String string : idsCheques) {
                idCheque.addItem(string);
                }
                idCheque.setEnabled(true);
                monto.setEnabled(false);
            }
        }
    }      
    
    private class CambioCheques extends JPanel implements ActionListener,ChangeListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        
        JLabel idChequeLbl = new JLabel();
        JLabel idCuentaDesLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        
        JComboBox idCheque = new JComboBox();
        JFormattedTextField idCuentaDes = new JFormattedTextField();
        JFormattedTextField fecha = new JFormattedTextField();
        
        JRadioButton efectivoRbtn = new JRadioButton();
        JRadioButton depositoRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] idsCheques;
        String[] auxVector= new String[4];
        String[] auxVector2=new String[4];
        String idAgencia,typeAgencia,idCliente;
        
        CambioCheques(String arg1,String arg2,String arg3){
            
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
            GroupRbtn.add(efectivoRbtn);
            GroupRbtn.add(depositoRbtn); 
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Cambio:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            efectivoRbtn.setText("Efectivo");
            efectivoRbtn.addChangeListener(this);
            this.add(efectivoRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            depositoRbtn.setText("Deposito");
            depositoRbtn.addChangeListener(this);
            this.add(depositoRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idChequeLbl.setText("ID Cheque");
            this.add(idChequeLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            idCuentaDesLbl.setText("Cuenta Destino:");
            this.add(idCuentaDesLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            fechaLbl.setText("Fecha :");
            this.add(fechaLbl,Const);
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCheque.setPreferredSize(new Dimension(200,20));
            this.add(idCheque, Const);

            Const.gridx=2;
            Const.gridy=2;
            idCuentaDes.setPreferredSize(new Dimension(200,20));
            idCuentaDes.setEnabled(false);
            this.add(idCuentaDes, Const);
            
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
                   
            auxVector[0]=(String)idCheque.getSelectedItem();
            //Se lee el registro del cheque
            auxVector2=Data.readReg(auxVector[0], Data.ChequesMtx, Data.ChequesMtxCounter);
            //Se introduce ID de la cuenta origen.
            auxVector[1]=auxVector2[1];
            auxVector[2]=idCuentaDes.getText();
            auxVector[3]=fecha.getText();
            
                                    
            
            if(efectivoRbtn.isSelected()){  
                
                if(Data.getSaldo(idAgencia,typeAgencia )>= Double.parseDouble(auxVector2[3].replace(",",""))){
                    
                    Data.makeDebito(idAgencia,typeAgencia, Double.parseDouble(auxVector2[3].replace(",","")));                                      
                    Data.addReg(auxVector, Data.CambioChequesMtx, Data.CambioChequesMtxCounter);
                    Data.delReg(auxVector[0], Data.ChequesMtx, Data.ChequesMtxCounter);
                    Data.CambioChequesMtxCounter++;
                    Data.ChequesMtxCounter--;
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Monto supera efectivo en agencia", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
            else if(depositoRbtn.isSelected()){
                
                if(Data.checkPK(idCuentaDes.getText(), Data.cAhorroMtx, Data.cAhorroMtxCounter)){
                    
                    Data.makeAbono(idCuentaDes.getText(), "TypeAH",Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.addReg(auxVector, Data.CambioChequesMtx, Data.CambioChequesMtxCounter);
                    Data.delReg(auxVector[0], Data.ChequesMtx, Data.ChequesMtxCounter);
                    Data.CambioChequesMtxCounter++;
                    Data.ChequesMtxCounter--;
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    JOptionPane.showMessageDialog(null,"Monto depositado a cuenta de Ahorro", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(Data.checkPK(idCuentaDes.getText(), Data.cMonetariaMtx, Data.cMonetariaMtxCounter)){
                    
                    Data.makeAbono(idCuentaDes.getText(), "TypeM",Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.makeAbono(idAgencia, typeAgencia,Double.parseDouble(auxVector2[3].replace(",","")));
                    Data.addReg(auxVector, Data.CambioChequesMtx, Data.CambioChequesMtxCounter);
                    Data.delReg(auxVector[0], Data.ChequesMtx, Data.ChequesMtxCounter);
                    Data.CambioChequesMtxCounter++;
                    Data.ChequesMtxCounter--;
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    JOptionPane.showMessageDialog(null,"Monto depositado a cuenta Monetaria", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Cuenta de destino no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else{
                
            }
            
            
        
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            
            if (efectivoRbtn.isSelected()) {
                idsCheques=Data.getCheques(idCliente);
                idCheque.removeAllItems();
                for (String string : idsCheques) {
                idCheque.addItem(string);
                }
                idCuentaDes.setText("N/A");
                idCuentaDes.setEnabled(false);
            }
            if (depositoRbtn.isSelected()) {
                idsCheques=Data.getCheques(idCliente);
                idCheque.removeAllItems();
                for (String string : idsCheques) {
                idCheque.addItem(string);
                }     
                idCuentaDes.setText("");
                idCuentaDes.setEnabled(true);
            }
            
        }
    }
    
    private class Pagos extends JPanel implements ActionListener,ChangeListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        JLabel title2Rbtn = new JLabel();
        
        JLabel idPagoLbl = new JLabel();
        JLabel conceptoLbl = new JLabel();
        JLabel montoLbl = new JLabel();
        JLabel tipoLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        
        JComboBox idCheque = new JComboBox();     
        JFormattedTextField idPago = new JFormattedTextField();       
        JComboBox concepto = new JComboBox();
        JFormattedTextField monto = new JFormattedTextField(new Double(0.00));
        JFormattedTextField tipoPago = new JFormattedTextField();
        JFormattedTextField fecha = new JFormattedTextField();
        
        JRadioButton servicioRbtn = new JRadioButton();
        JRadioButton prestamoRbtn = new JRadioButton();
        JRadioButton creditoRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        JRadioButton efectivoRbtn = new JRadioButton();
        JRadioButton chequeRbtn = new JRadioButton();
        ButtonGroup Group2Rbtn = new ButtonGroup();
        
        String [] idsVector;
        int respuesta;
        String respuesta2;
        String [] Opciones={"Obtener en Efectivo","Depositar"};
        String [] Opciones2={"Ahorro","Monetaria"};
        String [] idsCheques;
        String [] cuentas;
        String[] auxVector= new String[5];
        String[] auxVector2=new String[4];
        String idAgencia,typeAgencia,idCliente;
        
        Pagos(String arg1,String arg2,String arg3){
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
            GroupRbtn.add(servicioRbtn);
            GroupRbtn.add(prestamoRbtn);
            GroupRbtn.add(creditoRbtn);
            
            Group2Rbtn.add(efectivoRbtn);
            Group2Rbtn.add(chequeRbtn); 
            
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de pago:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            servicioRbtn.setText("Servicios");
            servicioRbtn.addChangeListener(this);
            this.add(servicioRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            prestamoRbtn.setText("Prestamo");
            prestamoRbtn.addChangeListener(this);
            this.add(prestamoRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=4;
            creditoRbtn.setText("Credito");
            creditoRbtn.addChangeListener(this);
            this.add(creditoRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=5;
            title2Rbtn.setText("Metodo de Pago:");
            this.add(title2Rbtn, Const);
            
            Const.gridx=0;
            Const.gridy=6;
            efectivoRbtn.setText("Efectivo");
            efectivoRbtn.addChangeListener(this);
            this.add(efectivoRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=7;
            chequeRbtn.setText("Cheque");
            chequeRbtn.addChangeListener(this);
            this.add(chequeRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=8;
            idCheque.setEnabled(false);
            idCheque.setPreferredSize(new Dimension(100,20));
            this.add(idCheque, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idPagoLbl.setText("ID Pago");
            this.add(idPagoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            conceptoLbl.setText("Concepto");
            this.add(conceptoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            montoLbl.setText("Monto");
            this.add(montoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            tipoLbl.setText("Tipo");
            this.add(tipoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            fechaLbl.setText("Fecha ");
            this.add(fechaLbl,Const);                                  
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idPago.setPreferredSize(new Dimension(200,20));
            this.add(idPago, Const);
            
            Const.gridx=2;
            Const.gridy=2;
            concepto.setPreferredSize(new Dimension(200,20));
            this.add(concepto, Const);

            Const.gridx=2;
            Const.gridy=3;
            monto.setPreferredSize(new Dimension(200,20));
            this.add(monto, Const);
            
            Const.gridx=2;
            Const.gridy=4;
            tipoPago.setPreferredSize(new Dimension(200,20));
            tipoPago.setEnabled(false);
            this.add(tipoPago, Const); 
            
            Const.gridx=2;
            Const.gridy=5;
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
            
            auxVector[0]=idPago.getText();
            auxVector[1]=(String)concepto.getSelectedItem();
            auxVector[2]=monto.getText();
            auxVector[3]=tipoPago.getText();
            auxVector[4]=fecha.getText();
                      
            if(servicioRbtn.isSelected()){
                
                if(efectivoRbtn.isSelected()){
                    if(!Data.checkPK(idPago.getText(), Data.PagosMtx, Data.PagosMtxCounter)){                       
                        Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter);
                        Data.makeAbono(idAgencia, typeAgencia, Double.parseDouble(monto.getText().replace(",","")));
                        Data.PagosMtxCounter++;
                        Data.increaseTransac(idAgencia, typeAgencia);
                        Data.increaseTransac(idCliente, "TypeCl");
                        JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    }  
                    else{
                        JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                else if(chequeRbtn.isSelected()){
                    
                    auxVector2=Data.readReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                    
                    if(!Data.checkPK(idPago.getText(), Data.PagosMtx, Data.PagosMtxCounter)){   
                        
                        if(Double.parseDouble(auxVector2[3].replace(",",""))<= Double.parseDouble(monto.getText().replace(",",""))){
                          Data.delReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                          Data.ChequesMtxCounter--;
                          Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter); 
                          Data.PagosMtxCounter++;
                          Data.increaseTransac(idAgencia, typeAgencia);
                          Data.increaseTransac(idCliente, "TypeCl");
                          JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                          }  
                        else{
                            Double diferencia = Double.parseDouble(auxVector2[3].replace(",",""))-Double.parseDouble(monto.getText().replace(",",""));
                            Data.delReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                            Data.ChequesMtxCounter--;
                            Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter);                   
                            Data.PagosMtxCounter++;
                            Data.increaseTransac(idAgencia, typeAgencia);
                            Data.increaseTransac(idCliente, "TypeCl");
                            respuesta = JOptionPane.showOptionDialog(this,"Tiene un Diferencia de "+diferencia+" ¿Que desea hacer?","Succes",JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,null,Opciones,Opciones[0]);
                            if(respuesta==0){
                                JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                respuesta = JOptionPane.showOptionDialog(this,"Dese depositar a cuenta de ahorro o monetaria?","Succes",JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,null,Opciones2,Opciones2[0]);
                                if(respuesta==0){
                                    cuentas=Data.getIDs(idCliente, "TypeAH");
                                    respuesta2=(String)JOptionPane.showInputDialog(null, "Seleccione una cuenta", "Cuenta", JOptionPane.DEFAULT_OPTION,null,cuentas,cuentas[0]);
                                    Data.makeAbono(respuesta2, "TypeAH", diferencia);
                                    JOptionPane.showMessageDialog(null,"Depositado a Cuenta de Ahorro", "Succes", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    cuentas=Data.getIDs(idCliente, "TypeM");
                                    respuesta2=(String)JOptionPane.showInputDialog(null, "Seleccione una cuenta", "Cuenta", JOptionPane.DEFAULT_OPTION,null,cuentas,cuentas[0]);
                                    Data.makeAbono(respuesta2, "TypeM", diferencia);
                                    JOptionPane.showMessageDialog(null,"Depositado a Cuenta Monetaria", "Succes", JOptionPane.INFORMATION_MESSAGE);
                                    
                                }
                            }
                        }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }                                                                                                                                     
                }  
                
                else{
                        JOptionPane.showMessageDialog(null,"Seleccione un metodo de pago", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            else if(prestamoRbtn.isSelected()){
                
                if(efectivoRbtn.isSelected()){
                    if(!Data.checkPK(idPago.getText(), Data.PagosMtx, Data.PagosMtxCounter)){
                        auxVector[1]=auxVector[1]+" - Prestamo";
                        Data.makeAbono(idAgencia, typeAgencia, Double.parseDouble(monto.getText().replace(",","")));
                        Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter);
                        Data.PagosMtxCounter++;
                        Data.increaseTransac(idAgencia, typeAgencia);
                        Data.increaseTransac(idCliente, "TypeCl");
                        Data.makeAbono((String)concepto.getSelectedItem(), "TypeP", Double.parseDouble(monto.getText().replace(",","")));
                        JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    }  
                    else{
                        JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                }
                
                else if(chequeRbtn.isSelected()){
                    
                    auxVector2=Data.readReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                    
                    if(!Data.checkPK(idPago.getText(), Data.PagosMtx, Data.PagosMtxCounter)){   
                        
                        if(Double.parseDouble(auxVector2[3].replace(",",""))<= Double.parseDouble(monto.getText().replace(",",""))){
                          Data.delReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                          Data.ChequesMtxCounter--;
                          auxVector[1]=auxVector[1]+" - Prestamo";
                          Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter); 
                          Data.PagosMtxCounter++;
                          Data.increaseTransac(idAgencia, typeAgencia);
                          Data.increaseTransac(idCliente, "TypeCl");
                          Data.makeAbono((String)concepto.getSelectedItem(), "TypeP", Double.parseDouble(monto.getText().replace(",","")));
                          JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                          }  
                        else{
                            Double diferencia = Double.parseDouble(auxVector2[3].replace(",",""))-Double.parseDouble(monto.getText().replace(",",""));
                            Data.delReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                            Data.ChequesMtxCounter--;
                            Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter);                   
                            Data.PagosMtxCounter++;
                            Data.increaseTransac(idAgencia, typeAgencia);
                            Data.increaseTransac(idCliente, "TypeCl");
                            respuesta = JOptionPane.showOptionDialog(this,"Tiene un Diferencia de "+diferencia+" ¿Que desea hacer?","Succes",JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,null,Opciones,Opciones[0]);
                            if(respuesta==0){
                                JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                respuesta = JOptionPane.showOptionDialog(this,"Dese depositar a cuenta de ahorro o monetaria?","Succes",JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,null,Opciones2,Opciones2[0]);
                                if(respuesta==0){
                                    cuentas=Data.getIDs(idCliente, "TypeAH");
                                    respuesta2=(String)JOptionPane.showInputDialog(null, "Seleccione una cuenta", "Cuenta", JOptionPane.DEFAULT_OPTION,null,cuentas,cuentas[0]);
                                    Data.makeAbono(respuesta2, "TypeAH", diferencia);
                                    JOptionPane.showMessageDialog(null,"Depositado a Cuenta de Ahorro", "Succes", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    cuentas=Data.getIDs(idCliente, "TypeM");
                                    respuesta2=(String)JOptionPane.showInputDialog(null, "Seleccione una cuenta", "Cuenta", JOptionPane.DEFAULT_OPTION,null,cuentas,cuentas[0]);
                                    Data.makeAbono(respuesta2, "TypeM", diferencia);
                                    JOptionPane.showMessageDialog(null,"Depositado a Cuenta Monetaria", "Succes", JOptionPane.INFORMATION_MESSAGE);
                                    
                                }
                            }
                        }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                else{
                        JOptionPane.showMessageDialog(null,"Seleccione un metodo de pago", "Error", JOptionPane.ERROR_MESSAGE);
                }
                                              
            }
            
            else if(creditoRbtn.isSelected()){
                
                if(efectivoRbtn.isSelected()){
                    
                    if(!Data.checkPK(idPago.getText(), Data.PagosMtx, Data.PagosMtxCounter)){  
                        auxVector[1]=auxVector[1]+" - Credito";
                        Data.makeAbono(idAgencia, typeAgencia, Double.parseDouble(monto.getText().replace(",","")));
                        Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter);
                        Data.PagosMtxCounter++;
                        Data.increaseTransac(idAgencia, typeAgencia);
                        Data.increaseTransac(idCliente, "TypeCl");
                        Data.makeAbono((String)concepto.getSelectedItem(), "TypeCR", Double.parseDouble(monto.getText().replace(",","")));
                        JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    }  
                    else{
                        JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                
                }
                
                else if(chequeRbtn.isSelected()){
                    auxVector2=Data.readReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                    
                    if(!Data.checkPK(idPago.getText(), Data.PagosMtx, Data.PagosMtxCounter)){   
                        
                        if(Double.parseDouble(auxVector2[3].replace(",",""))<= Double.parseDouble(monto.getText().replace(",",""))){
                          Data.delReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                          Data.ChequesMtxCounter--;
                          auxVector[1]=auxVector[1]+" - Credito";
                          Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter); 
                          Data.PagosMtxCounter++;
                          Data.increaseTransac(idAgencia, typeAgencia);
                          Data.increaseTransac(idCliente, "TypeCl");
                          Data.makeAbono((String)concepto.getSelectedItem(), "TypeCR", Double.parseDouble(monto.getText()));
                          JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                          }  
                        else{
                            Double diferencia = Double.parseDouble(auxVector2[3].replace(",",""))-Double.parseDouble(monto.getText().replace(",",""));
                            Data.delReg((String)idCheque.getSelectedItem(), Data.ChequesMtx, Data.ChequesMtxCounter);
                            Data.ChequesMtxCounter--;
                            Data.addReg(auxVector, Data.PagosMtx, Data.PagosMtxCounter);                   
                            Data.PagosMtxCounter++;
                            Data.increaseTransac(idAgencia, typeAgencia);
                            Data.increaseTransac(idCliente, "TypeCl");
                            respuesta = JOptionPane.showOptionDialog(this,"Tiene un Diferencia de "+diferencia+" ¿Que desea hacer?","Succes",JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,null,Opciones,Opciones[0]);
                            if(respuesta==0){
                                JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                respuesta = JOptionPane.showOptionDialog(this,"Dese depositar a cuenta de ahorro o monetaria?","Succes",JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,null,Opciones2,Opciones2[0]);
                                if(respuesta==0){
                                    cuentas=Data.getIDs(idCliente, "TypeAH");
                                    respuesta2=(String)JOptionPane.showInputDialog(null, "Seleccione una cuenta", "Cuenta", JOptionPane.DEFAULT_OPTION,null,cuentas,cuentas[0]);
                                    Data.makeAbono(respuesta2, "TypeAH", diferencia);
                                    JOptionPane.showMessageDialog(null,"Depositado a Cuenta de Ahorro", "Succes", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    cuentas=Data.getIDs(idCliente, "TypeM");
                                    respuesta2=(String)JOptionPane.showInputDialog(null, "Seleccione una cuenta", "Cuenta", JOptionPane.DEFAULT_OPTION,null,cuentas,cuentas[0]);
                                    Data.makeAbono(respuesta2, "TypeM", diferencia);
                                    JOptionPane.showMessageDialog(null,"Depositado a Cuenta Monetaria", "Succes", JOptionPane.INFORMATION_MESSAGE);
                                    
                                }
                            }
                        }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                else{
                        JOptionPane.showMessageDialog(null,"Seleccione un metodo de pago", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de pago", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if(servicioRbtn.isSelected()){
                
                concepto.removeAllItems();
                concepto.addItem("Agua");
                concepto.addItem("Luz");
                concepto.addItem("Telefono");
           
            }
            if(prestamoRbtn.isSelected()){              
                idsVector=Data.getIDs(idCliente,"TypeP");
                concepto.removeAllItems();
                for (String string : idsVector) {
                concepto.addItem(string);
                }                               
            }
            if(creditoRbtn.isSelected()){                              
                idsVector=Data.getIDs(idCliente,"TypeCR");
                concepto.removeAllItems();
                for (String string : idsVector) {
                concepto.addItem(string);
                }              
            }
            
            //--Medio de Pago
            
            if(efectivoRbtn.isSelected()){
                monto.setText("");
                monto.setEnabled(true);               
                idCheque.setEnabled(false);
                tipoPago.setText("Efectivo");
            }
            if(chequeRbtn.isSelected()){
                idsCheques=Data.getCheques(idCliente);
                idCheque.removeAllItems();
                for (String string : idsCheques) {
                idCheque.addItem(string);
                }     
                idCheque.setEnabled(true);
                tipoPago.setText("Cheque");
            }
        }
        
    }
    
    private class EmisionCheques extends JPanel implements ActionListener{
        
         JButton okBtn = new JButton();
        
        JLabel idChequeLbl = new JLabel();
        JLabel idCuentaLbl = new JLabel();
        JLabel idCliente2Lbl = new JLabel();
        JLabel montoLbl = new JLabel();
        
        JFormattedTextField idCheque = new JFormattedTextField(Data.getMask("###"));
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
                            Data.makeDebito((String)idCuenta.getSelectedItem(), "TypeM", Double.parseDouble(monto.getText().replace(",","")));
                            Data.increaseTransac(idAgencia, typeAgencia);
                            Data.increaseTransac(idCliente, "TypeCl");
                            Data.ChequesMtxCounter++;
                            Data.printMtx(Data.ChequesMtx);
                            //Se disminuye en 1 la cantidad de cheques disponibles en la cuenta monetaria
                            auxVector2=Data.readReg(auxVector[1],Data.cMonetariaMtx,Data.cMonetariaMtxCounter);
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
            
    private class SolPrestamo extends JPanel implements ActionListener{
        
        JButton okBtn = new JButton();
        
        JLabel idPrestamoLbl = new JLabel();
        JLabel idClienteLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        JLabel montoPresLbl = new JLabel();
        JLabel montoAboLbl = new JLabel();
        
        JFormattedTextField idPrestamo = new JFormattedTextField();
        JFormattedTextField idClienteField = new JFormattedTextField();
        JFormattedTextField fecha = new JFormattedTextField();
        JFormattedTextField montoPres = new JFormattedTextField();
        JFormattedTextField montoAbo = new JFormattedTextField();
        
        String [] auxVector= new String[5];
        String idAgencia,typeAgencia,idCliente;
        
        SolPrestamo(String arg1,String arg2,String arg3){
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
            idPrestamoLbl.setText("ID Prestamo:");
            this.add(idPrestamoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            idClienteLbl.setText("ID Cliente:");
            this.add(idClienteLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            fechaLbl.setText("Fecha: ");
            this.add(fechaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            montoPresLbl.setText("Monto Prestado: ");
            this.add(montoPresLbl,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            montoAboLbl.setText("Monto Abonado:");
            this.add(montoAboLbl,Const);
            
             //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idPrestamo.setPreferredSize(new Dimension(200,20));
            this.add(idPrestamo, Const);

            Const.gridx=2;
            Const.gridy=2;
            idClienteField.setPreferredSize(new Dimension(200,20));
            idClienteField.setText(idCliente);
            idClienteField.setEnabled(false);
            this.add(idClienteField, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            fecha.setPreferredSize(new Dimension(200,20));
            fecha.setText(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            fecha.setEnabled(false);
            this.add(fecha, Const);   
            
            Const.gridx=2;
            Const.gridy=4;
            montoPres.setPreferredSize(new Dimension(200,20));
            this.add(montoPres, Const); 
            
            Const.gridx=2;
            Const.gridy=5;
            montoAbo.setPreferredSize(new Dimension(200,20));
            montoAbo.setText("0");
            montoAbo.setEnabled(false);
            this.add(montoAbo, Const);
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            auxVector[0]=idPrestamo.getText();
            auxVector[1]=idClienteField.getText();
            auxVector[2]=fecha.getText();
            auxVector[3]=montoPres.getText();
            auxVector[4]=montoAbo.getText();
            if (!Data.checkPK(auxVector[0], Data.sPrestamosMtx, Data.sPrestamosMtxCounter)&&!Data.checkPK(auxVector[0], Data.aPrestamosMtx, Data.aPrestamosMtxCounter)){
                if(Data.checkPK(auxVector[1], Data.ClientesMtx, Data.ClientesMtxCounter)){
                                       
                    Data.addReg(auxVector, Data.sPrestamosMtx, Data.sPrestamosMtxCounter);
                    Data.sPrestamosMtxCounter++;
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    Data.printMtx(Data.sCreditoMtx);
                    
                    JOptionPane.showMessageDialog(null,"Solicitud Enviada a Departamento Financiero", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"ID Cliente no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }              
            }
            else{
                JOptionPane.showMessageDialog(null,"ID Prestamo ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    private class SolCredito extends JPanel implements ActionListener{
        
        JButton okBtn = new JButton();
        
        JLabel idPrestamoLbl = new JLabel();
        JLabel idClienteLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        JLabel limiteCreLbl = new JLabel();
        JLabel montoAdeLbl = new JLabel();
        
        JFormattedTextField idCredito = new JFormattedTextField();
        JFormattedTextField idClienteField = new JFormattedTextField();
        JFormattedTextField fecha = new JFormattedTextField(Data.getMask("##/##/##"));
        JFormattedTextField limiteCre = new JFormattedTextField();
        JFormattedTextField montoAde = new JFormattedTextField();
        
        String [] auxVector= new String[5];
        String idAgencia,typeAgencia,idCliente;
        
        SolCredito(String arg1,String arg2,String arg3){
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
            idPrestamoLbl.setText("ID Tarjeta:");
            this.add(idPrestamoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            idClienteLbl.setText("ID Cliente:");
            this.add(idClienteLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            fechaLbl.setText("Fecha Vencimiento: ");
            this.add(fechaLbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            limiteCreLbl.setText("Limite de Credito: ");
            this.add(limiteCreLbl,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            montoAdeLbl.setText("Monto Adeudado:");
            this.add(montoAdeLbl,Const);
            
             //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCredito.setPreferredSize(new Dimension(200,20));
            this.add(idCredito, Const);

            Const.gridx=2;
            Const.gridy=2;
            idClienteField.setPreferredSize(new Dimension(200,20));
            idClienteField.setText(idCliente);
            idClienteField.setEnabled(false);
            this.add(idClienteField, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            fecha.setPreferredSize(new Dimension(200,20));
            this.add(fecha, Const);   
            
            Const.gridx=2;
            Const.gridy=4;
            limiteCre.setPreferredSize(new Dimension(200,20));
            this.add(limiteCre, Const); 
            
            Const.gridx=2;
            Const.gridy=5;
            montoAde.setPreferredSize(new Dimension(200,20));
            montoAde.setText("0");
            montoAde.setEnabled(false);
            this.add(montoAde, Const);
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            auxVector[0]=idCredito.getText();
            auxVector[1]=idClienteField.getText();
            auxVector[2]=fecha.getText();
            auxVector[3]=limiteCre.getText();
            auxVector[4]=montoAde.getText();
            if (!Data.checkPK(auxVector[0], Data.sCreditoMtx, Data.sCreditoMtxCounter)&&!Data.checkPK(auxVector[0], Data.aCreditoMtx, Data.aCreditoMtxCounter)){
                if(Data.checkPK(auxVector[1], Data.ClientesMtx, Data.ClientesMtxCounter)){
                                       
                    Data.addReg(auxVector, Data.sCreditoMtx, Data.sCreditoMtxCounter);
                    Data.sCreditoMtxCounter++;
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.increaseTransac(idCliente, "TypeCl");
                    
                    JOptionPane.showMessageDialog(null,"Solicitud Enviada a Departamento Financiero", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"ID Cliente no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }              
            }
            else{
                JOptionPane.showMessageDialog(null,"ID Credito ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
    }
    
    private class Transferencias extends JPanel implements ActionListener,ChangeListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        JLabel title2Rbtn = new JLabel();
        
        JLabel idTransLbl = new JLabel();
        JLabel cuentaOrLbl = new JLabel();
        JLabel cuentaDesLbl = new JLabel();
        JLabel conceptoLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        JLabel montoLbl = new JLabel();
        JLabel tipoLbl = new JLabel();
             
        JFormattedTextField idTransferencia = new JFormattedTextField();       
        JComboBox cuentaOr = new JComboBox();
        JFormattedTextField idCuentaDes = new JFormattedTextField(); 
        JComboBox concepto = new JComboBox();
        JFormattedTextField fecha = new JFormattedTextField();
        JFormattedTextField monto = new JFormattedTextField();        
        JFormattedTextField tipoPago = new JFormattedTextField();
        
        JRadioButton cuentaRbtn = new JRadioButton();
        JRadioButton servicioRbtn = new JRadioButton();
        JRadioButton prestamoRbtn = new JRadioButton();
        JRadioButton creditoRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        JRadioButton ahorroRbtn = new JRadioButton();
        JRadioButton monetariaRbtn = new JRadioButton();
        ButtonGroup Group2Rbtn = new ButtonGroup();
        
        String [] idsVector;
        String [] idsCuentas;
        String[] auxVector= new String[7];
        String[] auxVector2=new String[4];
        String idAgencia,typeAgencia,idCliente;
        
        Transferencias(String arg1,String arg2,String arg3){
            
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
            GroupRbtn.add(cuentaRbtn);
            GroupRbtn.add(servicioRbtn);
            GroupRbtn.add(prestamoRbtn);
            GroupRbtn.add(creditoRbtn);
            
            Group2Rbtn.add(ahorroRbtn);
            Group2Rbtn.add(monetariaRbtn); 
            
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Transferencia:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            cuentaRbtn.setText("Cuenta de Tercero");
            cuentaRbtn.addChangeListener(this);
            this.add(cuentaRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            servicioRbtn.setText("Servicios");
            servicioRbtn.addChangeListener(this);
            this.add(servicioRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=4;
            prestamoRbtn.setText("Prestamo");
            prestamoRbtn.addChangeListener(this);
            this.add(prestamoRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=5;
            creditoRbtn.setText("Credito");
            creditoRbtn.addChangeListener(this);
            this.add(creditoRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=6;
            title2Rbtn.setText("Cuenta para Pago:");
            this.add(title2Rbtn, Const);
            
            Const.gridx=0;
            Const.gridy=7;
            ahorroRbtn.setText("Ahorros");
            ahorroRbtn.addChangeListener(this);
            this.add(ahorroRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=8;
            monetariaRbtn.setText("Monetaria");
            monetariaRbtn.addChangeListener(this);
            this.add(monetariaRbtn, Const);
            
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            idTransLbl.setText("ID Transferencia");
            this.add(idTransLbl,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            cuentaOrLbl.setText("Cuenta Origen");
            this.add(cuentaOrLbl,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            cuentaDesLbl.setText("Cuenta Destino");
            this.add(cuentaDesLbl,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            conceptoLbl.setText("Concepto");
            this.add(conceptoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            fechaLbl.setText("Fecha ");
            this.add(fechaLbl,Const);                                  
            
            Const.gridx=1;
            Const.gridy=6;
            montoLbl.setText("Monto");
            this.add(montoLbl,Const);
            
            Const.gridx=1;
            Const.gridy=7;
            tipoLbl.setText("Tipo");
            this.add(tipoLbl,Const);
            
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idTransferencia.setPreferredSize(new Dimension(200,20));
            this.add(idTransferencia, Const);
            
            Const.gridx=2;
            Const.gridy=2;
            cuentaOr.setPreferredSize(new Dimension(200,20));
            this.add(cuentaOr, Const);

            Const.gridx=2;
            Const.gridy=3;
            idCuentaDes.setPreferredSize(new Dimension(200,20));
            idCuentaDes.setEnabled(false);
            this.add(idCuentaDes, Const);
            
            Const.gridx=2;
            Const.gridy=4;
            concepto.setPreferredSize(new Dimension(200,20));
            concepto.setEnabled(false);
            this.add(concepto, Const);
            
            Const.gridx=2;
            Const.gridy=5;
            fecha.setPreferredSize(new Dimension(200,20));
            fecha.setText(new SimpleDateFormat("dd-mm-yyyy").format(new Date()));
            fecha.setEnabled(false);
            this.add(fecha, Const);   
            
            Const.gridx=2;
            Const.gridy=6;
            monto.setPreferredSize(new Dimension(200,20));
            this.add(monto, Const);
                 
            Const.gridx=2;
            Const.gridy=7;
            tipoPago.setPreferredSize(new Dimension(200,20));
            tipoPago.setEnabled(false);
            this.add(tipoPago, Const); 
               
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            okBtn.addActionListener(this);
            this.add(okBtn,Const);
                                 
        }
        

        @Override
        public void actionPerformed(ActionEvent e) {
            auxVector[0]=idTransferencia.getText();
            auxVector[1]=(String)cuentaOr.getSelectedItem();
            auxVector[2]=idCuentaDes.getText();
            auxVector[3]=(String)concepto.getSelectedItem();
            auxVector[4]=fecha.getText();
            auxVector[5]=monto.getText();
            auxVector[6]=tipoPago.getText();
        if(Data.checkPK(idTransferencia.getText(), Data.oCallCenterMtx, Data.oCallCenterMtxCounter)) {   
            if(cuentaRbtn.isSelected()){
                if(Data.checkPK(idCuentaDes.getText(), Data.cAhorroMtx, Data.cAhorroMtxCounter)){
                   Data.addReg(auxVector, Data.oCallCenterMtx, Data.oCallCenterMtxCounter);
                   Data.oCallCenterMtxCounter++;
                   Data.makeAbono(idCuentaDes.getText(), "TypeAH", Double.parseDouble(monto.getText().replace(",","")));
                   
                   if(ahorroRbtn.isSelected()){
                        Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeAH", Double.parseDouble(monto.getText().replace(",","")));
                   }
                   else{
                        Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeM", Double.parseDouble(monto.getText().replace(",","")));
                   }
                   
                }
                else{
                    JOptionPane.showMessageDialog(null,"ID Cuenta destino no existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(servicioRbtn.isSelected()){
                
                Data.addReg(auxVector, Data.oCallCenterMtx, Data.oCallCenterMtxCounter);
                Data.oCallCenterMtxCounter++;  
                Data.increaseTransac(idCliente, "TypeCL");
                JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                if(ahorroRbtn.isSelected()){
                     Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeAH", Double.parseDouble(monto.getText().replace(",","")));
                }
                else{
                     Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeM", Double.parseDouble(monto.getText().replace(",","")));
                }
                
            }
            else if(prestamoRbtn.isSelected()){
                
                Data.addReg(auxVector, Data.oCallCenterMtx, Data.oCallCenterMtxCounter);
                Data.oCallCenterMtxCounter++; 
                Data.increaseTransac(idCliente, "TypeCL");
                Data.makeAbono((String)concepto.getSelectedItem(), "TypeP",Double.parseDouble(monto.getText().replace(",","")));
                JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                if(ahorroRbtn.isSelected()){
                     Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeAH", Double.parseDouble(monto.getText().replace(",","")));
                }
                else if(monetariaRbtn.isSelected()){
                     Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeM", Double.parseDouble(monto.getText().replace(",","")));
                }
                else{
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de metodo de Pago", "Error", JOptionPane.ERROR_MESSAGE);
                }   
                
            }
            else if(creditoRbtn.isSelected()){
                
                Data.addReg(auxVector, Data.oCallCenterMtx, Data.oCallCenterMtxCounter);
                Data.oCallCenterMtxCounter++;
                Data.increaseTransac(idCliente, "TypeCL");
                Data.makeAbono((String)concepto.getSelectedItem(), "TypeCR",Double.parseDouble(monto.getText().replace(",","")));
                JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
                if(ahorroRbtn.isSelected()){
                     Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeAH", Double.parseDouble(monto.getText().replace(",","")));
                }
                else if(monetariaRbtn.isSelected()){
                     Data.makeDebito((String)cuentaOr.getSelectedItem(),"TypeM", Double.parseDouble(monto.getText().replace(",","")));
                }
                else{
                JOptionPane.showMessageDialog(null,"Seleccione un metodo de Pago", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de Transferencia", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else{
                JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        }
                       

        @Override
        public void stateChanged(ChangeEvent e) {
            
            if(cuentaRbtn.isSelected()){
                idCuentaDes.setEnabled(true);
                concepto.removeAllItems();
                concepto.setEnabled(false);
                tipoPago.setText("Transferencia");
           
            }
            else if(servicioRbtn.isSelected()){
                concepto.removeAllItems();
                idCuentaDes.setEnabled(false);
                idCuentaDes.setText("");
                concepto.setEnabled(true);
                concepto.addItem("Agua");
                concepto.addItem("Luz");
                concepto.addItem("Telefono");
                tipoPago.setText("Pago de Servicios");
           
            }
            else if(prestamoRbtn.isSelected()){ 
                idCuentaDes.setEnabled(false);
                idCuentaDes.setText("");
                concepto.setEnabled(true);
                idsVector=Data.getIDs(idCliente,"TypeP");
                concepto.removeAllItems();
                for (String string : idsVector) {
                concepto.addItem(string);
                } 
                tipoPago.setText("Pago de Prestamo");
            }
            else if(creditoRbtn.isSelected()){ 
                idCuentaDes.setEnabled(false);
                idCuentaDes.setText("");
                concepto.setEnabled(true);
                idsVector=Data.getIDs(idCliente,"TypeCR");
                concepto.removeAllItems();
                for (String string : idsVector) {
                concepto.addItem(string);
                }    
                tipoPago.setText("Pago de Credito");
            }
            
            //--Medio de Pago
            
            if(ahorroRbtn.isSelected()){
                cuentaOr.removeAllItems();
                idsCuentas=Data.getIDs(idCliente, "TypeAH");
                for (String string : idsCuentas) {
                cuentaOr.addItem(string);
                } 
            }
            else if(monetariaRbtn.isSelected()){
                cuentaOr.removeAllItems();
                idsCuentas=Data.getIDs(idCliente, "TypeM");
                for (String string : idsCuentas) {
                cuentaOr.addItem(string);
                } 
            }
        }
        
    }
    
    
    }
