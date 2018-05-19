package com.example.minor.prototype10.Models;

import io.realm.RealmObject;

public class RawMaterialName extends RealmObject {
    private String rawMaterialName;

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }
}
