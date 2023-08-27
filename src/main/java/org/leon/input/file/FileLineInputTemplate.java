package org.leon.input.file;

import org.leon.input.InputTemplate;
import org.leon.parser.Parser;

public class FileLineInputTemplate<R> implements InputTemplate<R> {
    private Parser<R> parser;
    @Override
    public R input() {
        return parser.parser();
    }

    public FileLineInputTemplate<R>   parser(Parser<R> parser){
        this.parser = parser;
        return this;
    }

}
