
package banksimulator;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Cristian Meoño 201801397
 */

public class Compras extends JInternalFrame implements MouseListener {
    
    private final  String[] columnNames = {"ID","Nombre","Direccion", "Telefono","Cuentas de Ahorro","Cuentas Monetarias","Prestamos","Tarjetas de Credito","Transacciones"};
    
    private Object[][] tableData = Data.ClientesMtx;
    private JTable tablaClientes =  new JTable(tableData,columnNames);
    private String IDCliente;
    private String[] IDsCredito,auxVector;
    private double monto;
    private boolean control; 
    String[] auxcompras = new String[2];
    
    Compras(){
        this.setTitle("Simulador de Compras");
        tablaClientes.addMouseListener(this);
        this.add(new JScrollPane(tablaClientes),BorderLayout.CENTER);
               
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getClickCount()>0){
        //Se obtiene valor del ID     
        Point point = e.getPoint();
        int row = tablaClientes.rowAtPoint(point);
        TableModel model = tablaClientes.getModel();        
        IDCliente=String.valueOf(model.getValueAt(row,0));
        IDsCredito=Data.getIDs(IDCliente, "TypeCR");
        System.err.println(IDsCredito.length+" "+IDsCredito[0].length());
        if(!(IDsCredito[0].length()==0)){
            String resp = (String) JOptionPane.showInputDialog(this, "Seleccione una tarjeta", "Tarjeta", JOptionPane.DEFAULT_OPTION,null,IDsCredito,IDsCredito[0]);
            auxVector=Data.readReg(resp, Data.aCreditoMtx, Data.aCreditoMtxCounter);
            do{
            String resp2 = (String) JOptionPane.showInputDialog(this, "Ingrese Monto", "Tarjeta", JOptionPane.INFORMATION_MESSAGE);
            try{
               monto=Double.parseDouble(resp2);
               control=false;
            }
            catch(NumberFormatException d){
                JOptionPane.showMessageDialog(this,"Ingrese un monto Valido", "Warning", JOptionPane.WARNING_MESSAGE);
                control=true;
            }
            }while(control);
            
            double disponible;
            if(Double.parseDouble(auxVector[4].replace(",", "")) > 0){
                disponible=Double.parseDouble(auxVector[3].replace(",", ""))-Double.parseDouble(auxVector[4].replace(",", ""));
            }
            else {
                disponible=Double.parseDouble(auxVector[3].replace(",", ""))-(Double.parseDouble(auxVector[4].replace(",", ""))*-1);
            }
                    
            if(monto<=disponible){
                Data.makeDebito(resp, "TypeCR", monto);
                JOptionPane.showMessageDialog(this,"Compra Realizada", "Succes", JOptionPane.INFORMATION_MESSAGE);
                auxcompras[0]=Integer.toString(Data.ComprasMtxCounter);
                auxcompras[1]=IDCliente;
                Data.addReg(auxcompras, Data.ComprasMtx, Data.ComprasMtxCounter);
                Data.ComprasMtxCounter++;
            }
            else{
                JOptionPane.showMessageDialog(this,"Monto Supera Limite de Credito", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this,"Cliente no cuenta con tarjetas de Credito", "Warning", JOptionPane.WARNING_MESSAGE);
        }
            
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
    
    
}
