package org.leon.input.file.linefile;

import org.leon.input.InputTemplate;
import org.leon.util.FileUtils;

import java.util.List;

public class ExcludeInputTemplate implements InputTemplate<List<String>> {

    private final  static String SOURCE_FILE_PATH = "file/exclude.txt";
    @Override
    public List<String> input() {
        return FileUtils.getIdsByFileLines(SOURCE_FILE_PATH);
    }
}
