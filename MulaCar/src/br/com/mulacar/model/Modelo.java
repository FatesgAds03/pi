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
public class Modelo {
    
    private int modelo_iden;
    private String nome;
    private Marca marca;

    /**
     * @return the modelo_iden
     */
    public int getModelo_iden() {
        return modelo_iden;
    }

    /**
     * @param modelo_iden the modelo_iden to set
     */
    public void setModelo_iden(int modelo_iden) {
        this.modelo_iden = modelo_iden;
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

    /**
     * @return the marca_iden
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca_iden the marca_iden to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
    
}
