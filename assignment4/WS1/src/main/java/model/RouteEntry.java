package model;

public class RouteEntry {

	private int id;
	private String City;
	private long time;
	private Package packageOfRote;
	
	
	public Package getPackageOfRote() {
		return packageOfRote;
	}
	public void setPackageOfRote(Package packageOfRote) {
		this.packageOfRote = packageOfRote;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "RouteEntry [City=" + City + ", time=" + time + "]";
	}
	
	
	
	
}
