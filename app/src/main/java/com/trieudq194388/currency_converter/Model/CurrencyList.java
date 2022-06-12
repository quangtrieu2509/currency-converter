package com.trieudq194388.currency_converter.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CurrencyList {
    public static Map<Integer, CurrencyUnit> cList = new HashMap<>();
    public static ArrayList<String> spinnerList = new ArrayList<>();

    public static void init(){
        cList.put(0, new CurrencyUnit("AFN","Afghanistan", "Afghani", "؋", 88.66));
        cList.put(1, new CurrencyUnit("ARS","Argentina", "Peso", "$", 121.79));
        cList.put(2, new CurrencyUnit("AZN","Azerbaijan", "New Manat", "MaH", 1.695));
        cList.put(3, new CurrencyUnit("BDT","Bangladesh", "Taka", "৳", 92.81));
        cList.put(4, new CurrencyUnit("BZD","Belize", "Dollar", "BZ$", 1.9982));
        cList.put(5, new CurrencyUnit("BAM","Bosnia and Herzegovina", "Convertible Marka", "KM", 1.8206));
        cList.put(6, new CurrencyUnit("BND","Brunei", "Dollar", "$", 1.3876));
        cList.put(7, new CurrencyUnit("CVE","Cabo Verde", "Escudo", "Esc", 102.8));
        cList.put(8, new CurrencyUnit("KHR","Cambodia", "Riel", "៛", 4052));
        cList.put(9, new CurrencyUnit("CAD","Canada", "Dollar", "$", 1.2781));
        cList.put(10, new CurrencyUnit("CNY","China", "Yuan", "¥", 6.7081));
        cList.put(11, new CurrencyUnit("DJF","Djibouti", "Franc", "Fdj", 177.5));
        cList.put(12, new CurrencyUnit("EUR","Europe", "Euro", "€", 0.9507));
        cList.put(13, new CurrencyUnit("GHS","Ghana", "Cedi", "₵", 7.75));
        cList.put(14, new CurrencyUnit("HNL","Honduras", "Lempira", "L", 24.356));
        cList.put(15, new CurrencyUnit("INR","India", "Rupee", "₹", 78.1156));
        cList.put(16, new CurrencyUnit("ILS","Israel", "Shekel", "₪", 3.39));
        cList.put(17, new CurrencyUnit("JPY","Japan", "Yen", "¥", 134.42));
        cList.put(18, new CurrencyUnit("KRW","Korea", "Won", "₩", 1279));
        cList.put(19, new CurrencyUnit("LAK","Laos", "Kip", "₭", 14651));
        cList.put(20, new CurrencyUnit("MYR","Malaysia", "Ringgit", "RM", 4.4));
        cList.put(21, new CurrencyUnit("MMK","Myanmar", "Kyat", "K", 1850));
        cList.put(22, new CurrencyUnit("NGN","Nigeria", "Naira", "₦", 414));
        cList.put(23, new CurrencyUnit("OMR","Oman", "Rial", "ر.ع", 0.3847));
        cList.put(24, new CurrencyUnit("PKR","Pakistan", "Rupee", "Rs", 201.6));
        cList.put(25, new CurrencyUnit("PEN","Peru", "Nuevo Sol", "S/.", 3.7545));
        cList.put(26, new CurrencyUnit("RUB","Russia", "Rouble", "₽", 55.75));
        cList.put(27, new CurrencyUnit("SGD","Singapore", "Dollar", "S$", 1.3876));
        cList.put(28, new CurrencyUnit("TWD","Taiwan", "New Dollar", "NT$", 29.657));
        cList.put(29, new CurrencyUnit("THB","Thailand", "Baht", "฿", 34.72));
        cList.put(30, new CurrencyUnit("USD","United States", "Dollar", "$", 1));
        cList.put(31, new CurrencyUnit("VES","Venezuela", "Bolivar Soberano", "Bs.S", 5.2973));
        cList.put(32, new CurrencyUnit("VND","Vietnam", "Dong", "₫", 23177));
        cList.put(33, new CurrencyUnit("YER","Yemen", "Rial", "﷼", 249.98));
        cList.put(34, new CurrencyUnit("ZMW","Zambia", "Kwacha", "K", 16.875));

    }

    public static void initSpinnerArray(){
        for(int i = 0; i < cList.size(); i++){
            String str = cList.get(i).getCountryName()+" - "+cList.get(i).getCurrencyName();
            spinnerList.add(str);
        }

    }
}
