package com.example.taller.procesador.archivo.Service;

import java.util.List;

public class FileResponse {
    private int lineasValidas;
    private int lineasInvalidas;
    private List<Integer> listaPos ; //posicion de las lineas validas

    public FileResponse(int contadorLineaValida, int contadorLineaInvalida, List<Integer> posicionLineasValidas) {
        this.lineasValidas = contadorLineaValida;
        this.lineasInvalidas = contadorLineaInvalida;
        this.listaPos =posicionLineasValidas;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "lineasValidas=" + lineasValidas +
                ", lineasInvalidas=" + lineasInvalidas +
                ", listaPosValidas=" + listaPos +
                '}';
    }
}
