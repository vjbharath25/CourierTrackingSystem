package dao;

import com.courier.entity.Branch;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Collections;

public class BranchDAO {

    // Save a new branch
    public void saveBranch(Branch branch) {

        Transaction transaction = null;

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(branch);

            transaction.commit();

            System.out.println("Branch saved successfully!");

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println(
                "Error saving branch: " + e.getMessage()
            );
        }
    }

    // Get all branches
    public List<Branch> getAllBranches() {

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                "FROM Branch", Branch.class
            ).getResultList();

        } catch (Exception e) {

            System.out.println(
                "Error retrieving branches: " + e.getMessage()
            );

            return Collections.emptyList();
        }
    }

    // Get a branch using its ID
    public Branch getBranchById(int branchId) {

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Branch.class, branchId);

        } catch (Exception e) {

            System.out.println(
                "Error finding branch: " + e.getMessage()
            );

            return null;
        }
    }
}
