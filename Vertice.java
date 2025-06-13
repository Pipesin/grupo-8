package modelo;

import java.util.ArrayList;
import java.util.List;
import interfaces.IVertice;

public class Vertice<T> implements IVertice<T> {
	
    private T valor; // Valor almacenado en el nodo; T <T>
    private List< IVertice<T>> vecinos; // Lista de nodos vecinos (adyacentes)

    // Constructor
    public Vertice(T valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>();
    }

    // Getter del valor
    public T getDato() {
        return valor;
    }

    // Setter del valor
    public void setValor(T valor) {
        this.valor = valor;
    }

    // Agrega un nodo vecino a la lista de adyacencia
    public void agregarVecino( IVertice<T> vecino) {
            vecinos.add(vecino);
        }
    

    // Devuelve la lista de vecinos
    public List< IVertice<T>> getVecinos() {
        return vecinos;
    }
   
    public String toString() {
        return valor.toString();
    }
}