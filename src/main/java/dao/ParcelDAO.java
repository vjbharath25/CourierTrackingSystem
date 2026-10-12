package dao;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.courier.entity.Parcel;
import com.courier.entity.TrackingHistory;

import util.HibernateUtil;

public class ParcelDAO {

    // 1. Save a new parcel and its initial tracking history
    public void saveParcel(Parcel parcel) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            // Save parcel
            session.persist(parcel);

            // Generate parcel ID
            session.flush();

            // Create initial tracking history
            TrackingHistory history = new TrackingHistory(
                    parcel.getParcelId(),
                    "Booked",
                    parcel.getSenderAddress(),
                    LocalDateTime.now(),
                    "Parcel booked successfully"
            );

            // Save tracking history
            session.persist(history);

            // Commit both records together
            transaction.commit();

            System.out.println("Parcel saved successfully!");
            System.out.println(
                    "Initial tracking history saved successfully!");
            System.out.println(
                    "Parcel ID: " + parcel.getParcelId());

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println(
                    "Error saving parcel: " + e.getMessage());
        }
    }

    // 2. Get all parcels
    public List<Parcel> getAllParcels() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Parcel ORDER BY parcelId",
                    Parcel.class
            ).getResultList();

        } catch (Exception e) {

            System.out.println(
                    "Error retrieving parcels: " + e.getMessage());

            return Collections.emptyList();
        }
    }

    // 3. Search parcel by ID
    public Parcel getParcelById(int parcelId) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Parcel.class, parcelId);

        } catch (Exception e) {

            System.out.println(
                    "Error finding parcel: " + e.getMessage());

            return null;
        }
    }

    // 4. Update parcel status and save tracking history
    public void updateParcelStatus(
            int parcelId, String newStatus) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Parcel parcel =
                    session.get(Parcel.class, parcelId);

            if (parcel == null) {
                transaction.rollback();
                System.out.println("Parcel not found!");
                return;
            }

            // Update parcel status
            parcel.setStatus(newStatus);

            // Save status update in tracking history
            TrackingHistory history = new TrackingHistory(
                    parcelId,
                    newStatus,
                    parcel.getReceiverAddress(),
                    LocalDateTime.now(),
                    "Parcel status updated to " + newStatus
            );

            session.persist(history);

            // Commit parcel update and history together
            transaction.commit();

            System.out.println(
                    "Parcel status updated successfully!");
            System.out.println(
                    "Tracking history saved successfully!");

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println(
                    "Error updating parcel status: "
                    + e.getMessage());
        }
    }
}