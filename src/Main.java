public class Main {
    private static Item[] data;

    public static void main(String[] args) {
        long time;
        int loops = 5;
        Item vector[];
        String sizes[] = {"500", "1000", "5000", "10000", "50000"}, types[] = {"alea", "inv", "ord"};
        System.out.println("SIZE\tTYPE\tAVERAGE TIME\t\t\tSORT METHOD");
        for (String size : sizes) {
            for (String type : types) {
                String filename = "registros" + size + type;

                //shellsort
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.shellsort(Reader.read(filename)), "shellsort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + "\t" + (size.length() == 3 ? "\t" : "") + type + "\t" + (type.length() == 3 ? "\t" : "") + time + "ms\t\t\t\t" + (time < 10 ? "\t" : "") + "shellsort");

                //quicksort
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.quicksort(Reader.read(filename)), "quicksort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + "\t" + (size.length() == 3 ? "\t" : "") + type + "\t" + (type.length() == 3 ? "\t" : "") + time + "ms\t\t\t\t" + (time < 10 ? "\t" : "") + "quicksort");

                //heapsort
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.heapsort(Reader.read(filename)), "heapsort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + "\t" + (size.length() == 3 ? "\t" : "") + type + "\t" + (type.length() == 3 ? "\t" : "") + time + "ms\t\t\t\t" + (time < 10 ? "\t" : "") + "heapsort");

                //quicksort w/ direct insertion
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.quicksortInsertionSort(Reader.read(filename)), "quicksortInsertionSort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + "\t" + (size.length() == 3 ? "\t" : "") + type + "\t" + (type.length() == 3 ? "\t" : "") + time + "ms\t\t\t\t" + (time < 10 ? "\t" : "") + "quicksort with insertion sort");
            }
        }
        System.out.println("\n\nSORTING DONE\n\n\n\n");


        //search
        //searching only files with 500, 1000 and 5000 registers due to stack overflow issues caused by recursion in ABB search method
        String[] searches = {"shellsort", "quicksort", "heapsort", "quicksortInsertionSort"}, cityList, searchSizes = {"500", "1000", "5000"};
        String randSize = searchSizes[(int) (Math.random() * searchSizes.length)];
        String searchFile = searches[(int) (Math.random() * searches.length)] + randSize + types[(int) (Math.random() * types.length)];
        System.out.println("Searching on file: " + searchFile);
        cityList = Reader.getCityList();
        time = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) Reader.save(Search.binSearch(Reader.readOutput(searchFile), cityList), "binarySearch");
        System.out.println("binSearch = " + (System.currentTimeMillis() - time) / loops + "ms");

        //ABB
        time = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) Reader.save(Reader.read(new ABB(), searchFile).balance().search(cityList), "ABB");
        System.out.println("ABB = " + (System.currentTimeMillis() - time) / loops + "ms");

        //AVL
        time = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) Reader.save(Reader.read(new AVL(), searchFile).search(cityList), "AVL");
        System.out.println("AVL = " + (System.currentTimeMillis() - time) / loops + "ms");

        //Hashing
        time = System.currentTimeMillis();
        for (int i = 0; i < loops; i++) Reader.save(Reader.read(new Hashing(Integer.parseInt(randSize)), searchFile).search(cityList), "Hashing");
        System.out.println("Hashing = " + (System.currentTimeMillis() - time) / loops + "ms");
    }
}
