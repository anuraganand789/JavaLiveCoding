public class PrintName{
    static{
        System.loadLibrary("name");
    }
    //the function is defined in a c-file
    private static native void printName(final String name);

    public static void main(final String ... args){
        printName("Anurag Anand");
    }
}
