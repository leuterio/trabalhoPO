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

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public Node getRepetido() {
        return repetido;
    }

    public void setRep(Node rep) {
        this.repetido = rep;
    }

    public byte getBalanceFactor() {
        return this.balanceFactor;
    }

    public void setBalanceFactor(byte balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public Item getInfo() {
        return this.info;
    }

    @Override
    public String toString() {
        return this.getInfo().getName() + "\t" + this.getInfo().getCpf() + "\t\t" + this.getInfo().getCity();
    }
}
