package model;

import java.time.Instant;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


public class TransformerFromPackageToPackageToSend {

	public PackageToSend transform(Package p) {
		PackageToSend toSend = new PackageToSend();
		toSend.setDescription(p.getDescription());
		toSend.setId(p.getId());
		toSend.setName(p.getName());
		toSend.setReceiver(p.getReceiver());
		toSend.setReceiverCity(p.getReceiverCity());
		toSend.setRouteId(p.getRouteId());
		toSend.setSender(p.getSender());
		toSend.setSenderCity(p.getSenderCity());
		toSend.setTracked(p.isTracked());
		toSend.setRoutes(this.obtainRepresentationOfRoutes(p.getRoutes()));
		return toSend;
	}

	public List<PackageToSend> transformPackages(List<Package> in) {
		List<PackageToSend> result = new ArrayList<PackageToSend>();
		for (Package p : in) {
			PackageToSend out = this.transform(p);
			result.add(out);
		}
		return result;
	}

	private String obtainRepresentationOfRoutes(Set<RouteEntry> routes) {

		String result = "Routes:";
		for (RouteEntry route : routes) {
			LocalDate date = Instant.ofEpochMilli(route.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
			String toAtach = "(" + route.getCity() + "," + date.toString() + ")";
			result += toAtach;
		}

		return result;

	}
}
