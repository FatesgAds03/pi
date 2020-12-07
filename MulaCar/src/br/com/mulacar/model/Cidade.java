/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.model;

import br.com.mulacar.util.EstadosEnum;

/**
 *
 * @author jsfr
 */
public class Cidade {
    private int iden;
    private String nome;
    private EstadosEnum estado;

    public Cidade() {
    }

    public Cidade(int iden, String nome, EstadosEnum estado) {
        this.iden = iden;
        this.nome = nome;
        this.estado = estado;
    }
    
    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadosEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadosEnum estado) {
        this.estado = estado;
    }
    
}
