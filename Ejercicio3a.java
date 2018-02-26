import java.io.*;
import javax.swing.*;

public class Ejercicio3a {

    public static void main(String[] args) {

       float promedioaux, promedioGrupal=0; //Declaracion de variables usadas por alumno.
       int i;
       int total= Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de alumnos que vas a dar de alta al sistema ")); //Obtencion del numero de alumnos

        Estudiante est[] = new Estudiante[total];

        for(i=0;i<total;i++){  //for que pide y rellena los datos dfel alumno.
             est[i] = new Estudiante();
             est[i].setNombre(JOptionPane.showInputDialog("Nombre del Alumno nuevo : "+ (i +1))) ; //Uso de JOptionPane para hacer un cuadro de texto.
             est[i].setCorreo(JOptionPane.showInputDialog("Correo del Alumno: "+ (i +1)));
             est[i].setMatricula(JOptionPane.showInputDialog("Matricula del Alumno nuevo: "+ (i +1)));
             promedioaux = Float.parseFloat(JOptionPane.showInputDialog("Promedio del Alumno nuevo : "+ (i +1)));
			 est[i].setPromedio(promedioaux);
        }

        for(i=0;i<total;i++){ //for que imprime a todos los alumnos y consigue el promedio general.
			   JOptionPane.showMessageDialog(null, "Informacion del estudiante: "+ (i +1)+"\n"+
                                        "Nombre: "+est[i].getNombre()+"\n"+"Correo: "+est[i].getCorreo()+"\n"+"Matricula: "+est[i].getMatricula()
                                            +"\n"+"Promedio: "+est[i].getPromedio()+"\n");//Se utiliza showMessageDialog para solo mostrar el texto capturado.
               promedioGrupal+=est[i].getPromedio();
        }
        JOptionPane.showMessageDialog(null, "Promedio del grupo: " + promedioGrupal/i); //Se imprime el promedio grupal.

        int num_empaux; //Declaracion de variables para el profesor.
        total= Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de profesores que vas a dar de alta al sistema ")); //Se obtiene el numero de profesores.

        Profesor prof[] = new Profesor[total];

        for(i=0;i<total;i++){ //for que consigue los valores de un profesor.
             prof[i] = new Profesor();
             prof[i].setNombre(JOptionPane.showInputDialog("Nombre del profesor nuevo : "+ (i +1))) ; //Uso de JOptionPane para hacer un cuadro de texto.
             prof[i].setCorreo(JOptionPane.showInputDialog("Correo del profesor: "+ (i +1)));
             num_empaux = Integer.parseInt(JOptionPane.showInputDialog("Numero de empleado del profesor nuevo : "+ (i +1)));
			 prof[i].setNum_emp(num_empaux);
			 prof[i].setGrado(JOptionPane.showInputDialog("Grado del profesor nuevo: "+ (i +1)));
        }

        for(i=0;i<total;i++){ //for para la impresion de los datos del profesor.
			   JOptionPane.showMessageDialog(null, "Informacion del profesor: "+ (i +1)+"\n"+
                                        "Nombre: "+prof[i].getNombre()+"\n"+"Correo: "+prof[i].getCorreo()+"\n"+"Numero de empleado: "+
                                        prof[i].getNum_emp()+"\n"+"Grado: "+prof[i].getGrado()+"\n");//Se utiliza showMessageDialog para solo mostrar el texto capturado.
        }
    }
}

class Persona{  //Clase padre: Persona.
    private String nombre;
    private String correo;

    public Persona(){}

    public Persona(String nombre, String correo){ //Constructor de Persona.
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre(){ //Uso de metodos get y set para los valores de Persona.
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

class Profesor extends Persona{ //Clase Profesor, hijo de Persona.
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
