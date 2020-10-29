package pt.pa.adts;

/**
 * Defines a queue data structure type
 *
 * @param <T> The queue element type
 */
public interface Queue<T> {

    /**
     * Enqueues a new element in the queue
     *
     * @param element The element to enqueue
     * @throws FullQueueException When the queue is full
     */
    void enqueue(T element) throws FullQueueException;

    /**
     * Dequeues the oldest element in the queue, according to the enqueuing order. The element is removed and returned
     *
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    T dequeue() throws EmptyQueueException;

    /**
     * Returns the oldest element in the queue, according to the enqueuing order. The element is not removed
     *
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    T front() throws EmptyQueueException;

    /**
     * Returns the number of elements in the queue
     * @return The queue size
     */
    int size();

    /**
     * Check if the queue is empty
     *
     * @return True if its empty or False if it isnt empty
     */
    boolean isEmpty();

    /**
     * Remove all elements from the queue
     */
    void clear();

}

