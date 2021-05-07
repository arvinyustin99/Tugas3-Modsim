import arjuna.JavaSim.Simulation.*;
import arjuna.JavaSim.Distributions.*;

import java.io.IOException;
import arjuna.JavaSim.Simulation.SimulationException;

public class Producer extends SimulationEntity
{

public Producer (double mean)
    {
	sTime = new ExponentialStream(mean);
    }

public void run ()
{
	for (;;)
	{
	    try
		{
		    Job work = new Job(jobnum); 
		    System.out.println("Job created "+jobnum);
		    jobnum++;
		    if (Controller.JobQueue.IsFull()) {
			System.out.println(" --------- Get from Producer  \n");
			Controller.p._semaphore.Get(this);
		    } 		    
		    Controller.TotalNumberOfJobs++;
		    Controller.JobQueue.Enqueue(work);
		    //System.out.println("Job created after "+(jobnum-1)+" "+Controller.JobQueue.QueueSize());
		    //    if (Controller.JobQueue.QueueSize() == 1)
		    Controller.c._semaphore.Release();
		    System.out.println("After Release Consumer "+Producer.jobnum);
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
public static int jobnum = 1; 
private ExponentialStream sTime;
private Job work;   
};
