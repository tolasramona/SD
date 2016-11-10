package org.clientComputingCarTaxes;

import javax.swing.*;

import org.commonInterfaceComputingCarTaxes.Car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CatalogController {
	
	private CatalogView catalogView;
	

	public CatalogController() {
		catalogView = new CatalogView();
		catalogView.setVisible(true);
		catalogView.addBtnGetActionListener(new GetActionListener());
		
	}

	

	public void displayErrorMessage(String message) {
		catalogView.clear();
		JOptionPane.showMessageDialog(catalogView, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void displayInfoMessage(String message) {
		catalogView.clear();
		JOptionPane.showMessageDialog(catalogView, message, "Success", JOptionPane.PLAIN_MESSAGE);
	}

	
	class GetActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				String yearText=catalogView.getCarYear();
				String engineCapacityText=catalogView.getCarEngineCapacity();
				String pourchasingPriceText=catalogView.getCarPourchiasingPrice();
				
				int year=Integer.parseInt(yearText);
				int engineCapacity=Integer.parseInt(engineCapacityText);
				int pourchasingPrice=Integer.parseInt(pourchasingPriceText);
				
				Car car=new Car(year,engineCapacity,pourchasingPrice);
				ClientRequest request=new ClientRequest(car);
				double tax=request.performRequestForTaxService();
				double sellingPrice=request.performRequestForSellingPrice();
				String toPrint="Tax:"+tax+"\n Selling price: "+sellingPrice;
				
				catalogView.printCarTaxes(toPrint);
			} catch (NumberFormatException ex) {
				displayErrorMessage("Please enter a number!");
			
			} 
			catch (Exception ex) {
				String message=ex.getMessage();
				catalogView.printCarTaxes(message);
			
			} 
		}
	}			
		
				
			
}
