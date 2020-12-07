/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.bll;

import br.com.mulacar.dal.MarcaDal;
import br.com.mulacar.model.Marca;
import java.util.List;

/**
 *
 * @author deockar
 */
public class MarcaBll {
    
    private static final long serialVersionUID = 1L;
    private MarcaDal dal;
    
    public MarcaBll(){
        super();
        dal = new MarcaDal();
    }
    
    public void Adicionar (Marca marca) throws Exception{
        dal.addMarca(marca);
    }
    public void Alterar (Marca marca) throws Exception {
        dal.updateMarca(marca);
    }
    public void Remover (Marca marca) throws Exception {
        dal.deleteMarca(marca.getMarca_iden());
    }
    public List<Marca> getConsulta(){
        return dal.getAllMarca();
    }
    public Marca getModeloById(int marcaId) {
        return dal.getMarcaById(marcaId);
    }
}
