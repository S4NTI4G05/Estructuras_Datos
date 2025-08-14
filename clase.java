public class clase {
    public static void main(String[] args) {
        double notas[][] = new double[3][4];

        //Estudiante 1
        notas[0][0] = 3.7;
        notas[0][1] = 4.2;
        notas[0][2] = 4.4;
        notas[0][3] = 5;

        //Estudiante 2
        notas[1][0] = 2.5;
        notas[1][1] = 3.0;
        notas[1][2] = 3.5;
        notas[1][3] = 4.0;

        //Estudiante 3
        notas[2][0] = 3.0;
        notas[2][1] = 3.5;
        notas[2][2] = 4.0;
        notas[2][3] = 4.5;

      for (int i = 0; i < notas.length; i++) {
            double suma = 0;
            for (int j = 0; j < notas[i].length; j++) {
                suma += notas[i][j];
            }
            double promedio = suma / notas[i].length;
            System.out.println("El promedio del estudiante " + (i + 1) + " es: " + promedio);
        } 
    }

    
}
