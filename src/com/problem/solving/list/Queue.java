package com.problem.solving.list;

import com.problem.solving.ProblemI;
import com.problem.solving.Utils;

/**
 * Queue- FIFO with array
 * 
 * @author rachita
 *
 */
public class Queue implements ProblemI {
	int capacity = 10;
	private int arr[] = new int[capacity];

	int start = -1;
	int size = 0;
	int end = -1;

	@Override
	public void execute() {

		System.out.println(getClass().getSimpleName());
		enqueue(1);
//		enqueue(2);
//		enqueue(3);
		dequeue();
		enqueue(2);
		enqueue(3);
		dequeue();

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
