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

        FileResponse resultado = new FileResponse(contadorLineaValida,contadorLineaInvalida,listaPos);
        System.out.println(resultado.toString());

        return resultado;
    }
    public FileResponse procesarXLS(List<Data> listData){
        int contadorLineaValida = 0;
        int contadorLineaInvalida = 0;
        List<Integer> listaPos = new ArrayList<>();
        int i=0;
        for (Data data: listData) {
            boolean esValido = FileProcessor.pasarValidarXLS(data); // comunicacion con el otro servicio.
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

    public String procesar(File file, CsvReader csvReader, XlsReader xlsReader) {
        String tipoArchivo = file.getTipo().toLowerCase();
        if (tipoArchivo.equals("csv") || tipoArchivo.equals("opencsv")) {
            List<Persona> personas = csvReader.read(file.getRuta());
            FileResponse lineas = procesarCSV(personas);
            return lineas.toString();
        } else if (tipoArchivo.equals("xlsx") || tipoArchivo.equals("xls") || tipoArchivo.equals("excel")) {
            List<Data> listData = xlsReader.read(file.getRuta());
            FileResponse lineas = procesarXLS(listData);
            return lineas.toString();
        } else {
            return "Archivo no permitido";
        }
    }
}
