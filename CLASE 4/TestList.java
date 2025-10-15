public class TestList {

    public static void main(String[] args) {
        LinkedList mylist = new LinkedList();
        mylist.add("Obcjeto 1");
        mylist.add("Obcjeto 2");
        mylist.add("Obcjeto 3");
        mylist.add("Obcjeto 4");
        mylist.add("Obcjeto 5");
        mylist.add("Obcjeto 6");
        mylist.add("Obcjeto 7");
        mylist.add("Obcjeto 8");
        mylist.add("Obcjeto 9");
        mylist.add("Obcjeto 10");
    
            //print list

        System.out.println(mylist);
        System.out.println(mylist.size());
        mylist.delete(4);
        System.out.println(mylist);
    } 
}