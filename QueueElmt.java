/**
 * This handles the element of Queue
 */
public class QueueElmt {
  private Job job;
  private QueueElmt next;

  /* CTOR */
  public QueueElmt() {
    job = null;
    next = null;
  }

  /* Selektor */
  public Job getJob() {
    return this.job;
  }

  public QueueElmt getNext() {
    return this.next;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public void setNext(QueueElmt next) {
    this.next = next;
  }

  
}