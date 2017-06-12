public class Search {
    public static String[] binarySearch(Item[] city, String[] cpf) {
        String[] line = new String[200];
        for (int i = 0; i < 200; i++) line[i] = binarySearch(city, cpf[i]);
        return line;
    }

    private static String binarySearch(Item[] items, String cpf) {
        int center, left = 0, right = items.length - 1;
        String foundCpf = "";

        while (left <= right) {
            center = (left + right) / 2;

            if (Long.parseLong(cpf) == items[center].getCpf()) {
                foundCpf +=  items[center].getName() + "\t"+ cpf + "\t" + items[center].getCity();

                /*//ANDA COM O VETOR PARA A ESQUERDA PARA VERIFICAR SE EXISTE OUTRO ELEMENTO COM O MESMO CPF
                int i;
                i = center - 1;
                while (i >= 0 && Long.parseLong(cpf) == items[i].getCpfLong()) {
                    foundCpf += items[i].getCity() + "\r\n";
                    i--;
                }

                //ANDA COM O VETOR PARA A DIREITA PARA VERIFICAR SE EXISTE OUTRO ELEMENTO COM O MESMO CPF
                i = center + 1;
                while (i < items.length && Long.parseLong(cpf) == items[i].getCpfLong()) {
                    foundCpf += items[i].getData() + "\t"
                            + items[i].getValor() + "\r\n";
                    total += items[i].getValor();
                    i++;
                }
                foundCpf += "TOTAL: " + total;
                return foundCpf;
*/
            }
            else if (Long.parseLong(cpf) < items[center].getCpf()) right = center - 1;
            else left = center + 1;
        }
        return (cpf + " - CPF INEXISTENTE");
    }

}
