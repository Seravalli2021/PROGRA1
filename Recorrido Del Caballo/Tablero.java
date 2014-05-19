/**
 * Representa un tablero con sus diferentes caracteristicas
 */
public class Tablero {
  /**
   * Atributos de la clase tablero
   */
  int[][] tabla;
  int longitud;
  /**
   * Constructor com parametros
   * @param longitud La longitud del tablero
   */
  public Tablero(int longitud) {
    tabla = new int[longitud][longitud];
    this.longitud = longitud;
  }

  /**
   * Imprime por pantalla el tablero
   * @param longitud La longitud del tablero de ajedrez
   */
  public void mostrar(int longitud) {

    for (int i = 0; i < longitud; i++)
      for (int j = 0; j < longitud; j++) {
        if (j < longitud - 1) {
          if (tabla[i][j] < 10)
            System.out.print(tabla[i][j] + "  | ");
          else {
            if (tabla[i][j] < 100)
              System.out.print(tabla[i][j] + " | ");
            else
              System.out.print(tabla[i][j] + "| ");
          }
        }
        else
          System.out.print(tabla[i][j] + "\n");
      }
  }

}