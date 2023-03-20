package com.example.Validador.Service;

import com.example.Validador.Model.Data;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceXls {

    public boolean validarCol(Data data) {
        boolean esValid = true;
            // Validar el Injury Location que sea diferente de N/A
            if (data.getInjuryLocation()== null || data.getInjuryLocation().equalsIgnoreCase("N/A")) {
                esValid = false;

            }
            // Validar el Report Type solo se deben aceptar (Near Miss, Lost Time, First Aid)
            if (!data.getReportType().equalsIgnoreCase("Near Miss") &&
                    !data.getReportType().equalsIgnoreCase("Lost Time") &&
                    !data.getReportType().equalsIgnoreCase("First Aid")) {
                esValid = false;
            }
        return esValid;
        }

    }


