package org.leon.handle.file;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Sets;
import org.leon.handle.AbstractComparisonHandle;
import org.leon.input.InputTemplate;
import org.leon.output.OutputTemplate;

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
        Set<String> sourceDifference = Sets.newHashSet(Sets.difference(sourceSet, targetSet));
        //存在target，不在source的元素
        Set<String> targetDifference = Sets.newHashSet(Sets.difference(targetSet, sourceSet));
        //过滤掉排除的
        for (String e : excludeSet) {
            sourceDifference.remove(e);
            targetDifference.remove(e);
        }

        return Pair.of(sourceDifference,targetDifference);
    }

    @Override
    public LineFileComparisonHandle source(InputTemplate<List<String>> s) {
        super.source(s);
        return this;
    }

    @Override
    public LineFileComparisonHandle target(InputTemplate<List<String>> t) {
        super.target(t);
        return this;
    }

    @Override
    public LineFileComparisonHandle exclude(InputTemplate<List<String>> e) {
        super.exclude(e);
        return this;
    }

    @Override
    public LineFileComparisonHandle output(OutputTemplate<String, Pair<Set<String>, Set<String>>> o) {
        super.output(o);
        return this;
    }
}
