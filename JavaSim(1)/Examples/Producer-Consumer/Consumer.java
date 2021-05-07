import arjuna.JavaSim.Simulation.*;
import arjuna.JavaSim.Distributions.*;

import java.io.IOException;
import arjuna.JavaSim.Simulation.SimulationException;

public class Consumer extends SimulationEntity
{

public Consumer (double mean)
    {
	sTime = new ExponentialStream(mean);
    }

public void run ()
{
	for (;;)
	{
	    try
		{
		    if (Controller.JobQueue.IsEmpty()){
			System.out.println(" --------- Get from Consumer \n");
			Controller.c._semaphore.Get(this);
		    } 

		    work = Controller.JobQueue.Dequeue();
		    System.out.println("Job Consumed "+work.number);
		    //if (Controller.JobQueue.QueueSize() == (Controller.JobQueue.QueueFull()-1)){
		    System.out.println("After Job Consumed (calling Producer.jobnum "+Producer.jobnum);

		    if (!Controller.p.idle()) 
			//Controller.p.Activate();
			//System.out.println("Producer is IDLE "+Producer.jobnum);
		    Controller.p._semaphore.Release();
		    System.out.println("After Release Producer "+Producer.jobnum);
		    Controller.NumberOfJobsConsumed++;	
		   
		    Hold(sTime.getNumber());
		  
		}
	    catch (SimulationException e)
		{
		}
	    catch (RestartException e)
		{
		}
	    catch (IOException e)
		{
		}
	}
}

public static Semaphore _semaphore = new Semaphore();
private ExponentialStream sTime;
private Job work;    
};
