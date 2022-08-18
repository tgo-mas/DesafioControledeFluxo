package br.com.flux.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.flux.controller.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		

		Controller sys = new Controller();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnValidar = new JButton("Validar Candidaturas");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				sys.verificarCandidaturas();
				
			}
		});
		
		JButton btnAdd = new JButton("Adicionar Candidatos");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					sys.addCandidatos();
					JOptionPane.showMessageDialog(null, "Sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Falha ao Adicionar!", "Falha", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel.add(btnAdd);
		btnValidar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel.add(btnValidar);
		
		JButton btnSelec = new JButton("Verificar Selecionados");
		btnSelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sys.mostrarSelecionados();
				
			}
		});
		btnSelec.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel.add(btnSelec);
		
		JButton btnContatar = new JButton("Contatar Selecionados");
		btnContatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sys.contatarSelecionados();
				
			}
		});
		btnContatar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel.add(btnContatar);
		
		JLabel lblNewLabel = new JLabel("Processys");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

}
