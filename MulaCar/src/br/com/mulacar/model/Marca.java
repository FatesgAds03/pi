/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.model;

/**
 *
 * @author deockar
 */
public class Marca {
    
    private int marca_iden;
    private String nome;

    /**
     * @return the marca_iden
     */
    public int getMarca_iden() {
        return marca_iden;
    }

    /**
     * @param marca_iden the marca_iden to set
     */
    public void setMarca_iden(int marca_iden) {
        this.marca_iden = marca_iden;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
  
}
