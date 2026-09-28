package samplewebmvc.dao;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import samplewebmvc.entity.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	public void saveUser(User user) {
		em.persist(user);
		System.out.println("UserDao.saveUser()");
	}
}