public class Item {
	private string name;
	private string cpf;
	private string city;
	
	public Item(string name, string cpf, string city) {
		this.cpf = cpf;
		this.name = name;
		this.city = city;
	}

	public string getName() {
		return name;
	}
	
	public void setName(string name) {
		this.name = name;
	}
	
	public string getCpf() {
		return cpf;
	}
	
	public void setCpf(string cpf) {
		this.cpf = cpf;
	}
	
	public string getCity() {
		return city;
	}
	
	public void setCity(string city) {
		this.city = city;
	}
}
