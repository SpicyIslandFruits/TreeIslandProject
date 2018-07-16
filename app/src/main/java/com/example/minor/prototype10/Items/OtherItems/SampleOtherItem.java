package com.example.minor.prototype10.Items.OtherItems;

import com.example.minor.prototype10.Items.SuperItem;

public class SampleOtherItem extends SuperItem {
    public static final String name = "SampleOtherItem";
    public static final String information = "OtherItemのサンプルです。何もできません。";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return information;
    }
}
