/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import controller.controllerCompra;
import controller.controllerMercadoria;
import controller.controllerVenda;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import view.entityCompra;
import view.entityMercadoria;
import view.entityVenda;

/**
 * REST Web Service
 *
 * @author gabriel
 */
@Path("mercadoria")
public class MercadoriaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MercadoriaResource
     */
    public MercadoriaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.MercadoriaResource
     * @return an instance of java.lang.String
     * Operações de busca da classe mercadoria
     */
    
    /*@GET
    @Path("buscaMercadoriaId")
    @Produces(MediaType.APPLICATION_JSON)
    public entityMercadoria buscaMercadoriaId(@FormParam("idMercadoria")int idMercadoria){
        return new controllerMercadoria(idMercadoria).listaMercadoria();
    }*/
    
    @GET
    @Path("buscaMercadoriaVenda")
    @Produces(MediaType.APPLICATION_JSON)
    public List<entityMercadoria> buscaPorTipoVenda(){
        return new controllerMercadoria().listaPorTipoVenda();
    }
    
    @GET
    @Path("buscaMercadoriaCompra")
    @Produces(MediaType.APPLICATION_JSON)
    public List<entityMercadoria> buscaPorTipoCompra(){
        return new controllerMercadoria().listaPorTipoCompra();
    }
    
    /**
     * Operação de busca da classe vendas
     * 
     * 
     * */
    
    @GET
    @Path("listarVendas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<entityVenda> listarVendas(){
        return new controllerVenda().listarVenda();
    }
    
    @GET
    @Path("listarCompras")
    @Produces(MediaType.APPLICATION_JSON)
    public List<entityCompra> listarCompras(){
        return new controllerCompra().listarCompras();
    }
    
    /**
     * PUT method for updating or creating an instance of MercadoriaResource
     * @param content representation for the resource
     * operações da classe venda
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    @POST
    @Path("/efetuaVenda")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void efetuaVenda(@FormParam("idMercadoria")int idMercadoria,@FormParam("quantidade")int quantidade) {
        System.out.println("idMercadoria: "+idMercadoria+" quantidade: "+quantidade);
        new controllerVenda(idMercadoria, quantidade).efetuaVenda();
    }
    
    @POST
    @Path("/efetuaCompra")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void efetuaCompra(@FormParam("idMercadoria")int idMercadoria,@FormParam("quantidade")int quantidade) {
        System.out.println("idMercadoria: "+idMercadoria+" quantidade: "+quantidade);
        new controllerCompra(idMercadoria, quantidade).efetuaCompras();
    }
    
}
