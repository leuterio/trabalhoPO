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

    public boolean empty() {
        return this.first==null && true || false;
    }

    public ChainedList insertLast(Item elem) {
        Node node = new Node(elem);
        if (this.empty()) this.first = node;
        else this.last.setNext(node);
        this.last = node;
        return this;
    }

}
