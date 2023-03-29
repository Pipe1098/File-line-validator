package com.example.Validador.Controller;
import com.example.Validador.Model.Person;
import com.example.Validador.Service.ValidationServiceCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationControllerCsv {
    private final ValidationServiceCSV validationServiceCSV;
    @Autowired
    public ValidationControllerCsv(ValidationServiceCSV validationService) {
        this.validationServiceCSV = validationService;
    }
    //    @RequestMapping(value = "/Person", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @PostMapping("/ArchivosCSV")
    public boolean procesarCSV(@RequestBody Person persona) {
        boolean validez = validationServiceCSV.validarLinea(persona);
        return validez;
    }


}