package baseDatosI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

@SuppressWarnings("serial")
public class bd extends JFrame {

	private JPanel contentPane;
	private Connection con;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//Connection con = null;
			public void run() {
				try {					
					bd frame = new bd();
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
	public bd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1740, 1095);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(661, 374, 940, 559);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(917, 227, 186, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(1339, 227, 186, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(784, 230, 126, 26);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaTermino = new JLabel("Fecha termino:");
		lblFechaTermino.setBounds(1177, 230, 153, 26);
		contentPane.add(lblFechaTermino);
		
		JButton btnNewButton = new JButton("Seleccionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(190, 954, 141, 35);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 48, 496, 885);
		contentPane.add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Linea 1", "Linea 1", "Linea 1", "Linea 1", "Linea 1", "Linea 1", "Linea 1", "Linea 1", "Linea 1"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(1083, 292, 141, 35);
		contentPane.add(btnConsultar);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(783, 180, 92, 26);
		contentPane.add(lblFecha);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(917, 174, 245, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
