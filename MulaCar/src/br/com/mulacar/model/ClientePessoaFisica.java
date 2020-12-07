/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.model;

import java.sql.Date;

/**
 *
 * @author jsfr
 */
public class ClientePessoaFisica extends Pessoa {
    private long cpf;
    private long cnh;
    private Date Dt_validade_cnh;
    private String cat_cnh;
    private long identidade;
    private int foto_iden;

   
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCnh() {
        return cnh;
    }

    public void setCnh(long cnh) {
        this.cnh = cnh;
    }

    public Date getDt_validade_cnh() {
        return Dt_validade_cnh;
    }

    public void setDt_validade_cnh(Date Dt_validade_cnh) {
        this.Dt_validade_cnh = Dt_validade_cnh;
    }

    public String getCat_cnh() {
        return cat_cnh;
    }

    public void setCat_cnh(String cat_cnh) {
        this.cat_cnh = cat_cnh;
    }

    public long getIdentidade() {
        return identidade;
    }

    public void setIdentidade(long identidade) {
        this.identidade = identidade;
    }

    public int getFoto_iden() {
        return foto_iden;
    }

    public void setFoto_iden(int foto_iden) {
        this.foto_iden = foto_iden;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
}
