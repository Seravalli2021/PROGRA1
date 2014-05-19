
public class PrincipalLista
{
	private static lista prueba;

	public static void main(String[] args)
	{
		prueba = new lista();
		prueba.insertaLista(2,2);
		prueba.insertaLista(1,1);
		prueba.insertaLista(3,2);


		nodo aux1 = prueba.getPrimero();

		while (aux1 != null)
		{
			System.out.println("eje X: " + " " + aux1.getEjeX() + "eje Y: "+ aux1.getEjeY());
			aux1 = aux1.getSiguiente();
		}

		nodo aux2 = prueba.buscaNodo(1,1,prueba);




	}
}