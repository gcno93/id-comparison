package org.leon.handle.file;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Sets;
import lombok.*;
import org.leon.handle.AbstractComparisonHandle;

import java.util.*;

public class LineFileComparisonHandle extends AbstractComparisonHandle<List<String>,List<String>,List<String>,Pair<Set<String>,Set<String>>,String> {
    @Override
    protected Pair<Set<String>,Set<String>> exec(List<String> source, List<String> target, List<String> exclude) {
        if(ObjectUtil.isEmpty(source)){
            source = new ArrayList<>();
        }
        if(ObjectUtil.isEmpty(target)){
            target =new ArrayList<>();
        }
        if(ObjectUtil.isEmpty(exclude)){
            exclude =new ArrayList<>();
        }
        Set<String> sourceSet = Sets.newHashSet(source);
        Set<String> targetSet = Sets.newHashSet(target);
        Set<String> excludeSet = Sets.newHashSet(exclude);
        //存在source，不在target的元素
        Set<String> sourceDifference = Sets.difference(sourceSet, targetSet);
        //存在target，不在source的元素
        Set<String> targetDifference = Sets.difference(targetSet, sourceSet);
        //过滤掉排除的
        for (String e : excludeSet) {
            sourceDifference.remove(e);
            targetDifference.remove(e);
        }

        return Pair.of(sourceDifference,targetDifference);
    }

}
