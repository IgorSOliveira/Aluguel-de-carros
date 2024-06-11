package main.java.alugueldecarro;

public class Cliente {
	
	private String nome;
	private int cpf;
	
	//Construtor
	public Cliente(String nome, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getCpf() {
		return cpf;
	}
	
}
