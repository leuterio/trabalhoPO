public class Main {
    private static Item[] data;

    public static void main(String[] args) {
        long time;
        int loops = 5;
        ABB abb;
        AVL avl;
        Hashing hash;
        Item vector[];
        String sizes[] = {"500", "1000", "5000", "10000", "50000"}, types[] = {"alea", "inv", "ord"};
        for (String size : sizes) {
            for (String type : types) {
                String filename = "registros" + size + type + ".txt";

                //shellsort
                vector = new Item[Integer.parseInt(size)];
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) {
                    //read to vector
                    Reader.read(vector, filename);
                    //apply shellsort
                    //save to file
                    Reader.save(vector, "shellsort" + size + type + ".txt");
                }
                time = (System.currentTimeMillis() - time) / loops;
                //save this time

                //quicksort
                vector = new Item[Integer.parseInt(size)];
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) {
                    //read to vector
                    Reader.read(vector, filename);
                    //apply quicksort
                    //save to file
                    Reader.save(vector, "quicksort" + size + type + ".txt");
                }
                time = (System.currentTimeMillis() - time) / loops;
                //save this time

                //heapsort
                vector = new Item[Integer.parseInt(size)];
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) {
                    //read to vector
                    Reader.read(vector, filename);
                    //apply heapsort
                    //
                    //save to file
                    Reader.save(vector, "heapsort" + size + type + ".txt");
                }
                time = (System.currentTimeMillis() - time) / loops;
                //save this time

                //quicksort w/ direct insertion
                vector = new Item[Integer.parseInt(size)];
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) {
                    //read to vector
                    Reader.read(vector, filename);
                    //apply heapsort
                    //
                    //save to file
                    Reader.save(vector, "quicksortDirectInsertion" + size + type + ".txt");
                }
                time = (System.currentTimeMillis() - time) / loops;
                //save this time
            }
        }

        //search
        String searches[] = {"shellsort", "quicksort", "heapsort", "quicksortDirectInsertion"};
        String searchFile = searches[(int) Math.random() * searches.length] + sizes[(int) Math.random() * sizes.length] + types[(int) Math.random() * types.length] + ".txt";

        //TODO: SEARCH FOR CITY AND SAVE ALL ITS CITIZENS OR RETURN "MUNICÍPIO INEXISTENTE" MESSAGE
    }
}
