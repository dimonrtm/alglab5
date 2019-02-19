package com.company;

/**
 * Created by админъ on 16.10.2017.
 */
public class Node {
    private int key;
    private boolean deleted;
    public Node(int key)
    {
        this.key=key;
        this.deleted=false;
    }

    public int getKey()
    {
        return this.key;
    }

    public boolean getDeleted()
    {
        return this.deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
