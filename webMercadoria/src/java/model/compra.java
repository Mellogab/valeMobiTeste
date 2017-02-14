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
import view.entityCompra;
import view.entityMercadoria;

/**
 *
 * @author gabriel
 */
public class compra {
    Connection conn;
    int mercadoriaId;
    int quantidadeCompra;
    entityMercadoria mercadoria;
    
    public compra(int idMercadoria, int quantidade) {
        conn = new conexao().conectar();
        
        mercadoriaId = idMercadoria;
        quantidadeCompra = quantidade;
        
        //1.0
        //preenche objeto mercadoria
        this.mercadoria = new mercadoria(mercadoriaId).listaMercadoria(); 
    }

    public compra(){
        conn = new conexao().conectar();
    }
    
    public void efetuaCompra(){
        //efetuar venda
        //confirmar venda
        
        try{
            //2.0
            PreparedStatement ppStmt = conn.prepareStatement("INSERT INTO compra(quantidade, idMercadoria) VALUES (?,?)");
            
            ppStmt.setInt(1, quantidadeCompra);
            ppStmt.setInt(2, mercadoriaId);
            ppStmt.execute();
            
            System.out.println("Compra Realizada");
            
            //3.0
            PreparedStatement ppStmt2 = conn.prepareStatement("UPDATE mercadoria set mercadoria.quantidade = ? WHERE mercadoria.idMercadoria = ?");
            int aux = mercadoria.getQuantidade();
            aux += quantidadeCompra;
            ppStmt2.setInt(1, aux);
            ppStmt2.setInt(2, mercadoriaId );
            ppStmt2.execute();
            
            System.out.println("Estoque Atualizado");
            //update TABELA set ATRIBUTO = VALOR [{, ATRIBUTO = VALOR}])]
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //atualizar o estoque da mercadoria
    }
    
    //listar operações de vendas
    public List<entityCompra> listarCompras(){
        List<entityCompra> lstC = new LinkedList<>();
        try{
            PreparedStatement ppstmt = conn.prepareStatement("SELECT * FROM compra");
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
    
    public entityCompra obtemDados(ResultSet rs)throws SQLException{
        
        entityCompra c = new entityCompra();
        c.setIdCompra(rs.getInt("idCompra"));
        c.setIdMercadoria(rs.getInt("idMercadoria"));
        c.setQuantidade(rs.getInt("quantidade"));
        
        return c;
    }
}
