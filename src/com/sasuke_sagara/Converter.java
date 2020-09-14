package com.sasuke_sagara;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Converter {
    private static final TreeMap<Integer, String> romanNumbersMap = new TreeMap<>();
    private static Set<Map.Entry<Integer, String>> entrySet = romanNumbersMap.entrySet();

    public Converter(){
        //Инициализируем romanMap
        romanNumbersMap.put(100, "C");
        romanNumbersMap.put(90, "XC");
        romanNumbersMap.put(50, "L");
        romanNumbersMap.put(40, "XL");
        romanNumbersMap.put(10, "X");
        romanNumbersMap.put(9, "IX");
        romanNumbersMap.put(5, "V");
        romanNumbersMap.put(4, "IV");
        romanNumbersMap.put(1, "I");
        romanNumbersMap.put(0, "N");
    }

    public int convertToArabic(String value){
        int arabic = 0,
            last = 0,
            valueOf = 0;
        for(int i = value.length() - 1; i >= 0; i--) {
            for (Map.Entry<Integer,String> pair : entrySet) {
                //Не кидайтесь камнями за такую конструкцию, плз =)
                if (romanNumbersMap.get(pair.getKey()).equals(Character.toString(value.charAt(i)))){
                    valueOf = pair.getKey();// нашли наше значение и возвращаем  ключ
                }
            }
            //Вычисляем значение
            arabic += (last > valueOf)
                    ? -valueOf
                    : valueOf;
            last = valueOf;
        }
        return arabic;
    }
    public String convertToRoman(int value){
        String roman = value<0
                ? "-"
                : "";
        value = Math.abs(value);
        int floorKey = romanNumbersMap.floorKey(value);
        return roman += (floorKey == value)
                ? romanNumbersMap.get(value)
                : romanNumbersMap.get(floorKey) + convertToRoman(value-floorKey);
    }

}
