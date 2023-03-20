package com.example.taller.procesador.archivo.Controller;


import com.example.taller.procesador.archivo.Model.File;
import com.example.taller.procesador.archivo.Service.CsvReader;
import com.example.taller.procesador.archivo.Service.ProcessorService;
import com.example.taller.procesador.archivo.Service.XlsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    private final CsvReader csvReader;
    private final XlsReader xlsReader;
    private final ProcessorService procesadorService = new ProcessorService();

    @Autowired
    public FileController(CsvReader csvReader, XlsReader xlsReader) {
        this.csvReader = csvReader;
        this.xlsReader = xlsReader;

    }

    @PostMapping("/Archivo")
    public String procesarCSV(@RequestBody File file) {
       String respuesta= procesadorService.procesar(file, csvReader,xlsReader);
       return respuesta;
    }

    }

