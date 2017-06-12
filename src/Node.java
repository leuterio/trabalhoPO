
public class Node {
    private Item info;
    private Node next;

    public Node(Item info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return this;
    }

    public Item getInfo() {
        return info;
    }

    public Node setInfo(Item info) {
        this.info = info;
        return this;
    }

    @Override
    public String toString() {
        return this.getInfo().getName() + "; " + this.getInfo().getCpf() + "; " + this.getInfo().getCity() + "; ";
    }

}
