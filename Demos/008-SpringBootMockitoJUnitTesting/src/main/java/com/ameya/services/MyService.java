package com.ameya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ameya.daos.MyDAO;

@Service
public class MyService {

	@Autowired
	private MyDAO dataService;
	
	public int findTheGreatestFromAllData() {
		int[] data=dataService.retrieveAllData();
		int greatest=Integer.MIN_VALUE;
		for(int value : data) {
			if(value > greatest) {
				greatest=value;
			}
		}
		return greatest;
	}
}
