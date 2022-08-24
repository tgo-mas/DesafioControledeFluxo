package br.com.flux.view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.flux.controller.Controller;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;

public class ViewGerenciar extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ViewGerenciar(Controller sys) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 275);
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
		
		table.setModel(new DefaultTableModel(
			modelTable,
			new String[] {
				"Nome", "Sal\u00E1rio desejado", "V\u00E1lido"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.getColumnModel().getColumn(0).setMaxWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(77);
		table.getColumnModel().getColumn(1).setMinWidth(77);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setMinWidth(35);
		table.setRowHeight(24);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 8, 47, 22);
		lblNome.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNome);
		
		JLabel lblSal = new JLabel("Sal\u00E1rio desejado");
		lblSal.setBounds(175, 8, 130, 22);
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
		
		this.setVisible(true);
		
	}

}
