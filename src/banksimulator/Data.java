package banksimulator;
/**
 *
 * @author cristianmeono
 */


public class Data {
    
    //Matrices
    protected String[][] ClientesMtx = new String[50][9];
    protected int ClintesMtxCounter=0;
    
    
    
    public void addReg(String [] toRecord, String[][] RegMtx, int Counter){
        
        for(int i=0;i<toRecord.length;i++){
            
            RegMtx[Counter][i] = toRecord[i];
            
        }
        Counter++;
        
    }
    
    public String[][] delReg(String ID, String [][] RegMtx, int Counter){
        
    String[] auxVector = new String[RegMtx[0].length];
    int line;
        
        for(int i=0; i<Counter;i++){
            
            if( ID.equals(RegMtx[i][0])){
                line=i;
                
                for(int j=line;j<Counter;j++){
                    
                    for(int k=0;k<RegMtx[0].length;k++){
                        
                      auxVector[k]= RegMtx[line+1][k];
                      RegMtx[line][k] = auxVector[k];  
                      
                    }
                }
                break;
            }
        }
        
    return RegMtx;
    
    }
    
    public String[][] editReg(String ID, String [] toRecord,String [][] RegMtx, int Counter){
        
    int line;
        
        for(int i=0; i<Counter;i++){
            
            if( ID.equals(RegMtx[i][0])){
                line=i;
                    
                    for(int k=0;k<RegMtx[0].length;k++){
                        
                      RegMtx[line][k] = toRecord[i]; 
                      
                    }
                break;
            }
        }
        
    return RegMtx;
    
    }
    
    public String[] readReg(String ID, String [][] RegMtx, int Counter){
        
    String[] auxVector = new String[RegMtx[0].length];    
    int line;
        
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
    
    
    
}
