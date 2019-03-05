package banksimulator;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 *
 * @author cristianmeono
 */
public class MainFrame extends JFrame  {
    
    Container ContentPane = getContentPane();
    JPanel SideMenu = new JPanel();
    JButton adminBtn,transBtn,reportBtn = new JButton();
    AdminModule Administrator = new AdminModule();
    TransactionModule Transaction = new TransactionModule();
    ReportsModule Reports = new ReportsModule();
    
    MainFrame(){
        
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
        
        adminBtn = this.newBtn("Administrador");
        adminBtn.setToolTipText("Administracion del Sistema");
        adminBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/admin.png")));
        adminBtn.addActionListener(new AdminBtn());
        SideMenu.add(adminBtn); 
        
        transBtn = this.newBtn("Transacciones");
        transBtn.setToolTipText("Realizar Transacciones");
        transBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/transaction.png")));
        transBtn.addActionListener(new TransBtn());
        SideMenu.add(transBtn); 
        
        reportBtn = this.newBtn("Reportes");
        reportBtn.setToolTipText("Creacion de Reportes");
        reportBtn.addActionListener(new ReportBtn());
        SideMenu.add(reportBtn);
        
        this.setVisible(true);       
        
    }
    
    public JButton newBtn(String text){
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
        ContentPane.add(Administrator.AdminFrame, BorderLayout.CENTER);
        Administrator.AdminFrame.show();
        
        reportBtn.setBackground(new java.awt.Color(17, 120, 204));
        transBtn.setBackground(new java.awt.Color(17, 120, 204));
        if(Reports.ReportFrame.isClosed()){
           Reports.ReportFrame.dispose();
        }
        if(Transaction.TransactionFrame.isClosed()){
            Transaction.TransactionFrame.dispose();
        }
        
        ContentPane.revalidate();
        ContentPane.repaint();      
        }
    }
    
    class TransBtn implements ActionListener {
        public void actionPerformed(ActionEvent e){
        ContentPane.add(Transaction.TransactionFrame, BorderLayout.CENTER);
        Transaction.TransactionFrame.show();
        
        adminBtn.setBackground(new java.awt.Color(17, 120, 204));
        reportBtn.setBackground(new java.awt.Color(17, 120, 204));
        if(Administrator.AdminFrame.isClosed()){
           Administrator.AdminFrame.dispose();
        }
        if(Reports.ReportFrame.isClosed()){
           Reports.ReportFrame.dispose();
        }
        
        ContentPane.revalidate();
        ContentPane.repaint(); 
        }
    }
    
    class ReportBtn implements ActionListener {
        public void actionPerformed(ActionEvent e){
        ContentPane.add(Reports.ReportFrame, BorderLayout.CENTER);
        Reports.ReportFrame.show();
        
        adminBtn.setBackground(new java.awt.Color(17, 120, 204));
        transBtn.setBackground(new java.awt.Color(17, 120, 204));
        if(Administrator.AdminFrame.isClosed()){
           Administrator.AdminFrame.dispose();
        }
        if(Transaction.TransactionFrame.isClosed()){
            Transaction.TransactionFrame.dispose();
        }
        
        ContentPane.revalidate();
        ContentPane.repaint(); 
        }
    }
   
}

    