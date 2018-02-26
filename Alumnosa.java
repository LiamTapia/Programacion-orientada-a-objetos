import java.io.*;
import javax.swing.*;


public class Alumnosa {

    public static void main(String[] args) {

       new NewAlumno("","","",1,""); //Se inicializa a vacios

       int i=0,promedioPo;

	Alumno al[]= new Alumno[1]; //arreglo del tipo Alumno simple. Se usa para capturar los datos del Alumno.

             al[i] = new Alumno();
             al[i].nombre = JOptionPane.showInputDialog("Nombre del Alumno nuevo : ");  //Uso de JOptionPane para capturar los datos.
             promedioPo= Integer.parseInt(JOptionPane.showInputDialog("promedioPoo del Alumno nuevo : "));
			 al[i].promedioPoo=promedioPo;
             al[i].direccion = JOptionPane.showInputDialog("Direccion del Alumno nuevo: ");
             al[i].sexo = JOptionPane.showInputDialog("Sexo del Alumno nuevo: ");
			 al[i].telefono = JOptionPane.showInputDialog("Telefono del Alumno nuevo: ");

			   JOptionPane.showMessageDialog(null, "Nombre: "+al[i].nombre+"\n"+"Sexo: "+al[i].sexo+"\n"+"Direccion: "+al[i].direccion
                                            +"\n"+"Promedio: "+al[i].promedioPoo+"\n"+"Telefono: "+al[i].telefono); //Uso de showMessageGialog para imprimir los datos del alumno.
    }
}

//Clase Alumno normal, solo con atributos
class Alumno {
 String nombre, telefono, direccion, sexo;
 int promedioPoo;
}
