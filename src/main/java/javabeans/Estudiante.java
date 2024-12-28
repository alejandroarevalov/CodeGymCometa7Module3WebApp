package javabeans;

import java.io.Serializable;
import java.util.Objects;

public class Estudiante implements Serializable {

    private String nombre;
    private String pais;
    private int edad;

    public Estudiante() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Estudiante that = (Estudiante) object;
        return edad == that.edad && Objects.equals(nombre, that.nombre) && Objects.equals(pais, that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais, edad);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Estudiante{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", pais='").append(pais).append('\'');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
}
