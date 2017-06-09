public class Item {
    private String name;
    private long cpf;
    private String city;

    public Item(String name, long cpf, String city) {
        this.cpf = cpf;
        this.name = name;
        this.city = city;
    }

    public Item(String name, String cpf, String city){
        this.cpf = Long.parseLong(cpf);
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public long getCpf() {
        return cpf;
    }

    public Item setCpf(String cpf) {
        this.cpf = Long.parseLong(cpf);
        return this;
    }

    public Item setCpf(long cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Item setCity(String city) {
        this.city = city;
        return this;
    }
}
