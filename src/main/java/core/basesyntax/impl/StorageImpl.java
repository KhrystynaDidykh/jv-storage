package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_SIZE = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int size;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_SIZE];
        valueArray = (V[]) new Object[MAX_SIZE];
        //size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (size <= MAX_SIZE) {
            for (int i = 0; i < size; i++) {
                if (keyArray[i] == key
                        || keyArray[i] != null
                        && keyArray[i].equals(key)) {
                    valueArray[i] = value;
                    size--;
                }
            }
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i] == key
                    || keyArray[i] != null
                    && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
