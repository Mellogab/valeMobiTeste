/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import utilitarios.conexao;
import view.entityMercadoria;

/**
 *
 * @author gabriel
 */
public class mercadoria{
    Connection conn;
    entityMercadoria mercadoria;
    int idMercadoria;
    
    public mercadoria(int mercadoriaId) {
        conn = new conexao().conectar();
        idMercadoria = mercadoriaId;
    }
    
    public mercadoria() {
        conn = new conexao().conectar();
    }
    
    
    //lista por id -> utilizada na classe venda e compra
    public entityMercadoria listaMercadoria(){
        
        try{
            PreparedStatement ppstmt = conn.prepareStatement("SELECT * FROM mercadoria WHERE mercadoria.idMercadoria = ?");
            ppstmt.setInt(1, idMercadoria );
            ResultSet rs;
            rs = ppstmt.executeQuery();
            while(rs.next()){
                //lstC.add(obtemDados(rs));
                mercadoria = obtemDados(rs);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return mercadoria;
    }
    
    //lista por tipo de operação -> COMPRA OU VENDA
    public List<entityMercadoria> listaPorTipoVenda(){
        List<entityMercadoria> lstC = new LinkedList<>();
        try{
            PreparedStatement ppstmt = conn.prepareStatement("SELECT * FROM mercadoria WHERE mercadoria.tipoNegociacao = ?");
           
            ppstmt.setString(1, "venda");                   //SELECT * FROM mercadoria WHERE mercadoria.tipoNegociacao = 'compra';            
            ResultSet rs;
            rs = ppstmt.executeQuery();
            while(rs.next()){
                lstC.add(obtemDados(rs));
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        
        return lstC;
    }
    
    //lista por tipo de operação -> COMPRA OU VENDA
    public List<entityMercadoria> listaPorTipoCompra(){
        List<entityMercadoria> lstC = new LinkedList<>();
        try{
            PreparedStatement ppstmt = conn.prepareStatement("SELECT * FROM mercadoria WHERE mercadoria.tipoNegociacao = 'compra'");
                                                            //SELECT * FROM mercadoria WHERE mercadoria.tipoNegociacao = 'compra';
            ResultSet rs;
            rs = ppstmt.executeQuery();
            while(rs.next()){
                lstC.add(obtemDados(rs));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lstC;
        
    }
    
    public entityMercadoria obtemDados(ResultSet rs)throws SQLException{
        
        entityMercadoria c = new entityMercadoria();
        c.setIdMercadoria(rs.getInt("idMercadoria"));
        c.setNome(rs.getString("nome"));
        c.setPreco(rs.getFloat("preco"));
        c.setQuantidade(rs.getInt("quantidade"));
        c.setTipoMercadoria(rs.getString("tipoMercadoria"));
        c.setTipoProduto(rs.getString("tipoNegociacao"));
        
        return c;
    }
    
    /*
    INSERT INTO mercadoria(idMercadoria,nome, preco, quantidade, tipoMercadoria, tipoProduto) 
    VALUES (NULL, 'Arroz','5.00','100','Alimentos','Venda');
    */
    
}
