public class nodo
{
	// ---------------------------------------- Atributos ---------------------------------------------------------------
	private int ejeX;
	private int ejeY;
	private nodo siguiente;
	private nodo anterior;


	// ---------------------------------------- Constructor -------------------------------------------------------------
	public nodo()
	{
	}



	public nodo(int ejeX, int ejeY)
	{
		this.ejeX = ejeX;
		this.ejeY = ejeY;
		this.siguiente = null;
		this.anterior = null;

	}


	//------------------------------------------ Metodos ------------------------------------------------------------------

	//Sets
	public void setEjeX(int ejeX)
	{
		this.ejeX = ejeX;
	}
	public void setEjeY(int ejeY)
	{
		this.ejeY = ejeY;
	}
	public void setSiguiente(nodo siguiente)
	{
		this.siguiente = siguiente;
	}
	public void setAnterior(nodo anterior)
	{
		this.anterior = anterior;
	}

	//Gets
	public int getEjeX()
	{
		return ejeX;
	}
	public int getEjeY()
	{
		return ejeY;
	}

	public nodo getSiguiente()
	{
		return siguiente;
	}
	public nodo getAnterior()
	{
		return anterior;
	}

}
