package br.com.flux.model;

import java.util.Random;

import javax.swing.JOptionPane;

public class Candidatura {

	private String nome;
	private double salario;
	private boolean valida;
	
	public Candidatura(String nom, double sal) {
		this.nome = nom;
		this.salario = sal;
		this.valida = false;
	}
	
	public Candidatura(String nom, double sal, boolean val) {
		this.nome = nom;
		this.salario = sal;
		this.valida = val;
	}
	
	public Candidatura(String candStr) {
		try{
			String[] props = candStr.split(",");
			nome = props[0];
			salario = Double.parseDouble(props[1]);
			valida = Boolean.parseBoolean(props[2]);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public boolean isValida() {
		return valida;
	}

	public boolean validar(double salBase) {
		if(salBase > this.salario) {
			this.valida = true;
			return valida;
		}else {
			this.valida = false;
			return valida;
		}
	}
	
	public boolean contatar() {
		return new Random().nextInt(3) == 1;
	}
	
	public String toString() {
		return this.nome + "," + this.salario + "," + this.valida;
	}
	
}
