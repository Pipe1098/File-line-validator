package com.example.Validador.Controller;

import com.example.Validador.Model.Data;
import com.example.Validador.Service.ValidationServiceXls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationControllerXls {
    private final ValidationServiceXls validationServiceXML;
    @Autowired
    public ValidationControllerXls(ValidationServiceXls validationServiceXML) {
        this.validationServiceXML = validationServiceXML;
    }
    @PostMapping("/ArchivosXML")
    public boolean procesarXML(@RequestBody Data data) {
        boolean validez = validationServiceXML.validarCol(data);
        return validez;
    }
}
