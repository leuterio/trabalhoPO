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
        System.out.println("SIZE\tTYPE\tAVERAGE TIME\t\t\tSORT METHOD");
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
                    Sort.shellsort(vector);
                    //save to file
                    Reader.save(vector, "shellsort" + size + type + ".txt");
                }
                String x = "hello";
                time = (System.currentTimeMillis() - time) / loops;
                //save this time
                System.out.println(size+"\t"+(size.length()==3?"\t":"")+type+"\t"+(type.length()==3?"\t":"")+time+"ms\t\t\t\t"+(time<10?"\t":"")+"shellsort");

                //quicksort
                vector = new Item[Integer.parseInt(size)];
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) {
                    //read to vector
                    Reader.read(vector, filename);
                    //apply quicksort
                    Sort.quicksort(vector);
                    //save to file
                    Reader.save(vector, "quicksort" + size + type + ".txt");
                }
                time = (System.currentTimeMillis() - time) / loops;
                //save this time
                System.out.println(size+"\t"+(size.length()==3?"\t":"")+type+"\t"+(type.length()==3?"\t":"")+time+"ms\t\t\t\t"+(time<10?"\t":"")+"quicksort");

                //heapsort
                vector = new Item[Integer.parseInt(size)];
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) {
                    //read to vector
                    Reader.read(vector, filename);
                    //apply heapsort
                    Sort.heapsort(vector);
                    //save to file
                    Reader.save(vector, "heapsort" + size + type + ".txt");
                }
                time = (System.currentTimeMillis() - time) / loops;
                //save this time
                System.out.println(size+"\t"+(size.length()==3?"\t":"")+type+"\t"+(type.length()==3?"\t":"")+time+"ms\t\t\t\t"+(time<10?"\t":"")+"heapsort");

                //quicksort w/ direct insertion
                vector = new Item[Integer.parseInt(size)];
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) {
                    //read to vector
                    Reader.read(vector, filename);
                    //apply quicksortInsertionSort
                    Sort.quicksortInsertionSort(vector);
                    //save to file
                    Reader.save(vector, "quicksortInsertionSort" + size + type + ".txt");
                }
                time = (System.currentTimeMillis() - time) / loops;
                //save this time
                System.out.println(size+"\t"+(size.length()==3?"\t":"")+type+"\t"+(type.length()==3?"\t":"")+time+"ms\t\t\t\t"+(time<10?"\t":"")+"quicksort with insertion sort");
            }
        }
        System.out.println("\n\nSORTING DONE");


        //search
        String searches[] = {"shellsort", "quicksort", "heapsort", "quicksortInsertionSort"};
        String searchFile = searches[(int) Math.random() * searches.length] + sizes[(int) Math.random() * sizes.length] + types[(int) Math.random() * types.length] + ".txt";
        System.out.println(searchFile);

        //TODO: SEARCH FOR CITY AND SAVE ALL ITS CITIZENS OR RETURN "MUNICÍPIO INEXISTENTE" MESSAGE
        System.out.println("TODO THE FREAKING REST");
    }
}
