package ibatis.services.user.impl;

/*
 * persistence layer 컴포넌트이다
 * SqlSession을 Hasing 하는 클래스이다
 * 1) 필드에 선언
 * 2) setter로 주입 하면 이제 hasing이 마무리 된다
 */

// 원래는 이부분이 MyBatisTestApp~들 에서  SqlMapConfig 담아서 SqlFactory로 보내가지고 만들어서 session으로  실행했던 부분인데 이번에는 persistence layer로 보내서 
// MyBatisUserDAOImpl12 에서 session을 통해 받아서 sql로직 실행 _DAO 역할 
// _이때 session 을 통해 받을 수 있는 이유는 userservice12.xml에서 MyBatisUserDAOImpl 의 객체 즉 bean 을 만들 때 session 을 ref 해서 만들어 달라고 설정문서에 요청했기 때문에 가능
// 먼저 Test~ 에서 실행을 하는 경우에, SqlMapConfig 를 SqlFactory로 보내고 Factory에서 SqlSession 을 만들어서  여기서 sql 로직을 수행하는거 까지가  MyBatis Framework 다

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

public class MyBatisUserDAOImpl12 implements UserDAO{
	
	private final String NS ="UserMapper10.";
	//1.  필드에 선언
	private SqlSession sqlSession;   // field 명에 따라서 setter 이름이 만들어지니까 알기 쉽고 직관적으로 뭘 set 하는지 알려줘야 
	
	//2. setter로 주입 하면 이제 hasing이 마무리
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("::"+getClass().getName()+".setSqlSession() Call ...");
	}

	@Override
	public int addUser(User user) throws Exception {            // 이렇게 비즈니스 로직이 한줄로 이루어진다 
		int result = sqlSession.insert(NS+"addUser", user);
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update(NS+"updateUser", user);
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete(NS+"removeUser", userId);
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User result = sqlSession.selectOne(NS+"getUser", userId);
		return result;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> result = sqlSession.selectList(NS+"getUserList", user);
		return result;
	}
	
}
