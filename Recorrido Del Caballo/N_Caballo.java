/**
 * Representa un juego con sus diferentes caracteristicas
 */
public class N_Caballo {
  /**
   * Atributos de la clase caballo
   */
  int x, y;
  int nuevax = 0, nuevay = 0, solx = 0, soly = 0, total = 0;
  /**
   * Constructor com parametros
   * @param x La coordenada x del punto de partida
   * @param y La coordenada y del punto de partida
   */
  public N_Caballo(int x, int y) {
    this.x = x;
    this.y = y;
  }

 /**
  * Instancia de tipo lista
  */
  private static lista ls;

  /**
   * Devuelve verdadero si recorre todo el tablero
   * @param tabla El tablero donde se desarrolla el juego
   * @return devuelve "true" si es capaz de recorrer todo el tablero
   * correctamente
   */
  public boolean hay_sol(Tablero tabla) {

	ls = new lista();

    for (int num = 1; num < tabla.longitud * tabla.longitud + 1; num++) {

      ls.insertaLista((x + 1),(y + 1));
      tabla.tabla[x][y] = num;

      if ( (posible_mover(tabla, x, y, num) == false &&
            num < tabla.longitud * tabla.longitud - 1))
        return false;
    }

    nodo temp = ls.getPrimero();

	  while (temp != null)
	  {
	 		System.out.print("(" + temp.getEjeX() + "," + temp.getEjeY() + ")"+  "\n");
	  		temp = temp.getSiguiente();
	  }

    return true;
  }

  /**
   * Devuelve falso si no puede realizarse el movimiento
   * @param tabla El tablero donde se desarrolla el juego
   * @param xx La coordenada x del punto de partida
   * @param yy La coordenada y del punto de partida
   * @param num El numero de casilla recorrida
   * @return devuelve "false" si no es posible recorrer todo el tablero
   */
  public boolean posible_mover(Tablero tabla, int xx, int yy, int num) {

    int accesible, minaccesible;
    minaccesible = 9;
    solx = xx;
    soly = yy;

    for (int i = 1; i < 9; i++) { //mirar si es 9 o es 8
      if (puede_saltar(tabla, i, x, y, nuevax, nuevay) == true) {
        accesible = contar_casillas(tabla, nuevax, nuevay);
        if ( (accesible < minaccesible) && ((accesible > 0) ||
        ((accesible == 0) && (num ==tabla.longitud * tabla.longitud - 1)) ) ) {

        minaccesible = accesible;
          solx = nuevax;
          soly = nuevay;
        } //fin del segundo if
      } //fin del primer if
    } //fin del for
    x = solx;
    y = soly;
    return (minaccesible < 9);
  }

  /**
   * Devuelve falso si el salto no es posible
   * @param tabla El tablero donde se desarrolla el juego
   * @param i Indica el tipo de salto a realizar
   * @param valex La coordenada x de la casilla actual
   * @param valey La coordenada y de la casilla actual
   * @param nx La coordenada x de la casilla a la que salta
   * @param ny La coordenada y de la casilla a la que salta
   * @return devuelve "false" si no es posible realizar el salto
   */
  public boolean puede_saltar(Tablero tabla, int i, int valex, int valey, int nx, int ny)
  {
    nuevax = nx;
    nuevay = ny;
    switch (i) {
      case 1:
        nuevax = valex - 1;
        nuevay = valey - 2;
        break;
      case 2:
        nuevax = valex - 2;
        nuevay = valey - 1;
        break;
      case 3:
        nuevax = valex - 2;
        nuevay = valey + 1;
        break;
      case 4:
        nuevax = valex - 1;
        nuevay = valey + 2;
        break;
      case 5:
        nuevax = valex + 1;
        nuevay = valey + 2;
        break;
      case 6:
        nuevax = valex + 2;
        nuevay = valey + 1;
        break;
      case 7:
        nuevax = valex + 2;
        nuevay = valey - 1;
        break;
      case 8:
        nuevax = valex + 1;
        nuevay = valey - 2;
        break;

      default:
        System.out.print("La opcion elegida es incorrecta." + "\n");
    } //fin del switch

    return ( (0 <= nuevax) && (nuevax < tabla.longitud) && (0 <= nuevay) &&
            (nuevay < tabla.longitud) && (tabla.tabla[nuevax][nuevay] == 0));
  }

  /**
   * Devuelve el numero de casillas a las que puede saltar el caballo
   * desde una posicion dada
   * @param tabla El tablero donde se desarrolla el juego
   * @param x La coordenada x de la casilla actual
   * @param y La coordenada y de la casilla actual
   * @return accion El numero de casillas a las que se podria saltar desde
   * la casilla actual
   */
  public int contar_casillas(Tablero tabla, int x, int y) {

    int accion = 0, i, nx = 0, ny = 0;

    for (i = 1; i < 9; i++) {
      if (saltarSimulado(tabla, i, x, y, nx, ny))
        accion++;
    }
    return accion;
  }

  /**
   * Metodo llamado desde "contar" que simula los saltos que puede dar
   * el caballo desde una posicion dada, y devuelve falso si el salto no
   * es posible
   * @param tabla El tablero donde se desarrolla el juego
   * @param i Indica el tipo de salto a realizar
   * @param valex La coordenada x de la casilla actual
   * @param valey La coordenada y de la casilla actual
   * @param nx La coordenada x de la casilla a la que salta
   * @param ny La coordenada y de la casilla a la que salta
   * @return devuelve "false" si no es posible realizar el salto
   */
  public boolean saltarSimulado(Tablero tabla, int i, int valex, int valey, int nx, int ny)
  {

    switch (i) {
      case 1:
        nx = valex - 1;
        ny = valey - 2;
        break;
      case 2:
        nx = valex - 2;
        ny = valey - 1;
        break;
      case 3:
        nx = valex - 2;
        ny = valey + 1;
        break;
      case 4:
        nx = valex - 1;
        ny = valey + 2;
        break;
      case 5:
        nx = valex + 1;
        ny = valey + 2;
        break;
      case 6:
        nx = valex + 2;
        ny = valey + 1;
        break;
      case 7:
        nx = valex + 2;
        ny = valey - 1;
        break;
      case 8:
        nx = valex + 1;
        ny = valey - 2;
        break;

      default:
        System.out.print("La opcion elegida es incorrecta." + "\n");
    } //fin del switch

    return ( (0 <= nx) && (nx < tabla.longitud) && (0 <= ny) &&
            (ny < tabla.longitud) && (tabla.tabla[nx][ny] == 0));
  }

}