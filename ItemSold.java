package virtualAuction.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemSold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int soldItemNumber; // Unique identifier for the sold item
    private int soldPrice;      // Price at which the item was sold

    @ManyToOne
    @JoinColumn(name = "itemNumber")
    private ItemList itemNumber; // Reference to the sold item

    @ManyToOne
    @JoinColumn(name = "bidderAdhar")
    private Bidders bidderAdhar; // Reference to the bidder who bought the item

    // Parameterized constructor
    public ItemSold(int soldPrice, ItemList itemNumber, Bidders bidderAdhar) {
        this.soldPrice = soldPrice;
        this.itemNumber = itemNumber;
        this.bidderAdhar = bidderAdhar;
    }

    // Getter and setter methods for all fields

    public int getSoldItemNumber() {
        return soldItemNumber;
    }

    public void setSoldItemNumber(int soldItemNumber) {
        this.soldItemNumber = soldItemNumber;
    }

    public int getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(int soldPrice) {
        this.soldPrice = soldPrice;
    }

    public ItemList getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(ItemList itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Bidders getBidderAdhar() {
        return bidderAdhar;
    }

    public void setBidderAdhar(Bidders bidderAdhar) {
        this.bidderAdhar = bidderAdhar;
    }
}
