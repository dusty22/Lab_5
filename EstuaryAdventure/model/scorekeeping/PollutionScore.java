package scorekeeping;

/**
 * class for holding data for the pollution score
 * @author abrah
 *
 */
public class PollutionScore extends GameScore {

	private int numRemoved;
	/**
	 * creates the pollution score
	 * @param numRemoved num pollutants removed
	 */
	public PollutionScore(int numRemoved){
		this.numRemoved = numRemoved;
	}
	
	/**
	 * gets the calculated score out of 100
	 */
	public int getCalculatedScore(){
		int returnScore = 0;
		if(numRemoved <= 8){
			returnScore = 10;
		}
		else if(numRemoved > 8 && numRemoved <= 16){
			returnScore = 20;
		}
		else if(numRemoved > 16 && numRemoved <= 24){
			returnScore = 30;
		}
		else if(numRemoved > 24 && numRemoved <= 32){
			returnScore = 40;
		}
		else if(numRemoved > 32 && numRemoved <= 40){
			returnScore = 50;
		}
		else if(numRemoved > 40 && numRemoved <= 48){
			returnScore = 60;
		}
		else if(numRemoved > 48 && numRemoved <= 56){
			returnScore = 70;
		}
		else if(numRemoved > 56 && numRemoved <= 64){
			returnScore = 80;
		}
		else if(numRemoved > 64 && numRemoved <= 72){
			returnScore = 90;
		}
		else if(numRemoved > 72){
			returnScore = 100;
		}
		return returnScore;
	}
}
