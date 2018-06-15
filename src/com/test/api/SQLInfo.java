package com.test.api;

import com.test.setting.GlobalSetting;

public class SQLInfo {
	private static GlobalSetting gs= GlobalSetting.getInstance();
	public static void main(String args[]){
//		GlobalSetting gs= GlobalSetting.getInstance();
		System.out.println(gs.getHostname());
	}

}