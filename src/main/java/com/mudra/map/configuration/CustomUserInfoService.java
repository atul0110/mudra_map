package com.mudra.map.configuration;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mudra.map.dao.UserInfoRepository;
import com.mudra.map.entity.UserInfo;

public class CustomUserInfoService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository  userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfoByMobileNum = userInfoRepository.findUserInfoByMobileNum(username);
		UserInfo userInfo = userInfoByMobileNum.get();
		if (userInfo == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(userInfo.getMobile_no(), userInfo.getPassword(), new ArrayList<>());
	}

}
