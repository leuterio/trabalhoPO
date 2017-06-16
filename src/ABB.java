public class ABB {

    private TreeNode root;
    private int length;

    public ABB() {
        this.root = null;
        this.length = 0;
    }

    public String[] search(String[] cities) {
        String[] line = new String[cities.length];
        for (int i = 0; i < cities.length; i++) {
            line[i] = this.search(cities[i], this.root);
            if (line[i].isEmpty()) line[i] = "MUNICÍPIO INEXISTENTE";
        }
        return line;
    }

    private String search(String city, TreeNode node) {
        String str = "";
        if (node != null) {
            if (city.compareTo(node.getInfo().getCity()) < 0) str = this.search(city, node.getLeft());
            else if (city.compareTo(node.getInfo().getCity()) > 0) str = this.search(city, node.getRight());
            else str = node.getInfo().getName();
        }
        return str;
    }

    public void insert(Item elem) {
        this.root = this.insert(elem, this.root);
        this.length++;
    }

    private TreeNode insert(Item elem, TreeNode node) {
        if (node == null) {
            return (new TreeNode(elem));
        } else if (elem.getCity().compareTo(node.getInfo().getCity()) < 0 || elem.getCity().equals(node.getInfo().getCity()) && elem.getName().compareTo(node.getInfo().getName()) < 0) {
            return node.setLeft(this.insert(elem, node.getLeft()));
//            return node;
        } else {
            return node.setRight(this.insert(elem, node.getRight()));
//            return node;
        }
    }

    public Item[] centralWalkthrough() {
        Item[] sortedVector = new Item[this.length];
        int i = 0;
        return (this.centralWalkthroughAux(this.root, sortedVector, i));
    }

    private Item[] centralWalkthroughAux(TreeNode tree, Item[] sortedVector, int i) {
        if (tree != null) {
            sortedVector = this.centralWalkthroughAux(tree.getLeft(), sortedVector, i);
            sortedVector[i++] = tree.getInfo();
            sortedVector = centralWalkthroughAux(tree.getRight(), sortedVector, i);
        }
        return sortedVector;
    }

    public ABB balancedTree() {
        ABB temp = new ABB();
        Item[] sortedVector = centralWalkthrough();
        this.balance(sortedVector, temp, 0, this.length - 1);
        return temp;
    }

    private void balance(Item[] sortedVector, ABB temp, int start, int end) {
        int center;
        if (end >= start) {
            center = (start + end) >> 1;
            if (sortedVector[center] != null) {
                temp.insert(sortedVector[center]);
                this.balance(sortedVector, temp, start, center - 1);
                this.balance(sortedVector, temp, center + 1, end);
            }
        }
    }
}
