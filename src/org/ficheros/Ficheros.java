package org.ficheros;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {

    public List<Persona> leerObjetosPersona(String fichero) throws RuntimeException {
        ArrayList<Persona> ejemplo = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            try {
                while (true) {
                    ejemplo.add((Persona) ois.readObject());
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error de clase no encontrada" + e.getMessage());
        }
        return ejemplo;
    }

    public void guardarObjetosPersona(List<Persona> personas, String fichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            for (Persona person : personas) {
                oos.writeObject(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Persona> leerpersona(String fichero) {
        ArrayList<Persona> personas = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
               while (true){
                   String nombre= dis.readUTF();
                   int edad=dis.readInt();
                   personas.add(new Persona(nombre,edad));
               }
        } catch (EOFException e) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }

    public void guardarPersonas(List<Persona>personas, String fichero){
        try(DataOutputStream dos= new DataOutputStream(new FileOutputStream(fichero))){
            for (Persona person:personas) {
                dos.writeUTF(person.getNombre());
                dos.writeInt(person.getEdad());
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
