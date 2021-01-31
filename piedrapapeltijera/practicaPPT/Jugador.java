

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *Clase Jugador, encargada de almacenar el nombre del jugador, las puntuaciones y las partidas ganadas, empatadas y perdidas.
 *También se encarga de controlar la opción elegida por el jugador humano.
 */
public class Jugador {

	private static int opcion=-1;
	private static int ganadas=0;
	private static int empatadas=0;
	private static int perdidas=0;
	private static String nombre;
	private static int puntuacion=0;
	private static PrintWriter salida;
	private static BufferedReader entrada;
	
	/**
	 * reestablece las variables y crea los streams de salida y entrada
	 * @param entrada flujo de entrada de datos
	 * @param salida flujo de salida de datos
	 */
	public Jugador(BufferedReader entrada, PrintWriter salida){
		Jugador.salida = salida;
		Jugador.entrada = entrada;
		
		ganadas=0;
		empatadas=0;
		perdidas=0;
		puntuacion=0;
		opcion=-1;
	}
	
	/**
	 * mensajePuntuacion muestra por pantalla el resultado de la ronda y la puntuación obtenida.
	 * @param compruebaganador vale 1 en caso de que gane el jugador, 0 la máquina y
	 * 		  -1 en caso de empate.
	 */
	public static void mensajePuntuacion(int compruebaganador){
				
		if (compruebaganador==1){
			salida.println("00¡¡HAS GANADO!!! Obtienes 100 puntos.");
			ganadas++;
		}
		
		else if (compruebaganador==0){
			salida.println("00Oooh... HAS PERDIDO. Se te restan 100 puntos.");
			perdidas++;
		}
		
		else{
			salida.println("00EMPATE. No se altera la puntuación.");
			empatadas++;
		}
		
		salida.println("00Puntos totales: "+ Jugador.generaPuntuacion() +".");
		salida.println("00");
	}
	
	/**
	 * Genera la puntuación final en relación a las partidas ganadas y las perdidas.
	 * @return valor de la puntuación obtenida hasta el momento.
	 */
	public static int generaPuntuacion(){
		return puntuacion = ganadas*100-perdidas*100;
	}
	
	public static int getPerdidas(){
		return perdidas;
	}
	
	public static int getEmpatadas(){
		return empatadas;
	}
	
	public static int getGanadas(){
		return ganadas;
	}
	
	public static int getOpcion(){
		return opcion;
	}
	
	public static void setopcion(int a){
		opcion = a;
	}
	
	public static String getNombre(){
		return nombre;
	}
	
	public static void setnombre(String a){
		nombre = a;
	}
}
