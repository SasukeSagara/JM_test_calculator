package com.sasuke_sagara;

public enum Operation {
    Addition("+"){
        public int execute(int arg1, int arg2){return arg1 + arg2;}
    },
    Substraction("-") {
        public int execute(int arg1, int arg2){return arg1 - arg2;}
    },
    Multiplication("*"){
        public int execute(int arg1, int arg2){return arg1 * arg2;}
    },
    Division("/"){
        public int execute(int arg1, int arg2){return arg1 / arg2;}
    };

    Operation(String value) {
        this.value = value;
    }
    private String value;
    public String getValue(){return this.value;}
    public abstract int execute(int arg1, int arg2);

}
