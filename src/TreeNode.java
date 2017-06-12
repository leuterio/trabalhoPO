import sun.reflect.generics.tree.Tree;

/**
 * Created by rdn on 03/06/17.
 */
public class TreeNode {
    private Item info;
    private TreeNode left, right;
    private Node repetido;
    private byte balanceFactor;

    public TreeNode(Item info) {
        this.info = info;
        this.balanceFactor = 0;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    /*public Node getRepetido() {
        return repetido;
    }*/

    /*public void setRep(Node rep) {
        this.repetido = rep;
    }*/

    public byte getBalanceFactor() {
        return this.balanceFactor;
    }

    public TreeNode setBalanceFactor(byte balanceFactor) {
        this.balanceFactor = balanceFactor;
        return this;
    }

    public Item getInfo() {
        return this.info;
    }

    @Override
    public String toString() {
        return this.getInfo().getName() + "\t" + this.getInfo().getCpf() + "\t\t" + this.getInfo().getCity();
    }
}
