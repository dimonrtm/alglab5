package com.company;

/**
 * Created by админъ on 16.10.2017.
 */
public class HashTable {
    private Node[] table = new Node[701];

    private int hashFunction1(int key) {
        return key % 701;
    }

    private int hashFunction2(int key) {
        return (1 + (key % 700));
    }

    private int fullHashFunction(int key, int i) {
        return (hashFunction1(key) + i * hashFunction2(key)) % 701;
    }

    public int insert(Node node,boolean counted) {
        int i = 0;
        int count=0;
        while (i < 701) {
            int j = fullHashFunction(node.getKey(), i);
            if (table[j] == null || table[j].getDeleted()) {
                table[j] = node;
                ++count;
                if(counted)
                {
                    System.out.println("На этом наборе данных добавление элемента требует "+count+" сравнений.");
                }
                return j;
            } else {
                i++;
                count++;
            }
        }
        if(counted)
        {
            System.out.println("На этом наборе данных добавление элемента требует "+count+" сравнений.");
        }
        return -1;
    }

    public int searsh(int key,boolean counted) {
        int i = 0;
        int count=0;
        while (i < 701) {
            int j = fullHashFunction(key, i);
            if (table[j] != null) {
                if (table[j].getKey() == key && !table[j].getDeleted()) {
                    ++count;
                    if(counted)
                    {
                        System.out.println("На этом наборе данных поиск элемента требует "+count+" сравнений.");
                    }
                    return j;
                } else {
                    count++;

                    i++;
                }
            } else {
                return -1;
            }
        }
        if(counted)
        {
            System.out.println("На этом наборе данных поиск элемента требует "+count+" сравнений.");
        }
        return -1;
    }

    public int remove(int key,boolean counted) {
        int i = 0;
        int count=0;
        while (i < 701) {
            int j = fullHashFunction(key, i);
            if (table[j] != null) {
                if (table[j].getKey() == key ) {
                    table[j].setDeleted(true);
                    ++count;
                    if(counted)
                    {
                        System.out.println("На этом наборе данных удаление элемента требует "+count+" сравнений.");
                    }
                    return j;
                } else {
                    count++;
                    i++;
                }
            } else {
                return -1;
            }
        }
        if(counted)
        {
            System.out.println("На этом наборе данных удаление элемента требует "+count+" сравнений.");
        }
        return -1;
    }

}


