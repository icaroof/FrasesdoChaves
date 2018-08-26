package br.com.barrildobrado.chavesdebolso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    /* Nome do banco de dados */
    private static final String DATABASE_NAME = "frases_do_chaves";
    /* Versão do banco de dados */
    public static final int DATABASE_VERSION = 12;

    private static DBHelper instance;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
        insertValues(db);
    }

    public static DBHelper getInstance(Context context) {
        if (instance == null)
            instance = new DBHelper(context);
        return instance;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropTables(db);
        onCreate(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(ScriptsSQL.CREATE_TABLE_PERSONAGEM);
        db.execSQL(ScriptsSQL.CREATE_TABLE_FRASE);
    }

    private void insertValues(SQLiteDatabase db) {
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_1);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_2);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_3);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_4);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_5);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_6);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_7);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_8);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_9);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_10);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_11);
        db.execSQL(ScriptsSQL.INSERT_INTO_PERSONAGEM_12);


        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_1);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_2);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_3);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_4);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_5);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_6);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_7);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_8);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_9);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_10);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_11);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_12);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_13);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_14);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_15);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_16);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_17);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_18);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_19);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_20);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_21);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_22);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_23);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_24);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_25);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_26);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_27);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_28);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_29);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_30);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_31);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_32);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_33);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_34);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_35);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_36);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_37);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_38);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_39);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_40);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_41);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_42);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_43);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_44);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_45);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_46);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_47);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_48);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_49);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_50);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_51);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_52);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_53);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_54);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_55);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_56);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_57);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_58);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_59);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_60);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_61);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_62);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_63);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_64);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_65);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_66);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_67);
        db.execSQL(ScriptsSQL.INSERT_INTO_FRASE_68);
    }

    private void dropTables(SQLiteDatabase db) {
        db.execSQL(ScriptsSQL.DROP_TABLE_PERSONAGEM);
        db.execSQL(ScriptsSQL.DROP_TABLE_FRASE);
    }
}
