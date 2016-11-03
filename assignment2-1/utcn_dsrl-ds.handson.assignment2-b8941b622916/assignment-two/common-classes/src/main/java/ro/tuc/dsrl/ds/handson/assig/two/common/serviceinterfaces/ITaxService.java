package ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces;

import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-two-common-classes
 * @Since: Sep 1, 2015
 * @Description:
 * 	Interface of the remote object published by the server. It allows for the computation
 * 	of the tax needed to be payed for a Car.
 */
public interface ITaxService {

	/**
	 * Computes the tax to be payed for a Car.
	 *
	 * @param c Car for which to compute the tax
	 * @return tax for the car
	 */
	double computeTax(Car c);
}
