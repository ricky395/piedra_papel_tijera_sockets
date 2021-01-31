

import java.net.Socket; 
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase principal que contiene el main. En ella se llevan a cabo todas las funciones necesarias para desarrollar el juego.
 * @author Ricardo Roldán
 * @author Alejandro García
 * @author Fernando Villalaín
 * @version 1.0
 */

public class JuegoPPT {
	
	private Scanner sc;
	private static int compruebaganador;
	public static int ronda=0;
	private Socket socket;
	private static PrintWriter salida;
	private static BufferedReader entrada;
		
	public static void Juegoparametros(BufferedReader entrada, PrintWriter salida){
		JuegoPPT.salida = salida;
		JuegoPPT.entrada = entrada;
		ronda=0;
	}
	
	/**
	 * Muestra por pantalla las reglas del juego.
	 */
	public static void muestraReglas(){
		
		salida.println("00Bienvenido al juego Piedra, Papel, Tijera.");
		salida.println("00");
		salida.println("00REGLAS:");
		salida.println("00El objetivo del juego consiste en elegir la opción ganadora de entre tres posibles elementos: PIEDRA, PAPEL o TIJERA.");
		salida.println("00El ordenador (aleatoriamente) y el usuario jugador elegirán una de esas tres opciones. El elemento más fuerte es el que gana.");
		salida.println("00Cada partida ganada suma 100 puntos y cada una perdida resta 100. En caso de perder 3 veces, el juego se acaba.");
		salida.println("00- PIEDRA gana a la TIJERA porque la rompe.");
		salida.println("00- PAPEL gana a PIEDRA porque la envuelve.");
		salida.println("00- TIJERA gana a PAPEL porque lo corta.");
		salida.println("00");
		salida.println("00En caso de que el programa y el jugador escojan el mismo elemento se produce un empate y no se suman ni restan puntos.");		 
						
	}
	/**
	 * Muestra el menú una vez empezado el juego.
	 */
	public static void muestraMenu(){
		
		ronda++;
		salida.println("00");
		salida.println("00  Ronda "+ ronda +". Elige una opción, "+ Jugador.getNombre() +":");
		salida.println("00");
		salida.println("01  1 - PIEDRA. / 2 - PAPEL. / 3 - TIJERA. / 4 - Salir del juego.");
		
	}
	/**
	 * Función principal que llama a las clases y a sus funciones.
	 * @param args
	 */
	
	public static int getcompruebaganador(){
		return compruebaganador;
	}
	
	public static void setcompruebaganador(int a){
		compruebaganador = a;
	}
}