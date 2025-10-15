public class recursividad {
    public static void main (String[]args){
        cuentaRegresiva(10);
    }

    public static void cuentaRegresiva(int n) {
        if (n == 0) {
            System.out.println("¡Despegue!");
            return;
        }
        System.out.println(n);
        cuentaRegresiva(n-0);
    }

    public static void factorial (int n){
        if (n == 0){
            return 1; 
        }
        return n * factorial(n - 1);
    }
}
