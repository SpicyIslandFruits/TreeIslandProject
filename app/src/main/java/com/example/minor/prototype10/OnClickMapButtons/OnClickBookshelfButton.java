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
        imageButton1Text.setText("創世記");
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
        imageButton2Text.setText("社会問題");
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("アメルーン族は、ニルンベルク血統保護法に従い、一定の条件のもとラーガ地区でのみ居住、繁殖が許可されている。\nしかし、法を無視し、我々の居住区に潜伏しようとする者が後を絶たない。");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton3Text.setText("市民の心得");
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("アメルーン族は、神を裏切り、悪魔に身を売った種族である。彼らはとても貧弱だが、悪魔に与えられた、無力で奇妙な力を使う。\n彼らは呪われている。我々バルト族は決して彼らの言葉に耳を傾けてはならない。");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("本を閉じる");
                        OnClickBookshelfButton onClickBookshelfButton = new OnClickBookshelfButton();
                        imageButton8.setOnClickListener(onClickBookshelfButton);
                    }
                }, 800);
            }
        });
        imageButton4Text.setText("民法全書");
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("民法第155条:すべての市民は指定の公的機関で定期的に検査を行う。これは市民の健康維持と、潜伏しているアメルーン族の捜索を目的としている。年齢に対する力量指数が187.7pm以下である場合には、アメルーン族である可能性が疑われる。直ちに能力テストを行い、何らかの異能が見つかった場合は、これを処分する。");
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
