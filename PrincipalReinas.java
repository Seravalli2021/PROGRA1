import java.util.ArrayList;

public class PrincipalReinas {

	private static lista prueba;


    public static void main(String[] args) {

        NReinas reinas= new NReinas(10);
        reinas.buscarSoluciones();
        ArrayList soluciones = reinas.getSoluciones();

        for (int i = 0; i<soluciones.size();i++)
        {
			prueba = new lista();
			int[] aux  = (int[]) soluciones.get(i);

            for (int j = 0; j<aux.length;j++)
            {
				System.out.print("(" + (j+1) + "," + (aux[j]+1) + ")");
				prueba.insertaLista((j+1),(aux[j]+1));
            }

            System.out.println("");
			if (prueba.member(5,8,prueba))
			{
				break;
			}


        }

        nodo aux1 = prueba.getPrimero();
        while (aux1 != null)
		{
			System.out.println("eje X: " + " " + aux1.getEjeX() + " eje Y: "+ aux1.getEjeY());
			aux1 = aux1.getSiguiente();
		}

    }

}
