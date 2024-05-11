import java.util.Objects;
import java.util.Random;
/**
 * A testing class representing objects to be used as keys in the hash table
 */

public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }


    @Override
    public int hashCode() {

        int hash = 7;
        hash = 31 * hash + id;
        return hash;
    }


}