import arjuna.JavaSim.Simulation.*;
import arjuna.JavaSim.Statistics.*;
import arjuna.JavaSim.Simulation.SimulationException;

public class Controller extends SimulationProcess
{

public Controller ()
    {
    }

public void run ()
    {
	try
	{
	    Controller.c.Activate();
	    Controller.p.Activate();
	    Scheduler.startSimulation();

	    Hold(100);

	System.out.println("Total number of jobs present "+TotalNumberOfJobs);
	System.out.println("Total number of jobs consumed "+NumberOfJobsConsumed);

	    Scheduler.stopSimulation();
	    
	    p.terminate();
	    c.terminate();

	    SimulationProcess.mainResume();
	}
	catch (SimulationException e)
	{
	}
	catch (RestartException e)
	{
	}
    }
    
public void Await ()
    {
	this.Resume();
	SimulationProcess.mainSuspend();
    }

public static Producer p = new Producer(2);
public static Consumer c = new Consumer(2);
public static Queue JobQueue = new Queue();
public static long TotalNumberOfJobs = 0;
public static long NumberOfJobsConsumed = 0;
    
};
