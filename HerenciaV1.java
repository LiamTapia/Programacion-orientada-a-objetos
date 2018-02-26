import java.io.*;
import javax.swing.*;

public class HerenciaV1 {

    public static void main(String[] args) { //main que inicializa el programa.

        Metodos m = new Metodos();
        m.Menu();  //Se llama al metodo que crea el menu

    }
}

class GeneralWeapon //Clase padre de armas.
{
    public String nombre; //Declaracion de las variables compartidas.
    public int nivel;

    public GeneralWeapon(String nombre, int nivel)//Constructor de generalWeapon.
    {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}

class ArmaPrincipal extends GeneralWeapon  //Clase armaPrincipal que hereda atricutos de generalWeapon.
{
    public int fuerza;
    public int precio;
    public int alcance;
    public int tinta;

    public ArmaPrincipal(String nombre, int nivel, int precio, int alcance, int tinta) //Constructor de armaPrincipal.
    {
        super(nombre, nivel);
        this.fuerza = fuerza;
        this.precio = precio;
        this.alcance = alcance;
        this.tinta = tinta;
    }
}

class Shooter extends ArmaPrincipal
{
    public int velocidadFuego;

    public Shooter (String nombre, int nivel, int precio, int alcance, int tinta, int velocidadFuego) //Constructor de shooter.
    {
        super(nombre, nivel, fuerza, precio, alcance, tinta);
        this.velocidadFuego = velocidadFuego;
    }
}

class Roller extends ArmaPrincipal
{
    public int velocidad;
    public int manejo;

    public Roller(String nombre, int nivel, int precio, int alcance, int tinta, int velocidad, int manejo) //Constructor de roller.
    {
        super(nombre, nivel, fuerza, precio, alcance, tinta);
        this.velocidad = velocidad;
        this.manejo = manejo;
    }
}

class Charger extends ArmaPrincipal
{
    public int velocidadCarga;
    public int movilidad;

    public Charger(String nombre, int nivel, int precio, int alcance, int tinta, int velocidadCarga, int movilidad) //Constructor de Charger.
    {
        super(nombre, nivel, fuerza, precio, alcance, tinta);
        this.velocidadCarga = velocidadCarga;
        this.movilidad = movilidad;
    }
}

class SubArma extends GeneralWeapon  //Clase subarma que hereda atricutos de generalWeapon.
{
    public int porcentajeUso;

    public SubArma(String nombre, int nivel, int porcentajeUso) //Constructor de subarma.
    {
        super(nombre, nivel);
        this.porcentajeUso = porcentajeUso;
    }
}

class Bomba extends SubArma
{
    public int distancia;

    public Bomba(String nombre, int nivel, int porcentajeUso, int distancia) //Constructor de bomba.
    {
        super(nombre, nivel, porcentajeUso);
        this.distancia = distancia;
    }
}

class BombaDano extends Bomba
{
    public int fuerza;

    public BombaDano(String nombre, int nivel, int porcentajeUso, int distancia, int fuerza) //Constructor de bomba daño.
    {
        super(nombre, nivel, porcentajeUso, distancia);
        this.fuerza = fuerza;
    }
}

class BombaEfecto extends Bomba
{
    public int duracion;

    public BombaEfecto(String nombre, int nivel, int porcentajeUso, int distancia, int duracion) //Constructor de bomba efecto.
    {
        super(nombre, nivel, porcentajeUso, distancia);
        this.duracion = duracion;
    }
}

class Barrera extends SubArma
{
    public int duracion;
    public int danoSegundo;

    public BombaDano(String nombre, int nivel, int porcentajeUso, int duracion, int danoSegundo) //Constructor de bomba daño.
    {
        super(nombre, nivel, porcentajeUso);
        this.duracion = duracion;
        this.danoSegundo = danoSegundo;
    }
}

class ArmaEspecial extends GeneralWeapon  //Clase subarma que hereda atricutos de Arma Especial.
{
    public float duracion;
    boolean instaKill;
    boolean invinsibilidad;
    boolean sensor;
    boolean efecto;

    public ArmaEspecial(String nombre, int nivel, float duracion, boolean instaKill, boolean invinsibilidad, boolean sensor, boolean efecto) //Constructor del especial.
    {
        super(nombre, nivel);
        this.duracion = duracion;
        this.instaKill = instaKill;
        this.invinsibilidad = invinsibilidad;
        this.sensor = sensor;
        this.efecto = efecto;
    }
}

class Metodos{

    public Metodos(){super();}

    public void Menu()
    {
        int bandera=1;

        do{ //do while para hacer un ciclo en el menu.
        Object[] opciones = {"Arma Principal","Sub Arma","Arma Especial", "Cancelar"};

        int choice = JOptionPane.showOptionDialog(null, "Que clase de arma quieres registrar?", "Elige una opcion",
                                   JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opciones, null); //Impresion del menu.

        if(choice == 0 )//if que entra a la captura de datos de un arma.
            {
               Object[] opcionesArma = {"Shooter","Roller","Charger","Cancelar"};

                int choiceArma = JOptionPane.showOptionDialog(null, "Que clase de arma principal quieres registrar?", "Elige una opcion",
                                   JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, opcionesArma, null);

                    if(choiceArma == 0)
                        {
                            int aux;
                            Shooter shoo = new Shooter();

                            shoo.nombre = JOptionPane.showInputDialog("Nombre del Arma: "); //Uso de JOptionPane para hacer un cuadro de texto.
                            aux = Integer.parseInt(JOptionPane.showInputDialog("Nivel necesario"));
                            shoo.nivel = aux;
                            aux = Integer.parseInt(JOptionPane.showInputDialog("Fuerza que tiene"));
                            shoo.fuerza = aux;
                            aux = Integer.parseInt(JOptionPane.showInputDialog("Precio del arma"));
                            shoo.precio = aux;
                            aux = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de tinta que gasta"));
                            shoo.tinta = aux;
                            aux = Integer.parseInt(JOptionPane.showInputDialog("Velocidad de fuego"));
                            shoo.velocidadFuego = aux;

                            JOptionPane.showMessageDialog(null, "Informacion del estudiante: "+ (i +1)+"\n"+
                                                "Nombre: "+shoo.nombre+"\n"+"Nivel en el que se obtiene: "+shoo.nivel+"\n"+"Fuerza: "+
                                                          shoo.fuerza+"\n"+"Precio: "+shoo.precio+"\n"+"Gasto de tinta: "+shoo.tinta+"\n"
                                                          +"Velocidad de disparo: "+shoo.velocidadFuego+"\n");
                        }


                }



         else bandera = 0; //Si se elige cancel se acaba el ciclo.

        }while(bandera==1); //Si bandera cambia de valor acaba el do while.

    }

    public int Reinicio(int band){ //Metodo reinicio para acabar el programa.

        Object[] respuesta = {"Si", "No"};

                    int respfinal = JOptionPane.showOptionDialog(null,
                                       "Quieres rellenar mas informacion de un estudiante o profesor?", "Elige una opcion", JOptionPane.YES_NO_OPTION,
                                       JOptionPane.INFORMATION_MESSAGE, null, respuesta, null); //Menu para saber si ya no se quieren rellenar datos.

                    if(respfinal == 1 ) band=0;
            return band; //Se regresa bandera original o alterada.
    }
}
