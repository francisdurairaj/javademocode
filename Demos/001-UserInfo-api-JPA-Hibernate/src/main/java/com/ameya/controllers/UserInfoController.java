package com.ameya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ameya.models.UserInfo;
import com.ameya.services.UserInfoService;

@RestController
@RequestMapping(value= {"/userinfo"})
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserInfo> getUserById(@PathVariable int id){
		UserInfo userInfo=userInfoService.findById(id);
		if(userInfo==null) {
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserInfo>(userInfo,HttpStatus.OK);
	}
	@PostMapping(value="/create")
	public ResponseEntity<Void> createUser(@RequestBody UserInfo userInfo,UriComponentsBuilder ucBuilder){
		userInfoService.createUserInfo(userInfo);
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(ucBuilder.path("/userinfo/{id}").
				buildAndExpand(userInfo.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getall")
	public List<UserInfo> getAllUsersInfo(){
		List<UserInfo> allUsersInfo=userInfoService.getAllUsersInfo();
		return allUsersInfo;
	}
	@PutMapping(value="/update")
	public ResponseEntity<String> updateUserInfo(@RequestBody UserInfo newUserInfo) {
		UserInfo userInfo=userInfoService.findById(newUserInfo.getId());
		if(userInfo==null) {
			return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
		}
		userInfoService.update(newUserInfo, newUserInfo.getId());
		return new ResponseEntity<String>("User Updated",HttpStatus.OK);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteUserInfo(@PathVariable int id){
		UserInfo userInfo=userInfoService.findById(id);
		if(userInfo==null) {
			return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
		}
		userInfoService.deleteUserInfoById(id);
		return new ResponseEntity<String>("User Deleted",HttpStatus.NO_CONTENT);
	}
}
