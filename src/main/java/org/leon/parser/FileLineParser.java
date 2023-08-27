package org.leon.parser;

import lombok.AllArgsConstructor;
import org.leon.util.FileUtils;

import java.util.List;

@AllArgsConstructor
public class FileLineParser implements Parser<List<String>> {

    private String path;
    @Override
    public List<String> parser() {
        return FileUtils.getIdsByFileLines(path);
    }
    public FileLineParser path(String path){
        this.path = path;
        return this;
    }

}
