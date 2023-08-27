package org.leon.output;

public interface OutputTemplate<T,I> {
    T output(I result);
}
