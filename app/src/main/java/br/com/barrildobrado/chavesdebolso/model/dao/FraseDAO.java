package br.com.barrildobrado.chavesdebolso.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.barrildobrado.chavesdebolso.model.DBHelper;
import br.com.barrildobrado.chavesdebolso.model.vo.FraseVO;

public class FraseDAO {
    public static final String TABLE_NAME = "FRASE";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_ICONE = "idIcone";
    private static final String COLUMN_BACKGROUND = "idBackground";
    private static final String COLUMN_MEDIA = "idMedia";
    private static final String COLUMN_FRASE = "idStrFrase";
    private static final String COLUMN_PERSONAGEM = "idPersonagem";
    private static final String COLUMN_ASSINATURA = "idAssinatura";

    private SQLiteDatabase dataBase = null;
    private static FraseDAO instance;

    public FraseDAO(Context context) {
        DBHelper persistenceHelper = DBHelper.getInstance(context);
        dataBase = persistenceHelper.getReadableDatabase();
    }

    public static FraseDAO getInstance(Context context) {
        if(instance == null)
            instance = new FraseDAO(context);
        return instance;
    }

    public void save(FraseVO frase) {
        ContentValues values = getContentValuesFrase(frase);
        dataBase.insert(TABLE_NAME, null, values);
    }

    public FraseVO findById(int id) {
        String strId = "_id = ?";
        Cursor cursor = dataBase.query(TABLE_NAME, null, strId, new String[]{String.valueOf(id)}, null, null, null);

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            return transformResultSet(cursor);
        }

        return null;
    }

    public List<FraseVO> findAll() {
        String queryReturnAll = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
        List<FraseVO> frases = transformResultSetList(cursor);
        return frases;
    }

    public List<FraseVO> findAllByPersonagem(int idPersonagem) {
        String queryReturnAll = "SELECT * FROM " + TABLE_NAME + " WHERE "+ COLUMN_PERSONAGEM + " = " + idPersonagem;

        Cursor cursor = dataBase.rawQuery(queryReturnAll, null);

        List<FraseVO> frases = transformResultSetList(cursor);

        return frases;
    }

    public void delete(FraseVO frase) {
        String[] args = {String.valueOf(frase.getId())};
        dataBase.delete(TABLE_NAME, COLUMN_ID + " = ?", args);
    }

    public void update(FraseVO frase) {
        ContentValues values = getContentValuesFrase(frase);
        String[] args = {String.valueOf(frase.getId())};
        dataBase.update(TABLE_NAME, values, COLUMN_ID + " = ?", args);
    }

    public void fecharConexao() {
        if (dataBase != null && dataBase.isOpen())
            dataBase.close();
    }

    private ContentValues getContentValuesFrase(FraseVO f) {
        ContentValues c = new ContentValues();
        c.put(COLUMN_ICONE, f.getIdIcone());
        c.put(COLUMN_MEDIA, f.getIdMedia());
        c.put(COLUMN_FRASE, f.getIdStrFrase());
        c.put(COLUMN_BACKGROUND, f.getIdBackground());
        c.put(COLUMN_PERSONAGEM, f.getIdStrFrase());
        c.put(COLUMN_ASSINATURA, f.getIdAssinatura());
        return c;
    }

    private FraseVO transformResultSet(Cursor cursor) {
        try {
            int indexId = cursor.getColumnIndex(COLUMN_ID);
            int indexIcone = cursor.getColumnIndex(COLUMN_ICONE);
            int indexMedia = cursor.getColumnIndex(COLUMN_MEDIA);
            int indexStrFrase = cursor.getColumnIndex(COLUMN_FRASE);
            int indexBackground = cursor.getColumnIndex(COLUMN_BACKGROUND);
            int indexPersonagem = cursor.getColumnIndex(COLUMN_PERSONAGEM);
            int indexAssinatura = cursor.getColumnIndex(COLUMN_ASSINATURA);

            FraseVO frase = new FraseVO();
            frase.setId(cursor.getInt(indexId));
            frase.setIdIcone(cursor.getInt(indexIcone));
            frase.setIdMedia(cursor.getInt(indexMedia));
            frase.setIdStrFrase(cursor.getInt(indexStrFrase));
            frase.setIdBackground(cursor.getInt(indexBackground));
            frase.setIdPersonagem(cursor.getInt(indexPersonagem));
            frase.setIdAssinatura(cursor.getInt(indexAssinatura));

            return frase;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<FraseVO> transformResultSetList(Cursor cursor) {
        List<FraseVO> frases = new ArrayList<>();

        if (cursor == null)
            return frases;

        try {
            if (cursor.moveToFirst()) {
                do {
                    FraseVO frase = transformResultSet(cursor);

                    if(frase != null)
                        frases.add(frase);
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }

        return frases;
    }
}
