public class Abstraction{
    interface Cleaner{
        void clean();
    }

    class HouseCleaner implements Cleaner{
        @Override
	public void clean(){
	    System.out.println("Take Bucket");
	    System.out.println("Pour Water");
	    System.out.println("Put dis-infectant in water");
	}
    }

    interface Homeworkable{
        void solveProblem1();
	void solveProblem2();
	void solveProblem3();
    }

    class Studen1 implements Homeworkable{}
    class Student2 implements Homeworkable{}

    interface TalkativeFriend{
        void talkToAFriend();
    }

    class WhatssAppMessage implements TalkativeFriend{ 
        @Override
	public void talkToAFriend(){
	    System.out.println("Text him");
	}
    }
    
    class WhatsAppVideoCall implements TalkativeFriend{
        @Override
	public void talkToAFriend(){
	    System.out.println("Video call him");
	}
    }
    
    interface Visitable{
        void visit();
    }

    interface FunLife{
        void haveFun();
    }

    class Alcoholic implements FunLife{
        @Override
	public void haveFun(){
	    System.out.println("Drink until I die");
	}
    }
    
    class Nerd implements FunLife{
        @Override
	public void haveFun(){
	    System.out.println("Do some nerd stuff");
	}
    }
    
    class PlayBoyOrPlayGirl implements FunLife{
        @Override
	public void haveFun(){
	    System.out.println("Have sex with many people");
	}
    }

    private void someOperation(){
        java.util.List<String> listOfStrings = new java.util.ArrayList<>();
	listOfStrings("A");
	listOfStrings("BB");
	listOfStrings("CC");
	listOfStrings("DD");

	listOfStrings.filter( element -> element.length() > 1).collect(Collections.join(","));
	StringBuilder sb = new StringBuilder();
	for(String element : listOfStrings) {
	    if(element.length() < 2) continue;
	    sb.append(element).append(",");
	}

    }







}












