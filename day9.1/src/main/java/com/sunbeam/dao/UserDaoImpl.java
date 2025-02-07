package com.sunbeam.dao;

import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User user) {
		// user - TRANSIENT
		String mesg = "user registration failed!!!!";
		// 1. get Session from SessionFactory
		/*
		 * API of SessionFactory public Session openSession() throws HibernateException
		 * OR public Session getCurrentSession() throws HibernateException SF (session
		 * factory) will check for the existing session If absent , creates n rets it to
		 * the caller. o.w(otherwise) rets the existing session to the caller. Such a
		 * session is auto closed upon tx boundary(commit | rollback)
		 */
		Session session = getFactory().getCurrentSession();
		// 2. Begin a transaction
		/*
		 * Session API org.hibernate.Transacation beginTransaction() throws HibExc.
		 */
		Transaction tx = session.beginTransaction();
		try {
			// CRUD operation
			/*
			 * Session API public Serializable save(Object o) throws HibernateException
			 * 
			 */
			Serializable userId = session.save(user);
			// user - PERSISTENT - part of L1 cache
			// => success
			tx.commit();// insert query --persistent entity gains DB id upon commit
			// session.close() -> L1 cache is destroyed n db cn rets to the DBCP
			mesg = "user registered successfully , with ID" + userId;
		} catch (RuntimeException e) {
			// rollback tx
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}
		// user - DETACHED (from L1 cache)
		return mesg;
	}

	@Override
	public User getUserDetailsById(Long userId) {
		User user = null;
		// 1. Get session from Session Factory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			/*
			 * Session API for getting entity details by it's id public <T> T get(Class<T>
			 * entityClass, Serializable id) throws HibernateException T - type of the
			 * entity Rets - in case of valid id - persistent entity ref o.w - null
			 */
			user = session.get(User.class, userId);// select
			user = session.get(User.class, userId);
			user = session.get(User.class, userId);
			user = session.get(User.class, userId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw same exc to the caller
			throw e;
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		String jpql = "select u from User u";
		List<User> users = null;
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}
		return users;//list detached entities 
	}

	@Override
	public List<User> getUsersByDobAndRole(LocalDate begin, LocalDate end1, Role userRole) {
		String jpql = "select u from User u where u.dob between :start and :end and u.role=:rl";
		List<User> users = null;
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start", begin).setParameter("end", end1)
					.setParameter("rl", userRole).getResultList();
			// users - list of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return users;// users - list of DETACHED entities
	}

	@Override
	public List<String> getLastNamesByRole(Role userRole) {
		List<String> names = null;
		String jpql = "select u.lastName from User u where u.role=:role";
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return names;
	}

	@Override
	public List<User> testJPACtorExpression(Role userRole) {
		List<User> users = null;
		String jpql = "select new com.sunbeam.entities.User(firstName,lastName,dob) from User u where u.role=:rl";
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("rl", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return users;
	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
		String mesg = "changing password failed !!!!!!!!!";
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		User user = null;
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			user = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", oldPwd)
					.getSingleResult();
			// user - PERSISTENT
			user.setPassword(newPwd);// updating state of the persistent Entity
			// session.evict(user); user : DETACHED
			tx.commit();
			/*
			 * session.flush --> auto dirty chking -> DML - update -> session.close -> L1
			 * cache is destroyed , db cn rets to DBCP
			 */
			mesg = "updated password!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}
		user.setPassword("9999999");// updating state of the DETACHED Entity
		return mesg;
	}

	@Override
	public String applyDiscount(LocalDate date, double discount) {
		String mesg = "applying discount failed !!!!";
		String jpql = "update User u set u.regAmount=u.regAmount-:disc  where u.dob < :dt and u.role <> 'ADMIN'";
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			int rows = session.createQuery(jpql).setParameter("disc", discount).setParameter("dt", date)
					.executeUpdate();
			tx.commit();
			mesg = "Applied discount to users - " + rows;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String deleteUserDetails(Long userId) {
		String mesg = "deletion failed";
		// 1. get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// get user from it's id
			User user = session.get(User.class, userId);
			// chk if it exists
			if (user != null) {
				// user : persistent=> user rec exists!
				session.delete(user);// user - REMOVED (entity is simply marked for removal)
				mesg = "user details deleted...";
			}
			tx.commit();/*
						 * session.flush() -> dirty chking -> entity marked for removal -> DML : delete
						 * , session.close() -> L1 cache is destroyed 
						 * n cn rets to DBCP
						 *  user - TRANSIENT
						 */
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exc to the caller
			throw e;
		}

		return mesg;
	}//user  - marked for GC(i.e. user object -doesnt exit on heap

}
