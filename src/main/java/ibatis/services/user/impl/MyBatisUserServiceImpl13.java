package ibatis.services.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;
import ibatis.services.user.UserService;

@Service
public class MyBatisUserServiceImpl13 implements UserService{
	
	@Autowired    // 를 하면 아래의 setSqlSession 없애줄 수 있다    &   xml설정문서에서 bean 을 없앨 수 있다
	// 1. 필드 선언
	UserDAO userDAO;
	
	/*
	 * //2. setter 까지 가야 주입 완성 public void setUserDAO(UserDAO userDAO) { this.userDAO
	 * = userDAO;
	 * System.out.println("::"+getClass().getName()+".setUserDAO() Call ..."); }
	 */
	

	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
		
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
		
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userDAO.getUser(userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return userDAO.getUserList(user);
	}

}
