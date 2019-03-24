package banksimulator;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Cristian Meoño 201801397
 */
public  class ReportsModule {
    
    public JInternalFrame ReportFrame = new JInternalFrame("Modulo de Reportes",true,true,false,true);
    JButton okBtn = new JButton();
        
        JButton rutaBtn = new JButton();
        JButton genBtn = new JButton();
        
        JTextField txtRuta = new JTextField();
        JComboBox Reporte = new JComboBox();
        
        
        
        String [] auxVector= new String[5];
        String idAgencia,typeAgencia;
    
    ReportsModule(){
        
       ReportFrame.setVisible(true);
       ReportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
      
    }
    
    
}
