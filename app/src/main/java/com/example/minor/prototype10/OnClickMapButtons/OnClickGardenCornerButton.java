package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickGardenCornerButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 20;
        savePosition();
        resetAllButtons();
        mainText.setText("土が不自然に盛り上がっている...。");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAllButtons();
                //あとで音声を変える
                MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("文章未定");
                OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
                imageButton1.setOnClickListener(onClickEmptyButton);
                imageButton1Text.setText("開ける");
                imageButton8Text.setText("戻る");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() { startAllButtons();
                    }
                }, 1000);
            }
        });
        imageButton1Text.setText("確認する");

        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
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
