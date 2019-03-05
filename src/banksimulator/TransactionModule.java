package banksimulator;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author cristianmeono
 */
public  class TransactionModule {
    
    public JInternalFrame TransactionFrame = new JInternalFrame("Modulo de Transacciones",true,true,false,true);
    
    TransactionModule(){
        
       TransactionFrame.setVisible(true);
       TransactionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
    }
    
    
}
