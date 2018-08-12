package pvt.notebook1.test;

import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.ListIterator;

public class Main {
    public static void main(String[] argv) {
	testCollections();
    }

    private static void testCollections() {
	final int MAX = 1000000;
	long startTime = 0;

	startTime = System.nanoTime();
	ArrayList<Integer> al = new ArrayList<Integer>();
	for (int i = 0; i < MAX; i++)
	    al.add(i);
	System.out.println("AL  add = " + (System.nanoTime() - startTime));
	
	startTime = System.nanoTime();
	ArrayList<Integer> al2 = new ArrayList<Integer>(MAX);
	for (int i = 0; i < MAX; i++)
	    al2.add(i);
	System.out.println("AL2 add = " + (System.nanoTime() - startTime));

	startTime = System.nanoTime();
	LinkedList<Integer> ll = new LinkedList<Integer>();
	for (int i = 0; i < MAX; i++)
	    ll.add(i);
	System.out.println("LL  add = " + (System.nanoTime() - startTime) + "\n");

	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    al.add((int) (Math.random() * al.size()), new Integer(i));
	System.out.println("AL expand = " + (System.nanoTime() - startTime));

	startTime = System.nanoTime();
	// ListIterator<Integer> it = ll.listIterator(ll.size() / 2);
	for (int i = 0; i < 100; i++) {
	    //it.add(new Integer(i));
	    ll.add((int) (Math.random() * ll.size()), new Integer(i));
	}
	System.out.println("LL expand = " + (System.nanoTime() - startTime + "\n"));
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    al.remove((int) (Math.random() * al.size()));
	System.out.println("AL remove = " + (System.nanoTime() - startTime));
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    ll.remove((int) (Math.random() * ll.size()));
	System.out.println("LL remove = " + (System.nanoTime() - startTime) + "\n");
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    al.get((int) (Math.random() * al.size()));
	System.out.println("AL get = " + (System.nanoTime() - startTime));
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    ll.get((int) (Math.random() * ll.size()));
	System.out.println("LL get = " + (System.nanoTime() - startTime) + "\n");
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    al.set((int) (Math.random() * al.size()), i);
	System.out.println("AL set = " + (System.nanoTime() - startTime));
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    ll.set((int) (Math.random() * ll.size()), i);
	System.out.println("LL set = " + (System.nanoTime() - startTime) + "\n");
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    al.add(0, i);
	System.out.println("AL add to position 0 = " + (System.nanoTime() - startTime));
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    ll.set(0, i);
	System.out.println("LL add to position 0 = " + (System.nanoTime() - startTime) + "\n");
	
	startTime = System.nanoTime();
	for (int i = 0; i < 10000; i++)
	    al.remove(al.size() - 1);
	System.out.println("AL remove last = " + (System.nanoTime() - startTime));
	
	startTime = System.nanoTime();
	for (int i = 0; i < 10000; i++)
	    ll.removeLast();
	System.out.println("LL remove last = " + (System.nanoTime() - startTime) + "\n");
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    al.add(al.size()/2, i);
	System.out.println("AL add to middle = " + (System.nanoTime() - startTime));
	
	startTime = System.nanoTime();
	for (int i = 0; i < 100; i++)
	    ll.set(ll.size()/2, i);
	System.out.println("LL add to middle = " + (System.nanoTime() - startTime));
    }
}