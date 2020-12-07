/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.bll;
import br.com.mulacar.dal.VeiculoDal;
import br.com.mulacar.model.Veiculo;
import java.util.List;
/**
 *
 * @author deockar
 */
public class VeiculoBll {
    
    private static final long serialVersionUID = 1L;
    private VeiculoDal dal;
    
    public VeiculoBll(){
        super();
        dal = new VeiculoDal();
    }
    
    public void Adicionar (Veiculo veiculo) throws Exception{
        dal.addVeiculo(veiculo);
    }
    public void Alterar (Veiculo veiculo) throws Exception {
        dal.updateVeiculo(veiculo);
    }
    public void Remover (Veiculo veiculo) throws Exception {
        dal.deleteVeiculo(veiculo.getPlaca_veiculo());
    }
    public List<Veiculo> getConsulta(){
        return dal.getAllVeiculo();
    }
    
    public List<Veiculo> getConsultaDisponiveis(){
        return dal.getAllVeiculoDisponiveis();
    }
    
    public Veiculo getVeiculoByPlaca(int veiculoId) {
        return dal.getVeiculoByPlaca(veiculoId);
    }
}
