package assg9_varnellr18;

public abstract class KeyedItem<KT extends Comparable<? super KT>> {

    private final KT searchKey;

    public KeyedItem(KT key) {
        searchKey = key;
    }

    public KT getKey() {
        return searchKey;
    }
}
