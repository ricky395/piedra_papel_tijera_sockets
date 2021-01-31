

import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) {
			
			int n = 0;
						
			try {
				
				
				//se crea servidor en el puerto 12334
				ServerSocket serv= new ServerSocket (12334);
				System.out.println ("Servidor creado en el puerto: "+ serv.getLocalPort());
				
				//el servidor espera la conexion de un cliente
				while (true){
					
					n++;
					//creamos socket y flujos 
					Socket c= serv.accept();		
					Thread t= new Thread (new Hilo(c, n));
					System.out.println ("\n\nSockets creados en Servidor. Conectado con cliente");
					t.start();
				}


		//excepciones en caso de error.
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
