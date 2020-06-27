public class TestMyException{
    public static void main(String... args) {
         try{
	     new TestMyException().throwException();
	 }catch(Throwable thrown){
	     if(thrown instanceof MyException) System.out.println("This is caused by my custom class for Exception");
	     thrown.printStackTrace();
	 }
    }

    private void throwException() throws MyException{
        final MyException myExCause = new MyException("I am the one which caused an exception during live coding");
	final MyException myEx = new MyException("Exception happened, because I am doing live coding", myExCause);
	throw myEx;
    }
}

