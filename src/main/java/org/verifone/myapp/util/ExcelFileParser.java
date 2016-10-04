package org.verifone.myapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileParser {

	/**
	 * @author PritpalT1
	 * @param args
	 */
	public void startParser() {
		// TODO Auto-generated method stub

		/* //Blank workbook
		System.out.println("Here 1");
        XSSFWorkbook workbook = new XSSFWorkbook();
        System.out.println("Here 2");
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee_Data");
          System.out.println("File Created");
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("5", new Object[] {4, "Brian", "Schultz"});
          System.out.println("Map Created");
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File(""));
            System.out.println("Writing data");
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
        	System.out.println("Write Exception");
            e.printStackTrace();
            
        }*/
		
		
		
		
		
		/**
		 * Writing Files
		 */
		
		try
		{
			
			int validColCount = 0;
			int colCount = 0;
			boolean skip = true;
			FileInputStream file = new FileInputStream(new File("c:\\testfile.xlsx"));

			if(file!=null){
				System.out.println("File found");
			}else{
				System.out.println("File not found");
			}
			
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			System.out.println("Workbook created");
			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			System.out.println("Sheet created");
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			System.out.println("Going to Iterate");
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				System.out.println("Number of cells in a row "+row.getPhysicalNumberOfCells());
				
				colCount = row.getPhysicalNumberOfCells();
				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					if(skip == false){
						if( colCount!= validColCount){
							System.out.println("Discardign Row");
							break;
						}
					}
					//Check the cell type and format accordingly
					switch (cell.getCellType())
					{
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "     ,    ");
						
						break;
					case Cell.CELL_TYPE_STRING:
						if(cell.getStringCellValue().equalsIgnoreCase("Device/Cable")){
							skip = false;
							validColCount = row.getPhysicalNumberOfCells();
						}
						if(skip == false){
							System.out.print(cell.getStringCellValue() + "     ,    ");
						}else{
							System.out.println("Discarding Row 3u49023");
						}
						break;
					case Cell.CELL_TYPE_BLANK:
						if(skip == false)
							System.out.print("Blank" + "     ,    ");
						break;
					}
				}
				System.out.println("");
				System.out.println("");
			}
			file.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}



	}

}
