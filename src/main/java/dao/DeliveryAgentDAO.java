package dao;

import com.courier.entity.DeliveryAgent;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Collections;

public class DeliveryAgentDAO {

    // Save a new delivery agent
    public void saveAgent(DeliveryAgent agent) {

        Transaction transaction = null;

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(agent);

            transaction.commit();

            System.out.println("Delivery agent saved successfully!");

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println(
                "Error saving delivery agent: " + e.getMessage()
            );
        }
    }

    // Get all delivery agents
    public List<DeliveryAgent> getAllAgents() {

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                "FROM DeliveryAgent", DeliveryAgent.class
            ).getResultList();

        } catch (Exception e) {

            System.out.println(
                "Error retrieving agents: " + e.getMessage()
            );

            return Collections.emptyList();
        }
    }

    // Find an agent using agent ID
    public DeliveryAgent getAgentById(int agentId) {

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            return session.get(DeliveryAgent.class, agentId);

        } catch (Exception e) {

            System.out.println(
                "Error finding agent: " + e.getMessage()
            );

            return null;
        }
    }
}
