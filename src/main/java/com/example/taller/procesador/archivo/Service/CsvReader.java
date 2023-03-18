package com.example.taller.procesador.archivo.Service;

import com.example.taller.procesador.archivo.Model.Persona;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class CsvReader implements FilesReader {
    @Override
    public List<Persona> read(String path) {
        List<Persona> personas = new ArrayList<>();
        try {
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader reader = new CSVReaderBuilder(new FileReader(path))
                    .withCSVParser(parser)
                    .withSkipLines(1)
                    .build();
            String[] linea;
            while ((linea = reader.readNext()) != null) {
                Persona persona = new Persona(linea[1], linea[2], linea[3], linea[4], linea[5],linea[6],linea[7], linea[8]);
                personas.add(persona);
                System.out.println(persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }
}






