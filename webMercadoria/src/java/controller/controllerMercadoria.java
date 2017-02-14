/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.LinkedList;
import java.util.List;
import model.mercadoria;
import view.entityMercadoria;

/**
 *
 * @author gabriel
 */
public class controllerMercadoria {
    private mercadoria mercadoriaDAO;
    int idMercadoria;
    
    //injeção de valores na classe Model
    public controllerMercadoria(int mercadoriaId) {
        idMercadoria = mercadoriaId;
        mercadoriaDAO = new mercadoria(idMercadoria);
    }

    public controllerMercadoria() {
        mercadoriaDAO = new mercadoria();
    }
    
    public entityMercadoria listaMercadoria(){
        return mercadoriaDAO.listaMercadoria();
    }
    
    public List<entityMercadoria> listaPorTipoVenda(){
        return  mercadoriaDAO.listaPorTipoVenda();
    }
    
    public List<entityMercadoria> listaPorTipoCompra(){
        return mercadoriaDAO.listaPorTipoCompra();
    }
    
}
