package arcanemaster.ui.fx.form;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxUnitEditor extends Application {
	
	//public static final String NUMBER = "[0-9]*";
	public static final String NUMBER = "-?[0-9]*";
	
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
	Label lblInfo = new Label("Description");
	Label lblLore = new Label("Lore");
	
	TextField tfFilename = new TextField();
	TextField tfName = new TextField();
	TextField tfRace = new TextField();
	
	TextArea taInfo = new TextArea("Unit description here!");
	TextArea taLore = new TextArea("Unit lore here!");
	
	ComboBox<String> cbType = new ComboBox<String>();
	ComboBox<String> cbRace = new ComboBox<String>();
	ComboBox<Integer> cbBuild = new ComboBox<Integer>();
	ComboBox<Integer> cbSight = new ComboBox<Integer>();
	ComboBox<String> cbMoveType = new ComboBox<String>();
	ComboBox<Integer> cbMoveSpeed = new ComboBox<Integer>();
	
	Button btnSave = new Button("Save");;
	Button btnClear = new Button("Clear");
	Button btnRevert = new Button("Revert");

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Arcane Master Unit Editor");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(20);
		grid.setVgap(15);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//Right justify column 1
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHalignment(HPos.RIGHT);
		grid.getColumnConstraints().add(column1);
		
		
		
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
		
		
		grid.add(lblInfo, 0, 11);
		GridPane.setValignment(lblInfo, VPos.TOP);
		grid.add(lblLore, 0, 12);
		GridPane.setValignment(lblLore, VPos.TOP);
		
		grid.add(tfFilename, 1,1);
		grid.add(tfName, 1, 2);
		
		cbType.getItems().addAll("Fighter", "Ranged", "Caster", "Healer", "Construct", "Creature", "Ship");
		cbType.setValue("Fighter");
		grid.add(cbType, 1, 3);
		
		cbRace.getItems().addAll("Human", "Monster", "Undead", "Elves", "Nature", "Neutral", "Dremer");
		cbRace.setEditable(true);
		cbRace.setValue("Human");
		grid.add(cbRace, 1, 4);
		
		cbBuild.getItems().addAll(0,1,2,3,4,5,6,7,8,9);
		//cbBuild.setEditable(true);
		cbBuild.setValue(2);
		grid.add(cbBuild, 1, 5);
		
		/*
		 * Unit Build Cost entry boxes including resource icons and entry fields
		 */
		
		int pCol = 3;
		HBox hbBuild = new HBox(10);
		
		Image gold = new Image("file:res/images/coin.png", 24, 24, false, false);
		ImageView ivGold = new ImageView();
		ivGold.setImage(gold);
		hbBuild.getChildren().add(ivGold);
		
		TextField tfGoldCost = new TextField("0"){
			@Override public void replaceText(int start, int end, String text) {
				if (text.matches(NUMBER)) {
					super.replaceText(start, end, text);
				}
			}

			@Override public void replaceSelection(String text) {
				if (text.matches(NUMBER)) {
					super.replaceSelection(text);
				}
			}
		};
		tfGoldCost.setPrefColumnCount(pCol);
		hbBuild.getChildren().add(tfGoldCost);
		
		Image food = new Image("file:res/images/food.png", 24, 24, false, false);
		ImageView ivFood = new ImageView();
		ivFood.setImage(food);
		hbBuild.getChildren().add(ivFood);
		
		TextField tfFoodCost = new TextField("0"){
			@Override public void replaceText(int start, int end, String text) {
				if (text.matches(NUMBER)) {
					super.replaceText(start, end, text);
				}
			}

			@Override public void replaceSelection(String text) {
				if (text.matches(NUMBER)) {
					super.replaceSelection(text);
				}
			}
		};
		tfFoodCost.setPrefColumnCount(pCol);
		hbBuild.getChildren().add(tfFoodCost);
		
		Image mana = new Image("file:res/images/mana.png", 24, 24, false, false);
		ImageView ivMana = new ImageView();
		ivMana.setImage(mana);
		hbBuild.getChildren().add(ivMana);
		
		TextField tfManaCost = new TextField("0"){
			@Override public void replaceText(int start, int end, String text) {
				if (text.matches(NUMBER)) {
					super.replaceText(start, end, text);
				}
			}

			@Override public void replaceSelection(String text) {
				if (text.matches(NUMBER)) {
					super.replaceSelection(text);
				}
			}
		};
		tfManaCost.setPrefColumnCount(pCol);
		hbBuild.getChildren().add(tfManaCost);
		
		grid.add(hbBuild, 1, 6);
		
		
		/*
		 * Unit Upkeep Cost entry boxes including resource icons and entry fields
		 * (similar to above)
		 */
		
		HBox hbUpkeep = new HBox(10);
		
		
		ImageView ivGoldUpkeep = new ImageView();
		ivGoldUpkeep.setImage(gold);
		hbUpkeep.getChildren().add(ivGoldUpkeep);
		
		TextField tfGoldUpkeepCost = new TextField("0"){
			@Override public void replaceText(int start, int end, String text) {
				if (text.matches(NUMBER)) {
					super.replaceText(start, end, text);
				}
			}

			@Override public void replaceSelection(String text) {
				if (text.matches(NUMBER)) {
					super.replaceSelection(text);
				}
			}
		};
		tfGoldUpkeepCost.setPrefColumnCount(pCol);
		hbUpkeep.getChildren().add(tfGoldUpkeepCost);
				
		ImageView ivFoodUpkeep = new ImageView();
		ivFoodUpkeep.setImage(food);
		hbUpkeep.getChildren().add(ivFoodUpkeep);
		
		TextField tfFoodUpkeepCost = new TextField("0"){
			@Override public void replaceText(int start, int end, String text) {
				if (text.matches(NUMBER)) {
					super.replaceText(start, end, text);
				}
			}

			@Override public void replaceSelection(String text) {
				if (text.matches(NUMBER)) {
					super.replaceSelection(text);
				}
			}
		};
		tfFoodUpkeepCost.setPrefColumnCount(pCol);
		hbUpkeep.getChildren().add(tfFoodUpkeepCost);
		
		
		ImageView ivManaUpkeep = new ImageView();
		ivManaUpkeep.setImage(mana);
		hbUpkeep.getChildren().add(ivManaUpkeep);
		
		TextField tfManaUpkeepCost = new TextField("0"){
			@Override public void replaceText(int start, int end, String text) {
				if (text.matches(NUMBER)) {
					super.replaceText(start, end, text);
				}
			}

			@Override public void replaceSelection(String text) {
				if (text.matches(NUMBER)) {
					super.replaceSelection(text);
				}
			}
		};
		tfManaUpkeepCost.setPrefColumnCount(pCol);
		hbUpkeep.getChildren().add(tfManaUpkeepCost);
		
		grid.add(hbUpkeep, 1, 7);
		
		HBox hbMove = new HBox(10);
		cbMoveType.getItems().addAll("Walk", "Amphibious", "Water", "Flying");
		cbMoveType.setValue("Walk");
		hbMove.getChildren().add(cbMoveType);
		cbMoveSpeed.getItems().addAll(0,1,2,3,4,5,6,7,8,9);
		cbMoveSpeed.setValue(2);
		hbMove.getChildren().add(cbMoveSpeed);
		grid.add(hbMove, 1, 8);
		
		cbSight.getItems().addAll(0,1,2,3,4,5,6,7,8,9);
		//cbBuild.setEditable(true);
		cbSight.setValue(2);
		grid.add(cbSight, 1, 9);
		
		TextField tfAttack = new TextField("0"){
			@Override public void replaceText(int start, int end, String text) {
				if (text.matches(NUMBER)) {
					super.replaceText(start, end, text);
				}
			}

			@Override public void replaceSelection(String text) {
				if (text.matches(NUMBER)) {
					super.replaceSelection(text);
				}
			}
		};
		tfAttack.setPrefColumnCount(2);
		grid.add(tfAttack, 1, 10);
		
		grid.add(taInfo, 1, 11);
		grid.add(taLore, 1, 12);
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSave);
		hbBtn.getChildren().add(btnClear);
		hbBtn.getChildren().add(btnRevert);
		grid.add(hbBtn, 1, 14);


		// Build the scene
		Scene scene = new Scene(grid, 750, 800);
		primaryStage.setScene(scene);

		primaryStage.show();

	}

}
