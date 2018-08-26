package br.com.barrildobrado.chavesdebolso.model;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Pretaum on 22/02/2016.
 */
public class AdMobLoader {

    public static void loadAdMob(AdView adView) {
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("8A281DD78284AB9EE7FC9DA4850E7521")
                .build();

        adView.loadAd(adRequest);
    }
}
