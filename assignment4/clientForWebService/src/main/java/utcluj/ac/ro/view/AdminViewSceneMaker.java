package utcluj.ac.ro.view;

import java.time.LocalDate;

import utcluj.ac.ro.model.*;
import utcluj.ac.ro.model.Package;
import utcluj.ac.ro.view.controllers.AdminViewController;
import javafx.scene.layout.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
@SuppressWarnings({ "restriction", "rawtypes" })
public class AdminViewSceneMaker extends SceneMaker {

	private Label helloMessage;
	private Text adminText;
	private Label addPackageLabel;
	private Label senderIDLabel;
	private Label receiverIDLabel;
	private Label nameLabel;
	private Label descriptionLabel;
	private Label senderCityLabel;
	private Label destinationCityLabel;
	private Label routeIdLabel;
	private CheckBox trackedCheckBox;
	private Label registerPackageLabel;
	private Label idRegisterPackageLabel;
	private Label removePackageLabel;
	private Label idRemovePackageLabel;
	private Label updatePackageLabel;
	private Label idPackageUpdatePackageLabel;
	private Label CityUpdatePackageLabel;
	private TextField CityUpdatePackageTextField;
	final DatePicker datePicker = new DatePicker(LocalDate.of(1983, 9, 19));

	private Button addButton;
	private Button removeButton;
	private Button registerButton;
	private Button updateButton;

	private TextField senderIDTextField;
	private TextField receiverIDTextField;
	private TextField nameTextField;
	private TextField descriptionTextField;
	private TextField senderCityTextField;
	private TextField destinationCityTextField;
	private TextField idUpdatePackagetextField;
	private TextField idRemovePackageTextField;
	private TextField idRegisterPackageTextField;
	private TextField routeIDTextField;
	private TableView table;

	private AdminViewController controller = new AdminViewController();

	final ObservableList<Client> data = FXCollections.observableArrayList(new Client("xdfa",1),
			new Client("asd", 1));

	public Scene makeScene() {
		initComponents();
		addActionHandlerForBackButton();
		grid.add(helloMessage, 0, 1);
		grid.add(adminText, 0, 2);
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(grid, gridPaneWithRgisterAndUpdateFunctionalities(), scrollPaneWithTableOFCLients());
		Scene scene = new Scene(hBox, 950, 475);
		scene.getStylesheets().add(View.class.getResource("input.css").toExternalForm());
		return scene;
	}

	private void initComponents() {

		helloMessage = new Label("Hello, admin");
		adminText = new Text();
		adminText.setFont(new Font(16));
		adminText.setWrappingWidth(250);
		adminText.setTextAlignment(TextAlignment.CENTER);
		adminText.setText("You can perform actions on packages");
		addPackageLabel = new Label("Add package");
		removePackageLabel = new Label("Remove package");
		registerPackageLabel = new Label("Register package");
		senderIDLabel = new Label("Sender ID:");
		receiverIDLabel = new Label("Receiver ID:");
		nameLabel = new Label("Name:");
		descriptionLabel = new Label("Description:");
		senderCityLabel = new Label("Sender city:");
		destinationCityLabel = new Label("Destination city:");
		routeIdLabel= new Label("Route id:");
		idRegisterPackageLabel = new Label("ID package");
		idRemovePackageLabel = new Label("ID package");
		updatePackageLabel = new Label("Update package");
		idPackageUpdatePackageLabel = new Label("ID package");
		CityUpdatePackageLabel = new Label("City");

		senderIDTextField = new TextField("Sender ID");
		receiverIDTextField = new TextField("Receiver ID");
		nameTextField = new TextField("Name");
		descriptionTextField = new TextField("Description");
		senderCityTextField = new TextField("Sender city");
		destinationCityTextField = new TextField("Destination city");
		idUpdatePackagetextField = new TextField("ID package");
		CityUpdatePackageTextField = new TextField("City package");
		idRemovePackageTextField = new TextField("Package  ID");
		idRegisterPackageTextField = new TextField("Package  ID");
		routeIDTextField= new TextField("Route  ID");
		trackedCheckBox = new CheckBox("Tracked");

		addButton = new Button();
		addButton.setText("Add package");
		removeButton = new Button();
		removeButton.setText("Remove package");
		registerButton = new Button();
		registerButton.setText("Register package");
		updateButton = new Button();
		updateButton.setText("Update package");
		addActionHandlerForButtons();

		table = new TableView();
		table.setEditable(true);

		TableColumn usernameCol = new TableColumn("Username");
		TableColumn idCol = new TableColumn("Id");
		usernameCol.setCellValueFactory(new PropertyValueFactory<Client, String>("username"));
		usernameCol.setMinWidth(200);
		idCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
		idCol.setMinWidth(200);
		data.clear();
		data.addAll(controller.fetchClients());
		table.setItems(data);
		table.getColumns().addAll(usernameCol, idCol);

	}

	public void addActionHandlerForButtons() {
		addButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					Package p = new Package();
					int senderId = Integer.parseInt(senderIDTextField.getText());
					p.setSenderId(senderId);
					int receiverId = Integer.parseInt(receiverIDTextField.getText());
					p.setReceiverId(receiverId);
					String name = nameTextField.getText();
					p.setName(name);
					String description = descriptionTextField.getText();
					p.setDescription(description);
					String senderCity = senderCityTextField.getText();
					p.setSenderCity(senderCity);
					String destinationCity = destinationCityTextField.getText();
					p.setReceiverCity(destinationCity);
					boolean tracked = trackedCheckBox.selectedProperty().getValue();
					p.setTracked(tracked);
					int rputeIDInt=Integer.parseInt(routeIDTextField.getText());
					p.setRouteId(rputeIDInt);
					controller.addPackage(p);
				} catch (Exception e) {
					System.out.println("exception add"+e);
				}

			}
		});
		removeButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					int id = Integer.parseInt(idRemovePackageTextField.getText());
					controller.removePackage(id);
				} catch (Exception e) {
					System.out.println("exception rmeove"+e);
				}
			}
		});
		registerButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					int id = Integer.parseInt(idRegisterPackageTextField.getText());
					controller.registerPackage(id);
				} catch (Exception e) {
					System.out.println("exception register"+e);
				}
			}
		});
		updateButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					int id = Integer.parseInt(idUpdatePackagetextField.getText());
					String city = CityUpdatePackageTextField.getText();
					LocalDate localDate = datePicker.getValue();
					controller.updatePackage(id, city, localDate);
				} catch (Exception e) {
					System.out.println("exception update"+e);
				}
			}
		});

	}

	private ScrollPane scrollPaneWithTableOFCLients() {
		ScrollPane sp = new ScrollPane();
		GridPane pane0=new GridPane();
		pane0.setAlignment(Pos.TOP_CENTER);
		GridPane pane1=new GridPane();
		pane1.setAlignment(Pos.TOP_CENTER);
		
		Text t=new Text("List of the clients");
		t.setFont(new Font(16));
		t.setTextAlignment(TextAlignment.CENTER);
		pane1.add(t, 0, 0);
		pane0.add(pane1, 0,0);
		pane0.add(table, 0,1);
		sp.setContent(pane0);
		return sp;
	}

	private ScrollPane gridPaneWithRgisterAndUpdateFunctionalities() {
		ScrollPane rgisterAndUpdateGRid = new ScrollPane();
		GridPane pane0=new GridPane();
		pane0.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(5, 5, 5, 5));
		pane0.add(scrollPaneWithAdd(), 0, 0);
		pane0.add(scrollPaneWithRemove(), 0, 1);
		pane0.add(scrollPaneWithRemove(), 0, 1);
		pane0.add(scrollPaneWithRegister(),0, 2);
		pane0.add(scrollPaneWithUpdate(),0, 3);		
		rgisterAndUpdateGRid.setContent(pane0);
		return rgisterAndUpdateGRid;
	}

	private ScrollPane scrollPaneWithUpdate() {
		ScrollPane sp = new ScrollPane();
		HBox register = new HBox();

		GridPane pane2 = new GridPane();
		pane2.add(updatePackageLabel, 0, 0);
		pane2.add(idPackageUpdatePackageLabel, 0, 1);
		pane2.add(idUpdatePackagetextField, 1, 1);
		pane2.add(CityUpdatePackageLabel, 0, 2);
		pane2.add(CityUpdatePackageTextField, 1, 2);
		pane2.add(datePicker, 1, 3);
		pane2.add(updateButton, 0, 4);

		register.getChildren().addAll(pane2);

		sp.setContent(register);
		return sp;
	}

	private ScrollPane scrollPaneWithRegister() {
		ScrollPane sp = new ScrollPane();
		HBox register = new HBox();
		GridPane pane1 = new GridPane();
		pane1.add(registerPackageLabel, 0, 0);
		pane1.add(idRegisterPackageLabel, 0, 1);
		pane1.add(idRegisterPackageTextField, 1, 1);
		pane1.add(registerButton, 0, 2);
		register.getChildren().addAll(pane1);
		sp.setContent(register);
		return sp;
	}

	private ScrollPane scrollPaneWithRemove() {
		ScrollPane sp = new ScrollPane();
		HBox register = new HBox();
		GridPane pane1 = new GridPane();
		pane1.add(removePackageLabel, 0, 0);
		pane1.add(idRemovePackageLabel, 0, 1);
		pane1.add(idRemovePackageTextField, 1, 1);
		pane1.add(removeButton, 0, 2);
		register.getChildren().addAll(pane1);
		sp.setContent(register);
		return sp;
	}

	private ScrollPane scrollPaneWithAdd() {
		ScrollPane sp = new ScrollPane();
		HBox register = new HBox();
		GridPane pane1 = new GridPane();
		pane1.add(addPackageLabel, 1, 0);
		pane1.add(senderIDLabel, 1, 1);
		pane1.add(receiverIDLabel, 1, 2);
		pane1.add(nameLabel, 1, 3);
		pane1.add(descriptionLabel, 1, 4);
		pane1.add(senderCityLabel, 1, 5);
		pane1.add(destinationCityLabel, 1, 6);
		pane1.add(routeIdLabel, 1, 7);
		pane1.add(trackedCheckBox, 1, 8);

		pane1.add(senderIDTextField, 2, 1);
		pane1.add(receiverIDTextField, 2, 2);
		pane1.add(nameTextField, 2, 3);
		pane1.add(descriptionTextField, 2, 4);
		pane1.add(senderCityTextField, 2, 5);
		pane1.add(destinationCityTextField, 2, 6);
		pane1.add(addButton, 1, 9);
		pane1.add(routeIDTextField, 2, 7);
		register.getChildren().addAll(pane1);
		sp.setContent(register);
		return sp;
	}

}
