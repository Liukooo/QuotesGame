import java.io.FileNotFoundException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HomePane extends BorderPane {

	public HomePane(Stage primaryStage) throws FileNotFoundException {

		MainControll controller = new MainControll(primaryStage);

		Label title = new Label("QUOTES GAME");
		title.setFont(new Font("Tahoma", 22));

		HBox top = new HBox();
		top.getChildren().add(title);
		top.setPadding(new Insets(20));
		top.setAlignment(Pos.CENTER);
		top.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 15, 0.5, 0.0, 0.0);");

		Label subtitle = new Label("LET'S PLAY!");
		subtitle.setFont(new Font("Tahoma", 18));

		Label select = new Label("Select how many quotes the program will show you");
		select.setFont(new Font("Tahoma", 14));
		select.setWrapText(true);
		select.setTextAlignment(TextAlignment.CENTER);

		Slider slider = new Slider(9, 21, 2);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setSnapToTicks(true);
		slider.setValue(11);
		slider.setMinorTickCount(0);
		slider.setMajorTickUnit(2);
		/*
		 * slider set the maximum number of displayed quotes.
		 */
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> obs, Number oldVal, Number newVal) {
				MaxValueControll.setMaxValue(newVal.intValue());
			}
		});

		GridPane selection = new GridPane();
		selection.add(select, 0, 0);
		selection.add(slider, 0, 1);
		selection.setMaxWidth(350);
		selection.setAlignment(Pos.CENTER);
		selection.setPadding(new Insets(5));
		selection.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.3), 8, 0.2, 0.0, 0.0);");

		Button start = new Button("START");
		start.setFont(new Font("Tahoma", 16));
		start.setPrefHeight(50);
		start.setPrefWidth(70);
		start.setStyle("-fx-color:#1e90ff;");
		start.setOnAction(e -> {
			try {
				primaryStage.setScene(controller.getQuoteScene());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});

		VBox center = new VBox();
		center.getChildren().addAll(subtitle, selection, start);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(35);
		center.setStyle(" -fx-background-color:#e6e6e6;");

		Button help = new Button("Help");
		help.setFont(new Font("Tahoma", 14));
		help.setStyle("-fx-color:#fff600; -fx-background-radius: 30");
		help.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Informations");
				alert.setHeaderText("Here you can find all the instructions of the game!");
				Label lb = new Label("On the homepage you can choose how many quotes the program will\n"
						+ "show. The default number is 11. To start the game press the start button.\n"
						+ "After pressing the button, the first quote will appear, the like and\n"
						+ "dislike buttons, and statistics. Pressing one of the two buttons will\n"
						+ "show you a new quote and the statistics will update. Before the end\n"
						+ "of the game, if you no longer feel like continuing, you can press the\n"
						+ "stop button. But remember, you must have given at least three ratings.\n"
						+ "After the game, you can see the result and the final statistics by\n"
						+ "pressing the appropriate button.Finally, you can close the application.");
				lb.setLineSpacing(3);
				alert.getDialogPane().setContent(lb);
				alert.showAndWait();
			}
		});

		HBox bottom = new HBox();
		bottom.getChildren().add(help);
		bottom.setPadding(new Insets(10));
		bottom.setAlignment(Pos.CENTER_RIGHT);
		bottom.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");

		setCenter(center);
		setTop(top);
		setBottom(bottom);
	}
}
