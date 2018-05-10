package com.example.minor.prototype10.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ItemId extends RealmObject {
    private int itemType;
    private String Name;

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
