import java.util.Scanner;
import java.util.Random;
public class LRU 
{
	public int main(int A[])
	{
		int Q[]=new int[3]; Q[0]=-1; Q[1]=-1; Q[2]=-1;
		int C[]=new int[3];
		Q[0]=A[0];
		System.out.println(Q[0]);
		C[0]=0;
		int count=1;
		int i=1;
		while(A[i]==Q[0])
		{	
			i++;
			C[0]=0;
			if(i==20) break;
			System.out.println(Q[0]);
		}
		if(i<20) 
		{
			Q[1]=A[i]; C[0]=1; C[1]=0;
			count++;
			i++;
			System.out.println(Q[0]+" "+Q[1]);
		}
		if(i<20)
		{
			while(A[i]==Q[0] || A[i]==Q[1])
			{
				if(A[i]==Q[0])
				{
					C[0]=0; C[1]+=1;
				}
				else
				{
					C[1]=0; C[0]+=1;
				}
				System.out.println(Q[0]+" "+Q[1]);
				i++;
				if(i==20) break;
			}
		}
		if(i<20)
		{
			Q[2]=A[i];
			C[0]+=1; C[1]+=1; C[2]=0;
			count++;
			i++;
			System.out.println(Q[0]+" "+Q[1]+" "+Q[2]);
		}
		for(;i<20;i++)
		{
			int k=A[i];
			if(k==Q[0] || k==Q[1] || k==Q[2])
			{
				int index1=equal(Q[0],Q[1],Q[2],k);
				C[index1]=0;
				C[(index1+1)%3]+=1;
				C[(index1+2)%3]+=1;
			}
			else
			{
				int index2=max(C[0],C[1],C[2]);
				C[index2]=0;
				C[(index2+1)%3]+=1;
				C[(index2+2)%3]+=1;
				Q[index2]=k;
				count++;
			}
			System.out.println(Q[0]+" "+Q[1]+" "+Q[2]);
		}
		return count;
	}
public static int max(int x,int y,int z)
{
	if(x>y && x>z)
		return 0;
	else if(y>x && y>z)
		return 1;
	else
		return 2;
}
public static int equal(int x,int y,int z,int p)
{
	if(p==x) return 0;
	else if(p==y) return 1;
	else return 2;
}
}
