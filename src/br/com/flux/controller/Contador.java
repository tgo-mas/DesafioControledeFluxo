package br.com.flux.controller;

import javax.swing.JOptionPane;

import br.com.flux.model.ParametrosInvalidosException;

public class Contador {

	public void contar(int n1, int n2) throws ParametrosInvalidosException {
		if(n2 < n1) {
			throw new ParametrosInvalidosException();
		}else {
			for(int i = n1; i <= n2; i++) {
				System.out.println("Imprimindo número " + i);
			}
		}
		JOptionPane.showMessageDialog(null, "Verifique o console!");
	}
}
