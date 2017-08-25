package com.madhu;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import junit.*;;

public class StockArrangementsTest {

	StockArrangements sa = new StockArrangements();

	@Test
	public void testSortStocks() {
		File stockTest = new File("src\\stockdetails.txt");
		sa.sortStocks(stockTest);
		System.out.println("Junit Test Coverage");
	}

}
