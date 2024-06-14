package main.java.alugueldecarro;

public class Carro {
	
	private String placa;
	private String modelo;
	private double precoPorDia;
	private boolean disponivel;
	
	//Construtor
	public Carro(String placa, String modelo, double precoPorDia) {
	    this.placa = placa;
	    this.modelo = modelo;
	    this.precoPorDia = precoPorDia;
	    this.disponivel = true;
	}

	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}
	

	public double getPrecoPorDia() {
		return precoPorDia;
	}

	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void devolverCarro() {
		disponivel = true;
	}
	
	public void alugar() {
		disponivel = false;
	}
	
	public double precoAluguel(int dias) {
		return precoPorDia * dias;
	}
}
