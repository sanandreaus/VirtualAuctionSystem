package virtualAuction.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bidamount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receiptNumber; // Unique identifier for the bid
    private int bidamount;     // Amount of the bid

    @ManyToOne // ManyToOne relationship with Bidders
    @JoinColumn(name = "bidderAdhar") // Foreign key column
    private Bidders bidder; // Reference to the Bidders object (renamed from bidderAdhar)

    @ManyToOne
    @JoinColumn(name = "itemNumber")
    private ItemList itemNumber; // Reference to the ItemList object

    // Default constructor
    public Bidamount() {
        // default constructor
    }

    // Parameterized constructor
    public Bidamount(int bidamount, Bidders bidder, ItemList itemNumber) {
        this.bidamount = bidamount;
        this.bidder = bidder;
    }

    // Getter and setter methods for all fields

    // Getter for bidamount
    public int getBidamount() {
        return bidamount;
    }

    // Setter for bidamount
    public void setBidamount(int bidamount) {
        this.bidamount = bidamount;
    }

    // Getter for bidder
    public Bidders getBidder() {
        return bidder;
    }

    // Setter for bidder
    public void setBidder(Bidders bidder) {
        this.bidder = bidder;
    }

    // Getter for itemNumber
    public ItemList getItemNumber() {
        return itemNumber;
    }

    // Setter for itemNumber
    public void setItem(ItemList itemNumber) {
        this.itemNumber = itemNumber;
    }
}
