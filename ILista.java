package interfaces;

public interface ILista {
	
    boolean esVacia();
    
    void insertarPrimero(int dato);
    
    void insertarUltimo(int dato);
    
    void eliminarPrimero();
    
    void eliminarUltimo();
    
    void mostrarLista();
}