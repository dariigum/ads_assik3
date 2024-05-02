import java.util.Random;
import MyTestingClass;

public class MyHashTable <K, V>{

    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return key + ": " + value;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int size;
    private int M=11;

    public MyHashTable(){
        this.chainArray =(HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(int M){
        this.chainArray =(HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
        this.M = M;
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        node = new HashNode<>(key, value);
        node.next = chainArray[index];
        chainArray[index] = node;
        size++;
    }

    public V get(K key){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null){
            if (node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public int hash(K key ){
        int hash = key.hashCode();
        return Math.abs(hash % M);
    }

    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> last = null;
        while (node != null){
            if (node.key.equals(key)){
                if (last == null){
                    chainArray[index] = node.next;
                }
                else {
                    last.next = node.next;
                }
                size--;
                return node.value;
            }
            last = node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(V value){
        for(int i=0; i<M; i++){
            HashNode<K, V> node = chainArray[i];
            while (node != null){
                if (node.value == value){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for(int i=0; i<M; i++){
            HashNode<K, V> node = chainArray[i];
            while (node != null){
                if (node.value == value){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void printBucketSize(){
        for(int i=0; i<M; i++){
            int count=0;
            HashNode<K, V> node = chainArray[i];
            while (node != null){
                count++;
                node = node.next;
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>();
        Random random = new Random();
        for(int i=0; i<10; i++){
            int id = random.nextInt(1000);
            MyTestingClass object=new MyTestingClass(id);
            hashTable.put(object, "Value "+i);
        }
        hashTable.printBucketSize();
    }
}
