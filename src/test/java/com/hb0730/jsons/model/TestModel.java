package com.hb0730.jsons.model;

/**
 * @author <a href="mailto:huangbing0730@gmail">hb0730</a>
 * @date 2022/6/19
 * @since 1.0.0
 */
public class TestModel {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestModel{" +
            "name='" + name + '\'' +
            ", value='" + value + '\'' +
            '}';
    }

    public static class TestModel2<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
