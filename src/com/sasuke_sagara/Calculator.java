package com.sasuke_sagara;

public class Calculator {

    public String calculate(Expression expression){
        String[] arguments = expression.getArguments();
        Converter converter = new Converter();
        boolean isRoman = Character.isLetter(expression.getArguments()[0].charAt(0));
        int result;
        if (isRoman){
            result = expression.operation.execute(
                    converter.convertToArabic(arguments[0]),
                    converter.convertToArabic(arguments[1])
            );
            return converter.convertToRoman(result);
        } else{
            result = expression.operation.execute(
                    Integer.parseInt(arguments[0]),
                    Integer.parseInt(arguments[1])
            );
            return Integer.toString(result);
        }
    }




}
