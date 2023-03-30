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
public abstract class ContaBancaria {
    
    public int numeroDaconta;
    private double saldo;
    private ArrayList <String> historico ;

    public ContaBancaria() {
    }

    
    
    public ContaBancaria(int numeroDaconta, double saldo) {
        this.numeroDaconta = numeroDaconta;
        this.saldo = saldo;
        this.historico = new ArrayList<String>();
    }

    public int getNumeroDaconta() {
        return numeroDaconta;
    }

    public void setNumeroDaconta(int numeroDaconta) {
        this.numeroDaconta = numeroDaconta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }
    
   public void transferir (double valor, ContaBancaria outraConta){
        if(saldo>= valor){
            this.sacar(valor);
            outraConta.depositar(valor);
            this.historico.add("Transferencia de MT" + valor + "para conta" + outraConta.numeroDaconta );
            
        }else{
            this.historico.add("Transferência de MT" + valor + " para conta " + outraConta.numeroDaconta + " falhou. Saldo insuficiente.");
        }
        
    }



    
   
    
    
    
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    
    
}
