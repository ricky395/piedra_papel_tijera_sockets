

import java.io.*;
import java.net.*;
import java.net.*;
import java.util.Scanner;

public class Hilo implements Runnable {

	private Socket con;
	private int num_hilo;
	private InetAddress ip_cliente;
	private int puerto_cliente;
	private String dato;
	private int opc;
	private static boolean salir=false;
	
	public Hilo(Socket socket, int n) {
		
		this.con = socket;
		num_hilo = n;
		ip_cliente = con.getInetAddress();
		puerto_cliente = con.getPort();
		
	}
	
	 	
	public void run() {
	
		
		try {
				
			PrintWriter salida = new PrintWriter(con.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader (new InputStreamReader(con.getInputStream()));
			
			
			System.out.println("\nIniciando partida...");
			
			JuegoPPT.Juegoparametros(entrada, salida);
			JuegoPPT.muestraReglas();
			salida.println("00");
			salida.println("01 Introduce tu nombre: ");						
			dato = entrada.readLine();
			salida.println("00");
			Jugador.setnombre(dato);
			
			System.out.println("\n  El cliente " + num_hilo + " ("+ ip_cliente +":"+ puerto_cliente +") " + "ha introducido el nombre: " + dato +"\n");
			
			do{		
				new Jugador(entrada, salida);
				new PiedraPapelTijera(entrada, salida);				
				JuegoPPT.ronda=0;
				
				salir=false;
				
				do{
					if(Jugador.getOpcion()== 4 || Jugador.getPerdidas()==3)	salir=true;
					
					else{
						 JuegoPPT.muestraMenu();
						 PiedraPapelTijera.generaAleatorio();
						
						do{
							System.out.println("     " + Jugador.getNombre() + " está eligiendo una opción...");
							dato = entrada.readLine();
							opc = Integer.parseInt(dato);
							Jugador.setopcion(opc);
							
						}while(Jugador.getOpcion() < 1 || Jugador.getOpcion() > 4);

						System.out.println("     " + Jugador.getNombre() + " ha elegido: " + dato);
						salida.print("00");
						PiedraPapelTijera.muestraAleatorio();
						
						if(opc!=4){
							JuegoPPT.setcompruebaganador(PiedraPapelTijera.compruebaGanador(Jugador.getOpcion(), PiedraPapelTijera.getaleatorio()));
								if(JuegoPPT.getcompruebaganador()==-1) System.out.println("     " + Jugador.getNombre() + " ha EMPATADO la ronda.\n");
								else if(JuegoPPT.getcompruebaganador()==0) System.out.println("     " + Jugador.getNombre() + " ha PERDIDO la ronda.\n");
								else System.out.println("     " + Jugador.getNombre() + " ha GANADO la ronda.\n");
							Jugador.mensajePuntuacion(JuegoPPT.getcompruebaganador());
							salida.print(Jugador.getPerdidas()+ "/3 rondas perdidas.");
						}					
					}
					
				}while(!salir);
				
				System.out.println("\n  " + Jugador.getNombre() + " ha terminado la partida.");
				salida.println("00---------------------------------------------------------------------------------");
				salida.println("00Ha terminado la partida. ¡¡Gracias por jugar!!");
				salida.println("00Has obtenido una puntuación total de "+Jugador.generaPuntuacion()+" puntos con:");
				salida.println("00 - "+Jugador.getGanadas()+" partidas ganadas.");
				salida.println("00 - "+Jugador.getEmpatadas()+" partidas empatadas.");
				salida.println("00 - "+Jugador.getPerdidas()+" partidas perdidas.");
				salida.println("00---------------------------------------------------------------------------------");
				
				
				do{
					salida.println("00");
					salida.println("00¿Quieres volver a jugar? Elige una opción:");
					salida.println("01 1 - Sí / 2 - No");
					dato = entrada.readLine();
					opc = Integer.parseInt(dato);
					
				}while(opc < 1 || opc > 2);
				
				Jugador.setopcion(-1);
				if(opc==1) System.out.println("\n" + Jugador.getNombre() + " comienza una nueva partida.\n");
				else System.out.println("\n" + Jugador.getNombre() + " ha acabado el programa.\n");
				
			}while(opc == 1);
			
			salida.println("00");
			salida.println("11");
					
		entrada.close();
		salida.close();
		con.close();
	
	} catch (Exception e) {
		System.out.println("Fallo en la conexión.");
	}
	
	}
	
	
}

