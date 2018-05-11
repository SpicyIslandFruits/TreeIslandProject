package com.example.minor.prototype10.Models;

import io.realm.RealmObject;

public class ImportantItemId extends RealmObject {
    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
