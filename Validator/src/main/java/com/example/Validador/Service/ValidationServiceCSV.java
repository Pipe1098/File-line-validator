package com.example.Validador.Service;
import com.example.Validador.Model.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
    public class ValidationServiceCSV {
        public ValidationServiceCSV(){}

        private final static String EMAIL_REGEX = "[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        private final static LocalDate MIN_FECHA_NACIMIENTO = LocalDate.of(1980, 1, 1);
        private final static Set<String> JOB_TITLES_VALIDOS = Set.of(
                "Haematologist", "Phytotherapist", "Building surveyor",
                "Insurance account manager", "Educational psychologist"

        );

        private boolean validarEmail(String email) {
            boolean x= email.matches(EMAIL_REGEX);
            return x;
        }

        private boolean validarFechaNacimiento(String fechaNacimiento) {
          LocalDate fechaNac = LocalDate.parse(fechaNacimiento);
            return fechaNac.isAfter(MIN_FECHA_NACIMIENTO);
        }

        private boolean validarJobTitle(String jobTitle) {
            return JOB_TITLES_VALIDOS.contains(jobTitle);
        }
        public boolean validarLinea(Person persona) {

            boolean esValido = true;
            if (!validarEmail(persona.getEmail())) {
                return false; // El email no es válido
            }

            if (!validarFechaNacimiento(persona.getDateBirth())) {
                return false; // La fecha de nacimiento no es válida
            }
            if (!validarJobTitle(persona.getJobTitle())) {
                return false; // El título del trabajo no es válido
            }
            return esValido;

        }

    }
