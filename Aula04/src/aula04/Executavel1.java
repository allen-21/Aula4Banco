/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula04;

import java.util.ArrayList;

/**
 *
 * @author anibal
 */
public class Executavel1 {
    
     public static void main(String[] args) {
         
          ArrayList<ContaBancaria> contas = new ArrayList<>();
        
         ContaCorrente contacorrente = new ContaCorrente (200, 2000, 10);
         
         ContaPoupanca contapoupanca = new ContaPoupanca(2001, 1000, 20);
         
         contacorrente.depositar(500);
         contapoupanca.depositar(200);
         
         contacorrente.sacar(1000);
         contapoupanca.sacar(1202);
         
         contacorrente.mostrarDados();
         contapoupanca.mostrarDados();
         
         // criar objeto relatório
          Relatorio relatorio = new Relatorio();

           // gerar relatório para cada conta bancária
          for (ContaBancaria conta : contas) {
           relatorio.gerarRelatorio((Imprimivel) conta);
    }
         
    }
    
}
