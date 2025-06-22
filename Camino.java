package modelo;

import interfaces.ICamino;
import interfaces.IUbicacion;

public class Camino implements ICamino {
    private IUbicacion origen;
    private IUbicacion destino;
    private int distancia;

    public Camino(IUbicacion origen, IUbicacion destino, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    @Override
    public IUbicacion getOrigen() {
        return origen;
    }

    @Override
    public IUbicacion getDestino() {
        return destino;
    }

    @Override
    public int getDistancia() {
        return distancia;
    }
}