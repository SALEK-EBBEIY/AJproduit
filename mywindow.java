package GUI ;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class user_interface extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel from = new JLabel("from: ");
	JLabel to = new JLabel("To: ");
	String[] Devises = {"dollar", "Euro", "MAD"};
	JComboBox <String>element1 = new JComboBox<>(Devises);
	JComboBox <String>element2 = new JComboBox<>(Devises);
	JLabel enter = new JLabel("Enter Amount to Converter : ");
	JTextField montant_convert = new JTextField();
	JLabel sortie = new JLabel("Total Amount Convert :");
	JTextField montant_sortie = new JTextField();
	JButton B1 = new JButton("compute");
	JButton B2 = new JButton("Exit");
	
	JPanel PP = new JPanel();
	JPanel PN = new JPanel();
	JPanel PC = new JPanel();
	JPanel PS = new JPanel();
	
	public user_interface(String title){
		super("Money currency converter ?");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PP.setLayout(new BorderLayout());
		setSize(400,250);
		montant_sortie.setEditable(false);
		
		PN.setLayout(new GridLayout(2,2));
		PN.add(from);PN.add(to);
		PN.add(element1);PN.add(element2);
		
		PC.setLayout(new GridLayout(4,0));
		PC.add(enter);PC.add(montant_convert);
		PC.add(sortie);PC.add(montant_sortie);
		
		PS.setLayout(new FlowLayout());
		PS.add(B1);PS.add(B2);
		
		PP.add(PN,BorderLayout.NORTH);
		PP.add(PC, BorderLayout.CENTER);
		PP.add(PS, BorderLayout.SOUTH);
		
		B2.addActionListener(this);
		B1.addActionListener(this);
		
		
		setContentPane(PP);
		//pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new user_interface("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==B2) {
			JOptionPane.showConfirmDialog(PP,"Do you want to exit ?", null, JOptionPane.YES_NO_OPTION);
		}
		else if(e.getSource()==B1){
			Double rslt = null;
			String val1 = montant_convert.getText();
			Double V1 = Double.parseDouble(val1);
			if(element1.getSelectedIndex()==0) {
				if(element2.getSelectedIndex()==0) {
					rslt = V1;
				}
				else if(element2.getSelectedIndex()==1) {
					rslt= V1*0.94;
				}
				else if(element2.getSelectedIndex()==2) {
					rslt = V1*9.91;
				}
			}
			else if(element1.getSelectedIndex()==1) {
				if(element2.getSelectedIndex()==0) {
					rslt = V1*1.07;
				}
				else if(element2.getSelectedIndex()==1) {
					rslt = V1;
				}
				else if (element2.getSelectedIndex()==2) {
					rslt = 10.59*V1;
				}
			}
			else if(element1.getSelectedIndex()==2) {
				if(element2.getSelectedIndex()==0) {
					rslt = V1/9.91;
				}
				else if(element2.getSelectedIndex()==1) {
					rslt = V1/10.59;
				}
				else if(element2.getSelectedIndex()==2) {
					rslt = V1;
				}
			}
            String s = String.format("%.2f", rslt);
			montant_sortie.setText(s);
		}
		
	}
}
