package com.endtoendtesting.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.endtoendtesting.pojo.AddProductPojo;

public class ReadExcelUtility {

	public static Iterator<AddProductPojo> readExcelFile(String filename) {
		File file=new File(System.getProperty("user.dir")+"\\testdata\\"+filename +".xlsx");
		XSSFWorkbook xssfWorkbok;
		XSSFSheet xssfsheet;
		Iterator<Row> iteratorrow;
		AddProductPojo addProduct = null;
		List<AddProductPojo> addProductList = null;
		
		
		try {
			 xssfWorkbok=new XSSFWorkbook(file);
			 xssfsheet=xssfWorkbok.getSheet("Sheet1");
		     iteratorrow=xssfsheet.rowIterator();
			iteratorrow.next();
			addProductList=new ArrayList();
			
			while(iteratorrow.hasNext()) {
				Row row=iteratorrow.next();
				Cell username=row.getCell(0);
				Cell password=row.getCell(1);
				Cell product=row.getCell(2);
				addProduct=new AddProductPojo(username.toString(),password.toString(), product.toString());
				System.out.println(username.toString());
				System.out.println(password.toString());
				System.out.println(product.toString());
				addProductList.add(addProduct);
			}
			
		
			System.out.println(addProductList.size());
			System.out.println(addProductList);
			
		} catch (InvalidFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
		return addProductList.iterator();
		
	}

}
