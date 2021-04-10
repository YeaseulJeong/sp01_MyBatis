package ibatis.services.user.impl;

/*
 * Annotation 사용
 * xml 에서 빈 설정을 하지 않고 소스 코드에다 바로 marking 하는 기법
 * marking 함으로써 Component 임을 입증 시키면 된다
 * 
 * @Component
 * layer 별로 @Component를 세분화 시켜서 marking 한다
 * 
 * @Repository -- Persistence Layer Bean
 * @Service -- Service Layer Bean
 * @Controller -- Presentation Layer Bean 
 */

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{
	
	private final String NS ="UserMapper10.";
	
	@Autowired   // 를 하면 아래의 setSqlSession 없애줄 수 있다    &   xml설정문서에서 bean 을 없앨 수 있다
	//1.  필드에 선언
	private SqlSession sqlSession;   // field 명에 따라서 setter 이름이 만들어지니까 알기 쉽고 직관적으로 뭘 set 하는지 알려줘야 
	
	/*
	 * //2. setter로 주입 하면 이제 hasing이 마무리 public void setSqlSession(SqlSession
	 * sqlSession) { this.sqlSession = sqlSession;
	 * System.out.println("::"+getClass().getName()+".setSqlSession() Call ..."); }
	 */

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
