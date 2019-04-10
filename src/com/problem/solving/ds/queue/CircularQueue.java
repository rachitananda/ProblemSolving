package com.problem.solving.ds.queue;

public class CircularQueue {
	int front, rear, size, capacity;
	int arr[];

	CircularQueue(int max) {
		capacity = max;
		front = -1;
		rear = -1;
		size = 0;
		arr = new int[capacity];
	}

	void enqueue(int item) {

		if (isEmpty()) {
			rear++;
			front = rear;
			arr[rear] = item;
			size++;
		} else if (!isFull()) {
			arr[rearIncrement()] = item;
			size++;
		}
		System.out.println("\nenqueue");
		print();
	}

	void dequeue() {

		if (!isEmpty()) {
			if (rear == front) {
				// 1 item
				front = -1;
				rear = -1;
			}

			// front++;
			frontInccrement();
			size--;
		}
		System.out.println("\ndequeue");
		print();
	}

	void print() {
		if (isEmpty()) {
			System.out.println("empty");
			return;
		}
		if (rear >= front) {
			for (int i = front; i <= rear; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		if (rear < front) {
			for (int i = front; i < capacity; i++) {
				System.out.print(arr[i] + " ");
			}
			for (int j = 0; j <= rear; j++) {
				System.out.print(arr[j] + " ");
			}
		}
	}

	boolean isEmpty() {
		return (rear == -1 && front == -1);
	}

	boolean isFull() {
		return size == capacity;
	}

	int rearIncrement() {

		if (rear == capacity - 1) {
			rear = 0;
		} else {
			rear++;
		}
		return rear;
	}

	int frontInccrement() {
		if (front == capacity - 1) {
			front = 0;
		} else {
			front++;
		}
		return front;
	}
}
