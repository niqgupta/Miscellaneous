import java.io.*;
import java.util.*;

public class Ranking {

	public static void main(String[] args) {
		List<Score> scores = new ArrayList<Score>();
		
		scores.add(new Score(1,20));
		scores.add(new Score(2,30));
		scores.add(new Score(3,21));
		scores.add(new Score(4,	34));
		scores.add(new Score(5	,25));
		scores.add(new Score(6,	32));
		scores.add(new Score(7,	44));
		scores.add(new Score(8,	54));
		scores.add(new Score(9,	65));
		scores.add(new Score(10,	20));
		scores.add(new Score(11,	12));
		scores.add(new Score(12,	30));
		scores.add(new Score(13,	34));
		scores.add(new Score(14,	25));
		scores.add(new Score(15,	52));
		scores.add(new Score(16,	64));
		scores.add(new Score(17,	73));
		scores.add(new Score(18,	82));
		scores.add(new Score(19,	95));
		scores.add(new Score(20,	100));

		//List<Score> scores = ReadFromFile(file);
		CalculateRank(scores);
		
		System.out.println("ID	Score	Rank	DenseRank	Rownum");
		for(int i=0; i<scores.size(); i++) {
			scores.get(i).Print();
		}
	}
	
	public static void CalculateRank(List<Score> scores) {
		// Will sort based on score in ascending order
		Collections.sort(scores, new Comparator<Score>() {
			public int compare(Score s1, Score s2) {
				return s2.GetScore() - s1.GetScore();
			}
		});
		
		int rownum = 1;
		int ranking = 1;
		int denseRanking = 1;
		scores.get(0).SetRanks(ranking, denseRanking, rownum);
		for(int i=1; i<scores.size(); i++) {
			if(scores.get(i-1).GetScore() == scores.get(i).GetScore()) {
				scores.get(i).SetRanks(ranking, denseRanking, ++rownum);
			} else {
				++rownum;
				ranking = rownum;
				scores.get(i).SetRanks(ranking, ++denseRanking, rownum);
			}
		}
	}
}
