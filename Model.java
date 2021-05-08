import arjuna.JavaSim.Simulation.*;
import arjuna.JavaSim.Simulation.Scheduler;

public class Model extends SimulationProcess {
  public double mean_service;
  public double mean_interarrival;
  // public static ModelServer server;
  public static Queue jobQ = null;
  public static double TotalResponseTime = 0.0;
  public static long TotalJobs = 0;
  public static long ProcessedJobs = 0;
  public static long JobsInQueue = 0;
  public static long CheckFreq = 0;
  public static double MachineActiveTime = 0.0;
  public static double MachineFailedTime = 0.0;

  /**
   * Construct a Model class
   * 
   * @param mean_service      determining the mean service time inside machine
   * @param mean_interarrival mean time of each job's interarrival
   */
  public Model(double mean_service, double mean_interarrival) {

    this.mean_service = mean_service;
    this.mean_interarrival = mean_interarrival;
  }

  public void run() {
    try {
      /* this.jobQ = new Queue(); */

      Arrival arrival = new Arrival(this.mean_interarrival);
      Model.jobQ = new Queue();
      // this.server = new ModelServer(this.mean_service);

      arrival.Activate();
      Scheduler.startSimulation();

      while (Scheduler.CurrentTime() < 3600.0) {
        System.out.print("Loop");
        Hold(3600.0);
      }
      System.out.println("Terminate Main");

      /* Stop the arrival thread, then simulation time, then back to MAIN thread */

      arrival.terminate();
      Scheduler.stopSimulation();
      SimulationProcess.mainResume();
      
      Model.jobQ.print();
    } catch (SimulationException e) {
    } catch (RestartException e) {
    }
  }

  public void Await() {
    this.Resume();
    SimulationProcess.mainSuspend();
  }

  public static void main(String[] args) {
    System.out.println("Test0");
    Model model = new Model(120.0, 150.0);
    model.Await();
    System.out.println("Test1");
  }
}