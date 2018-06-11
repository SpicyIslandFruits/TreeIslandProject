package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.media.MediaPlayer;
import android.view.View;
import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.OnClickPassButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickOldMansion1FButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        resetAllButtons();
        position = 8;
        savePosition();
        String bgmName = "oldMansionBgm";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.old_mansion_bgm);
        audioPlay(mediaPlayer, bgmName);
        OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
        imageButton1.setOnClickListener(onClickOldMansion2FButton);
        imageButton1Text.setText("2階へ上がる");
        OnClickBathButton onClickBathButton = new OnClickBathButton();
        imageButton2.setOnClickListener(onClickBathButton);
        imageButton2Text.setText("浴室");
        OnClickWarehouseButton onClickWarehouseButton = new OnClickWarehouseButton();
        imageButton4.setOnClickListener(onClickWarehouseButton);
        imageButton4Text.setText("倉庫");
        OnClickBackDoorButton onClickBackDoorButton = new OnClickBackDoorButton();
        imageButton7.setOnClickListener(onClickBackDoorButton);
        imageButton7Text.setText("裏口");
        OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton8.setOnClickListener(onClickPassButton);
        imageButton8Text.setText("出る");
        mainText.setText("お前は屋敷の中へと入っていった…。\n薄暗い部屋の中、壁の汚れた模様が不気味な雰囲気を醸し出している。\nとても陰気な雰囲気だ、しかし不思議とお前の心は安らいだ。");
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
