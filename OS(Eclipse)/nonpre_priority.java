import java.util.Random;

public class nonpre_priority
{
	public float begin(int num,int at[],int bt[],int pr[])
	{
		int [] et=new int[num+1];
		int [] st=new int[num+1];
		int [] vis=new int [num+1];
		int tot=0;	
		int temp=0;
		Random ra=new Random();
		for(int i=1;i<=num;i++)
		{
			tot=tot+bt[i];
			vis[i]=0;
		}
		int cnt=0,fff=0;
		while(true)
		{
			fff=0;
			for(int ss=1;ss<=num;ss++)
			{
				if(vis[ss]==1)
					fff++;
			}
			if(fff==num)
				break;
			int j=1;
			int dha=10000;
			int [] store=new int[num];
			int dd=0;
			for(int i=1;i<=num;i++)
			{
				if(at[i]<=cnt && vis[i]==0 && pr[i]<=dha)
				{
					dd=1;
					if(pr[i]==dha)
					{
						if(bt[store[j-1]]<bt[i])
						{
							
						}
						else
						{
							store[j]=i;
							j++;
							dha=pr[i];
						}
					}
					else
					{
						store[j]=i;
						j++;
						dha=pr[i];
					}
				}
			}
			if(dd==1)
			{
				int index=store[j-1];
				st[index]=cnt;
				et[index]=cnt+bt[index];
				cnt=et[index];
				vis[index]=1;
			}
			if(dd==0)
			cnt++;
		}
		float sum=0;
		int [] wt=new int[num+1];
		for(int i=1;i<=num;i++)
		{		
		 	wt[i]=st[i]-at[i];
		 	sum=sum+wt[i];
		}
		float sav=(float)sum/num;
		//System.out.println("NonPreemptive Priority: "+sav);
		return sav;
	}
}