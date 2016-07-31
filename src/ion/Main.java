package ion;

	import java.util.Map;
	import java.util.Random;
	import java.util.UUID;
	import java.util.concurrent.ConcurrentHashMap;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	/*from  ww  w. jav  a2  s  .com*/
	public class Main {
	  public static int MAP_SIZE = 100000;
	  public static void main(String[] args) {
	    Map<String, String> map = new ConcurrentHashMap<String, String>();
	    for (int i = 0; i < MAP_SIZE; i++) {
	      map.put("key:" + i, UUID.randomUUID().toString());
	    }
	    ExecutorService executor = Executors.newCachedThreadPool();
	    Accessor a1 = new Accessor(map);
	    Accessor a2 = new Accessor(map);
	    Mutator m = new Mutator(map);
	    executor.execute(a1);
	    executor.execute(m);
	    executor.execute(a2);
	  }
	}

	class Accessor implements Runnable {
	  Map<String, String> map;
	  public Accessor(Map<String, String> map) {
	    this.map = map;
	  }
	  public void run() {
	    for (Map.Entry<String, String> entry : this.map.entrySet()) {
	      System.out.println(Thread.currentThread().getName() + " - ["
	          + entry.getKey() + ", " + entry.getValue() + ']');
	    }
	  }
	}

	class Mutator implements Runnable {
	  Map<String, String> map;
	  Random random = new Random();
	  public Mutator(Map<String, String> map) {
	    this.map = map;
	  }
	  public void run() {
	    for (int i = 0; i < 100; i++) {
	      this.map.remove("key" + random.nextInt(Main.MAP_SIZE));
	      this.map.put("key" + random.nextInt(Main.MAP_SIZE), UUID.randomUUID()
	          .toString());
	      System.out.println(Thread.currentThread().getName() + ": " + i);
	    }
	  }
	}

