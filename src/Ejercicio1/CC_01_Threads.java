package Ejercicio1;

public class CC_01_Threads {
	private static class Hilo extends Thread{
		private int id;
		private int tiempo;
	 public Hilo(int id, int tiempo) {
		 super();
		 this.id=id;
		 this.tiempo=tiempo;
	 }
	 public void run() {
		 System.out.println("Thread"+" "+id);
		 try {
			 Thread.sleep(tiempo);
		 }
		 catch ( InterruptedException e ) {
			 System.out.println() ;
			 } 
		 System.out.println("Thread"+" "+id);
}
 }
	public static void main(String[] args) {
		int N=5;
		int T=3000;
		for(int i=0;i<N;i++) {
	    Hilo prueba=new Hilo(i,T);
	    prueba.start();
		}
		 try {
			 Thread.sleep(6000);
		 }
		 catch ( InterruptedException e ) {
			 System.out.println() ;
			 } 
	 System.out.println("Ha terminado");

	}

}



