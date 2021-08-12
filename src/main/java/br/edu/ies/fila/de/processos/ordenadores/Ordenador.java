package br.edu.ies.fila.de.processos.ordenadores;

import java.util.List;

import br.edu.ies.fila.de.processos.Processo;

public interface Ordenador {

	public List<Processo> ordenar(List<Processo> listaProcessos);
	
}
