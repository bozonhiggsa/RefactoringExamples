package com.application.argsExtraction.version1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for verify extracting Boolean arguments from command line
 * @author Ihor Savchenko
 */
public class ArgsBooleanTest {

    @Test
    public void testIsValid() throws Exception {
        Args arg = new Args("a.b.c", new String[]{"-abc", "-ab"});
        assertTrue(arg.isValid());
    }

    @Test
    public void testIsNotValid() throws Exception {
        Args arg = new Args("a.b.c", new String[]{"-abc", "-abdf"});
        assertFalse(arg.isValid());
    }

    @Test
    public void testCardinality() throws Exception {
        Args arg = new Args("a.b.c", new String[]{"-abc", "-abdf"});
        assertEquals(5, arg.cardinality());
    }

    @Test
    public void testUsage() throws Exception {
        Args arg = new Args("a.b.c", new String[]{"-abc", "-abdf"});
        assertEquals("-[a.b.c]", arg.usage());
    }

    @Test
    public void testErrorMessage() throws Exception {
        Args arg = new Args("a.b.c", new String[]{"-abc", "-abdf"});
        assertEquals("Argument(s) - df unexpected.", arg.errorMessage());
    }

    @Test
    public void testGetBoolean() throws Exception {
        Args arg = new Args("a.b.c", new String[]{"-ab", "-bdf"});
        assertTrue(arg.getBoolean('a'));
        assertTrue(arg.getBoolean('b'));
        assertFalse(arg.getBoolean('c'));
    }

    @Test
    public void testGetNumberOfUniqueBooleanArguments() throws Exception {
        Args arg = new Args("a.b.c", new String[]{"-abc", "-abdf"});
        assertEquals(3, arg.getNumberOfUniqueBooleanArguments());
    }
}