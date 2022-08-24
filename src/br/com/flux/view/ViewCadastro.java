package br.com.flux.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import br.com.flux.controller.Controller;

@SuppressWarnings("serial")
public class ViewCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	protected Controller sys;
	/**
	 * Create the frame.
	 */
	public ViewCadastro(Controller sys) {
		this.sys = sys;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCad = new JLabel("Cadastro de Candidato");
		lblCad.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel.add(lblCad);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_1.add(lblNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(textNome);
		textNome.setColumns(13);
		
		JLabel lblSal = new JLabel("Sal\u00E1rio pretendido: ");
		lblSal.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_1.add(lblSal);
		
		JLabel lblRS = new JLabel("R$ ");
		lblRS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblRS);
		
		JSpinner spinnerSal = new JSpinner();
		spinnerSal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinnerSal.setModel(new SpinnerNumberModel(1212, 1212, 9999, 10));
		panel_1.add(spinnerSal);
		
		JButton btnCad = new JButton("Cadastrar");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textNome.getText();
				int sal = Integer.parseInt(spinnerSal.getValue().toString());
				
				try{
					sys.addCandidato(nome, sal);
				}catch(Exception err) {
					JOptionPane.showMessageDialog(null, "Erro no registro de candidato!", "Falha", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnCad);
		
		JButton btnClose = new JButton("Sair");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				close();
				
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnClose);
	}
	
	public void close() {
		this.dispose();
	}
	
}
