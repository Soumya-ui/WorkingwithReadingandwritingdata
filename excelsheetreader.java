/*
 * To change this license header, choose License Headers in Project properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conf_File;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class excelsheetreader {
    
    int parameters;
public excelsheetreader(int value) {
       
        this.parameters= value;
        

  }
     static String path = System.getProperty("user.dir");
     static String soumya = path+"file name.xlsx";// takes the values from file name
    
  
    private static FileInputStream fis;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
      private static File file;
  
    public static void loadExel() throws Exception
    {
  
        file = new File(soumya);
        fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("TestData");
        fis.close();
    }
    
    public  Map<String, Map<String, String>> getdataMap() throws Exception {
        if(sheet==null)
    {
       loadExel();
    }

   
        Map<String, Map<String, String>> superMap = new  HashMap<String, Map<String, String>>();
        Map<String, String> mymap= new HashMap<String, String>();
      
        for(int i=1;i<sheet.getLastRowNum()+1;i++)
        {  
           row=sheet.getRow(i);
           String KeyCell =row.getCell(0).toString().trim();  
          
        int Colnum = parameters+2;
         
        for(int j=1;j<Colnum;j++){
            String value= row.getCell(j).toString().trim();
            
        mymap.put(KeyCell,value);
        }
        
        superMap.put("Mydata", mymap);
        }
        return superMap;
  }
    
    public  String getValue(String key) throws Exception
    {
        Map<String,String> myval= getdataMap().get("Mydata");
        String retValue= myval.get(key);

                return retValue;
        
    }
   public static void main(String[] args) throws Exception 
   {
      //System.out.println(getValue("Somya0"));
   }
}
