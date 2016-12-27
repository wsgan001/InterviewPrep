package org.practice.javaFundas.miscellaneous;

//Implement your own hashmap
public class MyHashMap {
    private static final int SIZE = 16;
    private Entry[] table = new Entry[SIZE];

    public static class Entry {
        private final String key;
        private String value;
        private Entry next;

        public Entry(String k, String v) {
            key = k;
            value =v;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public int hashcode(String key) {
        return Math.abs(key.hashCode()) % SIZE;

    }

    public String get(String key) {
        int hash = hashcode(key);
        Entry e = table[hash];
        while(e != null) {
            if(e.key.equals(key)) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    public void put(String key, String value) {
        int hash = hashcode(key);
        Entry e = table[hash];
        if(e != null) {
            if(e.getKey().equals(key)) {
                e.value = value;
            } else {
                while(e.next != null) {
                    e = e.next;
                }
                Entry oldEntry = new Entry(key, value);
                e.next = oldEntry;
            }

        } else {
            Entry newEntry = new Entry(key, value);
            table[hash] = newEntry;
        }
    }

    public static void main(String args[]) {
        MyHashMap map = new MyHashMap();
        map.put("Priyanka", "Singh");
        map.put("Vikas", "Kumar");
        System.out.println(map.get("Priyanka"));
        map.put("Vikas", "Singh");
        System.out.println(map.get("Vikas"));
    }
}
