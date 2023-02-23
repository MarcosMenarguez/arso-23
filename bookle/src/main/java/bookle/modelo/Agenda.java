package bookle.modelo;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateAdapter;

public class Agenda {

	private LocalDate fecha;
	private LinkedList<Turno> turno = new LinkedList<>();
	
	@XmlJavaTypeAdapter(value=LocalDateAdapter.class)
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LinkedList<Turno> getTurno() {
		return turno;
	}
	public void setTurno(LinkedList<Turno> turno) {
		this.turno = turno;
	}
	
	@Override
	public String toString() {
		return "Agenda [fecha=" + fecha + ", turnos=" + turno + "]";
	}
	
}
