package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickBBBothRepairedEvtButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 27;
        onInit();
        mainText.setText("気のせいではない...確かに誰かがいたのだ。\n探そう。");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        String bgmName = "oldMansionEventSound";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.old_mansion_event_sound);
        audioPlay(mediaPlayer, bgmName);
        //イベントマップにつなげます、テキスト以外の部分はほとんど通常マップのコピペ。
        OnClickEvtBenchButton onClickEvtBenchButton = new OnClickEvtBenchButton();
        imageButton1.setOnClickListener(onClickEvtBenchButton);
        imageButton1Text.setText("ベンチ");

        OnClickEvtIdoButton onClickEvtIdoButton = new OnClickEvtIdoButton();
        imageButton2.setOnClickListener(onClickEvtIdoButton);
        imageButton2Text.setText("井戸");

        OnClickEvtBurankoButton onClickEvtBurankoButton = new OnClickEvtBurankoButton();
        imageButton3.setOnClickListener(onClickEvtBurankoButton);
        imageButton3Text.setText("ブランコ");

        OnClickEvtGardenCornerButton onClickEvtGardenCornerButton = new OnClickEvtGardenCornerButton();
        imageButton7.setOnClickListener(onClickEvtGardenCornerButton);
        imageButton7Text.setText("庭の隅");

        OnClickEvtMansion1FButton onClickOldMansion1FButton = new OnClickEvtMansion1FButton();
        imageButton8.setOnClickListener(onClickOldMansion1FButton);
        imageButton8Text.setText("屋敷に入る");
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
