public class Item {
	private String name;
	private String cpf;
	private String city;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String name, String cpf, String city) {
		this.cpf = cpf;
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
}
