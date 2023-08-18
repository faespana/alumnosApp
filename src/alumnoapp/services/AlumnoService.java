package alumnoapp.services;

import alumnoapp.entities.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

public class AlumnoService {

    private Scanner leer;
    private ArrayList<Alumno> alumnos;

    public AlumnoService() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.alumnos = new ArrayList();
    }

    public Alumno crearAlumno() {

        Alumno alm = new Alumno();

        System.out.println("Ingrese el nombre del alumno");
        alm.setNombre(leer.next());

        System.out.println("");

        alm.setNotas(cargarNotas());

        return alm;
    }

    public ArrayList<Double> cargarNotas() {
        ArrayList<Double> notas = new ArrayList();
        System.out.println("Ingrese la cantidad de calificaciones que desea ingresar: ");
        int cant = leer.nextInt();
        System.out.println("");

        for (int i = 0; i < cant; i++) {
            System.out.println("Ingrese la calificacion numero " + (i + 1) + ": ");
            notas.add(leer.nextDouble());
        }
        return notas;
    }

    public void agregarAlumno(Alumno alm) {
        alumnos.add(alm);
    }

    public void agregarNuevoAlumno() {
        boolean bandera = true;
        int aux;
        Alumno alumnoCreado = crearAlumno();
        agregarAlumno(alumnoCreado);
        while (bandera) {
            System.out.println("");
            System.out.println("Desea agregar un nuevo alumno: \n1. Si \n2. No");
            aux = leer.nextInt();
            if (aux == 1) {
                alumnoCreado = crearAlumno();
                agregarAlumno(alumnoCreado);
            } else {
                System.out.println(alumnoCreado.toString());
                bandera = false;
            }
        }
    }

    public void mostrarAlumnos() {
        System.out.println("");
        System.out.println("Los alumnos actuales son: ");
        System.out.println("");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
        System.out.println("Cantidad =  " + alumnos.size());
    }
    
    public double calcularPromedio(ArrayList<Double> notas){
        double promedio = 0;
        for (int i = 0; i < notas.size(); i++) {
            promedio = promedio + notas.get(i);
        }
        return promedio/notas.size();
    }
    
    public void notaFinal() {
        String nombre;
        int cont = 0;
        System.out.println("");
        System.out.println("Ingrese el nombre del alumno que desea buscar: ");
        nombre = leer.next();
        for (Alumno alumno : alumnos) {
            if(nombre.equalsIgnoreCase(alumno.getNombre())) {
                cont = cont + 1;
                System.out.println("El promedio final del estudiante es: " + calcularPromedio(alumno.getNotas())); 
            }
        }
        if(cont == 0){
            System.out.println("");
            System.out.println("El alumno que busca, no se ha encontrado en el listado"); 
        }
        
        
    }
}
