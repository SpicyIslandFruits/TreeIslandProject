package com.example.minor.prototype10.Items.OtherItems;

import com.example.minor.prototype10.Items.SuperItem;

public class SampleOtherItem2 extends SuperItem {
    public static final String name = "SampleOtherItem2";
    public static final String information = "OtherItemのサンプル２です。何もできません。";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return information;
    }
}
