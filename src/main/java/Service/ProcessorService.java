package Service;

import Model.File;
import Model.Persona;

import java.util.List;

public class ProcessorService {
    private int contadorLineaValida = 0;
    private int contadorLineaInvalida = 0;
    private CsvReader lectorArchivo;
    private FileProcessor procesadorArchivo;


    public FileResponse procesar(File file){
        List<Persona> listaPersona =  lectorArchivo.read(file.getRuta());
        for (Persona persona: listaPersona) {
            boolean esValido = FileProcessor.pasarValidar(persona); // comunicacion con el otro servicio.
            if(esValido){
                contadorLineaValida++;
            }
            else{
                contadorLineaInvalida++;
            }
        }
        FileResponse resultado = new FileResponse(contadorLineaValida,contadorLineaInvalida);
        //1 leer el archivo dependiendo de la extension.
        //2 enviar cada linea (persona) del archivo al microservicio de validacion.
        //3 recibir la respuesta (boolean ) si es true = linea valida si es false linea invalida

        return resultado;
    }
}
