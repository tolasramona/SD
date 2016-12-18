package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Package {
	
	private int id;
	private Client sender;
	private Client receiver;
	private String name;
	private String description;
	private String senderCity;
	private String receiverCity;
	private boolean tracked;
	private int routeId;
//	private List<RouteEntry> routes=new ArrayList<RouteEntry>(0);
	private Set<RouteEntry> routes ;
			
	
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public Set<RouteEntry> getRoutes() {
		return routes;
	}
	public void setRoutes(Set<RouteEntry> routes) {
		this.routes = routes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSenderCity() {
		return senderCity;
	}
	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
	public boolean isTracked() {
		return tracked;
	}
	public void setTracked(boolean tracked) {
		this.tracked = tracked;
	}
	
	public Client getSender() {
		return sender;
	}
	public void setSender(Client sender) {
		this.sender = sender;
	}
	public Client getReceiver() {
		return receiver;
	}
	public void setReceiver(Client receiver) {
		this.receiver = receiver;
	}
	@Override
	public String toString() {
		return "Package [id=" + id + ", senderId=" + sender+ ", receiverId=" + receiver + ", name=" + name
				+ ", description=" + description + ", senderCity=" + senderCity + ", receiverCity=" + receiverCity
				+ ", tracked=" + tracked + ", routes=" + routes + "]";
	}
	
	

}
