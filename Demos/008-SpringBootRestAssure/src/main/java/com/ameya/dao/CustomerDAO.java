package com.ameya.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.ameya.models.Customer;

@Repository
public class CustomerDAO {
	 List<Customer> customerList = new ArrayList<Customer>();

	    @PostConstruct
	    public void init(){
	        customerList.add(new Customer(1, "Ameya"));
	        customerList.add(new Customer(2, "Avani"));
	    }
	    public List<Customer> getData() {
	        return customerList;
	    }
}
