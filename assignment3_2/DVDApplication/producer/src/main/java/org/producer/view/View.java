package org.producer.view;



import java.io.IOException;

import org.commons.serialize.SerializeUtils;
import org.model.DVD;
import org.producer.Send;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class View extends Application {

	private static final String HOST = "localhost";
	private static final int PORT = 8888;
	private Button btn;

	private GridPane grid;

	private DVD dvd;
	
	private Send send=new Send();
	private SerializeUtils serializeUtility=new SerializeUtils();

	@Override
	public void start(Stage primaryStage) {
		
		btn = new Button();
		btn.setText("Submit DVD");

		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(30);
		grid.setVgap(30);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label title = new Label("Title:");
		grid.add(title, 0, 1);
		final TextField titleTextField = new TextField();
		grid.add(titleTextField, 1, 1);
		Label year = new Label("Year:");
		grid.add(year, 0, 2);
		final TextField yearTextField = new TextField();
		grid.add(yearTextField, 1, 2);
		Label price = new Label("Price:");
		grid.add(price, 0, 3);
		final TextField priceTextField = new TextField();
		grid.add(priceTextField, 1, 3);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				String yearString = yearTextField.getText();
				String titleString = titleTextField.getText();
				String priceString = priceTextField.getText();
				dvd = makeDVD(titleString, yearString, priceString);
				try {
					String message=serializeUtility.serialize(dvd);
					send.send( message);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		grid.add(btn, 3, 1);
		//grid.setStyle("-fx-background-image: url('dvd.jpg');");
		grid.setStyle("-fx-background-color: #CED8F6;");
		Scene scene = new Scene(grid, 600, 375);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("DVD Insertion!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void getStarted() {
		launch(null);
	}

	private DVD makeDVD(String title, String year, String price) {
		DVD dvdReturned;
		try {
			int yearInt = Integer.parseInt(year);
			double priceFloat = Float.parseFloat(price);
			dvdReturned = new DVD(0, title, yearInt, priceFloat);
		} catch (Exception e) {
			dvdReturned = null;
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Something went wrong");
			alert.setContentText("Check the data introduced: year must be an integer, price a double");
			alert.showAndWait();

		}
		return dvdReturned;
	}

}
