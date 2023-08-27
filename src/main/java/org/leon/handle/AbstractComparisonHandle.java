package org.leon.handle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.leon.handle.ComparisonHandle;
import org.leon.input.InputTemplate;
import org.leon.output.OutputTemplate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractComparisonHandle<S,T,E,R,O> implements ComparisonHandle<S,T,E,R,O> {

    protected  InputTemplate<S> source;

    protected InputTemplate<T> target;

    protected InputTemplate<E> exclude;

    protected OutputTemplate<O,R> output;

    @Override
    public O handle() {
        S sourceList = source.input();
        T targetList = target.input();
        E  excludeList = exclude.input();
        return output.output(exec(sourceList,targetList,excludeList));
    }

    protected abstract R exec(S s,T t, E e);

    protected AbstractComparisonHandle<S,T,E,R,O> source(InputTemplate<S> s){
        this.source = s;
        return this;
    }

    protected AbstractComparisonHandle<S,T,E,R,O> target(InputTemplate<T> t){
        this.target = t;
        return this;
    }

    protected AbstractComparisonHandle<S,T,E,R,O> exclude(InputTemplate<E> e){
        this.exclude = e;
        return this;
    }

    protected AbstractComparisonHandle<S,T,E,R,O> output(OutputTemplate<O,R> o){
        this.output =o;
        return this;
    }

}
