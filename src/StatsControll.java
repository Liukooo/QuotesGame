import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.control.Label;

public class StatsControll {

	private static String file1, file2;

	private static int count, totalLike;
	private static int likeAuthor1, likeAuthor2, dislikeAuthor1, dislikeAuthor2;
	private static double overallSuccessScore, author1SuccessScore, author2SuccessScore;
	private static NumberFormat fmt;
	private static Random r;

	public StatsControll() {

		file1 = "Churchill.txt";
		file2 = "Einstein.txt";
		count = 0;

		fmt = NumberFormat.getPercentInstance();
		fmt.setMinimumFractionDigits(2);

		r = new Random();
	}

	public int updateCountStats() {
		return ++count;
	}

	public void updateLikeAuthors(ArrayList<String> choosenArray, ArrayList<String> array1) {

		if (choosenArray.equals(array1))
			likeAuthor1++;
		else
			likeAuthor2++;

		totalLike = likeAuthor1 + likeAuthor2;
	}

	public void updateDislikeAuthors(ArrayList<String> choosenArray, ArrayList<String> array1) {

		if (choosenArray.equals(array1))
			dislikeAuthor1++;
		else
			dislikeAuthor2++;
	}

	public void updateOverallSuccessScore(Label label) {

		overallSuccessScore = totalLike / (double) count;

		if (totalLike == 0 && count == 0)
			overallSuccessScore = 0.00;
		else
			label.setText("Overall Success Score: " + fmt.format(overallSuccessScore));
	}

	public void updateAuthor1SuccessScore(Label label) {

		author1SuccessScore = likeAuthor1 / (double) (likeAuthor1 + dislikeAuthor1);

		if (dislikeAuthor1 == 0 && likeAuthor1 == 0)
			author1SuccessScore = 0.00;
		else
			label.setText("Author A Success Score: " + fmt.format(author1SuccessScore));
	}

	public void updateAuthor2SuccessScore(Label label) {

		author2SuccessScore = likeAuthor2 / (double) (likeAuthor2 + dislikeAuthor2);

		if (dislikeAuthor2 == 0 && likeAuthor2 == 0)
			author2SuccessScore = 0.00;
		else
			label.setText("Author B Success Score: " + fmt.format(author2SuccessScore));
	}

	public static double getAuthor1Like() {
		return likeAuthor1;
	}

	public static double getAuthor2Like() {
		return likeAuthor2;
	}

	public static void getSuccessScore(Label label1, Label label2, Label label3) {

		overallSuccessScore = totalLike / (double) count;
		author1SuccessScore = likeAuthor1 / (double) (likeAuthor1 + dislikeAuthor1);
		author2SuccessScore = likeAuthor2 / (double) (likeAuthor2 + dislikeAuthor2);

		label1.setText("Final Overall Success Score: " + fmt.format(overallSuccessScore));
		label2.setText("Final " + file1.replaceAll(".txt", "") + " Success Score: " + fmt.format(author1SuccessScore));
		label3.setText("Final " + file2.replaceAll(".txt", "") + " Success Score: " + fmt.format(author2SuccessScore));
	}

	public static void setText(Label label) {

		if (author1SuccessScore == author2SuccessScore)
			if (likeAuthor1 > likeAuthor2)
				label.setText("Unluckily, both authors have the same Success Score, but " + file1.replaceAll(".txt", "")
						+ " has received more likes.");
			else
				label.setText("Unluckily, both authors have the same Success Score, but " + file2.replaceAll(".txt", "")
						+ " has received more likes.");
	}

	public static String favoriteAuthor() {

		String favoriteAuthor = "";

		if (author1SuccessScore != author2SuccessScore)
			if (author1SuccessScore > author2SuccessScore)
				favoriteAuthor += file1.replaceAll(".txt", "");
			else
				favoriteAuthor += file2.replaceAll(".txt", "");
		else if (likeAuthor1 > likeAuthor2)
			favoriteAuthor += file1.replaceAll(".txt", "");
		else
			favoriteAuthor += file2.replaceAll(".txt", "");

		return favoriteAuthor;
	}

	public static String addMoreQuotes(ArrayList<String> quotes1Array, ArrayList<String> quotes2Array) {

		int choosenString1, choosenString2;

		if (author1SuccessScore != author2SuccessScore)
			if (author1SuccessScore > author2SuccessScore) {
				choosenString1 = r.nextInt(quotes1Array.size());
				choosenString2 = r.nextInt(quotes1Array.size());

				while (MainControll.getQuotesUsed().contains(choosenString1))
					choosenString1 = r.nextInt(quotes1Array.size());

				while (choosenString1 == choosenString2)
					choosenString2 = r.nextInt(quotes1Array.size());

				MainControll.getQuotesUsed().add(choosenString1);
				MainControll.getQuotesUsed().add(choosenString2);

				return quotes1Array.get(choosenString1) + "\n" + quotes1Array.get(choosenString2);
			} else {
				choosenString1 = r.nextInt(quotes2Array.size());
				choosenString2 = r.nextInt(quotes2Array.size());

				while (MainControll.getQuotesUsed().contains(choosenString1)) {
					choosenString1 = r.nextInt(quotes2Array.size());
				}

				while (choosenString1 == choosenString2)
					choosenString2 = r.nextInt(quotes2Array.size());

				MainControll.getQuotesUsed().add(choosenString1);
				MainControll.getQuotesUsed().add(choosenString2);

				return quotes2Array.get(choosenString1) + "\n" + quotes2Array.get(choosenString2);
			}
		else {
			if (likeAuthor1 > likeAuthor2) {
				choosenString1 = r.nextInt(quotes1Array.size());
				choosenString2 = r.nextInt(quotes1Array.size());

				while (MainControll.getQuotesUsed().contains(choosenString1))
					choosenString1 = r.nextInt(quotes1Array.size());

				while (choosenString1 == choosenString2)
					choosenString2 = r.nextInt(quotes1Array.size());

				MainControll.getQuotesUsed().add(choosenString1);
				MainControll.getQuotesUsed().add(choosenString2);

//				StatsControll.setText(label);
				return quotes1Array.get(choosenString1) + "\n" + quotes1Array.get(choosenString2);
			} else {
				choosenString1 = r.nextInt(quotes2Array.size());
				choosenString2 = r.nextInt(quotes2Array.size());

				while (MainControll.getQuotesUsed().contains(choosenString1)) {
					choosenString1 = r.nextInt(quotes2Array.size());
				}

				while (choosenString1 == choosenString2)
					choosenString2 = r.nextInt(quotes2Array.size());

				MainControll.getQuotesUsed().add(choosenString1);
				MainControll.getQuotesUsed().add(choosenString2);

				return quotes2Array.get(choosenString1) + "\n" + quotes2Array.get(choosenString2);
			}
		}
	}
}
