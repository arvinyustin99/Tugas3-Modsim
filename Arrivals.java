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
import arjuna.JavaSim.Simulation.RestartException;
import arjuna.JavaSim.Simulation.SimulationException;
import arjuna.JavaSim.Simulation.SimulationProcess;

public class Arrivals extends SimulationProcess{
  private ExponentialStream interarrivalTime;

  public Arrivals(double mean){
    interarrivalTime = new ExponentialStream(mean);
  }

  public void run(){
    for (;;){
      try{
        Hold(interarrivalTime.getNumber());
      } catch (SimulationException e){

      } catch (RestartException e){

      } catch (IOException e){
        
      }
    }
  }
}