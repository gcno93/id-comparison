package org.leon.util;

import cn.hutool.core.io.file.FileReader;

import java.util.List;

public final class FileUtils {

    private FileUtils(){

    }

    /**
     *  读取每一行是id的文件
     * @param path resources目录下的文件,比如file/source.txt
     * @return
     */
    public static List<String> getIdsByFileLines(String path){
        FileReader fileReader = new FileReader(path);
        return fileReader.readLines();
    }
}
