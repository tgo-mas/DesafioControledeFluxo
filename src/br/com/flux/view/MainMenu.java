package br.com.flux.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.flux.controller.Contador;
import br.com.flux.controller.Controller;
import br.com.flux.model.ParametrosInvalidosException;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;

	protected Controller sys;
	
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
		this.sys = new Controller();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnValidar = new JButton("Validar Candidaturas");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				sys.verificarCandidaturas();
				
			}
		});
		
		JButton btnAdd = new JButton("Adicionar Candidatos");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro telaCad = new ViewCadastro(sys);
				telaCad.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("    Processys    ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblCont = new JLabel("Contador");
		lblCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblCont.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel_1.add(lblCont);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("De: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_2.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, null, 100, 1));
		panel_2.add(spinner);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblNewLabel_2 = new JLabel("At\u00E9: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_2.add(lblNewLabel_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, null, 100, 1));
		panel_2.add(spinner_1);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JButton btnNewButton = new JButton("Executar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Contador cont = new Contador();
				int num1 = Integer.parseInt(spinner.getValue().toString());
				int num2 = Integer.parseInt(spinner_1.getValue().toString());
				
				try{
					cont.contar(num1, num2);
				}catch(ParametrosInvalidosException err) {
					JOptionPane.showMessageDialog(null, err.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		panel_3.add(btnNewButton);
	}

}
