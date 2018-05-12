package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

public class OnClickOshiireButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 16;
        savePosition();
        resetAllButtons();
        mainText.setText("お前は押入れの中に入った。\nとても落ち着く...。\nたまには押入れで眠ってみるのもいいかもしれない。");
        MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton1Text.setText("");
                imageButton8Text.setText("");
                MainActivity.mediaPlayer.pause();
                MainActivity.soundPool.play(MainActivity.oldMansionSleepSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                int textNum;
                textNum = (int)(Math.random()*11 + 1);
                //ここはもっと増やしたい
                switch (textNum){
                    case 1:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは何かを目指して走り続けていた。\n人の身であるお前には辿り着けるはずがない場所だ。\nしかし諦めることを知らないお前は、どんどんこの世の理から外れていった。");
                        break;
                    case 2:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\n何かがおまえを見つめている。\nその眼には底知れない憎悪が宿っていた。");
                        break;
                    case 3:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは何かの鼓動を聞いた。それはゆっくりと成長を続けながら、世界を蝕んでいた...。");
                        break;
                    case 4:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは何かの存在を恐れていた。\nこの世界に存在する生命がそれを知ることは許されることではなかった。");
                        break;
                    case 5:
                        mainText.setText("お前には母親がいない。\n6際のころ突然育児を父親に押し付け、家を出ていった。\n毎日泣いて、毎日探しまわった。いつか帰ってくるだろうと待っていた。\nそんなことを思い出すうちに、お前は睡魔に襲われて眠りについた。");
                        break;
                    case 6:
                        mainText.setText("家主はどんな人だったのだろう...。どうしてこんなところに住もうと思ったのだろう...。\nそんなことを考えているうちに意識が朦朧として、お前は眠りについた。");
                        break;
                    case 7:
                        mainText.setText("お前はいつも劣っていた、しかしあの頃のお前には見守ってくれる存在もいたのかもしれない。\n過ぎ去った過去に思いをはせているうちに、お前は眠気に身を委ねていった。");
                        break;
                    case 8:
                        mainText.setText("お前には何も残されていなかった。\nお前はこれからのことに考えを巡らせたが、何も得られるものはなかった。\nそうこうしているうちにお前は眠りについた。");
                        break;
                    case 9:
                        mainText.setText("その夜お前は奇妙な夢を見た...。\nおまえは何かから逃げ続けている。\nおまえはそれを生命と呼んでいいのかわからなかった。");
                        break;
                    case 10:
                        mainText.setText("お前はふと考えた。\n自分はなぜこの屋敷にたどり着けたのだろうか。\nしかしいくら考えても答えは出てこない。\nそうこうしているうちにお前は眠気に誘われていった。");
                        break;
                    case 11:
                        mainText.setText("最近よく夢を見る...。\nぼんやりとして得体のしれないものばかりだが、不思議と感情だけははっきりと伝わってくる。\n思い出そうとしているうちに意識が朦朧として、お前は眠りについた。");
                        break;
                }
                realm.beginTransaction();
                playerInfo.setHP(playerInfo.getFmaxHP());
                playerInfo.setMP(playerInfo.getFmaxMP());
                realm.commitTransaction();
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageButton1.setEnabled(true);
                        imageButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                createMap();
                                mainText.setText("目覚めると傷が癒えていた。\n周囲を見渡して、お前はあることに気付く。\n\n真っ暗だ...。\n\n何度も目を疑ったが、しばらくしてここが押入れの中だと気付いた。");
                                startAllButtons();
                            }
                        });
                        imageButton1Text.setText("目を覚ます");
                    }
                }, 6500);
            }
        });
        imageButton1Text.setText("眠る");

        OnClickBedroomButton onClickBedroomButton = new OnClickBedroomButton();
        imageButton8.setOnClickListener(onClickBedroomButton);
        imageButton8Text.setText("出る");
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
