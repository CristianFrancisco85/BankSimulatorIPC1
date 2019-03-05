package banksimulator;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author cristianmeono
 */
public  class ReportsModule {
    
    public JInternalFrame ReportFrame = new JInternalFrame("Modulo de Reportes",true,true,false,true);
    
    ReportsModule(){
        
       ReportFrame.setVisible(true);
       ReportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
    }
    
    
}
