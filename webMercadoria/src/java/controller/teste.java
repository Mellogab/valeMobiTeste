/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.mercadoria;
import view.entityMercadoria;

/**
 *
 * @author gabriel
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List <entityMercadoria> mercCompra = new mercadoria().listaPorTipoCompra();
        List <entityMercadoria> mercVenda = new mercadoria().listaPorTipoVenda();

        //LISTA POR TIPO VENDA: OK
        for(entityMercadoria v : mercVenda){
            System.out.println("Nome: "+v.getNome());
        }

        //LISTA POR TIPO COMPRA: OK
        for(entityMercadoria c : mercCompra){
            System.out.println("Nome: "+c.getNome());
        }
    }
    
}
