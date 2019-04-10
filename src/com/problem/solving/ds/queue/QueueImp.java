package com.problem.solving.ds.queue;

import com.problem.solving.BaseProblem;

/**
 * Queue- FIFO with array
 * enqueue(), dequeue(), isFull(), isEmpty(), front() and rear() is O(1).
 * https://www.sanfoundry.com/java-program-implement-queue/
 * https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
 * @author rachita
 * Applications of queue
 *1) When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling.
2) When data is transferred asynchronously (data not necessarily received at same rate as sent) between two processes. Examples include IO Buffers, pipes, file IO, etc.
     Queu used in BFS 
 */
public class QueueImp extends BaseProblem {
	int capacity = 10;
	private int arr[] = new int[capacity];

	int start = -1;
	int size = 0;
	int end = -1;

	@Override
	public void execute() {

		System.out.println(getClass().getSimpleName());
//		enqueue(1);
////		enqueue(2);
////		enqueue(3);
//		dequeue();
//		enqueue(2);
//		enqueue(3);
//		dequeue();
		
		CircularQueue cq= new CircularQueue(5);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		cq.enqueue(4);
		cq.enqueue(5);
		cq.enqueue(5);
		cq.dequeue();
		cq.enqueue(6);
		cq.enqueue(6);
		cq.dequeue();
		cq.enqueue(7);

	}

	private void enqueue(int item) {
		if (isEmpty()) {
			// empty
			start = 0;
			end = 0;
			arr[end] = item;
			size++;
		} else if (!isFull()) {
			arr[++end] = item;
			size++;
		}
		printQueue();
	}

	private void dequeue() {
		if (!isEmpty()) {

			if (start == end) {
				// 1 item
				start = -1;
				end = -1;
				size = 0;

			} else  {
				start++;
				size--;
			}

		}
		printQueue();

	}

	boolean isFull() {
		return (size == capacity);
	}

	boolean isEmpty() {
		return (size == 0);

	}

	private void printQueue() {
		System.out.println();
		if(isEmpty()) {
			System.out.println("Empty queue");
			return;
		}
		for (int i = start; i <= end; i++) {
			System.out.print("" + arr[i]);
		}

	}

}
