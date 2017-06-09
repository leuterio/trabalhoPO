
public class Sort {
	public static void quicksort (Item[] list) {
		quicksort(0, list.length-1, list);
	}
	
	private static void quicksort(int left, int right, Item[] list) {
		int i = left, j = right;
		long pivot;
		pivot = list[(i+j) >> 1].getCpf();
		
		while (i <= j){
			while (list[i].getCpf() < pivot) i++;
			while (list[j].getCpf() > pivot) j--;
			if (i <= j) {
                Item tmp;
				tmp = list[i];
				list[i] = list[j];
				list[j] = tmp;
				i++;
				j--;
			}
		}
		
		if (left < j) quicksort(left, j, list);
		if (right > i) quicksort(i, right, list);
	}
	
	public static void quickInsert (Item[] list) {
		quickInsert (list, 0, list.length-1);
	}
	
	private static void quickInsert (Item[] list, int left, int right) {
		int i = left, j = right;
        Item tmp;
        Long pivot = list[(i+j) >> 1].getCpf();

        while (i <= j) {
            while (list[i].getCpf() < pivot) i++;
            while (list[j].getCpf() > pivot) j--;
            if (i <= j) {
                tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
                i++;
                j--;
            }
        }

        if (left < j) {
            if (j - left > 25) quickInsert(list, left, j);
            else insertionSort(list, left, j);
        }
        if (right > i) {
            if (right - i > 25) quickInsert(list, i, right);
            else insertionSort(list, i, right);
        }
	}
	
	private static void insertionSort(Item[] list, int left, int right) {
        int i, j;
        Item tmp;
        for (i = left + 1; i <= right; i++) {
            tmp = list[i];
            j = i;
            while (j > 0 && list[j - 1].getCpf() > tmp.getCpf()) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = tmp;
        }
    }
}
