package com.sasuke_sagara;

import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String description = "Создайте консольное приложение “Калькулятор”." +
            "\nПриложение должно читать из консоли введенные пользователем арифметические" +
            " операции и выводить в консоль результат их выполнения.",
            requirements = "1.\tКалькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.\n" +
                    "Данные передаются в одну строку (смотрите пример)! Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.\n" +
                    "2.\tКалькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.\n" +
                    "3.\tКалькулятор должен принимать на вход числа от 1 до 10 включительно, не более.\nНа выходе числа не ограничиваются по величине и могут быть любыми.\n" +
                    "4.\tКалькулятор умеет работать только с целыми числами.\n" +
                    "5.\tКалькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.\n" +
                    "6.\tПри вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.\n" +
                    "7.\tПри вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.\n";

    public static void main(String[] args) throws MyExcept {
        if (args.length != 0) {
            for (String arg: args) {
                if (arg.equals("/help")) System.out.println(
                        "Задача: “Калькулятор”\n"+
                        "Описание: \n"+
                        description+
                        "Требования: \n"+
                        requirements);
            }
        }
        Scanner in = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true){
            System.out.print("Введите выражение: ");
            String input = in.nextLine();
            String result = calculator.calculate(new Expression(input));
            System.out.println(String.format("%s = %s", input, result));
        }
    }

}