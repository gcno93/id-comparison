package org.leon.output;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleStringOutPutTemplate implements OutputTemplate<String, Pair<Set<String>,Set<String>>>{

    @Override
    public String output(Pair<Set<String>, Set<String>> result) {
        List<String> sourceRes = new ArrayList<>();
        List<String> targetRes = new ArrayList<>();
        Set<String> sourceSet = result.getKey();
        Set<String> targetSet = result.getValue();
        for (String s : sourceSet) {
            sourceRes.add(String.format("'%s'", s));
        }
        for (String t : targetSet) {
            targetRes.add(String.format("'%s'", t));
        }
        return String.format("source: %s\r\ntarget: %s",StrUtil.join(",",sourceRes),StrUtil.join(",",targetRes));
    }
}
