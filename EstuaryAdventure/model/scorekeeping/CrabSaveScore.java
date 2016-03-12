package scorekeeping;

/**
 * class to model the crab save game score
 * @author abrah
 *
 */
public class CrabSaveScore extends GameScore {
	
	private int getNumTrash;
	private double time;
	/**
	 * creates a CrabSaveScore
	 * @param getNumTrash
	 * @param time
	 */
	public CrabSaveScore(int getNumTrash, double time){
		this.getNumTrash = getNumTrash;
		this.time = time;
	}
	/**
	 * gets the trashnum
	 * @return
	 */
	public int getTrashNum(){
		return getNumTrash;
	}
	/**
	 * gets the time
	 * @return
	 */
	public double getTime(){
		return time;
	}
	/**
	 * gets the calculated score out of 100 based on all factors
	 * @return
	 */
	public int getCalculatedScore(){
		int trashScore = 0;
		int timeScore=0;
		//double time = 60-time;
		trashScore = ((6-getNumTrash)*11);
		if(time >= 34){
			timeScore = 34;
		}
		else{
			timeScore = (int) time;
		}
		return timeScore+trashScore;
	}
	
	
	
}
