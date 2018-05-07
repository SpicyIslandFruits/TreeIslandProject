package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

/**
 * Created by nishiokakota on 2018/05/06.
 */

public class OnClickBackDoorButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 18;
        savePosition();
        resetAllButtons();
        mainText.setText("ここから庭に出られるようだ。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton1.setOnClickListener(onClickGardenButton);
        imageButton1Text.setText("外に出る");
        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
        imageButton8.setOnClickListener(onClickOldMansion1FButton);
        imageButton8Text.setText("戻る");
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
