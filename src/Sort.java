public class Sort {
    private static boolean leftCondition(Item a, Item b) {
        return a.getCity().compareTo(b.getCity()) < 0 || a.getCity().equals(b.getCity()) && a.getName().compareTo(b.getName()) < 0;
    }

    private static boolean rightCondition(Item a, Item b) {
        return a.getCity().compareTo(b.getCity()) > 0 || a.getCity().equals(b.getCity()) && a.getName().compareTo(b.getName()) > 0;
    }

    public static Item[] quicksort(Item[] list) {
        quicksortAux(list, 0, list.length - 1);
        //return itself for chaining
        return list;
    }

    private static void quicksortAux(Item[] list, int left, int right) {
        int i = left, j = right;
        Item pivot = list[(i + j) / 2];

        while (i <= j) {
            while (leftCondition(list[i], pivot)) i++;
            while (rightCondition(list[j], pivot)) j--;
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
        int left = (right - 1) / 2;
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
            if (greaterChild < right && leftCondition(list[greaterChild], list[greaterChild + 1])) greaterChild++;
            if (leftCondition(root, list[greaterChild])) {
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
        Item pivot = list[(i + j) / 2];

        while (i <= j) {
            while (leftCondition(list[i], pivot)) i++;
            while (rightCondition(list[j], pivot)) j--;
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
        for (i = left + 1; i <= right; i++) {
            temp = list[j = i];
            j--;
            while (j >= 0 && rightCondition(list[j], temp)) list[j + 1] = list[j--];
            list[j + 1] = temp;
        }
    }
}
