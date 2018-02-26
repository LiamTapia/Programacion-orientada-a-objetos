import java.io.*;
import javax.swing.*;

public class Ejercicio4{

        public static void main(String[] args)
        {
            Metodos m = new Metodos();
            m.Menu();  //Se llama al metodo que crea el menu

        }
}

class Metodos{

    public Metodos(){super();}

    public void Menu()
    {
        int bandera=1;

        do{ //do while para hacer un ciclo en el menu.
        Object[] opciones = {"Entera","Flotante","Cancelar"};

        int choice = JOptionPane.showOptionDialog(null, "Quieres Crear una matriz?", "Elige una opcion",
                                   JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null); //Impresion del menu.

        if(choice == 0 )//if que entra a la captura de datos de la matriz entera.
            {
                int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas."));   //JOptionPane que pide las variables.
                int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas."));
                int min = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el limite inferior."));
                int max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el limite superior."));

                Matrizint m1 = new Matrizint(fil,col,min,max);

                Object[] impresion = {"Consola","Grafico","Ambas","Cancelar"};

                int imprimir = JOptionPane.showOptionDialog(null, "Quieres imprimir la matriz?", "Elige una opcion",
                                   JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, impresion, null); //Impresion de la seleccion de impresion.

                if(imprimir==0) m1.imprimeMatrizint();   //Dependiendo de la opcion se seccionada se imprime o no se hace.
                    else if(imprimir==1) m1.imprimeMatrizintGrafica();
                    else if(imprimir==2) { m1.imprimeMatrizint(); m1.imprimeMatrizintGrafica(); }

                bandera = Reinicio(bandera); //Se llama al metodo de Reinicio para saber si acaba el programa.

            }

        else if(choice == 1) //if que crea la matriz de flotantes.
            {
                int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas."));   //JOptionPane que pide las variables.
                int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas."));
                int min = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el limite inferior."));
                int max = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el limite superior."));

                Matrizfloat m2 = new Matrizfloat(fil,col,min,max);

                Object[] impresion = {"Consola","Grafico","Ambas","Cancelar"};

                int imprimir = JOptionPane.showOptionDialog(null, "Quieres imprimir la matriz?", "Elige una opcion",
                                   JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, impresion, null); //Seleccion de impresion o no.

                if(imprimir==0) m2.imprimeMatrizfloat();
                    else if(imprimir==1) m2.imprimeMatrizfloatGrafica();
                    else if(imprimir==2) { m2.imprimeMatrizfloat(); m2.imprimeMatrizfloatGrafica(); }

                bandera = Reinicio(bandera); //Se llama al metodo de Reinicio para saber si acaba el programa.
            }

         else bandera = 0; //Si se elige cancel se acaba el ciclo.

        }while(bandera==1); //Si bandera cambia de valor acaba el do while.

    }

    public int Reinicio(int band){ //Metodo reinicio para acabar el programa.

        Object[] respuesta = {"Si", "No"};

                    int respfinal = JOptionPane.showOptionDialog(null,
                                       "Quieres seguir utilizando el programa?", "Elige una opcion", JOptionPane.YES_NO_OPTION,
                                       JOptionPane.INFORMATION_MESSAGE, null, respuesta, null); //Menu para saber si ya no se quieren rellenar datos.

                    if(respfinal == 1 ) band=0;
            return band; //Se regresa bandera original o alterada.
    }
}

class Matriz  //Clase padre matriz.
{
        int fila;
        int columna;

        public Matriz(){}

        public Matriz(int fila, int columna) //Constructor del padre.
        {
            this.fila = fila;
            this.columna = columna;
        }
}


class Matrizint extends Matriz
{

    int arre[][];

    public Matrizint()
    {
        super();
    }

    public Matrizint(int fila, int columna, int limitemin, int limitemax)  //Constructor de matriz de entero que hereda de matriz.
    {
        super(fila, columna);
        arre=new int[fila][columna];
        iniciaMatrizint(limitemin, limitemax);
    }

    public void iniciaMatrizint(int lmin, int lmax) //Se inicia la matriz.
    {
        for(int i=0; i<fila;i++)
        {
            for(int j=0; j<columna;j++)
            {
                arre[i][j]=(int)Math.floor(Math.random()*(lmax-lmin))+lmin;
            }
        }
    }

    public void imprimeMatrizint()  //Se imprime la matriz en consola.
    {
        System.out.print("\nMatriz de enteros\n");

        for(int i=0; i<fila;i++)
        {
            for(int j=0; j<columna;j++)
                {
                    System.out.print(arre[i][j]+"\t");
                }
            System.out.print("\n");
        }
    }

    public void imprimeMatrizintGrafica()  //Se imprime la matriz en modo grafico.
    {
        String arregloMatriz = "";

        for(int i=0; i<fila;i++)
        {
            for(int j=0; j<columna;j++)
                {
                    if (arre[i][j] < 10 && arre[i][j] > -10) arregloMatriz += String.format("%12d", arre[i][j]);
                    else if(arre[i][j] >99 && arre[i][j] < 1000 || arre[i][j] > -1000 && arre[i][j] < -99) arregloMatriz += String.format("%10d", arre[i][j]);
                    else arregloMatriz += String.format("%11d", arre[i][j]);
                }
            arregloMatriz += "\n" ;
        }

        JOptionPane.showMessageDialog(null, "Matriz de enteros" + "\n" + arregloMatriz);
    }
}

class Matrizfloat extends Matriz
{

    float arre[][];

    public Matrizfloat()
    {
        super();
    }

    public Matrizfloat(int fila, int columna, int lmin, int lmax) //Constructor de la matriz flotante.
    {
        super(fila, columna);
        arre=new float[fila][columna];
        iniciaMatrizfloat(lmin, lmax);
    }

    public void iniciaMatrizfloat(int lmin, int lmax) //Se inicia la matriz de flotantes.
    {
        for(int i=0; i<fila;i++)
        {
            for(int j=0; j<columna;j++)
            {
                arre[i][j]=(float)(Math.random()*(lmax-lmin))+lmin;
            }
        }
    }

    public void imprimeMatrizfloat()  //Se imprime en consola.
    {
        System.out.print("\nMatriz de flotantes\n");

        for(int i=0; i<fila;i++)
        {
            for(int j=0; j<columna;j++)
                {
                    System.out.print(arre[i][j]+" \t");
                }
            System.out.print("\n");
        }
    }

    public void imprimeMatrizfloatGrafica() //Se imprime en modo grafico.
    {
        String arregloMatriz = "";

        for(int i=0; i<fila;i++)
        {
            for(int j=0; j<columna;j++)
                {
                    if (arre[i][j] < 10 && arre[i][j] > -10) arregloMatriz += String.format("|%12f|", arre[i][j]);
                    else if(arre[i][j] >99 && arre[i][j] < 1000 || arre[i][j] > -1000 && arre[i][j] < -99) arregloMatriz += String.format("|%9f|", arre[i][j]);
                    else arregloMatriz += String.format("|%11f|", arre[i][j]);

                }
            arregloMatriz += "\n" ;
        }

        JOptionPane.showMessageDialog(null, "Matriz de flotantes" + "\n" + arregloMatriz);
    }
}
