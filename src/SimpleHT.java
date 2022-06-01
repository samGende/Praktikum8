import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SimpleHT {

    private ArrayList<ArrayList<Pair>> hashTable;
    private int size;

    public class Pair{
        private Integer key;
        private Integer value;
        public Pair(Integer key, Integer value){
            this.key = key;
            this.value = value;
        }

        public Integer getKey(){
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public SimpleHT(int size){
        this.size = size;
        hashTable = new ArrayList<ArrayList<Pair>>(size);
        for( int i = 0; i < size; i++){
            hashTable.add(new ArrayList<Pair>());
        }
    }


    public void insert(Integer key, Integer value){
        //key berechnen
        Integer keyIndex = Math.floorMod(key,size);
        Pair pair = new Pair(key, value);

        //pruffen ob es schon ein object ins hashtable gibt
        if(hashTable.get(keyIndex).size() > 0){
            hashTable.get(keyIndex).removeIf(p -> p.getKey().equals(key));
        }
        // object zum table addieren
        hashTable.get(keyIndex).add(pair);
    }

    public Integer get(Integer key){
        for(Pair pair: hashTable.get(Math.floorMod(key, size))){
            if(pair.getKey().equals(key)){
                return pair.getValue();
            }
        }
        return null;
    }

    public boolean remove(Integer key){
        for(Pair pair: hashTable.get(Math.floorMod(key, size))){
            if(pair.getKey().equals(key)){
                return hashTable.get(Math.floorMod(key, size)).remove(pair);
            }
        }
        return false;
    }
}
