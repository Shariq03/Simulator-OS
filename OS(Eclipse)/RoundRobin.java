public class RoundRobin
{
	public float begin(int n,int bt[],int t)
	{	
		int waiting=0;
		int q1=t;
		for(int i=0;;i++)
		{	int q=q1;	
			if(i==n) i=0;
			if(bt[i]>0)
				bt[i]=bt[i]-q;
			else
				continue;
			if(bt[i]<0)
				q=q+bt[i];
			for(int j=0;j<n;j++)
			{
				if(j!=i && bt[j]>0)
				{
					waiting+=q;			
				}
			}
			boolean flag=true;
			for(int j=0;j<n;j++)
			{	
				if(bt[j]>0)
				{	
					flag=false;
					break;		
				}
			}
			if(flag)
				break;
		}
		//System.out.println("Round Robin: "+"\t\t"+(float)waiting/n);
		float ans=(float)waiting/n;
		return ans;
	}
}
