package br.com.flux.controller;

import java.io.PrintWriter;
import java.util.ArrayList;

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
	
	public void addCandidato(String nome, double salario) throws Exception {
		Candidatura cand = new Candidatura(nome, salario);
		try {
			this.cands.add(cand);
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
	
	public void salvarCandidatos(PrintWriter writer) {
		String str = "";
		
		for(Candidatura cand:this.cands) {
			str += cand.toString();
			str += ";";
		}
		
		writer.printf(str);
		writer.close();
	}
	
	public void lerCandidatos(String candsStr) {
		String[] candes = candsStr.split(";");
		
		for(String cand:candes) {
			this.cands.add(new Candidatura(cand));
		}
	}
	
	public void apagarCandidato(Candidatura cand){
		cands.remove(cand);
	}
	
	public void apagarCandidatos(ArrayList<Candidatura> candes) {
		for(int i = 0; i < cands.size(); i++) {
			for(Candidatura candAux:candes) {
				if(candAux.getNome().equals(cands.get(i).getNome())) {
					cands.remove(i);
				}
			}
		}
	}
	
	public Object[][] toObject(){
		Object[][] arr = new Object[cands.size()][4];
		
		for(int i = 0; i < cands.size(); i++) {
			arr[i] = new Object[]{false,cands.get(i).getNome(), cands.get(i).getSalario(), cands.get(i).isValida()};
		}
		
		return arr;
	}
	
}
