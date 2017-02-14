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
import view.entityVenda;

/**
 *
 * @author gabriel
 */
public class venda{
    Connection conn;
    int mercadoriaId;
    int quantidadeVenda;
    entityMercadoria mercadoria;
    
    // 1.0 - buscar objeto mercadoria pelo seu id
    // 2.0 - realizar a venda (persistir dados na tabela venda)
    // 3.0 - atualizat 0 estoque de mercadoria
    
    public venda(int idMercadoria, int quantidade) {
        conn = new conexao().conectar();
        
        mercadoriaId = idMercadoria;
        quantidadeVenda = quantidade;
        
        //1.0
        //preenche objeto mercadoria
        this.mercadoria = new mercadoria(mercadoriaId).listaMercadoria(); 
    }
    
    public venda() {
        conn = new conexao().conectar();
    }
   
    
    public void efetuaVenda(){
        //efetuar venda
        //confirmar venda
        
        try{
            //2.0
            PreparedStatement ppStmt = conn.prepareStatement("INSERT INTO venda(quantidade, idMercadoria) VALUES (?,?)");
            
            ppStmt.setInt(1, quantidadeVenda);
            ppStmt.setInt(2, mercadoriaId);
            ppStmt.execute();
            
            System.out.println("Venda Realizada");
            
            //3.0
            PreparedStatement ppStmt2 = conn.prepareStatement("UPDATE mercadoria set mercadoria.quantidade = ? WHERE mercadoria.idMercadoria = ?");
                                                             //UPDATE mercadoria set mercadoria.quantidade = ? WHERE mercadoria.idMercadoria = ?
            int aux = mercadoria.getQuantidade();
            aux -= quantidadeVenda;
            ppStmt2.setInt(1, aux);
            ppStmt2.setInt(2, mercadoriaId);
            ppStmt2.execute();
            
            System.out.println("Estoque Atualizado");
            //update TABELA set ATRIBUTO = VALOR [{, ATRIBUTO = VALOR}])]
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //atualizar o estoque da mercadoria
    }
    
   
    //listar operações de vendas
    public List<entityVenda> listarVendas(){
        List<entityVenda> lstC = new LinkedList<>();
        try{
            PreparedStatement ppstmt = conn.prepareStatement("SELECT * FROM venda");
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
    
    public entityVenda obtemDados(ResultSet rs)throws SQLException{
        
        entityVenda c = new entityVenda();
        c.setIdVenda(rs.getInt("idVenda"));
        c.setIdMercadoria(rs.getInt("idMercadoria"));
        c.setQuantidade(rs.getInt("quantidade"));
        
        return c;
    }
}
