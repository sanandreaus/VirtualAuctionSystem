package virtualAuction.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne; // Assuming a OneToOne relationship with ItemList

@Entity
public class LeftItemList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming auto-generated ID
    private Integer leftItemId; // Unique identifier for the left item

    @OneToOne
    @JoinColumn(name = "itemNumber")
    private ItemList item; // Reference to the ItemList object

    // Constructor with parameter
    public LeftItemList(ItemList item) {
        this.item = item;
    }

    // Getter for leftItemId
    public Integer getLeftItemId() {
        return leftItemId;
    }

    // Setter for leftItemId
    public void setLeftItemId(Integer leftItemId) {
        this.leftItemId = leftItemId;
    }

    // Getter for item
    public ItemList getItem() {
        return item;
    }

    // Setter for item
    public void setItem(ItemList item) {
        this.item = item;
    }
}
