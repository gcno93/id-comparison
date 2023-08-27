package org.leon;

import cn.hutool.core.io.file.FileReader;
import org.leon.handle.AbstractComparisonHandle;
import org.leon.handle.file.LineFileComparisonHandle;
import org.leon.input.file.linefile.ExcludeInputTemplate;
import org.leon.input.file.linefile.SourceInputTemplate;
import org.leon.input.file.linefile.TargetInputTemplate;
import org.leon.output.SimpleStringOutPutTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        String out = new LineFileComparisonHandle()
                .source(new SourceInputTemplate())
                .target(new TargetInputTemplate())
                .exclude(new ExcludeInputTemplate())
                .output(new SimpleStringOutPutTemplate()).handle();
        System.out.println(out);

    }


    public static List<String> getIdsByFile(String path){
        FileReader fileReader = new FileReader(path);
        return fileReader.readLines();
    }
}
