/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.util;

import br.com.mulacar.dal.PessoaDal;
import br.com.mulacar.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author jsfr
 */
public class PessoaComboboxModel extends AbstractListModel implements ComboBoxModel{
    
    private List<Pessoa> listapessoa;
    private Pessoa pessoaSelecionada;
    private PessoaDal cliente = new PessoaDal();

    public PessoaComboboxModel() {
    this.listapessoa = new ArrayList<>(cliente.getAllPessoaFisica());
    }
        
    @Override
    public int getSize() {
        return listapessoa.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listapessoa.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem instanceof Pessoa){
        this.pessoaSelecionada= (Pessoa) anItem;
        fireContentsChanged(this.listapessoa, 0, this.listapessoa.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.pessoaSelecionada;
    }
    
    public void addPessoas(Pessoa pPessoa){
        this.listapessoa.add(pPessoa);
    }
    
    public void reset(){
        this.listapessoa.clear();
    }
}
