package model.data_structures;

import java.util.Iterator;

public class Lista <T> 
{
	private Nodo<T> primero;
	private int tamano; 
	private Nodo<T> ultimo;
	{
		primero = null; 
	}
	public Lista () 
	{
		primero = null; 
		tamano = 0; 
	}
	public void agregarUltimo(T primer)
	{
		Nodo<T> nuevo = new Nodo<>(primer);
		if(primero == null)
		{
			primero = nuevo;
		}
		else
		{
			Nodo<T> actual = primero;
			while(actual.getNext() !=null)
			{
				actual = actual.getNext();
			}
			actual.setNextNode(nuevo);
			tamano++;
		}
	}
	public Nodo<T> darUltimo()
	{
		if(!estaVacia())
		{
			Nodo<T> actual = primero;
			while (actual.getNext() != null)
			{
				actual = actual.getNext();
			}
			if(actual.getNext() == null)
				ultimo = actual;
			return ultimo;
		}
		else
		{
			return null;
		}



	}
	public void agregarPrimero(T x)
	{
		if(!estaVacia())
		{
			Nodo<T> nuevo = new Nodo<>(x);
			nuevo.setNextNode(primero);
			primero = nuevo;
			tamano ++;
		}

	}
	public T eliminar(int pos) throws Exception
	{
		T eliminado = null;
		if(!estaVacia())
		{
			int contador =0;
			if(pos< 0 || pos> tamano)
				throw new ArrayIndexOutOfBoundsException(pos);
			if(pos == 0)
			{
				primero = primero.getNext();
				tamano --;
				eliminado = primero.getItem();
			}
			else
			{
				Nodo<T> actual = primero;
				Nodo<T> siguiente = primero.getNext();
				while(actual.getNext().getNext() != null && actual.getNext()!=null)
				{
					contador ++;
					if(contador == pos-1)
					{
						actual.setNextNode(siguiente.getNext());
					}
					tamano--;
				}
				eliminado = actual.getItem();

			}
		}
		return eliminado;
	}
	public int darTamano()
	{
		return tamano;
	}
	public T buscarPorId(int ID) throws Exception
	{
		if(!estaVacia())
		{
			Nodo<T> encontrado = null;
			if(ID<0)
				throw new Exception ("El iD es positivo");
			else
			{
				Nodo<T> actual = primero;
				while(actual!=null)
				{
					actual = actual.getNext();
					Comparendos x = (Comparendos) actual.getItem();
					if(ID == x.darID())
					{
						encontrado = actual;
					}
				}
				return encontrado.getItem();
			}
		}
		else
		{
			return null;
		}

	}
	public T buscarPorPos(int pos ) throws Exception
	{
		int contador = 0;
		if(!estaVacia())
		{
			Nodo<T> encontrado = null;
			if(pos<0 && pos> tamano)
				throw new ArrayIndexOutOfBoundsException(pos);
			else
			{
				Nodo<T> actual = primero ;
				while (actual !=null)
				{
					contador++;
					actual = actual.getNext();
					if(contador == pos)
					{
						encontrado = actual;
					}

				}
			}
			return encontrado.getItem();

		}
		else
		{
			return null;
		}
	}
	public boolean estaVacia()
	{
		if(primero !=null)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}


}
