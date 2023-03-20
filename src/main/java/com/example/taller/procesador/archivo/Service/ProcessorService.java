package com.example.taller.procesador.archivo.Service;

import com.example.taller.procesador.archivo.Model.Data;
import com.example.taller.procesador.archivo.Model.File;
import com.example.taller.procesador.archivo.Model.Persona;

import java.util.ArrayList;
import java.util.List;

public class ProcessorService {

    //1 leer el archivo dependiendo de la extension.
    //2 enviar cada linea (persona) del archivo al microservicio de validacion.
    //3 recibir la respuesta (boolean ) si es true = linea valida si es false linea invalida

    public ProcessorService(){
    }
    public FileResponse procesarCSV(List<Persona> listaPersona){
         int contadorLineaValida = 0;
         int contadorLineaInvalida = 0;
        List<Integer> listaPos = new ArrayList<>();
         int i=0;
        for (Persona persona: listaPersona) {
            boolean esValido = FileProcessor.pasarValidarCSV(persona); // comunicacion con el otro servicio.
            if(esValido){
                contadorLineaValida++;
                listaPos.add(listaPersona.indexOf(persona));
            }
            else{
                contadorLineaInvalida++;
                i++;
            }
        }
      /*  System.out.println("El numero de lineas validas es:"+ contadorLineaValida);
        System.out.println("El numero de lineas invalidas es:"+contadorLineaInvalida);*/

        FileResponse resultado = new FileResponse(contadorLineaValida,contadorLineaInvalida,listaPos);
        System.out.println(resultado.toString());

        return resultado;
    }
    public FileResponse procesarXML(List<Data> listData){
        int contadorLineaValida = 0;
        int contadorLineaInvalida = 0;
        List<Integer> listaPos = new ArrayList<>();
        int i=0;
        for (Data data: listData) {
            boolean esValido = FileProcessor.pasarValidarXML(data); // comunicacion con el otro servicio.
            if(esValido){
                contadorLineaValida++;
                listaPos.add(listData.indexOf(data));
            }
            else{
                contadorLineaInvalida++;
                i++;
            }
        }
        FileResponse resultado = new FileResponse(contadorLineaValida,contadorLineaInvalida,listaPos);
        return resultado;
    }

    public  String procesar(File file, CsvReader csvReader, XlsReader xlsReader){
        if (file.getTipo().contains("csv")) {
            List<Persona> personas = csvReader.read(file.getRuta());
            FileResponse lineas = procesarCSV(personas);
            return lineas.toString();
        } else if (file.getTipo().contains("xlsx")) {
            List<Data> listData = xlsReader.read(file.getRuta());
            FileResponse lineas = procesarXML(listData);
            // listData.forEach(System.out::println);
            return lineas.toString();
        }
        else return "Archivo no permitido";
    }
}
