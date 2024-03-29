package virtualAuction.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import virtualAuction.data.Bidamount;
import virtualAuction.data.Bidders;
import virtualAuction.data.ItemList;
import virtualAuction.data.ItemSold;
import virtualAuction.data.LeftItemList;

// Custom exception class for equal bids
class EqualBidsException extends RuntimeException {
    public EqualBidsException(String message) {
        super(message);
    }
}

public class main {

    public static void main(String[] args) {
        // Create Hibernate session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ItemList.class)
                .addAnnotatedClass(Bidders.class)
                .addAnnotatedClass(LeftItemList.class)
                .addAnnotatedClass(ItemSold.class)
                .addAnnotatedClass(Bidamount.class)
                .buildSessionFactory();

        // Get current session
        Session session = factory.getCurrentSession();

        try {
            // Begin transaction
            session.beginTransaction();

            Scanner scanner = new Scanner(System.in);

            List<Bidders> bidders = new ArrayList<>();
            List<Bidamount> bidsForItem1 = new ArrayList<>();

            // Creating new item
            ItemList item1 = new ItemList(1565, "Book of Vishanti", "Kolkata", 1000);
            session.save(item1);

            // Bidder input loop
            while (true) {
                System.out.print("Enter bidder Adhar (0 to stop): ");
                Integer bidderAdhar = scanner.nextInt();

                if (bidderAdhar == 0) {
                    break;
                }

                scanner.nextLine(); // consume newline character

                System.out.print("Enter bidder Name: ");
                String bidderName = scanner.nextLine();

                System.out.print("Enter bidder Age: ");
                Integer bidderAge = scanner.nextInt();

                // Create a new bidder
                Bidders bidder = new Bidders(bidderAdhar, bidderName, bidderAge);
                bidders.add(bidder);
                session.save(bidder);

                // Get bid amount for this bidder
                System.out.print("Enter bid amount for bidder " + bidderAdhar + ": ");
                int bidAmount = scanner.nextInt();

                // Create bid amount object and add it to the list
                Bidamount bidAmountObj = new Bidamount(bidAmount, bidder, item1);
                bidsForItem1.add(bidAmountObj); // Add bid to item's list
                session.save(bidAmountObj);
            }

            // Find highest bid
            int highestBid = 0;
            Bidders winningBidder = null;
            int bidCount = 0; // Keep track of bid count
            for (Bidamount bid : bidsForItem1) {
                bidCount++;
                if (bid.getBidder() != null && bid.getBidamount() > highestBid) {
                    highestBid = bid.getBidamount();
                    winningBidder = bid.getBidder();
                } else if (bid.getBidder() != null && bid.getBidamount() == highestBid) {
                    // Throw exception if two or more bids have the same amount
                    if (bidCount > 1) { // Ensure this is not the first equal bid
                        throw new EqualBidsException("Two or more bids have the same amount. Restart the bidding.");
                    }
                }
            }

            // Check if highest bid meets start price
            if (highestBid >= item1.getItemStartPrice()) {
                // Save the sold item
                ItemSold itemSold1 = new ItemSold(highestBid, item1, winningBidder);
                session.save(itemSold1);
                System.out.println("Item sold successfully!");
            } else {
                // Save the item in LeftItemList
                LeftItemList leftItem1 = new LeftItemList(item1); // Assuming LeftItemList constructor
                session.save(leftItem1);
                System.out.println("Item did not meet start price. Added to LeftItemList.");
            }

            // Commit transaction
            session.getTransaction().commit();
        } catch (EqualBidsException e) {
            // Handle the exception by restarting bidding or other actions
            System.out.println(e.getMessage());
        } finally {
            // Close session
            session.close();
            // Close factory
            factory.close();
        }
    }
}
