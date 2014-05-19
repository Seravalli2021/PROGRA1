import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class Interfaz implements MouseListener, MouseMotionListener
{

	//ATRIBUTOS
	private JFrame ventana1, ventana2,ventana3,ventana4,ventana5;
	private JPanel panel1,panel2,panel3,panel4,panel5;
	private ImageIcon imagen1,imagen2,imagen3,imagen4;
	private JButton boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10,boton11;
	private JTextField texto1,texto2,texto3,texto4;
	private JLabel etiqueta1,etiqueta2,etiqueta3,etiquetaReinas[][],etiqueta4,etiqueta5,
	etiqueta6,etiqueta7,etiqueta8,etiqueta9,etiquetaCab[][];
	private static lista sol,ls;
	private JTextPane area1,area2;
	private JScrollPane scroll1,scroll2;
	int eje1,eje2,inix, iniy;
	int ventana = 0;
	File archivo = null;
	FileReader fr = null;
    BufferedReader br = null;


    int tama=8;
    Caballo caballo;
    Tablero tablero;

	public Interfaz()
	{
		super();

		eje1=1;
		inix =1;
		iniy=1;
		eje2=1;


		//--------------------------------------------------------------------- VENTANA N° 1 -------------------------------------------------------------

		ventana1 = new JFrame("Inicio");
		panel1 = new JPanel();
		imagen1 = new ImageIcon("portada.jpg");
		etiqueta1 = new JLabel(imagen1);

		boton1 = new JButton("Reinas");
		boton2 = new JButton("Caballo");
		boton3 = new JButton("Ayuda/Acerca");
		boton4 = new JButton("Salir");

		panel1.setLayout(null);
		panel1.setBackground(new Color(0, 0, 0));

		addComponent(panel1, boton4, 120,210,100,20);
		addComponent(panel1, boton3, 230,180,120,20);
		addComponent(panel1, boton2, 120,180,100,20);
		addComponent(panel1, boton1, 10,180,100,20);
		addComponent(panel1, etiqueta1, 0,0,343,257);
		ventana1.add(panel1);

		ventana1.setLocation(new Point(300, 50));
		ventana1.setSize(375, 280);
		ventana1.setVisible(true);
		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton1_actionPerformed(e);
		}
		});

		boton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton2_actionPerformed(e);
		}
		});
		boton3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton3_actionPerformed(e);
		}
		});

		boton4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton4_actionPerformed(e);
		}
		});

		//---------------------------------------------------------- VENTANA 2 (salida) ----------------------------------
		ventana2 = new JFrame("Esta seguro?");
		panel2 = new JPanel();
		imagen2 = new ImageIcon("seguro.jpg");
		etiqueta2 = new JLabel(imagen2);

		boton5 = new JButton("Si");
		boton6 = new JButton("No");

		panel2.setLayout(null);
		panel2.setBackground(new Color(0, 0, 0));

		addComponent(panel2, boton6, 200,60,60,20);
		addComponent(panel2, boton5, 130,60,60,20);
		addComponent(panel2, etiqueta2, 0,0,312,108);
		ventana2.add(panel2);

		ventana2.setLocation(new Point(300, 50));
		ventana2.setSize(328, 130);
		ventana2.setVisible(false);
		ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boton5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton5_actionPerformed(e);
		}
		});

		boton6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton6_actionPerformed(e);
		}
		});

		//----------------------------------------------------------ventana 3
		ventana3 = new JFrame("Problema de la Reinas");
		panel3 = new JPanel();
		imagen3 = new ImageIcon("tablero.jpg");
		etiqueta3 = new JLabel(imagen3);

		boton7 = new JButton("Resolver");
		boton8 = new JButton("Regresar");

		panel3.setLayout(null);
		panel3.setBackground(new Color(30,16,89));

		etiqueta4 = new JLabel("POS X");
		etiqueta4.setForeground(Color.yellow);
		etiqueta4.setFont(new Font("Serif", Font.BOLD, 12));

		etiqueta5 = new JLabel("POS Y");
		etiqueta5.setForeground(Color.yellow);
		etiqueta5.setFont(new Font("Serif", Font.BOLD, 12));

		texto1 = new JTextField("");
		texto2 = new JTextField("");

		etiquetaReinas = new JLabel[8][8];
		for (int j = 0; j<8; j++)
		{

			for (int i = 0; i<8; i++)
			{
				imagen4 = new ImageIcon("queen.png"); //54x54
				etiquetaReinas[j][i] = new JLabel(imagen4);
				addComponent(panel3, etiquetaReinas[j][i],(j*54) ,(i*54),54,54);
				etiquetaReinas[j][i].setVisible(false);

			}
		}

		addComponent(ventana3, boton8, 165,500,90,20);
		addComponent(ventana3, boton7, 165,480,90,20);
		addComponent(ventana3, texto2,260,445,60,20);
		addComponent(ventana3, etiqueta5, 210,445,60,20);
		addComponent(ventana3, texto1, 140,445,60,20);
		addComponent(ventana3, etiqueta4, 90,445,60,20);
		addComponent(ventana3, etiqueta3, 0,0,415,426);
		ventana3.add(panel3);

		texto1.setEditable(false);
		texto2.setEditable(false);
		ventana3.setLocation(new Point(10, 10));
		ventana3.setSize(435, 560);
		ventana3.setVisible(false);
		panel3.addMouseListener(this);
		panel3.addMouseMotionListener(this);

		ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boton7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton7_actionPerformed(e);
		}
		});

		boton8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton8_actionPerformed(e);
		}
		});

		//--------------------------------------------------------ventana 4
		ventana4 = new JFrame("AYUDA");
		panel4 = new JPanel();

		etiqueta6 = new JLabel("Ventana de ayuda / Acerda de");
		etiqueta6.setForeground(Color.yellow);
		etiqueta6.setFont(new Font("Serif", Font.BOLD, 18));

		panel4.setLayout(null);
		panel4.setBackground(new Color(30,16,89));

		area1 = new JTextPane ();
		scroll1 = new JScrollPane(area1);
		area1.setEditable(false);

		boton9 = new JButton("REGRESAR");

		addComponent(panel4, boton9, 250,250,120,20);
		addComponent(panel4, scroll1, 30,30,500,200);
		addComponent(panel4, etiqueta6, 0,0,300,30);
		ventana4.add(panel4);

		ventana4.setLocation(new Point(10, 10));
		ventana4.setSize(580, 320);
		ventana4.setVisible(false);

		boton9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton9_actionPerformed(e);
		}
		});

		//----------------------------------------------------------------ventana 5
		ventana5 = new JFrame("solucion del caballo");
		panel5 = new JPanel();
		etiqueta7 = new JLabel(imagen3);

		etiqueta8 = new JLabel("POS X");
		etiqueta8.setForeground(Color.yellow);
		etiqueta8.setFont(new Font("Serif", Font.BOLD, 12));

		etiqueta9 = new JLabel("POS Y");
		etiqueta9.setForeground(Color.yellow);
		etiqueta9.setFont(new Font("Serif", Font.BOLD, 12));

		texto3 = new JTextField("");
		texto4 = new JTextField("");

		boton10 = new JButton("Resolver");
		boton11 = new JButton("Regresar");

		area2 = new JTextPane ();
		scroll2 = new JScrollPane(area2);
		area2.setEditable(false);

		panel5.setLayout(null);
		panel5.setBackground(new Color(30,16,89));

		etiquetaCab = new JLabel[8][8];
		for (int j = 0; j<8; j++)
		{
			for (int i = 0; i<8; i++)
			{
				etiquetaCab[j][i] = new JLabel();
				etiquetaCab[j][i].setForeground(Color.blue);
				etiquetaCab[j][i].setFont(new Font("Serif", Font.BOLD, 25));
				addComponent(panel5, etiquetaCab[j][i],(j*54) ,(i*54),54,54);
				etiquetaCab[j][i].setVisible(true);

			}
		}


		addComponent(ventana5, boton11,480,380,100,20);
		addComponent(ventana5, boton10,480,350,100,20);
		addComponent(ventana5, scroll2,440,70,180,200);
		addComponent(ventana5, texto4, 495,40,60,20);
		addComponent(ventana5, etiqueta9, 445,40,60,20);
		addComponent(ventana5, texto3, 495,10,60,20);
		addComponent(ventana5, etiqueta8, 445,10,60,20);
		addComponent(ventana5, etiqueta7, 0,0,415,426);
		ventana5.add(panel5);

		texto3.setEditable(false);
		texto4.setEditable(false);
		ventana5.setLocation(new Point(10, 10));
		ventana5.setSize(650, 470);
		ventana5.setVisible(false);
		panel5.addMouseListener(this);
		panel5.addMouseMotionListener(this);

		boton10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton10_actionPerformed(e);
		}
		});

		boton11.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		 	boton11_actionPerformed(e);
		}
		});




	}



		//--------------------------------------------------------------------- METODOS-------------------------------------------------------------------

		//Agregar elementos a un contenedor
		private void addComponent(Container container,Component c,int x,int y,int width,int height)
		{
		 	c.setBounds(x,y,width,height);
		 	container.add(c);
		}
		public void actionPerformed( ActionEvent actionEvent )
		{
		}

		public void mouseExited(MouseEvent evento)
		{

		}

		public void mouseEntered(MouseEvent evento)
		{

		}

		public void mouseReleased(MouseEvent evento)
		{
		}

		public void mousePressed(MouseEvent evento)
		{
		}

		public void mouseClicked(MouseEvent evento)
		{
			if (ventana == 3)
			{
				eje2=((evento.getX()/54)+1);
				eje1=((evento.getY()/54)+1);

				if ((eje1>8)||(eje2>8))
				{
					//System.out.println("error");
					 JOptionPane.showMessageDialog(null, "Error, favor seleccionar una posicion dentro del tablero");
				}
				else
				{

					texto1.setText(""+eje1);
					texto2.setText(""+eje2);


				}


			}
			if (ventana == 5)
			{
				inix =((evento.getY()/54)+1);
				iniy =((evento.getX()/54)+1);

				if ((inix>8)||(iniy >8))
				{
					//System.out.println("error");
					JOptionPane.showMessageDialog(null, "Error, favor seleccionar una posicion dentro del tablero");
				}
				else
				{

					texto3.setText(""+inix);
					texto4.setText(""+ iniy    );

				}


			}
		}
		public void mouseMoved(MouseEvent evento)
		{
		}
		public void mouseDragged(MouseEvent evento)
		{
		}

		//---------------------------------------------------------------------- BOTONES ------------------------------------------------------------------
		//botones

		//ventana 1

		//boton 8 reinas
		private void boton1_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(false);
			ventana3.setVisible(true);
			ventana = 3;
		}
		//boton caballo
		private void boton2_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(false);
			ventana5.setVisible(true);
			ventana = 5;
		}

		//boton ayuda
		private void boton3_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(false);
			ventana4.setVisible(true);
			try
			{
				archivo = new File ("ayuda.txt");
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);

				// Lectura del fichero
				String linea;
				while((linea=br.readLine())!=null)
				{
				     area1.setText(area1.getText() + linea +  "\n");

				 }
			}
			catch(Exception f)
			{
				f.printStackTrace();
      		}
		}
		//boton salir
		private void boton4_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(false);
			ventana2.setVisible(true);
		}

		//ventana 2

		//boton si
		private void boton5_actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
		//boton no
		private void boton6_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(true);
			ventana2.setVisible(false);
		}

		//ventana 3

		//resolver reinas
		private void boton7_actionPerformed(ActionEvent e)
		{

			NReinas reinas= new NReinas(8);
			reinas.buscarSoluciones();
			ArrayList soluciones = reinas.getSoluciones();
			for (int i = 0; i<soluciones.size();i++)
			{
				sol = new lista();
				int[] aux  = (int[]) soluciones.get(i);
			    for (int j = 0; j<aux.length;j++)
			    {
					sol.insertaLista((j+1),(aux[j]+1));

			    }

			    if (sol.member(eje2,eje1,sol))
				{
					break;
				}


			}
			//ocultar reinas
			for (int j = 0; j<8; j++)
			{
				for (int i = 0; i<8; i++)
				{
					etiquetaReinas[j][i].setVisible(false);

				}
			}
			//impresion de reinas
			int cont=0;
			nodo aux1 = sol.getPrimero();

			while (aux1 != null)
			{
				int x = (aux1.getEjeX()-1);
				int y = (aux1.getEjeY()-1);

				etiquetaReinas[x][y].setVisible(true);

				aux1 = aux1.getSiguiente();
				cont++;

			}

			addComponent(panel3, etiqueta3, 0,0,415,426);

		}

		//regresar a menu
		private void boton8_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(true);
			ventana3.setVisible(false);
			ventana =0;

			//ocultar reinas
			for (int j = 0; j<8; j++)
			{
				for (int i = 0; i<8; i++)
				{
					etiquetaReinas[j][i].setVisible(false);
				}
			}

			texto1.setText("");
			texto2.setText("");


		}

		//botones ventana 4

		//boton regresar al menu
		private void boton9_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(true);
			ventana4.setVisible(false);
		}

		//botones ventana 5

		//boton resolver problema del caballo
		private void boton10_actionPerformed(ActionEvent e)
		{
			//ocultar numeracion
			for (int j = 0; j<8; j++)
			{
				for (int i = 0; i<8; i++)
				{
					etiquetaCab[j][i].setText("");

				}
			}



			ls = new lista();
			area2.setText("");
			tablero = new Tablero(tama);
			inix = inix - 1;
			iniy = iniy - 1;
			caballo = new Caballo(inix, iniy);
			ls = caballo.hay_sol(tablero) ;
			int cont=1;

			nodo aux3 = ls.getPrimero();

			while (aux3 != null)
			{
				area2.setText(area2.getText() + "(" + aux3.getEjeX() + "," + aux3.getEjeY() + ")"+  "\n");
				int x = (aux3.getEjeX()-1);
				int y = (aux3.getEjeY()-1);
				etiquetaCab[y][x].setText("" + cont);
				etiquetaCab[y][x].setVisible(true);
				aux3 = aux3.getSiguiente();
				cont++;
			}

			addComponent(panel5, etiqueta7, 0,0,415,426);

		}

		//regresar al menu
		private void boton11_actionPerformed(ActionEvent e)
		{
			ventana1.setVisible(true);
			ventana5.setVisible(false);

			//ocultar numeracion
			for (int j = 0; j<8; j++)
			{
				for (int i = 0; i<8; i++)
				{
					etiquetaCab[j][i].setText("");

				}
			}
			area2.setText("");
			texto3.setText("");
			texto4.setText("");
		}

}
