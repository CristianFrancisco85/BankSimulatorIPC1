package banksimulator;

import javax.swing.JPanel;

/**
 *
 * @author cristianmeono
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainFrame Ventana = new MainFrame();
        
        //<editor-fold defaultstate="collapsed" desc="Creacion de Clientes Con sus Cuentas">
        String [] Cliente1 = {"1","Cristian","Zona 1","1100-0011","101,102","111,112","","","0"};
        String [] Cuenta1Cl1= {"101","1","26/03/19","1000","25"};
        String [] Cuenta2Cl1= {"102","1","26/03/19","2000","25"};
        String [] Cuenta3Cl1= {"111","1","26/03/19","3000","25"};
        String [] Cuenta4Cl1= {"112","1","26/03/19","4000","25"};
        Data.addReg(Cliente1, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl1, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl1, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl1, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl1, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++; 
        
        
        
        String [] Cliente2 = {"2","Manuel","Zona 2","2200-0022","201,202","221,222","","","0"};
        String [] Cuenta1Cl2= {"201","2","26/03/19","5000","25"};
        String [] Cuenta2Cl2= {"202","2","26/03/19","6000","25"};
        String [] Cuenta3Cl2= {"221","2","26/03/19","7000","25"};
        String [] Cuenta4Cl2= {"222","2","26/03/19","8000","25"};
        Data.addReg(Cliente2, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl2, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl2, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl2, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl2, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;

        
        String [] Cliente3 = {"3","Roberto","Zona 3","3300-0033","301,302","331,332","","","0"};
        String [] Cuenta1Cl3= {"301","3","26/03/19","9000","25"};
        String [] Cuenta2Cl3= {"302","3","26/03/19","10000","25"};
        String [] Cuenta3Cl3= {"331","3","26/03/19","1000","25"};
        String [] Cuenta4Cl3= {"332","3","26/03/19","2000","25"};
        Data.addReg(Cliente3, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl3, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl3, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl3, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl3, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;

        
        String [] Cliente4 = {"4","Francisco","Zona 4","4400-0044","401,402","441,442","","","0"};
        String [] Cuenta1Cl4= {"401","4","26/03/19","3000","25"};
        String [] Cuenta2Cl4= {"402","4","26/03/19","4000","25"};
        String [] Cuenta3Cl4= {"441","4","26/03/19","5000","25"};
        String [] Cuenta4Cl4= {"442","4","26/03/19","6000","25"};
        Data.addReg(Cliente4, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl4, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl4, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl4, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl4, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;

        
        String [] Cliente5 = {"5","Diego","Zona 5","5500-0055","501,502","551,552","","","0"};
        String [] Cuenta1Cl5= {"501","5","26/03/19","7000","25"};
        String [] Cuenta2Cl5= {"502","5","26/03/19","8000","25"};
        String [] Cuenta3Cl5= {"551","5","26/03/19","9000","25"};
        String [] Cuenta4Cl5= {"552","5","26/03/19","10000","25"};
        Data.addReg(Cliente5, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl5, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl5, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl5, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl5, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;

        
        String [] Cliente6 = {"6","Pedro","Zona 6","6600-0066","601,602","661,662","","","0"};
        String [] Cuenta1Cl6= {"601","6","26/03/19","1000","25"};
        String [] Cuenta2Cl6= {"602","6","26/03/19","2000","25"};
        String [] Cuenta3Cl6= {"661","6","26/03/19","3000","25"};
        String [] Cuenta4Cl6= {"662","6","26/03/19","4000","25"};
        Data.addReg(Cliente6, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl6, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl6, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl6, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl6, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;

        
        String [] Cliente7 = {"7","Luis","Zona 7","7700-0077","701,702","771,772","","","0"};
        String [] Cuenta1Cl7= {"701","7","26/03/19","5000","25"};
        String [] Cuenta2Cl7= {"702","7","26/03/19","6000","25"};
        String [] Cuenta3Cl7= {"771","7","26/03/19","7000","25"};
        String [] Cuenta4Cl7= {"772","7","26/03/19","8000","25"};
        Data.addReg(Cliente7, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl7, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl7, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl7, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl7, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;
        
        String [] Cliente8 = {"8","Miguel","Zona 8","8800-0088","801,802","881,882","","","0"};
        String [] Cuenta1Cl8= {"801","8","26/03/19","5000","25"};
        String [] Cuenta2Cl8= {"802","8","26/03/19","6000","25"};
        String [] Cuenta3Cl8= {"881","8","26/03/19","7000","25"};
        String [] Cuenta4Cl8= {"882","8","26/03/19","8000","25"};
        Data.addReg(Cliente8, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl8, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl8, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl8, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl8, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;

        
        String [] Cliente9 = {"9","Fernando","Zona 9","9900-0099","901,902","991,992","","","0"};
        String [] Cuenta1Cl9= {"901","9","26/03/19","5000","25"};
        String [] Cuenta2Cl9= {"902","9","26/03/19","6000","25"};
        String [] Cuenta3Cl9= {"991","9","26/03/19","7000","25"};
        String [] Cuenta4Cl9= {"992","9","26/03/19","8000","25"};
        Data.addReg(Cliente9, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl9, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl9, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl9, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl9, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;

        
        String [] Cliente10 = {"10","Charlie","Zona 10","1000-0010","121,122","131,132","","","0"};
        String [] Cuenta1Cl10= {"121","10","26/03/19","5000","25"};
        String [] Cuenta2Cl10= {"122","10","26/03/19","6000","25"};
        String [] Cuenta3Cl10= {"131","10","26/03/19","7000","25"};
        String [] Cuenta4Cl10= {"132","10","26/03/19","8000","25"};
        Data.addReg(Cliente10, Data.ClientesMtx, Data.ClientesMtxCounter);
        Data.addReg(Cuenta1Cl10, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta2Cl10, Data.cAhorroMtx, Data.cAhorroMtxCounter);
        Data.cAhorroMtxCounter++;
        Data.addReg(Cuenta3Cl10, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.addReg(Cuenta4Cl10, Data.cMonetariaMtx, Data.cMonetariaMtxCounter);
        Data.cMonetariaMtxCounter++;
        Data.ClientesMtxCounter++;
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Creacion de Agencias con y sin AutoBanco">
        String [] Agencia1 = {"101","USAC-T1","Zona 12","1001-1001","10","15","30000","0"};
        Data.addReg(Agencia1, Data.AgenciasMtx, Data.AgenciasMtxCounter);
        Data.AgenciasMtxCounter++;
        String [] Agencia2 = {"102","USAC-T3","Zona 12","1002-1002","11","16","40000","0"};
        Data.addReg(Agencia2, Data.AgenciasMtx, Data.AgenciasMtxCounter);
        Data.AgenciasMtxCounter++;
        String [] Agencia3 = {"103","USAC-S12","Zona 12","1003-1003","17","5","390000","0"};
        Data.addReg(Agencia3, Data.AgenciasMtx, Data.AgenciasMtxCounter);
        Data.AgenciasMtxCounter++;
        String [] Agencia4 = {"104","USAC-T5","Zona 12","1004-1004","13","8","25000","0"};
        Data.addReg(Agencia4, Data.AgenciasMtx, Data.AgenciasMtxCounter);
        Data.AgenciasMtxCounter++;
        String [] Agencia5 = {"105","USAC-S13","Zona 12","1005-1005","19","12","100000","0"};
        Data.addReg(Agencia5, Data.AgenciasMtx, Data.AgenciasMtxCounter);
        Data.AgenciasMtxCounter++;
        
        String [] AgenciaAuto1 = {"201","USAC-T1","Zona 12","2001-2001","10","15","70000","6","0"};
        Data.addReg(AgenciaAuto1, Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
        Data.AgenciasAutoMtxCounter++;
        String [] AgenciaAuto2 = {"202","USAC-T3","Zona 12","2002-2002","11","16","80000","7","0"};
        Data.addReg(AgenciaAuto2, Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
        Data.AgenciasAutoMtxCounter++;
        String [] AgenciaAuto3 = {"203","USAC-S12","Zona 12","2003-2003","17","5","90000","9","0"};
        Data.addReg(AgenciaAuto3, Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
        Data.AgenciasAutoMtxCounter++;
        String [] AgenciaAuto4 = {"204","USAC-T5","Zona 12","2004-2004","13","8","65000","10","0"};
        Data.addReg(AgenciaAuto4, Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
        Data.AgenciasAutoMtxCounter++;
        String [] AgenciaAuto5 = {"205","USAC-S13","Zona 12","2005-2005","19","12","19000","13","0"};
        Data.addReg(AgenciaAuto5, Data.AgenciasAutoMtx, Data.AgenciasAutoMtxCounter);
        Data.AgenciasAutoMtxCounter++;
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Creacion de Empleados">
        
        //AGENCIAS
        String [] Empleado11 = {"301","Jose Manuel","Agencia Bancaria","101"};
        Data.addReg(Empleado11, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado12 = {"302","Pedro Perez","Agencia Bancaria","101"};
        Data.addReg(Empleado12, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado13 = {"303","Carlos Agusto","Agencia Bancaria","101"};
        Data.addReg(Empleado13, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        String [] Empleado21 = {"304","Jose Manolo","Agencia Bancaria","102"};
        Data.addReg(Empleado21, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado22 = {"305","Roberto Perez","Agencia Bancaria","102"};
        Data.addReg(Empleado22, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado23 = {"306","Juan Agusto","Agencia Bancaria","102"};
        Data.addReg(Empleado23, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        String [] Empleado31 = {"307","Alejandro Manuel","Agencia Bancaria","103"};
        Data.addReg(Empleado31, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado32 = {"308","Fabio Ruiz","Agencia Bancaria","103"};
        Data.addReg(Empleado32, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado33 = {"309","Carlos Recinos","Agencia Bancaria","103"};
        Data.addReg(Empleado33, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        String [] Empleado41 = {"310","Antonio Manuel","Agencia Bancaria","104"};
        Data.addReg(Empleado41, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado42 = {"311","Andres Perez","Agencia Bancaria","104"};
        Data.addReg(Empleado42, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado43 = {"312","Jorge Agusto","Agencia Bancaria","104"};
        Data.addReg(Empleado43, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        String [] Empleado51 = {"313","Dario Manuel","Agencia Bancaria","105"};
        Data.addReg(Empleado51, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado52 = {"314","Pablo Perez","Agencia Bancaria","105"};
        Data.addReg(Empleado52, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado53 = {"315","Carlos Miguel","Agencia Bancaria","105"};
        Data.addReg(Empleado53, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        //AGENCIAS CON AUTO BANCO
        
        String [] Empleado61 = {"316","Jose Manuel","Agencia con AutoBanco","201"};
        Data.addReg(Empleado61, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado62 = {"317","Pedro Perez","Agencia con AutoBanco","201"};
        Data.addReg(Empleado62, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado63 = {"318","Carlos Agusto","Agencia con AutoBanco","201"};
        Data.addReg(Empleado63, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        String [] Empleado71 = {"319","Jose Manolo","Agencia con AutoBanco","202"};
        Data.addReg(Empleado71, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado72 = {"320","Roberto Perez","Agencia con AutoBanco","202"};
        Data.addReg(Empleado72, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado73 = {"321","Juan Agusto","Agencia con AutoBanco","202"};
        Data.addReg(Empleado73, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        String [] Empleado81 = {"322","Alejandro Manuel","Agencia con AutoBanco","203"};
        Data.addReg(Empleado81, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado82 = {"323","Fabio Ruiz","Agencia con AutoBanco","203"};
        Data.addReg(Empleado82, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado83 = {"324","Carlos Recinos","Agencia con AutoBanco","203"};
        Data.addReg(Empleado83, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;      
        
        String [] Empleado91 = {"325","Antonio Manuel","Agencia con AutoBanco","204"};
        Data.addReg(Empleado91, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;        
        String [] Empleado92 = {"326","Andres Perez","Agencia con AutoBanco","204"};
        Data.addReg(Empleado92, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado93 = {"327","Jorge Agusto","Agencia con AutoBanco","204"};
        Data.addReg(Empleado93, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        String [] Empleado101 = {"328","Dario Manuel","Agencia con AutoBanco","205"};
        Data.addReg(Empleado101, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado102 = {"329","Pablo Perez","Agencia con AutoBanco","205"};
        Data.addReg(Empleado102, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado103 = {"330","Carlos Miguel","Agencia con AutoBanco","205"};
        Data.addReg(Empleado103, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        //CALL-CENTER
        
        String [] Empleado111 = {"331","Jose Manuel","Call-Center","N/A"};
        Data.addReg(Empleado111, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado112 = {"332","Pedro Perez","Call-Center","N/A"};
        Data.addReg(Empleado112, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado113 = {"333","Carlos Agusto","Call-Center","N/A"};
        Data.addReg(Empleado113, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;       
        String [] Empleado121 = {"334","Jose Manolo","Call-Center","N/A"};
        Data.addReg(Empleado121, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado122 = {"335","Roberto Perez","Call-Center","N/A"};
        Data.addReg(Empleado122, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado123 = {"336","Juan Agusto","Call-Center","N/A"};
        Data.addReg(Empleado123, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;      
        String [] Empleado131 = {"337","Alejandro Manuel","Call-Center","N/A"};
        Data.addReg(Empleado131, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado132 = {"338","Fabio Ruiz","Call-Center","N/A"};
        Data.addReg(Empleado132, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado133 = {"339","Carlos Recinos","Call-Center","N/A"};
        Data.addReg(Empleado133, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;        
        String [] Empleado141 = {"340","Antonio Manuel","Call-Center","N/A"};
        Data.addReg(Empleado141, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        
        //OFICINAS CENTRALES 
        
        String [] Empleado142 = {"341","Andres Perez","Oficinas Centrales","Gerencia"};
        Data.addReg(Empleado142, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado143 = {"342","Jorge Agusto","Oficinas Centrales","Gerencia"};
        Data.addReg(Empleado143, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado151 = {"343","Dario Manuel","Oficinas Centrales","Departamento de Marketing"};
        Data.addReg(Empleado151, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado152 = {"344","Pablo Perez","Oficinas Centrales","Departamento de Marketing"};
        Data.addReg(Empleado152, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado153 = {"345","Carlos Miguel","Oficinas Centrales","Departamento de Informatica"};
        Data.addReg(Empleado153, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado161 = {"346","Jose Manuel","Oficinas Centrales","Departamento de Informatica"};
        Data.addReg(Empleado161, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado162 = {"347","Pedro Perez","Oficinas Centrales","Departamento Financiero"};
        Data.addReg(Empleado162, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado163 = {"348","Carlos Agusto","Oficinas Centrales","Departamento Financiero"}; 
        Data.addReg(Empleado163, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado171 = {"349","Jose Manolo","Oficinas Centrales","Departamento de Reclamos"};
        Data.addReg(Empleado171, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado172 = {"350","Roberto Perez","Oficinas Centrales","Departamento de Reclamos"};
        Data.addReg(Empleado172, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado173 = {"351","Juan Agusto","Oficinas Centrales","Departamento de Cobros"}; 
        Data.addReg(Empleado173, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;
        String [] Empleado181 = {"352","Alejandro Manuel","Oficinas Centrales","Departamento de Cobros"};
        Data.addReg(Empleado181, Data.EmpleadosMtx, Data.EmpleadosMtxCounter);
        Data.EmpleadosMtxCounter++;

        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Creacion de Cajeros">
        String [] Cajero1 = {"401","USAC","50000","Activo","0"};
        Data.addReg(Cajero1, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero2 = {"402","Walmart","60000","Activo","0"};
        Data.addReg(Cajero2, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero3 = {"403","Super24","70000","Activo","0"};
        Data.addReg(Cajero3, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero4 = {"404","URL","80000","Activo","0"};
        Data.addReg(Cajero4, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero5 = {"405","PriceSmart","90000","Activo","0"};
        Data.addReg(Cajero5, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero6 = {"406","Portales","10000","Activo","0"};
        Data.addReg(Cajero6, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero7 = {"407","Miraflores","20000","Activo","0"};
        Data.addReg(Cajero7, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero8 = {"408","Okland Mall","30000","Activo","0"};
        Data.addReg(Cajero8, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero9 = {"409","Naranjo Mall","40000","Activo","0"};
        Data.addReg(Cajero9, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        String [] Cajero10 = {"410","EuroPlaza","50000","Activo","0"};
        Data.addReg(Cajero10, Data.CajerosMtx, Data.CajerosMtxCounter);
        Data.CajerosMtxCounter++;
        //</editor-fold>
        
        
       
    }
    
}
