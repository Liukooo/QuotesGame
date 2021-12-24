import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainControll {

	private Stage primaryStage;
	private String file1, file2;
	private ArrayList<String> prevArray;
	private static ArrayList<Integer> quotesAlreadyUsed;
	private int quoteNum, count;
	private NumberFormat fmt;
	private Random r;
	private Scene sceneHome, sceneQuote, sceneResult, sceneStats;

	public MainControll(Stage primaryStage) throws FileNotFoundException {

		this.primaryStage = primaryStage;

		file1 = "Churchill.txt";
		file2 = "Einstein.txt";

		prevArray = new ArrayList<String>();
		quotesAlreadyUsed = new ArrayList<Integer>();

		quoteNum = 1;

		fmt = NumberFormat.getPercentInstance();
		fmt.setMinimumFractionDigits(2);

		r = new Random();
	}

	public Scene getHomeScene() throws FileNotFoundException {

		HomePane home = new HomePane(primaryStage);
		sceneHome = new Scene(home, 600, 400);

		return sceneHome;
	}

	public Scene getQuoteScene() throws FileNotFoundException {

		QuotePane quote = new QuotePane(primaryStage);
		sceneQuote = new Scene(quote, 600, 400);

		return sceneQuote;
	}

	public Scene getResultScene() throws FileNotFoundException {

		ResultPane result = new ResultPane(primaryStage);
		sceneResult = new Scene(result, 600, 400);

		return sceneResult;
	}

	public Scene getStatsScene() throws FileNotFoundException {

		StatisticsPane statistics = new StatisticsPane(primaryStage);
		sceneStats = new Scene(statistics, 600, 400);

		return sceneStats;
	}

	public void readQuotesFromFiles(ArrayList<String> array1, ArrayList<String> array2) throws FileNotFoundException {

		Scanner s1 = new Scanner(new File(file1));
		Scanner s2 = new Scanner(new File(file2));

		while (s1.hasNext())
			array1.add(s1.nextLine());

		while (s2.hasNext())
			array2.add(s2.nextLine());

		s1.close();
		s2.close();
	}

	public ArrayList<String> chooseAuthor(ArrayList<String> quotes1Array, ArrayList<String> quotes2Array) {

		if (r.nextInt(2) == 0)
			return quotes1Array;
		else
			return quotes2Array;
	}

	public void chooseQuote(Label label, ArrayList<String> choosenAuthor) throws FileNotFoundException {

		int choosenQuote;

		if (count < MaxValueControll.getMaxValue()
				&& StatsControll.getAuthor1Like() < MaxValueControll.getMaxValue() / 2 + 1
				&& StatsControll.getAuthor2Like() < MaxValueControll.getMaxValue() / 2 + 1) {

			choosenQuote = r.nextInt(choosenAuthor.size());

			while (quotesAlreadyUsed.contains(choosenQuote)) {
				choosenQuote = r.nextInt(choosenAuthor.size());
			}

			quotesAlreadyUsed.add(choosenQuote);

			label.setText(choosenAuthor.get(choosenQuote));
		} else {
			ResultPane result = new ResultPane(primaryStage);
			sceneResult = new Scene(result, 600, 400);
			primaryStage.setScene(sceneResult);
		}
	}

	public ArrayList<String> getPrevArray() {
		return prevArray;
	}

	public void setPrevArray(ArrayList<String> choosenArray) {
		prevArray = choosenArray;
	}

	public void updateTitleText(Label label) {

		label.setText("Quote number " + ++quoteNum + ":");
	}

	public int updateCountMain() {
		return ++count;
	}

	public static ArrayList<Integer> getQuotesUsed() {
		return quotesAlreadyUsed;
	}
}