package com.example.minor.prototype10.OnClickMapButtons;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.R;

import java.util.logging.Handler;

public class OnClickOldMansionInBasementButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 45;
        savePosition();
        resetAllButtons();
        startAllButtons();
        int bgmId = 5;
        mediaPlayer = MediaPlayer.create(mMain, R.raw.basement_sound);
        audioPlay(mediaPlayer, bgmId);
        mainText.setText("地下室の中です。文章未定");
        //日記、卵についての資料、悪魔についての研究資料、嵐についての研究資料
        imageButton1Text.setText("研究資料1");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("我々アメルーン一族とバルト族の間に子供が生まれることはない。(正確には、生まれてくるのは人ではない。見たものにしか分からない、忌まわしいものだ。)\n私はその理由について研究を重ねたが、遺伝的な原因は一切見つからなかった。");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });
        imageButton2Text.setText("社会学の本");
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //人工島に人類が移住し、魔族が弱体化したため、最初は対等に暮らしていたが、過去の恨みと力量の差から、今度は魔族が差別されるようになる話
                        mainText.setText("我々とバルト族の関係は、ますます悪化している。\nバルト族は際立った人種主義と、群集暗示の魔術的な力に翻弄され、過去の我々と同じ過ちを繰り返そうとしている。\nこれから我々アメルーン一族には、確実に暗い未来が訪れるだろう。");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });
        imageButton3Text.setText("日記");
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("パトローナムが破られた。跡形も残っていなかった。私には、見たものすべてを物語る勇気がない。すべて作り話のはずだったのだ。やつがここに辿り着くのも時間の問題だろう。このままでは間に合わない、せめて家族だけでも救うことができたら...");
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
        imageButton8Text.setText("出る");
    }

    @Override
    public void onClick(View v) {
        position = 45;
        savePosition();
        resetAllButtons();
        stopAllButtons();
        int bgmId = 4;
        mediaPlayer = MediaPlayer.create(mMain, R.raw.noise);
        audioPlay(mediaPlayer, bgmId);
        MainActivity.soundPool.play(MainActivity.walkGymnasiumSound, 5.0f, 5.0f, 1, 0, 0.8f);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.soundPool.play(MainActivity.doorOpenSound, 1.0f, 1.0f, 1, 0, 0.8f);
            }
        }, 4500);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createMap();
            }
        }, 5500);
    }
}
