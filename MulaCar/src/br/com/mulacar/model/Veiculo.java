    
    //VEICULOS UTILIZADOS, PEGADOS DO SITE https://www.localiza.com/brasil/pt-br/grupos-de-carros
    //ECONÔMICO (FIAT UNO, RENAULT KWID, FIAT MOBI, GM ONIX, NOVO FORD KA, FIAT ARGO, HB20, PEUGEOT 208, VW GOL, VW POLO, RENAULT SANDERO, NISSAN VERSA,
    //HB20S, GM PRISMA, GM ONIX PLUS )TODOS MODELOS 1.0
    //INTERMEDIARIO ( VW GOL 1.6, RENAULT SANDERO 1.6, GM PRISMA 1.4, FORD KA SEDAN 1.5, GM ONIX 1.0 TURBO, NISSAN VERSA 1.6, VOYAGE 1.6, HB20S 1.6,
    //VIRTUS 1.6, FIAT CRONOS 1.3 )
    //SUV ( FORD ECOSPORT 1.5, RENAULT DUSTER 1.6, GM TRACKER 1.4 TURBO, FORD ECOSPOT 2.0, CAPTUR 2.0, RENEGATE SPORT 1.8, VW T-CROSS 1.4 TSI )
    //EXECUTIVO ( VW JETTA, COROLLA GLI, CRUZE, MERCEDES C180, AUDI A4 TFSI, FORD FUSION, JEEP COMPASS LONGITUDE, VW TIGUAN TSI )
    //UTILITARIO ( FIAT STRADA 1.4, VW SAVEIRO 1.6, FIAT TORO 1.8, DUSTER OROCH 2.0, FIAT DOBLO 1.8, FIORINO 1.4, PATNER FURGÃO 1.6, VW MONTANA 1.4,
    //GM S10 2.8, VAN)

package br.com.mulacar.model;

import br.com.mulacar.util.CategoriaEnum;

/**
 *
 * @author deockar
 */
public class Veiculo {

    private String placa_veiculo;
    private int renavam;
    private CategoriaEnum categoria;
    private float preco_compra;
    private float preco_venda;
    private int numero_passageiro;
    private int ano_fabricacao;
    private int ano_modelo;
    private String tipo_combustivel;
    private String tipo;
    private String situacao;
    private int quilometragem;
    private int modelo_iden;
    private int foto_iden;

    public Veiculo(){
    }
    
    public Veiculo(String placa_veiculo, int renavam, CategoriaEnum categoria, float preco_compra,float preco_venda,int numero_passageiro,int ano_fabricacao, int ano_modelo,String tipo_combustivel,String tipo, String situacao,int quilometragem,int foto_iden, int modelo_iden){
        this.placa_veiculo = placa_veiculo;
        this.renavam = renavam;
        this.categoria = categoria;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.numero_passageiro = numero_passageiro;
        this.ano_fabricacao = ano_fabricacao;
        this.ano_modelo = ano_modelo;
        this.tipo_combustivel = tipo_combustivel;
        this.tipo = tipo;
        this.situacao = situacao;
        this.quilometragem = quilometragem;
        this.modelo_iden = modelo_iden;
        this.foto_iden = foto_iden;
        
    }
    
    /**
     * @return the placa_veiculo
     */
    public String getPlaca_veiculo() {
        return placa_veiculo;
    }

    /**
     * @param placa_veiculo the placa_veiculo to set
     */
    public void setPlaca_veiculo(String placa_veiculo) {
        this.placa_veiculo = placa_veiculo;
    }

    /**
     * @return the renavam
     */
    public int getRenavam() {
        return renavam;
    }

    /**
     * @param renavam the renavam to set
     */
    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    /**
     * @return the categoria
     */
    public CategoriaEnum getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the preco_compra
     */
    public double getPreco_compra() {
        return preco_compra;
    }

    /**
     * @param preco_compra the preco_compra to set
     */
    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }

    /**
     * @return the preco_venda
     */
    public double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    /**
     * @return the numero_passageiro
     */
    public int getNumero_passageiro() {
        return numero_passageiro;
    }

    /**
     * @param numero_passageiro the numero_passageiro to set
     */
    public void setNumero_passageiro(int numero_passageiro) {
        this.numero_passageiro = numero_passageiro;
    }

    /**
     * @return the ano_fabricacao
     */
    public int getAno_fabricacao() {
        return ano_fabricacao;
    }

    /**
     * @param ano_fabricacao the ano_fabricacao to set
     */
    public void setAno_fabricacao(int ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    /**
     * @return the ano_modelo
     */
    public int getAno_modelo() {
        return ano_modelo;
    }

    /**
     * @param ano_modelo the ano_modelo to set
     */
    public void setAno_modelo(int ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    /**
     * @return the tipo_combustivel
     */
    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    /**
     * @param tipo_combustivel the tipo_combustivel to set
     */
    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the quilometragem
     */
    public int getQuilometragem() {
        return quilometragem;
    }

    /**
     * @param quilometragem the quilometragem to set
     */
    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

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
     * @return the foto_iden
     */
    public int getFoto_iden() {
        return foto_iden;
    }

    /**
     * @param foto_iden the foto_iden to set
     */
    public void setFoto_iden(int foto_iden) {
        this.foto_iden = foto_iden;
    }

    public void add(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
