import org.ficheros.Ficheros;
import org.ficheros.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Andrés", 10));
        personas.add(new Persona("Carlos", 5));
        personas.add(new Persona("Amanda", 7));
        Ficheros nuevo = new Ficheros();
        System.out.println("Con ObjectInputStrem , ObjectOutputStream ");
       nuevo.guardarObjetosPersona(personas, "resources/personaObjetos.dat");
        List<Persona> personasLeidas;
        personasLeidas = nuevo.leerObjetosPersona("resources/personaObjetos.dat");
        for (Persona person: personasLeidas){
            System.out.println(person);
        }
        System.out.println("Con DataInputStrem , DataOutputStream ");
        nuevo.guardarPersonas(personas,"resources/pokemons.dat" );
        List<Persona> personasLeidas2;
        personasLeidas2=nuevo.leerpersona("resources/pokemons.dat");
        for (Persona person: personasLeidas2){
            System.out.println(person);
        }

    }
}
