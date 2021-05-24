import java.io.IOException;

import arjuna.JavaSim.Distributions.ExponentialStream;
import arjuna.JavaSim.Simulation.*;

/**
 * This handles object of server handling the JOB
 */
public class ModelServer extends SimulationProcess {
  private ExponentialStream mean_service;
  private Job current_job;
  private boolean is_working = false;

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

    for (;;) {

      // if Queue not empty then process
      while (!Model.jobQ.isEmpty()) {
        System.out.println("Server is processing job");
        is_working = true;
        start = CurrentTime();

        this.current_job = Model.jobQ.dequeue();

        current_job.taken();

        try {
          double temp = generateServiceTime();
          Hold(temp);
        } catch (SimulationException e) {
        } catch (RestartException e) {
        }

        end = CurrentTime();
        Model.ActiveTime += (end - start);
        Model.ProcessedJobs += 1;
        Model.TotalDelay += current_job.responseTime - current_job.arrivalTime;
        current_job.finished();
        is_working = false;
      }

      try {
        System.out.println("Server idle");
        Cancel();
      } catch (RestartException e) {
      }
    }
  }

  public boolean IsWorking() {
    return is_working;
  }
}