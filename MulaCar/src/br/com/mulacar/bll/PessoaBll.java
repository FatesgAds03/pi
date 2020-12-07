package br.com.mulacar.bll;

import br.com.mulacar.dal.PessoaDal;
import br.com.mulacar.model.ClientePessoaFisica;
import br.com.mulacar.model.ClientePessoaJuridica;
import br.com.mulacar.model.Pessoa;
import java.util.List;

/**
 *
 * @author Jsfr
 */
public class PessoaBll {

    private static final long serialVersionUID = 1L;
    private PessoaDal dal;

    public PessoaBll() {
        super();
        dal = new PessoaDal();
    }
    
    public void Adicionar(ClientePessoaFisica obj) throws Exception{
        dal.addPessoa(obj);
    }
    
    public void Adicionar(ClientePessoaJuridica obj) throws Exception{
        dal.addPessoa(obj);
    }
    
    public void Alterar(ClientePessoaFisica obj) throws Exception{
        dal.updatePessoa(obj);
    }
    
    public void Alterar(ClientePessoaJuridica obj) throws Exception{
        dal.updatePessoa(obj);
    }
    
    public void Remover(Pessoa obj) throws Exception{
        dal.deletePessoa(obj.getIden());
    }
    
    public List<ClientePessoaFisica> getConsultaPessoaFisica(){
        return dal.getAllPessoaFisica();
    }
    
    public Pessoa getConsultaPorId(int PessoaId){
        return dal.getPessoaById(PessoaId);
    }
    
}
