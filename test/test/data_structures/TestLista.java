package test.data_structures;

import model.data_structures.Comparendos;
import model.data_structures.Lista;
import model.data_structures.Nodo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLista <E>{

	private Lista<E> lista;


	@Before
	public void setUp1() 
	{
		lista = new Lista<E>();
	}

	public void setUp2() 
	{
		Comparendos primer = new Comparendos(1, "x", "y ", "z ", "a", "b ", "c", "d",13.3,12.2);
		lista.agregarUltimo( (E) primer);

	}

	@Test
	public void testdarTamano() {
		setUp1();
		setUp2();
		assertTrue(lista.darTamano() == 1);
	}

	@Test
	public void testBucar() {
		setUp2();
		setUp1();
		try
		{
			assertTrue("El número de la infracción es : 1 en las cordenadas 13.3,12.2" ==  lista.buscarPorPos(0).toString());
		}
		catch(Exception e)
		{

		}
	}
	public void testEliminar()
	{
		setUp1();
		setUp2();
		try {
			lista.eliminar(0);
			assertTrue(lista.darTamano() == 0);


		} catch (Exception e) {

		}

	}

}
