package Ejercicio3;

public class CC_03_MutexEA {
private static final int numIt=1000;
//Variable compartida
private static int n=0;
volatile static boolean en_scD=false;
volatile static boolean en_scI=false;
public static void inc() {
	n++;
}
public static void dec() {
	n--;
}
public static void no_sc() {
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static class Incrementador extends Thread {
	public void run() {
		for(int i=0;i<10;i++) {
			no_sc();
			while(en_scI) {}
			en_scI=true;
			inc();
			en_scI=false;
			//System.out.println(n);
		}}
	
}
public static class Decrementador extends Thread {
	public void run() {
		for(int i=0;i<10;i++) {
		no_sc();
		while(en_scD) {}
		en_scD=true;
		dec();
		en_scD=false;
		//System.out.println(n);
	}}
	
}
public static void main(String [] args) throws InterruptedException {
	Thread t1=new Incrementador();
	Thread t2=new Decrementador();
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println(n);
}
}
