package br.edu.ies.fila.de.processos.ordenadores;

import java.util.List;

import br.edu.ies.fila.de.processos.Processo;

public class OrdenadorPrioridade implements Ordenador {

	public List<Processo> ordenar(List<Processo> listaProcessos) {
		List<Processo> listaProcessosPrioridade = listaProcessos;

		Processo troca = null;

		for (int x = 0; x < listaProcessosPrioridade.size(); x++) {

			for (int y = 0; y < listaProcessosPrioridade.size(); y++) {

				// Por Prioridade.
				if (listaProcessosPrioridade.get(x).getPrioridade() < listaProcessosPrioridade.get(y).getPrioridade()) {
					troca = listaProcessosPrioridade.get(x);
					listaProcessosPrioridade.set(x, listaProcessosPrioridade.get(y));
					listaProcessosPrioridade.set(y, troca);

					// Se a Prioridade for igual...
				} else if (listaProcessosPrioridade.get(x).getPrioridade() == listaProcessosPrioridade.get(y)
						.getPrioridade()) {

					// Por Ordem de Chegada.
					if (listaProcessosPrioridade.get(x).getChegada() < listaProcessosPrioridade.get(y).getChegada()) {
						troca = listaProcessosPrioridade.get(x);
						listaProcessosPrioridade.set(x, listaProcessosPrioridade.get(y));
						listaProcessosPrioridade.set(y, troca);

						// Se a Ordem de Chegada for igual...
					} else if (listaProcessosPrioridade.get(x).getTempoExecucao() == listaProcessosPrioridade.get(y)
							.getTempoExecucao()) {

						// Por Tamanho.
						if (listaProcessosPrioridade.get(x).getTamanho() < listaProcessosPrioridade.get(y)
								.getTamanho()) {
							troca = listaProcessosPrioridade.get(x);
							listaProcessosPrioridade.set(x, listaProcessosPrioridade.get(y));
							listaProcessosPrioridade.set(y, troca);

						}
					}
				}
			}
		}

		return listaProcessosPrioridade;
	}

}