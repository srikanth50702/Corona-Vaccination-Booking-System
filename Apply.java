
package corona;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apply extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,r1;
      
        JComboBox comboBox;
        
        Choice c1,cn,c2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apply frame = new Apply();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Apply() throws SQLException {
		
                setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("corona/4.jpg"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
                JLabel lblName = new JLabel("APPLYING VACCINATION SLOT");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 15));
		lblName.setBounds(90, 5, 260, 53);
		contentPane.add(lblName);
		
                JLabel lblTim1 = new JLabel("Name :");
		lblTim1.setBounds(35, 100, 200, 14);
		contentPane.add(lblTim1);
                
                t1 = new JTextField();
		t1.setBounds(271, 100, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
                JLabel lblTime1 = new JLabel("Aadhar Id :");
		lblTime1.setBounds(35, 150, 200, 14);
		contentPane.add(lblTime1);
                
                t2 = new JTextField();
		t2.setBounds(271, 150, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Centre ID");
		lblNewLabel.setBounds(35, 200, 200, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    corona.conn c = new corona.conn();
                    ResultSet rs = c.s.executeQuery("select * from addcentre");
                    while(rs.next()){
                        c1.add(rs.getString("centreid"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(271, 200, 150, 20);
		contentPane.add(c1);		

                
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(35, 250, 200, 14);
		contentPane.add(lblDate);
                
                r1 = new JTextField();
		r1.setBounds(271, 250, 150, 20);
		contentPane.add(r1);
		r1.setColumns(10);
                
                
               
        

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            corona.conn c = new corona.conn();
                            String radio = null;
                            
                            
                            String s3 = c1.getSelectedItem();
                            
                            try{
	    			
	    			String s1 =  t1.getText();
                      
	    			String s2 =  t2.getText();
	    			String s6 =  r1.getText();
                                
                                
                                String q1 = "insert into apply values('"+s1+"','"+s2+"','"+s3+"','"+s6+"')";
                              
                                c.s.executeUpdate(q1);
                               
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new flight.Dashboard2().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnNewButton.setBounds(100, 470, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new corona.Dashboard2().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 470, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}

