package com.mudra.map.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mudra.map.constants.AppConstants;
import com.mudra.map.dao.UserInfoRepository;
import com.mudra.map.entity.UserInfo;
import com.mudra.map.util.DateUtility;

@Service
public class UserInfoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);
	
	@Autowired
	private UserInfoRepository  userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void addNewUser(UserInfo userInfo) {
		
		LOGGER.info("UserInfoService.class	->	addNewUser()	->	start");
		
		String encode = passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(encode);
		
		try {
			userInfo.setCreated_at(DateUtility.getCurrentDateTime());
			userInfo.setStatus(AppConstants.ACTIVE_STATUS);
			userInfoRepository.save(userInfo);
		} catch (Exception e) {
			LOGGER.error("Error while signup" + e.getMessage());
		}
		
		LOGGER.info("UserInfoService.class	->	addNewUser()	->	end");
	}
	
	public UserInfo verifyUser(UserInfo userInfo) {
		
		LOGGER.info("UserInfoService.class	->	verifyUser()	->	start");
		
		Optional<UserInfo> byMobile_num = java.util.Optional.empty(); 
		try {
			byMobile_num = userInfoRepository.findUserInfoByMobileNum(userInfo.getMobile_no());
		} catch (Exception e) {
			LOGGER.error("Error while login" + e.getMessage());
		}
		
		if(byMobile_num.isPresent()) {
			UserInfo userInfoFromDb = byMobile_num.get();
			if(passwordEncoder.matches(userInfo.getPassword(), userInfoFromDb.getPassword())) {
				LOGGER.info("User verified");
				return  userInfoFromDb;
			}else {
				LOGGER.info("Invalid credential");
				return new UserInfo();
			}	
		}else {
			LOGGER.info("Invalid credential");
			return new UserInfo();
		}
		
	}

}
