package modelo;

import java.util.*;

import interfaces.ICamino;
import interfaces.ICiudad;
import interfaces.IResultadoRuta;
import interfaces.IUbicacion;

public class Ciudad implements ICiudad {
    private Map<IUbicacion, List<ICamino>> mapa = new HashMap<>();

    @Override
    public void agregarCamino(IUbicacion origen, IUbicacion destino, int distancia) {
        mapa.putIfAbsent(origen, new ArrayList<>());
        mapa.putIfAbsent(destino, new ArrayList<>());
        mapa.get(origen).add(new Camino(origen, destino, distancia));
        mapa.get(destino).add(new Camino(destino, origen, distancia));
    }

    @Override
    public List<IUbicacion> obtenerUbicaciones() {
        return new ArrayList<>(mapa.keySet());
    }

    @Override
    public IResultadoRuta obtenerRutaMasCorta(IUbicacion inicio, IUbicacion fin) {
        Map<IUbicacion, Integer> distancias = new HashMap<>();
        Map<IUbicacion, IUbicacion> anteriores = new HashMap<>();
        PriorityQueue<IUbicacion> cola = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (IUbicacion ubicacion : mapa.keySet()) {
            distancias.put(ubicacion, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            IUbicacion actual = cola.poll();
            for (ICamino camino : mapa.getOrDefault(actual, Collections.emptyList())) {
                int nuevaDist = distancias.get(actual) + camino.getDistancia();
                if (nuevaDist < distancias.get(camino.getDestino())) {
                    distancias.put(camino.getDestino(), nuevaDist);
                    anteriores.put(camino.getDestino(), actual);
                    cola.add(camino.getDestino());
                }
            }
        }

        List<IUbicacion> ruta = new ArrayList<>();
        IUbicacion actual = fin;
        while (actual != null) {
            ruta.add(actual);
            actual = anteriores.get(actual);
        }
        Collections.reverse(ruta);
        return new ResultadoRuta(ruta, distancias.getOrDefault(fin, Integer.MAX_VALUE));
    }
}