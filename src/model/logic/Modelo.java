package model.logic;

import model.data_structures.Nodo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import com.google.gson.Gson;

import model.data_structures.Comparendos;
import model.data_structures.Lista;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private Lista datos;
	private Gson gson = new Gson();

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new Lista();
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregarPrimero(Comparendos dato)
	{	
		datos.agregarPrimero(dato);;
	}
	public void agregarUltimo(Comparendos dato)
	{	
		datos.agregarUltimo(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Comparendos buscarPorID(int x) throws Exception
	{
		return (Comparendos) datos.buscarPorId(x);
	}
	public Comparendos buscarPorPos(int x) throws Exception 
	{
		return (Comparendos)datos.buscarPorPos(x);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Comparendos  eliminar(int x) throws Exception
	{
		return (Comparendos) datos.eliminar(x);
	}

	public void leerGson()
	{
		System.out.println("Reading JSON from a file");
		System.out.println("----------------------------");
		boolean proceso = false;
		int ID = 0;
		String FECHA = "AI";
		String MEDIODETECCION = "";
		String CLASEVEHICULO = "";
		String TIPOSERVICIO = "";
		String INFRACCION = "";
		String DESCRIPCCION = "";
		String LOCALIDAD = "";
		double LATITUD = 0.0;
		double LONGITUD = 0.0;

		try
		{
			String ruta = "./data/comparendos_dei_2018_small.geojson";
			BufferedReader br = new BufferedReader(new FileReader(ruta));



			if(br.readLine().equals("properties") && !proceso)
			{
				String linea = br.readLine();
				String[] arreglo = linea.split(",");
				for (int i = 0; i < arreglo.length; i++) 
				{
					String actual = arreglo[i];
					String[] separador = actual.split(" ");

					if(separador[0].equals("OBJECTID :"))
					{

						ID = Integer.parseInt(separador[1]);
					}
					if(separador[0].equals("FECHA_HORA :"))
					{
						FECHA = separador[1];
					}
					if(separador[0].equals("MEDIO_DETE:"))
					{
						MEDIODETECCION = separador[1];
					}
					if(separador[0].equals("CLASE_VEHI :"))
					{

						CLASEVEHICULO = separador[1];
					}
					if(separador[0].equals("TIPO_SERVI :"))
					{

						TIPOSERVICIO = separador[1];
					}
					if(separador[0].equals("INFRACCION :"))
					{
						INFRACCION = separador[1];
					}
					if(separador[0].equals("DES_INFRAC :"))
					{

						DESCRIPCCION = separador[1];
					}
					if(separador[0].equals("LOCALIDAD :"))
					{

						LOCALIDAD = separador[1];
					}
					if(separador[0].equals("coordinates:"))
					{
						String lineaSiguiente = br.readLine();
						actual = lineaSiguiente;
						LATITUD = Double.parseDouble(actual);
						LONGITUD = Double.parseDouble(actual+1);

					}

					agregarUltimo(new Comparendos(ID, FECHA, MEDIODETECCION, CLASEVEHICULO, TIPOSERVICIO, INFRACCION, DESCRIPCCION, LOCALIDAD, LATITUD,LONGITUD));
					Comparendos x = gson.fromJson(br, Comparendos.class);
					agregarUltimo(x);

					proceso = true;



				}
			}
		}


		catch(Exception e)
		{

		}
	}
	public void leer1()
	{
		String son = gson.toString(); 
		Comparendos x = gson.fromJson(son, Comparendos.class);
		System.out.println(x);
	}




}
