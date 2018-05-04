package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickOldMansionButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.sampleSound1, 1.0f, 1.0f, 1, 0, 1);
        position = 6;
        savePosition();
        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
        imageButton1.setOnClickListener(onClickOldMansion1FButton);
        imageButton1Text.setText("中に入る");
        OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton8.setOnClickListener(onClickPassButton);
        imageButton8Text.setText("やめる");
        mainText.setText("そこには大きな屋敷があった。\nいかにも一昔前の物だと分かる趣のある古い建物だ。\n不思議なことに、ここは自分以外には見つけられない、そんな確信があった。");
    }

    @Override
    public void onClick(View v) {
        stopAllButtons();
        createMap();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAllButtons();
            }
        }, 1000);
    }
}
