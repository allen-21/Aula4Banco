/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula04;

/**
 *
 * @author anibal
 */
public class ContaPoupanca extends ContaBancaria implements Imprimivel{
    
   //atribui um limite de saldo 
    
       private double limite;

    public ContaPoupanca() {
    }

    public ContaPoupanca(int numeroConta, double saldo, double limite) {
        super(numeroConta, saldo);
        this.limite = limite;
    }
// metodo para sacar
    public void sacar(double valor) {
        if (this.getSaldo() + limite - valor < 0) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else {
            this.setSaldo(this.getSaldo() - valor);
            this.getHistorico().add("Saque de Mt" + valor + " realizado.");
        }
        return;
    }
//metodo para depositar
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        this.getHistorico().add("Depósito de MT" + valor + " realizado.");
        return;
    }
    
    // implemetacao do metodo mostrar dados da interface imprimivel
    public void mostrarDados(){
        System.out.println("Conta Poupanca; " + this.getNumeroDaconta());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("O limite" + this.limite);
    }
 
    
}
