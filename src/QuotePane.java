import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class QuotePane extends BorderPane {

	public QuotePane(Stage primaryStage) throws FileNotFoundException {

		MainControll ctrlMain = new MainControll(primaryStage);
		StatsControll ctrlStats = new StatsControll();

		ArrayList<String> quotes1Array = new ArrayList<String>();
		ArrayList<String> quotes2Array = new ArrayList<String>();

		HBox top = new HBox();
		top.setPadding(new Insets(30));
		top.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 15, 0.5, 0.0, 0.0);");

		Label title = new Label("Quote number 1:");
		title.setFont(new Font("Tahoma", 14));

		ctrlMain.readQuotesFromFiles(quotes1Array, quotes2Array);

		ArrayList<String> choosenFirstArray = ctrlMain.chooseAuthor(quotes1Array, quotes2Array);
		ctrlMain.setPrevArray(choosenFirstArray);

		Label quoteText = new Label();
		quoteText.setFont(new Font("Tahoma", 14));
		quoteText.setWrapText(true);
		quoteText.setTextAlignment(TextAlignment.CENTER);
		quoteText.setPadding(new Insets(20));

		ctrlMain.chooseQuote(quoteText, choosenFirstArray);

		Label overallSuccessScoreText = new Label("Overall Success Score: ---");
		overallSuccessScoreText.setFont(new Font("Tahoma", 14));

		Label author1SuccessScoreText = new Label("Author A Success Score: ---");
		author1SuccessScoreText.setFont(new Font("Tahoma", 14));

		Label author2SuccessScoreText = new Label("Author B Success Score: ---");
		author2SuccessScoreText.setFont(new Font("Tahoma", 14));

		/*
		 * The two handlers perform the following procedure: updateLikeAuthors take the
		 * previous shown quote and see if the like or dislike button were pressed. Then
		 * the other update methods update the two counts, the quoteNum of the title,
		 * the overall score, author A score and author B score. ChooseQuote update the
		 * shown quote and setPrevArray set the display array as the array that
		 * updateLikeAuthors should analyze next time.
		 */
		Button likeButt = new Button("Like");
		likeButt.setFont(new Font("Tahoma", 14));
		likeButt.setStyle("-fx-color: #1e90ff");
		likeButt.setOnAction(e -> {
			ctrlStats.updateLikeAuthors(ctrlMain.getPrevArray(), quotes1Array);
			ctrlMain.updateCountMain();
			ctrlStats.updateCountStats();
			ctrlMain.updateTitleText(title);
			ArrayList<String> choosenArray = ctrlMain.chooseAuthor(quotes1Array, quotes2Array);
			try {
				ctrlMain.chooseQuote(quoteText, choosenArray);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			ctrlMain.setPrevArray(choosenArray);
			ctrlStats.updateOverallSuccessScore(overallSuccessScoreText);
			ctrlStats.updateAuthor1SuccessScore(author1SuccessScoreText);
			ctrlStats.updateAuthor2SuccessScore(author2SuccessScoreText);
		});

		Button dislikeButt = new Button("Dislike");
		dislikeButt.setFont(new Font("Tahoma", 14));
		dislikeButt.setStyle("-fx-color: #FF4500");
		dislikeButt.setOnAction(e -> {
			ctrlStats.updateDislikeAuthors(ctrlMain.getPrevArray(), quotes1Array);
			ctrlMain.updateCountMain();
			ctrlStats.updateCountStats();
			ctrlMain.updateTitleText(title);
			ArrayList<String> choosenArray = ctrlMain.chooseAuthor(quotes1Array, quotes2Array);
			try {
				ctrlMain.chooseQuote(quoteText, choosenArray);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			ctrlMain.setPrevArray(choosenArray);
			ctrlStats.updateOverallSuccessScore(overallSuccessScoreText);
			ctrlStats.updateAuthor1SuccessScore(author1SuccessScoreText);
			ctrlStats.updateAuthor2SuccessScore(author2SuccessScoreText);
		});

		HBox judge = new HBox(likeButt, dislikeButt);
		judge.setAlignment(Pos.CENTER);
		judge.setSpacing(25);

		VBox scores = new VBox(overallSuccessScoreText, author1SuccessScoreText, author2SuccessScoreText);
		scores.setAlignment(Pos.CENTER);
		scores.setSpacing(5);

		VBox center = new VBox();
		center.getChildren().addAll(title, quoteText, judge, scores);
		center.setAlignment(Pos.CENTER);
		center.setSpacing(15);
		center.setStyle("-fx-background-color:#e6e6e6;");

		Button stop = new Button("Stop and show the results");
		stop.setFont(new Font("Tahoma", 14));
		stop.setOnAction(e -> {
			if (ctrlStats.updateCountStats() > 4)
				try {
					primaryStage.setScene(ctrlMain.getResultScene());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Attention");
				alert.setHeaderText("You inserted too few discriminating!");
				alert.setContentText("Please, at least insert three ratings.");
				alert.showAndWait();
			}
		});

		HBox bottom = new HBox(stop);
		bottom.setAlignment(Pos.CENTER);
		bottom.setPadding(new Insets(10));
		bottom.setStyle(
				"-fx-background-color:#f1f1f1; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.4), 10, 0.5, 0.0, 0.0);");

		setCenter(center);
		setTop(top);
		setBottom(bottom);
	}
}