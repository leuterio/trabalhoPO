
public class Hashing {
    private ChainedList[] chainedVector;
    private int m;

    public void insertHashing(Item item){
        int n = (int) (item.getCpfLong() % m);
        chainedVector[n].insertEnd(item);
    }

    public Hashing(int length) {
        int t = (int) (length*1.1);
        this.m = closestPrime(t);
        this.chainedVector = new ChainedList[this.m];
        for (int i = 0; i < chainedVector.length; i++)
            chainedVector[i] = new ChainedList();

    }

    public String[] search(string[] cpfs){
        String[] line = new String[cpfs.length];
        for (int i = 0; i < cpfs.length; i++) {
            line[i] = this.search(Long.parseLong(cpfs[i]));
            if (line[i].isEmpty()) line[i] = cpfs[i] + " - CPF INEXISTENTE";
        }
        return line;
    }

    private String search(long cpf) {
        int n = (int) (cpf % this.m);
        ChainedList list = this.chainedVector[n];
        Node node = list.getFirst();
        while(node != null){
            if (node.getInfo().getCpfLong() == cpf) return node.toString();
            node = node.getNext();
        }
        return "not found";
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
        else if ((number < 2) || (number % 2 == 0) || (number % 3 == 0) || (number % 5 == 0)) return false;
        int root = (int) Math.ceil(Math.sqrt(number));
        int n, i = 3;

        do {
            n = number % i;
            if (n == 0) return false;
            i += 2;
        } while (i < root);

        return true;
    }

}
