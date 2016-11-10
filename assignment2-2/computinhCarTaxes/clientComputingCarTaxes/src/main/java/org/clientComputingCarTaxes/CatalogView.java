package org.clientComputingCarTaxes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class CatalogView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textYear;
	private JTextField textEngineCapacity;
	private JTextField textPourchaisingPrice;
	private JButton btnGetInformations;
	private JTextArea textArea;

	public CatalogView() {
		setTitle("Car services");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblYear = new JLabel("Year of fabrication");
		lblYear.setBounds(10, 36, 150, 14);
		contentPane.add(lblYear);

		JLabel lblengineCapacity = new JLabel("Engine capacity");
		lblengineCapacity.setBounds(10, 61, 150, 14);
		contentPane.add(lblengineCapacity);

		JLabel lblPourchasingPrice = new JLabel("Pourchaising price");
		lblPourchasingPrice.setBounds(10, 86, 150, 14);
		contentPane.add(lblPourchasingPrice);

		textYear = new JTextField();
		textYear.setBounds(160, 33, 86, 20);
		contentPane.add(textYear);
		textYear.setColumns(10);

		textEngineCapacity = new JTextField();
		textEngineCapacity.setBounds(160, 58, 86, 20);
		contentPane.add(textEngineCapacity);
		textEngineCapacity.setColumns(10);

		textPourchaisingPrice = new JTextField();
		textPourchaisingPrice.setBounds(160, 83, 86, 20);
		contentPane.add(textPourchaisingPrice);
		textPourchaisingPrice.setColumns(10);

		btnGetInformations = new JButton("GET INFO");
		btnGetInformations.setBounds(10, 132, 89, 23);
		contentPane.add(btnGetInformations);

		textArea = new JTextArea();
		textArea.setBounds(235, 131, 171, 120);
		contentPane.add(textArea);

	}

	public void addBtnGetActionListener(ActionListener e) {
		btnGetInformations.addActionListener(e);
	}

	public String getCarYear() {
		return textYear.getText();
	}

	public String getCarEngineCapacity() {
		return textEngineCapacity.getText();
	}

	public String getCarPourchiasingPrice() {
		return textPourchaisingPrice.getText();
	}

	public void printCarTaxes(String toPrint) {
		textArea.setText(toPrint);
	}

	public void clear() {
		textEngineCapacity.setText("");
		textPourchaisingPrice.setText("");
		textYear.setText("");
		textArea.setText("");

	}

}
