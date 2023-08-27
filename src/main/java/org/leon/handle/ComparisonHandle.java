package org.leon.handle;

import org.leon.input.InputTemplate;
import org.leon.output.OutputTemplate;

public interface ComparisonHandle<S,T,E,R,O> {
    O handle();
}
