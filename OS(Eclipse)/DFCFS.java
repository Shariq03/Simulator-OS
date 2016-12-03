import java.util.Scanner;
import java.util.*;
public class DFCFS{
	public int main(int A[],int n,int head)
	{
		Random x = new Random();
		int temp=Math.abs(head-A[0]);
		for(int i=1;i<n;i++)
		{
			temp=temp+Math.abs(A[i]-A[i-1]);	
		}
		return temp;
	}
}
