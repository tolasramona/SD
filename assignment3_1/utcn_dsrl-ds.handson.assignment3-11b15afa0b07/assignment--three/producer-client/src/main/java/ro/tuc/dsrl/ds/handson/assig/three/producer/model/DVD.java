package ro.tuc.dsrl.ds.handson.assig.three.producer.model;


public class DVD {

	private int id;
	private String title;
	private int year;
	private double price;
	public DVD(int id,String title, int year, double price) {
		super();
		this.id=id;
		this.title = title;
		this.year = year;
		this.price = price;
	}
	public DVD(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "DVD [title=" + title + ", year=" + year + ", price=" + price + "]";
	}
	
	

}
