package test;

import interfaces.IGrafos;
import interfaces.IVertice;
import modelo.Grafos;
import modelo.Persona;

public class TestGrafos {
    public static void main(String[] args) {

        Grafos<Persona> grafo = new Grafos<>(false); // No dirigido

        Persona p1 = new Persona("Ana", 123);
        Persona p2 = new Persona("Bruno", 456);
        Persona p3 = new Persona("Carla", 789);

        grafo.agregarVertice(p1);
        grafo.agregarVertice(p2);
        grafo.agregarVertice(p3);

        grafo.agregarArista(p1, p2);
        grafo.agregarArista(p2, p3);

        grafo.mostrarListaAdyacencia();
        grafo.bfs(p1);
        grafo.dfs(p1);
        grafo.mostrarMatrizAdyacencia();
    }
}