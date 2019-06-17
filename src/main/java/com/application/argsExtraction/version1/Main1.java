package com.application.argsExtraction.version1;

/**
 * Entry point for extracting Boolean arguments from command line.
 * Pattern in command line: -abc -abdfes
 * @author Ihor Savchenko
 */
public class Main1 {

    public static void main(String[] args) {
        Args arg = new Args("a.b.c", args);
        System.out.println(arg.usage());
        System.out.println(arg.cardinality());
        System.out.println(arg.getBoolean('a'));
        System.out.println(arg.getBoolean('b'));
        System.out.println(arg.getBoolean('c'));
        System.out.println(arg.errorMessage());
    }
}
