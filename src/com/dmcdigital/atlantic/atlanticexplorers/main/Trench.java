package com.dmcdigital.atlantic.atlanticexplorers.main;

public class Trench {

	private final static int lowerX = 0;
	private final static int lowerY= 0;

	private int maxXBound;
	private int maxYBound;
	private String maxBounds;

	public Trench (String maxBounds){
		String[] trenchBounds = maxBounds.split(" ");
		setTopXBound(trenchBounds[0]);
		setTopYBound(trenchBounds[1]);
		this.maxBounds = maxBounds;
	}
	public String getMaxBounds() {
		return maxBounds;
	}

	private void setTopYBound(String topYBound) {
		setMaxYBound(Integer.parseInt(topYBound));		
	}
	private void setTopXBound(String topXBound) {
		setMaxXBound(Integer.parseInt(topXBound));		
	}

	public int getLowerX() {
		return lowerX;
	}
	public int getLowerY() {
		return lowerY;
	}
	public int getMaxXBound() {
		return maxXBound;
	}
	private void setMaxXBound(int maxXBound) {
		this.maxXBound = maxXBound;		
	}
	public int getMaxYBound() {
		return maxYBound;
	}
	private void setMaxYBound(int maxYBound) {
		this.maxYBound = maxYBound;	
	}

}