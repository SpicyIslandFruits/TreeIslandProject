package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickEvtMansion1FButton extends SuperOnClickMapButton {
    private void setBack(){
        stopAllButtons();
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("ここに隠れているのだろうか...");
        imageButton1Text.setText("探す");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1.setEnabled(false);
                imageButton1Text.setText("");
                imageButton8.setEnabled(false);
                imageButton8Text.setText("");
                mainText.setText("");
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 0.5f);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("戻る");
                        mainText.setText("ここにはいないようだ...");
                    }
                }, 1500);
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ボタンを元に戻す処理です。
                MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
                mainText.setText("あれは何だったんだろう...\nどこへ行ったのだろう...\n謎は深まるばかりだ。");
                imageButton1Text.setText("2階へ上がる");
                OnClickEvtMansion2FButton onClickEvtMansion2FButton = new OnClickEvtMansion2FButton();
                imageButton1.setOnClickListener(onClickEvtMansion2FButton);
                imageButton2Text.setText("浴室");
                imageButton4Text.setText("倉庫");
                imageButton7Text.setText("裏口");
                imageButton8Text.setText("出る");
                imageButton8.setEnabled(false);
                imageButton8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainText.setText("屋敷の外へ出たとは考えにくい...\nもう少し探してみよう。");
                    }
                });
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startAllButtons();
                    }
                }, 1000);
            }
        });
        imageButton8Text.setText("戻る");
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageButton1.setEnabled(true);
                imageButton8.setEnabled(true);
            }
        }, 1000);
    }

    @Override
    public void createMap() {
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        resetAllButtons();
        position = 33;
        onInit();

        if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 0) {
            OnClickEvtMansion2FButton onClickEvtMansion2FButton = new OnClickEvtMansion2FButton();
            imageButton1.setOnClickListener(onClickEvtMansion2FButton);
            imageButton1Text.setText("2階へ上がる");
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton2Text.setText("浴室");
            imageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton4Text.setText("倉庫");
            OnClickEvtBackDoorButton onClickEvtBackDoorButton = new OnClickEvtBackDoorButton();
            imageButton7.setOnClickListener(onClickEvtBackDoorButton);
            imageButton7Text.setText("裏口");
            imageButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                    mainText.setText("屋敷の外へ出たとは考えにくい...\nもう少し探してみよう。");
                }
            });
            imageButton8Text.setText("出る");


        }else if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 1){
            OnClickEvtMansion2FButton onClickEvtMansion2FButton = new OnClickEvtMansion2FButton();
            imageButton1.setOnClickListener(onClickEvtMansion2FButton);
            imageButton1Text.setText("2階へ上がる");
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton2Text.setText("浴室");
            OnClickEvtWarehouseButton onClickEvtWarehouseButton = new OnClickEvtWarehouseButton();
            imageButton4.setOnClickListener(onClickEvtWarehouseButton);
            imageButton4Text.setText("倉庫");
            OnClickEvtBackDoorButton onClickEvtBackDoorButton = new OnClickEvtBackDoorButton();
            imageButton7.setOnClickListener(onClickEvtBackDoorButton);
            imageButton7Text.setText("裏口");
            imageButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                    mainText.setText("屋敷の外へ出たとは考えにくい...\nもう少し探してみよう。");
                }
            });
            imageButton8Text.setText("出る");
        }else if(sharedPreferences.getInt("oldMansionGhostPosition", 0) == 2){
            OnClickEvtMansion2FButton onClickEvtMansion2FButton = new OnClickEvtMansion2FButton();
            imageButton1.setOnClickListener(onClickEvtMansion2FButton);
            imageButton1Text.setText("2階へ上がる");
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                }
            });
            imageButton2Text.setText("浴室");
            imageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainText.setText("ここにはもういないだろう。\n他を探そう...");
                }
            });
            imageButton4Text.setText("倉庫");
            OnClickEvtBackDoorButton onClickEvtBackDoorButton = new OnClickEvtBackDoorButton();
            imageButton7.setOnClickListener(onClickEvtBackDoorButton);
            imageButton7Text.setText("裏口");
            imageButton8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setBack();
                    mainText.setText("屋敷の外へ出たとは考えにくい...\nもう少し探してみよう。");
                }
            });
            imageButton8Text.setText("出る");
        }

        //ここは修正
        mainText.setText("あれは何だったんだろう...\nどこへ行ったのだろう...\n謎は深まるばかりだ。");
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
