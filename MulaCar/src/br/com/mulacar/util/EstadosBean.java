/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mulacar.util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jsfr
 */



public class EstadosBean {

 private List<String> estados;
 
 public List<String> getEstados() {
  List<String> estadosList = new ArrayList<String>();  

  for (EstadosEnum e : EstadosEnum.values()) {
   estadosList.add(e.toString());
  }
  return estadosList;
 }

 public void setEstados(List<String> estados) {
  this.estados = estados;
 }}