package br.edu.ies.fila.de.processos.run;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import br.edu.ies.fila.de.processos.Processo;
import br.edu.ies.fila.de.processos.Interface.InterfaceConsole;
import br.edu.ies.fila.de.processos.ordenadores.Ordenador;
import br.edu.ies.fila.de.processos.ordenadores.OrdenadorChegada;
import br.edu.ies.fila.de.processos.ordenadores.OrdenadorPrioridade;
import br.edu.ies.fila.de.processos.ordenadores.OrdenadorTamanho;

public class FilaDeProcessos {
	private static HashMap<String, Ordenador> modoExecucao = new HashMap<String, Ordenador>();
	private static List<Processo> listaDeTodosOsProcessos = new ArrayList<Processo>();
	private static List<Processo> filaProcessos = new ArrayList<Processo>();
	private static Integer instante = 0;
	private static InterfaceConsole console = new InterfaceConsole();
	private static Ordenador ordenador;

	public static void main(String[] args) throws InterruptedException {
		modoExecucao.put("prioridade", new OrdenadorPrioridade());
		modoExecucao.put("chegada", new OrdenadorChegada());
		modoExecucao.put("tamanho", new OrdenadorTamanho());

		popularProcessos();

		Scanner input = new Scanner(System.in);

		String mensagemModos = "=> prioridade\n" + "=> chegada\n" + "=> tamanho";

		System.out.println("Digite o Modo de Processamento do CPU:");
		System.out.println(mensagemModos);
		String modo = input.next();

		while (modoExecucao.get(modo) == null) {
			System.out.println("Modo de Execução selecionado inexistente.\nDigite outro modo:");
			System.out.println(mensagemModos);
			modo = input.next();
		}

		console.separatorSimple();

		inicializarCPU(modo);

		input.close();
	}

	private static void popularProcessos() {
		listaDeTodosOsProcessos.add(new Processo("A", 4, 2, 4, 1));
		listaDeTodosOsProcessos.add(new Processo("B", 2, 4, 2, 2));
		listaDeTodosOsProcessos.add(new Processo("C", 1, 1, 3, 3));
		listaDeTodosOsProcessos.add(new Processo("T", 1, 1, 2, 3));
		listaDeTodosOsProcessos.add(new Processo("D", 3, 2, 5, 4));
		listaDeTodosOsProcessos.add(new Processo("E", 1, 1, 5, 5));
		listaDeTodosOsProcessos.add(new Processo("F", 5, 4, 6, 6));
		listaDeTodosOsProcessos.add(new Processo("Z", 4, 4, 6, 6));
		listaDeTodosOsProcessos.add(new Processo("U", 3, 4, 6, 6));
		listaDeTodosOsProcessos.add(new Processo("G", 3, 2, 2, 7));
		listaDeTodosOsProcessos.add(new Processo("H", 1, 3, 1, 8));

		listaDeTodosOsProcessos.add(new Processo("V", 1, 1, 1, 1));
//		listaDeTodosOsProcessos.add(new Processo("V", 2, 2, 2, 2));
//
//		listaDeTodosOsProcessos.add(new Processo("V1", 3, 3, 3, 2));
//
//		for (int x = 0; x < listaDeTodosOsProcessos.size(); x++) {
//
//			for (int y = 0; y < listaDeTodosOsProcessos.size(); y++) {
//
//				if (listaDeTodosOsProcessos.get(x).getIdentificador().equals(listaDeTodosOsProcessos.get(y).getIdentificador())) {
//					listaDeTodosOsProcessos.get(x).setIdentificador(listaDeTodosOsProcessos.get(x).getIdentificador() + "1");
//				}
//			}
//		}
//		
//		for (Processo processo : listaDeTodosOsProcessos) {
//			for (Processo processo2 : listaDeTodosOsProcessos) {
//				if (processo.getIdentificador().equals(processo2.getIdentificador())) {
//					processo2.setIdentificador(processo2.getIdentificador() + "1");
//				}
//			}
//		}

	}

	private static void inicializarCPU(String modo) throws InterruptedException {
		Boolean stop = false;
		List<Processo> fila = null;

		ordenador = modoExecucao.get(modo);

		aumentarInstante();
		adicionarProcessosFilaExecucao();

		System.out.println("Instante 1");
		console.mostrarFilaExecucao(filaProcessos);

		while (!stop) {

			fila = filaProcessos;

			if (!filaProcessos.isEmpty()) {

				fila = ordenador.ordenar(fila);
				executarProcesso(fila.get(0));
				filaProcessos.remove(fila.get(0));

			} else {
				stop = Boolean.TRUE;
			}
		}
	}

	private static void aumentarInstante() {
		instante++;
		for (Processo processo : filaProcessos) {
			processo.setTempoExecucao(processo.getTempoExecucao() + 1);
		}
	}

	private static void executarProcesso(Processo processo) throws InterruptedException {
		while (processo.getTamanho() > 0) {
			System.out.println("Instante: " + instante);
			console.mostrarFilaExecucao(filaProcessos, processo);

			processo.setTamanho(processo.getTamanho() - 1);

			TimeUnit.SECONDS.sleep(1);

			aumentarInstante();
			adicionarProcessosFilaExecucao();
		}

		System.out.println("Instante: " + instante);
		console.mostrarFilaExecucao(filaProcessos, processo);
	}

	private static void adicionarProcessosFilaExecucao() {
		for (Processo processo : listaDeTodosOsProcessos) {
			if (processo.getChegada() == instante) {
				filaProcessos.add(processo);
			}
		}
	}

}