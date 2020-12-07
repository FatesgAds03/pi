package br.com.mulacar.bll;

import br.com.mulacar.dal.CidadeDal;
import br.com.mulacar.model.Cidade;
import java.util.List;

/**
 *
 * @author Jsfr
 */
public class CidadeBll {

    private static final long serialVersionUID = 1L;
    private CidadeDal dal;

    public CidadeBll() {
        super();
        dal = new CidadeDal();
    }
    
    public void Adicionar(Cidade obj) throws Exception{
        dal.addCidade(obj);
    }
    
    public void Alterar(Cidade obj) throws Exception{
        dal.updateCidade(obj);
    }
    
    public void Remover(Cidade obj) throws Exception{
        dal.deleteCidade(obj.getIden());
    }
    
    public List<Cidade> getConsulta(){
        return dal.getAllCidades();
    }
    
    public Cidade getConsultaPorId(int CidadeId){
        return dal.getCidadeById(CidadeId);
    }
}
