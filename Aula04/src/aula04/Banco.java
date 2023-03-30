/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula04;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anibal
 */
public class Banco implements Imprimivel {
    
       private ArrayList<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<ContaBancaria>();
    }

    public void inserir(ContaBancaria conta) {
        contas.add(conta);
    }

    public void remover(ContaBancaria conta) {
        contas.remove(conta);
    }

    public ContaBancaria procurarConta(int numeroDaConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroDaconta() == numeroDaConta) {
                return conta;
            }
        }
        return null;
    }
    
    public void relatorioContas() {
    System.out.println("Relatório de contas:");

    for (ContaBancaria conta : contas) {
        System.out.println("Número da conta: " + conta.getNumeroDaconta());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Tipo de conta: " + (conta instanceof ContaCorrente ? "Conta corrente" : "Conta poupança"));
        System.out.println("------------------------------------");
    }
}

    @Override
    public void mostrarDados() {
         for (ContaBancaria conta : contas) {
            conta.getNumeroDaconta();
            conta.getSaldo();
            conta.getNumeroDaconta();
             System.out.println("<<<<<<<>>>>>>>>>>>");
            
        }
    }
    

    

}
