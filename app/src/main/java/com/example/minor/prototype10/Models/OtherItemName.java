package com.example.minor.prototype10.Models;

import io.realm.RealmObject;

public class OtherItemName extends RealmObject {
    private String otherItemName;

    public String getOtherItemName() {
        return otherItemName;
    }

    public void setOtherItemName(String otherItemName) {
        this.otherItemName = otherItemName;
    }
}
