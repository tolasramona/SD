package utcluj.ac.ro.view;

import java.util.List;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import utcluj.ac.ro.view.controllers.ClientViewController;
import ws.PackageToSend;

@SuppressWarnings({ "restriction", "rawtypes" })
public class ClientViewSceneMaker extends SceneMaker {

	private Label helloMessage;
	private Text usernameText;
	private Text routesText;
	private Label searchPackageLabel;
	private Button listButton;
	private Button searchButton;
	private TextField idPackageForSearchTextField;
	private Text resultText;

	private String username;
	private String password;

	private final ObservableList<PackageToSend> data = FXCollections.observableArrayList();
	private TableView table;
	

	private ClientViewController controller = new ClientViewController();

	public Scene makeScene() {
		initComponents();
		addActionHandlerForBackButton();

		grid.add(helloMessage, 0, 1);
		grid.add(usernameText, 0, 2);
		GridPane sp=new GridPane();
		sp.setMaxWidth(120);
		sp.setMinWidth(120);		
		sp.setMinHeight(320);
		sp.add(routesText, 0, 0);
		grid.add(sp, 0, 3);

		HBox hBox = new HBox();
		hBox.getChildren().addAll(scrollPaneWithFunctions(), scrollPaneWithResult(), grid);
		Scene scene = new Scene(hBox, 1000, 475);
		scene.getStylesheets().add(View.class.getResource("input.css").toExternalForm());
		return scene;
	}

	private void initComponents() {

		helloMessage = new Label("Thank you for being a client of PaketTracer!");
		searchPackageLabel = new Label("Search");
		listButton = new Button("List all my packages");
		listButton.setMinWidth(200);
		searchButton = new Button("Search package");
		addActionHandlerForButtons();
		idPackageForSearchTextField = new TextField("Package  ID");

		resultText = new Text();
		resultText.setFont(new Font(20));
		resultText.setWrappingWidth(500);
		resultText.setTextAlignment(TextAlignment.JUSTIFY);
		resultText.setText("No result");

		usernameText = new Text();
		usernameText.setFont(new Font(20));
		usernameText.setTextAlignment(TextAlignment.CENTER);
		usernameText.setText("You are registerd as " + username);
		
		routesText = new Text();
		routesText.setFont(new Font(15));
		routesText.setTextAlignment(TextAlignment.CENTER);
		routesText.setWrappingWidth(220);
		routesText.setFont(Font.font ("Verdana", 15));
		//routesText.setFill(Color.RED);
		//routesText.setFontSmoothingType(FontSmoothingType.LCD);
		routesText.setText("");
		
	}

	private GridPane scrollPaneWithFunctions() {
		ScrollPane sp = new ScrollPane();
		GridPane wrapping = new GridPane();
		wrapping.setAlignment(Pos.TOP_CENTER);
		wrapping.setHgap(50);
		wrapping.setVgap(50);
		wrapping.setPadding(new Insets(1, 1, 1, 1));
		Text functionsText = new Text("Packet tracer functions for clients");
		functionsText.setFont(new Font(20));
		functionsText.setWrappingWidth(200);
		functionsText.setTextAlignment(TextAlignment.CENTER);
		wrapping.add(functionsText, 0, 0);
		GridPane pane0 = new GridPane();
		pane0.setAlignment(Pos.TOP_CENTER);
		pane0.add(listButton, 0, 0);
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.TOP_CENTER);
		pane1.add(searchPackageLabel, 0, 2);
		pane1.add(idPackageForSearchTextField, 1, 2);
		GridPane pane3 = new GridPane();
		pane3.setAlignment(Pos.TOP_CENTER);
		pane3.add(searchButton, 0, 0);
		// pane1.add(pane3, 0, 3);
		wrapping.add(pane0, 0, 1);
		wrapping.add(pane1, 0, 2);
		wrapping.add(pane3, 0, 3);

		sp.setContent(wrapping);
		return wrapping;
	}

	private ScrollPane scrollPaneWithResult() {
		ScrollPane sp = new ScrollPane();
		HBox register = new HBox();
		GridPane pane2 = new GridPane();
		pane2.add(resultText, 0, 0);
		makePackagesTable();
		pane2.add(table, 0, 1);
		register.getChildren().addAll(pane2);

		sp.setContent(register);
		sp.setMinWidth(550);
		sp.setMaxWidth(550);
		return sp;
	}

	public void addActionHandlerForButtons() {
		listButton.setOnAction(new EventHandler<ActionEvent>() {

			@SuppressWarnings("unchecked")
			public void handle(ActionEvent event) {
				try {
					data.clear();
					resultText.setText("Resulting table");
					List list = controller.getPackages(username,password);
					for (Object o : list) {
						data.add((PackageToSend) o);
					}
					table.setItems(data);
				} catch (Exception e) {
					resultText.setText("An error occured!");
					System.out.println(e);
				}
			}
		});
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@SuppressWarnings("unchecked")
			public void handle(ActionEvent event) {
				String id = idPackageForSearchTextField.getText();
				try {
					data.clear();
					int idInt = Integer.parseInt(id);
					resultText.setText("Resulting table");
					data.add(controller.obtainPackage(username, idInt,password));
					table.setItems(data);
				} catch (Exception e) {
					resultText.setText("Id must be an integer!");
					System.out.println(e);
				}

			}
		});

	}

	@SuppressWarnings("unchecked")
	private void makePackagesTable() {

		table = new TableView();
		table.setEditable(true);
		

		TableColumn nameCol = new TableColumn("Name");
		TableColumn idCol = new TableColumn("Id");
		TableColumn descriptionCol = new TableColumn("Description");
		TableColumn senderCityCol = new TableColumn("Sender City");
		TableColumn receiverCityCol = new TableColumn("Receiver City");
		TableColumn trackedCol = new TableColumn("Tracked");
		TableColumn routesCol = new TableColumn("Routes");
		routesCol.setMinWidth(150);
		nameCol.setCellValueFactory(new PropertyValueFactory<PackageToSend, String>("name"));
		idCol.setCellValueFactory(new PropertyValueFactory<PackageToSend, Integer>("id"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<PackageToSend, String>("description"));
		senderCityCol.setCellValueFactory(new PropertyValueFactory<PackageToSend, String>("senderCity"));
		receiverCityCol.setCellValueFactory(new PropertyValueFactory<PackageToSend, String>("receiverCity"));
		routesCol.setCellValueFactory(new PropertyValueFactory<PackageToSend, String>("routes"));
		trackedCol.setCellValueFactory(new PropertyValueFactory<PackageToSend, Boolean>("tracked"));
		table.setItems(data);
		table.getColumns().addAll(nameCol, idCol, descriptionCol,senderCityCol, receiverCityCol,trackedCol,routesCol);
		table.setRowFactory(new Callback<TableView<PackageToSend>, TableRow<PackageToSend>>() {  
              
            public TableRow<PackageToSend> call(TableView<PackageToSend> tableView) {  
                final TableRow<PackageToSend> row = new TableRow<PackageToSend>();  
                final ContextMenu contextMenu = new ContextMenu();  
                final MenuItem removeMenuItem = new MenuItem("Show routes");  
                removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {  
                 
                    public void handle(ActionEvent event) {  
                    	PackageToSend pck=row.getItem();
                    	routesText.setText("The selected package has : "+pck.getRoutes());
                    }  
                });  
                contextMenu.getItems().add(removeMenuItem);  
               // Set context menu on row, but use a binding to make it only show for non-empty rows:  
                row.contextMenuProperty().bind(  
                        Bindings.when(row.emptyProperty())  
                        .then((ContextMenu)null)  
                        .otherwise(contextMenu)  
                );  
                return row ;  
            }  
        });
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
