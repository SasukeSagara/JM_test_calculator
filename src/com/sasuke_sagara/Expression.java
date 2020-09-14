package com.sasuke_sagara;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private static final String[] regExs = new String[]{
            "(\\b((V?I{0,3})|(I?[VX]{0,1}))\\b)",   // Romans       (I II III IV V VI VII VIII IX X)
            "\\b(10|[0-9])\\b",                     // Arabic       (1 2 3 4 5 6 7 8 9 10)
            "([+|\\-|*|/])"                         // Operations   (+ - * /)
    };
    private String[] arguments;
    Operation operation;
    private String value;

    public Expression(String expression) throws MyExcept {
        if (this.validate(expression)){
            this.value = expression;
            this.setArguments();
            this.setOperation();
        } else throw new MyExcept("Введено недопустимое выражение.");
    }

    private boolean validate(String input){
        String regEx = String.join("\\s*", "^", regExs[0], regExs[2], regExs[0], "$",
                "|^", regExs[1], regExs[2], regExs[1], "$");
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private void setArguments(){
        String[] result = this.value.split(regExs[2]);
        for (int i = 0; i<result.length; i++)
            result[i] = result[i].trim();
        this.arguments=result;
    }

    public String[] getArguments(){return this.arguments;}

    private void setOperation(){
        for (char symb: this.value.toCharArray()) {
            for (Operation operation : Operation.values()){
                if (String.valueOf(symb).equals(operation.getValue())) {
                    this.operation = operation;
                    break;
                }
            }
        }
    }

    public Operation getOperation(){ return this.operation;}
}
