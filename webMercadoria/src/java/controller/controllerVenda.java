/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.venda;
import view.entityVenda;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class controllerVenda {
    private venda vendaDAO;
    int idMercadoria;
    int quantidade;

    public controllerVenda(int idMercadoria, int quantidade) {
        this.idMercadoria = idMercadoria;
        this.quantidade = quantidade;
        
        vendaDAO = new venda(idMercadoria, quantidade);
    }
    
    public controllerVenda() {
        vendaDAO = new venda();
    }
    
    public void efetuaVenda(){
        vendaDAO.efetuaVenda();
    }
    
    public List<entityVenda> listarVenda(){
        return vendaDAO.listarVendas();
    }
    
    
}
