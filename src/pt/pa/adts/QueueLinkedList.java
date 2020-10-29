package pt.pa.adts;

/**
 * Doubly linked list implementation of the queue data structure
 *
 * @param <T> The queue element type
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;
    private int capacity;

    /**
     * Creates a new doubly linked list based queue.
     */
    public QueueLinkedList(int cap) {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.next = trailer;
        size = 0;
        capacity = cap;
    }

    /**
     * Enqueues a new element in the queue
     *
     * @param element The element to enqueue
     * @throws FullQueueException When the queue is full
     */
    public void enqueue(T element) throws FullQueueException {
        if(size() == capacity)
            throw new FullQueueException();
        Node node = new Node(element, header, header.next);
        header.next.prev = node; //red
        header.next = node;
        size++;
    }

    /**
     * Dequeues the oldest element in the queue, according to the enqueuing order. The element is removed and returned
     *
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        }

        Node node = trailer.prev;
        node.prev.next = trailer;
        trailer.prev = node.prev;
        size--;

        return node.element;
    }

    /**
     * Returns the oldest element in the queue, according to the enqueuing order. The element is not removed
     *
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    public T front() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return trailer.prev.element;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return The queue size
     */
    public int size() {
        return size;
    }

    /**
     * Check if the queue is empty
     *
     * @return True if its empty or False if it isnt empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Remove all elements from the queue
     */
    public void clear() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.next = trailer;
        size = 0;
    }

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
