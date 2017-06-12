
public class Sort {
    public static void quicksort(Item[] list) {
        quicksortAux(list, 0, list.length - 1);
    }

    private static void quicksortAux(Item[] list, int left, int right) {
        int i = left, j = right;
        long pivot;
        pivot = list[(i + j) >> 1].getCpf();

        while (i <= j) {
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

        if (left < j) quicksortAux(list, left, j);
        if (right > i) quicksortAux(list, i, right);
    }

    public static void shellsort(Item[] list) {
        int i, j, h = 1;
        Item temp;
        do h = 3 * h + 1;
        while (h < list.length);

        do {
            h = h / 3;
            for (i = h; i < list.length; i++) {
                temp = list[j = i]; //perhaps "temp = list[j=i];" and remove the line below
                while (list[j - h].getCpf() > temp.getCpf()) {
                    list[j] = list[j - h];
                    j -= h;
                    if (j < h) break;
                }
                list[j] = temp;
            }
        } while (h != 1);
    }


    public static void heapsort(Item[] list) {
        int right = list.length - 1;
        int left = (right - 1) >> 1;
        Item temp;
        while (left >= 0) heapsortAux(list, left--, list.length - 1);
        while (right > 0) {
            temp = list[0];
            list[0] = list[right];
            list[right--] = temp;
            heapsortAux(list, 0, right);
        }
    }

    private static void heapsortAux(Item[] list, int left, int right) {
        int i = left;
        int greaterChild = 2 * i + 1;
        Item root = list[i];
        boolean heap = false;
        while (greaterChild <= right && !heap) {
            if (greaterChild < right && list[greaterChild].getCpf() < list[greaterChild + 1].getCpf())
                greaterChild++;
            if (root.getCpf() < list[greaterChild].getCpf()) {
                list[i] = list[greaterChild];
                i = greaterChild;
                greaterChild = 2 * i + 1;
            } else heap = true;
        }
        list[i] = root;
    }

    public static void quicksortInsertionSort(Item[] list) {
        quicksortInsertionSortAux(list, 0, list.length - 1);
    }

    private static void quicksortInsertionSortAux(Item[] list, int left, int right) {
        int i = left, j = right;
        long pivot;
        pivot = list[(i + j) >> 1].getCpf();

        while (i <= j) {
            while (list[i].getCpf() < pivot) i++;
            while (list[j].getCpf() > pivot) j--;
            if (i <= j) {
                Item tmp;
                tmp = list[i];
                list[i++] = list[j];
                list[j--] = tmp;
            }
        }

        if (left < j)
            if (j - left < 25) insertionSort(list, left, j);
            else quicksortInsertionSortAux(list, left, j);
        if (right > i)
            if (right - i < 25) insertionSort(list, i, right);
            else quicksortInsertionSortAux(list, i, right);
    }

    private static void insertionSort(Item[] list, int left, int right) {
        int i, j;
        Item temp;
        for (i = left + 1; i < right - left + 1; i++) {
            temp = list[i];
            j = i - 1;
            while (j >= 0 && list[j].getCpf() > temp.getCpf()) list[j + 1] = list[j--];
            list[j + 1] = temp;
        }
    }


	/*public static void quickInsert (Item[] list) {
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
    }*/
}
