
/**
 * This class manage and control the arrival of jobs
 * Process:
 * 1. set the 'mean interarrival'
 * 2. calling new JOB every 'mean interarrival in indefinitely length'
 * 3. 
 *
 */
import java.io.IOException;

import arjuna.JavaSim.Distributions.ExponentialStream;
import arjuna.JavaSim.Simulation.*;

public class Arrival extends SimulationProcess {
  private ExponentialStream interarrivalTime;

  public Arrival(double mean) {
    interarrivalTime = new ExponentialStream(mean);
  }

  public void run() {
    for (;;) {
      try {
        Hold(interarrivalTime.getNumber());
      } catch (SimulationException e) {
      } catch (RestartException e) {
      } catch (IOException e) {
      }

      Job job = new Job();
      /* Insert the new job into Queue */
      Model.jobQ.enqueue(job);
      Model.TotalJobs += 1;
      System.out.println("Job datang pada:\t" + (CurrentTime()));

      if (!Model.server.IsWorking()) {
        try {
          Model.server.ReActivate();
        } catch (SimulationException e) {
        } catch (RestartException e) {
        }
      }
    }
  }
}