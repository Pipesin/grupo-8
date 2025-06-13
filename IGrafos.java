package interfaces;

public interface IGrafos<T> {
    void agregarVertice(T dato);
    void agregarArista(T origen, T destino);
    void mostrarMatrizAdyacencia();
    void mostrarListaAdyacencia();
    void dfs(T inicio);
    void bfs(T inicio);
    
}