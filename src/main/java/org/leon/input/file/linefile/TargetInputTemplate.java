package org.leon.input.file.linefile;

import org.leon.input.InputTemplate;
import org.leon.util.FileUtils;

import java.util.List;

public class TargetInputTemplate implements InputTemplate<List<String>> {

    private final  static String SOURCE_FILE_PATH = "file/target.txt";
    @Override
    public List<String> input() {
        return FileUtils.getIdsByFileLines(SOURCE_FILE_PATH);
    }
}
