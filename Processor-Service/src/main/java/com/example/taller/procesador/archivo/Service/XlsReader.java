package com.example.taller.procesador.archivo.Service;

import com.example.taller.procesador.archivo.Model.Data;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class XlsReader implements FilesReader {

    @Override
    public List<Data> read(String path) {

        List<Data> dataList = new ArrayList<>();
        try {
            File f = new File(path);
            InputStream inp = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            int iRow=1;
            Row row = sheet.getRow(iRow); 
            while(row!=null)
            {
                Data data=new Data(row.getCell(1).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        row.getCell(3).getStringCellValue(),
                        row.getCell(4).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(6).getStringCellValue(),
                        row.getCell(7).getStringCellValue(),
                        row.getCell(8).getStringCellValue(),
                        row.getCell(9).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(1).getStringCellValue());

                dataList.add(data);
                iRow++;
                row = sheet.getRow(iRow);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dataList;
    }
}
