package uniandes.dpoo.galeria.modelo.empleado;

import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.plataforma.Subasta;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

import java.util.ArrayList;

public class OperadorGaleria extends Empleado {

    private HashMap<Pieza, Subasta> subastasActivas;
    private HashMap<Pieza, ArrayList<Usuario>> participantesPorSubasta;
    private HashMap<Pieza, HashMap<Usuario, Integer>> ofertasPorSubasta;
    private Subasta subasta = new Subasta();
    private Plataforma plataforma= new Plataforma();

    public OperadorGaleria(String nombre, int identificacion, int edad) {
        super("Operador", nombre, identificacion, edad);
        subastasActivas = new HashMap<>();
        participantesPorSubasta = new HashMap<>();
        ofertasPorSubasta = new HashMap<>();
    }

    public void iniciarSubasta(Pieza pieza) {
    	subasta.agregarPiezaASubastar(pieza);
        subastasActivas.put(pieza, subasta);
        participantesPorSubasta.put(pieza, new ArrayList<>());
        ofertasPorSubasta.put(pieza, new HashMap<>());
    }

    public void registrarParticipantesSubasta(Usuario usuario, Pieza pieza) {
        ArrayList<Usuario> participantes = participantesPorSubasta.getOrDefault(pieza, new ArrayList<>());
        if (!participantes.contains(usuario)) {
            participantes.add(usuario);
        }
        participantesPorSubasta.put(pieza, participantes);
    }

    public void registrarOfertasSubasta(Usuario usuario, Pieza pieza, int oferta) {
    	if (aceptarOfertasSubasta(pieza, usuario)) {
    	subasta.agregarOfertaSubasta(usuario, oferta, pieza);
        HashMap<Usuario, Integer> ofertas = ofertasPorSubasta.getOrDefault(pieza, new HashMap<>());
        ofertas.put(usuario, oferta);
        ofertasPorSubasta.put(pieza, ofertas);}
    }

    public boolean aceptarOfertasSubasta(Pieza pieza, Usuario usuario) {
      
    	Comprador comprador = (Comprador) usuario;
    	if (comprador.getSaldo()-pieza.getPrecio() >= 0) {
    		return true;
    	}
    	return false;
        }
    

    public Usuario identificarPostorGanador(Pieza pieza) {
        Subasta subasta = subastasActivas.get(pieza);
        if (subasta != null) {
            return plataforma.subastar(pieza);
        }
        return null;
    }

    public void finalizarSubasta(Pieza pieza) {
        Subasta subasta = subastasActivas.remove(pieza);
        if (subasta != null) {
            subasta.finalizar(pieza);
            notificarParticipantes(pieza, subasta);
        }
    }

    private void notificarParticipantes(Pieza pieza, Subasta subasta) {
        ArrayList<Usuario> participantes = participantesPorSubasta.get(pieza);
        if (participantes != null) {
            for (Usuario participante : participantes) {
                System.out.println();
            }
        }
    }
    
   
}
