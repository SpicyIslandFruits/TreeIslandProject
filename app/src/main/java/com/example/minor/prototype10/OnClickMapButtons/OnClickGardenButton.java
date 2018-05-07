package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

/**
 * Created by nishiokakota on 2018/05/06.
 */

public class OnClickGardenButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 19;
        savePosition();
        resetAllButtons();
        mainText.setText("お前は庭に出た...。\n小さなブランコが置いてある、家族で住んでいたのだろうか。");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldWoodenDoorSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("座るところが抜けて骨組みがむき出しになっている。\nこのままでは使えない。");
            }
        });
        imageButton1Text.setText("壊れたベンチ");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("井戸の中に何かあるかもしれない...。\n\n\nなどと思って入ろうとした者はまさかいないだろう。");
                imageButton1.setEnabled(false);
                imageButton2.setEnabled(false);
                imageButton3.setEnabled(false);
                imageButton7.setEnabled(false);
                imageButton8.setEnabled(false);
                imageButton2Text.setText("");
                imageButton3Text.setText("");
                imageButton7Text.setText("");
                imageButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.soundPool.play(MainActivity.moneyDropSound, 1.0f, 1.0f, 1, 0, 1);
                        //金額を選択してお金を投げ入れる処理を描く
                        mainText.setText("未実装");
                    }
                });
                imageButton1Text.setText("お金を投げ込む");

                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
                        imageButton1.setEnabled(false);
                        imageButton2.setEnabled(false);
                        imageButton3.setEnabled(false);
                        imageButton7.setEnabled(false);
                        imageButton8.setEnabled(false);
                        imageButton2Text.setText("井戸");
                        imageButton3Text.setText("ブランコ");
                        imageButton7Text.setText("庭の隅");
                        imageButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldWoodenDoorSound, 1.0f, 1.0f, 1, 0, 1);
                                mainText.setText("座るところが抜けて骨組みがむき出しになっている。\nこのままでは使えない。");
                            }
                        });
                        imageButton1Text.setText("壊れたベンチ");
                        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
                        imageButton8.setOnClickListener(onClickOldMansion1FButton);
                        imageButton8Text.setText("戻る");
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                imageButton1.setEnabled(true);
                                imageButton2.setEnabled(true);
                                imageButton3.setEnabled(true);
                                imageButton7.setEnabled(true);
                                imageButton8.setEnabled(true);
                            }
                        }, 1000);
                        mainText.setText("お前は庭に出た...。\n小さなブランコが置いてある、家族で住んでいたのだろうか。");
                    }
                });
                imageButton8Text.setText("やめる");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton1.setEnabled(true);
                        imageButton8.setEnabled(true);
                    }
                }, 1000);
            }
        });
        imageButton2Text.setText("井戸");

        OnClickEmptyButton onClickEmptyButton3 = new OnClickEmptyButton();
        imageButton3.setOnClickListener(onClickEmptyButton3);
        imageButton3Text.setText("ブランコ");

        OnClickGardenCornerButton onClickGardenCornerButton = new OnClickGardenCornerButton();
        imageButton7.setOnClickListener(onClickGardenCornerButton);
        imageButton7Text.setText("庭の隅");

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
