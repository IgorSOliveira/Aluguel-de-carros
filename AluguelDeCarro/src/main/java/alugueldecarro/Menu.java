package main.java.alugueldecarro;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static AluguelService aluguelservice = new AluguelService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        aluguelservice.addCarro(new Carro("123", "Modelo A", 100.0));
        aluguelservice.addCarro(new Carro("456", "Modelo B", 150.0));

        while (true) {
            System.out.println("==== Alugue seu carro ====");
            System.out.println("1. Alugar um carro");
            System.out.println("2. Devolver um carro");
            System.out.println("3. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha pendente

            switch (opcao) {
                case 1:
                    alugarCarro(scanner);
                    break;
                case 2:
                    devolverCarros(scanner);
                    break;
                case 3:
                    System.out.println("\nSaindo do programa.");
                    scanner.close();
                    return; // Finaliza o método main e, consequentemente, o programa
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

	private static void alugarCarro(Scanner scanner) {
		System.out.println("\n===Alugar um carro===");
		List<Carro> carros = aluguelservice.listarCarros();

		if (carros.isEmpty()) {
			System.out.println("Não há carros disponíveis.");
			return;
		}

		System.out.println("\nCarros disponíveis: ");
		for (int i = 0; i < carros.size(); i++) {
			Carro carro = carros.get(i);
			System.out.print((i + 1) + ". " + carro.getModelo() + " - " + carro.getPlaca() + " - R$"
					+ carro.getPrecoPorDia() + " por dia\n");
		}

		System.out.print("\nInforme o número do carro que deseja (1, 2, ...): ");
		int numCarro = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha pendente

		if (numCarro < 1 || numCarro > carros.size()) {
			System.out.println("\nOpção inválida.");
			return;
		}

		Carro carroDesejado = carros.get(numCarro - 1);

		System.out.println("Insira seu nome: ");
		String nomeCliente = scanner.nextLine();
		System.out.println("Insira seu CPF: ");
		int cpfCliente = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha pendente
		System.out.println("Quantos dias deseja alugar: ");
		int diasDesejados = scanner.nextInt();
		scanner.nextLine(); // Consumir a nova linha pendente

		Cliente cliente = new Cliente(nomeCliente, cpfCliente);
		aluguelservice.alugarCarro(carroDesejado, cliente, diasDesejados);
	}

	private static void devolverCarros(Scanner scanner) {
		System.out.println("==== Devolver um carro ====");
		System.out.print("Informe a placa do carro que deseja devolver: ");
		String placaCarro = scanner.nextLine();

		Carro carroParaDevolver = null;
		for (Carro carro : aluguelservice.listarCarros()) {
			if (carro.getPlaca().equals(placaCarro)) {
				carroParaDevolver = carro;
				break;
			}
		}

		if (carroParaDevolver == null) {
			System.out.println("Carro não encontrado.");
			return;
		}

		aluguelservice.devolverCarro(carroParaDevolver);
	}
}
