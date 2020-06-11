package com.javasm.demo;

import com.alibaba.excel.EasyExcel;
import com.javasm.demo.entity.UserExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void jodaTime(){
        System.out.println(new DateTime(new Date()).toString("yyyy-MM-dd HH:mm:ss"));
    }

    private List<UserExcel> data(){
        List<UserExcel> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            UserExcel mydata=new UserExcel();
            mydata.setUser_id(i);
            mydata.setUser_name("时间点"+i);
            mydata.setUser_age(i+16);
            mydata.setLast_loginTime(new Date());
            list.add(mydata);
        }
        return list;
    }

    @Test
    void easyexcelwrite(){
        String PATH="D:\\practice\\";
        String fileName="EasyTest1.xlsx";
        String filePath=PATH+fileName;
        EasyExcel.write(filePath,UserExcel.class).sheet("模板").doWrite(data());
    }

	@Test
    /*POI,写excel表*/
	void writeExcel() {
	    String PATH="D:\\practice\\";
		/*创建工作簿*/
		Workbook workbook=new HSSFWorkbook();
		/*创建工作表*/
		Sheet sheet=workbook.createSheet("用户统计表");
		/*创建行*/
		Row row1=sheet.createRow(0);
		/*创建列,单元格*/
        Cell cell11 = row1.createCell(0);
        Cell cell12 = row1.createCell(1);
        cell11.setCellValue("用户ID");
        cell12.setCellValue("用户姓名");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(PATH+"exceltest1.xls");
            try {
                workbook.write(fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
        /*POI,读excel表*/
    void readExcel() {
        String PATH="D:\\practice\\";
        try {
            FileInputStream fileInputStream=new FileInputStream(PATH+"通讯录.xlsx");
            /*获得工作簿*/
            Workbook workbook=new XSSFWorkbook(fileInputStream);
            /*获得工作表*/
            Sheet sheet=workbook.getSheetAt(0);
            /*获得行*/
            Row row = sheet.getRow(0);
            /*获得列*/
            if(row!=null){
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();//获取列数
                for(int i=0;i<physicalNumberOfCells;i++){
                    Cell cell = row.getCell(i);
                    if(cell!=null){
                        System.out.println(cell);
                        // TODO: 2020/6/10 根据cell的数据的类型获取数据，需要进行类型匹配
                        switch(cell.getCellTypeEnum()){
                            case STRING:
                        }
                        System.out.println(cell.getCellTypeEnum());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
