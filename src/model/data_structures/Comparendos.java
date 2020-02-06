package model.data_structures;

public class Comparendos
{
	private int OBJECTID;
	private String FECHA_HORA;
	private String MEDIO_DETE;
	private String CLASE_VEHI;
	private String TIPO_SERVI;
	private String INFRACCION;
	private String DES_INFRAC;
	private String LOCALIDAD;
	private double LATITUD;
	private double LONGITUD;
	public Comparendos(int nId, String nFecha, String nMediodete, String nClaseVehiculo, String nTipo, String nINfraccion, String nDescrip, String nLocalidad,double nLatitud, double nLongitud)
	{
		OBJECTID = nId;
		FECHA_HORA = nFecha;
		MEDIO_DETE = nMediodete;
		CLASE_VEHI = nClaseVehiculo;
		TIPO_SERVI = nTipo;
		INFRACCION = nINfraccion;
		DES_INFRAC = nDescrip;
		LOCALIDAD = nLocalidad;
		LATITUD = nLatitud;
		LONGITUD = nLongitud;




	}
	public int darID()
	{
		return OBJECTID;
	}
	public String toString()
	{
		return("El número de la infracción es :" + OBJECTID  + "en las cordenadas:" + LATITUD + "," + LONGITUD);
	}

}
