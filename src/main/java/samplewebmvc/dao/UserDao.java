package samplewebmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import samplewebmvc.entity.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	// CREATE
	public void saveUser(User user) {

		Session session = sessionFactory.getCurrentSession();

		session.persist(user);

		System.out.println("UserDao.saveUser()");
	}

	// READ
	public User getUser(int id) {

		Session session = sessionFactory.getCurrentSession();

		return session.find(User.class, id);
	}

	// UPDATE
	public void updateUser(User user) {

		Session session = sessionFactory.getCurrentSession();

		session.merge(user);
	}

	// DELETE
	public void deleteUser(int id) {

		Session session = sessionFactory.getCurrentSession();

		User user = session.find(User.class, id);

		if (user != null) {
			session.remove(user);
		}
	}
}