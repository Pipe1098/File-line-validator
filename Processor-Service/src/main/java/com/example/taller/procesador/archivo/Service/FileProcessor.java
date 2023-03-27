package com.example.taller.procesador.archivo.Service;

import com.example.taller.procesador.archivo.Model.Data;
import com.example.taller.procesador.archivo.Model.Persona;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


public class FileProcessor {
    public static boolean pasarValidarCSV(Persona persona) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:8082/ArchivosCSV";
        HttpEntity<Persona> requestPersona = new HttpEntity<>(persona,headers);
        boolean respuesta = restTemplate.postForObject(url,requestPersona, boolean.class);

        return respuesta;
    }
    public static boolean pasarValidarXML(Data data) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:8082/ArchivosXLS";
        HttpEntity<Data> requestData = new HttpEntity<>(data,headers);
        boolean respuesta = restTemplate.postForObject(url,requestData, boolean.class);

        return respuesta;
    }

}
