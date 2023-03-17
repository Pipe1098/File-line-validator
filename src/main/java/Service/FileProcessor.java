package Service;

import Model.File;
import Model.Persona;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import javax.print.attribute.standard.Media;


public class FileProcessor {
    public static boolean pasarValidar(Persona persona) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:8090/api/v1/csv";
        HttpEntity<Persona> requestPersona = new HttpEntity<>(persona, headers);
        Boolean respuesta = restTemplate.postForObject(url,requestPersona, Boolean.class);

        //1 enviar una peticion POST al micrservicio de validacion.
        // post request (persona body)
        //restTemplate
        // hacerele el return a ;la respuesta.

        return respuesta;
    }


}
