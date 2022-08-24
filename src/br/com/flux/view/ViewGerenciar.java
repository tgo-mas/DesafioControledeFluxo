package br.com.flux.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.flux.controller.Controller;
import br.com.flux.model.Candidatura;

@SuppressWarnings("serial")
public class ViewGerenciar extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ViewGerenciar(Controller sys) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setBounds(18, 38, 388, 180);
		table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table.setBorder(UIManager.getBorder("CheckBox.border"));
		table.setToolTipText("");
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		Object[][] modelTable = sys.toObject();
		String[] columnNames = new String[] {"Selecionado", "Nome", "Sal\u00E1rio desejado", "V\u00E1lido"};
		
		atualizarTabela(modelTable, columnNames);
		
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(59, 8, 47, 22);
		lblNome.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNome);
		
		JLabel lblSal = new JLabel("Sal\u00E1rio desejado");
		lblSal.setBounds(203, 8, 130, 22);
		lblSal.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSal.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblSal);
		
		JLabel lblValid = new JLabel("V\u00E1lido");
		lblValid.setBounds(341, 8, 49, 22);
		lblValid.setAlignmentY(Component.TOP_ALIGNMENT);
		lblValid.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblValid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValid.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblValid);
		contentPane.add(table);
		
		JButton btnRemove = new JButton("Excluir selecionados");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Candidatura> selec = getSelecionados();
				sys.apagarCandidatos(selec);
				Object[][] modelTable = sys.toObject();
				atualizarTabela(modelTable, columnNames);
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemove.setBounds(203, 226, 203, 40);
		contentPane.add(btnRemove);
		
		JButton btnAdd = new JButton("Cadastrar candidato");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro telaCad = new ViewCadastro(sys);
				telaCad.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(203, 274, 203, 40);
		contentPane.add(btnAdd);
		
		JButton btnAtt = new JButton("Atualizar");
		btnAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] modelTable = sys.toObject();
				atualizarTabela(modelTable, columnNames);
			}
		});
		btnAtt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtt.setBounds(27, 226, 106, 22);
		contentPane.add(btnAtt);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private ArrayList<Candidatura> getSelecionados(){
		ArrayList<Candidatura> selec = new ArrayList<>();
		TableModel model = table.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			if(model.getValueAt(i, 0).equals(true)) {
				selec.add(new Candidatura(model.getValueAt(i, 1).toString(), Double.parseDouble(model.getValueAt(i, 2).toString()), Boolean.parseBoolean(model.getValueAt(i, 3).toString())));
			}
		}
		
		return selec;
	}
	
	private void atualizarTabela(Object[][] modelTable, String[] columnNames) {
		table.setModel(new DefaultTableModel(
				modelTable, columnNames
			) {
				Class[] columnTypes = new Class[] {
					Boolean.class, String.class, Double.class, Boolean.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(77);
		table.getColumnModel().getColumn(2).setMinWidth(77);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setMinWidth(35);
		table.setRowHeight(24);
	}
}
