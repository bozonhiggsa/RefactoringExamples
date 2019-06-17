package com.application.argsExtraction.version3;

import java.util.Iterator;

public interface ArgumentMarshaler {

    void set(Iterator<String> currentArgument) throws ArgsException;
}
