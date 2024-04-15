package controller;

import java.util.concurrent.Semaphore;

public class ThreadCassino extends Thread{
	Semaphore semaforo = new Semaphore(1);
	private static int ganhador = 1 ;
	int id;
	public ThreadCassino(int id) {
		this.id = id;

	}
	
	@Override
	public void run() {
		rolarDados();
		
	}
	
	public void rolarDados() {
		int dado1=0;
		int dado2=0;
		int pontos = 0;
		while(pontos<5) {
            dado1 = (int) (Math.random()*6)+1;
            dado2 = (int) (Math.random()*6)+1;
            if(dado1+dado2==7 || dado1+dado2==11) {
            	                pontos++;
            	                
            }
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		try {
			semaforo.acquire();
			verificarGanhador();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public synchronized void  incrementarGanhador() {
		  ganhador++;
	 }
	public void verificarGanhador() {
		if(ganhador ==1) {
			System.out.println("O jogador "+id+" ficou em "+ganhador+" e ganhou R$5000,00");
			incrementarGanhador();
		}else if(ganhador == 2){
			System.out.println("O jogador "+id+" ficou em "+ganhador+" e ganhou R$4000,00");
			incrementarGanhador();
		}else if(ganhador == 3){
            System.out.println("O jogador "+id+" ficou em "+ganhador+" e ganhou R$3000,00");
            incrementarGanhador();
		}else {
			System.out.println("O jogador "+id+" ficou em "+ganhador);
			incrementarGanhador();
		}
		semaforo.release();
	}

}
