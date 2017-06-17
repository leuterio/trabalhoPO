public class ABB {

    private TreeNode root;
    private int length;

    public ABB() {
        this.root = null;
        this.length = 0;
    }

    private Boolean leftCondition(Item a, Item b) {
        return a.getCity().compareTo(b.getCity()) < 0 || a.getCity().equals(b.getCity()) && a.getName().compareTo(b.getName()) < 0;
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
            else {
                str += node.getInfo().getName();
                String left = search(city, node.getLeft());
                if (!left.isEmpty()) str += "\n" + left;
                String right = search(city, node.getRight());
                if (!right.isEmpty()) str += "\n" + right;
            }
        }
        return str;
    }

    public void insert(Item elem) {
        this.root = this.insert(elem, this.root);
        this.length++;
    }

    private TreeNode insert(Item elem, TreeNode node) {
        if (node == null) return new TreeNode(elem);
        else if (leftCondition(elem, node.getInfo())) return node.setLeft(this.insert(elem, node.getLeft()));
        return node.setRight(this.insert(elem, node.getRight()));
    }

    public Item[] centralWalkthrough() {
        Item[] sortedVector = new Item[this.length];
        return (this.centralWalkthroughAux(this.root, sortedVector, 0));
    }

    private Item[] centralWalkthroughAux(TreeNode tree, Item[] sortedVector, int i) {
        if (tree != null) {
            sortedVector = this.centralWalkthroughAux(tree.getLeft(), sortedVector, i);
            sortedVector[i++] = tree.getInfo();
            sortedVector = centralWalkthroughAux(tree.getRight(), sortedVector, i);
        }
        return sortedVector;
    }

    public ABB balance() {
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
