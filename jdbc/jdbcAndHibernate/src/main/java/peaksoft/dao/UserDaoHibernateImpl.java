package peaksoft.dao;


import org.hibernate.Session;
import peaksoft.entity.User;
import peaksoft.util.Util;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final Session session= Util.getSession().openSession();
    User user=new User();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
        session.beginTransaction();
        String sql = "DROP TABLE User";
        session.createNativeQuery(sql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session.beginTransaction();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.persist(user);//save
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        session.beginTransaction();
        User user=session.get(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSession().openSession();

        session.beginTransaction();
        List<User> student = session.createQuery(
                "select u from User u", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public void cleanUsersTable() {
        session.beginTransaction();
        session.createQuery("DELETE FROM User").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
