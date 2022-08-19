package br.com.flux.model;

import java.util.Random;

public class Candidatura {

	private String nome;
	private double salario;
	private boolean valida;
	
	public Candidatura(String nom, double sal) {
		this.nome = nom;
		this.salario = sal;
		this.valida = false;
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
	
}
