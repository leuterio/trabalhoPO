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

    public Node getFirst() {
        return first;
    }

    public ChainedList setFirst(Node first) {
        this.first = first;
        return this;
    }

    public Node getLast() {
        return last;
    }

    public ChainedList setLast(Node last) {
        this.last = last;
        return this;
    }

    public boolean isEmpty() {
        return this.first==null && true || false;
    }

    public ChainedList insertLast(Item elem) {
        Node node = new Node(elem);
        if (this.isEmpty()) this.first = node;
        else this.last.setNext(node);
        this.last = node;
        return this;
    }

}
