import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyBST<Integer, String> bst = new MyBST<>();


        bst.put(10, "Value 10");
        bst.put(5, "Value 5");
        bst.put(15, "Value 15");
        bst.put(3, "Value 3");
        bst.put(7, "Value 7");


        System.out.println("Value associated with key 5: " + bst.get(3));


        bst.delete(3);


        System.out.println("Value associated with key 5 after deletion: " + bst.get(3));


        System.out.println("Keys in asc:");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }

        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();


        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(1000);
            MyTestingClass object = new MyTestingClass(id);
            table.put(object, "Value " + i);
        }


        table.printBucketSize();
    }
}





