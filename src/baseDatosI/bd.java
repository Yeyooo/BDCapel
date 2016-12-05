package baseDatosI;

import java.awt.BorderLayout;
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

public class bd extends JFrame {

	private JPanel contentPane;
	private JTextField rut;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField textField_3;
	private JTextField textField_4;
	private Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			Connection con = null;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProbarConexion = new JButton("Probar Conexion");
		btnProbarConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				con = null;
				try{
					 Class.forName("org.postgresql.Driver");
			         con = DriverManager.getConnection("jdbc:postgresql://10.3.132.10:5432/prueba","prueba", "7aplac9");
				} catch (Exception e){
					e.printStackTrace();
		        	 System.err.println(e.getClass().getName()+": "+e.getMessage());
		             System.exit(0);
				}
				System.out.println("Opened database successfully");
				JOptionPane.showMessageDialog(null, "Exito");
			}
		});
		btnProbarConexion.setBounds(271, 227, 153, 23);
		contentPane.add(btnProbarConexion);
		
		rut = new JTextField();
		rut.setBounds(79, 39, 122, 20);
		contentPane.add(rut);
		rut.setColumns(10);
		
		JLabel lblDatosDueo = new JLabel("Buscar datos Due\u00F1o");
		lblDatosDueo.setBounds(23, 14, 161, 14);
		contentPane.add(lblDatosDueo);
		
		JLabel lblRut = new JLabel("Rut");
		lblRut.setBounds(23, 40, 46, 14);
		contentPane.add(lblRut);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(23, 77, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(23, 102, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setBounds(23, 137, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(23, 171, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(79, 74, 327, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setEditable(false);
		apellido.setBounds(79, 99, 327, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(79, 134, 327, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(79, 168, 327, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "Select * from \"Dueño\" where \"RUT\" = '"+rut.getText().toString()+"' ;";
					Statement st = con.createStatement();
					ResultSet result = st.executeQuery(sql);
					String a= "nO FUNCIONO";
					String b = "No funciono";
					String c = "No funciono";
					while(result.next()){
						 a = result.getString("nombre");
					     b = result.getString("apellidoP");
					     c = result.getString("apellidoM");
					     
					}
					nombre.setText(a);
					apellido.setText(b+" "+c);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBuscar.setBounds(249, 38, 89, 23);
		contentPane.add(btnBuscar);
	}
}
