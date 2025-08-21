public class MyArrayList <T>{

    private T[] myArray;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList(){
        myArray = (T[]) new Object [ DEFAULT_SIZE];
        size = 0;
    }

    public void add (T Object){
        if (size == myArray.length) {
            increaseSize();
        }
        myArray[size] = Object;
        size++;
    }

    

    public void delete (int index){
       for (int i = index; i < myArray.length; i++){
            if (i + 1 != size)
                myArray[i] = myArray[i + 1];
            else
                myArray[i] = null;
        }
        size--;
    }

    public T get(int index){

        return myArray[index];
    }

    public String toString(){
        String returnString = "";
        for (int i=0; i<myArray.length; i++){
            returnString += myArray[i] + " , ";
        }
        return returnString;
    }

    private void increaseSize(){
        T[] newArray = (T[])new Object [myArray.length * 2];
        for (int i = 0; i < myArray.length; i++){
            newArray[i] = myArray[i];
        }
        myArray=newArray;
    }
}