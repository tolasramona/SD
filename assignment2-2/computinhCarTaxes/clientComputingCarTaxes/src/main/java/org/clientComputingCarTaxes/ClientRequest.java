package org.clientComputingCarTaxes;

import org.commonInterfaceComputingCarTaxes.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRequest {

	private Car car;

	public ClientRequest(Car c) {
		this.car = c;
	}

	public double performRequestForTaxService() throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(1099);
		ITaxComputing stub = (ITaxComputing) registry.lookup("ITaxComputing");
		double rez = stub.computeTax(car);
		return rez;

	}

	public double performRequestForSellingPrice() throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(1099);
		ISellingPriceService sellingPriceStub = (ISellingPriceService) registry.lookup("ISellingPriceService");
		double sellingP = sellingPriceStub.computeSellingPrince(car);
		return sellingP;

	}
}
