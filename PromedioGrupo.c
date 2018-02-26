#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define CLEAR() system("CLS")  //Definición de CLEAR usado para borrar la pantalla.

typedef struct promedios  //Declaración de la estructura donde se guardan los datos de los alumnos.
{
  char nombre[40];
  float matricula;
  int num_materia;
  char materias[10][15];
  float calificaciones[10];
  float promedioestudiante;
}prom;

void captura(prom * ); //Declaración de las funciones prototipo.
void guardar(prom);
void mostrar();

int main()
{
    prom estudiante;
    char opc;
    do   //do while para imprimir el menú.
    {   CLEAR();
        puts("1) Agregar estudiante.");
        puts("2) Ver promedio del grupo.");
        puts("0) Salir");
        printf("Eleccion : ");
        setbuf(stdin, 0);
        opc=getchar();

        switch(opc)    //Switch para la elección de la opción del menú.
        {
            case '1':   captura(&estudiante);
                        guardar(estudiante);
                        break;
            case '2':   mostrar();
                break;
        }
    }while (opc!=48);
    return 0;
}

void captura(prom *estudiante)   //Procedimiento para capturar los datos de un alumno.
{
    int i, total=0, band=1;
    float aux, promaux=0;
    CLEAR();

    setbuf(stdin,0);
    printf("Ingresa el nombre del estudiante = "); gets(estudiante->nombre); setbuf(stdin,0);
    printf("Ingresa la matricula = "); scanf("%f",&aux);
    estudiante->matricula = aux;

    do{    //do para validar la cantidad de materias que se pueden elegir.
            printf("\nIngresa la cantidad de materias = "); scanf("%d",&total); setbuf(stdin,0);
            if(total<10 && total>0) band = 0;
        }while(band==1);

    estudiante->num_materia=total;

	for(i=0;i<total;i++){    //for para capturar la cantidad de materias que se eligió.
        printf("\nIngresa el nombre de la materia %d = ", i+1); gets(estudiante->materias[i]); setbuf(stdin,0);
        printf("\nIngresa la calificacion de la materia %d = ", i+1); scanf("%f", &aux); setbuf(stdin,0);
        estudiante->calificaciones[i]=aux;
        promaux+=aux;

	}
	printf("\nPromedio del estudiante = %.2f", promaux/total);
	estudiante->promedioestudiante=(promaux/total); setbuf(stdin,0);
	getchar();

}

void guardar(prom estudiante)  //Procedimiento que guarda la estructura en un archivo.
{
    FILE * flujo;
    flujo= fopen("promediogrupo.dat","ab");
    if (flujo!=NULL)
    {
        fwrite(&estudiante,sizeof(prom),1,flujo);
        fclose(flujo);
    }
    else
        printf("No se pudo abrir el archivo.");
}

void mostrar() //Procedimiento que muestra todas las estructuras.
{
    FILE * flujo;
    prom estudiante;  float promedioGrupal=0, cont=0;
    int i;
    flujo= fopen("promediogrupo.dat","rb");
    if (flujo)
    {
        while( fread(&estudiante,sizeof(prom),1,flujo)>0)
        {
            printf("\n\n Nombre del alumno = %s", estudiante.nombre);
            printf("\n\n Matricula = %.0f", estudiante.matricula);
            for(i=0;i<estudiante.num_materia;i++){
                printf("\n Nombre de materia %d = %s",(i+1),estudiante.materias[i]);
                setbuf(stdin,0);
                printf("\n Calificacion materia %d = %.2f ",(i+1),estudiante.calificaciones[i]);
                setbuf(stdin,0);
            }
			printf("\n Promedio del estudiante = %.2f ", estudiante.promedioestudiante);
            setbuf(stdin,0);
            promedioGrupal+=estudiante.promedioestudiante;
            cont++;
        }
        printf("\n\n\nPromedio grupal = %.2f", promedioGrupal/cont);
    }
    else
        printf("No se pudo abrir el archivo."); getchar();
    fclose(flujo);
}
