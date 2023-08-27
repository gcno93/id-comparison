package org.leon.output;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimpleStringOutPutTemplate implements OutputTemplate<String, Pair<Set<String>,Set<String>>>{

    private boolean isEnter = false;
    private String containTag = "'";

    private String splitTag = ",";

    @Override
    public String output(Pair<Set<String>, Set<String>> result) {
        List<String> sourceRes = new ArrayList<>();
        List<String> targetRes = new ArrayList<>();
        Set<String> sourceSet = result.getKey();
        Set<String> targetSet = result.getValue();
        int sourceSetIndex = 0;
        for (String s : sourceSet) {
            sourceSetIndex++;
            sourceRes.add(String.format(isEnter?"%s%s%s%s\r\n":"%s%s%s%s", containTag,s,containTag,sourceSetIndex==sourceSet.size()?"":splitTag));
        }
        int targetSetIndex = 0;
        for (String t : targetSet) {
            targetSetIndex++;
            targetRes.add(String.format(isEnter?"%s%s%s%s\r\n":"%s%s%s%s", containTag,t,containTag,targetSetIndex==targetSet.size()?"":splitTag));
        }
        if(isEnter){
            return String.format("source: \r\n--count: %s\r\n--data:\r\n%s\r\n target: \r\n--count: %s\r\n--data: \r\n",sourceRes.size(),StrUtil.join("",sourceRes),targetRes.size(),StrUtil.join("",targetRes));
        }else {
            return String.format("source: %s\r\n--count: %s\r\ntarget: %s\r\n--count: %s",StrUtil.join("",sourceRes),sourceRes.size(),StrUtil.join("",targetRes),targetRes.size());
        }

    }

    public SimpleStringOutPutTemplate isEnter(boolean isEnter){
        this.isEnter = isEnter;
        return this;
    }

    public SimpleStringOutPutTemplate containTag(String containTag){
        this.containTag = containTag;
        return this;
    }

    public SimpleStringOutPutTemplate splitTag(String splitTag){
        this.splitTag = splitTag;
        return this;
    }

}
