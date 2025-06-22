package modelo;

import java.util.Objects;

import interfaces.IUbicacion;

public class Ubicacion implements IUbicacion {
    private String nombre;

    public Ubicacion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Ubicacion && nombre.equals(((Ubicacion) o).nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}