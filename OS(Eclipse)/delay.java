import java.util.concurrent.TimeUnit;
public class delay 
{
	public void basic()
	{
		{		try
				{
					TimeUnit.SECONDS.sleep(2);
				}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
	}
}




