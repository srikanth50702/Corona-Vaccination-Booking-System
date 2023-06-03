
package corona;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class Remove extends JFrame{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove frame = new Remove();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	
	public Remove() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("corona/4.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Remove Vaccination Centres ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 200, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Centre Id :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
                
                c1 = new Choice();
                try{
                    corona.conn c = new corona.conn();
                    ResultSet rs = c.s.executeQuery("select * from addcentre");
                    while(rs.next()){
                        c1.add(rs.getString("centreid"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);
                
                l2.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae){
                        System.out.println("Hi");
                        try{
                            
                            corona.conn c = new corona.conn();
                            String number = c1.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from addcentre where centreid = "+number);
                            
                            if(rs.next()){
                                System.out.println("clicked");
                                t1.setText(rs.getString("centreid"));    
                            }
                        }catch(Exception e){ }
                    }
                });

		
		
                
                
           	
                
		JButton btnCheckOut = new JButton("RemoveFlight");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id = c1.getSelectedItem();
                                //String s1 = t1.getText();
				String deleteSQL = "Delete from addcentre where centreid = "+id;
                              corona.conn c = new corona.conn();

	    		try{
	    			c.s.executeUpdate(deleteSQL);
	    			
	    			JOptionPane.showMessageDialog(null, "Centre removed Successful");
	    			new flight.Dashboard().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(50, 150, 150, 30);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new corona.Dashboard().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(200, 150, 150, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}