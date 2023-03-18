package com.example.taller.procesador.archivo.Controller;

import com.example.taller.procesador.archivo.Model.Persona;
import com.example.taller.procesador.archivo.Service.CsvReader;
import com.example.taller.procesador.archivo.Service.FileResponse;
import com.example.taller.procesador.archivo.Service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {
    private final CsvReader csvReader;
    @Autowired
    public FileController(CsvReader csvReader) {
        this.csvReader = csvReader;

    }
    @PostMapping("/ArchivoCSV")
    public String procesar(@RequestBody String ruta){
        List<Persona> personas= csvReader.read(ruta);
        FileResponse lineas = procesadorService.procesar(personas);

        return lineas.toString();
    }


}
