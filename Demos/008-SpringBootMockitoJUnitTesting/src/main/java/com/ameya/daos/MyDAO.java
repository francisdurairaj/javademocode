package com.ameya.daos;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {

	public int[] retrieveAllData() {
		//Some dummy data
		//Actually this would be communicating with DB to get all Data
		
		return new int[] {1,2,3,4,5};
	}
}
