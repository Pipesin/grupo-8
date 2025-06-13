package modelo;

import java.util.*;
import interfaces.IGrafos;
import interfaces.IVertice;

public class Grafos<T extends Comparable<T>> implements IGrafos<T> {

    private Map<T, Vertice<T>> nodos = new HashMap<>();
    private boolean dirigido;

    public Grafos(boolean dirigido) {
        this.dirigido = dirigido;
    }

    public void agregarVertice(T valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new Vertice<>(valor));
        }
    }

    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Vertice<T> nodoOrigen = nodos.get(origen);
            Vertice<T> nodoDestino = nodos.get(destino);

            nodoOrigen.agregarVecino(nodoDestino);
            if (!dirigido) {
                nodoDestino.agregarVecino(nodoOrigen);
            }
        }
    }

    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        List<T> claves = new ArrayList<>(nodos.keySet());
        Collections.sort(claves); // Ordenar nodos

        System.out.print("   ");
        for (T j : claves) System.out.print(j + " ");
        System.out.println();

        for (T i : claves) {
            System.out.print(i + ": ");
            for (T j : claves) {
                Vertice<T> nodoI = nodos.get(i);
                Vertice<T> nodoJ = nodos.get(j);
                System.out.print(nodoI.getVecinos().contains(nodoJ) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
        for (Map.Entry<T, Vertice<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            for (IVertice<T> vecino : entrada.getValue().getVecinos()) {
                System.out.print(vecino.getDato() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<Vertice<T>> cola = new LinkedList<>();

        cola.add(nodos.get(inicio));
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Vertice<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");
            for (IVertice<T> vecino : actual.getVecinos()) {
                T val = vecino.getDato();
                if (!visitados.contains(val)) {
                    visitados.add(val);
                    cola.add((Vertice<T>) vecino);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(Vertice<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato() + " ");
        for (IVertice<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getDato())) {
                dfsRec((Vertice<T>) vecino, visitados);
            }
        }
    }
}