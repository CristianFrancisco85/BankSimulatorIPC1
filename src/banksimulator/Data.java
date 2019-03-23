package banksimulator;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Cristian Meoño 201801397
 */


public class Data {
    
    //Matrices
    static String [][] ClientesMtx = new String[50][9];
    static int ClientesMtxCounter=0;
    
    static String [][] EmpleadosMtx =  new String[50][4]; 
    static int EmpleadosMtxCounter=0;
    
    static String [][] AgenciasMtx = new String[50][8];
    static int AgenciasMtxCounter=0;
    
    static String [][] AgenciasAutoMtx = new String[50][9];
    static int AgenciasAutoMtxCounter=0;
    
    static String [][] CajerosMtx =  new String[50][5];
    static int CajerosMtxCounter=0;
    
    static String [][] cAhorroMtx =  new String [50][5];
    static int cAhorroMtxCounter=0;
    
    static String [][] cMonetariaMtx =  new String [50][5];
    static int cMonetariaMtxCounter=0;
    
    static String [][] DepositosMtx =  new String [50][5];
    static int DepositosMtxCounter=0;
    
    static String [][] RetirosMtx =  new String [50][4];
    static int RetirosMtxCounter=0;
    
    static String [][] ChequesMtx= new String[50][4];
    static int ChequesMtxCounter=0;
    
    static String [][] CambioChequesMtx= new String[50][4];
    static int CambioChequesMtxCounter=0;
            
    static String[][] CallCenterMtx = new String[50][5];
    static int CallCenterMtxCounter=0;
    
    static String [][] sPrestamosMtx =  new String [50][5];
    static int sPrestamosMtxCounter=0;
    
    static String [][] aPrestamosMtx =  new String [50][5];
    static int aPrestamosMtxCounter=0;
    
    static String [][] sCreditoMtx =  new String [50][5];
    static int sCreditoMtxCounter=0;
    
    static String [][] aCreditoMtx =  new String [50][5];
    static int aCreditoMtxCounter=0;
    
    static String [][] PagosMtx = new String [50][5];
    static int PagosMtxCounter = 0;
    
    static String [][] oCallCenterMtx =  new String[50][7];
    static int oCallCenterMtxCounter=0;
    
     
    
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
        JOptionPane.showMessageDialog(null,"Operacion Exitosa", "Succes", JOptionPane.INFORMATION_MESSAGE);
        
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
    
    /**
     *
     * @param ID : ID a buscar
     * @param RegMtx : Matriz en donde se buscara
     * @param Counter : Contador donde de la matriz 
     * @return False: Si no existe True: Si existe
     */
    public static boolean checkPK(String ID, String [][] RegMtx, int Counter){
        
        for(int i=0; i<Counter;i++){
            
            if( ID.equals(RegMtx[i][0])){
                return true; 
            }
        }
        return false;
        
    }
     
    /**
     *
     * @param RegMtx Matriz de la cual se imprimiran 5 lineas
     */
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
    
    /**
     *
     * @param array Matriz de donde se sacara la columna
     * @param index Indice de la columna que se sacara (Begin:0)
     * @param counter Contador de la matriz 
     * @return
     */
    public static String[] getColumn(String[][] array, int index,int counter){
    String[] column = new String[counter];
    
    for(int i=0; i<counter; i++){
       column[i] = array[i][index];
    }
    
    for(int i=0; i<counter; i++){
       System.err.println(column[i]);
    }
    
    return column;
    }
    
    /**
     *
     * @param ID ID a buscar - Establece Fila
     * @param newValue Valor nuevo a insertar
     * @param RegMtx Matriz donde se buscara
     * @param Counter Contador de la matriz
     * @param columna Indice de columna donde se insertara - Establece Columna 
     */
    public static void addValueIn (String ID, String newValue, String [][] RegMtx, int Counter, int columna){
        
       if(!Data.checkPK(ID, RegMtx, Counter)){   
            JOptionPane.showMessageDialog(null,"ID no existe", "Error", JOptionPane.ERROR_MESSAGE); 
        }
       
       for(int i=0; i<Counter;i++){
            
            if( ID.equals(RegMtx[i][0])){
                    
               RegMtx[i][columna]= RegMtx[i][columna]+newValue+",";
               break;
            }
        }
        
        
        
    }
    
    /**
     *
     * @param ID ID de Agencia
     * @param Type Tipo de Agencia - TypeA:Agencia - TypeB:AgenciaAutoBanco
     */
    public static void increaseTransac (String ID,String Type){
        
        switch(Type){
            case "TypeA":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasMtx[i][0])){
                       Data.AgenciasMtx[i][7]=Integer.toString(Integer.parseInt(Data.AgenciasMtx[i][7])+1);
                       break;
                    }
                }
                
                break;
            case "TypeB":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasAutoMtx[i][0])){
                       Data.AgenciasAutoMtx[i][8]=Integer.toString(Integer.parseInt(Data.AgenciasAutoMtx[i][8])+1);
                       break;
                    }
                }
                
                break;
            case "TypeC":
                for(int i=0; i<Data.CajerosMtxCounter;i++){
            
                    if( ID.equals(Data.CajerosMtx[i][0])){

                       Data.CajerosMtx[i][4]=Integer.toString(Integer.parseInt(Data.CajerosMtx[i][4])+1);
                       break;
                    }
                }
                
                break;
            case "TypeCl":
            for(int i=0; i<Data.ClientesMtxCounter;i++){

                if( ID.equals(Data.ClientesMtx[i][0])){

                   Data.ClientesMtx[i][8]=Integer.toString(Integer.parseInt(Data.ClientesMtx[i][8])+1);
                   break;
                }
            }
                               
                break;
            default:
                
            
        }
        
    }
    
    /**
     *
     * @param ID: ID de cliente
     * @param Type : Tipo de consulta - TypeAH:Cuentas de Ahorro - TypeM:Cuentas Monetarias - TypeP:Prestamos
     * @return Retorna un vector donde cada espacio es un elemento
     */
    public static String[] getIDs(String ID,String Type){
        
        String[] IDs = null;
        
        switch(Type){
            case"TypeAH":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.ClientesMtx[i][0])){
                        
                       IDs = Data.ClientesMtx[i][4].split(",");
                       break;
                    }
                }
                             
                break;
            case "TypeM":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.ClientesMtx[i][0])){
                        
                       IDs = Data.ClientesMtx[i][5].split(",");
                       break;
                    }
                }
                
                break;
            case "TypeP":
               for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.ClientesMtx[i][0])){
                        
                       IDs = Data.ClientesMtx[i][6].split(",");
                       break;
                    }
                }
            break;   
            case "TypeCR":
             for(int i=0; i<50;i++){

                 if( ID.equals(Data.ClientesMtx[i][0])){

                    IDs = Data.ClientesMtx[i][7].split(",");
                    break;
                 }
             }

             break;
               
        }        
        
        return IDs;
        
    }
    
    /**
     *
     * @param ID : ID de cuenta
     * @param Type : Tipo de Cuenta - TypeAH:Cuentas de Ahorro - TypeM:Cuentas Monetarias
     * @return
     */
    public static double getSaldo(String ID,String Type){
        double saldo=0;
        
        switch(Type){
            case "TypeA":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.AgenciasMtx[i][6].replace(",",""));
                       System.err.println(saldo);
                       break;
                    }
                }
                
                break;
            case "TypeB":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasAutoMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.AgenciasAutoMtx[i][6].replace(",",""));
                       break;
                    }
                }
                
                break;
            case "TypeC":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.CajerosMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.CajerosMtx[i][2].replace(",",""));
                       break;
                    }
                }
                
                break;
            case "TypeAH":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.cAhorroMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.cAhorroMtx[i][3].replace(",",""));
                       break;
                    }
                }
                
                break;
            case "TypeM":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.cMonetariaMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.cMonetariaMtx[i][3].replace(",",""));
                       break;
                    }
                }
                break;
            case "TypeP":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.cMonetariaMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.cMonetariaMtx[i][3].replace(",",""));
                       break;
                    }
                }
                break;
            
        }
        return saldo;
    }
    
    /**
     *
     * @param ID
     * @param Type
     * @param monto
     */
    public static void makeDebito (String ID,String Type,double monto){ 
        
        double saldo;
        
        switch(Type){
            case "TypeA":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.AgenciasMtx[i][6].replace(",",""));
                       Data.AgenciasMtx[i][6]=Double.toString(saldo-monto);
                       break;
                    }
                }
                
                break;
            case "TypeB":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasAutoMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.AgenciasAutoMtx[i][6].replace(",",""));
                       Data.AgenciasAutoMtx[i][6]=Double.toString(saldo-monto);
                       break;
                    }
                }
                
                break;
            case "TypeC":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.CajerosMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.CajerosMtx[i][2].replace(",",""));
                       Data.CajerosMtx[i][2]=Double.toString(saldo-monto);
                       break;
                    }
                }
                
                break;
            case "TypeAH":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.cAhorroMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.cAhorroMtx[i][3].replace(",",""));
                       Data.cAhorroMtx[i][3]=Double.toString(saldo-monto);
                       break;
                    }
                }
                
                break;
            case "TypeM":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.cMonetariaMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.cMonetariaMtx[i][3].replace(",",""));
                       Data.cMonetariaMtx[i][3]=Double.toString(saldo-monto);
                       break;
                       
                    }
                }
                break;
            case "TypeP":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.aPrestamosMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.aPrestamosMtx[i][4].replace(",",""));
                       break;
                    }
                }
                break;
            
        }
        
    }
    
    /**
     *
     * @param ID
     * @param Type
     * @param monto
     */
    public static void makeAbono (String ID,String Type,double monto){ 
        
        double saldo;
        
        switch(Type){
            
            case "TypeA":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.AgenciasMtx[i][6].replace(",",""));
                       Data.AgenciasMtx[i][6]=Double.toString(saldo+monto);
                       break;
                    }
                }
                
                break;
            case "TypeB":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.AgenciasAutoMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.AgenciasAutoMtx[i][6].replace(",",""));
                       Data.AgenciasAutoMtx[i][6]=Double.toString(saldo+monto);
                       break;
                    }
                }
                
                break;
            case "TypeC":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.CajerosMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.CajerosMtx[i][2].replace(",",""));
                       Data.CajerosMtx[i][2]=Double.toString(saldo+monto);
                       break;
                    }
                }
                
                break;
            case "TypeAH":
                
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.cAhorroMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.cAhorroMtx[i][3].replace(",",""));
                       Data.cAhorroMtx[i][3]=Double.toString(saldo+monto);
                       break;
                    }
                }
                
                break;
            case "TypeM":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.cMonetariaMtx[i][0])){
                        
                       saldo = Double.parseDouble(Data.cMonetariaMtx[i][3].replace(",",""));
                       Data.cMonetariaMtx[i][3]=Double.toString(saldo+monto);
                       break;
                       
                    }
                }
                break;
            case "TypeP":
                for(int i=0; i<50;i++){
            
                    if( ID.equals(Data.aPrestamosMtx[i][0])){                       
                       saldo = Double.parseDouble(Data.aPrestamosMtx[i][3].replace(",",""));
                       Data.aPrestamosMtx[i][3]=Double.toString(saldo+monto);
                       break;
                    }
                }
                break;
                
            case "TypeCR":
            for(int i=0; i<50;i++){

                if( ID.equals(Data.aCreditoMtx[i][0])){                       
                   saldo = Double.parseDouble(Data.aCreditoMtx[i][3].replace(",",""));
                   Data.aCreditoMtx[i][3]=Double.toString(saldo+monto);
                   break;
                }
            }
            break;
            
        }
        
    }
    
    /**
     *
     * @param mascara
     * @return
     * @throws ParseException
     */
    public static MaskFormatter getMask(String mascara)  {
        // Inicializamos el objeto
         MaskFormatter Format = new MaskFormatter();

         try {
             Format = new MaskFormatter(mascara);
         } catch (ParseException e) {
             // Algún error que pueda ocurrir en el casteo
             e.printStackTrace();
         }
         return Format;
    }
    
    /**
     *
     * @param ID
     * @return
     */
    public static String[] getCheques(String ID){
        
        int counter=0;
        
        for(int i=0;i<50;i++){         
            if( ID.equals(Data.ChequesMtx[i][2])){                      
                counter++;                      
            }                   
        }
        
        String[] cheques= new String[counter];
        counter=0;
        for(int i=0;i<50;i++){         
            if( ID.equals(Data.ChequesMtx[i][2])){                      
                cheques[counter]=Data.ChequesMtx[i][0];
                counter++;
            }                   
        }
        
        return cheques;
    }

}
