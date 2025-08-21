public class TestMyArray{

    public static void main(String[]args){
        MyArrayList myArray = new MyArrayList();
        myArray.add("objeto 1");
        myArray.add("objeto 2");
        myArray.add("objeto 3");
        myArray.add("objeto 4");
        myArray.add("objeto 5");
        myArray.add("objeto 6");
        myArray.add("objeto 7");
        myArray.add("objeto 8");
        myArray.add("objeto 9");
        myArray.add("objeto 10");

        myArray.delete(4);
        System.out.println(myArray);

        System.out.println(myArray.get(6));
    }
}