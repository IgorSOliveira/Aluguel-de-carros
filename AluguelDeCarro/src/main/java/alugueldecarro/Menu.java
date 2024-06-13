package main.java.alugueldecarro;

import java.util.List;
import java.util.Scanner;

public class Menu {

	private static AluguelService aluguelservice;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("==== Alugue seu carro ====");
		System.out.println("1. Alugar um carro");
		System.out.println("2. Devolver um carro");
		System.out.println("3. Sair");
		System.out.print("Escolha uma opção: ");

		int opcao = scanner.nextInt();
		scanner.nextLine();

		switch (opcao) {
		case 1:
			alugarCarro(scanner);
			break;
		case 2:
			devolverCarro(scanner);
			break;
		case 3:
			System.out.println("Saindo do programa.");
			break;
		default:
			System.out.println("Opção inválida.");
		}
		scanner.close();

	}

	private static void alugarCarro(Scanner scanner){
		System.out.println("Alugar um carro");
		List<Carro> carros = aluguelservice.listarCarros();
		
		if (carros.isEmpty()){
			System.out.println("Não há carros disponíveis.");
			return;
		}
		
		System.out.println("\nCarros disponíveis: ");
		for(int i = 0; i < carros.size(); i++) {
			Carro carro = carros.get(i);
		}


	}
}
