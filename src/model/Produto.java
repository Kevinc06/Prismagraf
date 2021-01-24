/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Produto {
    
    private int codProd,quantidade;
    private String nomeProd,valorDeVenda;

   

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(String valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

   
    @Override
    public String toString() {
        return "Produto: " + this.codProd
                + "\nQuantidade: " + this.quantidade
                + "\nNome do produto : "+this.nomeProd
                +"\nValor de Venda"+this.valorDeVenda;
                
    }
    
    
    
}
