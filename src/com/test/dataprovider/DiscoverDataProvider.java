package com.test.dataprovider;

import java.util.Map;

public class DiscoverDataProvider {
	Map<String,Integer> map;
	public static void main(String args[]){
		String str="长江站";
		System.out.println(new RMCountSuoZhan().getRMDmaCount(str));
	}
}
