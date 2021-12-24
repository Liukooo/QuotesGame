import java.io.FileNotFoundException;
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

public class StatisticsPane extends BorderPane {

	public StatisticsPane(Stage primaryStage) throws FileNotFoundException {

		Label title = new Label("Overall scores");
		title.setFont(new Font("Tahoma", 20));

		HBox top = new HBox();
		top.getChildren().add(title);
		top.setAlignment(Pos.CENTER);
		top.setPadding(new Insets(20));
		top.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 15, 0.5, 0.0, 0.0);");

		Label expectation = new Label();
		expectation.setFont(new Font("Tahoma", 14));
		expectation.setWrapText(true);
		expectation.setTextAlignment(TextAlignment.CENTER);
		expectation.setPadding(new Insets(10));

		StatsControll.setText(expectation);

		Label overallScore = new Label();
		overallScore.setFont(new Font("Tahoma", 16));

		Label author1SuccessScore = new Label();
		author1SuccessScore.setFont(new Font("Tahoma", 16));

		Label author2SuccessScore = new Label();
		author2SuccessScore.setFont(new Font("Tahoma", 16));

		StatsControll.getSuccessScore(overallScore, author1SuccessScore, author2SuccessScore);

		VBox center = new VBox();
		center.getChildren().addAll(expectation, overallScore, author1SuccessScore, author2SuccessScore);
		center.setAlignment(Pos.CENTER_LEFT);
		center.setMaxWidth(400);
		center.setSpacing(12);
		center.setStyle("-fx-background-color:#e6e6e6;");

		Button close = new Button("Close application");
		close.setFont(new Font("Tahoma", 14));
		close.setStyle("-fx-color: #FF4500");
		close.setOnAction(e -> primaryStage.close());

		HBox bottom = new HBox(close);
		bottom.setPadding(new Insets(10));
		bottom.setAlignment(Pos.BOTTOM_RIGHT);
		bottom.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");

		setStyle("-fx-background-color:#e6e6e6;");
		setCenter(center);
		setTop(top);
		setBottom(bottom);
	}
}
