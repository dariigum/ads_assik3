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

    public MyHashTable(){}

    public MyHashTable(int M){}

    public void put(K key, V value){}

    public V get(K key){}

    public int hash(K key ){}

    public V remove(K key){}

    public boolean contains(K key){}

    public K getKey(V value){}
}
