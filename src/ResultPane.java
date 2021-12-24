import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ResultPane extends BorderPane {

	public ResultPane(Stage primaryStage) throws FileNotFoundException {

		MainControll controller = new MainControll(primaryStage);

		ArrayList<String> quotes1Array = new ArrayList<String>();
		ArrayList<String> quotes2Array = new ArrayList<String>();

		controller.readQuotesFromFiles(quotes1Array, quotes2Array);

		Label title = new Label("Results");
		title.setFont(new Font("Tahoma", 20));

		HBox top = new HBox();
		top.getChildren().add(title);
		top.setAlignment(Pos.CENTER);
		top.setPadding(new Insets(20));
		top.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 15, 0.5, 0.0, 0.0);");

		Label text = new Label("Your favorite author is...");
		text.setFont(new Font("Tahoma", 14));

		Label res = new Label(StatsControll.favoriteAuthor());
		res.setFont(new Font("Tahoma", 18));

		Label moreQuotes = new Label(
				"More quotes from you favorite author:\n\n" + StatsControll.addMoreQuotes(quotes1Array, quotes2Array));
		moreQuotes.setFont(new Font("Tahoma", 12));
		moreQuotes.setWrapText(true);
		moreQuotes.setTextAlignment(TextAlignment.CENTER);

		VBox center = new VBox();
		center.getChildren().addAll(text, res, moreQuotes);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		center.setStyle("-fx-background-color:#e6e6e6;");

		Button stats = new Button("See overall scores");
		stats.setFont(new Font("Tahoma", 14));
		stats.setOnAction(e -> {
			try {
				primaryStage.setScene(controller.getStatsScene());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});

		HBox bottom = new HBox();
		bottom.getChildren().add(stats);
		bottom.setAlignment(Pos.CENTER);
		bottom.setPadding(new Insets(10));
		bottom.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");

		setCenter(center);
		setTop(top);
		setBottom(bottom);
	}
}
