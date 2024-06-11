package main.java.alugueldecarro;

public class Aluguel {
	private Carro carro;
	private Cliente cliente;
	private int dias;
	
	//Construtor
	public Aluguel(Carro carro, Cliente cliente, int dias) {
		this.carro = carro;
		this.cliente = cliente;
		this.dias = dias;
	}

	//Metodos
	public Carro getCarro() {
		return carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getDias() {
		return dias;
	}
	
	
}
