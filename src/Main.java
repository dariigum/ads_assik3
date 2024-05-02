import java.util.Random;

public class Main {
    public static void main(String[] args) {

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





