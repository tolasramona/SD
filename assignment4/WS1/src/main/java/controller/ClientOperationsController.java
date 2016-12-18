package controller;

import java.util.ArrayList;
import java.util.Collection;

import model.*;
import model.Package;

import java.util.List;

import org.hibernate.cfg.Configuration;

import crud.PackageDao;

public class ClientOperationsController {
	private PackageDao packageDao = new PackageDao(new Configuration().configure().buildSessionFactory());
	
	public ArrayList<Package> getClientPackages(String clientUsername){
		ArrayList<Package> packages=new ArrayList<Package>();
		packages.addAll( packageDao.findPackage(clientUsername));
		System.out.println(packages);
		return packages;
	}
	
	public Package getClientPackage(String clientUsername,int packageID){
		Package p=packageDao.findPackage(clientUsername, packageID);
		System.out.println(p);
		return p;
		
	}

}
