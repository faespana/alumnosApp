package alumnoapp;

import alumnoapp.entities.Alumno;
import alumnoapp.services.AlumnoService;

public class AlumnoAPP {

    public static void main(String[] args) {
        AlumnoService as = new AlumnoService();
        //Alumno alm1 = as.crearAlumno();
        //System.out.println(alm1);
        
        as.agregarNuevoAlumno();
        as.mostrarAlumnos();
        as.notaFinal();
        
    }
    
}
