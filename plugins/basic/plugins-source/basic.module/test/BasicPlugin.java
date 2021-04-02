package test;

import com.sun.source.util.Plugin;
import com.sun.source.util.JavacTask;

public class BasicPlugin implements Plugin{
    
    @Override
    public String getName() {
        return "basic";
    }

    @Override
    public void init(final JavacTask javacTask, final String... arguments){
        System.out.println("Basic Plugin Called");
    }
}
