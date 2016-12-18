package model;

import java.util.List;

public class Route {
	
	private List<RouteEntry> routeEntries;

	public List<RouteEntry> getRouteEntries() {
		return routeEntries;
	}

	public void setRouteEntries(List<RouteEntry> routeEntries) {
		this.routeEntries = routeEntries;
	}

	@Override
	public String toString() {
		return "Route [routeEntries=" + routeEntries + "]";
	}
	
	

}
