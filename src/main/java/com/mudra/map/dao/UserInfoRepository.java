package com.mudra.map.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mudra.map.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	
	@Query(value = "SELECT * FROM user_info WHERE mobile_no = :mobile_no", nativeQuery = true)
	Optional<UserInfo> findUserInfoByMobileNum(@Param("mobile_no") String mobile_no);
}
