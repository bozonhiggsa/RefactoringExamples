package com.application.argsExtraction.version2;

/**
 * Entry point for extracting Boolean and String arguments from command line.
 * Pattern in command line: -abc -g miracle -e lucky
 * @author Ihor Savchenko
 */
public class Main2 {

    public static void main(String[] args) throws Exception {
        Args arg = new Args("a.b.c.g*.e*", args);
        System.out.println(arg.usage());
        System.out.println(arg.cardinality());
        System.out.println(arg.getBoolean('a'));
        System.out.println(arg.getBoolean('b'));
        System.out.println(arg.getBoolean('c'));
        System.out.println(arg.getString('g'));
        System.out.println(arg.getString('e'));
        System.out.println(arg.isValid());
        System.out.println(arg.getNumberOfUniqueBooleanArguments());
        System.out.println(arg.getNumberOfUniqueStringArguments());
    }
}
