package uam.edu.ni.torneoapp4;

public class Participante {

    private String nombre;
    private int edad;
    private String telefono;
    private String categoria;
    private String genero;
    private String modalidad;
    private String disciplina;
    private String caracteristicas;
    private String estado;

    public Participante(String nombre, int edad, String telefono,
                        String categoria, String genero,
                        String modalidad, String disciplina,
                        String caracteristicas, String estado) {

        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.categoria = categoria;
        this.genero = genero;
        this.modalidad = modalidad;
        this.disciplina = disciplina;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getGenero() {
        return genero;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getEstado() {
        return estado;
    }
}
