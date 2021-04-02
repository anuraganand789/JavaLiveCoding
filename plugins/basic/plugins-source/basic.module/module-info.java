module basic.module{
    requires jdk.compiler;
    provides com.sun.source.util.Plugin with test.BasicPlugin;
}
