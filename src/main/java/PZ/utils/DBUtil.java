package PZ.utils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
public class DBUtil {
    public static void init() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.getTransaction().commit();
    }
    public static void insert(Object o) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
    }
    public static void delete(Object o) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
    }
    public static void update(Object o) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
    }
    public static <T> List<T> selectAll(String tableName) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<T> list = session.createQuery("from " + tableName).list();
        session.getTransaction().commit();
        return list;
    }

    public static <T> List<T> selectAllWhere(String className, String colName, String param) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query<T> q = session.createQuery("FROM " + className + " WHERE " + colName + " = :param");
        q.setParameter("param", param);
        List<T> list = q.list();
        session.getTransaction().commit();
        return list;
    }
}
