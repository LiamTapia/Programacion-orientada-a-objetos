import java.io.*;
import javax.swing.*;

public class Alumnosb {

    public static void main(String[] args) {

       new NewAlumno("","","",1,""); //Se inicializa a vacios.

       int i=0,promedioPo,promedioGrupo=0,contador=0;
       int total= Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de alumnos que vas a dar de alta al sistema "));

	Alumno al[]= new Alumno[total]; //arreglo del tipo Alumno simple. Se usa para capturar los datos del Alumno.

		for(i=0;i<total;i++){ //Ciclo para capturar la cantidad de Alumnos a darl de alta en una captura.
             al[i] = new Alumno(); //Se crean los arreglos de alumnos necesarios en cada ciclo.
             al[i].nombre = JOptionPane.showInputDialog("Nombre del Alumno nuevo : " + (i +1)); //Uso de JOptionPane para hacer un cuadro de texto.
             promedioPo= Integer.parseInt(JOptionPane.showInputDialog("promedioPoo del Alumno nuevo : " + (i +1)));
			 al[i].promedioPoo=promedioPo;
             al[i].direccion = JOptionPane.showInputDialog("Direccion del Alumno nuevo: " + (i +1));
             al[i].sexo = JOptionPane.showInputDialog("Sexo del Alumno nuevo: " + (i +1));
			 al[i].telefono = JOptionPane.showInputDialog("Telefono del Alumno nuevo: " + (i +1));
		}

		for(i=0;i<total;i++){  //Ciclo for para la impresión de los estudiantes.
			   JOptionPane.showMessageDialog(null, "Informacion del estudiante No.-"+(i+1)+"\n"+
                                        "Nombre: "+al[i].nombre+"\n"+"Sexo: "+al[i].sexo+"\n"+"Direccion: "+al[i].direccion
                                            +"\n"+"Promedio: "+al[i].promedioPoo+"\n"+"Telefono: "+al[i].telefono);//Se utiliza showMessageDialog para solo mostrar el texto capturado.
                promedioGrupo+=al[i].promedioPoo; //Se suman todos los promedios para obtener el grupal.
                contador=contador+1;
		}
		JOptionPane.showMessageDialog(null, "Promedio del grupo: " + promedioGrupo/contador); //Se imprime en un recuadro a parte el promedio grupal.
    }
}

//Clase Alumno normal, solo con atributos
class Alumno {
 String nombre, telefono, direccion, sexo;
 int promedioPoo;
}
