package gui;

import game.*;
import characters.*;
import javafx.application.*;
import javafx.concurrent.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.stage.*;
//import javafx.event.*;
import java.io.*;
import java.util.*;

public class ClashWindow extends Stage {
	private Button createWarriorsButton = new Button("Create Warriors");
	private Button initClashButton = new Button("Initiialize Clash");
	private Button nextClashButton = new Button("Next Clash");
	private Button clashButton = new Button("Full Clash");
	private Button saveButton = new Button("Save");
	private Button loadButton = new Button("Load");
	private Button countButton = new Button("Count");
	private TextField knights = new TextField();
	private TextField braveKnights = new TextField();
	private TextField badOgres = new TextField();
	private TextField warriorType = new TextField();
	private Label knightsLabel = new Label("Knights");
	private Label braveKnightsLabel = new Label("Brave knights");
	private Label badOgresLabel = new Label("Bad ogres");
	private Label warriorTypeLabel = new Label("Warrior type");
	private TextArea output = new TextArea();
	private ScrollPane scroll = new ScrollPane();
	
	public ClashWindow() {
		super();
		
		setTitle("Clash");
		
		FlowPane pane = new FlowPane();
		
		Game game = new Game();
		
		pane.getChildren().add(createWarriorsButton);
		pane.getChildren().add(initClashButton);
		pane.getChildren().add(nextClashButton);
		pane.getChildren().add(clashButton);
		pane.getChildren().add(saveButton);
		pane.getChildren().add(loadButton);
		pane.getChildren().add(countButton);
		pane.getChildren().add(knights);
		pane.getChildren().add(knightsLabel);
		pane.getChildren().add(braveKnights);
		pane.getChildren().add(braveKnightsLabel);
		pane.getChildren().add(badOgres);
		pane.getChildren().add(badOgresLabel);
		pane.getChildren().add(output);
		pane.getChildren().add(warriorType);
		pane.getChildren().add(warriorTypeLabel);
		
		scroll.setContent(pane);		
		
		createWarriorsButton.setOnAction(e -> {
			try {
				game.createWarriors(Integer.parseInt(knights.getText()),
						Integer.parseInt(braveKnights.getText()),
						Integer.parseInt(badOgres.getText()),
						new AlternateSwordsGameSetup());
				output.clear();
				output.appendText("Warriors created.\n");
			} catch (UnevenNumberOfWarriorsException ex) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setContentText("The count of bad ogres cannot be greater than the overall count of knights.");
				a.showAndWait();
			}
		});

		initClashButton.setOnAction(e -> {
			output.appendText("\n" + "Ready for the next clash.\n\n");
			game.initClash();
		});
		
		nextClashButton.setOnAction(e -> {
 			try {
 				output.appendText(game.nextClash1on1());
 			} catch (NoSuchElementException ex) {
				Alert a = new Alert(AlertType.ERROR);
				a.setTitle("Error");
				a.setContentText("There is no next pair of warriors.");
				a.showAndWait(); 					 				
 			}
 		});

 		clashButton.setOnAction(e -> {
		    Task<String> t = new Task<String>() {
 				protected String call() {
 					return game.clash();
 				}
 				protected void succeeded() {
 					Platform.runLater(() -> output.appendText(getValue()));
 				}
 			};
 

 			t.exceptionProperty().addListener((observable, oldValue, newValue) ->  {
 				if(newValue != null) {
 					Exception ex = (Exception) newValue;
 	 				if (ex instanceof NullPointerException) {
 	 					Alert a = new Alert(AlertType.ERROR);
 	 					a.setTitle("Error");
 	 					a.setContentText("The warriors have not been initialized.");
 	 					a.showAndWait();
 	 				}
 				}
 			});
			
 			Thread th = new Thread(t);

 			th.setDaemon(true);
 			th.start();
 		});
 		
  		saveButton.setOnAction(e -> {
			try {
				game.save();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
 		
 		loadButton.setOnAction(e -> {
			try {
				game.load();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

 		countButton.setOnAction(e -> { 			
 			switch (warriorType.getText()) {
 				case ("k") : output.appendText("Knights: " + game.countWarriors(Knight.class) + "\n");
 				break;
 				case ("bk") : output.appendText("Brave knights: " + game.countWarriors(BraveKnight.class) + "\n");
 				break;
 				case ("o") : output.appendText("Ogres: " + game.countWarriors(Ogre.class) + "\n");
 				break;
 				case ("bo") : output.appendText("Bad ogres: " + game.countWarriors(BadOgre.class) + "\n");
 				break; 			
 			}
		});
	
		setScene(new Scene(scroll, 500, 300));
		show();
	}
}