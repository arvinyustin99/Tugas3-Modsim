import arjuna.JavaSim.Simulation.*;

public class Job{
  public double responseTime;
  public double finishedTime;
  public double arrivalTime;

  public Job(){
    finishedTime = 0.0;
    responseTime = 0.0;
    arrivalTime = Scheduler.CurrentTime();
  }
  public void taken(){
    responseTime = Scheduler.CurrentTime();
  }
  public void finished(){
    finishedTime = Scheduler.CurrentTime();
  }
}