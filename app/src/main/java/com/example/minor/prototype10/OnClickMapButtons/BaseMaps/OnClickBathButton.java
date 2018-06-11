package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickBathButton extends SuperOnClickMapButton {
    public void createMap() {
        position = 10;
        savePosition();
        resetAllButtons();
        mainText.setText("浴室には大きめの窓がついており、とても開放的だ。\n窓の外では杉林が夜の闇に沈んでいる...。\nあたりには生き物の気配はなく、死んだような静寂だけが広がっていた。");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1Text.setText("");
                imageButton8Text.setText("");
                mainText.setText("入浴中・");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("入浴中・・");
                    }
                }, 1100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("入浴中・・・");
                    }
                }, 2100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("入浴中・・・・");
                    }
                }, 3100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("入浴中・・・・・");
                    }
                }, 4100);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("入浴中・・・・・・");
                    }
                }, 5100);
                MainActivity.soundPool.play(MainActivity.oldMansionShowerSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                realm.beginTransaction();
                playerInfo.setPoisonFlag(false);
                playerInfo.setBleedingFlag(false);
                realm.commitTransaction();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton1Text.setText("入浴する");
                        imageButton8Text.setText("戻る");
                        mainText.setText("お前の体にたまった疲れや汚れが、シャワーの水と一緒に落ちていった。\n生まれ変わったような気分である。\n※状態異常が回復した。");
                        startAllButtons();
                    }
                }, 6100);
            }
        });
        imageButton1Text.setText("入浴する");
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
