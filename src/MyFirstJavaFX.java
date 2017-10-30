


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MyFirstJavaFX extends Application {
	
	Label label1;
	Button button1;
	int i = 1;
	
	TextField tfNum1;
	TextField tfNum2;
	Button btnDivide;
	Button btnMultiply;
	Button btnAddition;
	Button btnSubtraction;
	Button btnClear;
	
	Label lblAnswer;
	Operation op1 = null;
	public static void main(String[] args) {
		System.out.println("Hello world!");
		launch(args);
	}
	
	private void setWidths() {
	   tfNum1.setPrefWidth(70);
	   tfNum2.setPrefWidth(70);
	   btnDivide.setPrefWidth(70);
	   btnMultiply.setPrefWidth(70);
	   btnAddition.setPrefWidth(70);
	   btnSubtraction.setPrefWidth(70);
	   btnClear.setPrefWidth(150);
	   lblAnswer.setPrefWidth(150);
	}
	 
	// sets handler
	public void attachCode() {
	   //have each button run BTNCODE when clicked
	   btnAddition.setOnAction(e -> btncode(e));
	   btnSubtraction.setOnAction(e -> btncode(e));
	   btnMultiply.setOnAction(e -> btncode(e));
	   btnDivide.setOnAction(e -> btncode(e));
	   btnClear.setOnAction(e -> btncode(e));
	}
	
	// handles all events
	public void btncode(ActionEvent e) {
		int num1, num2, answer;
		char symbol;
		
		//e tells us which button was clicked
		if (e.getSource() == btnClear) {
		   tfNum1.setText("");
		   tfNum2.setText("");
		   lblAnswer.setText("?");
		   tfNum1.requestFocus();
		   return;
		}
		//read numbers in from textfields
		num1 = Integer.parseInt(tfNum1.getText());
		num2 = Integer.parseInt(tfNum2.getText());
		
		if (e.getSource() == btnAddition) {
		   symbol = '+';
		   op1 = OperationalFactory.getOperation("Add");
		} else if (e.getSource() == btnSubtraction) {
		   symbol = '-';
		   op1 = OperationalFactory.getOperation("Subtract");
		} else if (e.getSource() == btnMultiply) {
		   symbol = '*';
		   op1 = OperationalFactory.getOperation("MULTIPLY");
		} else {
		   symbol = '/';
		   op1 = OperationalFactory.getOperation("Divide"); 
		}
		
		answer = op1.calculate(num1, num2);
		//display answer
		lblAnswer.setText("" + num1 + symbol + num2 + "=" + answer);
	}
	
	@Override 
	public void start(Stage stage) throws Exception {
		tfNum1 = new TextField();
		tfNum2 = new TextField();

		btnDivide = new Button("/");
		btnMultiply = new Button("*");
		btnAddition = new Button("+");
		btnSubtraction = new Button("-");
		btnClear = new Button("Clear");
		
		lblAnswer = new Label("Answer");
		lblAnswer.setAlignment(Pos.CENTER);
		lblAnswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		
		grid.setHgap(10);
		grid.setVgap(10);
		
		
		grid.add(btnDivide, 0,0);
		grid.add(btnMultiply, 1,0);
		grid.add(btnAddition, 0,1);
		grid.add(btnSubtraction, 1,1);
		grid.add(btnClear, 0,4, 2, 1);

		grid.add(tfNum1, 0,2);
		grid.add(tfNum2, 1,2);
		grid.add(lblAnswer, 0,3, 2, 1);

		setWidths();
		attachCode();
		
		Scene scene = new Scene(grid, 300, 400);
		stage.setScene(scene);
		stage.setTitle("My First Calculator");
		stage.show();

	}
}
