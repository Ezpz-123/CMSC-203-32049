package packages;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button button1,button2,button3,button4,button5;
	Label label1;
	TextField textfield;
	HBox hb1,hb2;
	VBox vb1; 
	
	//student Task #4:
	//  declare an instance of DataManager
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		label1 = new Label("Feedback:");
		textfield = new TextField();
		hb1 = new HBox(label1,textfield);
		hb2 = new HBox(button1,button2,button3,button4,button5);
		vb1 = new VBox(hb1,hb2);		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		DataManager data = new DataManager();
		
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
		hb1.getChildren().addAll(label1,textfield);
		hb2.getChildren().addAll(button1,button2,button3,button4,button5);
		vb1.getChildren().addAll(hb1,hb2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent> {
		
		DataManager data = new DataManager();
		
		@Override
		public void handle(ActionEvent event) {
			button1.setOnAction(new ButtonHandler());
			button2.setOnAction(new ButtonHandler());
			button3.setOnAction(new ButtonHandler());
			button4.setOnAction(new ButtonHandler());
			button5.setOnAction(new ButtonHandler());
			
			if(button1 == event.getTarget()) {
				data.getHello();
			}
			
			if(button2 == event.getTarget()) {
				data.getHowdy();
			}
			
			if(button3 == event.getTarget()) {
				data.getChinese();
			}
			
		}
		
	}
}
	