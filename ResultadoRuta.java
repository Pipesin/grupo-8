package modelo;

import java.util.List;

import interfaces.IResultadoRuta;
import interfaces.IUbicacion;

public class ResultadoRuta implements IResultadoRuta {
    private List<IUbicacion> ruta;
    private int distanciaTotal;

    public ResultadoRuta(List<IUbicacion> ruta, int distanciaTotal) {
        this.ruta = ruta;
        this.distanciaTotal = distanciaTotal;
    }

    @Override
    public List<IUbicacion> getRuta() {
        return ruta;
    }

    @Override
    public int getDistanciaTotal() {
        return distanciaTotal;
    }

    @Override
    public void mostrar() {
        System.out.println("\nRuta más corta:");
        for (int i = 0; i < ruta.size(); i++) {
            System.out.print(ruta.get(i));
            if (i < ruta.size() - 1) System.out.print(" → ");
        }
        System.out.println("\nDistancia total: " + distanciaTotal + " km\n");
    }
}