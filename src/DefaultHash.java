public class DefaultHash<K> implements SimpleHashFunction<K>{

    @Override
    public int getHash(K key) {
        return key.hashCode();
    }
}
