package CLASE2;

public class Biblioteca{
    public static void main (String[]args){
        String libros[] = new String[10];
        libros[0]= "El principito";
        libros[1]= "El señor de lo anillos";
        libros[2]= "La biblia";
        libros[3]= "Harry potter";
        libros[4]= "El quijote de la mancha";
        libros[5]= "La divina comedia";
        libros[6]= "100 años de soledad";
        libros[7]= "Cronica de una muerte anunciada";
        libros[8]= "Mortem";
        libros[9]= "Las 48 leyes del poder";


        for (int i = 0; i < libros.length; i++){
            System.out.println(libros[i]);
        }
    }
}