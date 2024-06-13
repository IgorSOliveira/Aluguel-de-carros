package main.java.alugueldecarro;

import java.util.ArrayList;
import java.util.List;

public class AluguelService {
	
	private List<Carro> carros;
	private List<Cliente> clientes;
	private List<Aluguel> alugueis;

	//Constructor
	public AluguelService(List<Carro> carros, List<Cliente> clientes, List<Aluguel> alugueis) {
		this.carros = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.alugueis = new ArrayList<>();
	}
	
	public void addCarro(Carro carro) {
		carros.add(carro);
	}
	
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public List<Carro> listarCarros() {
	        return carros;
	} 
	
	//Metodo para alugar um carro
	public void alugarCarro(Carro carro, Cliente cliente, int dias) {
		if(carro.isDisponivel()) {
			carro.alugar();
			alugueis.add(new Aluguel(carro, cliente, dias));
		
		} else {
			System.out.println("Esse carro nao esta disponivel para ser alugado.");
		}
	}
	
	//Metodo para devolver um carro
	public void devolverCarro(Carro carro) {
		
		carro.devolverCarro();
		Aluguel removerAlugado = null;
		for(Aluguel aluguel : alugueis) {
			if(aluguel.getCarro() == carro) {
				removerAlugado = aluguel;
				break;
			}
		}
		
		if (removerAlugado != null) {
			alugueis.remove(removerAlugado);
			System.out.println("Carro devolvido!");
		
		} else {
			System.out.println("Carro nao esta alugado!");
		}
	}
}

