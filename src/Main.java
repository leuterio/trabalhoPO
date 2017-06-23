import java.io.IOException;

public class Main {
    private static Item[] data;

    public static void main(String[] args) {
        long time;
        int loops = 5;
        Item vector[];
        String sizes[] = {"500", "1000", "5000", "10000", "50000"}, types[] = {"alea", "inv", "ord"};
        System.out.println("SIZE; TYPE; AVERAGE TIME; SORT METHOD");
        for (String size : sizes) {
            for (String type : types) {
                String filename = "registros" + size + type;

                //shellsort
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.shellsort(Reader.read(filename)), "shellsort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + ";  " + type + "; " + time + "ms; shellsort");

                //quicksort
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.quicksort(Reader.read(filename)), "quicksort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + ";  " + type + "; " + time + "ms; quicksort");

                //heapsort
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.heapsort(Reader.read(filename)), "heapsort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + ";  " + type + "; " + time + "ms; heapsort");

                //quicksort w/ direct insertion
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Sort.quicksortInsertionSort(Reader.read(filename)), "quicksortInsertionSort" + size + type);
                time = (System.currentTimeMillis() - time) / loops;
                System.out.println(size + ";  " + type + "; " + time + "ms; quicksort with insertion sort");
            }
        }
        System.out.println("\n\nSORTING DONE\n\n\n\n");


        //search
        //searching only files with 500, 1000 and 5000 registers due to stack overflow issues caused by recursion in ABB search method

        String[] searches = {"shellsort", "quicksort", "heapsort", "quicksortInsertionSort"}, cityList;
        for (String size : sizes) {
            String searchFile = searches[(int) (Math.random() * searches.length)] + size + types[(int) (Math.random() * types.length)];
            System.out.println("Searching on file: " + searchFile);
            cityList = Reader.getCityList();
            try {
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Search.binSearch(Reader.readOutput(searchFile), cityList), "binarySearch" + size);
                System.out.println("binSearch" + size + " = " + (System.currentTimeMillis() - time) / loops + "ms");
            } catch (StackOverflowError e) {
                System.out.println("binSearch" + size + " = Error: " + e.toString());
            }

            //ABB
            try {
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Reader.read(new ABB(), searchFile).balance().search(cityList), "ABB" + size);
                System.out.println("ABB" + size + " = " + (System.currentTimeMillis() - time) / loops + "ms");
            } catch (StackOverflowError e) {
                System.out.println("ABB" + size + " = Error: " + e.toString());
            }

            //AVL
            try {
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Reader.read(new AVL(), searchFile).search(cityList), "AVL" + size);
                System.out.println("AVL" + size + " = " + (System.currentTimeMillis() - time) / loops + "ms");
            } catch (StackOverflowError e) {
                System.out.println("AVL" + size + " = Error: " + e.toString());
            }

            //Hashing
            try {
                time = System.currentTimeMillis();
                for (int i = 0; i < loops; i++) Reader.save(Reader.read(new Hashing(Integer.parseInt(size)), searchFile).search(cityList), "Hashing" + size);
                System.out.println("Hashing" + size + " = " + (System.currentTimeMillis() - time) / loops + "ms");
            } catch (StackOverflowError e) {
                System.out.println("Hashing" + size + " = Error: " + e.toString());
            }
        }
    }
}
