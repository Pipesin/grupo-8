package test;

import java.util.List;
import java.util.Scanner;

import interfaces.ICiudad;
import interfaces.IUbicacion;
import interfaces.IResultadoRuta;

import modelo.Ciudad;
import modelo.Ubicacion;

public class SimulacionGPS {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ICiudad ciudad = new Ciudad();

        IUbicacion plaza = new Ubicacion("Plaza");
        IUbicacion supermercado = new Ubicacion("Supermercado");
        IUbicacion colegio = new Ubicacion("Colegio");
        IUbicacion hospital = new Ubicacion("Hospital");
        IUbicacion estacion = new Ubicacion("Estación");

        ciudad.agregarCamino(plaza, supermercado, 10);
        ciudad.agregarCamino(plaza, colegio, 15);
        ciudad.agregarCamino(supermercado, hospital, 12);
        ciudad.agregarCamino(colegio, estacion, 10);
        ciudad.agregarCamino(hospital, estacion, 2);

        List<IUbicacion> ubicaciones = ciudad.obtenerUbicaciones();
        System.out.println("Ubicaciones disponibles:");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println(i + ". " + ubicaciones.get(i));
        }

        System.out.print("\nSeleccioná el número de la ubicación de origen: ");
        int idxOrigen = entrada.nextInt();
        System.out.print("Seleccioná el número de la ubicación de destino: ");
        int idxDestino = entrada.nextInt();

        entrada.close();

        IResultadoRuta resultado = ciudad.obtenerRutaMasCorta(
            ubicaciones.get(idxOrigen), 
            ubicaciones.get(idxDestino)
        );
        resultado.mostrar();
    }
}