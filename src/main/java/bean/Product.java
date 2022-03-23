package bean;

public class Product implements java.io.Serializable{
	private int id;
	private String name;
	private int price;
	private String image;
	private String detail;
	private int genre;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getImage() {
		return image;
	}
	public String getDetail() {
		return detail;
	}
	public int getGenre() {
		return genre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setImage(String image) {
		this.image= image;
	}
	public void setDetail(String detail) {
		this.detail= detail;
	}
	public void setGenre(int genre) {
		this.genre=genre; 
	}
}
