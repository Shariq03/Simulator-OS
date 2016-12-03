public class FCFS
{	
	public float begin(int a,int at[],int bt[])
	{	
		int [] st=new int[a+1];
		int [] wt=new int[a+1];
		st[1]=at[1];
		wt[1]=st[1]-at[1];
		for(int i=2;i<=a;i++)
		{
			st[i]=st[i-1]+bt[i-1];
			wt[i]=st[i]-at[i];
		}
		float temp=0;
		for(int i=1;i<=a;i++)
		{
			temp=temp+wt[i];
		}
		//System.out.println("FCFS: "+"\t\t\t"+temp/a);
		float kk=temp/a;
		return kk;
	}
}
