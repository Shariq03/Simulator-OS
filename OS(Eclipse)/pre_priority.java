public class pre_priority
{
	public float begin(int n,int at[],int bt[],int pr[])
	{
		int current_Priority;
		int time=0,i,temp=0;
		int waiting=0;
		int processing=0;
		current_Priority=n+1;
		for(i=0;i<n;i++)
			temp+=bt[i];
		for(i=0;i<temp;i++)
		{	
			for(int j=0; j<n && at[j]<=i; j++)
			{
				if(pr[j] <= current_Priority && bt[j]!=0)
				{	
					processing=j;
					current_Priority=pr[j];
				}
			}
			if(bt[processing]==0) continue;
			bt[processing]--;
			int nn=processing+1;
			boolean allp=true;
			for(int j=0;j<n;j++)
			{
				if(bt[j]!=0)
				{
					allp=false;
					break;
				}
			}
			if(allp)
			{
				break;
			}
			if(bt[processing]==0)
				current_Priority=n+1;
			for(int j=0;j<n;j++)
			{
				if(at[j]<i && processing!=j && bt[j]!=0)
				{
					waiting++;
				}
			}
		}
		//System.out.println("Preemptive Priority: "+"\t"+((float)waiting)/n);
		float ans=(float)waiting/n;
		return ans;
	}	
}