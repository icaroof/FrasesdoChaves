package br.com.barrildobrado.chavesdebolso.model.dto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.barrildobrado.chavesdebolso.R;
import br.com.barrildobrado.chavesdebolso.model.vo.FraseVO;

/**
 * Created by Pretaum on 16/02/2016.
 */
public class AdapterListView extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<FraseVO> itens;

    public AdapterListView(Context context, List<FraseVO> itens) {
        //Itens do listview
        this.itens = itens;

        //Objeto responsável por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public FraseVO getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        FraseVO item = itens.get(position);

        view = mInflater.inflate(R.layout.item_list, null);

        ((TextView) view.findViewById(R.id.text_personagem)).setText(item.getIdStrFrase());
        ((ImageView) view.findViewById(R.id.icn_personagem)).setImageResource(item.getIdIcone());

        return view;
    }
}
