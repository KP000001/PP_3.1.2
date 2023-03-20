package web.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.createQuery("select us from User us", User.class).getResultList();
        }
    }

    @Override
    public User findById(int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.get(User.class, id);
        }
    }

    @Override
    public void saveUser(User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.persist(user);
        }
    }

    @Override
    public void update(int id, User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            User u = session.get(User.class, id);
            u.setName(user.getName());
            u.setLastName(user.getLastName());
            u.setAge(user.getAge());
        }
    }

    @Override
    public void deleteUser(int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.remove(session.get(User.class, id));
        }
    }
}
