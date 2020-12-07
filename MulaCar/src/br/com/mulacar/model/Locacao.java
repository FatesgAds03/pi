/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author jsfr
 */
public class Locacao {
    SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yyyy");

    private int iden;
    private float multaAtraso;
    private boolean tanqueCheio;
    private Veiculo veiculo;
    private Pessoa motorista;
    private Pessoa locatario;
    private Date dataRetirada;
    private Date dataDevolucaoPrevista;
    private Date dataDevolucao;
    private int kilometragenInicial;
    private int kilometragemFinal;

    public Locacao() {
    }

    public Locacao(int iden, float multaAtraso, boolean tanqueCheio, Veiculo veiculo, Pessoa motorista, Pessoa locatario, Date dataRetirada, Date dataDevolucaoPrevista, Date dataDevolucao, int kilometragenInicial, int kilometragemFinal) {
        this.iden = iden;
        this.multaAtraso = multaAtraso;
        this.tanqueCheio = tanqueCheio;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.locatario = locatario;
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucao = dataDevolucao;
        this.kilometragenInicial = kilometragenInicial;
        this.kilometragemFinal = kilometragemFinal;
    }



    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public float getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(float multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public boolean isTanqueCheio() {
        return tanqueCheio;
    }

    public boolean getTanqueCheio() {
        return tanqueCheio;
    }

    public void setTanqueCheio(boolean tanqueCheio) {
        this.tanqueCheio = tanqueCheio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Pessoa getMotorista() {
        return motorista;
    }

    public void setMotorista(Pessoa motorista) {
        this.motorista = motorista;
    }

    public Pessoa getLocatario() {
        return locatario;
    }

    public void setLocatario(Pessoa locatario) {
        this.locatario = locatario;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getKilometragenInicial() {
        return kilometragenInicial;
    }

    public void setKilometragenInicial(int kilometragenInicial) {
        this.kilometragenInicial = kilometragenInicial;
    }

    public int getKilometragemFinal() {
        return kilometragemFinal;
    }

    public void setKilometragemFinal(int kilometragemFinal) {
        this.kilometragemFinal = kilometragemFinal;
    }

    

    public double calcularValorLocacao() {
        long dt = (dataDevolucao.getTime() - dataRetirada.getTime()) + 3600000;
        long dias = (dt / 86400000L);
        double valor = (this.veiculo.getCategoria().getValor()*dias);
        return valor;
    }
    
    public double calcularMultaPorAtraso(){
        long dt = (dataDevolucao.getTime() - dataDevolucaoPrevista.getTime()) + 3600000;
        long dias = (dt / 86400000L);
        double valor = (this.veiculo.getCategoria().getValor()*dias);
        return valor;
    }
    public double calcularValorSeguro(){
        return calcularValorLocacao()*0.09;
    }
    
    public double calcularValorCalcao(){
        return calcularValorLocacao()*1.5;
    }
}
