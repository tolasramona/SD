package org.commonInterfaceComputingCarTaxes;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISellingPriceService extends Remote {
	
	double computeSellingPrince(Car c) throws RemoteException;

}
