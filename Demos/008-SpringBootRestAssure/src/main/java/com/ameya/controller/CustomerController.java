package com.ameya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ameya.dao.CustomerDAO;
import com.ameya.models.Customer;

@RestController
public class CustomerController {

    @Autowired
    CustomerDAO repository;

    @RequestMapping("/list")
    public List<Customer> findAll() {
        return repository.getData();
    }

    @RequestMapping("/one/{id}")
    public Customer findOne(@PathVariable int id) {
        return repository.getData().get(id);

    }
}
