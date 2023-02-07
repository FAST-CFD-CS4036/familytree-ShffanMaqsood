package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bll.PersonBO;
import to.PersonTO;

public class FamiltyTreeView implements ActionListener {
	
	private JFrame frame;
	private JTextField cnic1;
	private JTextField cnic2;
	private JTextField name;
	private JButton button1;
	private JButton button2;
	private JTextArea result1;
	private JTextArea result2;
	
	private PersonBO bo;
	
	public FamiltyTreeView() throws SQLException {
		bo = new PersonBO();
		frame = new JFrame("Check if two citizens are siblings or not");
		cnic1 = new JTextField("");
		cnic2 = new JTextField("");
		name = new JTextField("");
		button1 = new JButton("Check if Siblings/Half Siblings");
		button2 = new JButton("Get Person Details");
		result1 = new JTextArea();
		result2 = new JTextArea();
	}
	public void viewSibling() {

		cnic1.setBounds(50, 50, 300, 50);
		cnic2.setBounds(50, 100, 300, 50);
		button1.setBounds(50, 150, 300, 50);
		button1.addActionListener(this);
		result1.setBounds(50, 230, 300, 50);
		name.setBounds(50, 300, 300, 50);
		button2.setBounds(50, 350, 300, 50);
		button2.addActionListener(this);
		result2.setBounds(50, 400, 300, 80);
		frame.add(cnic1);
		frame.add(cnic2);
		frame.add(name);
		frame.add(result1);
		frame.add(result2);
		frame.add(button1);
		frame.add(button2);
		
		frame.setSize(400,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String txt1 = cnic1.getText();
		String txt2 = cnic2.getText();
		if(txt1 != "" && txt2 != "") 
		{
			int nic1 = Integer.parseInt(txt1);
			int nic2 = Integer.parseInt(txt2);
	
			if (bo.isSibling(nic1, nic2)) {
				result1.setText("YES, THESE TWO CITIZENS ARE SIBLINGS");
			} else if (bo.isHalfSibling(nic1, nic2)) {
				result1.setText("YES, THESE TWO CITIZENS ARE HALF SIBLINGS");
			} else {
				result1.setText("NO, THESE TWO CITIZENS ARE NOT SIBLINGS OR HALF SIBLINGS");
			}
		}
		
		String perName = name.getText();
		PersonTO p = bo.getPerson(perName);
		if(p != null)
		{
			result2.setText(Integer.toString(p.getCnic()));
			result2.append("\n" + p.getName());
			result2.append("\n" + Integer.toString(p.getFather()));
			result2.append("\n" + Integer.toString(p.getMother()));
		}
	}
	public static void main(String[] args) {
		FamiltyTreeView app;
		try {
			app = new FamiltyTreeView();
			app.viewSibling();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
