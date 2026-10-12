package dao;

import com.courier.entity.TrackingHistory;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Collections;

public class TrackingHistoryDAO {

    // Save tracking history
    public void saveTrackingHistory(
            int parcelId,
            String status,
            String location,
            String remarks) {

        Transaction transaction = null;

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            TrackingHistory history = new TrackingHistory(
                parcelId,
                status,
                location,
                LocalDateTime.now(),
                remarks
            );

            session.persist(history);
            transaction.commit();

            System.out.println("Tracking history saved successfully!");

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println(
                "Error saving tracking history: " + e.getMessage()
            );
        }
    }

    // Get history for a particular parcel
    public List<TrackingHistory> getHistoryByParcelId(int parcelId) {

        try (Session session =
                 HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                "FROM TrackingHistory WHERE parcelId = :parcelId " +
                "ORDER BY updateTime ASC",
                TrackingHistory.class
            )
            .setParameter("parcelId", parcelId)
            .getResultList();

        } catch (Exception e) {

            System.out.println(
                "Error retrieving tracking history: " + e.getMessage()
            );

            return Collections.emptyList();
        }
    }
}
