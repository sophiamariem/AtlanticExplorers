package com.dmcdigital.atlantic.atlanticexplorers.main;

import com.dmcdigital.atlantic.atlanticexplorers.main.exceptions.ExplorerOutOfBoundsException;
import com.dmcdigital.atlantic.atlanticexplorers.main.exceptions.InvalidInputException;

public class Navigator {

	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';
	private static final char MOVE = 'M';

	private String newPosition;

	private Explorer explorer;
	private Trench trench;

	public Navigator(Trench trench, Explorer explorer){
		this.trench = trench;
		this.explorer = explorer;
	}

	public void moveExplorer(String instructionSeries) throws ExplorerOutOfBoundsException, InvalidInputException{	
		int thisDirection = instructionSeries.length();

		for (int i = 0; i < thisDirection; i++) {
			char instruction = instructionSeries.charAt(i);
			switch (instruction) {
			case LEFT:
				explorer.retrieveNewDirectionFromLeft();
				break;
			case RIGHT:
				explorer.retrieveNewDirectionFromRight();
				break;
			case MOVE:
				if (isWithinBounds()){
					explorer.retrieveNewForwardDirection();
				} else {
					throw new ExplorerOutOfBoundsException("Out Of Bounds!");
				}
				break;
			default:
				throw new InvalidInputException("Invalid Argument!");
			}
			String finalPosition = explorer.getxCoordinateValue() + " " + explorer.getyCoordinateValue() + " " +  explorer.getOrientation();
			setNewPosition(finalPosition);
		}
	}

	private  boolean isWithinBounds() {
		if (explorer.isNorth()){
			return explorer.getyCoordinateValue()<trench.getMaxYBound();
		}
		if (explorer.isEast()){
			return explorer.getxCoordinateValue()<trench.getMaxXBound();
		}
		if (explorer.isSouth()){
			return explorer.getyCoordinateValue()>trench.getLowerY();
		}
		if (explorer.isWest()){
			return explorer.getxCoordinateValue()>trench.getLowerX();
		}
		return false;
	}

	public String getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(String newPosition) {
		this.newPosition = newPosition;
	}
}
