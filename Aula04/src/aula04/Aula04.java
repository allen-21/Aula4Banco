/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula04;

import java.util.Scanner;

/**
 *
 * @author anibal
 */
public class Aula04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
             Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco!");

        while (true) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("1. Criar conta");
            System.out.println("2. Selecionar conta");
            System.out.println("3. Remover conta");
            System.out.println("4. Gerar relatório");
            System.out.println("5. Finalizar");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Tipo de conta (1 - Corrente, 2 - Poupança): ");
                    int tipoConta = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Número da conta: ");
                    int numeroConta = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Saldo inicial: ");
                    double saldoInicial = sc.nextDouble();
                    sc.nextLine();

                    if (tipoConta == 1) {
                        System.out.print("Taxa de operação: ");
                        double taxaOperacao = sc.nextDouble();
                        sc.nextLine();

                        ContaCorrente cc = new ContaCorrente(numeroConta, saldoInicial, taxaOperacao);
                        banco.inserir(cc);
                    } else if (tipoConta == 2) {
                        System.out.print("Limite: ");
                        double limite = sc.nextDouble();
                        sc.nextLine();

                        ContaPoupanca cp = new ContaPoupanca(numeroConta, saldoInicial, limite);
                        banco.inserir(cp);
                    } else {
                        System.out.println("Tipo de conta inválido.");
                    }
                    break;
                case 2: // Selecionar conta
                    System.out.println("Informe o número da conta: ");
                    int numeroDaConta = sc.nextInt();
                    ContaBancaria contaSelecionada = banco.procurarConta(numeroDaConta);
                    if (contaSelecionada != null) {
                        System.out.println("Conta selecionada: " + contaSelecionada.getNumeroDaconta());
                        int opcaoSubMenu = 0;
                        do {
                            System.out.println("\n===== Menu da conta " + contaSelecionada.getNumeroDaconta() + " =====");
                            System.out.println("1 - Realizar Depósito");
                            System.out.println("2 - Realizar Saque");
                            System.out.println("3 - Realizar Transferência");
                            System.out.println("4 - Gerar relatório");
                            System.out.println("5 - Retornar ao menu anterior\" ");
                            opcaoSubMenu = sc.nextInt();
                            switch (opcaoSubMenu) {
                                case 1:
                                    System.out.println("Informe o valor do deposito: ");
                                    double valorDeposito = sc.nextDouble();
                                    contaSelecionada.depositar(valorDeposito);
                                    System.out.println("Deposito realisado com sucesso!");
                                    break;
                                case 2:
                                    System.out.println("Digite o valor a ser sacado:");
                                    double valorSaque = sc.nextDouble();
                                    contaSelecionada.sacar(valorSaque);

                                    break;
                                case 3:
                                     System.out.print("Informe o número da conta de destino: ");
                                    int numeroDestino = sc.nextInt();
                                    ContaBancaria outraConta = banco.procurarConta(numeroDestino);

                                    if (outraConta == null) {
                                        System.out.println("Conta de destino inexistente.");
                                    } else {
                                        System.out.print("Informe o valor a ser transferido: ");
                                        double valor = sc.nextDouble();
                                        contaSelecionada.transferir(valor, outraConta);
                                    }
                                    break;
                                case 4:
                                  banco.mostrarDados();
                                case 5:
                                    System.out.println("Voltando ao menu principal...");
                                    break;

                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                                    break;
                            }
                        } while (opcaoSubMenu != 5);
                    } else {
                        System.out.println("Conta inexistente.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- REMOVER CONTA ---");
                    System.out.print("Digite o número da conta: ");
                    int numContaRemover = sc.nextInt();
                    ContaBancaria contaRemover = banco.procurarConta(numContaRemover);
                    if (contaRemover != null) {
                        banco.remover(contaRemover);
                        System.out.println("Conta removida com sucesso.");
                    } else {
                        System.out.println("Conta inexistente.");
                    }
                    break;
                case 4:
                   
                    banco.relatorioContas();
                    break;

                default:

                case 5:
                    System.out.println("Encerrando a aplicação...");
                    sc.close();
                    System.exit(0);
                    break;

            }
        }
    }
    
    
}
