package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OperateExcel {
	private static XSSFSheet excelSheet2007;
	private static HSSFSheet excelSheet2003;
	private static XSSFWorkbook excelBook2007;
	private static HSSFWorkbook excelBook2003;
	//private static XSSFCell cell2007;
	//private static HSSFCell cell2003;
	static boolean isExcel2007=false;
	static boolean isExcel2003=false;
	private static XSSFCell cell2007;
	private static HSSFCell cell2003;
	//Ĭ�ϵ�Ԫ������Ϊ����ʱ��ʽ  
    private static DecimalFormat df = new DecimalFormat("0");  
    // Ĭ�ϵ�Ԫ���ʽ�������ַ���   
    private static SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");   
    // ��ʽ������  
    private static DecimalFormat nf = new DecimalFormat("0.00"); 
	//�ж��Ƿ���excel2007��
	public static void main(String args[]){
		System.out.println(isExcel2007("C:/Users/jinwx/Desktop/1��Ԥ����ͨѶ�쳣��ʵ���1212.xls"));
	}
	public static boolean isExcel2007(String path){
		String prefix=path.substring(path.lastIndexOf("."));
		File file=new File(path);
		if(file.exists()){
			if(prefix.equals(".xlsx")||prefix.equals(".XLSX")){
				isExcel2007=true;
				return isExcel2007;
			}else if(prefix.equals(".xls")||prefix.equals(".XLS")){
				isExcel2003=true;
				return isExcel2003;
			} else return false;
		}else return false;
	}
	public static XSSFWorkbook setExcelFile2007(String path){
		try {
			FileInputStream excelFile= new FileInputStream(path);
			if(isExcel2007==true){
				excelBook2007=new XSSFWorkbook(excelFile);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelBook2007;
	}
	public static HSSFWorkbook setExcelFile2003(String path){
		try {
			FileInputStream excelFile= new FileInputStream(path);
			if(isExcel2003==true){
				excelBook2003=new HSSFWorkbook(excelFile);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelBook2003;
	}
	public static ArrayList<ArrayList<Object>> readExcel2007(String sheetName){

		XSSFRow row;
		XSSFCell cell2007;
		Object value;
		excelSheet2007=excelBook2007.getSheet(sheetName);
		ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> colList;
		for(int i=excelSheet2007.getFirstRowNum(),rowCount=0;rowCount < excelSheet2007.getPhysicalNumberOfRows();i++){
			row=excelSheet2007.getRow(i);
			colList = new ArrayList<Object>();
			if(row==null){
				//��������
				if(i != excelSheet2007.getPhysicalNumberOfRows()){//�ж��Ƿ������һ��  
                    rowList.add(colList);  
                }  
                continue; 
			}else{
				rowCount++;
			}
			for(int j=row.getFirstCellNum();j<=row.getLastCellNum();j++){
				cell2007=row.getCell(j);
				if(cell2007 == null || cell2007.getCellType() == HSSFCell.CELL_TYPE_BLANK){  
                    //���õ�Ԫ��Ϊ��  
                    if(j != row.getLastCellNum()){//�ж��Ƿ��Ǹ��������һ����Ԫ��  
                        colList.add("");  
                    }  
                    continue;  
                }
				switch(cell2007.getCellType()){  
                case XSSFCell.CELL_TYPE_STRING:    
                       System.out.println(i + "��" + j + " �� is String type");    
                       value = cell2007.getStringCellValue();    
                       break;    
                   case XSSFCell.CELL_TYPE_NUMERIC:    
                       if ("@".equals(cell2007.getCellStyle().getDataFormatString())) {    
                           value = df.format(cell2007.getNumericCellValue());    
                       } else if ("General".equals(cell2007.getCellStyle()    
                               .getDataFormatString())) {    
                           value = nf.format(cell2007.getNumericCellValue());    
                       } else {    
                           value = sdf.format(HSSFDateUtil.getJavaDate(cell2007    
                                   .getNumericCellValue()));    
                       }    
                       System.out.println(i + "��" + j    
                               + " �� is Number type ; DateFormt:"    
                               + value.toString());   
                       break;    
                   case XSSFCell.CELL_TYPE_BOOLEAN:    
                       System.out.println(i + "��" + j + " �� is Boolean type");    
                       value = Boolean.valueOf(cell2007.getBooleanCellValue());  
                       break;    
                   case XSSFCell.CELL_TYPE_BLANK:    
                       System.out.println(i + "��" + j + " �� is Blank type");    
                       value = "";    
                       break;    
                   default:    
                       System.out.println(i + "��" + j + " �� is default type");    
                       value = cell2007.toString();    
                }// end switch 
				colList.add(value);
			}//end for j
			rowList.add(colList);
		}//end for i
		return rowList; 
	}
	
    public static ArrayList<ArrayList<Object>> readExcel2003(String sheetName){  
        ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();  
        ArrayList<Object> colList;  
        excelSheet2003 = excelBook2003.getSheet(sheetName);  
        HSSFRow row;  
        HSSFCell cell;  
        Object value;  
        for(int i = excelSheet2003.getFirstRowNum() , rowCount = 0; rowCount < excelSheet2003.getPhysicalNumberOfRows() ; i++ ){  
            row = excelSheet2003.getRow(i);  
            colList = new ArrayList<Object>();  
            if(row == null){  
                //����ȡ��Ϊ��ʱ  
                if(i != excelSheet2003.getPhysicalNumberOfRows()){//�ж��Ƿ������һ��  
                    rowList.add(colList);  
                }  
                continue;  
            }else{  
                rowCount++;  
            }  
            for( int j = row.getFirstCellNum() ; j <= row.getLastCellNum() ;j++){  
                cell = row.getCell(j);  
                if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){  
                    //���õ�Ԫ��Ϊ��  
                    if(j != row.getLastCellNum()){//�ж��Ƿ��Ǹ��������һ����Ԫ��  
                        colList.add("");  
                    }  
                    continue;  
                }  
                switch(cell.getCellType()){  
                 case XSSFCell.CELL_TYPE_STRING:    
                        System.out.println(i + "��" + j + " �� is String type");    
                        value = cell.getStringCellValue();    
                        break;    
                    case XSSFCell.CELL_TYPE_NUMERIC:    
                        if ("@".equals(cell.getCellStyle().getDataFormatString())) {    
                            value = df.format(cell.getNumericCellValue());    
                        } else if ("General".equals(cell.getCellStyle()    
                                .getDataFormatString())) {    
                            value = nf.format(cell.getNumericCellValue());    
                        } else {    
                            value = sdf.format(HSSFDateUtil.getJavaDate(cell    
                                    .getNumericCellValue()));    
                        }    
                        System.out.println(i + "��" + j    
                                + " �� is Number type ; DateFormt:"    
                                + value.toString());   
                        break;    
                    case XSSFCell.CELL_TYPE_BOOLEAN:    
                        System.out.println(i + "��" + j + " �� is Boolean type");    
                        value = Boolean.valueOf(cell.getBooleanCellValue());  
                        break;    
                    case XSSFCell.CELL_TYPE_BLANK:    
                        System.out.println(i + "��" + j + " �� is Blank type");    
                        value = "";    
                        break;    
                    default:    
                        System.out.println(i + "��" + j + " �� is default type");    
                        value = cell.toString();    
                }// end switch  
                colList.add(value);  
            }//end for j  
            rowList.add(colList);  
        }//end for i             
        return rowList; 
    }
    public static String readCell2007(int rownum,int cellnum){
    	cell2007= excelSheet2007.getRow(rownum).getCell(cellnum);
    	String value;
    	 switch(cell2007.getCellType()){  
         	case XSSFCell.CELL_TYPE_STRING:   
                value = cell2007.getStringCellValue(); 
                break;    
            case XSSFCell.CELL_TYPE_NUMERIC:    
                if ("@".equals(cell2007.getCellStyle().getDataFormatString())) {    
                	value = df.format(cell2007.getNumericCellValue());    
                } else if ("General".equals(cell2007.getCellStyle()    
                        .getDataFormatString())) {    
                    value = nf.format(cell2007.getNumericCellValue());    
                } else {    
                    value = sdf.format(HSSFDateUtil.getJavaDate(cell2007    
                            .getNumericCellValue()));    
                }      
                break;    
            case XSSFCell.CELL_TYPE_BOOLEAN:      
                value = Boolean.valueOf(cell2007.getBooleanCellValue()).toString();  
                break;    
            case XSSFCell.CELL_TYPE_BLANK:     
                value = "";    
                break;    
            default:      
                value = cell2007.toString();    
        }// end switch  
    	return value;
    }
    public static String readCell2003(int rownum,int cellnum){
       	cell2003= excelSheet2003.getRow(rownum).getCell(cellnum);
       	String value;
       	 switch(cell2003.getCellType()){  
            	case XSSFCell.CELL_TYPE_STRING:   
                   value = cell2003.getStringCellValue(); 
                   break;    
               case XSSFCell.CELL_TYPE_NUMERIC:    
                   if ("@".equals(cell2003.getCellStyle().getDataFormatString())) {    
                   	value = df.format(cell2003.getNumericCellValue());    
                   } else if ("General".equals(cell2003.getCellStyle()    
                           .getDataFormatString())) {    
                       value = nf.format(cell2003.getNumericCellValue());    
                   } else {    
                       value = sdf.format(HSSFDateUtil.getJavaDate(cell2003    
                               .getNumericCellValue()));    
                   }      
                   break;    
               case XSSFCell.CELL_TYPE_BOOLEAN:      
                   value = Boolean.valueOf(cell2003.getBooleanCellValue()).toString();  
                   break;    
               case XSSFCell.CELL_TYPE_BLANK:     
                   value = "";    
                   break;    
               default:      
                   value = cell2003.toString();    
           }// end switch  
       	return value;
       }
    public static void remove(){}
    public static void write(){}
}