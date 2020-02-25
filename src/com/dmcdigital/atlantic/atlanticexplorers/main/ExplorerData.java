package com.dmcdigital.atlantic.atlanticexplorers.main;

public class ExplorerData {

	private String initialPosition;
	private String instructionSeries;

	private String xCoordinate;
	private String yCoordinate;
	private String orientation;

	private Explorer explorer;

	public ExplorerData(Explorer explorer){
		this.explorer = explorer;
	}

	public String getInitialPosition() {
		return initialPosition;
	}
	public void setInitialPosition(String initialPosition) {
		String[] explorerPosition = initialPosition.split(" ");
		setxCoordinate(explorerPosition[0]);
		setyCoordinate(explorerPosition[1]);
		setOrientation(explorerPosition[2]);
		this.initialPosition = initialPosition;
	}
	public String getInstructionSeries() {
		return instructionSeries;
	}
	public void setInstructionSeries(String instructionSeries) {
		this.instructionSeries = instructionSeries;
	}

	public String getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(String xCoordinate) {
		explorer.setxCoordinateValue(Integer.parseInt(xCoordinate));	
		this.xCoordinate = xCoordinate;
	}
	public String getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(String yCoordinate) {
		explorer.setyCoordinateValue(Integer.parseInt(yCoordinate));	
		this.yCoordinate = yCoordinate;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		explorer.setOrientation(orientation);
		this.orientation = orientation;
	}
}