package org.leon;

import cn.hutool.core.io.file.FileReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        List<String> sourceList = getIdsByFile("source.txt");
        List<String> targetList = getIdsByFile("target.txt");
        List<String> resultList = new ArrayList<>();
        for (String s : sourceList) {
            if(!targetList.contains(s)){
                resultList.add(s);
            }
        }
        for (String s : resultList) {
            System.out.println(s);
        }

    }


    public static List<String> getIdsByFile(String path){
        FileReader fileReader = new FileReader(path);
        return fileReader.readLines();
    }
}
