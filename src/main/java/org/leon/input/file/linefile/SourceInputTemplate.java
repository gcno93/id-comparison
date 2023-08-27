package org.leon.input.file.linefile;

import org.leon.input.InputTemplate;
import org.leon.util.FileUtils;

import java.util.List;

public class SourceInputTemplate implements InputTemplate<List<String>> {

    private final  static String SOURCE_FILE_PATH = "file/source.txt";
    @Override
    public List<String> input() {
        return FileUtils.getIdsByFileLines(SOURCE_FILE_PATH);
    }
}
