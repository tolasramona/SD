package org.commonInterfaceComputingCarTaxes;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITaxComputing extends Remote  {
	
	double computeTax(Car c) throws RemoteException;

}
