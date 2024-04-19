package uniandes.dpoo.galeria.modelo.empleado;

import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Subasta;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

import java.util.ArrayList;

public class OperadorGaleria extends Empleado {

    private HashMap<Pieza, Subasta> subastasActivas;
    private HashMap<Pieza, ArrayList<Usuario>> participantesPorSubasta;
    private HashMap<Pieza, HashMap<Usuario, Double>> ofertasPorSubasta;

    public OperadorGaleria(String nombre, int identificacion, int edad) {
        super("Operador", nombre, identificacion, edad);
        subastasActivas = new HashMap<>();
        participantesPorSubasta = new HashMap<>();
        ofertasPorSubasta = new HashMap<>();
    }

    public void iniciarSubasta(Pieza pieza) {
        Subasta subasta = new Subasta(pieza);
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

    public void registrarOfertasSubasta(Usuario usuario, Pieza pieza, double oferta) {
        HashMap<Usuario, Double> ofertas = ofertasPorSubasta.getOrDefault(pieza, new HashMap<>());
        ofertas.put(usuario, oferta);
        ofertasPorSubasta.put(pieza, ofertas);
    }

    public void aceptarOfertasSubasta(Pieza pieza, Usuario usuario) {
      
        Subasta subasta = subastasActivas.get(pieza);
        if (subasta != null){

        
            HashMap<Usuario, Double> ofertas = ofertasPorSubasta.get(pieza);
            int precio = pieza.getPrecio();
            subasta.agregarOfertaSubasta(usuario,precio,pieza);
        }
    }

    public Usuario identificarPostorGanador(Pieza pieza) {
        Subasta subasta = subastasActivas.get(pieza);
        if (subasta != null) {
            return subasta.identificarGanador();
        }
        return null;
    }

    public void finalizarSubasta(Pieza pieza) {
        Subasta subasta = subastasActivas.remove(pieza);
        if (subasta != null) {
            subasta.finalizar();
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
