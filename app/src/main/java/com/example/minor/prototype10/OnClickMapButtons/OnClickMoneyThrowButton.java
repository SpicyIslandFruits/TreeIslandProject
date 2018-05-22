package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickMoneyThrowButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 34;
        savePosition();
        resetAllButtons();
        mainText.setText("何を思ったのか、お前は無性にお金を投げ込みたくなったのだ。\n\n\n幾ら投げ込もうか...");
        MainActivity.soundPool.play(MainActivity.walletSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerInfo.getMoney() >= 100) {
                    MainActivity.soundPool.play(MainActivity.moneyDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 100);
                    realm.commitTransaction();
                    stopAllButtons();
                    mainText.setText("");
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 500);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int textNum;
                            textNum = (int)(Math.random()*2 + 1);
                            switch (textNum) {
                                case 1:
                                    mainText.setText("お前は100$投げ込んだ、何か物足りない気分だ。");
                                    break;
                                case 2:
                                    mainText.setText("きっといいことがあるだろう。こういうのは気持ちの問題だ。");
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
        imageButton1Text.setText("100$");

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playerInfo.getMoney() >= 500) {
                    MainActivity.soundPool.play(MainActivity.moneyDropSound, 1.0f, 1.0f, 1, 0, 1);
                    realm.beginTransaction();
                    playerInfo.setMoney(playerInfo.getMoney() - 500);
                    realm.commitTransaction();
                    stopAllButtons();
                    mainText.setText("");
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 500);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int textNum;
                            textNum = (int)(Math.random()*2 + 1);
                            switch (textNum) {
                                case 1:
                                    mainText.setText("お前は500$投げ込んだ、何とも言えない気分だ。");
                                    break;
                                case 2:
                                    mainText.setText("きっといいことがあるだろう");
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
                    realm.commitTransaction();
                    stopAllButtons();
                    mainText.setText("");
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.soundPool.play(MainActivity.waterDropSound, 1.0f, 1.0f, 1, 0, 1);
                        }
                    }, 500);
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
                                    mainText.setText("こんなことをして何になるんだろう...");
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
