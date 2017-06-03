public class ABB {

    private TreeNode root;
    private int length;

    public ABB() {
        this.root = null;
        this.length = 0;
    }

    public String[] search(String[] cpfs) {
        String[] line = new String[cpfs.length];
        for (int i = 0; i < cpfs.length; i++) {
            line[i] = this.search(Long.parseLong(cpfs[i]), this.root);
            if (line[i].isEmpty()) {
                line[i] = cpfs[i] + " - CPF INEXISTENTE";
            }
        }
        return line;
    }

    //TODO: olhar de novo
    private String search(long cpf, TreeNode node) {
        String str = "";
//        double total = 0;
        if (node != null) {
            if (cpf < node.getInfo().getCpfLong())
                str = this.search(cpf, node.getLeft());
            else if (cpf > node.getInfo().getCpfLong())
                str = this.search(cpf, node.getRight());
            else str = node.toString();
            /*else {
                str = node.toString();
                total = node.getInfo().getValor();
                if (node.getRepetido() != null) {
                    No repetidos = node.getRepetido();
                    while (repetidos != null) {
                        str += repetidos.getCompra();
                        total += repetidos.getInfo().getValor();
                        repetidos = repetidos.getProx();
                    }
                }
                str += "TOTAL: " + total;
            }*/
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
        } else if (elem.getCpfLong() < node.getInfo().getCpfLong()) {
            node.setLeft(this.insert(elem, node.getLeft()));
            return node;
        } else if (elem.getCpfLong() > node.getInfo().getCpfLong()) {
            node.setRight(this.insert(elem, node.getRight()));
            return node;
        } else {
            if (node.getRepetido() == null) {
                node.setRep(new No(elem));
            } else {
                Node repetido = node.getRepetido();
                while (repetido.getProx() != null)
                    repetido = repetido.getProx();
                repetido.setProx(new No(elem));
            }
            return node;
        }
    }

    public Item[] centralWalkthrough() {
        Item[] sortedVector = new Item[this.length];
//        int[] i = new int[1];
//        i[0] = 0;
        int i = 0;
        return (this.centralWalkthroughExec(this.root, sortedVector, i));
    }

    private Item[] centralWalkthroughExec(TreeNode tree, Item[] sortedVector, int i) {
        if (tree != null) {
            sortedVector = this.centralWalkthroughExec(tree.getLeft(), sortedVector, i);
            sortedVector[i] = tree.getInfo();
            i++;
            if (tree.getRepetido() != null) {
                Node reptidos = tree.getRepetido();
                while (reptidos != null) {
                    sortedVector[i] = reptidos.getInfo();
                    i++;
                    reptidos = reptidos.getNext();
                }
            }
            sortedVector = centralWalkthroughExec(tree.getRight(), sortedVector, i);
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
            center = (start + end) / 2;
            if (sortedVector[center] != null) {
                temp.insert(sortedVector[center]);
                this.balance(sortedVector, temp, start, center - 1);
                this.balance(sortedVector, temp, center + 1, end);
            }
        }
    }
}
