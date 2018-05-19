package com.example.minor.prototype10.Models;

import io.realm.RealmObject;

public class AmuletName extends RealmObject {
    private String amuletName;

    public String getAmuletName() {
        return amuletName;
    }

    public void setAmuletName(String amuletName) {
        this.amuletName = amuletName;
    }
}
