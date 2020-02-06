package controller;

import java.util.Scanner;

import model.data_structures.Comparendos;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run()
	{
		try
		{
			Scanner lector = new Scanner(System.in);
			boolean fin = false;
			Comparendos  dato = null;
			Comparendos respuesta = null;

			while( !fin ){
				view.printMenu();

				int option = lector.nextInt();
				switch(option){
				case 1:
					view.printMessage("--------- \nBuscar elementos de la lista por posición");
					int pos  = lector.nextInt();
					Comparendos a = modelo.buscarPorPos(pos);
					if(a!= null)
						view.printMessage("el comparendo de la lista en la po" + pos + a);		
					else
					{
						view.printMessage("Dato  no encontrado");
					}
					break;

				case 2:
					view.printMessage("--------- \nDar Eliminar de la lista el elemento por pos: ");
					int pos1 = lector.nextInt();
					modelo.eliminar(pos1);
					view.printMessage("Dato eliminado");
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3:
					view.printMessage("--------- \nDar Dar tamaño: ");
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 4:
					view.printMessage("--------- \nDar Imprimir Lista");


				case 5: 
					view.printMessage("--------- \nLeer el Gson ");
					modelo.leer1();
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;	

				case 6: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
				}
			}
		}
		catch(Exception e ){

		}
	}

}
