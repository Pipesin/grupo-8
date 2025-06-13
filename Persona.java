package modelo;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
	 private String nombre;
	    private int dni;

	    public Persona(String nombre, int dni) {
	        this.nombre = nombre;
	        this.dni = dni;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getDni() {
	        return dni;
	    }

	    @Override
	    public int compareTo(Persona otra) {
	        // Por ejemplo, ordenamos por dni
	        return Integer.compare(this.dni, otra.dni);
	    }

	    @Override
	    public String toString() {
	        return nombre + " (" + dni + ")";
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Persona)) return false;
	        Persona p = (Persona) o;
	        return dni == p.dni;
	    }

	    @Override
	    public int hashCode() {
	        return Integer.hashCode(dni);
	    }
	}