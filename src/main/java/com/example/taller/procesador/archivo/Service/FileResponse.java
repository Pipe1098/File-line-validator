package com.example.taller.procesador.archivo.Service;

public class FileResponse {
    private int lineasValidas;
    private int lineasInvalidas;

    public FileResponse(int contadorLineaValida, int contadorLineaInvalida) {
        this.lineasValidas = lineasValidas;
        this.lineasInvalidas = lineasInvalidas;
    }

    public int getLineasValidas() {
        return lineasValidas;
    }

    public int getLineasInvalidas() {
        return lineasInvalidas;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "lineasValidas=" + lineasValidas +
                ", lineasInvalidas=" + lineasInvalidas +
                '}';
    }
}
