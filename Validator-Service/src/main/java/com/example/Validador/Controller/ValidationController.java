package com.example.Validador.Controller;

import com.example.Validador.Model.Data;
import com.example.Validador.Model.Person;
import com.example.Validador.Service.ValidationServiceCSV;
import com.example.Validador.Service.ValidationServiceXLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationController {
    private final ValidationServiceXLS validationServiceXML;
    private final ValidationServiceCSV validationServiceCSV;
    @Autowired
    public ValidationController(ValidationServiceXLS validationServiceXML, ValidationServiceCSV validationServiceCSV) {
        this.validationServiceXML = validationServiceXML;

        this.validationServiceCSV = validationServiceCSV;
    }
    @PostMapping("/ArchivosXLS")
    public boolean procesarXLS(@RequestBody Data data) {
        boolean validez = validationServiceXML.validarCol(data);
        return validez;
    }
    @PostMapping("/ArchivosCSV")
    public boolean procesarCSV(@RequestBody Person persona) {
        boolean validez = validationServiceCSV.validarLinea(persona);
        return validez;
    }
}
