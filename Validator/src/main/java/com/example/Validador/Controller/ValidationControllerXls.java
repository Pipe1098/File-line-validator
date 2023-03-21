package com.example.Validador.Controller;

import com.example.Validador.Model.Data;
import com.example.Validador.Service.ValidationServiceXLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationControllerXls {
    private final ValidationServiceXLS validationServiceXls;
    @Autowired
    public ValidationControllerXls(ValidationServiceXLS validationServiceXls) {
        this.validationServiceXls = validationServiceXls;
    }
    @PostMapping("/ArchivosXLS")
    public boolean procesarXLS(@RequestBody Data data) {
        boolean validez = validationServiceXls.validarCol(data);
        return validez;
    }
}
