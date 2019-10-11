
public class Score {
	private int id;
	private int score;
	private int rank;
	private int denseRank;
	private int rownum;
	
	public Score(int id, int score) {
		this.id= id;
		this.score = score;
	}
	
	public int GetId() {
		return this.id;
	}
	
	public int GetScore() {
		return this.score;
	}
	
	public void SetRanks(int rank, int denseRank, int rownum) {
		this.rank = rank;
		this.denseRank = denseRank;
		this.rownum = rownum;
	}
	
	public void Print() {
		System.out.println(this.id + " " + this.score + " " + this.rank + " " + this.denseRank + " " + this.rownum);
	}
}
