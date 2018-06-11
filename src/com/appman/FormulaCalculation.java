package com.appman;
import jdk.internal.org.objectweb.asm.tree.analysis.Interpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.text.NumberFormat;
import java.text.ParseException;

public class FormulaCalculation {
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    public Object getResult(String input) throws Exception {
        try {
            if(input.matches(".*[a-zA-Z;~`#$_{}\\[\\]:\\\\;\"',\\?]+.*")) {
                throw new Exception("Invalid expression : " + input );
            }
            return engine.eval(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println((new FormulaCalculation()).getResult("(22*2) + 50"));
            System.out.println((new FormulaCalculation()).getResult("((2*3+12) / 2)"));
            System.out.println((new FormulaCalculation()).getResult("(10-5+3/2*2)"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
