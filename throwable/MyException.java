public class MyException extends Throwable {
    
    public MyException(){ }
    public MyException(final String message) {
        super(message);
    }

    public MyException(final String message, final Throwable cause){
        super(message, cause);
    }

    @Override
    public String toString(){
        return getMessage() == null || getMessage().isEmpty() ? "MyException has occurred, but nothing to worry about" : getMessage();
    }
}
