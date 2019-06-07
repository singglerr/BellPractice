package ru.bellintegrator.singglerr.practice.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.singglerr.practice.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

	private final EntityManager em;

	@Autowired
	public UserDaoImpl(EntityManager em) {
		this.em = em;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> loadListBy(Long officeId, Integer citizenshipCode, Integer docCode, String firstName,
								 String secondName, String middleName, String position) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User loadById(Long id) {
		return em.find(User.class, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(User user) {
		em.persist(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Long id, User user) {
		User renewableUser = loadById(id);

	}
}
