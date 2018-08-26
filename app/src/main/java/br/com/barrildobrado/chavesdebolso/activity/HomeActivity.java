package br.com.barrildobrado.chavesdebolso.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdView;

import br.com.barrildobrado.chavesdebolso.R;
import br.com.barrildobrado.chavesdebolso.model.AdMobLoader;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnMadruga;
    private ImageButton btnChaves;
    private ImageButton btnBarriga;
    private ImageButton btnChiquinha;
    private ImageButton btnKiko;
    private ImageButton btnNhonho;
    private ImageButton btnClotildes;
    private ImageButton btnFlorinda;
    private ImageButton btnGirafales;
    private ImageButton btnGodinez;
    private ImageButton btnPopis;
    private ImageButton btnEspecial;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdMobLoader.loadAdMob((AdView) findViewById(R.id.ad_view));

        configuraBotoes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_todas) {
            Intent todosIntent = new Intent(HomeActivity.this, ListaFrasesActivity.class);
            startActivity(todosIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void configuraBotoes() {
        intent = new Intent(this, PlayerFraseActivity.class);

        btnMadruga = (ImageButton) findViewById(R.id.btn_madruga);
        btnMadruga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.MADRUGA.getValue());
                startActivity(intent);
            }
        });

        btnChaves = (ImageButton) findViewById(R.id.btn_chaves);
        btnChaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.CHAVES.getValue());
                startActivity(intent);
            }
        });

        btnChiquinha = (ImageButton) findViewById(R.id.btn_chiquinha);
        btnChiquinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.CHIQUINHA.getValue());
                startActivity(intent);
            }
        });

        btnClotildes = (ImageButton) findViewById(R.id.btn_clotildes);
        btnClotildes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.CLOTILDES.getValue());
                startActivity(intent);
            }
        });

        btnBarriga = (ImageButton) findViewById(R.id.btn_barriga);
        btnBarriga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.BARRIGA.getValue());
                startActivity(intent);
            }
        });

        btnKiko = (ImageButton) findViewById(R.id.btn_kiko);
        btnKiko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.KIKO.getValue());
                startActivity(intent);
            }
        });

        btnNhonho = (ImageButton) findViewById(R.id.btn_nhonho);
        btnNhonho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.NHONHO.getValue());
                startActivity(intent);
            }
        });

        btnFlorinda = (ImageButton) findViewById(R.id.btn_florinda);
        btnFlorinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.FLORINDA.getValue());
                startActivity(intent);
            }
        });

        btnGirafales = (ImageButton) findViewById(R.id.btn_girafales);
        btnGirafales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.GIRAFALES.getValue());
                startActivity(intent);
            }
        });

        btnGodinez = (ImageButton) findViewById(R.id.btn_godinez);
        btnGodinez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.GODINEZ.getValue());
                startActivity(intent);
            }
        });

        btnPopis = (ImageButton) findViewById(R.id.btn_popis);
        btnPopis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.POPIS.getValue());
                startActivity(intent);
            }
        });

        btnEspecial = (ImageButton) findViewById(R.id.btn_especial);
        btnEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("personagem", Personagem.ESPECIAL.getValue());
                startActivity(intent);
            }
        });
    }

    public static enum Personagem {
        BARRIGA(1), CHAVES(2), CHIQUINHA(3), CLOTILDES(4), FLORINDA(5), GIRAFALES(6),
        KIKO(7), MADRUGA(8), NHONHO(9), GODINEZ(10), POPIS(11), ESPECIAL(12);

        private int codigo;

        private Personagem(int c) {
            codigo = c;
        }

        public int getValue() {
            return codigo;
        }
    }
}
