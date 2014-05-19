public class lista
{
	// ---------------------------------------- Atributos -----------------------------------------------------------------
	private nodo primero;
	private nodo ultimo;

	// ---------------------------------------- Constructor ---------------------------------------------------------------
	public lista()
	{
	}

	//------------------------------------------ Metodos ------------------------------------------------------------------

	//Sets
	public void setPrimero(nodo primero)
	{
		this.primero = primero;
	}
	public void setUltimo(nodo ultimo)
	{
		this.ultimo = ultimo;
	}

	//Get
	public nodo getPrimero()
	{
		return primero;
	}
	public nodo getUltimo()
	{
		return ultimo;
	}

	//Comprobar si la lista esta vacia
	public boolean vaciaLista()
	{
		return primero == null;
	}



	//Inserta nodos al final (Hace lista)
	public void insertaLista (int ejeX, int ejeY)
	{
		if (vaciaLista())
		{
			primero = ultimo = new nodo (ejeX, ejeY);
		}
		else
		{
			nodo nuevo = new nodo (ejeX, ejeY);
			ultimo.setSiguiente(nuevo);
			nuevo.setAnterior(ultimo);
			ultimo = nuevo;
		}
	}



	//Funcion que verifica si esta en la lista
	public boolean member (int ejeX, int ejeY, lista l)
	{

		nodo aux = l.getPrimero();
		while (aux != null)
		{
			if ((ejeX == aux.getEjeX()) && (ejeY == aux.getEjeY()))
			{
				return true;
			}
			else
			{
				aux = aux.getSiguiente();
			}
		}
		return false;
	}



	//Busca un nodo de acuerdo al x y
	public nodo buscaNodo(int ejeX,int ejeY, lista todos)
	{
		nodo Aux = todos.getPrimero();
		while (Aux != null)
		{
			if ((Aux.getEjeX() == ejeX)&&(Aux.getEjeY() == ejeY))
			{
				return Aux;

			}
			else
			{
				Aux = Aux.getSiguiente();
			}
		}
		return null;
	}

	//Elimina al final
	public void eliminaFinal(lista abierta)
	{
		ultimo = ultimo.getAnterior();
		ultimo.setSiguiente(null);
	}
}