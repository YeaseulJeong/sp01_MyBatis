package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

/*
 * 데이터를 가공 혹은 조작하는 레이어
 * 예) 페이징 처리
 */
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	// void removeUser(String userId) throws Exception;  데이터를 조작해야 하는데 지우는 건 정말 필요 없다 
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
