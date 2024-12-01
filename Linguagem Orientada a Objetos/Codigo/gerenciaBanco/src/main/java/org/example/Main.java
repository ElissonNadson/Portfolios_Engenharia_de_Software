package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.println("Bem-vindo ao Sistema Bancário!");

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        conta.setNome(nome);
        conta.setSobrenome(sobrenome);
        conta.setCpf(cpf);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nSaldo atual: R$ " + conta.getSaldo());
                    break;
                case 2:
                    System.out.print("\nDigite o valor a ser depositado: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 3:
                    System.out.print("\nDigite o valor a ser sacado: R$ ");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para saque.");
                    }
                    break;
                case 4:
                    System.out.println("\nObrigado por utilizar nosso sistema. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Encerrar o sistema");
        System.out.print("Opção: ");
    }
}
