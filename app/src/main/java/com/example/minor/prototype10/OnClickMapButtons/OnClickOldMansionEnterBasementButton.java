package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickOldMansionEnterBasementButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 40;
        savePosition();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.doorOpenSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("ここは地下室への階段です。");
        //音声を変更します。扉が開く音にします。BGMを変更します。ホラー素材にあった600hz音にします。
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("階段を下りる");
        OnClickGardenCornerButton onClickGardenCornerButton = new OnClickGardenCornerButton();
        imageButton8.setOnClickListener(onClickGardenCornerButton);
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
