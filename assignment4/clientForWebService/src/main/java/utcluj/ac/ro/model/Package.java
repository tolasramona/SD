package utcluj.ac.ro.model;

public class Package {
	
	private int id;
	private int senderId;
	private int receiverId;
	private String name;
	private String description;
	private String senderCity;
	private String receiverCity;
	private boolean tracked;
	private int routeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
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
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	@Override
	public String toString() {
		return "Package [id=" + id + ", senderId=" + senderId + ", receiverId=" + receiverId + ", name=" + name
				+ ", description=" + description + ", senderCity=" + senderCity + ", receiverCity=" + receiverCity
				+ ", tracked=" + tracked + ", routeId=" + routeId + "]";
	}
	
	

}
