/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.bll;

import br.com.mulacar.dal.ModeloDal;
import br.com.mulacar.model.Modelo;
import java.util.List;

/**
 *
 * @author deockar
 */
public class ModeloBll {
    
    private static final long serialVersionUID = 1L;
    private ModeloDal dal;
    
    public ModeloBll(){
        super();
        dal = new ModeloDal();
    }
    
    public void Adicionar (Modelo modelo) throws Exception{
        dal.addModelo(modelo);
    }
    public void Alterar (Modelo modelo) throws Exception {
        dal.updateModelo(modelo);
    }
    public void Remover (Modelo modelo) throws Exception {
        dal.deleteModelo(modelo.getModelo_iden());
    }
    public List<Modelo> getConsulta(){
        return dal.getAllModelo();
    }
    public Modelo getModeloById(int modeloId) {
        return dal.getModeloById(modeloId);
    }
}
