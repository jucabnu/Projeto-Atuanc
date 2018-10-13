/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.Date;

/**
 *
 * @author Juliano
 */
public class Datas {
    
    public static String converteData(Date d){
    java.text.SimpleDateFormat sdf = 
            new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");            
    String data = sdf.format(d);
        return data;
    }
    
}
