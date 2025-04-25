package interfaces;

public interface INodo {
	
    int getDato();
    
    void setDato(int dato);
    
    INodo getSiguiente();
    
    void setSiguiente(INodo nodo);
    
    INodo getAnterior();
    
    void setAnterior(INodo nodo);
}