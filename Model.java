import arjuna.JavaSim.Simulation.*;
import arjuna.JavaSim.Simulation.Scheduler;

public class Model extends SimulationProcess {
  public double mean_service;
  public double mean_interarrival;
  public double simulation_duration;
  public static ModelServer server = null;
  public static Queue jobQ = null;
  public static double TotalDelay = 0.0;
  public static long TotalJobs = 0;
  public static long ProcessedJobs = 0;
  public static double ActiveTime = 0.0;
  public static double TotalQueueLength = 0.0;

  /**
   * Construct a Model class
   * 
   * @param mean_service      determining the mean service time inside machine
   * @param mean_interarrival mean time of each job's interarrival
   */
  public Model(double mean_service, double mean_interarrival, double simulation_duration) {

    this.mean_service = mean_service;
    this.mean_interarrival = mean_interarrival;
    this.simulation_duration = simulation_duration;
  }

  public void run() {
    try {
      /* this.jobQ = new Queue(); */

      Arrival arrival = new Arrival(this.mean_interarrival);
      Model.jobQ = new Queue();
      Model.server = new ModelServer(this.mean_service);

      arrival.Activate();
      Model.server.Activate();
      Scheduler.startSimulation();

      while (Scheduler.CurrentTime() < simulation_duration) {
        Hold(simulation_duration);
      }

      System.out.println("\n- Simulation end - ");

      /* Print simulation details */
      System.out.println("Jumlah jobs : " + TotalJobs);
      System.out.println("Jumlah jobs diproses : " + ProcessedJobs);
      System.out.println("Rata-rata delay nasabah : " + TotalDelay + " " + TotalJobs);
      System.out.println("Rata-rata panjang antrian : " + TotalQueueLength / simulation_duration);
      System.out.println("Utilisasi server : " + (ActiveTime / simulation_duration));
      System.out.println("Lama server idle : " + (simulation_duration - ActiveTime) + " dari " + simulation_duration);

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

}