// In order to wake up a thread waiting for a specific condition, we want to
// implement a more generalized monitor. We will call this monitor, SyncQueue.
// The SyncQueue class should provide the following methods: 


public class SyncQueue
{
	// maintains an array of QueueNode objects, each representing a different
	// condition and enqueuing all threads that wait for this condition. You 
	// have to implement your own QueueNode.java. The size of the queue array 
	// should be given through a constructor whose spec is given below.
	private QueueNode[] queue;
	
	private static final int DEFAULT_MAX = 10;
	
	// constructors that create a queue and allow threads to wait for a 
	// default condition number (=10) or a condMax number of condition/event
	// types.
	public SyncQueue()
	{
		queue = new QueueNode[DEFAULT_MAX];
		for(int i = 0; i < DEFAULT_MAX; i++)
		{
        queue[i] = new QueueNode();
		}
	}
	public SyncQueue(int condMax)
	{
		queue = new QueueNode[condMax];
		for(int i = 0; i < condMax; i++)
		{
        queue[i] = new QueueNode();
		}
	}
	
	// enqueues the calling thread into the queue and waits until a given
	// condition is satisfied. It returns the ID of a child thread that has
	// woken the calling thread.
	public int enqueueAndSleep(int condition)
	{
		int nothing_there = -1;
		
		if(condition >= 0 && condition < queue.length)
		{
			return queue[condition].sleepSignal();
		}
		else
		{
			return nothing_there; 
		}
	}
	
	// dequeues and wakes up a thread waiting for a given condition. If there
	// are two or more threads waiting for the same condition, only one 
	// thread is dequeued and resumed. The FCFS (first-come-first-service) 
	// order does not matter. This function can receive the calling thread's
	// ID, (tid) as the 2nd argument. This tid will be passed to the thread
	// that has been woken up from enqueueAndSleep. If no 2nd argument is 
	// given, you may regard tid as 0. 
	public void dequeueAndWakeup(int condition)
	{	
		int tid_not_specified = 0;
		if(condition >= 0 && condition < queue.length)
		{
			queue[condition].wakeSignal(tid_not_specified);
		}
	}
	public void dequeueAndWakeup(int condition, int tid)
	{
		if(condition >= 0 && condition < queue.length)
		{
			queue[condition].wakeSignal(tid);
		}
	}
}
