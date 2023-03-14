package web.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(@Qualifier("entityManagerFactory") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.createQuery("select us from User us", User.class).getResultList();
        }
    }

    @Override
    @Transactional
    public User findById(int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.get(User.class, id);
        }
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.persist(user);
        }
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            User u = session.get(User.class, id);
            u.setName(user.getName());
            u.setAge(user.getAge());
            u.setLastName(user.getLastName());
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.remove(session.get(User.class, id));
        }
    }
}
