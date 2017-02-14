/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


/**
 *
 * @author gabriel
 */
public class entityVenda {
    private int idVenda;
    private int quantidade;
    private int idMercadoria;
    
    //configurar relação @ManyToOne = PK

    public int getIdMercadoria() {
        return idMercadoria;
    }

    public void setIdMercadoria(int idMercadoria) {
        this.idMercadoria = idMercadoria;
    }
    

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    

   
}
