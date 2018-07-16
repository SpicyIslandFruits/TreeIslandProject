package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.Activities.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickMoneyThrowButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 34;
        onInit();
        mainText.setText("何を思ったのか、お前は無性にお金を投げ込みたくなったのだ。\n\n\n幾ら投げ込もうか...");
        MainActivity.soundPool.play(MainActivity.walletSound, 1.0f, 1.0f, 1, 0, 1);
        //投げ込んだ金額を足し算して、幽霊のイベントの際に1.1倍にして返す。
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerInfo.getMoney() >= 100) {
                    MainActivity.soundPool.play(MainActivity.moneyDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 100);
                    playerInfo.setIdoMoneyCount(playerInfo.getIdoMoneyCount() + 100);
                    realm.commitTransaction();
                    stopAllButtons();
                    mainText.setText("");
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 700);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mainText.setText("お前は100$投げ込んだ...\n\nちょっともったいない気がした。");
                            startAllButtons();
                            imageButton1Text.setText("100$");
                            imageButton2Text.setText("500$");
                            imageButton3Text.setText("1000$");
                            imageButton8Text.setText("やめる");
                        }
                    }, 1000);
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
                    MainActivity.soundPool.play(MainActivity.moneyDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 500);
                    playerInfo.setIdoMoneyCount(playerInfo.getIdoMoneyCount() + 500);
                    realm.commitTransaction();
                    stopAllButtons();
                    mainText.setText("");
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 700);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int textNum;
                            textNum = (int)(Math.random()*2 + 1);
                            switch (textNum) {
                                case 1:
                                    mainText.setText("お前は500$投げ込んだ。ご利益があるだろうか。");
                                    break;
                                case 2:
                                    mainText.setText("コインを投げると願いが叶うと聞いたことがある。\nきっといいことがあるだろう");
                                    break;
                            }
                            startAllButtons();
                            imageButton1Text.setText("100$");
                            imageButton2Text.setText("500$");
                            imageButton3Text.setText("1000$");
                            imageButton8Text.setText("やめる");
                        }
                    }, 1000);
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
                    MainActivity.soundPool.play(MainActivity.moneyDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 1000);
                    playerInfo.setIdoMoneyCount(playerInfo.getIdoMoneyCount() + 1000);
                    realm.commitTransaction();
                    stopAllButtons();
                    mainText.setText("");
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 700);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int textNum;
                            textNum = (int)(Math.random()*2 + 1);
                            switch (textNum) {
                                case 1:
                                    mainText.setText("何をやっているのだろう...\nお前は少し後悔した。");
                                    break;
                                case 2:
                                    mainText.setText("お前は1000$投げ込んだ。\n少しもったいない気もするが...");
                                    break;
                            }
                            startAllButtons();
                            imageButton1Text.setText("100$");
                            imageButton2Text.setText("500$");
                            imageButton3Text.setText("1000$");
                            imageButton8Text.setText("やめる");
                        }
                    }, 1000);
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

        OnClickIdoButton onClickIdoButton = new OnClickIdoButton();
        imageButton8.setOnClickListener(onClickIdoButton);
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
