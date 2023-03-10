package ar.edu.unlp.objetos.uno.Ejerciocio17_FacturaciondeLlamadas;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sistema {
	private ArrayList<String> numeros;
	private ArrayList<Persona> personas;
	
	public Sistema() {
		numeros = new ArrayList<>();
		personas= new ArrayList<>();
	}
	
	public void AgregarNumeroDisponible(String unNumero){
		this.numeros.add(unNumero);
	}
	
	public PersonaFisica darDeAltaPersonaFisica(String unNombre, String unaDireccion,String  unNumTelefono,int dni) {
		PersonaFisica personaFisica = new PersonaFisica(unNombre, unaDireccion, unNumTelefono,dni);
		this.personas.add(personaFisica);
		return personaFisica;
	}
	
	public PersonaJuridica darDeAltaPersonaJurica(String unNombre, String unaDireccion,String  unNumTelefono, int unCuit, String unTipo) {
		PersonaJuridica personaJuridica = new PersonaJuridica(unNombre,unaDireccion, unNumTelefono,unCuit, unTipo);
		this.personas.add(personaJuridica);
		return personaJuridica;
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDateTime comienzo, LocalDateTime duracion, String  emisor, String  receptor) {
		Persona persona =  this.buscarEmisor(emisor);
		persona.registrarLlamadaLocal(comienzo, receptor, emisor, receptor);
		return LlamadaLocal;

	}

	protected Persona buscarEmisor(String numero) {
		return this.personas.stream().filter(p -> p.getNroTelefono().equals(numero)).findFirst().orElse(null);
		}
}
}
