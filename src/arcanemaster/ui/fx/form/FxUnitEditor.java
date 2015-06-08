package arcanemaster.ui.fx.form;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxUnitEditor extends Application {
	
	Label lblFilename = new Label("Filename");
	Label lblName = new Label("Name");
	Label lblType = new Label("Type");
	Label lblRace = new Label("Race");
	Label lblCost = new Label("Purchase Cost");
	Label lblUpkeep = new Label("Upkeep");
	Label lblBuildtime = new Label("Build Time");
	Label lblMovement = new Label("Movement");
	Label lblSightrange = new Label("Sight Range");
	Label lblAttack = new Label("Attack");
	Label lblPerks = new Label("Perks");
	Label lblResistances = new Label("Resistances");
	
	TextField tfFilename = new TextField();
	TextField tfName = new TextField();
	TextField tfRace = new TextField();
	
	Button btnSave = new Button("Save");;
	Button btnClear = new Button("Clear");
	Button btnRevert = new Button("Revert");

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Arcane Master Unit Editor");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Unit Editor");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		grid.add(lblFilename, 0, 1);
		grid.add(lblName, 0, 2);
		grid.add(lblType, 0, 3);
		grid.add(lblRace, 0, 4);
		grid.add(lblBuildtime, 0, 5);
		grid.add(lblCost, 0, 6);
		grid.add(lblUpkeep, 0, 7);
		grid.add(lblMovement, 0, 8);
		grid.add(lblSightrange, 0, 9);
		grid.add(lblAttack,0, 10);
		
		grid.add(tfFilename, 1,1);
		grid.add(tfName, 1, 2);
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSave);
		hbBtn.getChildren().add(btnClear);
		hbBtn.getChildren().add(btnRevert);
		grid.add(hbBtn, 1, 14);

//		Label userName = new Label("User Name:");
//		grid.add(userName, 0, 1);
//
//		TextField userTextField = new TextField();
//		grid.add(userTextField, 1, 1);
//
//		Label pw = new Label("Password:");
//		grid.add(pw, 0, 2);
//
//		PasswordField pwBox = new PasswordField();
//		grid.add(pwBox, 1, 2);

		Scene scene = new Scene(grid, 800, 600);
		primaryStage.setScene(scene);

		primaryStage.show();

	}

}
