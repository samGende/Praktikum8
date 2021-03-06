import java.util.ArrayList;

public class SimpleHT<K, V> {

    private ArrayList<ArrayList<Pair>> hashTable;
    private int size;
    private SimpleHashFunction<K> hashFunktion;

    public class Pair<K, V>{
        private K key;
        private V value;
        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    public SimpleHT(int size, SimpleHashFunction<K> hashFunktion){
        this.size = size;
        this.hashFunktion = hashFunktion;
        hashTable = new ArrayList<ArrayList<Pair>>(size);
        //hashtable mit leere arraylist initialzieren
        for( int i = 0; i < size; i++){
            hashTable.add(new ArrayList<Pair>());
        }
    }

    public SimpleHT(int size){
       this(size, new DefaultHash<K>());
    }




    public void insert(K key, V value){
        //key berechnen
        Integer keyIndex = addressOfList(key);
        Pair pair = new Pair(key, value);

        //pruffen ob es schon ein object ins hashtable gibt
        if(hashTable.get(keyIndex).size() > 0){
            //objecte mit gleiche key raus nehmen
            hashTable.get(keyIndex).removeIf(p -> p.getKey().equals(key));
        }
        // object zum table addieren
        hashTable.get(keyIndex).add(pair);
    }

    public V get(K key){
        //in die richtige liste key finden
        for(Pair pair: hashTable.get(addressOfList(key))){
            if(pair.getKey().equals(key)){
                return (V) pair.getValue();
            }
        }
        return null;
    }

    public boolean remove(K key){
        // in die richtige liste key finden
        for(Pair pair: hashTable.get(addressOfList(key))){
            if(pair.getKey().equals(key)){
                return hashTable.get(addressOfList(key)).remove(pair);
            }
        }
        return false;
    }

    private int addressOfList(K key){
        return Math.floorMod(hashFunktion.getHash(key), size);

    }
}
