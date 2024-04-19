package uniandes.dpoo.galeria.modelo.usuario;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.plataforma.Subasta;

public class Usuario {
    protected String nombre;
    protected int identificacion;
    protected int edad;
    protected String nombreUsuario;
    protected String password;

    public Usuario(String nombre, int identificacion, int edad, String nombreUsuario, String password) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

  
   public void ofertarSubasta(Pieza pieza, Usuario usuario) {
        
        pieza.recibirOferta(this, usuario);
       
        Subasta subasta = Subasta.getSubastaPorPieza(pieza);
        if (subasta != null) {
            subasta.registrarOferta(this, pieza);
        }
    }

    public void registrarsePlataforma() {
      
        boolean esRegistrado = Plataforma.registrarUsuario(this);
        if (esRegistrado) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("El registro ha fallado.");
        }
    }

    public void ingresarPlataforma() {
       
        boolean esValido = Plataforma.validarCredenciales(this.nombreUsuario, this.password);
        if (esValido) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Inicio de sesión fallido.");
        }
    }
}
