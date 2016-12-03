public class SJF_non_preemptive
{
	public float begin(int n,int A[],int B[])
	{	int i;
		int V[]=new int[n];
		for(i=0;i<n;i++)
		{
			V[i]=1;
		}
		V[0]=0;
		int P_B=B[0],sum=0,min,j;
		int index=0;
		for(i=1;i<n;i++)
		{	boolean flag=false;
			min=11;
			for(j=0;j<n;j++)
			{
				if(V[j]==1 && A[j]<=P_B && B[j]<min)
				{
					min=B[j];
					index=j;
					flag=true;
				}
			}
			if(!flag) index=i;
			
			V[index]=0;
			sum = sum + (P_B - A[index]);
			P_B = P_B + B[index];
			if (sum<0) sum=0;
		}
		//System.out.println("SJF-Non Preemptive: "+"\t"+((float)sum)/n);
		float ans=(float)sum/n;
		return sum;
	}
}