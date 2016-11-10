package org.serverComputinCarTaxes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.commonInterfaceComputingCarTaxes.*;

public class Server {

	public static void main(String args[]) {

		try {

			Registry registry = LocateRegistry.createRegistry(1099);
			ComputingTaxService service = new ComputingTaxService();
			SellingPriceService sellingPriceService = new SellingPriceService();
			ITaxComputing stub = (ITaxComputing) UnicastRemoteObject.exportObject(service, 0);
			ISellingPriceService stub2 = (ISellingPriceService) UnicastRemoteObject.exportObject(sellingPriceService,
					1);

			registry = LocateRegistry.getRegistry();
			registry.bind("ITaxComputing", stub);
			registry.bind("ISellingPriceService", stub2);

			System.err.println("Server ready");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
