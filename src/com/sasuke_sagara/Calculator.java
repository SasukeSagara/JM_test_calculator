package com.sasuke_sagara;

import javax.lang.model.type.NullType;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Calculator {

    public String calculate(Expression expression) throws MyExcept {
        String[] arguments = expression.getArguments();
        Converter converter = new Converter();
        boolean isRoman = Character.isLetter(expression.getArguments()[0].charAt(0));
        int result = 0;
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
        //        return isRoman
//                ? converter.convertToRoman(result)
//                : Integer.toString(result);
    }




}
