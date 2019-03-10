package banksimulator;

import javax.swing.JOptionPane;

/**
 *
 * @author cristianmeono
 */


public class Data {
    
    //Matrices
    static String [][] ClientesMtx = new String[50][9];
    static int ClientesMtxCounter=0;
    
    static String [][] AgenciasMtx = new String[50][7];
    static int AgenciasMtxCounter=0;
    
    static String [][] AgenciasAutoMtx = new String[50][8];
    static int AgenciasAutoMtxCounter=0;
    
    static String [][] CajerosMtx =  new String[50][5];
    static int CajerosMtxCounter =0;
    
    
    /**
     *
     * @param toRecord : Recibira el vector a guardar en la matriz
     * @param RegMtx :  Matriz en donde se procedera a guardar el vector
     * @param Counter : Contador de la matriz donde se guardara el vector
     */
    public static void addReg(String [] toRecord, String[][] RegMtx, int Counter){
        
        if(!Data.checkPK(toRecord[0], RegMtx, Counter)){  

            for(int i=0;i<toRecord.length;i++){            
                RegMtx[Counter][i] = toRecord[i];          
            } 
        } 
    
        else{
            JOptionPane.showMessageDialog(null,"ID ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     *
     * @param ID
     * @param RegMtx
     * @param Counter
     * @return
     */
    public static String[][] delReg(String ID, String [][] RegMtx, int Counter){
        
    String[] auxVector = new String[RegMtx[0].length];
    int line;
        
        for(int i=0; i<Counter;i++){           
            if( ID.equals(RegMtx[i][0])){
                line=i;                
                for(int j=line;j<=Counter;j++){                   
                    for(int k=0;k<RegMtx[0].length;k++){                      
                      auxVector[k]= RegMtx[j+1][k];
                      RegMtx[j][k] = auxVector[k];                    
                    }
                }                
            }
        }
        
    return RegMtx;
    
    }
    
    /**
     *
     * @param ID
     * @param toRecord
     * @param RegMtx
     * @param Counter
     * @return
     */
    public static String[][] editReg(String ID, String [] toRecord,String [][] RegMtx, int Counter){
        
        if(!Data.checkPK(ID, RegMtx, Counter)){   
            JOptionPane.showMessageDialog(null,"ID no existe", "Error", JOptionPane.ERROR_MESSAGE); 
            return RegMtx;
        }
        
        int line;
        
        for(int i=0; i<Counter;i++){
            
            if( ID.equals(RegMtx[i][0])){
                line=i;
                    
                    for(int k=0;k<RegMtx[0].length;k++){
                        
                      RegMtx[line][k] = toRecord[k]; 
                    
                    }
                break;
            }
        }
        
    return RegMtx;
    
    }
    
    /**
     *
     * @param ID : Recibe la primary key del registro a buscar
     * @param RegMtx : Recibe la matriz donde se buscara
     * @param Counter : Recibe el contador de la matriz donde se buscara 
     * @return De encontrar un registro regresara el registro en forma de vector 
     */
    public static String[] readReg(String ID, String [][] RegMtx, int Counter){
        
    String[] auxVector = new String[RegMtx[0].length];    
    int line;
    
    if(!Data.checkPK(ID, RegMtx, Counter)){   
        JOptionPane.showMessageDialog(null,"ID no existe", "Error", JOptionPane.ERROR_MESSAGE); 
        return auxVector;
    }
        
        for(int i=0; i<Counter;i++){
            
            if( ID.equals(RegMtx[i][0])){
                line=i;
                    
                    for(int k=0;k<RegMtx[0].length;k++){
                        
                      auxVector[k]=RegMtx[line][k];                   
                    }
                    
                break;
            }
        }
        
    return auxVector;
        
        
    }
    
    public static boolean checkPK(String ID, String [][] RegMtx, int Counter){
        
        for(int i=0; i<Counter;i++){
            
            if( ID.equals(RegMtx[i][0])){
                return true; 
            }
        }
        return false;
        
    }
     
    public static void printMtx(String [][] RegMtx) {
        
        for(int i=0; i<RegMtx[0].length;i++){   
            
            System.out.print(RegMtx[0][i]+" ");
        }
        System.out.println("");
        
        for(int i=0; i<RegMtx[0].length;i++){   
            
            System.out.print(RegMtx[1][i]+" ");
        }
        System.out.println("");
        
        for(int i=0; i<RegMtx[0].length;i++){   
            
            System.out.print(RegMtx[2][i]+" ");
        }
        System.out.println("");
        
        for(int i=0; i<RegMtx[0].length;i++){   
            
            System.out.print(RegMtx[3][i]+" ");
        }
        System.out.println("");
    }
    
    
}
