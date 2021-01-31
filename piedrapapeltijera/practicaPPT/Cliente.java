
/**
*
* @author Redes y Entornos Multijugador 
* @version 1.0
*/
import java.net.*; 
import java.io.*;
/**
*/
import java.util.Scanner;


public class Cliente {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String envio="";
		String recibo="";
		String codigo="";
		String mensaje="";
				
		try{
			Socket s= new Socket ("localhost", 12334);
			PrintWriter salida= new PrintWriter(s.getOutputStream(),true);
			BufferedReader entrada= new BufferedReader (new InputStreamReader(s.getInputStream()));
								   //memoria intermedia  //interpreta la info  //obtiene los bytes tal cual entran 
			
			//identificacion de los datos de conexion
			System.out.println(" Máquina origen: " + s.getLocalAddress() + " - Puerto: " + s.getLocalPort());
			System.out.println(" Máquina destino: " + s.getInetAddress() + " - Puerto: " + s.getPort() +"\n");
			
			do{
				recibo = entrada.readLine();
				//System.out.println(recibo);
				codigo = recibo.substring(0,2);
				mensaje = recibo.substring(2);
				
				if(codigo.equals("00")){ //solo leo datos recibidos
					System.out.println(mensaje);

				}
				
				else if(codigo.equals("01")){ //leo datos recibidos y envío otro dato
					System.out.println(mensaje);
					envio=teclado.nextLine();
					salida.println(envio);
				}
												
			}while(!codigo.equals("11") && recibo != null);
				
			
			System.out.println("\nFin del programa.");
			
			teclado.close();
			salida.close();
			entrada.close();
			s.close();
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}