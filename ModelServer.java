import java.io.IOException;

import arjuna.JavaSim.Distributions.ExponentialStream;
import arjuna.JavaSim.Simulation.*;

/**
 * This handles object of server handling the JOB
 */
public class ModelServer extends SimulationProcess {
  private ExponentialStream mean_service;
  private Job current_job;

  /**
   * 
   */

  public ModelServer(double means) {

    this.mean_service = new ExponentialStream(means);
    this.current_job = null;
  }

  public double generateServiceTime() {
    try {
      return this.mean_service.getNumber();
    } catch (IOException e) {
      return 0.0;
    }
  }

  public void run() {
    /*
     * This is to measure the duration the machine is active
     */
    double start, end;
    System.out.println("not even here?");
    for (;;) {
      
      while (!Model.jobQ.isEmpty()) {
        start = CurrentTime();
        
        this.current_job = Model.jobQ.dequeue();
        System.out.println("Job diproses");
        // This update the job that must be queued / in delay
        Model.JobsInQueue += Model.jobQ.getSize();
        
        current_job.taken();
        
        try {
          double temp = generateServiceTime();
          Hold(temp);
        } catch (SimulationException e) {
        } catch (RestartException e) {
        }

        end = CurrentTime();
        Model.ActiveTime += (start - end);
        Model.ProcessedJobs += 1;
        current_job.finished();
      }

      try {
        System.out.println("masuk sini cok");
        Cancel();
      } catch (RestartException e){
      }
    }
  }
}