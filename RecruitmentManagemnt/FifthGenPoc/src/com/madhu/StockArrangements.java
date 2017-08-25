package com.madhu;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

import javax.sound.sampled.Line;

import org.apache.commons.lang3.StringUtils;

public class StockArrangements {

	public static void main(String[] args) {
		File stock = null;
		if(args.length > 0){
			stock = new File(args[0]);
		}
		
		StockArrangements stockArrangements = new StockArrangements();
		stockArrangements.sortStocks(stock);

	}
	public void sortStocks(File stock){
		List<String> stockEntry = new ArrayList<String>();
		int count = 0 ;
		BufferedReader br = null;
		if(stock.exists()){
			try{
				br = new BufferedReader(new FileReader(stock));
				for(String line; (line = br.readLine()) != null; ) {
					System.out.println("Before sorting the stocks value" + line);
					stockEntry.add(line);
				}
			}catch(IOException io){
				io.printStackTrace();
			}
			if(stockEntry.isEmpty()){
				return;
			}
		}
		String[] stockSegregate = null;
		LinkedHashMap<Integer,String> soretedList = new LinkedHashMap<Integer,String>();
		int[] totalStockEntries = new int[stockEntry.size()] ;
		for(String line : stockEntry){
			int totalCount = 0;
				stockSegregate = line.split(",");
				for(String stockCost: stockSegregate){
					totalCount = Integer.parseInt(StringUtils.substringAfterLast(stockCost, "- ")) + totalCount;
				}
				for(int i = count; i == count; i++){
					totalStockEntries[i] = totalCount;
				}
				count = count+1;
				soretedList.put(totalCount, line);
		}
		int temp1 = 0;
		for(int i = 0; i< totalStockEntries.length; i++){
			for(int j=i+1;j<totalStockEntries.length;j++){
				if(totalStockEntries[i]<totalStockEntries[j]){
					temp1 = totalStockEntries[i];
					totalStockEntries[i] = totalStockEntries[j];
					totalStockEntries[j] = temp1;
				}
			}
			System.out.println("Toppest stocks value to lowest" + soretedList.get(totalStockEntries[i]));
		}
	}
}
