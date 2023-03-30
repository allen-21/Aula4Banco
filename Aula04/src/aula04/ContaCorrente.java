/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula04;

/**
 *
 * @author anibal
 */
public class ContaCorrente extends ContaBancaria{
    private double taxaOperacao;

    public ContaCorrente() {
    }

    
    
    public ContaCorrente(int numeroDaconta, double saldo,double taxaOperacao) {
        super(numeroDaconta, saldo);
        this.taxaOperacao = taxaOperacao;
    }

   

  
    // implemetacao do metodo mostrar dados da interface imprimivel
    public void mostrarDados(){
        System.out.println("Conta Corrente; " + this.getNumeroDaconta());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("taxa da Opecao" + this.taxaOperacao);
    }

    @Override
    public void sacar(double valor) {
         double valorTotal = valor;
        if (this.getSaldo() - valorTotal < 0) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else {
            this.setSaldo(getSaldo() - valor - this.taxaOperacao);
            this.getHistorico().add("Saque de MT" + valor + " realizado com taxa de MT" + taxaOperacao + ".");
        }
        return;
    }

    @Override
    public void depositar(double valor) {
         this.setSaldo(this.getSaldo() + valor - this.taxaOperacao);
        this.getHistorico().add("Depósito de MT" + valor + " realizado com taxa de MT" + taxaOperacao + ".");
        return;
    }
    

    
}
