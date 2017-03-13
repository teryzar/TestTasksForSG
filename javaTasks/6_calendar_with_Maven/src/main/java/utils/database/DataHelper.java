package utils.database;

/**
 * Class that provides all database magic. Every query is being generated here 
 */

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.*;
import entity.*;

public class DataHelper {

    private SessionFactory sessionFactory = null;
    private static DataHelper dataHelper;

    private DataHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static DataHelper getInstance() {
        return dataHelper == null ? new DataHelper() : dataHelper;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    public int addUser(User userToAdd) {
        int status;
        try {
            Session session = getSession();
            Transaction tx = session.beginTransaction();
            session.save(userToAdd);
            tx.commit();
            status = 200;
        } catch (ConstraintViolationException e) {
            //тут сформируем правильній ответ, если такой логин уже есть
            System.out.println(e.getSQLException());
            status = 409;

        }
        return status;
    }

    public User getUser(String username) {
        return (User) getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
    }

    public List<Integer> getIssuesIds() {
        return getSession().createSQLQuery("select id from issue").list();
    }

    public Issue getIssueById(int id) {
        return (Issue) getSession().createCriteria(Issue.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public void addIssue(Issue issue) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(issue);
        tx.commit();
    }

    //получаем все комментарии, связанніе с конкретной Issue
    public List<Integer> getCommentIDs(int id) {
        return getSession().createSQLQuery("SELECT `comment`.id FROM `comment`INNER JOIN ticket ON "
                + "`comment`.ticket_id = ticket.id  INNER JOIN issue ON ticket.issue_id = issue.id "
                + "WHERE issue.id =" + id).list();
    }

    public List<Integer> getTicketIds() {
        return getSession().createSQLQuery("select id from ticket").list();
    }

    public Issue getTicketById(int id) {
        return (Issue) getSession().createCriteria(Ticket.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    public void addTicket(Ticket ticket) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(ticket);
        tx.commit();
    }

    public Comment getCommentById(int id) {
        return (Comment) getSession().createSQLQuery("SELECT * FROM comment WHRE id = " + id).uniqueResult();
    }

}
