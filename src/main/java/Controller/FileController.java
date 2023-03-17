package Controller;

import Service.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    private final CsvReader csvReader;
    @Autowired
    public FileController(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    @PostMapping("/cargarArchivo")
    public boolean procesar(@RequestBody String ruta){
        csvReader.read(ruta);
        return true;
    }



}
