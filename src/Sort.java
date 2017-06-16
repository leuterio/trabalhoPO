public class Sort {
    public static Item[] quicksort(Item[] list) {
        quicksortAux(list, 0, list.length - 1);

        //return itself for chaining
        return list;
    }

    private static void quicksortAux(Item[] list, int left, int right) {
        int i = left, j = right;
        Item pivot = list[(i + j) >> 1];

        while (i <= j) {
            while (list[i].getCity().compareTo(pivot.getCity()) < 0 || list[i].getCity().equals(pivot.getCity()) && list[i].getName().compareTo(pivot.getName()) < 0)
                i++;
            while (list[j].getCity().compareTo(pivot.getCity()) > 0 || list[j].getCity().equals(pivot.getCity()) && list[j].getName().compareTo(pivot.getName()) > 0)
                j--;
            if (i <= j) {
                Item tmp;
                tmp = list[i];
                list[i++] = list[j];
                list[j--] = tmp;
            }
        }

        if (left < j) quicksortAux(list, left, j);
        if (right > i) quicksortAux(list, i, right);
    }

    public static Item[] shellsort(Item[] list) {
        int i, j, h = 1;
        Item temp;
        do h = 3 * h + 1;
        while (h < list.length);

        do {
            h = h / 3;
            for (i = h; i < list.length; i++) {
                temp = list[j = i];
                while (list[j - h].getCity().compareTo(temp.getCity()) > 0) {
                    list[j] = list[j - h];
                    j -= h;
                    if (j < h) break;
                }
                list[j] = temp;
            }
        } while (h != 1);

        //return itself for chaining
        return list;
    }


    public static Item[] heapsort(Item[] list) {
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

        //return itself for chaining
        return list;
    }

    private static void heapsortAux(Item[] list, int left, int right) {
        int i = left;
        int greaterChild = 2 * i + 1;
        Item root = list[i];
        boolean heap = false;
        while (greaterChild <= right && !heap) {
            if (greaterChild < right && (list[greaterChild].getCity().compareTo(list[greaterChild + 1].getCity()) < 0 || list[greaterChild].getCity().equals(list[greaterChild + 1].getCity()) && list[greaterChild].getName().compareTo(list[greaterChild + 1].getName()) < 0))
                greaterChild++;
            if (root.getCity().compareTo(list[greaterChild].getCity()) < 0 || root.getCity().equals(list[greaterChild].getCity()) && root.getName().compareTo(list[greaterChild].getName()) < 0) {
                list[i] = list[greaterChild];
                i = greaterChild;
                greaterChild = 2 * i + 1;
            } else heap = true;
        }
        list[i] = root;
    }

    public static Item[] quicksortInsertionSort(Item[] list) {
        quicksortInsertionSortAux(list, 0, list.length - 1);
        //return itself for chaining
        return list;
    }

    private static void quicksortInsertionSortAux(Item[] list, int left, int right) {
        int i = left, j = right;
        Item pivot = list[(i + j) >> 1];

        while (i <= j) {
            while (list[i].getCity().compareTo(pivot.getCity()) < 0 || list[i].getCity().equals(pivot.getCity()) && list[i].getName().compareTo(pivot.getName()) < 0)
                i++;
            while (list[j].getCity().compareTo(pivot.getCity()) > 0 || list[j].getCity().equals(pivot.getCity()) && list[j].getName().compareTo(pivot.getName()) > 0)
                j--;
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
            while (j >= 0 && (list[j].getCity().compareTo(temp.getCity()) > 0 || list[j].getCity().equals(temp.getCity()) && list[j].getName().compareTo(temp.getName()) > 0))
                list[j + 1] = list[j--];
            list[j + 1] = temp;
        }
    }
}
