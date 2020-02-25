package com.dmcdigital.atlantic.atlanticexplorers.test;

import com.dmcdigital.atlantic.atlanticexplorers.main.Explorer;
import com.dmcdigital.atlantic.atlanticexplorers.main.Navigator;
import com.dmcdigital.atlantic.atlanticexplorers.main.Trench;
import com.dmcdigital.atlantic.atlanticexplorers.main.ExplorerData;
import com.dmcdigital.atlantic.atlanticexplorers.main.exceptions.ExplorerOutOfBoundsException;
import com.dmcdigital.atlantic.atlanticexplorers.main.exceptions.InvalidInputException;

import org.junit.Before;
import org.junit.Test;


public class WithinBoundsTest {

	private Trench trench = new Trench("5 5");

	private ExplorerData thirdExplorerData;
	private ExplorerData fourthExplorerData;
	private ExplorerData fifthExplorerData;
	private ExplorerData sixthExplorerData;

	private Explorer thirdExplorer;
	private Explorer fourthExplorer;
	private Explorer fifthExplorer;
	private Explorer sixthExplorer;

	private Navigator navigator3;
	private Navigator navigator4;
	private Navigator navigator5;
	private Navigator navigator6;

	String failInstructionSeries = "M";

	@Before
	public void setExplorerIllegalArgument(){	
		thirdExplorer = new Explorer();
		thirdExplorerData = new ExplorerData(thirdExplorer);
		navigator3 = new Navigator(trench, thirdExplorer);
		thirdExplorerData.setInitialPosition("3 5 N");
		thirdExplorerData.setInstructionSeries(failInstructionSeries);

		fourthExplorer = new Explorer();
		fourthExplorerData = new ExplorerData(fourthExplorer);
		navigator4 = new Navigator(trench, fourthExplorer);
		fourthExplorerData.setInitialPosition("5 3 E");
		fourthExplorerData.setInstructionSeries(failInstructionSeries);

		fifthExplorer = new Explorer();
		fifthExplorerData = new ExplorerData(fifthExplorer);
		navigator5 = new Navigator(trench, fifthExplorer);
		fifthExplorerData.setInitialPosition("3 0 S");
		fifthExplorerData.setInstructionSeries(failInstructionSeries);

		sixthExplorer = new Explorer();
		sixthExplorerData = new ExplorerData(sixthExplorer);
		navigator6 = new Navigator(trench, sixthExplorer);
		sixthExplorerData.setInitialPosition("0 3 W");
		sixthExplorerData.setInstructionSeries(failInstructionSeries);
	}

	@Test(expected=ExplorerOutOfBoundsException.class)
	public void testExplorerIllegalArgumentNav3() throws ExplorerOutOfBoundsException, InvalidInputException{
		navigator3.moveExplorer(failInstructionSeries);
	}

	@Test(expected=ExplorerOutOfBoundsException.class)
	public void testExplorerIllegalArgumentNav4() throws ExplorerOutOfBoundsException, InvalidInputException{;
	navigator4.moveExplorer(failInstructionSeries);
	}

	@Test(expected=ExplorerOutOfBoundsException.class)
	public void testExplorerIllegalArgumentNav5() throws ExplorerOutOfBoundsException, InvalidInputException{
		navigator5.moveExplorer(failInstructionSeries);
	}

	@Test(expected=ExplorerOutOfBoundsException.class)
	public void testExplorerIllegalArgumentNav6() throws ExplorerOutOfBoundsException, InvalidInputException{
		navigator6.moveExplorer(failInstructionSeries);
	}

}
