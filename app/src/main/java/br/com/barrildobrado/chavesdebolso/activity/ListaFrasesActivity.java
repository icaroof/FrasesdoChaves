package br.com.barrildobrado.chavesdebolso.activity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdView;

import java.util.List;

import br.com.barrildobrado.chavesdebolso.R;
import br.com.barrildobrado.chavesdebolso.model.AdMobLoader;
import br.com.barrildobrado.chavesdebolso.model.dao.FraseDAO;
import br.com.barrildobrado.chavesdebolso.model.dto.AdapterListView;
import br.com.barrildobrado.chavesdebolso.model.vo.FraseVO;

public class ListaFrasesActivity extends AppCompatActivity implements Animation.AnimationListener {

    private AdView mAdView;

    private ListView listaFrases;
    private AdapterListView adapterListView;
    private List<FraseVO> itens;

    private MediaPlayer mediaPlayer;
    private Animation chaves_animation;

    private FraseDAO fraseDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fraseDAO = FraseDAO.getInstance(this);

        setContentView(R.layout.activity_lista_frases);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        configurarAnimacoes();
        initListaFrases();

        AdMobLoader.loadAdMob((AdView) findViewById(R.id.ad_view_frases));
    }

    private void initListaFrases() {
        itens = fraseDAO.findAll();

        adapterListView = new AdapterListView(this, itens);

        listaFrases = (ListView) findViewById(R.id.list_frases);
        listaFrases.setAdapter(adapterListView);
        listaFrases.setCacheColorHint(Color.TRANSPARENT);

        listaFrases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                prepareMediaAndAnimation(adapterListView.getItem(position));
            }
        });
    }

    private void prepareMediaAndAnimation(FraseVO frase) {
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            mediaPlayer = MediaPlayer.create(ListaFrasesActivity.this, frase.getIdMedia());
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                }
            });
            mediaPlayer.start();
        }
    }

    private void configurarAnimacoes() {
        chaves_animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.chaves_animation);
        chaves_animation.setAnimationListener(this);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == chaves_animation) {
            chaves_animation.cancel();
            chaves_animation = null;
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub
    }
}
