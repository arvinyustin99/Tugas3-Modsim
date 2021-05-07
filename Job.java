import arjuna.JavaSim.Simulation.*;

public class Job{
  private double finishedTime;
  private double responseTime;
  private double arrivalTime;

  public Job(){
    finishedTime = 0.0;
    responseTime = 0.0;
    arrivalTime = Scheduler.CurrentTime();
  }
  public void taken(){
    responseTime = Scheduler.CurrentTime() - arrivalTime;
  }
  public void finished(){
    finishedTime = Scheduler.CurrentTime() - responseTime;
  }
}