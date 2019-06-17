package com.application.argsExtraction.version3;

/**
 * Entry point for extracting Boolean, String, int, double, String[] arguments from command line.
 * Pattern in command line: -abc -g miracle -e lucky -x 192
 * @author Ihor Savchenko
 */
public class Main3 {

    public static void main(String[] args) throws ArgsException {
        Args arg = new Args("a.b.c.g*.e*.x#", args);
        System.out.println(arg.getBoolean('a'));
        System.out.println(arg.getBoolean('b'));
        System.out.println(arg.getBoolean('c'));
        System.out.println(arg.getString('g'));
        System.out.println(arg.getString('e'));
        System.out.println(arg.getInt('x'));
    }
}
