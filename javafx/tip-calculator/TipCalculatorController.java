import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import java.text.NumberFormat;

public class TipCalculatorController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="amountTextField"
    private TextField amountTextField; // Value injected by FXMLLoader

    @FXML // fx:id="tipAmoutTextField"
    private TextField tipAmountTextField; // Value injected by FXMLLoader

    @FXML // fx:id="totalAmountTextField"
    private TextField totalAmountTextField; // Value injected by FXMLLoader

    @FXML // fx:id="calculateButton"
    private Button calculateButton; // Value injected by FXMLLoader

    @FXML // fx:id="tipSlider"
    private Slider tipSlider; // Value injected by FXMLLoader

    @FXML
    private Label tipSliderLabel;

    private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    private static NumberFormat percentFormatter  = NumberFormat.getPercentInstance();

    @FXML
    void calculateTipAndTotalAmount(ActionEvent event) {
       try{
           String amountEnteredByTheUser = amountTextField.getText(); 
           if(amountEnteredByTheUser != null && !amountEnteredByTheUser.isEmpty()){
               double tipValue       = tipSlider.getValue() / 100.0;
               double amountInDouble = Double.valueOf(amountEnteredByTheUser);
               double tipAmount      = amountInDouble * tipValue;
               double totalAmount    = amountInDouble + tipAmount;
                
               tipAmountTextField.setText(currencyFormatter.format(tipAmount));
               totalAmountTextField.setText(currencyFormatter.format(totalAmount));
           }
       }catch(NumberFormatException exc){
           amountTextField.setText("");
           tipAmountTextField.setText("");
           totalAmountTextField.setText("");

	   amountTextField.requestFocus();
       }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert amountTextField != null : "fx:id=\"amountTextField\" was not injected: check your FXML file 'TipCalculatorView.fxml'.";
        assert tipAmountTextField != null : "fx:id=\"tipAmoutTextField\" was not injected: check your FXML file 'TipCalculatorView.fxml'.";
        assert totalAmountTextField != null : "fx:id=\"totalAmountTextField\" was not injected: check your FXML file 'TipCalculatorView.fxml'.";
        assert calculateButton != null : "fx:id=\"calculateButton\" was not injected: check your FXML file 'TipCalculatorView.fxml'.";
        assert tipSlider != null : "fx:id=\"tipSlider\" was not injected: check your FXML file 'TipCalculatorView.fxml'.";
        assert tipSliderLabel != null : "fx:id=\"tipSliderLabel\" was not injected: check your FXML file 'TipCalculatorView.fxml'.";

        tipSlider
	.valueProperty()
	.addListener(
            new ChangeListener<Number>(){
	        @Override 
	        public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue){
	            tipSliderLabel.setText(percentFormatter.format(newValue.doubleValue() / 100.0));
	        }
	    }
	 );
    }
}
