import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Reader {

    private static final String INPUT = "./src/files/input/";
    private static final String OUTPUT = "./src/files/output/";

    public static Item[] read(String file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(INPUT + file + ".txt")));
            String line = "", values[];
            Item dataVector[] = new Item[Integer.parseInt(file.replaceAll("\\D+", ""))];
            int i = 0;
            while ((line = in.readLine()) != null) {
                values = line.split(";");
                dataVector[i++] = new Item(values[0], values[1], values[2]);
            }
            in.close();
            return dataVector;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Item[] readOutput(String file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT + file + ".txt")));
            String line = "", values[];
            Item dataVector[] = new Item[Integer.parseInt(file.replaceAll("\\D+", ""))];
            int i = 0;
            while ((line = in.readLine()) != null) {
                values = line.split(";");
                dataVector[i++] = new Item(values[0], values[1], values[2]);
            }
            in.close();
            return dataVector;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ABB read(ABB tree, String file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT + file + ".txt")));
            String line = "";
            String values[];

            while ((line = in.readLine()) != null) {
                values = line.split(";");
                tree.insert(new Item(values[0], values[1], values[2]));
            }
            in.close();
            return tree;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AVL read(AVL tree, String file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT + file + ".txt")));
            String line = "";
            String values[];

            while ((line = in.readLine()) != null) {
                values = line.split(";");
                tree.insert(new Item(values[0], values[1], values[2]));
            }
            in.close();
            return tree;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Hashing read(Hashing hash, String file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT + file + ".txt")));
            String line = "";
            String values[];

            while ((line = in.readLine()) != null) {
                values = line.split(";");
                hash.insertHashing(new Item(values[0], values[1], values[2]));
            }

            in.close();
            return hash;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String[] getCityList() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(INPUT + "pesquisa.txt"));
            String line = "", cityList[] = new String[200];
            int i = 0;
            while ((line = in.readLine()) != null) cityList[i++] = line;
            in.close();
            return cityList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void save(Item[] data, String file) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(OUTPUT + file + ".txt")));
            for (int i = 0; i < data.length && data[i] != null; i++) {
                out.write(data[i].getName() + ";"
                        + data[i].getCpf() + ";"
                        + data[i].getCity());
                out.newLine();
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(String[] data, String file) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(new File(OUTPUT + file + ".txt")));
            for (int i = 0; i < data.length; i++) {
                out.write(data[i]);
                out.newLine();
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}