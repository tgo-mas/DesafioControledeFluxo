package br.com.flux.controller;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

import br.com.flux.model.Candidatura;

public class Controller {

	private ArrayList<Candidatura> cands;
	private double salBase;
	
	public Controller() {
		this.cands = new ArrayList<>();
		this.salBase = 2000.00;
	}

	public ArrayList<Candidatura> getCands() {
		return cands;
	}

	public void setCands(ArrayList<Candidatura> cands) {
		this.cands = cands;
	}
	
	private double random() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	public void addCandidato(String nome, double sal) throws Exception {
		try {
			this.cands.add(new Candidatura(nome, sal));
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void verificarCandidaturas() {
		String result = "";
		for(Candidatura cand:cands) {
			result += "Candidatx: " + cand.getNome() + "  Situação: ";
			if(cand.validar(salBase)) {
				result += "Válido.\n";
			}else {
				result += "Inválido.\n";
			}
		}
		JOptionPane.showMessageDialog(null, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarSelecionados() {
		String result = "Candidatos selecionados: \n";
		for(Candidatura cand:cands) {
			if(cand.isValida()) {
				result += cand.getNome() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, result, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void contatarSelecionados() {
		for(Candidatura cand:cands) {
			if(cand.isValida()) {
				for(int i = 1; i <= 3; i++) {
					if(cand.contatar()) {
						String message = "Conseguimos contato com " + cand.getNome() + " após " + i + " tentativa(s).";
						JOptionPane.showMessageDialog(null, message, "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}else if (i == 3){
						String message = "Não conseguimos contato com o candidato " + cand.getNome();
						JOptionPane.showMessageDialog(null, message, "Falha", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
	
}
