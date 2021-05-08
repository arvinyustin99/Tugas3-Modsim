import arjuna.JavaSim.Simulation.*;
import java.util.NoSuchElementException;

/**
 * This is Data Structure holding the queueing Job before
 * processed by Machine / Server. The queue has HEAD and Length info
 * 
 * 
 */
public class Queue {
  private QueueElmt head;
  private long length;

  /* CTOR */
  public Queue(){
    head = null;
    length = 0;
  }

  /* Basic Check */
  public boolean isEmpty(){
    return (length == 0);
  }

  /* Selector */
  public long getSize(){
    return length;
  }

  /**
   * Add new Job to the Queue
   * 
   * @param new Job must be initialized before
   */
  public void enqueue(Job newJob){
    if (newJob == null){
      return;
    }

    QueueElmt pointer = head;

    /* if list is empty, directly insert into head */
    if (isEmpty()){
      this.head = new QueueElmt();
      this.head.setJob(newJob);
      this.head.setNext(null);
    }
    else{
      /* insert at the end of queue */
      while (pointer.getNext() != null){
        pointer = pointer.getNext();
      }

      QueueElmt newElmt = new QueueElmt();
      newElmt.setJob(newJob);
      pointer.setNext(newElmt);
    }
    length++;
  }
  
/**
 * Remove QueueElmt from the head
 */
  public Job dequeue(){
    if (isEmpty()){
      throw (new NoSuchElementException());
    }

    QueueElmt removedJob = head;
    head = head.getNext();
    length--;
    return removedJob.getJob();
  }

  public void print(){
    if (isEmpty()){
      System.out.println("Queue Empty");
    }
    else{
      QueueElmt ptr = head;
      long counter = 1;
      while (ptr != null){
        System.out.println(counter + "." + ptr.getJob().arrivalTime);
        ptr = ptr.getNext();
      }
    }
  }
}