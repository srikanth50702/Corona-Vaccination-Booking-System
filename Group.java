
package corona;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Group extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JLabel lblGender;
	private JTable table;
	private JLabel lblCountry;
	private JLabel lblRoom;
	private JLabel lblStatus;
	private JLabel lblNewLabel1;
private JTextField t1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Group frame = new Group();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Group() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                 JLabel lblTime = new JLabel("Centre :");
		lblTime.setBounds(50, 10, 200, 14);
		contentPane.add(lblTime);
                
                t1 = new JTextField();
		t1.setBounds(150, 10, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new corona.Dashboard().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(450, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                           // String id = t1.getText();
				try{
                                    corona.conn c  = new corona.conn();
                                    
				String displayCustomersql = "select * from addcentre where centre = '"+t1.getText()+"'";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				//table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
		btnLoadData.setBounds(300, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		
		lblId = new JLabel("Centre Id");
		lblId.setBounds(31, 31, 100, 14);
		contentPane.add(lblId);
                
                JLabel l1 = new JLabel("Centre");
		l1.setBounds(200, 31, 100, 14);
		contentPane.add(l1);
		
		lblNewLabel = new JLabel("LandMark");
		lblNewLabel.setBounds(400, 31, 200, 14);
		contentPane.add(lblNewLabel);
		
                lblNewLabel1 = new JLabel("Working Hours");
		lblNewLabel1.setBounds(700, 31, 200, 14);
		contentPane.add(lblNewLabel1);
		
		
                
                getContentPane().setBackground(Color.WHITE);
	}
}
