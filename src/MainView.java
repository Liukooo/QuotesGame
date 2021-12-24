import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	public void start(Stage primaryStage) throws FileNotFoundException {

		MainControll controller = new MainControll(primaryStage);

		primaryStage.setTitle("Multi-armed bandits application");
		primaryStage.centerOnScreen();
		primaryStage.setScene(controller.getHomeScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
