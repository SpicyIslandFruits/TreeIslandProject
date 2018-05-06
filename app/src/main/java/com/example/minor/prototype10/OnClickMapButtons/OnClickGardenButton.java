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
        MainActivity.soundPool.play(MainActivity.sampleSound1, 1.0f, 1.0f, 1, 0, 1);
        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
        imageButton1.setOnClickListener(onClickEmptyButton);
        imageButton1Text.setText("ベンチ");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("井戸の中は真っ暗だ、まさかこの中に入ろうとしたものはいないだろう。");
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
                        //金額を選択してお金を投げ入れる処理を描く
                        mainText.setText("未実装");
                    }
                });
                imageButton1Text.setText("お金を入れる");

                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageButton1.setEnabled(false);
                        imageButton2.setEnabled(false);
                        imageButton3.setEnabled(false);
                        imageButton7.setEnabled(false);
                        imageButton8.setEnabled(false);
                        imageButton2Text.setText("井戸を覗く");
                        imageButton3Text.setText("ブランコ");
                        imageButton7Text.setText("庭の隅");
                        //ここはOnClickGardenButtonの処理に合わせる
                        OnClickEmptyButton onClickEmptyButton = new OnClickEmptyButton();
                        imageButton1.setOnClickListener(onClickEmptyButton);
                        imageButton1Text.setText("ベンチ");
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
        imageButton2Text.setText("井戸を覗く");

        OnClickEmptyButton onClickEmptyButton3 = new OnClickEmptyButton();
        imageButton3.setOnClickListener(onClickEmptyButton3);
        imageButton3Text.setText("ブランコ");
        OnClickEmptyButton onClickEmptyButton1 = new OnClickEmptyButton();
        imageButton7.setOnClickListener(onClickEmptyButton1);
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
