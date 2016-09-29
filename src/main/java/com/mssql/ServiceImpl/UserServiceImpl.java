package com.mssql.ServiceImpl;

 
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mssql.Dao.UserDao;
import com.mssql.Objects.User;
import com.mssql.Service.UserService;
@Service
//@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userdao;

	@Override
	public User add(User  user) {
		System.out.println("USer Service Impl is Calling <><><><<><><"+user);
 		return userdao.add(user);
	}

	@Override
	public String sample() {
		return userdao.sample();	
		}

	@Override
	public User get(int id) {
		return userdao.get(id);	

	}

}
