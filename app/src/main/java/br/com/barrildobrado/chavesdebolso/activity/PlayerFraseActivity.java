package br.com.barrildobrado.chavesdebolso.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.facebook.FacebookSdk;

//import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import br.com.barrildobrado.chavesdebolso.R;
import br.com.barrildobrado.chavesdebolso.model.AdMobLoader;
import br.com.barrildobrado.chavesdebolso.model.dao.FraseDAO;
import br.com.barrildobrado.chavesdebolso.model.vo.FraseVO;

public class PlayerFraseActivity extends AppCompatActivity {
    private String FRASE = "FRASE";

    private MediaPlayer mediaPlayer;
    private Animation chaves_animation;

    private FloatingActionButton flBtnRepeat;
    private RelativeLayout layout;
    private TextView strFrase;

    private FraseDAO fraseDAO;

    private FraseVO frase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fraseDAO = FraseDAO.getInstance(this);

        setContentView(R.layout.activity_player_frase);
        initScreenElements();

        if(savedInstanceState == null) {
            findFrasesAndGetRandom();
            prepareMediaAndAnimation(layout, true);
        } else {
            frase = new Gson().fromJson(savedInstanceState.getString(FRASE), FraseVO.class);
            prepareMediaAndAnimation(layout, false);
        }

        prepareShareOption();

        AdMobLoader.loadAdMob((AdView) findViewById(R.id.ad_view_player));
    }

    private void prepareShareOption() {
        FloatingActionButton btnShare = (FloatingActionButton) findViewById(R.id.fl_btn_share);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frase == null)
                    Toast.makeText(PlayerFraseActivity.this, R.string.nao_encontrado, Toast.LENGTH_SHORT).show();
                else {
                    String shareString = getText(frase.getIdStrFrase()) + " (" + getText(frase.getIdAssinatura()) + ")";
                    Intent sendIntent = new Intent(Intent.ACTION_SEND);
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getText(R.string.app_name));
                    sendIntent.putExtra(Intent.EXTRA_TEXT, shareString);

                    try {
                        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.compartilhar_via)));
                    } catch (Exception e) {
                        Toast.makeText(PlayerFraseActivity.this, "Application not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(FRASE, new Gson().toJson(frase));
        super.onSaveInstanceState(savedInstanceState);
    }

    private void findFrasesAndGetRandom() {
        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("personagem")) {
            int idPersonagem = bundle.getInt("personagem");

            Random random = new Random();

            List<FraseVO> frases = fraseDAO.findAllByPersonagem(idPersonagem);

            if (!frases.isEmpty()) {
                int index = random.nextInt(frases.size());
                frase = frases.get(index);
            }
        }
    }

    private void prepareMediaAndAnimation(RelativeLayout layout, boolean primeiraCarga) {
        if(frase == null) {
            layout.setBackgroundResource(R.drawable.bg_especial);
            Toast.makeText(PlayerFraseActivity.this, R.string.nao_encontrado, Toast.LENGTH_SHORT).show();
        }
        else {
            layout.setBackgroundResource(frase.getIdBackground());
            strFrase.setText(frase.getIdStrFrase());

            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                mediaPlayer = MediaPlayer.create(PlayerFraseActivity.this, frase.getIdMedia());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                        }
                    }
                });
            }

            if (primeiraCarga)
                startMediaAndAnimation();
        }
    }

    private void initScreenElements() {
        flBtnRepeat = (FloatingActionButton) findViewById(R.id.fl_btn_repeat);
        flBtnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frase == null)
                    Toast.makeText(PlayerFraseActivity.this, R.string.nao_encontrado, Toast.LENGTH_SHORT).show();
                else {
                    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                        try {
                            mediaPlayer.stop();
                            mediaPlayer.prepare();
                            mediaPlayer.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        layout = (RelativeLayout) findViewById(R.id.lyt_background);
        strFrase = (TextView) findViewById(R.id.str_frase);
    }

    private void startMediaAndAnimation() {
        if(mediaPlayer != null && !mediaPlayer.isPlaying())
            mediaPlayer.start();
    }

}
