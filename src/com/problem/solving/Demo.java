package com.problem.solving;


public class Demo {

	public static void main(String[] args) {
		
		Queue queue= new Queue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
	}

	static class Queue {
		int front, rear, size, capacity;
		int arr[];
		Queue(int max) {
			capacity = max;
			front = -1;
			rear = -1;
			size=0;
			arr= new int[capacity];
		}

		void enqueue(int item){
			
			if(isEmpty()){
				rear++;
				front= rear;
			   arr[rear]=item;		
			   size++;
			}else if(!isFull()){
				arr[++rear]= item;
				   size++;
			}
			System.out.println("enqueue");
			print();
		}
		
		void dequeue(){
			
		
			if(!isEmpty()){
				if(rear==front){
					//1 item
					front= -1;
					rear=-1;
				}
				
				front++;
			}
			System.out.println("dequeue");
			print();
		}
		
		void print(){
			if(isEmpty()){
				System.out.println("empty");
				return;
			}
			for(int i= front; i<=rear;i++ ){
				System.out.print(arr[i]+" ");
			}
		}
		boolean isEmpty() {
			return rear ==-1;
		}

		boolean isFull() {
			return size == capacity;
		}
	}
}
