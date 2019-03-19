package banksimulator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
 * @author cristianmeono
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
                    Window.TabbedPane.addTab("Pagos", new Pagos());
                    Window.TabbedPane.addTab("Consulta", new Consulta());
                    Window.TabbedPane.add("Apertura Cuentas", new AbrirCts(IDPlace,IDCliente,"TypeA"));
                    Window.setVisible(true);
                break;
                
                case "Agencia con AutoBanco":
                    IDPlace = (String) JOptionPane.showInputDialog(null,"¿De que agencia viene?","Agencias",
                    JOptionPane.DEFAULT_OPTION,null,Data.getColumn(Data.AgenciasAutoMtx,0,Data.AgenciasAutoMtxCounter),Data.AgenciasAutoMtx[0][0]);
                    
                    Window.TabbedPane.addTab("Retiro", new Retiro(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Deposito", new Deposito(IDPlace,IDCliente,"TypeB"));
                    Window.TabbedPane.addTab("Cambio de Cheques", new CambioCheques());
                    Window.TabbedPane.addTab("Pagos", new Pagos());
                    Window.TabbedPane.addTab("Consulta", new Consulta());
                    Window.TabbedPane.add("Apertura Cuentas", new AbrirCts(IDPlace,IDCliente,"TypeB"));
                    Window.setVisible(true);
                break;
                
                case "Cajero Automatico":
                    IDPlace = (String) JOptionPane.showInputDialog(null,"¿De que cajero viene?","Agencias",
                    JOptionPane.DEFAULT_OPTION,null,Data.getColumn(Data.CajerosMtx,0,Data.CajerosMtxCounter),Data.CajerosMtx[0][0]);
                    Window.TabbedPane.addTab("Retiro", new Retiro(IDPlace,IDCliente,"TypeX"));
                    Window.TabbedPane.addTab("Consulta", new Consulta());
                    Window.setVisible(true);
                break;
                
                case "Call-Center":                   
                    Window.TabbedPane.addTab("Retiro", new Retiro("Single",IDCliente,"TypeX"));
                    Window.TabbedPane.addTab("Deposito", new Deposito("Single",IDCliente,"TypeX"));
                    Window.TabbedPane.addTab("Cambio de Cheques", new CambioCheques());
                    Window.TabbedPane.addTab("Pagos", new Pagos());
                    Window.TabbedPane.addTab("Consulta", new Consulta());
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
    private class TransactionsWindow extends JFrame implements ActionListener {
        
        public JTabbedPane TabbedPane = new JTabbedPane();
    
        TransactionsWindow(){
            this.setSize(new Dimension(800,600));
            this.setLayout(new BorderLayout());
            this.setVisible(false);
            this.setLocationRelativeTo(null);
            this.add(TabbedPane,BorderLayout.CENTER);
                     
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        
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
        
        JFormattedTextField idCuenta = new JFormattedTextField();
        JFormattedTextField idCliente = new JFormattedTextField();
        JFormattedTextField fechaAp = new JFormattedTextField();
        JFormattedTextField monto = new JFormattedTextField();
        
        JRadioButton ahorroRbtn = new JRadioButton();
        JRadioButton monetariaRbtn = new JRadioButton();
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        String [] auxVector= new String[4];
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
        
            if(ahorroRbtn.isSelected()){
         
                Data.addReg(auxVector, Data.cAhorroMtx, Data.cAhorroMtxCounter);
            
                if(!(Data.checkPK(idCuenta.getText(),Data.cAhorroMtx,Data.cAhorroMtxCounter))){ 
                    Data.addValueIn(idCliente.getText(),idCuenta.getText(),Data.ClientesMtx,Data.ClientesMtxCounter,4);
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.cAhorroMtxCounter++;
                    
                } 
                
                Data.printMtx(Data.cAhorroMtx);
                
            }
            
            else if(monetariaRbtn.isSelected()){    
                
                Data.addReg(auxVector, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
                            
                if(!(Data.checkPK(idCuenta.getText(),Data.cMonetariaMtx,Data.cMonetariaMtxCounter))){  
                    Data.addValueIn(idCliente.getText(),idCuenta.getText(),Data.ClientesMtx,Data.ClientesMtxCounter,5);
                    Data.increaseTransac(idAgencia, typeAgencia);
                    Data.cMonetariaMtxCounter++;                  
                }
                
                Data.printMtx(Data.cMonetariaMtx);
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Seleccione un tipo de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
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
        JFormattedTextField fechaAp = new JFormattedTextField();
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
            fechaAp.setPreferredSize(new Dimension(200,20));
            this.add(fechaAp, Const);   
            
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
    
    private class Retiro extends JPanel implements ActionListener,ChangeListener{
        
        JButton okBtn = new JButton();
        
        JLabel titleRbtn = new JLabel();
        
        JLabel idCuentaLbl = new JLabel();
        JLabel montoLbl = new JLabel();
        JLabel fechaLbl = new JLabel();
        
        JComboBox idCuenta = new JComboBox();
        JFormattedTextField monto = new JFormattedTextField();
        JFormattedTextField fechaAp = new JFormattedTextField();
        
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
            montoLbl.setText("Monto a Depositar");
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
            fechaAp.setPreferredSize(new Dimension(200,20));
            this.add(fechaAp, Const);
          
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
    
    
    
    private class SolPrestamo extends JPanel{
        
    }
    
    private class Soltjt extends JPanel{
        
    }
    
    private class Consulta extends JPanel{
        
        public String IDAgencia;
        public String IDCliente;
        
    }
}
