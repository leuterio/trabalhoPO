/**
 * Created by rdn on 06/06/17.
 */

public class ChainedList {
    private Node first;
    private Node last;

    public ChainedList() {
        first = null;
        last = null;
    }

    public ChainedList(Item elem) {
        this.insertLast(elem);
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public boolean empty() {
        return this.first==null && true || false;
    }

    public void insertLast(Item elem) {
        Node node = new No(elem);
        if (this.empty()) this.first = node;
        else this.last.setNext(node);
        this.last = node;
    }

}
