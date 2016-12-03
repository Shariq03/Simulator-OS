import java.util.Scanner;
import java.util.*;
public class SSTF{
	public int main(int queue[],int num,int head)
	{
		/*Random x = new Random();
		int  head = x.nextInt(200) + 0;
		System.out.print("Head:- ");
		System.out.println(head);
		int num=x.nextInt(10)+5;
		System.out.print("n:- ");
		System.out.println(num);
		int [] queue=new int[num+1];
		System.out.print("Queue contains:- ");
		int i;
		for(i=1;i<=num;i++)
		{
			int use=x.nextInt(200)+0;
			System.out.print(use);
			System.out.print(" ");
			queue[i]=use;
		}
			System.out.println("");*/
		
		int temp=0;
			int [] use=new int[num];
			for(int j=0;j<num;j++)
			{
					use[j]=Math.abs(queue[j]-head);
			}
			for(int j=0;j<num;j++)
			{
				for(int k=0;k<num;k++)
				{
					if(use[k]>use[j])
					{
						int t=use[k];
						use[k]=use[j];
						use[j]=t;
						t=queue[k];
						queue[k]=queue[j];
						queue[j]=t;
					}
				}
			}
			temp=Math.abs(queue[1]-head);
			for(int j=1;j<num;j++)
			{
			//	System.out.println(queue[j]);
				temp=temp+Math.abs(queue[j]-queue[j-1]);
			}
		return temp;
	}
}
