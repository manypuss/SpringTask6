package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u ", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
