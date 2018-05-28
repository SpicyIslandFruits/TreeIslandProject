package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickBookshelfButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 39;
        savePosition();
        resetAllButtons();
        mainText.setText("古そうな書物が並んでいる...");
        MainActivity.soundPool.play(MainActivity.oldMansionWalkingSound, 1.0f, 1.0f, 1, 0, 1);
        imageButton1Text.setText("書物1");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("初めに、神は海と地を創造された。海は混沌であって、闇が深淵の表にあり、光が水の表を動いていた。それぞれの世界をつなぐようにして、果樹が地に芽生えた。ユグドラシルである。");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton2Text.setText("書物2");
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton3Text.setText("書物3");
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("アメルーン族は、神を裏切り、悪魔に身を売った呪われた種族である。彼らはとても貧弱だが、悪魔に与えられた、無力で奇妙な力を使う。\n我々バルト族は、決して彼らの声に耳を傾けてはならない。なぜなら我々も、呪われてしまうかもしれないからだ。");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
        OnClickStudyButton onClickStudyButton = new OnClickStudyButton();
        imageButton8.setOnClickListener(onClickStudyButton);
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
