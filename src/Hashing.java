public class Hashing {
    private ChainedList[] chainedVector;
    private int m;

    //summing charCodes to generate a number for the hashing function
    private int hashNumber(String city){
        int sum = 0;
        for(int i=0; i<city.length(); i++) sum += (int) city.charAt(i);
        return sum;
    }

    public void insertHashing(Item item) {
        int n = hashNumber(item.getCity()) % this.m;
        chainedVector[n].insertLast(item);
    }

    public Hashing(int length) {
        int t = (int) (length * 1.1);
        this.m = closestPrime(t);
        this.chainedVector = new ChainedList[this.m];
        for (int i = 0; i < chainedVector.length; i++) chainedVector[i] = new ChainedList();
    }

    public String[] search(String[] cities) {
        String[] line = new String[cities.length];
        for (int i = 0; i < cities.length; i++) {
            line[i] = this.search(cities[i]);
            if (line[i].isEmpty()) line[i] = "MUNICÍPIO INEXISTENTE";
        }
        return line;
    }

    private String search(String city) {
        int n = hashNumber(city) % this.m;
        ChainedList list = this.chainedVector[n];
        Node node = list.getFirst();
        String str = "";
        while (node != null) {
            if (city.equals(node.getInfo().getCity())) str += (!str.isEmpty() ? "\n" : "") + node.getInfo().getName();
            node = node.getNext();
        }
        return str;
    }

    private int closestPrime(int number) {
        if (number % 2 == 0) number--;
        int smaller = number;
        int bigger = number + 2;

        do {
            if (isPrime(smaller)) return smaller;
            if (isPrime(bigger)) return bigger;
            smaller -= 2;
            bigger += 2;
        } while (true);
    }

    private boolean isPrime(int number) {
        if (number == 2 || number == 3 || number == 5) return true;
        else if (number < 2 || number % 2 == 0 || number % 3 == 0 || number % 5 == 0) return false;
        int root = (int) Math.ceil(Math.sqrt(number)), n, i = 3;

        do {
            n = number % i;
            if (n == 0) return false;
            i += 2;
        } while (i < root);

        return true;
    }

}
