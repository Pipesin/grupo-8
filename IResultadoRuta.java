package interfaces;

import java.util.List;

public interface IResultadoRuta {
    List<IUbicacion> getRuta();
    int getDistanciaTotal();
    void mostrar();
}