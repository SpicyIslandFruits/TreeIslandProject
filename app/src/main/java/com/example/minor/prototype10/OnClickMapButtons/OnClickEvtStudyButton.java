package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtStudyButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 37;
        savePosition();
        resetAllButtons();
        //鍵を取得します、その後、窓が開いていることに気付き外を見ると、幽霊らしき影が飛び去って行くのが見えます。
        mainText.setText("ここに隠れているのだろうか...");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton3Text.setText("書棚");
        OnClickEvtBookshelfButton onClickEvtBookshelfButton = new OnClickEvtBookshelfButton();
        imageButton3.setOnClickListener(onClickEvtBookshelfButton);
        OnClickEvtMansion2FButton onClickEvtMansion2FButton = new OnClickEvtMansion2FButton();
        imageButton8.setOnClickListener(onClickEvtMansion2FButton);
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
