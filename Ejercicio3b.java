import java.io.*;
import javax.swing.*;

public class Ejercicio3b {

    public static void main(String[] args) { //main que inicializa el programa.

        Metodos m = new Metodos();
        m.Menu();  //Se llama al metodo que crea el menu

    }
}

class Persona{ //Clase padre Persona.

    private String nombre; //Declaracion de las variables compartidas.
    private String correo;

    public Persona(){}

    public Persona(String nombre, String correo){  //Constructor de Persona.
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre(){//Uso de metodos get y set para los valores de Persona.
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
}

class Estudiante extends Persona{ //Clase Estudiante que hereda atricutos de Persona.
    String matricula;
    float promedio;

    public Estudiante(){super();}

    public Estudiante(String nombre, String correo, String matricula, float promedio){ //Constructor de Estudiante que recibe valores de Persona.
        super(nombre, correo);
        this.matricula = matricula;
        this.promedio = promedio;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public float getPromedio(){
        return promedio;
    }

    public void setPromedio(float promedio){
        this.promedio = promedio;
    }
}

class Profesor extends Persona{//Clase Profesor, hijo de Persona.
    int num_emp;
    String grado;

    public Profesor(){super();}

    public Profesor(String nombre, String correo, int num_emp, String grado){ //Constructor de Profesor.
        super(nombre, correo);
        this.num_emp = num_emp;
        this.grado = grado;
    }

    public int getNum_emp(){
        return num_emp;
    }

    public void setNum_emp(int num_emp){
        this.num_emp =  num_emp;
    }

    public String getGrado(){
        return grado;
    }

    public void setGrado(String grado){
        this.grado = grado;
    }
}

class Metodos{

    public Metodos(){super();}

    public void Menu()
    {
        int bandera=1;

        do{ //do while para hacer un ciclo en el menu.
        Object[] opciones = {"Alumno",
                    "Profesor","Cancelar"};

        int choice = JOptionPane.showOptionDialog(null, "Quieres rellenar informacion de un estudiante o profesor?", "Elige una opcion",
                                   JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null); //Impresion del menu.

        if(choice == 0 )//if que entra a la captura de datos de alumno.
            {
               float promedioaux, promedioGrupal=0;//Declaracion de variables usadas por alumno.
               int i;
               int total= Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de alumnos que vas a dar de alta al sistema "));

                Estudiante est[] = new Estudiante[total]; //Se crea el arreglo de estudiantes.

                for(i=0;i<total;i++){ //for que rellena los datos del alumno.
                     est[i] = new Estudiante();
                     est[i].setNombre(JOptionPane.showInputDialog("Nombre del Alumno nuevo : "+ (i +1))) ; //Uso de JOptionPane para hacer un cuadro de texto.
                     est[i].setCorreo(JOptionPane.showInputDialog("Correo del Alumno: "+ (i +1)));
                     est[i].setMatricula(JOptionPane.showInputDialog("Matricula del Alumno nuevo: "+ (i +1)));
                     promedioaux = Float.parseFloat(JOptionPane.showInputDialog("Promedio del Alumno nuevo : "+ (i +1)));
                     est[i].setPromedio(promedioaux);
                }

                for(i=0;i<total;i++){ //for que imprime los datos del alumno.
                       JOptionPane.showMessageDialog(null, "Informacion del estudiante: "+ (i +1)+"\n"+
                                                "Nombre: "+est[i].getNombre()+"\n"+"Correo: "+est[i].getCorreo()+"\n"+"Matricula: "+est[i].getMatricula()
                                                    +"\n"+"Promedio: "+est[i].getPromedio()+"\n");//Se utiliza showMessageDialog para solo mostrar el texto capturado.
                       promedioGrupal+=est[i].getPromedio();
                }
                JOptionPane.showMessageDialog(null, "Promedio del grupo: " + promedioGrupal/i); //Impresion del promedio grupal.

                bandera = Reinicio(bandera); //Se llama al metodo de Reinicio para saber si acaba el programa.

                }

        else if(choice == 1) //if que entra al rellenado de datos de profesor.
            {
               int num_empaux,i; //Declaracion de variables de profesor.
                    int total= Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de profesores que vas a dar de alta al sistema "));

                    Profesor prof[] = new Profesor[total]; //Creacion del arreglo de profesores.

                    for(i=0;i<total;i++){ //for de captura de datos para profesores.
                         prof[i] = new Profesor();
                         prof[i].setNombre(JOptionPane.showInputDialog("Nombre del profesor nuevo : "+ (i +1))) ; //Uso de JOptionPane para hacer un cuadro de texto.
                         prof[i].setCorreo(JOptionPane.showInputDialog("Correo del profesor: "+ (i +1)));
                         num_empaux = Integer.parseInt(JOptionPane.showInputDialog("Numero de empleado del profesor nuevo : "+ (i +1)));
                         prof[i].setNum_emp(num_empaux);
                         prof[i].setGrado(JOptionPane.showInputDialog("Grado del profesor nuevo: "+ (i +1)));
                    }

                    for(i=0;i<total;i++){ //for para impresion de datos de profesores.
                           JOptionPane.showMessageDialog(null, "Informacion del profesor: "+ (i +1)+"\n"+
                                                    "Nombre: "+prof[i].getNombre()+"\n"+"Correo: "+prof[i].getCorreo()+"\n"+"Numero de empleado: "+
                                                    prof[i].getNum_emp()+"\n"+"Grado: "+prof[i].getGrado()+"\n");//Se utiliza showMessageDialog para solo mostrar el texto capturado.
                    }

                    bandera = Reinicio(bandera); //Se llama al metodo Reinicio para saber si acaba el programa.
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
