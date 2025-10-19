/**
 * Clase: Operation (Operación)
 * -------------------------------
 * Representa una acción que se guardará en la "pila de deshacer".
 * 
 * Por ejemplo:
 * - Si agregas un libro, aquí se guarda cómo eliminarlo si deshaces.
 * - Si prestas un libro, se guarda cómo devolverlo.
 *
 * Campos:
 *  - type: qué tipo de operación fue.
 *  - a, b, c: datos necesarios para poder revertirla después.
 *
 * En resumen:
 * - Sirve para recordar lo último que se hizo y poder revertirlo.
 */

 public class Operation {
    private OperationType tipo;
    private String datoA, datoB, datoC; // carga genérica (A,B,C)

    public Operation(OperationType t, String a, String b, String c) {
        this.tipo = t;
        this.datoA = a;
        this.datoB = b;
        this.datoC = c;
    }

    public OperationType getType() {
        return tipo;
    }

    public String getA() {
        return datoA;
    }

    public String getB() {
        return datoB;
    }

    public String getC() {
        return datoC;
    }
}
