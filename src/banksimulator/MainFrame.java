package banksimulator;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 *
 * @author Cristian Meoño 201801397
 */
public class MainFrame extends JFrame  {
    
    Container ContentPane = getContentPane();
    JPanel SideMenu = new JPanel();
    JButton adminBtn,transBtn,saleBtn;
    AdminModule Administrator = new AdminModule();
    TransactionModule Transaction = new TransactionModule();
    Compras ComprasFrame = new Compras();
    
    MainFrame(){
        //Configuracion de MainFrame
        this.setSize(1100,650);
        this.setTitle("Banco del Exterior - Main System");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ContentPane.setLayout(new BorderLayout());
        ContentPane.setBackground(new java.awt.Color(238, 238, 238));
        ContentPane.add(SideMenu, BorderLayout.WEST);
        
        SideMenu.setBackground(new java.awt.Color(19, 137, 223));
        SideMenu.setVisible(true);
        SideMenu.setLayout(new GridLayout(10,0,0,8));
        SideMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK,1, true));
        
        //Configuracion Boton "Administador"
        adminBtn = this.newBtn("Administrador");
        adminBtn.setToolTipText("Administracion del Sistema");
        adminBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/admin.png")));
        adminBtn.addActionListener(new AdminBtn());
        SideMenu.add(adminBtn); 
        
        //Configuracion Boton "Transacciones"
        transBtn = this.newBtn("Transacciones");
        transBtn.setToolTipText("Realizar Transacciones");
        transBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/transaction.png")));
        transBtn.addActionListener(new TransBtn());
        SideMenu.add(transBtn);        
        
        //Configuracion Boton "Compras"
        saleBtn = this.newBtn("Compras");
        saleBtn.setToolTipText("Simular Compra");
        saleBtn.addActionListener(new saleBtn());
        SideMenu.add(saleBtn);
        
        this.setVisible(true);   
        
    }
    
    public JButton newBtn(String text){
        //Configuracion de
        JButton btn = new JButton();
        btn.setText(text);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setBackground(new java.awt.Color(17, 120, 204));
        
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setBackground(new java.awt.Color(14, 73, 156));
            }
            
        }
        );
                                   
        return btn;
    }
    
    class AdminBtn implements ActionListener {
        public void actionPerformed(ActionEvent e){
        
            String user = JOptionPane.showInputDialog(ContentPane,"Ingrese Uuario", "Login",JOptionPane.QUESTION_MESSAGE);
            String password = JOptionPane.showInputDialog(ContentPane,"Ingrese Contraseña", "Login",JOptionPane.QUESTION_MESSAGE);

            if(user.equals("admin") && password.equals("123")){
               ContentPane.add(Administrator.AdminFrame, BorderLayout.CENTER);
               Administrator.AdminFrame.show();        
               transBtn.setBackground(new java.awt.Color(17, 120, 204));
               saleBtn.setBackground(new java.awt.Color(17, 120, 204));

               Transaction.TransactionFrame.dispose();
               ComprasFrame.dispose();

               ContentPane.revalidate();
               ContentPane.repaint();    
            }
            else{
                JOptionPane.showMessageDialog(ContentPane, "Credenciales Invalidos", "Login", JOptionPane.ERROR_MESSAGE);

            }
             
        }
    }
    
    class TransBtn implements ActionListener {
        public void actionPerformed(ActionEvent e){
        ContentPane.add(Transaction.TransactionFrame, BorderLayout.CENTER);
        Transaction.TransactionFrame.show();
        
        adminBtn.setBackground(new java.awt.Color(17, 120, 204));
        saleBtn.setBackground(new java.awt.Color(17, 120, 204));
        Administrator.AdminFrame.dispose();
        ComprasFrame.dispose();
        ContentPane.revalidate();
        ContentPane.repaint(); 
        }
    }   
    
    class saleBtn implements ActionListener {
        public void actionPerformed(ActionEvent e){
        ContentPane.add(ComprasFrame, BorderLayout.CENTER);
        ComprasFrame.setVisible(true);
        
        adminBtn.setBackground(new java.awt.Color(17, 120, 204));
        transBtn.setBackground(new java.awt.Color(17, 120, 204));
        Transaction.TransactionFrame.dispose();
        Administrator.AdminFrame.dispose();
        ContentPane.revalidate();
        ContentPane.repaint(); 
        }
    }
   
}

    