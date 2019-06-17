package com.application.argsExtraction.version2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for verify extracting Boolean and String arguments from command line
 * @author Ihor Savchenko
 */
public class ArgsBooleanStringTest {

    @Test
    public void testCardinality() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-ab", "-g", "fuckup", "-e", "lucky"});
        assertEquals(5, arg.cardinality());
    }

    @Test
    public void testUsage() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-ab", "-g", "fuckup", "-e", "lucky"});
        assertEquals("-[a.b.c.g*.e*]", arg.usage());
    }

    @Test(expected = Exception.class)
    public void testErrorMessageIfOK() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-ab", "-g", "fuckup", "-e", "lucky"});
        arg.errorMessage();
    }

    @Test
    public void testErrorMessageIfMISSING_STRING() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-ab", "-g", "fuckup", "-e"});
        assertEquals("Could not find string parameter for -e.", arg.errorMessage());
    }

    @Test
    public void testErrorMessageIfUnexpectedArguments() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-abd", "-h", "fuckup", "-e", "lucky"});
        assertEquals("Argument(s) - dh unexpected.", arg.errorMessage());
    }

    @Test
    public void testGetBoolean() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-ab", "-g", "fuckup", "-e", "lucky"});
        assertTrue(arg.getBoolean('a'));
        assertTrue(arg.getBoolean('b'));
        assertFalse(arg.getBoolean('c'));
    }

    @Test
    public void testGetString() throws Exception {
        Args arg = new Args("a.b.c.g*.e*.s*", new String[]{"-ab", "-g", "fuckup", "-e", "lucky"});
        assertEquals("fuckup", arg.getString('g'));
        assertEquals("lucky", arg.getString('e'));
        assertEquals("", arg.getString('s'));
    }

    @Test
    public void testGetNumberOfUniqueBooleanArguments() throws Exception {
        Args arg = new Args("a.b.c.g*.e*.s*", new String[]{"-abc", "ab", "-g", "fuckup", "-e", "lucky"});
        assertEquals(3, arg.getNumberOfUniqueBooleanArguments());
    }

    @Test
    public void testGetNumberOfUniqueStringArguments() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "ab", "-g", "fuckup", "-e", "lucky"});
        assertEquals(2, arg.getNumberOfUniqueStringArguments());
        arg = new Args("a.b.c.g*.e*.s*", new String[]{"-abc", "ab", "-g", "fuckup", "-e", "lucky"});
        assertEquals(3, arg.getNumberOfUniqueStringArguments());
    }

    @Test
    public void testHas() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "ab", "-g", "fuckup", "-e", "lucky"});
        assertTrue(arg.has('a'));
        assertTrue(arg.has('b'));
        assertTrue(arg.has('c'));
        assertTrue(arg.has('g'));
        assertTrue(arg.has('e'));
        arg = new Args("a.b.c.g*.e*", new String[]{"-ab", "ab", "-g", "fuckup", "-e", "lucky"});
        assertFalse(arg.has('c'));
        arg = new Args("a.b.c.g*.e*.s*", new String[]{"-abc", "ab", "-g", "fuckup", "-e", "lucky"});
        assertFalse(arg.has('s'));

    }

    @Test
    public void testIsValid() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-ab", "-g", "fuckup", "-e", "lucky"});
        assertTrue(arg.isValid());
    }

    @Test
    public void testIsNotValid() throws Exception {
        Args arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-abdf", "-g", "fuckup", "-e", "lucky"});
        assertFalse(arg.isValid());
        arg = new Args("a.b.c.g*.e*", new String[]{"-abc", "-ab", "-h", "fuckup", "-e", "lucky"});
        assertFalse(arg.isValid());
    }
}