package org.leon;

import cn.hutool.core.io.file.FileReader;
import org.leon.handle.file.LineFileComparisonHandle;
import org.leon.input.file.FileLineInputTemplate;
import org.leon.output.SimpleStringOutPutTemplate;
import org.leon.parser.FileLineParser;
import org.leon.parser.Parser;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        String out =  new LineFileComparisonHandle()
                .source(new FileLineInputTemplate().parser(new FileLineParser("file/source.txt")))
                .target(new FileLineInputTemplate().parser(new FileLineParser("file/target.txt")))
                .exclude(new FileLineInputTemplate().parser(new FileLineParser("file/exclude.txt")))
                .output(new SimpleStringOutPutTemplate().isEnter(true).containTag("\""))
                .handle();
        System.out.println(out);

    }


    public static List<String> getIdsByFile(String path){
        FileReader fileReader = new FileReader(path);
        return fileReader.readLines();
    }
}
