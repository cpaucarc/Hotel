package Conexion;

import Database.Controller;

public class Control {
    
    static Controller con;
    //Example database
    static String user = "root";
    static String psw = "1234";
    static String db = "hotel";
    static String host = "localhost";
        
    public static Controller getControl(){
        con = new Controller(user, psw, db, host);
	return con;
    }
    
}
