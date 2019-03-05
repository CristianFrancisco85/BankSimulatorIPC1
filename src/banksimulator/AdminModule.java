package banksimulator;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

/**
 *
 * @author cristianmeono
 */
public  class AdminModule {
    
    public JInternalFrame AdminFrame = new JInternalFrame("Modulo de Administracion",true,true,false,true);
    public JTabbedPane TabbedPane = new JTabbedPane();
    
    AdminModule(){
        
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
    
    
    class ClientePanel extends JPanel{
        
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
        JFormattedTextField telefonoCliente = new JFormattedTextField();
        JFormattedTextField ctcahorroCliente = new JFormattedTextField();
        JFormattedTextField ctsmonetariasCliente = new JFormattedTextField();
        JFormattedTextField prestamosCliente = new JFormattedTextField();
        JFormattedTextField tjtcreditoCliente = new JFormattedTextField();
        JFormattedTextField transaccionesCliente = new JFormattedTextField();
        
        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();
        
        
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        
        ClientePanel(){
            
            
            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);
            
            GridBagConstraints Const = new GridBagConstraints();
            
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=4; 
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=5; 
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            id.setText("ID");
            this.add(id,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            nombre.setText("Nombre: ");
            this.add(nombre,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            direccion.setText("Direccion: ");
            this.add(direccion,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            telefono.setText("Telefono: ");
            this.add(telefono,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            ctsahorro.setText("Cuentas de Ahorro: ");
            this.add(ctsahorro,Const);
            
            Const.gridx=1;
            Const.gridy=6;
            ctsmonetarias.setText("Cuentas Monetarias: ");
            this.add(ctsmonetarias,Const);
            
            Const.gridx=1;
            Const.gridy=7;
            prestamos.setText("Prestamos");
            this.add(prestamos,Const);
            
            Const.gridx=1;
            Const.gridy=8;
            tjtcredito.setText("Tarjetas de Credito: ");
            this.add(tjtcredito,Const);
            
            Const.gridx=1;
            Const.gridy=9;
            transacciones.setText("Transacciones: ");
            this.add(transacciones,Const);
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCliente.setPreferredSize(new Dimension(200,20));
            this.add(idCliente, Const);

            Const.gridx=2;
            Const.gridy=2;
            nombreCliente.setPreferredSize(new Dimension(200,20));
            this.add(nombreCliente, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            direccionCliente.setPreferredSize(new Dimension(200,20));
            this.add(direccionCliente, Const);           
            
            Const.gridx=2;
            Const.gridy=4;
            telefonoCliente.setPreferredSize(new Dimension(200,20));
            this.add(telefonoCliente, Const);
            
            Const.gridx=2;
            Const.gridy=5;
            ctcahorroCliente.setPreferredSize(new Dimension(200,20));
            this.add(ctcahorroCliente, Const);
            
            Const.gridx=2;
            Const.gridy=6;
            ctsmonetariasCliente.setPreferredSize(new Dimension(200,20));
            this.add(ctsmonetariasCliente, Const);
            
            Const.gridx=2;
            Const.gridy=7;
            tjtcreditoCliente.setPreferredSize(new Dimension(200,20));
            this.add(tjtcreditoCliente, Const);
            
            Const.gridx=2;
            Const.gridy=8;
            prestamosCliente.setPreferredSize(new Dimension(200,20));
            this.add(prestamosCliente, Const);
            
            Const.gridx=2;
            Const.gridy=9;
            transaccionesCliente.setPreferredSize(new Dimension(200,20));
            this.add(transaccionesCliente, Const);
            
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            this.add(okBtn,Const);
           
            
            
        }
        
        
    }
    
    class AgenciaPanel extends JPanel{
                  
        JButton okBtn = new JButton();
       
        JLabel titleRbtn = new JLabel();       
        JLabel id = new JLabel();
        JLabel nombre = new JLabel();
        JLabel direccion = new JLabel();
        JLabel telefono = new JLabel();
        JLabel numcajas = new JLabel();
        JLabel numescritorios = new JLabel();
        JLabel efectivo = new JLabel();
        
        JFormattedTextField idAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField nombreAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField direccionAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField telefonoAgencia = new JFormattedTextField();
        JFormattedTextField numcajasAgencia = new JFormattedTextField();
        JFormattedTextField numescritoriosAgencia = new JFormattedTextField();
        JFormattedTextField efectivoAgencia = new JFormattedTextField();
        
        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();      
        
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        AgenciaPanel(){
            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);
            
            GridBagConstraints Const = new GridBagConstraints();
            
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=4; 
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=5; 
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            id.setText("ID");
            this.add(id,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            nombre.setText("Nombre: ");
            this.add(nombre,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            direccion.setText("Direccion: ");
            this.add(direccion,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            telefono.setText("Telefono: ");
            this.add(telefono,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            numcajas.setText("Numero de Cajas: ");
            this.add(numcajas,Const);
            
            Const.gridx=1;
            Const.gridy=6;
            numescritorios.setText("Escritorios de Servicio al Cliente: ");
            this.add(numescritorios,Const);
            
            Const.gridx=1;
            Const.gridy=7;
            efectivo.setText("Efectivo");
            this.add(efectivo,Const);           
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idAgencia.setPreferredSize(new Dimension(200,20));
            this.add(idAgencia, Const);

            Const.gridx=2;
            Const.gridy=2;
            nombreAgencia.setPreferredSize(new Dimension(200,20));
            this.add(nombreAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            direccionAgencia.setPreferredSize(new Dimension(200,20));
            this.add(direccionAgencia, Const);           
            
            Const.gridx=2;
            Const.gridy=4;
            telefonoAgencia.setPreferredSize(new Dimension(200,20));
            this.add(telefonoAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=5;
            numcajasAgencia.setPreferredSize(new Dimension(200,20));
            this.add(numcajasAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=6;
            numescritoriosAgencia.setPreferredSize(new Dimension(200,20));
            this.add(numescritoriosAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=7;
            efectivoAgencia.setPreferredSize(new Dimension(200,20));
            this.add(efectivoAgencia, Const);          
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            this.add(okBtn,Const);
        }
        
    }
    
    class AgenciaAutoPanel extends JPanel{
        
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
        
        JFormattedTextField idAgencia = new JFormattedTextField(new Integer(0));
        JFormattedTextField nombreAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField direccionAgencia = new JFormattedTextField(new String(""));
        JFormattedTextField telefonoAgencia = new JFormattedTextField();
        JFormattedTextField numcajasAgencia = new JFormattedTextField();
        JFormattedTextField numescritoriosAgencia = new JFormattedTextField();
        JFormattedTextField efectivoAgencia = new JFormattedTextField();
        JFormattedTextField numautoAgencia =  new JFormattedTextField();
        
        JRadioButton delRbtn = new JRadioButton();
        JRadioButton addRbtn = new JRadioButton();
        JRadioButton editRbtn = new JRadioButton();
        JRadioButton readRbtn = new JRadioButton();      
        
        ButtonGroup GroupRbtn = new ButtonGroup();
        
        AgenciaAutoPanel(){
            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);
            
            GridBagConstraints Const = new GridBagConstraints();
            
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=4; 
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=5; 
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            id.setText("ID");
            this.add(id,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            nombre.setText("Nombre: ");
            this.add(nombre,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            direccion.setText("Direccion: ");
            this.add(direccion,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            telefono.setText("Telefono: ");
            this.add(telefono,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            numcajas.setText("Numero de Cajas: ");
            this.add(numcajas,Const);
            
            Const.gridx=1;
            Const.gridy=6;
            numescritorios.setText("Escritorios de Servicio al Cliente: ");
            this.add(numescritorios,Const);
            
            Const.gridx=1;
            Const.gridy=7;
            efectivo.setText("Efectivo");
            this.add(efectivo,Const);   
            
            Const.gridx=1;
            Const.gridy=8;
            cajasauto.setText("Numeros de Cajas en AutoBanco");
            this.add(cajasauto,Const); 
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idAgencia.setPreferredSize(new Dimension(200,20));
            this.add(idAgencia, Const);

            Const.gridx=2;
            Const.gridy=2;
            nombreAgencia.setPreferredSize(new Dimension(200,20));
            this.add(nombreAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            direccionAgencia.setPreferredSize(new Dimension(200,20));
            this.add(direccionAgencia, Const);           
            
            Const.gridx=2;
            Const.gridy=4;
            telefonoAgencia.setPreferredSize(new Dimension(200,20));
            this.add(telefonoAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=5;
            numcajasAgencia.setPreferredSize(new Dimension(200,20));
            this.add(numcajasAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=6;
            numescritoriosAgencia.setPreferredSize(new Dimension(200,20));
            this.add(numescritoriosAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=7;
            efectivoAgencia.setPreferredSize(new Dimension(200,20));
            this.add(efectivoAgencia, Const);   
            
            Const.gridx=2;
            Const.gridy=8;
            numautoAgencia.setPreferredSize(new Dimension(200,20));
            this.add(numautoAgencia, Const);
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            this.add(okBtn,Const);
        }
        
        
    }
    
    class CajeroPanel extends JPanel{
        
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
        
        CajeroPanel(){
            
            this.setLayout(new GridBagLayout());
            GroupRbtn.add(delRbtn);
            GroupRbtn.add(addRbtn);
            GroupRbtn.add(editRbtn);
            GroupRbtn.add(readRbtn);
            
            GridBagConstraints Const = new GridBagConstraints();
            
            //CONSTANTES
            //------------------
            Const.weightx=0.0;
            Const.weighty=0.0;
            Const.insets = new Insets(5,5,5,5);
            Const.anchor = GridBagConstraints.NORTHWEST;
            //---------------
            
            //RADIO BUTTONS
            
            Const.gridx=0;
            Const.gridy=0;
            titleRbtn.setText("Tipo de Consulta:");
            this.add(titleRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=2;
            delRbtn.setText("Eliminar");
            this.add(delRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=3;
            addRbtn.setText("Agregar");
            this.add(addRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=4; 
            editRbtn.setText("Editar");
            this.add(editRbtn, Const);
            
            Const.gridx=0;
            Const.gridy=5; 
            readRbtn.setText("Buscar");
            this.add(readRbtn, Const);
            
            //CAMPOS  
            Const.insets = new Insets(5,75,5,0);
                     
            Const.gridx=1;
            Const.gridy=1;
            id.setText("ID");
            this.add(id,Const);
            
            Const.gridx=1;
            Const.gridy=2;
            ubicacion.setText("Ubicacion: ");
            this.add(ubicacion,Const);
            
            Const.gridx=1;
            Const.gridy=3;
            efectivo.setText("Efectivo Disponible: ");
            this.add(efectivo,Const);
            
            Const.gridx=1;
            Const.gridy=4;
            estado.setText("Estado: ");
            this.add(estado,Const);
            
            Const.gridx=1;
            Const.gridy=5;
            numtrans.setText("Transacciones Realizadas: ");
            this.add(numtrans,Const);           
            
            //TEXT FIELD
            
            Const.gridx=2;
            Const.gridy=1;
            idCajero.setPreferredSize(new Dimension(200,20));
            this.add(idCajero, Const);

            Const.gridx=2;
            Const.gridy=2;
            ubicacionCajero.setPreferredSize(new Dimension(200,20));
            this.add(ubicacionCajero, Const);
            
            Const.gridx=2;
            Const.gridy=3;
            efectivoCajero.setPreferredSize(new Dimension(200,20));
            this.add(efectivoCajero, Const);           
            
            Const.gridx=2;
            Const.gridy=4;
            estadoCajero.setPreferredSize(new Dimension(200,20));
            this.add(estadoCajero, Const);
            
            Const.gridx=2;
            Const.gridy=5;
            numtransCajero.setPreferredSize(new Dimension(200,20));
            this.add(numtransCajero, Const);
            
            Const.gridx=2;
            Const.gridy=12;
            okBtn.setText("OK");
            this.add(okBtn,Const);
            
        }
        
    }
    
    class TarjetaCreditoPanel extends JPanel{
        
    }
    
    class PrestamosPanel extends JPanel{
        
    }
    
    class EmpleadosPanel extends JPanel{
        
    }
    
}
