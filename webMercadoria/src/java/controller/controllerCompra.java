/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.compra;
import view.entityCompra;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class controllerCompra {
    private compra compraDAO;
    int idMercadoria;
    int quantidade;

    public controllerCompra(int idMercadoria, int quantidade) {
        this.idMercadoria = idMercadoria;
        this.quantidade = quantidade;
        
        compraDAO = new compra(idMercadoria, quantidade);
    }

    public controllerCompra() {
        compraDAO = new compra();
    }
    
    public void efetuaCompras(){
        compraDAO.efetuaCompra();
    }
    
    public List<entityCompra> listarCompras(){
        return compraDAO.listarCompras();
    }
}
