package interfaces;

import java.util.List;

public interface ICiudad {
    void agregarCamino(IUbicacion origen, IUbicacion destino, int distancia);
    List<IUbicacion> obtenerUbicaciones();
    IResultadoRuta obtenerRutaMasCorta(IUbicacion origen, IUbicacion destino);
}