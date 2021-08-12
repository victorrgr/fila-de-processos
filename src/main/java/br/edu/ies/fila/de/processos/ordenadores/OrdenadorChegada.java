package br.edu.ies.fila.de.processos.ordenadores;

import java.util.List;

import br.edu.ies.fila.de.processos.Processo;

public class OrdenadorChegada implements Ordenador {

	public List<Processo> ordenar(List<Processo> listaProcessos) {
		List<Processo> listaProcessosChegada = listaProcessos;

		Processo troca = null;

		for (int x = 0; x < listaProcessosChegada.size(); x++) {

			for (int y = 0; y < listaProcessosChegada.size(); y++) {

				// Somente Por Ordem de Chegada.
				if (listaProcessosChegada.get(x).getChegada() < listaProcessosChegada.get(y).getChegada()) {
					troca = listaProcessosChegada.get(x);
					listaProcessosChegada.set(x, listaProcessosChegada.get(y));
					listaProcessosChegada.set(y, troca);
				}
			}
		}

		return listaProcessosChegada;
	}

}
