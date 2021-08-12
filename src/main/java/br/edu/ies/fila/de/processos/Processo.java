package br.edu.ies.fila.de.processos;

public class Processo {
	private String identificador;
	private Integer prioridade;
	private Integer chegada;
	private Integer tempoExecucao;
	private Integer tamanho;
	
	public Processo(String identificador, Integer prioridade, Integer tempoExecucao, Integer tamanho, Integer chegada) {
		this.setIdentificador(identificador);
		this.setPrioridade(prioridade);
		this.setTempoExecucao(tempoExecucao);
		this.setTamanho(tamanho);
		this.setChegada(chegada);
	}
	
	//Getters & Setters
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public Integer getTempoExecucao() {
		return tempoExecucao;
	}

	public void setTempoExecucao(Integer tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Integer getChegada() {
		return chegada;
	}

	public void setChegada(Integer chegada) {
		this.chegada = chegada;
	}

}