package com.avenger.edu.teac.poi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.avenger.edu.teac.model.Grade;

@Component
public class Excel {

	public List<Grade> getValue(MultipartFile file) {
	
		List<Grade> list = new ArrayList<Grade>();
		InputStream in = null;
		try {
			in = file.getInputStream();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		POIFSFileSystem fs = null;
		Workbook wb = null;
		try {
			fs = new POIFSFileSystem(in);
			wb = new HSSFWorkbook(fs);
		} catch (Exception e) {
			try {
				InputStream in2 = file.getInputStream();
				wb = new XSSFWorkbook(in2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
		    org.apache.poi.ss.usermodel.Sheet hssfSheet = wb.getSheetAt(numSheet);
		    if (hssfSheet == null) { 
		        continue;
		    }
		    for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
		         Row hssfRow = hssfSheet.getRow(rowNum);
		        if (hssfRow == null) { 
		            continue;
		        } 
		       
		        Grade gra = new Grade();
		        gra.setStuId((int)hssfRow.getCell(0).getNumericCellValue());
		        gra.setTeaId((int)hssfRow.getCell(1).getNumericCellValue());
		        gra.setScore((int)hssfRow.getCell(2).getNumericCellValue());
		        gra.setPoint((int)hssfRow.getCell(3).getNumericCellValue());
		        gra.setJudge(hssfRow.getCell(4).getStringCellValue());
		       list.add(gra);
		    }
		}
		return list;
	}
}
