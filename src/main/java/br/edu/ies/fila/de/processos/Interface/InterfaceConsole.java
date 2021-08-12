package br.edu.ies.fila.de.processos.Interface;

import java.util.List;

import br.edu.ies.fila.de.processos.Processo;

public class InterfaceConsole {

	public void mostrarFilaExecucao(List<Processo> listaProcessos) {
		System.out.println("Processos a Serem executados:");
		separatorSimple();
		System.out.println("  IDE " + " |  " + "PRI" + "  |  " + "TMP" + "  |  " + "CHE" + "  |  " + "TAM" + "  |");
		separatorColuna();

		for (Processo x : listaProcessos) {
			System.out.println("   " + x.getIdentificador() + "   |   " + x.getPrioridade() + "   |   "
					+ x.getTempoExecucao() + "   |   " + x.getChegada() + "   |   " + x.getTamanho() + "   |");
		}

		separatorSimple();
	}

	public void mostrarFilaExecucao(List<Processo> listaProcessos, Processo processoExecutando) {
		System.out.println("Processos a Serem executados:");
		separatorSimple();
		System.out.println("  IDE " + " |  " + "PRI" + "  |  " + "TMP" + "  |  " + "CHE" + "  |  " + "TAM" + "  |");
		separatorColuna();

		String estado = null;

		for (Processo x : listaProcessos) {
			if (x.equals(processoExecutando) && processoExecutando.getTamanho() == 0) {
				estado = "TERMINADO";
			} else if (x.equals(processoExecutando)) {
				estado = "EXECUTANDO";
			} else {
				estado = "ESPERANDO";
			}
			System.out.println(
					"   " + x.getIdentificador() + "   |   " + x.getPrioridade() + "   |   " + x.getTempoExecucao()
							+ "   |   " + x.getChegada() + "   |   " + x.getTamanho() + "   | " + estado);
		}

		separatorSimple();
	}

	public void separatorColuna() {
		System.out.println("-------+-------+-------+-------+-------+");
	}

	public void separatorSimple() {
		System.out.println("----------------------------------------");
	}

}