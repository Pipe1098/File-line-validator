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
        String url = "http://localhost:8090/ArchivosCSV";
        HttpEntity<Persona> requestPersona = new HttpEntity<>(persona,headers);
        boolean respuesta = restTemplate.postForObject(url,requestPersona, boolean.class);

        return respuesta;
    }
    public static boolean pasarValidarXML(Data data) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:8090/ArchivosXML";
        HttpEntity<Data> requestData = new HttpEntity<>(data,headers);
        boolean respuesta = restTemplate.postForObject(url,requestData, boolean.class);


/*       RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
        ResponseEntity<Foo> response = restTemplate
                .exchange(fooResourceUrl, HttpMethod.POST, request, Foo.class);

        Assertions.assertEquals(response.getStatusCode(), HttpStatus.CREATED);

        Foo foo = response.getBody();

        Assertions.assertNotNull(foo);
        Assertions.assertEquals(foo.getName(), "bar");

        1 enviar una peticion POST al micrservicio de validacion.
         post request (persona body)
        restTemplate
         hacerele el return a ;la respuesta.*/

        return respuesta;
    }

}
