package com.example.taller.procesador.archivo.Service;

import com.example.taller.procesador.archivo.Model.File;
import com.example.taller.procesador.archivo.Model.Persona;

import java.util.List;

public class ProcessorService {

    private CsvReader lectorArchivo;
    private FileProcessor procesadorArchivo;

    public ProcessorService(){

    }

    public FileResponse procesar(List<Persona> listaPersona){
         int contadorLineaValida = 0;
         int contadorLineaInvalida = 0;
        for (Persona persona: listaPersona) {
            boolean esValido = FileProcessor.pasarValidar(persona); // comunicacion con el otro servicio.
            if(esValido){
                contadorLineaValida++;

            }
            else{
                contadorLineaInvalida++;

            }
        }
        System.out.println("El numero de lineas validas es:"+ contadorLineaValida);
        System.out.println("El numero de lineas invalidas es:"+contadorLineaInvalida);
        FileResponse resultado = new FileResponse(contadorLineaValida,contadorLineaInvalida);
        System.out.println(resultado.toString());
        //1 leer el archivo dependiendo de la extension.
        //2 enviar cada linea (persona) del archivo al microservicio de validacion.
        //3 recibir la respuesta (boolean ) si es true = linea valida si es false linea invalida

        return resultado;
    }
}
