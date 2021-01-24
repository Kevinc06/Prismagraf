/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Cliente {
   
    private int codCli,idade,codProdCom;
    private String nomeCli,email,telefone;

   

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCodProdCom() {
        return codProdCom;
    }

    public void setCodProdCom(int codProdCom) {
        this.codProdCom = codProdCom;
    }
    

    @Override
    public String toString() {
        return "\nCódigo do Cliente: "+this.codCli+
                 "\nNome do Cliente: "+ this.nomeCli+ 
                 "\nEmail: " + this.email+ 
                 "\nIdade: " + this.idade+ 
                "\nTelefone : " +this.telefone+
        "\nCódigo do Produto Comprado: " +this.codProdCom;
 
       
    }

}
