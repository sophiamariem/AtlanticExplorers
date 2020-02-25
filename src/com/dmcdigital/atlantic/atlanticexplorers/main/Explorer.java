package com.dmcdigital.atlantic.atlanticexplorers.main;

public class Explorer { 

	private static final String NORTH = "N";	
	private static final String EAST = "E";	
	private static final String SOUTH = "S";
	private static final String WEST = "W";

	private int xCoordinateValue;
	private int yCoordinateValue;
	private String orientation;

	public int getxCoordinateValue() {
		return xCoordinateValue;
	}

	public void setxCoordinateValue(int xCoordinateValue) {
		this.xCoordinateValue = xCoordinateValue;
	}

	public int getyCoordinateValue() {
		return yCoordinateValue;
	}

	public void setyCoordinateValue(int yCoordinateValue) {
		this.yCoordinateValue = yCoordinateValue;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	protected  void retrieveNewForwardDirection() {
		if (isNorth()){
			incrementYCoordinate();
		} else if (isEast()){
			incrementXCoordinate();
		} else if (isSouth()){
			decrementYCoordinate();
		} else if (isWest()){
			decrementXCoordinate();
		}
	}

	protected  void retrieveNewDirectionFromRight() {
		if (isNorth()){
			setOrientationToEast();
		} else if (isEast()){
			setOrientationToSouth();
		} else if (isSouth()){
			setOrientationToWest();
		} else if (isWest()){
			setOrientationToNorth();
		}
	}

	protected  void retrieveNewDirectionFromLeft() {
		if (isNorth()){
			setOrientationToWest();
		} else if (isWest()){
			setOrientationToSouth();
		} else if (isSouth()){
			setOrientationToEast();
		} else if (isEast()){
			setOrientationToNorth();
		}
	}

	public boolean isWest() {
		return  getOrientation().equals(WEST);
	}

	public boolean isSouth() {
		return  getOrientation().equals(SOUTH);
	}

	public boolean isEast() {
		return  getOrientation().equals(EAST);
	}

	public boolean isNorth() {
		return  getOrientation().equals(NORTH);
	}

	private void setOrientationToNorth() {
		setOrientation(NORTH);
	}

	private void setOrientationToWest() {
		setOrientation(WEST);
	}

	private void setOrientationToSouth() {
		setOrientation(SOUTH);
	}

	private void setOrientationToEast() {
		setOrientation (EAST);
	}

	private void decrementXCoordinate() {
		xCoordinateValue -= 1;
	}

	private void decrementYCoordinate() {
		yCoordinateValue -= 1;
	}

	private void incrementXCoordinate() {
		xCoordinateValue += 1;
	}

	private void incrementYCoordinate() {
		yCoordinateValue += 1;
	}
}
