import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Reader {
	
	private static final String INPUT = "./src/files/input/";
	private static final String OUTPUT = "./src/files/output/";
	
	public static void read(Item[] dataVector, String file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(INPUT + file)));
			String line = "";
			String values[];
			int i = 0;
			while ((line = in.readLine()) != null) {
				values = line.split(";");
				dataVector[i] = new Item(values[0], values[1], values[2]);
				i++;
			}
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read(ABB tree, String file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT + file)));
			String line = "";
			String values[];

			while ((line = in.readLine()) != null) {
				values = line.split(";");
				tree.insert(new Item(values[0], values[1], values[2]));
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read(AVL tree, String file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT + file)));
			String line = "";
			String values[];
			
			while ((line = in.readLine()) != null) {
				values = line.split(";");
				tree.createRoot(new Item(values[0], values[1], values[2]));
			}
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read(Hashing hash, String file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(OUTPUT + file)));
			String line = "";
			String values[];
			
			while ((line = in.readLine()) != null) {
				values = line.split(";");
				hash.insertHashing(new Item(values[0], values[1], values[2]));
			}
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void read(String[] vectorCPF) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(INPUT + "cpf.txt"));
			String line = "";
			int i = 0;
			
			while ((line = in.readLine()) != null) {
				vectorCPF[i] = line;
				i++;
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void save(Item[] data, String file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(OUTPUT + file)));
			for (int i = 0; i < data.length && data[i] != null; i++) {
				out.write(data[i].getName() + ";" 
						+ data[i].getCpf() + ";" 
						+ data[i].getCity());
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void save(String[] data, String file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(OUTPUT + file + ".txt")));
			for (int i = 0; i < data.length; i++) {
				out.write(data[i]);
				out.newLine();
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}