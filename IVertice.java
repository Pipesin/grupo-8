package interfaces;
import java.util.List;

public interface IVertice<T> {
    T getDato();
    void agregarVecino(IVertice<T> vecino);
    List<IVertice<T>> getVecinos();
}