package scorekeeping;

/**
 * stores all the score objects thoughout the lifetime of the game so they can 
 * be displayed at the end of the game
 * @author abrah
 *
 */
public class ScoreKeeper {
	
	private OverfishingScore overfishingScore;
	private PollutionScore pollutionScore;
	private CrabSaveScore crabSaveScore;
	
	/**
	 * returns true if the scorekeeper has been given an overfishing score
	 * @return
	 */
	public boolean hasOverfishingScore(){
		return overfishingScore!=null;
	}
	/**
	 * returns true if the scorekeep has been given a pollution score
	 * @return
	 */
	public boolean hasPollutionScore(){
		return pollutionScore!=null;
	}
	/**
	 * returns true if the the scorekeeper has been given a crab score
	 * @return
	 */
	public boolean hasCrabSaveScore(){
		return crabSaveScore!=null;
	}
	
	/**
	 * sets of overfishing score to be the parameter
	 * @param score
	 */
	public void addOverfishingScore(OverfishingScore score){
		this.overfishingScore = score;
	}
	
	/**
	 * gets the overfishing score
	 * @return
	 */
	public OverfishingScore getOverfishingScore() {
		return overfishingScore;
	}
	/**
	 * sets the pollution score to be the parameter
	 * @param pollutionScore
	 */
	public void addPollutionScore(PollutionScore pollutionScore){
		this.pollutionScore = pollutionScore;
	}
	/**
	 * gets the pollution score
	 * @return
	 */
	public PollutionScore getPollutionScore(){
		return pollutionScore;
	}
	
	/**
	 * sets the crab save score to be the parameter
	 * @param crabSaveScore
	 */
	public void addCrabSaveScore(CrabSaveScore crabSaveScore){
		this.crabSaveScore = crabSaveScore;
	}
	
	/**
	 * gets the crab save score
	 * @return
	 */
	public CrabSaveScore getCrabSaveScore(){
		return crabSaveScore;
	}
}
