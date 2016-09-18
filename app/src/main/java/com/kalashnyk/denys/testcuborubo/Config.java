package com.kalashnyk.denys.testcuborubo;

import com.kalashnyk.denys.testcuborubo.model.Location;
import com.kalashnyk.denys.testcuborubo.model.ToolsTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by User on 11.09.2016.
 */
public class Config {
    final static public String LINK_STORE = "http://aschoolapi.appspot.com/";
    // strings for request to Store
    public static int _idStore;
    public static String _nameStore;
    public static String _addressStore;
    public static String _phoneStore;
    public static Location _locationStore;
    // strings for request to Instrument
    public static int _idInstrument;
    public static String _brandInstrument;
    public static String _modelInstrument;
    public static String _imageUrlInstrument;
    public static String _typeInstrument;
    public static double _priceInstrument;
    public static int _quantityInstrument;
    // strings for Location
    public static int _latitudeLocation;
    public static int _longitudeLocation;


    public static final int REPLACE = 0;
    public static final int DIALOG_REPLACE = 1;
    public final static String LOG_TAG = "myLogs";
    public static final int DIALOG_ALERT = 2;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final String[] BRAND = {
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Антон Чехов","Антон Чехов", "J R R Tolkien","J R R Tolkien","J R R Tolkien"};

    private static final String[] MODEL = {
            "Морфий","Белая гвардия","Прощай оружие","По ком звонит колокол",
            "Заводной апельсин","1984","Тихий Дон",
            "Игра престолов","Пикник на обочине","Трудно быть богом",
            "Палата №6","Жалобная книга", "Lord of the Rings: The Fellowship of the Ring",
            "Lord of the Rings: The Two Towers",
            "Lord of the Rings: The Return of the King"};
    private static final String[] IMAGEURL = {
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Антон Чехов","Антон Чехов", "J R R Tolkien","J R R Tolkien","J R R Tolkien"};

    private static final String[] TYPE = {
            "Морфий","Белая гвардия","Прощай оружие","По ком звонит колокол",
            "Заводной апельсин","1984","Тихий Дон",
            "Игра престолов","Пикник на обочине","Трудно быть богом",
            "Палата №6","Жалобная книга", "Lord of the Rings: The Fellowship of the Ring",
            "Lord of the Rings: The Two Towers",
            "Lord of the Rings: The Return of the King"};
    private static final double [] PRICE = {
            0.20, 0.21, 0.22, 0.23, 0.24,
            0.25, 0.26, 0.27, 0.28, 0.29, 0.30,
            0.31, 0.32,  0.33, 0.34, 0.35};

    private static final int[] QUANTITY = {
            20, 21, 22, 23, 24,
            25, 26, 27, 28, 29, 30,
            31, 32,  33, 34, 35};
    public ArrayList getToolsData(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i<BRAND.length; i++){
            arrayList.add(new ToolsTest()
                    .setBrand(BRAND[i])
                    .setModel(MODEL[i])
                    .setImageUrl(IMAGEURL[i])
                    .setType(TYPE[i])
                    .setPrice(PRICE[i])
                    .setQuantity(QUANTITY[i]));
        }
        return arrayList;
    }
}
