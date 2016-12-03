import java.util.Random;
public class CScan {
	public int main(int A[],int n,int head)
	{	
	//	int next_to_m=find(A,n,m);
		int ans;
		if(head<100)
		{	int ma=max(A,n,head);
			ans=(head-0)+(199-ma);
		}
		else
		{	int mi=min(A,n,head);
			ans=(199-head)+(mi);
		}
		return ans;
	}
public static int max(int Ai[],int n,int head)
{	int A[]=new int[n],k=0;
	for(int i=0;i<n;i++)
	{
		if(Ai[i]>head)
		{
			A[k]=Ai[i]; k++;
		}
	}
	if(k!=-1)
	{
	int ma=A[0];
	for(int i=1;i<n;i++)
	{
		if(A[i]<ma) ma=A[i];
	}
	return ma;
	}
	return 199;
}
public static int min(int Ai[],int n,int head)
{	
	int A[]=new int[n],k=0;
	for(int i=0;i<n;i++)
	{
		if(Ai[i]<head)
		{
			A[k]=Ai[i]; k++;
		}
	}
	if(k!=-1)
	{
	int mi=A[0];
	for(int i=1;i<n;i++)
	{
		if(A[i]>mi) mi=A[i];
	}
	return mi;
	}
	return 0;
}
}
