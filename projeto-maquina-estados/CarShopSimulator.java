// classe principal

import java.util.Scanner;

public class CarShopSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarState startState = new CarState("Início");
        CarState exploringState = new CarState("Explorando Carros");
        CarState detailsState = new CarState("Detalhes do Carro");
        CarState negotiatingState = new CarState("Negociando");
        CarState purchaseState = new CarState("Compra Efetuada");
        CarState closingState = new CarState("Encerramento");

        CarState currentState = startState;  // Estado inicial

        System.out.println("Bem-vindo à Loja de Carros!");

        while (currentState != closingState) {
            System.out.println("Estado atual: " + currentState.getStateName());

            if (currentState == startState) {
                System.out.println("Pressione qualquer tecla para começar a explorar carros...");
                scanner.nextLine();
                currentState = exploringState;
            } else if (currentState == exploringState) {
                System.out.println("Selecione um carro para ver detalhes (D) ou iniciar negociação (N):");
                String choice = scanner.nextLine().toUpperCase();
                if (choice.equals("D")) {
                    currentState = detailsState;
                } else if (choice.equals("N")) {
                    currentState = negotiatingState;
                }
            } else if (currentState == detailsState) {
                System.out.println("Pressione qualquer tecla para voltar à lista de carros...");
                scanner.nextLine();
                currentState = exploringState;
            } else if (currentState == negotiatingState) {
                System.out.println("Negociação em andamento...");
                // Lógica de negociação aqui

                System.out.println("Negociação concluída. Deseja comprar o carro (C) ou voltar (V)?");
                String choice = scanner.nextLine().toUpperCase();
                if (choice.equals("C")) {
                    currentState = purchaseState;
                } else if (choice.equals("V")) {
                    currentState = exploringState;
                } else {
                    System.out.println("Opção inválida. Voltando à lista de carros.");
                    currentState = exploringState;
                }
                
                System.out.println("Deseja continuar a negociação (C) ou voltar à lista de carros (V)?");
                choice = scanner.nextLine().toUpperCase();
                if (choice.equals("C")) {
                    // Aqui você pode adicionar mais lógica de negociação se desejar
                    // Por exemplo, oferecer um novo preço
                } else if (choice.equals("V")) {
                    currentState = exploringState;  // Voltar à exploração de carros
                } else {
                    System.out.println("Opção inválida. Voltando à lista de carros.");
                    currentState = exploringState;
                }
            } else if (currentState == purchaseState) {
                System.out.println("Parabéns pela sua compra!");
                currentState = closingState;
            }

            System.out.println();
        }

        System.out.println("Obrigado por usar o Simulador de Loja de Carros!");

        scanner.close();
    }
}



