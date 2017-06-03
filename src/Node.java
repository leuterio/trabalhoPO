
public class Node {
    private Item info;
    private Node next;

    //TODO: check if it is needed
    public Node() {

    }

    public Node(Item info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Item getInfo() {
        return info;
    }

    public void setInfo(Item info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return this.getInfo().getName() + "; " + this.getInfo().getCpf() + "; " + this.getInfo().getCity() + "; ";
    }

}
