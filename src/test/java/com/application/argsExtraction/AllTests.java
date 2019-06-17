package com.application.argsExtraction;

import com.application.argsExtraction.version1.ArgsBooleanTest;
import com.application.argsExtraction.version2.ArgsBooleanStringTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArgsBooleanTest.class, ArgsBooleanStringTest.class})
public class AllTests {
}
