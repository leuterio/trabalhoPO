public class Search {
    public static String[] binarySearch(Item[] city, long[] cpf) {
        String[] line = new String[200];
        for (int i = 0; i < 200; i++) line[i] = binarySearch(city, cpf[i]);
        return line;
    }

    private static String binarySearch(Item[] items, long cpf) {
        int center, left = 0, right = items.length - 1;
        while (left <= right) {
            center = (left + right) / 2;

            if (cpf == items[center].getCpf()) return items[center].toString();
            else if (cpf < items[center].getCpf()) right = center - 1;
            else left = center + 1;
        }
        return (cpf + " - CPF INEXISTENTE");
    }
}
