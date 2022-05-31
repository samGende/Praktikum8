public class SimpleHT {

    private Pair[] hashTable;

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
        hashTable = new Pair[size];
    }


    public void insert(Integer key, Integer value){

    }

    public Integer get(Integer key){
        return 1;
    }

    public boolean remove(Integer key){
        return true;
    }
}
