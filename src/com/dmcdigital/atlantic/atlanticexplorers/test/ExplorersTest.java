package com.dmcdigital.atlantic.atlanticexplorers.test;

import static org.junit.Assert.*;

import com.dmcdigital.atlantic.atlanticexplorers.main.Explorer;
import com.dmcdigital.atlantic.atlanticexplorers.main.Navigator;
import com.dmcdigital.atlantic.atlanticexplorers.main.Trench;
import com.dmcdigital.atlantic.atlanticexplorers.main.ExplorerData;
import com.dmcdigital.atlantic.atlanticexplorers.main.exceptions.ExplorerOutOfBoundsException;
import com.dmcdigital.atlantic.atlanticexplorers.main.exceptions.InvalidInputException;

import org.junit.Before;
import org.junit.Test;

public class ExplorersTest {

	private Trench trench = new Trench("5 5");
	private ExplorerData firstExplorerData;
	private ExplorerData secondExplorerData;

	private Explorer firstExplorer;
	private Explorer secondExplorer;

	private Navigator navigator;
	private Navigator navigator2;

	String firstInstructionSeries = "LMLMLMLMM";
	String secondInstructionSeries = "MMRMMRMRRM";

	@Test
	public void testTrenchValues(){
		assertTrue(trench.getMaxBounds().equals("5 5"));
		assertEquals(5, trench.getMaxXBound());
		assertEquals(5, trench.getMaxYBound());		
		assertEquals(0, trench.getLowerX());
		assertEquals(0, trench.getLowerY());
	}

	@Before
	public void setExplorerOne(){
		firstExplorer = new Explorer();
		firstExplorerData = new ExplorerData(firstExplorer);
		navigator = new Navigator(trench, firstExplorer);
		firstExplorerData.setInitialPosition("1 2 N");
		firstExplorerData.setInstructionSeries(firstInstructionSeries);
	}

	@Test
	public void testExplorerOne() throws ExplorerOutOfBoundsException, InvalidInputException{
		assertTrue(firstExplorerData.getInitialPosition().equals("1 2 N"));
		assertTrue(firstExplorerData.getInstructionSeries().equals(firstInstructionSeries)); 

		assertEquals("1", firstExplorerData.getxCoordinate());
		assertEquals("2", firstExplorerData.getyCoordinate());
		assertEquals("N", firstExplorerData.getOrientation());
		navigator.moveExplorer(firstInstructionSeries);
		assertEquals(1, firstExplorer.getxCoordinateValue());
		assertEquals(3, firstExplorer.getyCoordinateValue());

		assertTrue(navigator.getNewPosition().equals("1 3 N"));
	}

	@Before
	public void setExplorerTwo(){	
		secondExplorer = new Explorer();
		secondExplorerData = new ExplorerData(secondExplorer);
		navigator2 = new Navigator(trench, secondExplorer);
		secondExplorerData.setInitialPosition("3 3 E");
		secondExplorerData.setInstructionSeries(secondInstructionSeries);
	}

	@Test
	public void testExplorerTwo() throws ExplorerOutOfBoundsException, InvalidInputException{
		assertTrue(secondExplorerData.getInitialPosition().equals("3 3 E"));
		assertTrue(secondExplorerData.getInstructionSeries().equals(secondInstructionSeries));

		assertEquals("3", secondExplorerData.getxCoordinate());
		assertEquals("3", secondExplorerData.getyCoordinate());
		assertEquals("E", secondExplorerData.getOrientation());
		navigator2.moveExplorer(secondInstructionSeries);
		assertEquals(5, secondExplorer.getxCoordinateValue());
		assertEquals(1, secondExplorer.getyCoordinateValue());

		assertTrue(navigator2.getNewPosition().equals("5 1 E"));
	}

}