
public class Queue {
	public int A[]=new int[1000];
	public int rear;
	public int front;
	public void add(int x)
	{
		A[rear]=x;	
		rear++;
	}
	public void remove()
	{
		front++;	
	}
	public int peek()
	{
		return A[front];
	}
	public int size()
	{
		return rear-front;
	}
	public Queue()
	{
		rear=0;
		front=0;
	}
}


