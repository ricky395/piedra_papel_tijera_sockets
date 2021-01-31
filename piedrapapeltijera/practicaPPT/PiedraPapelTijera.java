

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Random;

public class PiedraPapelTijera {
	
	private static int aleatorio=0;
	private static int jugadorgana;
	private static PrintWriter salida;
	private static BufferedReader entrada;
	
	/**
	 * 
	 * @param entrada flujo de entrada de lectura
	 * @param salida flujo para la salida de datos
	 */
	public PiedraPapelTijera(BufferedReader entrada, PrintWriter salida){
		PiedraPapelTijera.salida = salida;
		PiedraPapelTijera.entrada = entrada;
	}
	
  /**
   * Genera la elección aleatoria del ordenador.
   */
	public static void generaAleatorio(){
		
		Random r = new Random();
		aleatorio = r.nextInt (3)+1;
		System.out.println("     La máquina contra " + Jugador.getNombre() + " ha elegido: " + aleatorio +" (1-Piedra / 2-Papel / 3-Tijera)");
	}
	
	
	/**
	 * Muestra la opción elegida por el ordenador tras haber elegido el jugador humano y se comparan los resultados.
	 */
	public static void muestraAleatorio(){
		
		if(aleatorio==1) salida.println("00--- El ordenador ha elegido PIEDRA. ---");
		else if(aleatorio==2) salida.println("00--- El ordenador ha elegido PAPEL. ---");
		else salida.println("00--- El ordenador ha elegido TIJERA. ---");
	
	}

	/**
	 * Comprueba si el ganador es la máquina o el jugador.
	 * @param opcjugador la opción elegida por el jugador humano.
	 * @param opcmaquina opción elegida por la máquina.
	 * @return devuelve 1 en caso de que gane el jugador humano, 0 si gana la máquina y -1 en caso de empate.
	 */
	public static int compruebaGanador(int opcjugador, int opcmaquina){
		
		if (opcjugador==opcmaquina) jugadorgana=-1;
		
		else if (opcjugador==1 && opcmaquina==2) jugadorgana=0;
		
		else if (opcjugador==1 && opcmaquina==3) jugadorgana=1;
		
		else if (opcjugador==2 && opcmaquina==1) jugadorgana=1;
		
		else if (opcjugador==2 && opcmaquina==3) jugadorgana=0;
		
		else if (opcjugador==3 && opcmaquina==1) jugadorgana=0;
		
		else if (opcjugador==3 && opcmaquina==2) jugadorgana=1;
		
		return jugadorgana;
	}
	
	public static int getaleatorio(){
		return aleatorio;
	}
}
