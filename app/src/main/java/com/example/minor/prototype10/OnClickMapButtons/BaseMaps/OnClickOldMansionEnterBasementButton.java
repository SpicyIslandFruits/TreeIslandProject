package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickOldMansionEnterBasementButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 40;
        savePosition();
        resetAllButtons();
        String bgmName = "noise";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.noise);
        audioPlay(mediaPlayer, bgmName);
        MainActivity.soundPool.play(MainActivity.doorOpenSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("隠し階段が現れた...\n地下室があるようだ。");
        //音声を変更します。扉が開く音にします。BGMを変更します。ホラー素材にあった600hz音にします。
        OnClickOldMansionInBasementButton onClickOldMansionInBasementButton = new OnClickOldMansionInBasementButton();
        imageButton1.setOnClickListener(onClickOldMansionInBasementButton);
        imageButton1Text.setText("階段を下りる");
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
