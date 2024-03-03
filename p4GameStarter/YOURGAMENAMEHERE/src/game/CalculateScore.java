package game;

/**
 * CLASS: CalculateScore DESCRIPTION: Represents the calculation strategy for
 * scoring in the game. This interface defines a method for calculating the
 * score based on the game's rules or player's achievements.
 */
public interface CalculateScore {

	/**
	 * Calculates the score based on the given input.
	 * 
	 * @param score The base score to be calculated upon.
	 * @return The calculated score after applying the game's scoring rules.
	 */
	public int calcScore(int score);
}
