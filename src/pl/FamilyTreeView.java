package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bll.IBO;
import bll.PersonBO;
import dal.IDAL;
import dal.PersonDAO;
import to.PersonTO;

public class FamilyTreeView implements ActionListener {	
	private JFrame frame1;
	private JFrame frame2;
	private JFrame frame3;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JTextField cnic1;
	private JTextField cnic2;
	private JTextField name;
	private JButton button1;
	private JButton button2;
	private JTextArea result;
	private JPanel panel;
	private IBO ibo; 
	
	public FamilyTreeView() throws SQLException {
		IDAL idao = new PersonDAO();
		ibo = new PersonBO(idao);
		frame1 = new JFrame();
		frame2 = new JFrame();
		frame3 = new JFrame();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		cnic1 = new JTextField("");
		cnic2 = new JTextField("");
		name = new JTextField("");
		button1 = new JButton();
		button2 = new JButton();
		result = new JTextArea();
	}
	
	public void menuWindow() {
		frame1.setTitle("Family Tree App");
		
		button1.setText("Check Siblings/Half Siblings");
		button1.setBounds(40, 50, 200, 50);
		button1.addActionListener(this);
		
		button2.setText("Get Person Details");
		button2.setBounds(40, 125, 200, 50);
		button2.addActionListener(this);
		
		frame1.add(button1);
		frame1.add(button2);
		
		frame1.setSize(300,250);
		frame1.setLayout(null);
		frame1.setVisible(true);
	}
	
	public void siblingsStatusWindow() {
		panel = new JPanel();
		frame2.add(panel);
		frame2.setTitle("Check Siblings/Half Siblings");
		
		label1.setText("Enter CNIC 1");
		label1.setBounds(70, 20, 100, 10);
		cnic1.setBounds(70, 35, 150, 30);
		label2.setText("Enter CNIC 2");
		label2.setBounds(70, 70, 150, 10);
		cnic2.setBounds(70, 85, 150, 30);
		
		button1.setText("Check Siblings/Half Siblings");
		button1.setBounds(40, 120, 220, 40);
		button1.addActionListener(this);
		
		result.setText("");
		result.setBounds(40, 170, 220, 30);
		
		button2.setText("Menu");
		button2.setBounds(60, 210, 180, 30);
		button2.addActionListener(this);
		
		frame2.add(label1);
		frame2.add(label2);
		frame2.add(cnic1);
		frame2.add(cnic2);
		frame2.add(result);
		frame2.add(button1);
		frame2.add(button2);
		frame2.setSize(300,300);
		frame2.setLayout(null);
		frame2.setVisible(true);
	}
	
	public void personDetailsWindow() {
		panel = new JPanel();
		frame3.add(panel);
		frame3.setTitle("Get Person Details");
		
		label3.setText("Enter Name");
		label3.setBounds(70, 20, 100, 10);
		name.setBounds(70, 35, 150, 30);
		
		button1 = new JButton();
		button1.setText("Get Person Details");
		button1.setBounds(50, 80, 200, 40);
		button1.addActionListener(this);
		
		result.setText("");
		result.setBounds(50, 130, 200, 70);
		
		button2.setText("Menu");
		button2.setBounds(50, 220, 200, 30);
		button2.addActionListener(this);
		
		frame3.add(label3);
		frame3.add(name);
		frame3.add(result);
		frame3.add(button1);
		frame3.add(button2);
		frame3.setSize(300,300);
		frame3.setLayout(null);
		frame3.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Menu") {
			frame2.setVisible(false);
			frame3.setVisible(false);
			menuWindow();
		}
		else if(e.getActionCommand() == "Check Siblings/Half Siblings") {
			frame1.setVisible(false);
			siblingsStatusWindow();
			if(!(cnic1.getText().isEmpty() && cnic2.getText().isEmpty())) {
				int nic1 = Integer.parseInt(cnic1.getText());
				int nic2 = Integer.parseInt(cnic2.getText());
				if (ibo.isSibling(nic1, nic2)) {
					result.setText("Yes, the two citizens are siblings");
				} else if (ibo.isHalfSibling(nic1, nic2)) {
					result.setText("Yes, the two citizens are Half siblings");
				} else {
					result.setText("No, the two citizens are not siblings");
				}
			}
		}
		else if(e.getActionCommand() == "Get Person Details") {
			frame1.setVisible(false);
			personDetailsWindow();
			String perName = name.getText();
			PersonTO p = ibo.getPerson(perName);
			if(p != null)
			{
				result.setText(Integer.toString(p.getCnic()));
				result.append("\n" + p.getName());
				result.append("\n" + Integer.toString(p.getFather()));
				result.append("\n" + Integer.toString(p.getMother()));
			}
			
	     }
	}

	
	public static void main(String[] args) {
		FamilyTreeView app;
		try {
			app = new FamilyTreeView();
			app.menuWindow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
