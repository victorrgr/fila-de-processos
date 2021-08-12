package br.edu.ies.fila.de.processos.ordenadores;

import java.util.List;

import br.edu.ies.fila.de.processos.Processo;

public class OrdenadorTamanho implements Ordenador {

	public List<Processo> ordenar(List<Processo> listaProcessos) {
		List<Processo> listaProcessosTamanho = listaProcessos;

		Processo troca = null;

		for (int x = 0; x < listaProcessosTamanho.size(); x++) {

			for (int y = 0; y < listaProcessosTamanho.size(); y++) {

				// Por Ordem de Chegada.
				if (listaProcessosTamanho.get(x).getChegada() < listaProcessosTamanho.get(y).getChegada()) {
					troca = listaProcessosTamanho.get(x);
					listaProcessosTamanho.set(x, listaProcessosTamanho.get(y));
					listaProcessosTamanho.set(y, troca);

				// Se a Ordem de Chegada for igual...
				} else if (listaProcessosTamanho.get(x).getTempoExecucao() == listaProcessosTamanho.get(y).getTempoExecucao()) {
					
					// Por Tamanho.
					if (listaProcessosTamanho.get(x).getTamanho() < listaProcessosTamanho.get(y).getTamanho()) {
						troca = listaProcessosTamanho.get(x);
						listaProcessosTamanho.set(x, listaProcessosTamanho.get(y));
						listaProcessosTamanho.set(y, troca);
					}
				}
			}
		}

		return listaProcessosTamanho;
	}

}
