import java.util.*;
public class Scan {
	public int main(int A[],int n,int head)
	{	
	//	int next_to_m=find(A,n,m);
		int ans;
		if(head<100)
		{	int ma=max(A,n);
			ans=(head-0)+(ma-0);
		}
		else
		{	int mi=min(A,n);
			ans=(199-head)+(199-mi);
		}
		return ans;
	}
public static int max(int A[],int n)
{	int ma=A[0];
	for(int i=1;i<n;i++)
	{
		if(A[i]>ma) ma=A[i];
	}
	return ma;
}
public static int min(int A[],int n)
{	int mi=A[0];
	for(int i=1;i<n;i++)
	{
		if(A[i]<mi) mi=A[i];
	}
	return mi;
}
}
