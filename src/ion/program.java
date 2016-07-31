package ion;
import co.iontrading.test.model.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;


public class program {
	static HashMap <Integer,Boolean> seat = new HashMap <Integer,Boolean>();
	static HashMap <Integer,SeatMap> seat1 = new HashMap <Integer,SeatMap>();
	static HashMap<Auditorium, HashMap <Integer,SeatMap>> store1 = new HashMap<Auditorium, HashMap <Integer,SeatMap>>();
	static HashMap<Integer, HashMap <Integer,Boolean>> store = new HashMap<Integer,HashMap <Integer,Boolean>>();
	private final ReentrantLock lock = new ReentrantLock();
	private int count = 0;

	//Locking using Lock and ReentrantLock
	public int getCount() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
			return count++;
		} finally {
			lock.unlock();
		}

	}

	public int bookSeat(int se, int audi)
	{
		audi = 1;
		if(!(store.get(audi)).get(se).booleanValue())
		{
			seat.put(se,true);
			store.put(se,seat);
			return 1;
		}
		return 0;

	}

	public void diplaySeatMap(int audi)
	{
		HashMap<Integer,Boolean> local = new HashMap<Integer,Boolean>(); 
		local =	store.get(audi);
		for(Integer key : local.keySet())
		{
			System.out.println("Seat Number: " +key+ " Availibility :" + local.get(key));
		}
	}
	public static void main(String args[]) {
		//final program counter = new program();
		program p = new program();
		for(int i=1;i<=300;i++)
			seat.put(i,false);
		store.put(1,seat);

		p.bookSeat(3, 1);
		p.bookSeat(5, 1);
		p.diplaySeatMap(1);
		/*	Thread t1 = new Thread() {

			@Override
			public void run() {
				while (counter.getCount() < 6) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						ex.printStackTrace();                    }
				}
			}
		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				while (counter.getCount() < 6) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		t1.start();
		t2.start();
		 */
	}
}


