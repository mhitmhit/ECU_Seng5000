package KW.CH04;
/*<exercuse chapter="4" type="programming-project" number="11">*/
/*
 * JobQueue.java
 *
 * Created on July 24, 2004, 9:57 PM
 */

import java.util.Queue;

/** Class to simulate a queue of printing jobs. */
public class JobQueue {
    // Data Fields
    // The queue
    private final Queue<Request> theQueue;
    /** The number of requests served. */
    private int numServed;
    /** The total time requests were waiting. */
    private int totalWait;
    /** The name of this queue. */
    private final String queueName;
    /** The average arrival rate. */
    private double arrivalRate;
    // Constructor
    /** Construct a JobQueue with the given name.
      @param queueName The name of this queue
    */
    public JobQueue(String queueName) {
        theQueue = new ArrayDeque<>();
        numServed = 0;
        totalWait = 0;
        this.queueName = queueName;
    }
    
    /** New arrival has occurred.
     * @param clock The current simulated time
     * @param numPages Number of pages to be printed
     * @param showAll if true, provide detailed output
    */
    public void checkNewArrival(int clock, int numPages, boolean showAll) {
        int procTime = (int) Math.ceil(((double)numPages) / 10.0);
        theQueue.offer(new Request(clock, procTime));
        if (showAll) {
            System.out.println("Time is "
            + clock + ": "
            + queueName
            + " arrival, new queue size is "
            + theQueue.size());
        }
    }    
    
    /** Update statistics.
      @param clock The current simulated time
     *@param printer System printer number handling this job
      @param showAll Flag to indicate whether to show detail
      @return Time request is done being served
    */
    public int update(int clock, int printer, boolean showAll) {
        Request nextRequest = theQueue.remove();
        int timeStamp = nextRequest.getArrivalTime();
        int wait = clock - timeStamp;
        totalWait += wait;
        numServed++;
        if (showAll) {
            System.out.println("Time is " + clock
            + ": Printer " + printer + " Serving "
            + queueName
            + " with time stamp "
            + timeStamp);
        }
        return clock + nextRequest.getProcessingTime();
    }
    
    public int getNumServed(){
        return numServed;
    }
    
    public int getTotalWait(){
        return totalWait;
    }
    
    public void setArrivalRate(double arrivalRate){
        this.arrivalRate = arrivalRate;
    }
    
    public boolean isEmpty(){
        return theQueue.isEmpty();        
    }
}
/*</exercise>*/

