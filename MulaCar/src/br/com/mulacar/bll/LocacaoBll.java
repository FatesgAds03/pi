/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.bll;

import br.com.mulacar.dal.LocacaoDal;
import br.com.mulacar.model.Locacao;
import java.util.List;

/**
 *
 * @author jsfr
 */
public class LocacaoBll {
    private static final long serialVersionUID = 1L;
    private LocacaoDal dal;

    public LocacaoBll() {
        super();
        dal = new LocacaoDal();
    }
    
    public void Adicionar(Locacao locacao) throws Exception{
        dal.addLocacao(locacao);
    }
    
    public void Alterar(Locacao locacao) throws Exception{
        dal.updateLocacao(locacao);
    }
    
    public void Remover(Locacao locacao) throws Exception{
        dal.deleteLocacao(locacao.getIden());
    }
    
    public List<Locacao> getConsulta(){
        return dal.getAllLocacoes();
    }
    
    public Locacao getConsultaPorId(int LocacaoId){
        return dal.getLocacaoById(LocacaoId);
    }
} 