package com.endtoendtesting.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.endtoendtesting.pojo.AddProductPojo;
import com.endtoendtesting.utility.ReadExcelUtility;

public class ExcelDataProvider {
	
	@DataProvider(name = "AddProductToCartDataProvider")
	public Iterator<AddProductPojo> AddProductDataProvider() {
		return ReadExcelUtility.readExcelFile("addproducttocart");
	}

}
