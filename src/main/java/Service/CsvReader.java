package Service;

import Model.Persona;
import com.opencsv.CSVReader;
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
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Enrique\\Desktop\\people.csv"));
            String[] linea;
            while ((linea = reader.readNext()) != null) {
                Persona persona = new Persona(linea[1], linea[2], linea[3], linea[4], linea[5],linea[6],linea[7], linea[8]);
                personas.add(persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }
}






