package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Comparendos;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;


	@Before
	public void setUp1()
	{
		modelo = new Modelo();
	}

	public void setUp2()
	{
		Comparendos primer = new Comparendos(1, "x", "y ", "z ", "a", "b ", "c", "d",13.3,12.2);
		modelo.agregarUltimo( primer);
	}


	@Test
	public void testDarTamano()
	{
		assertTrue(modelo.darTamano() == 1);
	}

	@Test
	public void testAgregar() 
	{
		setUp1();
		setUp2();
		Comparendos agregado = new Comparendos(2, "X", "Y ", "Z ", "A", "B ", "C", "D",13.4,12.4);
		try
		{
			modelo.agregarUltimo(agregado);
			assertTrue(modelo.darTamano() == 2);

		}
		catch(Exception e )
		{

		}
	}

	@Test
	public void testBuscar() {
		try
		{
			setUp2();
			setUp1();
			assertTrue("El número de la infracción es : 1 en las cordenadas 13.3,12.2" ==  modelo.buscarPorPos(0).toString());
		}
		catch(Exception e)
		{

		}
	}

	@Test
	public void testEliminar()
	{
		setUp1();
		setUp2();
		try 
		{
			modelo.eliminar(0);
			assertTrue(modelo.darTamano() == 0);

		}
		catch (Exception e) 
		{

		}


	}

}
