package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.courier.entity.Parcel;
import com.courier.entity.Branch;
import com.courier.entity.DeliveryAgent;
import com.courier.entity.TrackingHistory;

import dao.ParcelDAO;
import dao.BranchDAO;
import dao.DeliveryAgentDAO;
import dao.TrackingHistoryDAO;

import util.HibernateUtil;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ParcelDAO parcelDAO = new ParcelDAO();
    private static final BranchDAO branchDAO = new BranchDAO();
    private static final DeliveryAgentDAO agentDAO =
            new DeliveryAgentDAO();
    private static final TrackingHistoryDAO trackingHistoryDAO =
            new TrackingHistoryDAO();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n===== COURIER TRACKING SYSTEM =====");
            System.out.println("1. Add New Parcel");
            System.out.println("2. View All Parcels");
            System.out.println("3. Track Parcel by ID");
            System.out.println("4. Update Parcel Status");
            System.out.println("5. Add Branch");
            System.out.println("6. View All Branches");
            System.out.println("7. Add Delivery Agent");
            System.out.println("8. View All Delivery Agents");
            System.out.println("9. View Tracking History");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInteger();

            switch (choice) {
                case 1:
                    addParcel();
                    break;

                case 2:
                    viewAllParcels();
                    break;

                case 3:
                    trackParcel();
                    break;

                case 4:
                    updateParcelStatus();
                    break;

                case 5:
                    addBranch();
                    break;

                case 6:
                    viewAllBranches();
                    break;

                case 7:
                    addDeliveryAgent();
                    break;

                case 8:
                    viewAllDeliveryAgents();
                    break;

                case 9:
                    viewTrackingHistory();
                    break;

                case 10:
                    running = false;
                    System.out.println("Thank you for using Courier Tracking System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
        HibernateUtil.shutdown();
    }

    // Read integer safely
    private static int readInteger() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    // Add a new parcel
    private static void addParcel() {

        System.out.println("\n===== ADD NEW PARCEL =====");

        System.out.print("Enter Sender Name: ");
        String senderName = scanner.nextLine();

        System.out.print("Enter Receiver Name: ");
        String receiverName = scanner.nextLine();

        System.out.print("Enter Sender Address: ");
        String senderAddress = scanner.nextLine();

        System.out.print("Enter Receiver Address: ");
        String receiverAddress = scanner.nextLine();

        System.out.print("Enter Receiver Phone: ");
        String receiverPhone = scanner.nextLine();

        String status = "Booked";
        LocalDate bookingDate = LocalDate.now();

        Parcel parcel = new Parcel(
                senderName,
                receiverName,
                senderAddress,
                receiverAddress,
                receiverPhone,
                status,
                bookingDate
        );

        parcelDAO.saveParcel(parcel);
    }

    // View all parcels
    private static void viewAllParcels() {

        System.out.println("\n===== ALL PARCELS =====");

        List<Parcel> parcels = parcelDAO.getAllParcels();

        if (parcels.isEmpty()) {
            System.out.println("No parcels found.");
            return;
        }

        for (Parcel parcel : parcels) {
            displayParcel(parcel);
        }
    }

    // Track parcel by ID
    private static void trackParcel() {

        System.out.print("Enter Parcel ID: ");
        int parcelId = readInteger();

        Parcel parcel = parcelDAO.getParcelById(parcelId);

        if (parcel == null) {
            System.out.println("Parcel not found!");
        } else {
            displayParcel(parcel);
        }
    }

    // Update parcel status
    private static void updateParcelStatus() {

        System.out.print("Enter Parcel ID: ");
        int parcelId = readInteger();

        Parcel parcel = parcelDAO.getParcelById(parcelId);

        if (parcel == null) {
            System.out.println("Parcel not found!");
            return;
        }

        System.out.println("\nSelect New Status:");
        System.out.println("1. Picked Up");
        System.out.println("2. In Transit");
        System.out.println("3. Out for Delivery");
        System.out.println("4. Delivered");
        System.out.print("Enter choice: ");

        int statusChoice = readInteger();
        String newStatus;

        switch (statusChoice) {
            case 1:
                newStatus = "Picked Up";
                break;

            case 2:
                newStatus = "In Transit";
                break;

            case 3:
                newStatus = "Out for Delivery";
                break;

            case 4:
                newStatus = "Delivered";
                break;

            default:
                System.out.println("Invalid status choice!");
                return;
        }

        parcelDAO.updateParcelStatus(parcelId, newStatus);
    }

    // Display parcel details
    private static void displayParcel(Parcel parcel) {

        System.out.println("\n----- PARCEL DETAILS -----");
        System.out.println("Parcel ID        : " + parcel.getParcelId());
        System.out.println("Sender Name      : " + parcel.getSenderName());
        System.out.println("Receiver Name    : " + parcel.getReceiverName());
        System.out.println("Sender Address   : " + parcel.getSenderAddress());
        System.out.println("Receiver Address : " + parcel.getReceiverAddress());
        System.out.println("Receiver Phone   : " + parcel.getReceiverPhone());
        System.out.println("Status           : " + parcel.getStatus());
        System.out.println("Booking Date     : " + parcel.getBookingDate());
        System.out.println("--------------------------");
    }

    // Add a branch
    private static void addBranch() {

        System.out.println("\n===== ADD BRANCH =====");

        System.out.print("Enter Branch Name: ");
        String branchName = scanner.nextLine();

        System.out.print("Enter Branch Location: ");
        String location = scanner.nextLine();

        System.out.print("Enter Branch Phone: ");
        String phone = scanner.nextLine();

        Branch branch = new Branch(branchName, location, phone);

        branchDAO.saveBranch(branch);
    }

    // View all branches
    private static void viewAllBranches() {

        System.out.println("\n===== ALL BRANCHES =====");

        List<Branch> branches = branchDAO.getAllBranches();

        if (branches.isEmpty()) {
            System.out.println("No branches found.");
            return;
        }

        for (Branch branch : branches) {
            System.out.println("\nBranch ID   : " + branch.getBranchId());
            System.out.println("Branch Name : " + branch.getBranchName());
            System.out.println("Location    : " + branch.getLocation());
            System.out.println("Phone       : " + branch.getPhone());
            System.out.println("--------------------------");
        }
    }

    // Add a delivery agent
    private static void addDeliveryAgent() {

        System.out.println("\n===== ADD DELIVERY AGENT =====");

        System.out.print("Enter Agent Name: ");
        String agentName = scanner.nextLine();

        System.out.print("Enter Agent Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Agent Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = scanner.nextLine();

        String availability = "Available";

        DeliveryAgent agent = new DeliveryAgent(
                agentName,
                phone,
                email,
                vehicleNumber,
                availability
        );

        agentDAO.saveAgent(agent);
    }

    // View all delivery agents
    private static void viewAllDeliveryAgents() {

        System.out.println("\n===== ALL DELIVERY AGENTS =====");

        List<DeliveryAgent> agents = agentDAO.getAllAgents();

        if (agents.isEmpty()) {
            System.out.println("No delivery agents found.");
            return;
        }

        for (DeliveryAgent agent : agents) {
            System.out.println("\nAgent ID       : " + agent.getAgentId());
            System.out.println("Agent Name     : " + agent.getAgentName());
            System.out.println("Phone          : " + agent.getPhone());
            System.out.println("Email          : " + agent.getEmail());
            System.out.println("Vehicle Number : " + agent.getVehicleNumber());
            System.out.println("Availability   : " + agent.getAvailability());
            System.out.println("--------------------------");
        }
    }

    // View tracking history for a parcel
    private static void viewTrackingHistory() {

        System.out.print("Enter Parcel ID: ");
        int parcelId = readInteger();

        // Check whether the parcel exists
        Parcel parcel = parcelDAO.getParcelById(parcelId);

        if (parcel == null) {
            System.out.println("Parcel not found!");
            return;
        }

        List<TrackingHistory> historyList =
                trackingHistoryDAO.getHistoryByParcelId(parcelId);

        System.out.println("\n===== TRACKING HISTORY =====");
        System.out.println("Parcel ID: " + parcelId);

        if (historyList.isEmpty()) {
            System.out.println("No tracking history found for this parcel.");
            return;
        }

        for (TrackingHistory history : historyList) {
            System.out.println("\nTracking ID : " + history.getTrackingId());
            System.out.println("Status      : " + history.getStatus());
            System.out.println("Location    : " + history.getLocation());
            System.out.println("Updated Time: " + history.getUpdateTime());
            System.out.println("Remarks     : " + history.getRemarks());
            System.out.println("----------------------------");
        }
    }
}