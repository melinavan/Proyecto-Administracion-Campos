/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.campo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Normal
 */
public class fechadao {
     public static Date ConvertirStringaDate(String sfecha){
        Date dfecha=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = sfecha;
        try
        {
            Date date = formatter.parse(dateInString);
            dfecha=date;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        
         
        return dfecha; 
     }
}
