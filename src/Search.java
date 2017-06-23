public class Search {
	public static String[] binSearch(Item[] vector, String[] cities) {
		String[] lines = new String[cities.length];
		for (int i = 0; i < cities.length; i++) lines[i] = binSearchAux(vector, cities[i]);
		return lines;
	}

	//using CRLF because works on Windows (CRLF), old Mac (CR), Linux (LF) and new Mac (LF) that was based on Linux
	private static String binSearchAux(Item[] vector, String city) {
		int center, left = 0, right = vector.length - 1;
		String citizens = "";
		while (left <= right) {
			center = (left + right) / 2;
			if (city.compareTo(vector[center].getCity()) == 0) {
				citizens += vector[center].getName();

				//check if left neighbors that have same city
				int i = center - 1;
				while (i >= 0 && city.compareTo(vector[i].getCity()) == 0) citizens += "\r\n"+vector[i--].getName();

				//check if right neighbors that have same city
				i = center + 1;
				while (i < vector.length && city.compareTo(vector[i].getCity()) == 0) citizens += "\r\n"+vector[i++].getName();
				return citizens;
			} else if (city.compareTo(vector[center].getCity()) < 0) right = center - 1;
			else left = center + 1;
		}
		return "MUNICÍPIO INEXISTENTE";
	}
}
