package Ejercicio2;
public class CC_02_Carrera{
public static class CC_02_Carrera_1 extends Thread {
	private int id;
	private int n;
	public CC_02_Carrera_1(int id, int n) {
		super();
		this.id=id;
		this.n=n;
	}
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n++;
	}
}
public static class CC_02_Carrera_2 extends Thread {
	private int id;
	private int n;
	public CC_02_Carrera_2(int id, int n) {
		
		super();
		this.id=id;
		this.n=n;
	}
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.n--;	
	}
}
public static void main(String [] args) throws InterruptedException {
	int n=0;
	int max=1000;
	CC_02_Carrera_1[] arr= new CC_02_Carrera_1[max];
	CC_02_Carrera_2[] arr1= new CC_02_Carrera_2[max];
	for(int i=0;i<max;i++) {
		if(i%2==0) {
		CC_02_Carrera_1 prueba= new CC_02_Carrera_1(i,n);
		prueba.start();
		arr[i]=prueba;
		}
		else {
			CC_02_Carrera_2 prueba1= new CC_02_Carrera_2(i,n);
			prueba1.start();
			arr1[i]=prueba1;	
			}
	}
	for(int i=0;i<max;i++) {
		if(i%2==0)
		arr[i].join();
		else
			arr1[i].join();
	}
	System.out.println("Valor variable"+" "+n);
}

}
