package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickEvtMoneyThrowButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 33;
        savePosition();
        resetAllButtons();
        mainText.setText("何を思ったのか、お前は無性にお金を投げ込みたくなったのだ。\n\n\n幾ら投げ込もうか...");
        MainActivity.soundPool.play(MainActivity.moneyDropSound, 1.0f, 1.0f, 1, 0, 1);
        //幽霊の笑い声を流し、sharedPreferenceのイベントの進度フラッグを一増やします。
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerInfo.getMoney() >= 100) {
                    MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 100);
                    realm.commitTransaction();
                }else{
                    int textNum;
                    textNum = (int)(Math.random()*3 + 1);
                    switch (textNum) {
                        case 1:
                            mainText.setText("金が足りてないではないか。\nこんなことをしている場合ではない。");
                            break;
                        case 2:
                            mainText.setText("お金が足りない。\n街で稼いでこよう...");
                            break;
                        case 3:
                            mainText.setText("こういう時に限ってお金が足りない...\nお前は大切な機会を逃した気分になった。");
                            break;
                    }
                }
            }
        });
        imageButton1Text.setText("100$");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerInfo.getMoney() >= 500) {
                    MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 500);
                    realm.commitTransaction();
                }else{
                    int textNum;
                    textNum = (int)(Math.random()*3 + 1);
                    switch (textNum) {
                        case 1:
                            mainText.setText("金が足りてないではないか。\nこんなことをしている場合ではない。");
                            break;
                        case 2:
                            mainText.setText("お金が足りない。\n街で稼いでこよう...");
                            break;
                        case 3:
                            mainText.setText("こういう時に限ってお金が足りない...\nお前は大切な機会を逃した気分になった。");
                            break;
                    }
                }
            }
        });
        imageButton2Text.setText("500$");

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerInfo.getMoney() >= 1000) {
                    MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 1000);
                    realm.commitTransaction();
                }else{
                    int textNum;
                    textNum = (int)(Math.random()*3 + 1);
                    switch (textNum) {
                        case 1:
                            mainText.setText("金が足りてないではないか。\nこんなことをしている場合ではない。");
                            break;
                        case 2:
                            mainText.setText("お金が足りない。\n街で稼いでこよう...");
                            break;
                        case 3:
                            mainText.setText("こういう時に限ってお金が足りない...\nお前は大切な機会を逃した気分になった。");
                            break;
                    }
                }
            }
        });
        imageButton3Text.setText("1000$");

        OnClickEvtIdoButton onClickEvtIdoButton = new OnClickEvtIdoButton();
        imageButton8.setOnClickListener(onClickEvtIdoButton);
        imageButton8Text.setText("やめる");
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
