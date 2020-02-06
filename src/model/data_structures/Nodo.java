package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class Nodo <E>
{
	/**
	 * Nodo siguiente
	 */
	private Nodo<E> next;
	/**
	 * Contenido del Nodo
	 */
	private E item;
/**
 * metodo contructor del nodo
 * @param x item del nodo
 */
	public Nodo(E x) 
	{
		next = null;
		item = x;
	} 
	/**
	 * Obtener el Nodo siguiente
	 * @return el Nodo siguiente
	 */
	public Nodo<E> getNext() 
	{
		return next;
	}

	/**
	 * Cambiar el nodo siguiente
	 * @param x Nodo que va a ir siguiente
	 */
	public void setNextNode ( Nodo<E> x) 
	{
		next = x;
	} 

	/**
	 * Obtiene el item que esta en el nodo
	 * @return item del nodo
	 */
	public E getItem()
	{
		return item;
	} 
	/**
	 * Cambia el item del nodo
	 * @param x item que se quiere meter al nodo
	 */
	public void setItem (E x) 
	{ 
		item = x;
	}

}
