package com.sign.in.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sign.in.entity.User;
@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long>{

String USER_DETAILS ="SELECT user.userId from User user WHERE user.emailId = ?1 and user.password =?2";

@Query(USER_DETAILS)
public int findUserDetails(String emailid,String password);

String GET_ALL_EMAIL_ID ="SELECT user.emailId from User user";

@Query(GET_ALL_EMAIL_ID)
public List<String> getEmailidList();

String EMAIL_ID_EXISTS="SELECT user.password from User user WHERE user.emailId=?";

@Query(EMAIL_ID_EXISTS)
public String getEmailId(String emailId);

}
