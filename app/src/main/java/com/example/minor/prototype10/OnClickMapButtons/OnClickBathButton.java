package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBathButton extends SuperOnClickMapButton {
    public void createMap() {
        position = 10;
        savePosition();
        resetAllButtons();
        mainText.setText("浴室には余分なスペースはほとんどないが、なぜか窮屈な感じはしなかった。\n天井が高く、大きめの窓がついているせいかもしれない...");
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
                        mainText.setText("汗みどろになった後のシャワーの味は格別だ。\n体にたまった疲れや汚れが、シャワーの水と一緒に落ちていった。\n流石に生まれ変わったような気分だ。");
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

    public static class OnClickWarehouseButton extends SuperOnClickMapButton {
        public void createMap() {
            position = 14;
            savePosition();
            resetAllButtons();
            mainText.setText("倉庫は未実装です。");
            MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
            OnClickOldMansion2FButton onClickOldMansion2FButton = new OnClickOldMansion2FButton();
            imageButton8.setOnClickListener(onClickOldMansion2FButton);
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
}
