
public class AVL {
    private TreeNode root;
    private boolean h;
    private int length;

    public AVL() {
        this.root = null;
        this.h = true;
        this.length = 0;
    }

    public void createRoot(Item elem) {
        this.root = this.insert(elem, this.root);
        this.length++;
    }

    private TreeNode insert(Item elem, TreeNode node) {
        if (node == null) {
            TreeNode newNode = new TreeNode(elem);
            this.h = true;
            return newNode;
        } else if (elem.getCpf() < node.getInfo().getCpf()) {
            node.setLeft(this.insert(elem, node.getLeft()));
            node = this.balanceRight(node);
            return node;
        } else {
            node.setRight(this.insert(elem, node.getRight()));
            node = this.balanceLeft(node);
            return node;
        }
    }

    private TreeNode balanceRight(TreeNode node) {
        if (this.h) {
            byte factor = node.getBalanceFactor();
            if (factor == 1) {
                node.setBalanceFactor((byte) 0);
                this.h = false;
            } else if (factor == 0) node.setBalanceFactor((byte) -1);
            else if (factor == -1) node = this.rotateRight(node);
        }
        return node;
    }

    private TreeNode balanceLeft(TreeNode node) {
        if (this.h) {
            byte factor = node.getBalanceFactor();
            if(factor == 1) node = this.rotateLeft(node);
            else if(factor == 0) node.setBalanceFactor((byte) 1);
            else if(factor == 1){
                node.setBalanceFactor((byte) 0);
                this.h = false;
            }
        }
        return node;
    }

    private TreeNode rotateRight(TreeNode node) {
        TreeNode temp1, temp2;
        temp1 = node.getLeft();
        if (temp1.getBalanceFactor() == -1) {
            node.setLeft(temp1.getRight());
            temp1.setRight(node);
            node.setBalanceFactor((byte) 0);
            node = temp1;
        } else {
            temp2 = temp1.getRight();
            temp1.setRight(temp2.getLeft());
            temp2.setLeft(temp1);
            node.setLeft(temp2.getRight());
            temp2.setRight(node);
            if (temp2.getBalanceFactor() == -1) node.setBalanceFactor((byte) 1);
            else node.setBalanceFactor((byte) 0);

            if (temp2.getBalanceFactor() == 1) temp1.setBalanceFactor((byte) -1);
            else temp1.setBalanceFactor((byte) 0);
            node = temp2;
        }
        node.setBalanceFactor((byte) 0);
        this.h = false;
        return node;
    }

    private TreeNode rotateLeft(TreeNode node) {
        TreeNode temp1, temp2;
        temp1 = node.getRight();
        if (temp1.getBalanceFactor() == 1) {
            node.setRight(temp1.getLeft());
            temp1.setLeft(node);
            node.setBalanceFactor((byte) 0);
            node = temp1;
        } else {
            temp2 = temp1.getLeft();
            temp1.setLeft(temp2.getRight());
            temp2.setRight(temp1);
            node.setRight(temp2.getLeft());
            temp2.setLeft(node);
            if (temp2.getBalanceFactor() == 1) node.setBalanceFactor((byte) -1);
            else node.setBalanceFactor((byte) 0);
            if (temp2.getBalanceFactor() == -1) temp1.setBalanceFactor((byte) 1);
            else temp1.setBalanceFactor((byte) 0);
            node = temp2;
        }
        node.setBalanceFactor((byte) 0);
        this.h = false;
        return node;
    }

    //TODO: meio redundante, já que faz o caminhamento central também, identicamente a função "centralWalkthrough"
    public Item[] sortedVector() {
        Item[] vector = new Item[this.length];
        int i = 0;
        sortedVector(this.root, vector, i);

        return vector;
    }

    private void sortedVector(TreeNode node, Item[] vector, int i) {
        if (node == null) return;

        sortedVector(node.getLeft(), vector, i);
        vector[i++] = node.getInfo();
        sortedVector(node.getRight(), vector, i);
    }

    public String[] search(String[] cpfs) {
        String[] lines = new String[cpfs.length];
        for (int i = 0; i < cpfs.length; i++) {
            lines[i] = this.search(Long.parseLong(cpfs[i]), this.root);
            if (lines[i].isEmpty()) lines[i] = cpfs[i] + " - CPF INEXISTENTE";
        }
        return lines;

    }

    private String search(long cpf, TreeNode node) {
        String str = "";
        if (node != null) {
            if (cpf < node.getInfo().getCpf()) str = this.search(cpf, node.getLeft());
            else if (cpf > node.getInfo().getCpf()) str = this.search(cpf, node.getRight());
            else str = node.toString();
        }
        return str;
    }
}
