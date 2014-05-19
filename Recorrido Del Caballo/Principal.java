import java.io.*;

/**
 * la clase Principal es la encargada de pedir los datos, asi como de
 * validar su introduccion
 */

public class Principal {
  /**
   * Atributos de la clase Principal
   */
  BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
  Tablero tablero;
  int longitud, inix, iniy;
  N_Caballo caballo;
  /**
   * Constructor sin parametros
   */
  public Principal() {

    try {
      do {
        System.out.print("\n");
        System.out.print("BIENVENIDO AL PROBLEMA DEL CABALLO DE AJEDREZ" + "\n");
        System.out.print(
            " introduzca el tamano del tablero: n*n (n debe ser mayor que 4)" +
            "\n");
        System.out.print(" n--> " + "\n");
        longitud = Integer.parseInt(teclado.readLine());
      }
      while (longitud < 5);
      tablero = new Tablero(longitud);

      do {
        System.out.print(" introduzca la posicion inicial del caballo: (x,y)" +
                         "\n");
        System.out.print(" x (numero de fila: de 1 hasta n-1) --> " + "\n");
        inix = Integer.parseInt(teclado.readLine());
        inix = inix - 1;
        System.out.print(" y (numero de colmuna: de 1 hasta n-1) --> " + "\n");
        iniy = Integer.parseInt(teclado.readLine());
        iniy = iniy - 1;
        System.out.print("\n");
      }
      while (inix >= longitud || iniy >= longitud);

    }
    catch (Exception e) {
      System.out.print("Hay un error al introducir los datos" + "\n");
    }
    caballo = new N_Caballo(inix, iniy);

    if (caballo.hay_sol(tablero) == true) {
      System.out.print("\n" + "\n");
      tablero.mostrar(longitud);
    }
    else
    {
      System.out.print("\n" + "\n");
      tablero.mostrar(longitud);
      System.out.print(" no es posible recorrer el tablero");
    }
  }
  /**
   * metodo main
   */
  public static void main(String[] args) {
    Principal principal1 = new Principal();
  }

}