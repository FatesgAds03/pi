/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.util;

/**
 *
 * @author jsfr
 */
public enum CategoriaEnum {
    ECONOMICO(70.0),
    INTERMEDIARIO(90.0),
    SUV(120.0),
    EXECUTIVO(160.0),
    UTILITARIO(200.0);
    
    private double valor;

    CategoriaEnum(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
