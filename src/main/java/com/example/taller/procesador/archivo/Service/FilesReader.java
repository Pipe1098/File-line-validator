package com.example.taller.procesador.archivo.Service;

import com.example.taller.procesador.archivo.Model.Persona;

import java.util.List;

public interface FilesReader {

    public List<Persona> read(String path);


}
