/*
    Name:           Sehee Jang
    Student ID:     0133152
    Date:           Feb 18, 2022
    Class:          CS235 Data Structures and Algorithms
    Instructor:     Daniel Oliveira

    Description:    Queue (using LinkedList)


    I pledge that the work done here was my own and that I have learned how to write this program, such that I could
    throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand,
    describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for
    its authenticity. (Sehee Jang)

*/

package edu.ensign.cs235.queue;

public class QueueOnLinkedList_driver<T> {
	public static void main(String[] args) {
		QueueOnLinkedList<Integer> queue_ll = new QueueOnLinkedList<Integer>();
		assert queue_ll.is_empty();

		for (int value = 1; value < 11; value++) {
			queue_ll.enqueue(value);
		}

		System.out.println("Added to the Queue:");
		System.out.println(queue_ll);
		System.out.println("Queue size: " + queue_ll.get_size());

		assert (queue_ll.get_size() == 10);
		assert (queue_ll.dequeue() == 1);
		assert (queue_ll.peek_front() == 2);
		assert (queue_ll.peek_rear() == 10);

		System.out.println("\nAfter queue operations:");
		System.out.println(queue_ll);

		queue_ll.clear();
		assert queue_ll.is_empty();
		System.out.println("\nCleaned up the Queue:");
		System.out.println("Queue size: " + queue_ll.get_size());

		System.out.println(queue_ll);
	}
}
