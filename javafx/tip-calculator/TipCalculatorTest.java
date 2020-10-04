import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class TipCalculatorTest extends Application{

    @Override
    public void start(final Stage stage) throws Exception{
       final String fxmlFileLocation = "file:///home/anuraganand/streams/java-streams/jcode/javafx/tip-calculator/TipCalculatorView.fxml"; 
       final Parent calculatorApp = FXMLLoader.load(new URL(fxmlFileLocation));

       stage.setTitle("Tip Calculator");
       stage.setScene(new Scene(calculatorApp));
       stage.show();
    }
    
    public static void main(final String... args){
        launch(args);
    }
}
