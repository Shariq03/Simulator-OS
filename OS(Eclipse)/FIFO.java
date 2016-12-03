import java.util.Random;
public class FIFO {
	public int main(int A[]) 
	{
		Random ra=new Random();
		int Q[]=new int[3]; Q[1]=-1; Q[2]=-1;
		int count=1;
		Q[0]=A[0];
		int i=1;
		while(A[i]==Q[0])
		{	
			i++;
			if(i==20) break;
		}
		if(i<20) 
		{
			Q[1]=A[i];
			count++;
			i++;
		}
		if(i<20)
		{
			while(A[i]==Q[0] || A[i]==Q[1])
			{
				i++;
				if(i==20) break;
			}
		}
		if(i<20)
		{
			Q[2]=A[i];
			count++;
			i++;
		}
		for(;i<20;i++)
		{
			int k=A[i];
			if(k==Q[0] || k==Q[1] || k==Q[2]){
			}
			else
			{	int m=Q[1];
				int n=Q[2];
				Q[2]=k;
				Q[1]=n;
				Q[0]=m;
				count++;
			}
		}
		return count;
	}
}
