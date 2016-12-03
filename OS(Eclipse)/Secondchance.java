public class Secondchance 
{
	public int main(int A[])
	{	
		int Q[]=new int[3];
		int C[]=new int[3];
		int Counter[]=new int[3];
		Counter[0]=0; Counter[1]=-1; Counter[2]=-1;
		Q[0]=A[0]; C[0]=0;
		int i=1;
		int count=1;
		System.out.println(Q[0]);
		while(A[i]==Q[0])
		{	
			i++;
			C[0]=1; Counter[0]+=1;
			if(i==20) break;
			System.out.println(Q[0]);
		}
		if(i<20) 
		{
			Q[1]=A[i]; Counter[0]+=1; Counter[1]+=1; C[1]=0;
			i++; count++;
			System.out.println(Q[0]+" "+Q[1]);
		}
		if(i<20)
		{
			while(A[i]==Q[0] || A[i]==Q[1])
			{
				if(A[i]==Q[0])
				{
					C[0]=1; Counter[0]+=1; Counter[1]+=1;
				}
				else
				{
					C[1]=1; Counter[0]+=1; Counter[1]+=1;	
				}
				System.out.println(Q[0]+" "+Q[1]);
				i++;
				if(i==20) break;
			}
		}
		if(i<20)
		{
			Q[2]=A[i];
			C[2]=0; C[1]=0; C[0]=0;
			Counter[2]=0; Counter[1]+=1; Counter[0]+=1; 
			i++;
			count++;
			System.out.println(Q[0]+" "+Q[1]+" "+Q[2]);
		}
		for(;i<20;i++)
		{
			int k=A[i];
			if(k==Q[0] || k==Q[1] || k==Q[2])
			{
				int index1=whichindex(Q[0],Q[1],Q[2],k);
				C[index1]=1;
				Counter[0]+=1;
				Counter[1]+=1;
				Counter[2]+=1;
			}
			else
			{
				count++;
				if(C[0]==C[1] && C[1]==C[2])
				{   int y=maximum(Counter[0],Counter[1],Counter[2]);
					if(y==0)
					{	
						Q[0]=k;
						C[0]=0; C[1]=0; C[2]=0;
						Counter[0]=0; Counter[1]+=1; Counter[2]+=1;
					}
					else if(y==1)
					{						
						Q[1]=k;
						C[0]=0; C[1]=0; C[2]=0;
						Counter[0]+=1; Counter[1]=0; Counter[2]+=1;
					}
					else
					{	
						Q[2]=k;
						C[0]=0; C[1]=0; C[2]=0;
						Counter[0]+=1; Counter[1]+=1; Counter[2]=0;
					}
				}
				else
				{
					int y=maximum(Counter[0],Counter[1],Counter[2]);
					if(C[y]==1)
					{
						int z=max(Counter[(y+1)%3],Counter[(y+2)%3],(y+1)%3,(y+2)%3);
						if(C[z]==0)
						{
							C[y]=0; Q[z]=k; Counter[z]=0; Counter[(z+1)%3]+=1; Counter[(z+2)%3]+=1;
						}
						else
						{	int l;
							for(l=0;l<3;l++)
							{
								if(C[l]==0)
									break;
							}
							Q[l]=k; C[y]=0; C[z]=0; Counter[l]=0; Counter[(l+1)%3]+=1; Counter[(l+2)%3]+=1;
						}
					}
					else
					{
						Counter[y]=0; Q[y]=k; Counter[(y+1)%3]+=1; Counter[(y+2)%3]+=1;  
					}
				}
			}
			System.out.println(Q[0]+" "+Q[1]+" "+Q[2]);
		}
		return count;
	}	
public static int whichindex(int x,int y,int z,int p)
{
	if(p==x) return 0;
	else if(p==y) return 1;
	else return 2;
}
public static int max(int x,int y,int i1,int i2)
{
	if(x>y) return i1;
	else return i2;
}
public static int maximum(int x,int y,int z)
{
	if(x>=y && x>=z) return 0;
	else if(y>=x && y>=z) return 1;
	else return 2;
}
}