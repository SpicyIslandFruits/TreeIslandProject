package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBedroomButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 13;
        savePosition();
        resetAllButtons();
        mainText.setText("窓には重々しいカーテンがおろされ、室内に明かりはついていない。\nカーテンの隙間から微かに光がもれていたが、かえって暗闇を際立たせていた。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);

        OnClickBedButton onClickBedButton = new OnClickBedButton();
        imageButton1.setOnClickListener(onClickBedButton);
        imageButton1Text.setText("ベッド");

        OnClickOshiireButton onClickOshiireButton = new OnClickOshiireButton();
        imageButton7.setOnClickListener(onClickOshiireButton);
        imageButton7Text.setText("押入れ");

        OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
        imageButton8.setOnClickListener(onClickOldMansion2FButton);
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
