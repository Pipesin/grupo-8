package test;

import modelo.Lista;
import interfaces.ILista;

public class TestLista {
   public static void main(String[] args) {
       ILista lista = new Lista();

       // Verificamos si la lista está vacía o no.
       System.out.println("¿La lista está vacía?: " + lista.esVacia());

       // Insertar algunos elementos en diferentes posiciones.
       lista.insertarPrimero(10); // [10]
       lista.insertarUltimo(30); // [10, 30]
       lista.insertarUltimo(40); // [10, 30, 40]

       // Mostramos la lista.
       System.out.println("Lista después de cambios: ");
       lista.mostrarLista(); // Debería mostrar: 10 <-> 30 <-> 40 <-> null

       // Eliminamos el primer elemento.
       lista.eliminarPrimero();
       System.out.println("La lista después de eliminar el primero: ");
       lista.mostrarLista(); // Debería mostrar: 30 <-> 40 <-> null

       // Eliminamos el último elemento.
       lista.eliminarUltimo();
       System.out.println("La lista después de eliminar el último es: ");
       lista.mostrarLista(); // Debería mostrar: 30 <-> null

       // Reinsertamos los valores y verificamos.
       lista.insertarPrimero(20); // [20, 30]
       lista.insertarUltimo(50); // [20, 30, 50]

       // Mostrar lista final.
       System.out.println("Lista final:");
       lista.mostrarLista(); // Debería mostrar: 20 <-> 30 <-> 50 <-> null

       // Verificamos si la lista está vacía.
       System.out.println("¿La lista está vacía?: " + lista.esVacia());
   }
}
