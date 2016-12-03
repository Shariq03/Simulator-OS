public class SJF_preemptive
{
	public float begin(int n,int AT[],int BT[])
	{	
		int waiting[]=new int[n];
		int temp=0;
		for(int i=0;i<n;i++)
		{	temp=temp+BT[i];
			waiting[i]=0;
		}
		int processing=0;
		for(int i=0;i<temp;i++)
		{
			int minRun=11;
			for(int j=0; j<n && AT[j]<=i; j++)
			{
				if(BT[j]<minRun && BT[j]!=0)
				{
					processing=j;
					minRun=BT[j];
				}
			}
			if(minRun==11)
			{
				continue;
			}
			BT[processing]--;
			boolean allp=true;
			for(int j=0;j<n;j++)
			{
				if(BT[j]!=0)
				{
					allp=false;
					break;
				}
			}
			if(allp)
			{
				break;
			}
			for(int j=0;j<n;j++)
			{
				if(AT[j]<i && processing!=j && BT[j]!=0)
				{
					waiting[j]++;
				}
			}
		}
		int totalWait=0;
		for(int i=0;i<n;i++)
			totalWait+=waiting[i];	
		System.out.println("SJF-Preemptive: "+"\t"+(float)totalWait/n);
		float ans=(float)totalWait/n;
		return ans;
	}	
}